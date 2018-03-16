/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.service.impl;<br/>  
 * <b>文件名：</b>SurvivalServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月12日下午4:27:07<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.statistics.bean.FollowupSurvivalRateFinalReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupSurvivalRatePreReq;
import com.esuizhen.cloudservice.statistics.bean.TSurvivalRateInfo;
import com.esuizhen.cloudservice.statistics.bean.TSurvivalRateItem;
import com.esuizhen.cloudservice.statistics.bean.TSurvivalRateStaticInfo;
import com.esuizhen.cloudservice.statistics.constant.Constant;
import com.esuizhen.cloudservice.statistics.dao.SurvivalDao;
import com.esuizhen.cloudservice.statistics.service.SurvivalService;
import com.esuizhen.cloudservice.statistics.util.ExcelFileWriteUtil;
import com.westangel.common.bean.search.ConfGlobal;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.bean.user.RConfDataPrivilege;
import com.westangel.common.bean.user.TRDoctor;
import com.westangel.common.dao.search.ConfGlobalDao;
import com.westangel.common.dao.search.SearchDao;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.AuthorizationService;
import com.westangel.common.service.DoctorService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.search.RetrievalParamentUtil;

/** 
* @ClassName: SurvivalServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年8月12日 下午4:27:07  
*/
@Service
@Transactional
public class SurvivalServiceImpl implements SurvivalService {
	
	@Autowired
	private SearchDao searchDao;
	
	@Autowired
	private SurvivalDao survivalDao;
	
	private String[] months = {"3","6","9","12","24","36","48","60"};
	
	private HttpSession session;
	
	private Map<String,Object> survivals;
	@Autowired
	private ConfGlobalDao confGlobalDao;
	
	@Autowired
	private MessageSource messageSource;
	
