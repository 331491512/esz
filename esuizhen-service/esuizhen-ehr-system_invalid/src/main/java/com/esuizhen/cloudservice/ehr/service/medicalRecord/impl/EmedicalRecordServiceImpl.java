package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.MedialRecordForwardReq;
import com.esuizhen.cloudservice.ehr.bean.TEmrDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.dao.disease.EdiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.dao.disease.MetaEdiseaseBodyPartDao;
import com.esuizhen.cloudservice.ehr.dao.disease.MetaEdiseaseTypeKeywordDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalPhotoOcrsDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalRecordDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.TVarPatientDoctorMedicalDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.TVarPatientMedicalDao;
import com.esuizhen.cloudservice.ehr.dao.user.UserDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalPhotoOcrs;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.TVarPatientMedical;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.resp.MedialRecordUploadResp;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.EmedicalRecordService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.ehr.TSyncDiagnosisInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.service.DoctorService;
import com.westangel.common.service.EmrInnerService;
import com.westangel.common.service.PatientService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushUtil;

@Service
@Transactional
public class EmedicalRecordServiceImpl implements EmedicalRecordService, EmrInnerService{
	private Locale locale=Locale.getDefault();
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserDao           userDao;
	
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
}
