package com.esuizhen.cloudservice.ehr.service.inhospital.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.PatientInHospitalNoteListReq;
import com.esuizhen.cloudservice.ehr.bean.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.dao.patient.InHospitalDao;
import com.esuizhen.cloudservice.ehr.model.inhospital.InhospitalTurnRecord;
import com.esuizhen.cloudservice.ehr.service.inhospital.InhospitalService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.PageUtil;

@Service
public class InhospitalServiceImpl implements InhospitalService{
	@Autowired
	private InHospitalDao inhospitalDao;
	
	//患者入院信息
	@Override
	public Page<TInhospitalInfo> getPatienInhospitalList(PatientInHospitalNoteListReq req) {
		// TODO Auto-generated method stub
		if(req==null||req.getPatientId()==null)
			throw new EmptyObjectExcption("patientId is null");
		PageHelper.startPage(req.getPage()+1,req.getNum());
		List<TInhospitalInfo> list =inhospitalDao.queryPatientInhospitalInfoByPatientId(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TInhospitalInfo>)list);
	}

	/**
	 * 转科情况添加功能
	 */
	@Override
	public int addInhospitalTurnRecord(List<InhospitalTurnRecord> req) {

		// 判断必填项
		for (InhospitalTurnRecord inhospitalTurnRecord : req) {
			if (inhospitalTurnRecord.getInhospitalId() == null
					|| inhospitalTurnRecord.getPatientId() == null)
				throw new EmptyObjectExcption(
						"param error [InhospitalId] or [PatientId] is null");
		}

		// 取第一条对象的数据，然后删除关联的信息
		inhospitalDao.delInhospitalTurnRecordByPatient(req.get(0));

		// 如果全部删除后，不用再添加数据
		if (req.size() == 1 && req.get(0).getActionFlag() == 3) {
			return 1;
		}

		return inhospitalDao.addInhospitalTurnRecord(req);
	}

	/**
	 * 转科情况删除功能
	 */
	@Override
	public int delInhospitalTurnRecord(List<InhospitalTurnRecord> req) {
		for (InhospitalTurnRecord inhospitalTurnRecord : req) {
			if (inhospitalTurnRecord.getTurnId() == 0)
				throw new EmptyObjectExcption("param error [TurnId] is 0");
		}

		return inhospitalDao.delInhospitalTurnRecord(req);
	}

	/**
	 * 转科情况查询功能
	 */
	@Override
	public List<InhospitalTurnRecord> queryInhospitalTurnRecord(
			InhospitalTurnRecord req) {
		if (req.getInhospitalId() == null || req.getPatientId() == null)
			throw new EmptyObjectExcption(
					"param error [InhospitalId] or [PatientId] is null");

		List<InhospitalTurnRecord> list = inhospitalDao
				.queryInhospitalTurnRecord(req);
		return list;
	}

}
