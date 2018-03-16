package com.esuizhen.cloudservice.ehr.service.medical.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.bean.MedialRecordForwardReq;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;
import com.esuizhen.cloudservice.ehr.bean.TEmrDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.bean.medical.PatientMedicalRecordModifyFlag;
import com.esuizhen.cloudservice.ehr.bean.medical.PatientMedicalRecordReq;
import com.esuizhen.cloudservice.ehr.dao.disease.EdiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.dao.disease.MetaEdiseaseBodyPartDao;
import com.esuizhen.cloudservice.ehr.dao.disease.MetaEdiseaseTypeKeywordDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalPhotoOcrsDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalRecordDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.TVarPatientDoctorMedicalDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.TVarPatientMedicalDao;
import com.esuizhen.cloudservice.ehr.dao.user.UserDao;
import com.esuizhen.cloudservice.ehr.model.diagnose.PatientDiagnosisInfoReq;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.medical.ChangeVersion;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalPhotoOcrs;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.TVarPatientMedical;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.resp.MedialRecordUploadResp;
import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.PatientTreatmentInfoReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;
import com.esuizhen.cloudservice.ehr.service.adversereaction.AdverseReactionService;
import com.esuizhen.cloudservice.ehr.service.common.CommonService;
import com.esuizhen.cloudservice.ehr.service.genenalexamsign.GenenalExamSignService;
import com.esuizhen.cloudservice.ehr.service.inhospital.PatientClinicInfoService;
import com.esuizhen.cloudservice.ehr.service.inhospital.TInhospitalDetailInfoService;
import com.esuizhen.cloudservice.ehr.service.medical.MedicalCatalogueService;
import com.esuizhen.cloudservice.ehr.service.medical.MedicalService;
import com.esuizhen.cloudservice.ehr.service.meta.MetaDataUserDefinedService;
import com.esuizhen.cloudservice.ehr.service.patientinfo.PatientWideTableService;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.PresentationMorbidityService;
import com.esuizhen.cloudservice.ehr.service.qualitylife.QualityLifeService;
import com.esuizhen.cloudservice.ehr.service.surgeryintensivecare.PatientSurgeryIntensiveCareService;
import com.esuizhen.cloudservice.ehr.service.treatment.PatientSurgeryService;
import com.esuizhen.cloudservice.ehr.service.treatment.PatientTreatmentService;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentChemotherapyMedicationInfoService;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentRadiotherapyInfoService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.UserDefinedMetaData;
import com.westangel.common.bean.ehr.TSyncDiagnosisInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.DoctorService;
import com.westangel.common.service.EmrInnerService;
import com.westangel.common.service.PatientService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushUtil;

@Service
@Transactional
public class MedicalServiceImpl implements MedicalService, EmrInnerService{
	private Locale locale=Locale.getDefault();
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmedicalRecordDao dao;
	
	@Autowired
	private EmedicalPhotoOcrsDao ocrDao;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired 
	private DoctorService   doctorService;

	@Autowired
	private PushInnerService pushInnerService;
	
	@Autowired
	private TVarPatientDoctorMedicalDao varPatientDoctorMedicalDao;
	
	@Autowired
	private TVarPatientMedicalDao varPatientMedicalDao;
	
	@Autowired
	private MetaEdiseaseTypeKeywordDao diseaseTypeKeywordDao;
	
	@Autowired
	private EdiagnosisInfoDao diagnosisDao;
	
	@Autowired
	private MetaEdiseaseBodyPartDao bodyPartDao;
	
	@Autowired
	private TInhospitalDetailInfoService inhospitalDetailInfoService;
	
	@Autowired
	private PatientClinicInfoService patientClinicInfoService;
	
	@Autowired
	private QualityLifeService qualityLifeService;
	
	@Autowired
	@Qualifier("diagnosisInfoService")
	private CommonService<TDiagnosisInfo> diagnosisCommonService;
	
	@Autowired
	@Qualifier("treatmentService")
	private CommonService<TPatientTreatmentInfo> treatmentCommonService;
	
	@Autowired
	private PresentationMorbidityService presentationMorbidityService;
	
	@Autowired
	private GenenalExamSignService genenalExamSignService;
	
	@Autowired
	private AdverseReactionService adverseReactionService;
	
	@Autowired
	private PatientSurgeryIntensiveCareService patientSurgeryIntensiveCareService; 
	
