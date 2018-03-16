/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.service.impl;<br/>  
 * <b>文件名：</b>FollowupServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月7日上午10:24:37<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.statistics.bean.PatientSpreadReq;
import com.esuizhen.cloudservice.statistics.bean.SurvivalRateReq;
import com.esuizhen.cloudservice.statistics.bean.TDiseaseSpread;
import com.esuizhen.cloudservice.statistics.bean.TDiseaseSpreadItem;
import com.esuizhen.cloudservice.statistics.bean.TFollowupReportApply;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultSpread;
import com.esuizhen.cloudservice.statistics.bean.TFollowupSpread;
import com.esuizhen.cloudservice.statistics.bean.TPatientSpreadInfo;
import com.esuizhen.cloudservice.statistics.bean.TSurvivalRateInfo;
import com.esuizhen.cloudservice.statistics.bean.TSurvivalRateItem;
import com.esuizhen.cloudservice.statistics.dao.FollowupReportApplyDao;
import com.esuizhen.cloudservice.statistics.dao.StatisticsDao;
import com.esuizhen.cloudservice.statistics.service.StatisticsService;
import com.esuizhen.cloudservice.statistics.util.MathUtils;
import com.westangel.common.bean.search.ConfGlobal;
import com.westangel.common.constant.Constant;
import com.westangel.common.dao.search.ConfGlobalDao;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;

