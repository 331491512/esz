package com.esuizhen.cloudservice.ehr.service.doctor.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.ConsultDoctorsOfPatientGetReq;
import com.esuizhen.cloudservice.ehr.bean.TConsultDoctorDetailResp;
import com.esuizhen.cloudservice.ehr.dao.DetectionReport.DetectionReportDao;
import com.esuizhen.cloudservice.ehr.dao.doctor.DoctorDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.ExamReportDao;
import com.esuizhen.cloudservice.ehr.dao.patient.DiagnosisDao;
import com.esuizhen.cloudservice.ehr.service.doctor.DoctorService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.service.UserService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DiagnosisDao diagnosisDao;
	
	@Autowired
	private DetectionReportDao detectionReportDao;
	
	@Autowired
	private ExamReportDao examReportDao;
	
	@Autowired
	private DoctorDao doctorDao;
	
	/**
	 * 公共用户服务
	 */
	@Resource(name = "userService")
	private UserService userService;
	
	@Override
	public Doctor getConsultDoctorOfPatient(ConsultDoctorsOfPatientGetReq req){
		Doctor doctor=new Doctor();
		Long patientId=req.getPatientId();
		String reportId=req.getReportId();
		
		if(req.getType()==1){//检查
			doctor=this.examReportDao.getApplyDoctorByReportId(reportId);
		}else{//检验
			doctor=this.detectionReportDao.getApplyDoctorByReportId(reportId);
		}
		
		//获取询问医师
		if(UtilValidate.isEmpty(doctor)){
			doctor=doctorDao.queryDoctorByLashInhospitalInfo(patientId);
			if(UtilValidate.isEmpty(doctor)){
				doctor=doctorDao.queryDoctorByRelation(patientId);
			}
		}
		return doctor;
	}
	
	@Override
	public Doctor getServiceDutyDoctor(Integer hospitalId){
		//获取值班医生
		return doctorDao.queryServiceDutyDoctor(hospitalId);
	}
	
	@Override
	public TConsultDoctorDetailResp getConsultDoctorDetailOfPatient(ConsultDoctorsOfPatientGetReq req){
		TConsultDoctorDetailResp result =new TConsultDoctorDetailResp();
		Doctor doctor=this.getConsultDoctorOfPatient(req);
		if(UtilValidate.isNotEmpty(doctor)){
			result.setConsultDoctorType(1);
		}else if(UtilValidate.isNotEmpty(req.getHospitalId())){
			doctor=this.getServiceDutyDoctor(req.getHospitalId());
			result.setConsultDoctorType(2);
		}
		if(UtilValidate.isNotEmpty(doctor)){
			UserProfileDetailResp userProfileDetailResp = userService.getDetailUserProfile(doctor.getUserId(), 2, doctor.getDoctorId());
			result.setUserProfileDetailResp(userProfileDetailResp);
		}
		return result;
	}
	
}