	@Autowired
	private MedicalCatalogueService medicalCatalogueService; 
	
	@Autowired
	private MetaDataUserDefinedService metaDataUserDefinedService;
	
	@Autowired
	private PatientSurgeryService patientSurgeryService;
	
	@Autowired
	private PatientWideTableService patientWideTableService;
	
	@Autowired
	private TreatmentRadiotherapyInfoService radiotherapyInfoService;
	
	@Autowired
	private TreatmentChemotherapyMedicationInfoService chemotherapyMedicationInfoService;
	
	@Autowired
	private PatientTreatmentService patientTreatmentService;

	@Value("${server.ehr.query.path}")
	private String ehrPath;
	
	@Value("${server.wx.url.root}")
	private String wxUrl;
	
	@Value("${ehr.upload.wx.template.name}")
	private String templateName;
	
	@Value("${server.h5.url.root.app2}")
	private String appUrl;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public MedialRecordUploadResp insertEmedicalRecord(EmedicalRecord emedicalRecord)
	{
		//保存电子病例主信息
		emedicalRecord.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
		emedicalRecord.setCacheIndex(System.currentTimeMillis());
		if(emedicalRecord.getSourceFlag()!=null&&emedicalRecord.getSourceFlag()==1){
			emedicalRecord.setCreatorId(null);
		}
		dao.insertEmedicalRecord(emedicalRecord);
		
		//更新医患电子病历中间表
		modifyPatientDoctorMedicalCount(emedicalRecord,1);
		
		//判断是否有OCR图片
		if(emedicalRecord.getMedicalPicInfoList()==null||emedicalRecord.getMedicalPicInfoList().size()<1)
		{//如果没有图片直接返回
			throw new RuntimeException();
		}
		
		//设置电子病例ID
		Calendar calendar = Calendar.getInstance ();
		for(EmedicalPhotoOcrs ocr : emedicalRecord.getMedicalPicInfoList())
		{
			ocr.setEmrPhotoId(GeneralUtil.generatorTimeUUID());
			ocr.setEmrId(emedicalRecord.getEmrId());
			calendar.add (Calendar.SECOND, 1);
			Date nowDate = calendar.getTime();
			//String updateTime = DateUtil.getDateOfDay(nowDate, "yyyy-MM-dd HH:mm:ss");
			ocr.setUpdateTime(nowDate);
		}
		
		//保存OCR电子病例
		ocrDao.insertEmedicalPhotoOcrsList(emedicalRecord.getMedicalPicInfoList());
		
		//病历动态更新信息
		TVarPatientMedical varPatientMedical = varPatientMedicalDao.queryVarPatientMedicalByPatientId(emedicalRecord.getPatientId());
		if(varPatientMedical!=null)
		{//如果存在则更新
			varPatientMedical.setLatestMedicalRecordUploadTime(new Date());
			varPatientMedicalDao.updateVarPatientMedical(varPatientMedical);
		}else
		{//不存在则保存
			varPatientMedical = new TVarPatientMedical();
			varPatientMedical.setPatientId(emedicalRecord.getPatientId());
			varPatientMedical.setLatestMedicalRecordUploadTime(new Date());
			varPatientMedicalDao.insertVarPatientMedical(varPatientMedical);
		}
		
		try 
		{
			//状态回写
			patientService.hasVisibleMedicalRecord(emedicalRecord.getVisibleFlag(),emedicalRecord.getSourceFlag() ,emedicalRecord.getCreatorId(), emedicalRecord.getPatientId());
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.logError.error(e.getMessage());
		}
		//最后发送消息
		//Added by Daloong, 2016/1/14
		// 发出一条推送. 先找到此患者所有关注的医生。逐个发送（将来可以群发）
		if (emedicalRecord.getVisibleFlag() == 0) {//
													// 暂时预留不做任何推送
		} else if (emedicalRecord.getSourceFlag() == 1) {// 患者上传
			//sendPushNotifyToDoctor(emedicalRecord.getPatientId(), emedicalRecord.getEmrId());
		} else if (emedicalRecord.getSourceFlag() == 2
				&& (emedicalRecord.getVisibleFlag() == 1 || emedicalRecord.getVisibleFlag() == 2)
				//是否新上传
				&& (emedicalRecord.getRepeat() == null || emedicalRecord.getRepeat() == 0)) {// 医生上传
			LinkedHashMap<String, Object> patientMap = dao.queryPatientById(emedicalRecord.getCreatorId(),
					emedicalRecord.getPatientId());
			if (patientMap != null && patientMap.get("userId") != null && patientMap.get("trueName") != null
					&& patientMap.get("productId") != null) {
				this.notificationPatientNewMedicalRecords(patientMap);
			}
		}
		MedialRecordUploadResp medialRecordUploadResp = new MedialRecordUploadResp();
		medialRecordUploadResp.setEmrInfo(emedicalRecord);
		return medialRecordUploadResp;
	}

