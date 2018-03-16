/**
  * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.patient.impl;<br/>  
 * <b>文件名：</b>PatientServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午11:48:44<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.DetectionReport.impl;

import java.util.ArrayList;   
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.TDetectionItemInfo;
import com.esuizhen.cloudservice.ehr.bean.TDetectionReportDetailInfo;
import com.esuizhen.cloudservice.ehr.dao.DetectionReport.DetectionReportDao;
import com.esuizhen.cloudservice.ehr.dao.DetectionReport.DetectionReportItemDao;
import com.esuizhen.cloudservice.ehr.dao.doctor.DoctorDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalRecordDao;
import com.esuizhen.cloudservice.ehr.dao.patient.PatientSymptomDao;
import com.esuizhen.cloudservice.ehr.model.detection.DetectionItemDetail;
import com.esuizhen.cloudservice.ehr.model.detection.DetectionReport;
import com.esuizhen.cloudservice.ehr.service.DetectionReport.DetectionReportService;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.westangel.common.bean.UserDefinedMetaData;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.GeneralUtil;

/** 
* @ClassName: DetectionReportServiceImpl
* @Description: 
* @author fanpanwei
* @date 2017年03月31日 上午11:48:44  
*/
@Service
public class DetectionReportServiceImpl implements DetectionReportService {

	@Autowired
	private EmedicalRecordDao medicalRecordDao;
	@Autowired
	private PatientSymptomDao patientSymptomDao;
	@Autowired
	private DetectionReportDao detectionReportDao;
	@Autowired
	private DetectionReportItemDao detectionReportItemDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private MetaDataService metaDataService;
	
	
	@Override
	public List<TDetectionReportDetailInfo> saveDetectionReportDetailList(
			List<TDetectionReportDetailInfo> reqList) throws Exception {
		// TODO Auto-generated method stub
		List<TDetectionReportDetailInfo> resultList=null;
		if(reqList!=null&&reqList.size()>0){
			resultList=new ArrayList<TDetectionReportDetailInfo>();
			if(reqList.get(0)==null)return null;
			Long patientId = reqList.get(0).getPatientId();
			Long doctorId = reqList.get(0).getDoctorId();
			Integer isDelete = null;
			String emrId = null;
			String detectionReportId = null;
			TDetectionReportDetailInfo resultInfo = null;
			Map<String, Object> patientInfoMap = patientSymptomDao.queryPatientById(patientId);
			Map<String, Object> doctorInfoMap = this.doctorDao.getDoctorInfoById(doctorId);
			if(doctorInfoMap==null)throw new Exception("传入DoctorId有异常！");
			
			for (TDetectionReportDetailInfo reportInfo : reqList) {
				resultInfo = new TDetectionReportDetailInfo();
				isDelete=reportInfo.getIsDelete();
				emrId=reportInfo.getEmrId();
				detectionReportId=reportInfo.getDetectionReportId();
				
				if(detectionReportId!=null){
					this.detectionReportItemDao.deleteDetectionReportDetail(detectionReportId);
					this.detectionReportDao.deleteDetectionReport(detectionReportId);
				}else{
					detectionReportId = GeneralUtil.generatorUUID("ELIS");
				}
				if(isDelete!=null&&isDelete==1){
					//删除逻辑
					continue;
				}else if(emrId==null){//新增逻辑  修改不做处理
					emrId = GeneralUtil.generatorUUID("EMRI");
				}
				//设置返回值
				resultInfo.setEmrId(emrId);
				resultInfo.setSortNum(reportInfo.getSortNum());
				resultInfo.setDetectionReportId(detectionReportId);
				resultList.add(resultInfo);
				//插入检验项信息
				this.insertReportInfo(reportInfo, patientInfoMap, emrId, detectionReportId,doctorInfoMap);
				//插入检验项明细
				this.insertreportItemInfoList(reportInfo, patientInfoMap);
			}
		}
		return resultList;
	}
	private void insertReportInfo(TDetectionReportDetailInfo reportInfo,Map<String,Object> patientInfoMap,String emrId,String detectionReportId,Map<String,Object> doctorInfoMap){
		//更新检验类型元数据信息
		String mainKey=reportInfo.getDetectionTypeId()!=null?reportInfo.getDetectionTypeId().toString():null;
		UserDefinedMetaData metaData=new UserDefinedMetaData();
		metaData.setMainKey(mainKey);
		metaData.setMetaName(reportInfo.getDetectionTypeName());
		metaData.setCreator(reportInfo.getDoctorId());
		metaData.setParentKey(reportInfo.getParentId().toString());
		
		metaData.setMetaDataTable("meta_e_detection_type");
		metaData.setMainKeyField("detectionTypeId");
		metaData.setMetaNameField("detectionTypeName");
		metaData.setParentKeyField("parentId");
		Integer finalKey=this.metaDataService.addMetaDate(metaData);
		reportInfo.setDetectionTypeId(finalKey);
		//更新业务表信息
		reportInfo.setEmrId(emrId);
		reportInfo.setDetectionReportId(detectionReportId);
		reportInfo.setPatientNo(patientInfoMap.get("patientNo")!=null?patientInfoMap.get("patientNo").toString():null);
		reportInfo.setPatientIdno(patientInfoMap.get("idNo")!=null?patientInfoMap.get("idNo").toString():null);
		reportInfo.setPatientAddress(patientInfoMap.get("address")!=null?patientInfoMap.get("address").toString():null);
		reportInfo.setPatientMobile(patientInfoMap.get("mobile")!=null?patientInfoMap.get("mobile").toString():null);
		if(patientInfoMap.get("sex")!=null){
			reportInfo.setOutPatientFlag(Integer.parseInt(patientInfoMap.get("sex").toString()));
		}
		if(patientInfoMap.get("outPatientFlag")!=null){
			reportInfo.setOutPatientFlag(Integer.parseInt(patientInfoMap.get("outPatientFlag").toString()));
		}
		
		
		reportInfo.setDeptId(null);
		reportInfo.setDeptName(null);
		reportInfo.setDoctorId(doctorInfoMap.get("doctorId")!=null?Long.parseLong(doctorInfoMap.get("doctorId").toString()):null);
		reportInfo.setDoctorNo(doctorInfoMap.get("staffNo")!=null?doctorInfoMap.get("staffNo").toString():null);
		reportInfo.setDoctorName(doctorInfoMap.get("doctorName")!=null?doctorInfoMap.get("doctorName").toString():null);
		reportInfo.setState(3);
		reportInfo.setReadFlag(Constant.User.READFLAG_NO);
		this.detectionReportDao.insert(reportInfo);
	}
	