/** 
* @ClassName: FollowupServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年4月7日 上午10:24:37  
*/
@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService{
	
	@Autowired
	private StatisticsDao dao;
	@Autowired
	private FollowupReportApplyDao applyDao;
	@Autowired
	private ConfGlobalDao confGlobalDao;
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${mail.subject}")
	private String subject;
	
	@Value("${mail.from}")
	private String mailFrom;
	
	// 查询月份
	private String[] months = new String[] { "3", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36", "39",
			"42", "45", "48", "51", "54", "57", "60"};
	// 数据格式
	private DecimalFormat decimalFormat = new DecimalFormat("0.0");
	/**
	 * 生存率统计
	 */
	@Override
	public Object calculateSurvivalRate(SurvivalRateReq req) {
		// TODO Auto-generated method stub
		List result = new ArrayList();
		if(req.getUserId()==null){
			throw new EmptyParamExcption("\"userId\" cannot be empty!");
		}
		if(req.getUserRole()==null){
			throw new EmptyParamExcption("\"userRole\" cannot be empty!");
		}
		//如果userId为0 则统计平台数据
		if(req.getUserId()==0){
			req.setUserRole(0);
		}
		//如果角色为医生，获取医生Id
		if(req.getUserRole()==Constant.User.ROLE_DOCTOR){
			req.sql = organizationDoctorService.getPatientSql(null, req.getUserId());
		}
		if(req.getWantDiseaseType()==null||req.getWantDiseaseType()==0){ //不分病种
			req.setWantDiseaseType(null);
			initSurvivalResultList(req,result);
		}
		else if(req.getWantDiseaseType()==1){ //分病种
			if(req.getDiseaseTypes()==null||req.getDiseaseTypes().size()==0){
				req.setDiseaseTypeNum(3);
				req.setDiseaseTypes(dao.queryDoctorDiseaseList(req));
			}
			initSurvivalResultList(req,result);
			if(result.size()>0){
				//如果数量少  则重置查询条件
				if(result.size()<req.getDiseaseTypes().size()){
					req.getDiseaseTypes().clear();
					for(Object obj :result){
						TSurvivalRateInfo rete = (TSurvivalRateInfo)obj;
						req.getDiseaseTypes().add(rete.getDiseaseTypeId());
					}
				}
			}else{
				return null;
			}
			req.setUserRole(0);
			req.setDoctorId(null);
			initSurvivalResultList(req,result);
		}
		return result;
	}
	
	//获取统计数据
	private void initSurvivalResultList(SurvivalRateReq req,List reuslt){
		try{
		List<LinkedHashMap<String, Object>> list = null;
		//如果角色为0 查平台
		if(req.getUserRole()==0){
			list = dao.querySurvivalAvg(req);
		}else{//查医生
			list = dao.queryDoctorSurvivalCount(req);
			if(list==null)//没有数据直接返回
				return;
			for(LinkedHashMap<String, Object> mapInfo : list){
				req.setTypeId((Integer)mapInfo.get("typeId"));
				LinkedHashMap<String, Object> rate = dao.statisSurvivalRate(req);
				if(rate!=null){
					for(String key:rate.keySet()){
						mapInfo.put(key, rate.get(key));
					}
				}
			}
		}
		if(list!=null)
			for(Map<String,Object> map :list)
				if(map!=null)
					reuslt.add(formatTSurvivalRateInfo(map));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//加载日报数据
	private void initFollowupReportResultList(SurvivalRateReq req,List reuslt){
		List<LinkedHashMap<String, Object>> list = dao.queryDoctorSurvivalCount(req);
		if(list==null)//没有数据直接返回
			return;
		for(LinkedHashMap<String, Object> mapInfo : list){
			req.setTypeId((Integer)mapInfo.get("typeId"));
			LinkedHashMap<String, Object> rate = dao.statisSurvivalRate(req);
			if(rate!=null){
				for(String key:rate.keySet()){
					mapInfo.put(key, rate.get(key));
				}
			}
		}
		if(list!=null){
			for(Map<String,Object> map : list)
				if(map!=null)
					reuslt.add(formatTSurvivalRateInfo(map));
		}
	}
	
	private String rateExeute(Integer dividend, Integer divisor){
		if(dividend==null||dividend ==0)
			return "0";
		return decimalFormat.format((float)dividend/(float)divisor*100);
	} 
	//结构化统计数据
	private TSurvivalRateInfo formatTSurvivalRateInfo(Map<String,Object> resultMap){
		if(resultMap==null)
			return null;
		TSurvivalRateInfo info = new TSurvivalRateInfo();
		if(resultMap.get("typeId")!=null){
			info.setTypeId(resultMap.get("typeId")+""); //类型编号
			info.setDiseaseTypeId(Integer.parseInt(info.getTypeId())); //病种Id
		}
		info.setTypeName(resultMap.get("typeName")+""); //类型名称
		info.setDiseaseTypeName(info.getTypeName()); //病种名称
		info.setTotalNum(Integer.parseInt(resultMap.get("totalNum")+"")); //患者总人数
		info.setValidNum(Integer.parseInt(resultMap.get("validNum")+"")); //有效人数
		info.setUnvalidNum(Integer.parseInt(resultMap.get("unvalidNum")+"")); //无效人数
		info.setDeathNum(Integer.parseInt(resultMap.get("deathNum")+"")); //死亡人数
		info.setValidRate(rateExeute(info.getValidNum(),info.getTotalNum())); //有效率
		info.setUnvalidRate(rateExeute(info.getUnvalidNum(),info.getTotalNum())); //无效率
		info.setDeathRate(rateExeute(info.getDeathNum(),info.getTotalNum())); //死亡率
		info.setMiddleMonth((String)resultMap.get("middleMonth")); //中位生存月
		info.setSurvivalRates(new ArrayList<TSurvivalRateItem>());
		List<TSurvivalRateItem> rates = info.getSurvivalRates();
		for(String month : months){
			TSurvivalRateItem rate = new TSurvivalRateItem();
			rate.setMonth(Integer.parseInt(month));
			if(resultMap.get("survivalRate"+month)!=null&&StringUtils.isNotEmpty(resultMap.get("survivalRate"+month)+"")){
				rate.setSurvivalRate(resultMap.get("survivalRate"+month)+"");
				rate.setTotalNumber(info.getTotalNum());
				rate.setValid(info.getValidNum());
				rate.setSurvivalNumber(info.getSurvivalCount());
				rate.setValidRate(info.getValidRate());
			}
			else{
				rate.setSurvivalRate("0");
				rate.setTotalNumber(0);
			}
			rates.add(rate);
		}
		return info;
	}
	
	
	/**
	 * 患者概况统计
	 */
	@Override
	public Object calculatePatientSpread(PatientSpreadReq req) {
		// TODO Auto-generated method stub
		if(req.getUserId()==null){
			throw new EmptyParamExcption("\"userId\" cannot be empty!");
		}
		if(req.getUserRole()==null){
			throw new EmptyParamExcption("\"userRole\" cannot be empty!");
		}
		if(req.getUserId()==0){
			req.setUserRole(0);
		}
		if(req.getUserRole()==Constant.User.ROLE_DOCTOR){
			String sql = organizationDoctorService.getPatientSql(null, req.getUserId());
			if(sql!=null)
				req.sql=sql;
		}
		TPatientSpreadInfo info = new TPatientSpreadInfo();
		if(req.getStatisticType()==null||req.getStatisticType().length==0){
			req.setStatisticType(new String[]{"SEXAGE","PROVINCE","DISEASE"});
		}
		for(String type : req.getStatisticType()){
			if("SEXAGE".equals(type))
				info.setSexAge(dao.querySexAgeResult(req));
			else if("PROVINCE".equals(type))
				info.setProvince(dao.queryProvinceResult(req));
			else if("DISEASE".equals(type)){
				List<TDiseaseSpreadItem> list = dao.queryDiseaseSpreadItem(req);
				if(list!=null&&list.size()>0){
					TDiseaseSpread disease = new TDiseaseSpread();
					disease.initDiseaseDistributionItems(list);
					info.setDisease(disease);
				}
			}
			else if("CONTACTWAY".equals(type)){
				info.setContactWay(dao.queryContactwaySpread(req));
			}
			else if("ISFOLLOWUP".equals(type))
				info.setFollowup(dao.queryFollowupSpread(req));
			else if("FOLLOWUPRESULT".equals(type))
				info.setFollowupResult(dao.queryFollowupResultSpread(req));
		}
		return info;
	}

	/**
	 * 更新随访数据
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public void update_data() {
		// TODO Auto-generated method stub
		LogUtil.log.debug("--------------update start------------------");
		try {
			dao.updateDayStatistics();
		} catch (Exception e) {
			// TODO: handle exception
			LogUtil.logError.error("--------------update error------------------"+e.getMessage());
		}
		LogUtil.log.debug("--------------update end------------------");
	}
	
	/**
	 * 申请报告发送
	 */
	@Override
	public void checkFollowReportApply() {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Runnable run = new Runnable(){
			@Override
			public void run()
			{
				excuFollowReportApply();
			}
		};
		exec.execute(run);
	}
	private void excuFollowReportApply(){
		List<TFollowupReportApply> list = applyDao.queryNotSendFollowupReportApply();
		if(list!=null && list.size()>0){
			//报告扫描
			List reuslt = new ArrayList();
			//初始化请求
			SurvivalRateReq req = new SurvivalRateReq();
			//初始化请求角色
			req.setUserRole(2);
			for(TFollowupReportApply apply : list){
				//给定用户
				req.setUserId(apply.getUserId());
				req.sql = organizationDoctorService.getPatientSql(apply.getDoctorId(),null);
				//病种分类
				req.setWantDiseaseType(1);
				req.setDiseaseTypes(dao.queryDoctorDiseaseList(req));
				//获取病种请求数据
				if(req.getDiseaseTypes()!=null&&req.getDiseaseTypes().size()>0)
					initFollowupReportResultList(req, reuslt);
				
				try {
					//文件生成
					File file = initFollowReportFile(reuslt,apply.getTrueName()+subject);
					String title = pushInnerService.getMessage(PushContentUtil.getStatisticsPushContent("2", "followup.report.mail.title"));
					String content = pushInnerService.getMessage(PushContentUtil.getStatisticsPushContent("2", "followup.report.mail.content",new Object[]{apply.getTrueName(),DateUtil.getDateStr(apply.getApplyDate())}));
					//邮件发送
					if(sendMain(apply.getEmail(),title,content,file)){
						applyDao.modifyFollowupReportApply(apply.getProductapplyId());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				//清空数据
				reuslt.clear();
			}
		}
	}
	/**
	 * 邮件发送
	 * @author lichenghao
	 * @title :sendMain
	 * @Description:TODO
	 * @return boolean
	 * @date 2016年5月31日 下午9:19:48
	 */
	public boolean sendMain(String toMail,String sendTile,String sendText, File toFile) 
	{
		boolean sendFlag = false;
		LogUtil.log.info("---------send mail start -------mail:"+toMail);
		try {
			MimeMessage mail = sender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mail, true);
			helper.setTo(toMail);
//			helper.setFrom(mailFrom);
			String nick="";  
	        try {  
	            nick=javax.mail.internet.MimeUtility.encodeText("易随诊");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }   
	        helper.setFrom(new InternetAddress(nick+" <"+mailFrom+">"));
			helper.setSubject(sendTile);
			helper.setText(sendText);
			helper.addAttachment(toFile.getName(), toFile);
			sender.send(mail);
			toFile.deleteOnExit();
			sendFlag = true;
			LogUtil.log.info("---------send mail success -------mail:"+toMail);
		} catch (Exception e) {
			LogUtil.logError.error("---------send mail error -------mail:"+toMail);
			LogUtil.logError.error(e.getCause()+"/t"+e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} 
		return sendFlag;
	}
	
	private File initFollowReportFile(List reuslt,String fileName)throws Exception{
		LogUtil.log.info("---------init file start-------");
		String filePath= this.getClass().getClassLoader().getResource("").getPath();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		writeFollowReportTemple(filePath+"template/survival_for_doctor_template.xlsx",baos,reuslt);
		filePath+="template/"+fileName+".xlsx";
		File file =new File(filePath);
		FileOutputStream fileOut = new FileOutputStream(file);
		baos.writeTo(fileOut);
		baos.close();
		fileOut.close();
		LogUtil.log.info("---------init file success-------");
		return file;
	}
	
	public static void writeFollowReportTemple(String file,ByteArrayOutputStream baos,List result)throws Exception{
		FileInputStream is = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowindex=4;
		XSSFRow row = null;
		XSSFCell cell = null;
		if(result!=null)
		for(Object obj : result){
			TSurvivalRateInfo info = (TSurvivalRateInfo)obj;
			if(info.getPatientCount()!=null&&info.getPatientCount()==0)
				continue;
			row = sheet.createRow(rowindex++);
			int clo=0;
			//病种标题
			cell = row.createCell(clo++);
			setCellValue(cell,info.getDiseaseTypeName());
			//总数
			cell = row.createCell(clo++);
			setCellValue(cell,info.getTotalNum());
			
			//有效
			cell = row.createCell(clo++);
			setCellValue(cell,info.getValidNum());
			
			//有效率
			cell = row.createCell(clo++);
			setCellValue(cell,info.getValidRate());
			
			//无效
			cell = row.createCell(clo++);
			setCellValue(cell,info.getUnvalidNum());
			
			//无效率
			cell = row.createCell(clo++);
			setCellValue(cell,info.getUnvalidRate());
			
			//死亡
			cell = row.createCell(clo++);
			setCellValue(cell,info.getDeathNum());
			
			//死亡率
			cell = row.createCell(clo++);
			setCellValue(cell,info.getDeathRate());
			
			for (TSurvivalRateItem item : info.getSurvivalRates()) {
				//n月生存率
				switch (item.getMonth()) {
				case 3:
				case 6:
				case 9:
				case 12:
				case 24:
				case 36:
				case 48:
				case 60:
					cell = row.createCell(clo++);
					if("0".equals(item.getSurvivalRate()))
						setCellValue(cell,"-");
					else
						setCellValue(cell,item.getSurvivalRate()+"%");
					break;
				default:
					break;
				}
			}
			
			//中位生存月
			cell = row.createCell(clo++);
			setCellValue(cell,info.getMiddleMonth());
		}
		wb.write(baos);
	}
	
	public static void setCellValue(XSSFCell cell,Object value){
		if(value==null)
			cell.setCellValue("");
		else 
			cell.setCellValue(value+"");
	}
	private static DecimalFormat df = new DecimalFormat("0.0%");
	public static String toDoubleFormMat(double d){
		return df.format(d);
	}
	public static void main(String[] args) {
	}

	@Override
	public boolean isToB() {
		// TODO Auto-generated method stub
		ConfGlobal conf = confGlobalDao.queryConfGlobal();
		if(conf!=null && conf.getDeployLocation()==1){
			return true;
		}
		return false;
	}

	@Override
	public TFollowupSpread statisticsFollowupProgressively(
			PatientSpreadReq req) {
		if(req.getUserRole()==Constant.User.ROLE_DOCTOR){
			req.sql = organizationDoctorService.getPatientSql(null, req.getUserId());
		}
		TFollowupSpread result = dao.statisticsFollowupProgressively(req);
		if(result != null) {
			result.setNoFollowup(result.getTotalNum()-result.getEffectiveFollowup()-result.getInvalidFollowup());
			if(result.getTotalNum() > 0) {
				result.setNoFollowupRate(MathUtils.sub("1", MathUtils.add(result.getEffectiveRate(), result.getInvalidRate(), 3), 3));
			}
        }
        return result;
	}

	@Override
	public TFollowupResultSpread statisticsLastEffectiveFollowupResult(
			PatientSpreadReq req) {
		if(req.getUserRole()==Constant.User.ROLE_DOCTOR){
			req.sql = organizationDoctorService.getPatientSql(null, req.getUserId());
		}
        TFollowupResultSpread result = dao.statisticsLastEffectiveFollowupResult(req);
        if(result != null && result.getTotalNum() > 0) {
            result.setDeathRate(MathUtils.sub("1", MathUtils.add(MathUtils.add(result.getStableRate(), result.getRecurrenceRate(), 2), result.getTransferRate(), 2), 2));
        }
        /*if(result != null && result.getTotalNum() > 0) {
        	BigDecimal stableRate = new BigDecimal(result.getStableRate());
            BigDecimal recurrenceRate = new BigDecimal(result.getRecurrenceRate());
            BigDecimal transferRate = new BigDecimal(result.getTransferRate());
            BigDecimal deathRate = new BigDecimal(result.getDeathRate());
            
            Map<String,Double> stableRateMap = new HashMap<String,Double>();
            stableRateMap.put("type", 1.0);
            stableRateMap.put("splitRate", stableRate.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            stableRateMap.put("diffRate", MathUtils.sub(stableRateMap.get("splitRate")+"", result.getStableRate(),2));
            list.add(stableRateMap);
            
            Map<String,Double> recurrenceRateMap = new HashMap<String,Double>();
            recurrenceRateMap.put("type", 2.0);
            recurrenceRateMap.put("splitRate", recurrenceRate.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            recurrenceRateMap.put("diffRate", MathUtils.sub(recurrenceRateMap.get("splitRate")+"", result.getRecurrenceRate(),2));
            list.add(recurrenceRateMap);
            
            Map<String,Double> transferRateMap = new HashMap<String,Double>();
            transferRateMap.put("type", 3.0);
            transferRateMap.put("splitRate", transferRate.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            transferRateMap.put("diffRate", MathUtils.sub(transferRateMap.get("splitRate")+"", result.getTransferRate(),2));
            list.add(transferRateMap);
            
            Map<String,Double> deathRateMap = new HashMap<String,Double>();
            deathRateMap.put("type", 4.0);
            deathRateMap.put("splitRate", deathRate.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            deathRateMap.put("diffRate", MathUtils.sub(deathRateMap.get("splitRate")+"", result.getDeathRate(),2));
            list.add(deathRateMap);
            
            ArrayList<Map<String,Double>> newList = new ArrayList<Map<String,Double>>();
            for(Map<String,Double> map :list) {
            	if(map.get("diffRate") > 0) {
            		newList.add(map);
            	}
            }
            if(newList != null && newList.size() > 0) {
            	int position = 0;
                double max = newList.get(0).get("diffRate");
                for(int i = 1;i < newList.size();i++) {
                	double diffRate = newList.get(i).get("diffRate");
                	if(max < diffRate) {
                		max = newList.get(i).get("diffRate");
                		position = i;
                	}
                }
                String testRate = "0.01";
                newList.get(position).put("splitRate", MathUtils.sub(newList.get(position).get("splitRate")+"", testRate,2));
            }
            
            //把值重新赋值到相应的字段里面
            for(int i = 0;i < list.size();i++) {
            	double type = list.get(i).get("type");
            	String splitRate = list.get(i).get("splitRate")+"";
            	if(type ==1.0) {
            		result.setStableRate(splitRate);
            	}else if(type ==2.0) {
            		result.setRecurrenceRate(splitRate);
            	}else if(type ==3.0) {
            		result.setTransferRate(splitRate);
            	}else if(type ==4.0) {
            		result.setDeathRate(splitRate);
            	}
            }
        }*/
		return result;
	}
}