	/**
	 * <p>Title:notificationPatientNewMedicalRecords</p>
	 * <p>Description:通知患者有新病历到达</p>
	 * @author YYCHEN
	 * @date 2016年12月6日 下午2:22:58
	 * @param params
	 */
	private void notificationPatientNewMedicalRecords(Map<String, Object> params) {
		LogUtil.log.info("推送通知患者消息");
		List<String> data = new ArrayList<String>();
		data.add(messageSource.getMessage("ehr.upload.fisrt.info", null, null));
		data.add(params.get("patientName") + "");
		data.add(params.get("trueName") + "");
		data.add(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		data.add(messageSource.getMessage("ehr.upload.remark.info",
				new Object[] { params.get("trueName"), params.get("trueName") }, null));
		PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(templateName,
				wxUrl + ehrPath + "?fromUserName=" + params.get("openId"), data);
		notify.setUserId(Long.parseLong(params.get("userId") + ""));
		notify.setProductId((Integer) params.get("productId"));
		pushInnerService.push(notify);
		LogUtil.log.info("notify:" + notify);
	}
	
	private void notificationPatientMdtFinish(Map<String, Object> params) {
		LogUtil.log.info("推送患者会诊结束");
		List<String> data = new ArrayList<String>();
		data.add("");
		data.add(params.get("groupName") + "");
		data.add(messageSource.getMessage("push.service.mdt.finish", null, null));
		data.add("MDT要求与目的："+params.get("goal") + "。您申请的会诊进度已完成,点击查看会诊结果。");
		PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo("huizhenjindutongzhi",appUrl + "mdt/html/detail/detail.html?id="+params.get("id")
		        +"&userId="+params.get("doctorUserId")
		        +"&doctorId="+params.get("doctorId"), data);
		notify.setUserId(Long.parseLong(params.get("userId") + ""));
		notify.setProductId((Integer) params.get("productId"));
		pushInnerService.push(notify);
		LogUtil.log.info("notify:" + notify);
	}
	
	/**更新医患病历中间表*/
	private void modifyPatientDoctorMedicalCount(EmedicalRecord eme,Integer count){
		if(eme.getVisibleFlag()==null || eme.getVisibleFlag()==0){
			return;
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("patientId",eme.getPatientId());
		param.put("creatorId",eme.getCreatorId());
		param.put("visibleFlag",eme.getVisibleFlag());
		param.put("addCount", count);
		Integer updateLine = varPatientDoctorMedicalDao.modifyVarPatientDoctorMedical(param);
		if(updateLine!=null&&updateLine==0){
			if(eme.getCreatorId()!=null){
				this.varPatientDoctorMedicalDao.insert(param);
			}else{
				varPatientDoctorMedicalDao.createVarPatientDoctorMedical(param);
			}
		}
	}
	
	/**
	 * 当患者上传病历后，发送推送通知给医生
	 * @param patientId
	 * @param emrId
	 */
	private void sendPushNotifyToDoctor(Long patientId, String emrId) {
		//上传新病历时，给医生发出推送
		try{
			String patientName = userDao.getUserTrueName(patientId);
		    String content = messageSource.getMessage("push.emr.new.upload.todoctor", 
					new Object[]{patientName}, locale);
			//找到此患者所有关注的医生，每个医生都进行推送（好在一个患者关注的医生不多）  暂不推送
		    List<DoctorSimpleInfo> doctorList = doctorService.listDoctorsOfPatient(patientId,0L);
		    LogUtil.log.debug("doctorList.size()="+doctorList.size());
		    for(DoctorSimpleInfo doctor:doctorList){
		    	PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForEmr(doctor.getUserId(), patientId, patientName, emrId,content);
		    	pushInnerService.push(notifyInfo);
		    }
		}
		catch(Exception e){
			//没有调用成功时，不对外抛异常，不能影响正常业务
			LogUtil.logError.error("sendPushNotifyToDoctor failed: patientId="+patientId+e.getMessage());
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateEmedicalRecord(EmedicalRecord emedicalRecord)
	{
		//修改电子病例信息
		dao.updateEmedicalRecord(emedicalRecord);
		
		//删除orc信息
		ocrDao.deleteEmedicalPhotoOcrsByEmrId(emedicalRecord.getEmrId());

		//判断是否有OCR图片
		if(emedicalRecord.getMedicalPicInfoList()==null||emedicalRecord.getMedicalPicInfoList().size()<1)
		{
			return;
		}
		
		//设置电子病例ID
		Calendar calendar = Calendar.getInstance ();
		for(EmedicalPhotoOcrs ocr : emedicalRecord.getMedicalPicInfoList())
		{
			ocr.setEmrPhotoId(GeneralUtil.generatorTimeUUID());
			ocr.setEmrId(emedicalRecord.getEmrId());
			calendar.add (Calendar.SECOND, 1);
			Date nowDate = calendar.getTime();
			//String updateTime = DateUtil.getDateOfDay(nowDate, "yyyy-MM-dd HH:mm:ss");
			ocr.setUpdateTime(nowDate);
		}
		
		//保存OCR电子病例
		ocrDao.insertEmedicalPhotoOcrsList(emedicalRecord.getMedicalPicInfoList());
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteEmedicalRecord(String emrId)
	{
		//获取电子病历信息
		EmedicalRecord emedicalRecord = dao.queryEmedicalRecordById(emrId);
		
		//更新医患电子病历中间表
		modifyPatientDoctorMedicalCount(emedicalRecord,-1);
				
		//删除orc信息
		ocrDao.deleteEmedicalPhotoOcrsByEmrId(emrId);
		
		//删除电子病例信息
		dao.deleteEmedicalRecord(emrId);
		
		try 
		{
			Integer count = 0;
			//状态回写
			if(1==emedicalRecord.getVisibleFlag())
			{
				count = dao.queryEmedicalRecordCountByParam(emedicalRecord.getPatientId(), null, "1", null);
			}else if(2==emedicalRecord.getVisibleFlag()||3==emedicalRecord.getVisibleFlag())
			{
				count = dao.queryEmedicalRecordCountByParam(emedicalRecord.getPatientId(), emedicalRecord.getCreatorId(), "2,3", null);
			}else if(4==emedicalRecord.getVisibleFlag())
			{
				count = dao.queryEmedicalRecordCountByParam(emedicalRecord.getPatientId(), emedicalRecord.getCreatorId(), "4", null);
			}
			
			StringBuffer sb = new StringBuffer();
			sb.append("VisibleFlag="+emedicalRecord.getVisibleFlag());
			sb.append("SourceFlag="+emedicalRecord.getSourceFlag());
			sb.append("CreatorId="+emedicalRecord.getCreatorId());
			sb.append("PatientId="+emedicalRecord.getPatientId());
			
			LogUtil.log.info("参数:"+sb.toString());
			LogUtil.log.info("患者病历数:"+count);
			if(count==0)
			{
				LogUtil.log.info("调用用户修改接口开始");
				patientService.delHasVisibleMedicalRecord(emedicalRecord.getVisibleFlag(),emedicalRecord.getSourceFlag(), emedicalRecord.getCreatorId(), emedicalRecord.getPatientId());
				LogUtil.log.info("调用用户修改接口结束");
			}
		} catch (Exception e) {
			LogUtil.log.info("调用用户修改接口失败");
			LogUtil.logError.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public EmedicalRecord queryEmedicalRecordById(String emedicalRecordId)
	{
		return dao.queryEmedicalRecordById(emedicalRecordId);
	}

	@Override
	public Page<EmedicalRecord> selectEmedicalRecordList(Long userId , Integer role , Long patientId, Integer page, Integer num)
	{
		List<EmedicalRecord> list = null ;
		PageHelper.startPage(page+1, num);
		if(role==1)
		{//患者自己查看病历，及医生给患者公开的病历
			list = dao.selectEmedicalRecordListByPatientId(patientId);
		}else
		{//医生自己查看病历，并查看患者自己上传的病历
			list = dao.selectEmedicalRecordListByUserId(userId , patientId);
		}
		
		if(list!=null && list.size()>0)
		{//如果列表不为空
			for(EmedicalRecord emedicalRecord : list)
			{//查询图片列表
				emedicalRecord.setMedicalPicInfoList(dao.queryMedicalPhotoOcrsByEmrId(emedicalRecord.getEmrId()));
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<EmedicalRecord>)list);
	}	
	
	/**
	 * 
	* @Title: syncDiagnosis 
	* @Description: 同步疾病信息 
	* @param @param diagonsis    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void syncDiagnosis(TSyncDiagnosisInfo diagonsis)
	{		
		LogUtil.log.info("进入同步诊断信息.........................syncDiagnosis="+JsonUtil.toJson(diagonsis));
		String emrId = null;
		List<String> list = dao.queryEmrIdOfPateint(
				diagonsis.getPatientId(), 
				diagonsis.getPatientNo(),
				diagonsis.getHospitalId());
		
		if (null == list || 0 == list.size()) {
			emrId = GeneralUtil.generateUniqueID("EMRI");
			EmedicalRecord record = new EmedicalRecord();
			record.setEmrType(9);
			record.setEmrSubType(0);
			record.setPatientId(diagonsis.getPatientId());
			record.setPatientNo(diagonsis.getPatientNo());
			record.setHospitalId(diagonsis.getHospitalId());
			record.setEmrId(emrId);
			record.setSourceFlag(1);
			record.setStructFlag(1);
			record.setVisibleFlag(0);
			record.setVisitTime(new Date());
			dao.insertEmedicalRecord(record);
		} else {
			emrId = list.get(0);
			diagnosisDao.deleteDiagnosisByEmrId(emrId);
		}
		List<TEmrDiagnosisInfo> diagnosisList = new ArrayList<TEmrDiagnosisInfo>();
		//存入诊断表
		for (String diagnosis:diagonsis.getDiagnosis()){
			List<Integer> idList = getDiseaseTypeIdViaDiagnosis(diagnosis);
			if (null != idList && idList.size() > 0) {
				Integer dtypeId = idList.get(0);
				TEmrDiagnosisInfo info = new TEmrDiagnosisInfo();
				info.setDiagnosisId(GeneralUtil.generateUniqueID("ED"));
				info.setEmrId(emrId);
				info.setPatientId(diagonsis.getPatientId());
				info.setPatientNo(diagonsis.getPatientNo());				
				info.setDiagnosis(diagnosis);
				info.setDiseaseTypeId(dtypeId);
				info.setDiseaseCode("0");
				info.setIsSourceDiagnosis(0);
				info.setDiagnosisTypeId(dtypeId==0 ? 0 : 1);
				//如果为0，设为未知，否则反查部位
				info.setDiseaseBodyPartId(0 == dtypeId?0:bodyPartDao.selectDiseaseBodyPartByDiseaseTypeId(dtypeId));
				diagnosisList.add(info);
			}
		}
		if (diagnosisList.size() > 0) {
			diagnosisDao.insertDiagnosis(diagnosisList);	
		}
	}
	
	@Override
	public List<Integer> getDiseaseTypeIdViaDiagnosis(String diagnosis)
	{
		LogUtil.log.info("进入根据诊断获取疾病类型.........................getDiseaseTypeIdViaDiagnosis="+diagnosis);
		List<Integer> list = diseaseTypeKeywordDao.queryDieasetypeByDiagnosis(diagnosis);
		//如果查不到
		if (null == list || 0 == list.size()) {
			list = new ArrayList<Integer>();
			list.add(0);
		}
		return list;
	}

	@Override
	public boolean forwardMedicalRecord2Patient(MedialRecordForwardReq medialRecordForwardReq) {
		switch (medialRecordForwardReq.getEmrType()) {
		case 6:
			this.dao.forwardMDTMedicalRecord(medialRecordForwardReq);
			//给患者推送新病例通知
			LinkedHashMap<String, Object> patientMap = dao.queryPatientMdtById(medialRecordForwardReq.getDoctorId(),
					medialRecordForwardReq.getPatientId(),medialRecordForwardReq.getProductApplyId());
			if (patientMap != null && patientMap.get("userId") != null && patientMap.get("trueName") != null
					&& patientMap.get("productId") != null) {
				this.notificationPatientNewMedicalRecords(patientMap);
				this.notificationPatientMdtFinish(patientMap);
			}
			break;
		}
		return true;
	}

	@Transactional
	@Override
	public void savePatientMedicalRecord(PatientMedicalRecordReq patientMedicalRecordReq) {
		if(patientMedicalRecordReq == null) {
			throw new EmptyParamExcption("param error [PatientMedicalRecordReq] is null");
		}
		// modily by zhuguo
		Long patientId=patientMedicalRecordReq.getPatientId();
		Long operatorId=patientMedicalRecordReq.getOperatorId();
		Integer hospitalId=patientMedicalRecordReq.getHospitalId();
		// end
		if(patientId == null) {
			throw new EmptyParamExcption("param error [PatientId] is null");
		}
		if(operatorId == null) {
			throw new EmptyParamExcption("param error [Operator] is null");
		}
		if(StringUtils.isEmpty(patientMedicalRecordReq.getInhospitalId())) {
			throw new EmptyParamExcption("param error [inhospitalId] is null");
		}
		//保存日志
		this.saveChangeVersion(patientMedicalRecordReq);
		String inhospitalId=null;
		String clinicMedicalId=null;
		//住院信息
		TInhospitalDetailInfo inhospitalDetailInfo=patientMedicalRecordReq.getInhospitalDetailInfo();
		//门诊信息
		PatientClinicInfo patientClinicInfo=patientMedicalRecordReq.getPatientClinicInfo();
		//诊断信息
		List<TDiagnosisInfo> diagnosisList=patientMedicalRecordReq.getDiagnosisList();
		//手术信息
		List<TPatientSurgeryInfo> surgeryList=patientMedicalRecordReq.getSurgeryList();
		//重症监护信息
		List<TPatientSurgeryIntensiveCareInfo> surgeryIntensiveCareList=patientMedicalRecordReq.getSurgeryIntensiveCareList(); 
		//治疗信息
		List<TPatientTreatmentInfo> treatmentList=patientMedicalRecordReq.getTreatmentList();
		//表现与发病
		PresentationMorbidityInfo presentationMorbidity=patientMedicalRecordReq.getPresentationMorbidityInfo();
		//体格检查情况
		GenenalExamSignsInfo genenalExamSignsInfo=patientMedicalRecordReq.getGenenalExamSignsInfo();
		//身体状态评分
		QualityoflifeInfo qualityoflifeInfo=patientMedicalRecordReq.getQualityoflifeInfo();
		//不良反应情况
		List<AdverseReactionResultInfo> adverseReactionResultList=patientMedicalRecordReq.getAdverseReactionResultList();
		
		//保存住院信息
		if(UtilValidate.isNotEmpty(inhospitalDetailInfo)){
			inhospitalId=inhospitalDetailInfo.getInhospitalId();
			//住院信息新增
			if(UtilValidate.isEmpty(inhospitalDetailInfo.getInhospitalId())){
				inhospitalDetailInfoService.createInhospitalDetail(inhospitalDetailInfo);
			//住院信息修改
			}else {
				inhospitalDetailInfoService.updateInhospitalDetail(inhospitalDetailInfo);
			}
			
		//保存门诊信息
		}else if(UtilValidate.isNotEmpty(patientClinicInfo)){
			clinicMedicalId=patientClinicInfo.getClinicMedicalId();
			patientClinicInfoService.insertPatientClinicInfo(patientClinicInfo);
		}
		
		//保存诊断信息
		CommonReq reqOne = new CommonReq();
		reqOne.setPatientId(diagnosisList.get(0).getPatientId());
		reqOne.setSpecialDiseaseRegisterId(diagnosisList.get(0).getSpecialDiseaseRegisterId());
		reqOne.setOperateFlag(diagnosisList.get(0).getOperateFlag());
		diagnosisCommonService.save(reqOne, diagnosisList);
		
		//保存手术信息(treatmentSchemeId???)
		TInhospitallSurgeryMsg<TPatientSurgeryInfo> inhospitalSurgeryMsg=new TInhospitallSurgeryMsg<TPatientSurgeryInfo>();
		if(StringUtils.isNotEmpty(inhospitalDetailInfo.getInhospitalId())){
			inhospitalSurgeryMsg.setInhospitalId(inhospitalDetailInfo.getInhospitalId());
		}else{
			inhospitalSurgeryMsg.setClinicMedicalId(patientClinicInfo.getClinicMedicalId());
		}
		inhospitalSurgeryMsg.setPatientNo(patientMedicalRecordReq.getPatientNo());
		inhospitalSurgeryMsg.setHospitalId(hospitalId);
		inhospitalSurgeryMsg.setOperatorId(operatorId);
		inhospitalSurgeryMsg.setResultList(surgeryList);
		// add by zhuguo
		inhospitalSurgeryMsg.setPatientId(patientId);
		// end
		patientSurgeryService.savePatientSurgeryInfo(inhospitalSurgeryMsg);
		
		//保存重症监护
		TInhospitallSurgeryMsg<TPatientSurgeryIntensiveCareInfo> msg=new TInhospitallSurgeryMsg<TPatientSurgeryIntensiveCareInfo>();
		msg.setInhospitalId(inhospitalId);
		msg.setResultList(surgeryIntensiveCareList);
		patientSurgeryIntensiveCareService.savePatientSurgeryIntensiveCareInfo(msg);
		
		//保存治疗与用药(treatmentSchemeId???)
		CommonReq req = new CommonReq();
		req.setPatientId(patientId);
//		req.setSpecialDiseaseRegisterId(treatmentList.get(0).getSpecialDiseaseRegisterId());
		req.setOperatorId(operatorId);
		//add by fanpanwei更新化疗方案类型元数据信息
		for (TPatientTreatmentInfo tPatientTreatmentInfo : treatmentList) {
			if(tPatientTreatmentInfo==null)continue;
			if(StringUtils.isNotBlank(tPatientTreatmentInfo.getTreatmentName())){
				UserDefinedMetaData metaData=new UserDefinedMetaData();
				metaData.setCreator(operatorId);
				metaData.setMetaName(tPatientTreatmentInfo.getTreatmentName());
				metaData.setParentKey(tPatientTreatmentInfo.getTreatmentTypeId().toString());
				
				metaData.setMetaDataTable("ehr_db.meta_e_treatment_scheme");
				metaData.setMainKeyField("treatmentSchemeId");
				metaData.setMetaNameField("treatmentSchemeName");
				metaData.setParentKeyField("treatmentTypeId");
				metaData.setQueryCondition(" AND treatmentTypeId='"+tPatientTreatmentInfo.getTreatmentTypeId()+"'");
				this.metaDataUserDefinedService.addMetaDateInIntKey(metaData);
			}
		}
		
		// 如果没有传入“治疗及用药”列表的数据时
		if (treatmentList.size() <= 0) {
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("patientId", inhospitalSurgeryMsg.getPatientId());
			paramsMap.put("inhospitalId", inhospitalId);
			paramsMap.put("clinicMedicalId",
					inhospitalSurgeryMsg.getClinicMedicalId());
			radiotherapyInfoService.deleteRadiotherapyInfo(paramsMap);
			chemotherapyMedicationInfoService
					.deleteChemotherapyMedicationInfo(paramsMap);
			patientTreatmentService.deletePatientTreatmentInfo(paramsMap);
		}
		//更新业务数据
		treatmentCommonService.save(req, treatmentList);
		
		//表现与发病
		presentationMorbidityService.insertPresentationMorbidity(presentationMorbidity);
		
		//保存体格检查
		genenalExamSignService.saveGenenalExamSignsInfo(genenalExamSignsInfo);
		
		//保存不良反应情况
		adverseReactionService.saveAdverseReactionResult(adverseReactionResultList);
		// 异步更新宽表信息
		if(StringUtils.isNotEmpty(inhospitalDetailInfo.getInhospitalId())) {
			patientWideTableService.updatePatientWideTable(patientId, inhospitalId);
		}
		
	}
	/**
	 * 保存病案日志
	 * @param req
	 */
	@Override
	public void saveChangeVersion(PatientMedicalRecordReq req){
		ChangeVersion changeVersion=new ChangeVersion();
		PatientMedicalRecordModifyFlag modifyFlag = req.getModifyFlag();
		if(modifyFlag == null) {
			LogUtil.log.info("#####PatientMedicalRecordModifyFlag is null#####");
			return;
		}
		
		//住院信息历史保存
		TInhospitalDetailInfo inhospitalDetailInfo = inhospitalDetailInfoService.queryInhospitalDetail(req.getInhospitalId());
		if(inhospitalDetailInfo != null) {
			changeVersion.setInhospitalContent(JsonUtil.toJson(inhospitalDetailInfo));
		}
		//诊断信息历史保存
		PatientDiagnosisInfoReq diagnosisReq = new PatientDiagnosisInfoReq();
		diagnosisReq.setPatientId(req.getPatientId());
		diagnosisReq.setInhospitalId(req.getInhospitalId());
		List<TDiagnosisInfo> diagnosisList = diagnosisCommonService.query(diagnosisReq);
		if(diagnosisList != null && diagnosisList.size() > 0) {
			changeVersion.setDiagnosisContent(JsonUtil.toJson(diagnosisList));
		}
		//手术治疗历史保存
		PatientTreatmentInfoReq treatmentReq = new PatientTreatmentInfoReq();
		treatmentReq.setPatientId(req.getPatientId());
		treatmentReq.setInhospitalId(req.getInhospitalId());
		List<TPatientTreatmentInfo> treatmentList = treatmentCommonService.query(treatmentReq);
		CommonReq commonReq = new CommonReq();
		commonReq.setPatientId(req.getPatientId());
		commonReq.setInhospitalId(req.getInhospitalId());
		List<TPatientSurgeryInfo> surgeryList = patientSurgeryService.queryPatientSurgeryInfoByInHospitalId(commonReq);
		if(surgeryList != null && surgeryList.size() > 0) {
			changeVersion.setSurgeryContent(JsonUtil.toJson(surgeryList));
		}
		if(treatmentList != null && treatmentList.size() > 0) {
			changeVersion.setTreatmentContent(JsonUtil.toJson(treatmentList));
		}
		//重症监护室
		List<TPatientSurgeryIntensiveCareInfo> surgeryIntensiveCareList = patientSurgeryIntensiveCareService.queryPatientSurgeryIntensiveCareInfoByInHospitalId(req.getInhospitalId());
		if(surgeryIntensiveCareList != null && surgeryIntensiveCareList.size() > 0) {
			changeVersion.setIntensiveCareContent(JsonUtil.toJson(surgeryIntensiveCareList));
		}
		//表现与发病历史保存
		PresentationMorbidityInfo morbidityInfo = presentationMorbidityService.queryPresentationMorbidity(commonReq);
		if(morbidityInfo != null) {
			changeVersion.setMorbidityContent(JsonUtil.toJson(morbidityInfo));
		}
		//体格检查历史保存
		AttendPatientReq attendPatientReq = new AttendPatientReq();
		attendPatientReq.setPatientId(req.getPatientId());
		attendPatientReq.setInhospitalId(req.getInhospitalId());
		GenenalExamSignsInfo genenalExamSigns = genenalExamSignService.queryGenenalExamSignsInfo(attendPatientReq);
		if(genenalExamSigns != null) {
			changeVersion.setGenenalExamSignsContent(JsonUtil.toJson(genenalExamSigns));
		}
		//不良反应历史保存
		List<AdverseReactionResultInfo> adverseReactionList = adverseReactionService.queryAdverseReactionResult(attendPatientReq);
		if(adverseReactionList != null && adverseReactionList.size() > 0) {
			changeVersion.setAdverseReactionContent(JsonUtil.toJson(adverseReactionList));
		}
		//卡片标签,json格式
		String cardTag = JsonUtil.toJson(modifyFlag);
		changeVersion.setCardTag(cardTag);
		
		changeVersion.setPatientId(req.getPatientId());
		if(UtilValidate.isNotEmpty(req.getInhospitalDetailInfo())){
			changeVersion.setVisitType(1);//住院
			changeVersion.setVisitId(req.getInhospitalDetailInfo().getInhospitalId());
		}else if(UtilValidate.isNotEmpty(req.getPatientClinicInfo())){
			changeVersion.setVisitType(2);//门诊
			changeVersion.setVisitId(req.getPatientClinicInfo().getClinicMedicalId());
		}
		changeVersion.setHospitalId(req.getHospitalId());
		changeVersion.setOperator(req.getOperatorId());
		medicalCatalogueService.insertChangeVersion(changeVersion);
	}
}
