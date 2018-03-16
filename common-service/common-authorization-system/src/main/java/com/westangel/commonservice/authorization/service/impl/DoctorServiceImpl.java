package com.westangel.commonservice.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.westangel.common.bean.Doctor;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.commonservice.authorization.common.Cons;
import com.westangel.commonservice.authorization.dao.DoctorDao;
import com.westangel.commonservice.authorization.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorDao doctorDao;

	@Transactional
	@Override
	public boolean addDoctor(Doctor doctor) {
		doctor.setSyncFlag(Constant.SYNC_NO);//同步标识
		doctor.setIsExpert(Constant.User.ISEXPERT_NO);//是否专家出诊
		doctor.setAuditState(Constant.User.AUDITSTATE_NOT);//医生审核状态
		doctor.setRecommendFlag(0);//推荐标志
		this.doctorDao.insert(doctor);
		
		List<Doctor> subordinateUserList = doctor.getSubordinateUserList();
		if (subordinateUserList != null && !subordinateUserList.isEmpty()) {
			//更新下级医生
			this.doctorDao.updateSubordinate(doctor.getDoctorId(), subordinateUserList);
		}
		return true;
	}

	@Override
	public List<Doctor> getOrganizationStructure(Integer hospitalId, Long userId) throws InsufficientParameterExcption {
		if (hospitalId == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		List<Doctor> doctors = this.doctorDao.findPositionDoctor(hospitalId, Cons.POSITION_DEAN);
		this.getSubordinateDoctors(hospitalId, doctors);
		return doctors;
	}
	
	/**
	 * <p>Title:getSubordinateDoctors</p>
	 * <p>Description:获取医生的直接下级医生</p>
	 * @author YYCHEN
	 * @date 2016年8月5日 下午5:49:50
	 * @param hospitalId
	 * @param doctors
	 */
	private void getSubordinateDoctors(Integer hospitalId, List<Doctor> doctors){
		if (doctors == null || doctors.isEmpty()) {
			return;
		}
		for (Doctor doctor : doctors) {
			List<Doctor> list = this.doctorDao.findSubordinateDoctors(hospitalId, doctor.getDoctorId());
			doctor.setSubordinateUserList(list);
			this.getSubordinateDoctors(hospitalId, list);
		}
	}
}