	private void insertreportItemInfoList(TDetectionReportDetailInfo reportInfo,Map<String,Object> patientInfoMap){
		List<TDetectionItemInfo> reportDetailList=reportInfo.getDetectionItemDetails();
		if (reportDetailList != null && !reportDetailList.isEmpty()) {
			for (TDetectionItemInfo itemInfo:reportDetailList) {
				//更新检验单位元数据信息
				String mainKey=itemInfo.getUnit()!=null?itemInfo.getUnit().toString():null;
				UserDefinedMetaData metaData=new UserDefinedMetaData();
				if(StringUtils.isNotBlank(itemInfo.getUnit())){
					metaData.setMainKey(mainKey);
					metaData.setMetaName(itemInfo.getUnit());
					metaData.setCreator(reportInfo.getDoctorId());
					
					metaData.setMetaDataTable("meta_c_detection_unit");
					metaData.setMainKeyField("id");
					metaData.setMetaNameField("unit");
					
					this.metaDataService.addMetaDate(metaData);
				}
				//更新检验明细元数据信息
				mainKey=itemInfo.getDetectionItemId()!=null?itemInfo.getDetectionItemId().toString():null;
				metaData=new UserDefinedMetaData();
				metaData.setMainKey(mainKey);
				metaData.setMetaName(itemInfo.getDetectionItemName());
				metaData.setCreator(reportInfo.getDoctorId());
				metaData.setParentKey(reportInfo.getDetectionTypeId().toString());
				metaData.setFlagKey(1);
				
				metaData.setMetaDataTable("meta_e_detection_item");
				metaData.setMainKeyField("detectionItemId");
				metaData.setMetaNameField("detectionItemName");
				metaData.setParentKeyField("detectionTypeId");
				metaData.setFlagKeyField("flag");
				
				Integer finalKey=this.metaDataService.addMetaDate(metaData);
				itemInfo.setDetectionItemId(finalKey.toString());
				//更新业务表信息
				itemInfo.setDetectionDetailId(GeneralUtil.generatorUUID("EDETD"));
				itemInfo.setDetectionReportId(reportInfo.getDetectionReportId());
				itemInfo.setPatientId(reportInfo.getPatientId());
				
				itemInfo.setPatientNo(reportInfo.getPatientNo());
				itemInfo.setDetectionTypeName(reportInfo.getDetectionTypeName());
				this.detectionReportItemDao.insert(itemInfo);
		}
		}
	}
	@Override
	public List<DetectionReport> getDetectionReportList(
			Long patientId) {
		// TODO Auto-generated method stub
		//按检验项分组查处所有检验记录
		List<DetectionReport> byTypeSet=this.detectionReportDao.getAllReportGroupByType(patientId);
		//List<Map<String, Object>> byTypeSet = this.detectionReportDao.getAllReportGroupByType(patientId);
		if(byTypeSet==null||byTypeSet.size()==0)return null;
		for (DetectionReport detectionReport : byTypeSet) {
			//处理检验项明细开始
			List<DetectionItemDetail> itemDetailList = this.detectionReportItemDao.getAllDetailGroupByType(detectionReport.getDetectionTypeName().toString(),patientId);
			detectionReport.setItemDetailList(itemDetailList);
		}
		return byTypeSet;
	}
	@Override
	public Map<String, Object> getSpecifyDetectionReport(
			String detectionReportId) {
		//获取检验项相关信息
		Map<String, Object> returnMap = this.detectionReportDao.getSpecifyReportByReportId(detectionReportId);
		if(returnMap==null)return null;
		//获取检验项明细相关信息
		List<Map<String, Object>> detailByReportIdList = this.detectionReportItemDao.getSpecifyDetailByReportId(detectionReportId);
		if(detailByReportIdList!=null&&detailByReportIdList.size()>0){
			returnMap.put("detectionDetails", detailByReportIdList);
		}
		return returnMap;
	}
}