	/** 院际医生工作站  add by yuan_wm 20170217 start */
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private DoctorService doctorService;
	/** 院际医生工作站  add by yuan_wm 20170217 end */
	
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	
	@Override
	@Transactional
	public void initSurvivalRate(FollowupSurvivalRatePreReq req){
		if(req.getOperator()==null)
			throw new EmptyParamExcption(" param operator is null");
		if(req.getStaticType()==null)
			throw new EmptyParamExcption(" param staticType is null");
		if(req.getStaticType()==4&&req.getParaments()==null)
			throw new EmptyParamExcption(" param paraments is null");
		//创建查询
		SearchInfo search = new SearchInfo(Thread.currentThread().getStackTrace()[1].getMethodName(), JsonUtil.toJson(req), req.getOperator(),req.getStaticType()==4?null:searchDao.queryVarFollowupPatientTableName());
		//肿瘤有效性判断
		ConfGlobal conf = confGlobalDao.queryConfGlobal();
		if(conf!=null){
			req.followupRangeFlag=conf.getFollowupRangeFlag();
			req.sourceTumorFlags=conf.getNotMalignantTumorFlag();
		}
		//如果是高级检索 生成检索条件
		if(req.getStaticType()==4&&req.getParaments()!=null){
			req.sql = RetrievalParamentUtil.loadingParaments(req.getParaments());
			Integer searchId = searchDao.createSearchInfo(search);
			search = searchDao.querySearchById(searchId);
		}else{
			searchDao.insert(search);
		}
		req.searchId = search.getSearchId();
		req.searchTableName = search.getSearchTableName();
		req.searchColumn = search.getSearchColumn();
		boolean flag = false;//默认是B端
		RConfDataPrivilege rConfDataPrivilege = authorizationService.findDataPrivilegeByDoctor(req.getOperator());
		boolean isFollowupRole = organizationDoctorService.queryDoctorRoleById(req.getOperator(), null);
		if(isFollowupRole){
			String sql = organizationDoctorService.getPatientSql(req.getOperator(), null);
			req.setPrivilegeSql(sql);
		}
		if(rConfDataPrivilege != null && rConfDataPrivilege.getDataId() != null) {
			req.setDataId(rConfDataPrivilege.getDataId());
			req.setOutPatientFlag(null);
		}else {
			if(conf != null) {
				if(conf.getDeployLocation() != null && conf.getDeployLocation() == 2) {
					req.setDeployLocation(conf.getDeployLocation());
					flag = true;
				}
			}
		}
		if(flag) {
			TRDoctor doctor = doctorService.getTRDoctorByDoctorId(req.getOperator());
			if(doctor!=null){
				req.setDoctorLevel(doctor.getDoctorLevel());
			}
			req.setOutPatientFlag(null);
		}
		int totalNum = 0;
		if(req.getStaticType()==4)
			totalNum = survivalDao.updateSearchPatientStaticPatient(req);
		else
			totalNum = survivalDao.insertSearchPatientStaticPatient(req);
		if(totalNum==0)
			throw new EmptyObjectExcption("survaival list is null");
		search.setTotalNum(totalNum);
		searchDao.update(search);
	}
	//统计全部生存率
	private void countAllSurvivalRate(List<TSurvivalRateInfo> list){
		if(list.size()==1)
			return;
		TSurvivalRateInfo all = new TSurvivalRateInfo();
		all.setTypeName("全部");
		all.setTypeId("0");
		all.setTotalNum(0);
		all.setFollowupNum(0);
		all.setValidNum(0);
		all.setUnvalidNum(0);
		all.setDeathNum(0);
		all.setBeginLostFollowupNum(0);
		for(TSurvivalRateInfo info : list){
			all.setTotalNum(all.getTotalNum()+info.getTotalNum());
			all.setBeginLostFollowupNum(all.getBeginLostFollowupNum()+info.getBeginLostFollowupNum());
			all.setFollowupNum(all.getFollowupNum()+info.getFollowupNum());
			all.setDeathNum(all.getDeathNum()+info.getDeathNum());
			all.setUnvalidNum(all.getUnvalidNum()+info.getUnvalidNum());
			all.setValidNum(all.getValidNum()+info.getValidNum());
		}
		all.setFollowupRate(rateFormat(all.getFollowupNum(), all.getTotalNum()));
		all.setDeathRate(rateFormat(all.getDeathNum(), all.getFollowupNum()));
		all.setValidRate(rateFormat(all.getValidNum(), all.getFollowupNum()));
		all.setUnvalidRate(rateFormat(all.getUnvalidNum(), all.getFollowupNum()));
		list.add(0,all);
	}
	private String rateFormat(Integer m,Integer d){
		if(m==0){
			return "0.00%";
		}
		float f = (float)m*100/d;
		if(f==0f){
			return "0.00%";
		}
		BigDecimal b = new BigDecimal(f);
		float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(Float.parseFloat(f1+""))+"%";
	}
	@Override
	public Object preFollowupSurvivalRate(final FollowupSurvivalRatePreReq req) {
		// TODO Auto-generated method stub
//		boolean isFollowupRole = organizationDoctorService.queryDoctorRoleById(req.getOperator(), null);
//		if(isFollowupRole){
//			String sql = organizationDoctorService.getPatientSql(req.getOperator(), null);
//			req.setPrivilegeSql(sql);
//		}
		req.setPrivilegeSql(null);
		session = req.session;
		List<TSurvivalRateInfo> list = survivalDao.queryFollowupSurvival(req);
		if(list==null||list.size()==0)
			throw new EmptyObjectExcption("survaival list is null");
		if(req.getStaticType()!=4&&list.size()>1){
			//外部统计全局
			//countAllSurvivalRate(list);
			TSurvivalRateInfo countSurvival = survivalDao.queryFollowupSurvivalCount(req);
			if(countSurvival!=null){
				list.add(0,countSurvival);
			}
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("searchId", req.getSearchId());
		result.put("data", list);
		session.setAttribute("Export"+req.getSearchId(), list);
		final Integer listSize = list.size();
		survivals = new HashMap<String, Object>();
		//开启线程处理
		ExecutorService exec = Executors.newFixedThreadPool(3);
		int i = 0;
		for(final TSurvivalRateInfo survival : list){
			final int item = i;
			Runnable run = new Runnable(){
				@Override
				public void run()
				{
					LogUtil.log.debug("exe ------- searchId="+req.getSearchId()+"   index = "+item);
					FollowupSurvivalRateFinalReq param = new FollowupSurvivalRateFinalReq();
					param.setSearchId(req.getSearchId());
					param.setConditionId(Integer.parseInt(survival.getTypeId()));
					param.setSearchTableName(req.getSearchTableName());
					param.setSearchColumn(req.getSearchColumn());
					param.setStaticType(req.getStaticType());
					param.setTreatmentTypeStatisticsResult(req.getTreatmentTypeStatisticsResult());
					param.setDoctorId(req.getOperator());
					survivals.put(item+"", finalFollowupSurvival(param));
					LogUtil.log.debug("exe ------- searchId="+req.getSearchId()+"   index = "+item +"  listSize = "+listSize +"  survivals ="+survivals.keySet().size());
					if(listSize==survivals.keySet().size()){
						LogUtil.log.debug("exe over------- searchId="+req.getSearchTableName()+"   index = "+item +"  ");
						List<Object> list= new ArrayList<Object>();
						for(int index=0;index<listSize;index++){
							list.add(survivals.get(index+""));
						}
						session.setAttribute(req.getSearchId()+"", list);
						Constant.survivalMap.put(req.getSearchId()+"", session);
					}
				}
			};
			exec.execute(run);
			i++;
		}
		exec.shutdown();
		return result;
	}
	
	//生存率生成
	@Override
	public Object finalFollowupSurvival(FollowupSurvivalRateFinalReq req){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("searchId", req.getSearchId());
		param.put("conditionId", req.getConditionId());
		param.put("searchColumn", req.getSearchColumn());
		param.put("searchTableName", req.getSearchTableName());
		param.put("staticType", req.getStaticType());
		param.put("treatmentTypeStatisticsResult", req.getTreatmentTypeStatisticsResult());
//		boolean isFollowupRole = organizationDoctorService.queryDoctorRoleById(req.getDoctorId(), null);
//		if(isFollowupRole){
//			String sql = organizationDoctorService.getPatientSql(req.getDoctorId(), null);
//			param.put("sql", sql);
//		}
		param.put("sql", null);
		LinkedHashMap<String, Object> map = survivalDao.querySurvivalRate(param);
		TSurvivalRateStaticInfo rate = new TSurvivalRateStaticInfo();
		rate.setMiddleMonth((String)map.get("middlelive"));
		rate.setSurvivalRates(new ArrayList<TSurvivalRateItem>());
		List<TSurvivalRateItem> list = rate.getSurvivalRates();
		for(String month : months){
			list.add(new TSurvivalRateItem(month, (String)map.get(month+"live")));
		}
		return rate;
	}
	
	@Override
	public List<Object> initExportData(Object obj, Object obj2, Object compareObj, Object compareObj2, Integer type) {
		// TODO Auto-generated method
		// stub
		List<TSurvivalRateInfo> listAll = new ArrayList<TSurvivalRateInfo>();
		List<TSurvivalRateStaticInfo> listAll2 = new ArrayList<TSurvivalRateStaticInfo>();
		if (obj == null && compareObj == null)
			throw new EmptyParamExcption(" data is null");
		List<Object> files = new ArrayList<Object>();
		files.add(new ArrayList<Object>());
		List<Object> sheet = (List<Object>) files.get(0);
		// 统计结果
		List<TSurvivalRateInfo> list = (List<TSurvivalRateInfo>) obj;
		if (list != null && list.size() > 0) {
			listAll.addAll(list);
		}
		if (compareObj != null) {
			List<TSurvivalRateInfo> compareList = (List<TSurvivalRateInfo>) compareObj;
			listAll.addAll(compareList);
		}
		// 生存率结果
		List<TSurvivalRateStaticInfo> list2 = (List<TSurvivalRateStaticInfo>) obj2;
		if (list2 != null && list2.size() > 0) {
			listAll2.addAll(list2);
		}
		if (compareObj2 != null) {
			List<TSurvivalRateStaticInfo> compareList2 = (List<TSurvivalRateStaticInfo>) compareObj2;
			if (compareList2 != null && compareList2.size() > 0) {
				listAll2.addAll(compareList2);
			}
		}
		for (int index = 0; index < listAll.size(); index++) {
			String[] row = new String[18];
			int col = 0;
			TSurvivalRateInfo info = listAll.get(index);
			TSurvivalRateStaticInfo rate = listAll2.get(index);
			if (type != 4)
				row[col++] = info.getTypeName();
			row[col++] = info.getTotalNum() + "";
			row[col++] = info.getBeginLostFollowupNum() + "";
			row[col++] = info.getBeginFollowupDeathNum() + "";
			row[col++] = info.getFollowupNum() + "";
			row[col++] = info.getFollowupRate();
			row[col++] = info.getValidNum() + "";
			row[col++] = info.getValidRate();
			row[col++] = info.getDeathNum() + "";
			row[col++] = info.getDeathRate();
			for (TSurvivalRateItem item : rate.getSurvivalRates())
				row[col++] = item.getSurvivalRate();
			// row[col++]=rate.getMiddleMonth();
			sheet.add(row);
		}
		return files;
	}
	@Override
	public List<Object> initExportPatientData(Object obj,final Integer searchId,final Integer staticType,final Integer reqFlag,final Integer staticResultType, Integer doctorId) {
		// TODO Auto-generated method stub
		if(obj==null)
			throw new EmptyParamExcption(" source data is null");
		String exportTemplateId = "EXPTPSTATICS";
		final LinkedHashMap<String, Object> templateMap = survivalDao.queryExportTemplate(exportTemplateId);
		if(templateMap==null)
			throw new EmptyParamExcption(" template is null");
		final String[] heads = ((String)templateMap.get("heads")).split(",");
		final String[] fileds = ((String)templateMap.get("fields")).split(",");
		//创建数据集
		List<Object> bookData = new ArrayList<Object>();
		final String sqlcontent = (String)templateMap.get("sqlContent");
		final String tableName = searchDao.queryTableNameBySearchId(searchId);
		List objs = (List<TSurvivalRateInfo>)obj;
		final Object[] objData = new Object[objs.size()];
		ExecutorService exec = Executors.newFixedThreadPool(5);
		final CountDownLatch doneSignal = new CountDownLatch(objs.size());
		final Map<String,Object> dataMap1= new HashMap<String, Object>();
		// 循环所有条件选项
		for(Object objinfo : objs){
			final TSurvivalRateInfo info = (TSurvivalRateInfo)objinfo;
			if(info.getTypeId().equals(0)){
				doneSignal.countDown();
				LogUtil.log.debug("doneSignal count ===="+doneSignal.getCount());
				continue;
			}
			Runnable run = new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
					//创建一个sheet
					String sql = " JOIN "+tableName+" t ON t.patientId=t1.patientId AND t.searchId = "+searchId;
					if(reqFlag!=null&&reqFlag==1){
						sql +=" AND t.flag in (1,2) ";
					}
					if(info.getTypeId()!=null){
						if(staticType != null && staticType==5) {
							int typeId = Integer.parseInt(info.getTypeId());
							if(staticResultType != null && staticResultType == 2) {
								switch(typeId) {
									case 1:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE operationFlag=1 AND  patientId = t.patientId) ";
										break;
									case 2:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE radiotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 3:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE chemotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 4:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE operationFlag=1 AND radiotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 5:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE operationFlag=1 AND chemotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 6:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE radiotherapyFlag=1 AND chemotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 7:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE operationFlag=1 AND radiotherapyFlag=1 AND chemotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 8:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE operationFlag=0 AND radiotherapyFlag=0 AND chemotherapyFlag=0 AND  patientId = t.patientId) ";
										break;
									case 9:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE patientId = t.patientId AND isHaveTherapy=0) ";
										break;
								}
							}else {
								switch(typeId) {
									case 1:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE operationFlag=1 AND  patientId = t.patientId) ";
										break;
									case 2:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE radiotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 3:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE chemotherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 4:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE targetedTherapyFlag=1 AND  patientId = t1.patientId) ";
										break;
									case 5:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE endocrineTherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 6:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE interventionalTherapyFlag=1 AND  patientId = t.patientId) ";
										break;
									case 7:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE immunotherapyFlag=1 AND  patientId = t1.patientId) ";
										break;
									case 8:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE laserTreatmentFlag=1 AND  patientId = t.patientId) ";
										break;
									case 9:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE biologicalTreatmentFlag=1 AND  patientId = t.patientId) ";
										break;
									case 10:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE traditionalChineseMedicineFlag=1 AND  patientId = t.patientId) ";
										break;
									case 11:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE isotopeTreatmentFlag=1 AND  patientId = t.patientId) ";
										break;
									case 12:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE rfAblationFlag=1 AND  patientId = t.patientId) ";
										break;
									case 13:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE analgesicTherapyFlag=1 AND  patientId = t1.patientId) ";
										break;
									case 14:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE otherFlag=1 AND  patientId = t1.patientId) ";
										break;
									case 15:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE patientId = t.patientId AND (unknownFlag=1 OR isHaveTherapy=0)) ";
										break;
									case 16:
										sql += " AND EXISTS(SELECT 1 FROM ehr_db.var_patient_medical WHERE untreatedFlag=1 AND  patientId = t.patientId) ";
										break;
								}
							}
						}else {
							sql +=" AND conditionId = "+info.getTypeId()+" ";
						}
					}
					Map<String,String> sqlMap = new HashMap<String, String>();
					sqlMap.put("sqlContent", MessageFormat.format(sqlcontent, sql,"",""));
					List<HashMap<String,Object>> dataList = survivalDao.queryPatientInfo(sqlMap);
					if(dataList==null||dataList.size()==0)
						return;
					List<Object> sheetData = new ArrayList<Object>();
					//头部数据
					sheetData.add(heads);
					int size = dataList.size();
					//循环结果
					for(HashMap<String,Object> dataMap : dataList){
						String[] data = new String[fileds.length];
						//列循环写入数组
						for(int i=0;i<fileds.length;i++){
							Object value = dataMap.get(fileds[i]);
							data[i]=value==null?"":value.toString();
						}
						sheetData.add(data);
					}
					dataList.clear();
					LogUtil.logError.error("=====name=="+info.getTypeName()+"==size==="+size);
					dataMap1.put(info.getTypeName(), sheetData);
					}catch(Exception e){
						LogUtil.logError.error(" query sql error, message:"+e.getMessage());
					}finally {
						doneSignal.countDown();
						LogUtil.log.debug("doneSignal count ===="+doneSignal.getCount());
					}
				}
			};
			exec.submit(run);
		}
		try {
			doneSignal.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			exec.shutdown();
		}
		int i = 0;
		for(Object objinfo : objs){
			if(objs.size()>1&&i++==0)
				continue;
			TSurvivalRateInfo info = (TSurvivalRateInfo)objinfo;
			Map<String, Object> sheetMap = new HashMap<String, Object>();
			if(dataMap1.get(info.getTypeName())==null)
				continue;
			sheetMap.put("sheetName", info.getTypeName());
			sheetMap.put("sheetData", dataMap1.get(info.getTypeName()));
			List list = (List)dataMap1.get(info.getTypeName());
			LogUtil.log.debug("=====name=="+info.getTypeName()+"==size==="+list.size());
			bookData.add(sheetMap);
		}
		return bookData;
	}
	
	@Override
	public File buildSurvivalRateReportFile(Object countData, Object subData, Object compareData, Object compareSubData, String searchId, Integer staticType){
		// TODO Auto-generated method stub
		File outFile = null;
		//加载数据
		List<Object> fdata = this.initExportData(countData,subData, compareData, compareSubData, staticType);
		//文件路径获取
		String filePath= this.getClass().getClassLoader().getResource("").getPath();
		//模版名称获取
		String fileTemplate = "export.survival.file.template."+staticType;
		//拼接文件名
		fileTemplate = messageSource.getMessage(fileTemplate, null, null);
		try{
			outFile = ExcelFileWriteUtil.initFollowReportTemplateFile(new File(filePath+"template/template"+(new Date()).getTime()+".xlsx"), filePath+"template/"+fileTemplate, 3, 0, fdata);
		}catch(Exception e){
			LogUtil.logError.error("build survivalRateReport error message:"+e.getMessage());
		}
		//头部内容
		ConfGlobal conf = confGlobalDao.queryConfGlobal();
		String title =  messageSource.getMessage("export.survivalrate.title", new Object[]{conf.getHospitalName()}, null);
		String condition = null;
		if(staticType!=4){
			if(searchId != null){
				SearchInfo searchInfo = searchDao.querySearchById(Integer.parseInt(searchId));
				FollowupSurvivalRatePreReq req = JsonUtil.toObject(searchInfo.getReq(), FollowupSurvivalRatePreReq.class);
				Object[] objs= getConditions(req);
				if(objs!=null)
					condition = messageSource.getMessage("export.survivalrate.condition", objs, null);
			}
		}
		String remark = messageSource.getMessage("export.survivalrate.remark", null, null);
		//部分内容写入
		try{
			FileInputStream is = new FileInputStream(outFile);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			int rows = sheet.getLastRowNum();
			rows++;
			//合并列
			int mergerColumnNum = 0;
			if(staticType!=4){
				mergerColumnNum=17;
			}else{
				mergerColumnNum=16;
			}
			//头部信息
			XSSFCell cell = row.getCell(0);
			cell.setCellValue(title);
			//条件行
			if(condition!=null){
				CellRangeAddress region1 = new CellRangeAddress(rows, rows, 0, mergerColumnNum);
				sheet.addMergedRegion(region1);
				row = sheet.createRow(rows++);
				row.setHeightInPoints(60);
				cell = row.createCell(0);
				cell.setCellValue(condition);
				XSSFCellStyle cellstyle = wb.createCellStyle();
				cellstyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
				cellstyle.setWrapText(true);
				cell.setCellStyle(cellstyle);
			}
			//结果行
			CellRangeAddress region = new CellRangeAddress(rows, rows, 0, mergerColumnNum);
			sheet.addMergedRegion(region);
			row = sheet.createRow(rows);
			row.setHeightInPoints(204);
			XSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setWrapText(true);
			cell = row.createCell(0);
			cell.setCellStyle(cellstyle);
			cell.setCellValue(remark);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			wb.write(baos);
			FileOutputStream fileOut = new FileOutputStream(outFile);
			baos.writeTo(fileOut);
			baos.close();
			fileOut.close();
		}catch(Exception e){
			LogUtil.logError.error("template create error message="+e.getMessage());
			e.printStackTrace();
		}
		return outFile;
	}
	
	private Object[] getConditions(FollowupSurvivalRatePreReq req){
		Object[] objs= new Object[6];
		String str = "-";
		if(req==null)
			return null;
		objs[0]=req.getConfirmedDateStart()!=null?DateUtil.getDateStr(req.getConfirmedDateStart()):str;
		objs[1]=req.getConfirmedDateEnd()!=null?DateUtil.getDateStr(req.getConfirmedDateEnd()):str;
		objs[2]=req.getOutHospitalDateStart()!=null?DateUtil.getDateStr(req.getOutHospitalDateStart()):str;
		objs[3]=req.getOutHospitalDateEnd()!=null?DateUtil.getDateStr(req.getOutHospitalDateEnd()):str;
		if(req.getSubReq()==null){
			objs[4]=str;
			objs[5]=str;
		}else{
			objs[4]=req.getSubReq().getFollowupDateStart()!=null?DateUtil.getDateStr(req.getSubReq().getFollowupDateStart()):str;
			objs[5]=req.getSubReq().getFollowupDateEnd()!=null?DateUtil.getDateStr(req.getSubReq().getFollowupDateEnd()):str;
		}
		return objs;
	}
}
