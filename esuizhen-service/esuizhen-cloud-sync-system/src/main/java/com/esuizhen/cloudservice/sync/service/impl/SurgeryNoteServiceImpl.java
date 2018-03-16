package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.dao.incre.IncreSurgeryNoteDao;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.SurgeryNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxSurgeryNoteService;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.GeneralUtil;

/**
 * 
 * @author YYCHEN
 *
 */
@Service
public class SurgeryNoteServiceImpl implements SurgeryNoteService {
	@Autowired
	private IncreSurgeryNoteDao increSurgeryNoteDao;

	@Autowired
	private TxSurgeryNoteService txSurgeryNoteService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	/**
	 * { 
			"emrNo":"8768”, 
			"patientUuid”:”asdfegege1965641654”,
			"surgeryName ":"两支血管的操作",
			"surgeryDate ":"2015-09-08 09:06:06"，
			"anesthesiaDoctorUuid":”asdfegege1965641654”，
			"surgeryAssistant1Uuid":”asdfegege1965641654”,
			"surgeryAssistant2Uuid":”asdfegege1965641654”,
			"anesthesiaWay":” 全麻”，
			"surgeryDoctorUuid":”asdfegege1965641654”, 
			"hospitalId ":15
		}
	 * @param surgeryInfo
	 * @return
	 * @throws RejectRequestExcption 
	 * @throws HospitalWithoutRightExcption 
	 */
	@Transactional
	@Override
	public MedicalRecord syncSurgery(TPatientSurgeryNoteDetailInfo surgeryInfo) throws RejectRequestExcption, HospitalWithoutRightExcption {
		if(surgeryInfo==null||!checkBeforeSyncService.checkHospitalId(surgeryInfo.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		//将数据保存到增量数据库
		this.savePatientSurgeryNoteDetailInfoToIncre(surgeryInfo);
		
		return this.txSurgeryNoteService.syncSurgery(surgeryInfo);
	}
	/**
	 * 
	 * @param surgeryInfo
	 * @return
	 */
	private boolean savePatientSurgeryNoteDetailInfoToIncre(TPatientSurgeryNoteDetailInfo surgeryInfo){
		//电子病历//add by fanpanwei 适应230
		if(StringUtils.isBlank(surgeryInfo.getEmrId()))
		surgeryInfo.setEmrId(GeneralUtil.generatorUUID("EMRI"));
		//手术信息//add by fanpanwei 适应230
		if(StringUtils.isBlank(surgeryInfo.getSurgeryId()))
		surgeryInfo.setSurgeryId(GeneralUtil.generatorUUID("ESUR"));
		this.increSurgeryNoteDao.insert(surgeryInfo.createSurgeryNote());
		return true;
	}

}
