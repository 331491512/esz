package com.esuizhen.cloudservice.sync.service;

import java.util.List;

import com.esuizhen.cloudservice.sync.bean.PacAndLisResp;
import com.esuizhen.cloudservice.sync.bean.TDetectionReportSync;
import com.esuizhen.cloudservice.sync.bean.TExamReportSync;
import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.HospitalWithoutRightExcption;

public interface DiagnosisInfoService {
	/**
	 * 
	 * @param diagnosisNoteDetailInfo
	 * @return
	 * @throws HospitalWithoutRightExcption 
	 */
	public MedicalRecord syncDiagnosisInfo(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo) throws HospitalWithoutRightExcption;

	/**
	 * <p>Title:examReportCoudSync</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月6日 下午4:42:37
	 * @param examReportList
	 * @return
	 * @throws HospitalWithoutRightExcption 
	 */
	public PacAndLisResp examReportCoudSync(List<TExamReportSync> examReportList) throws HospitalWithoutRightExcption;

	/**
	 * <p>Title:detectionReportCloudSync</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月6日 下午4:42:57
	 * @param detectionReportSyncList
	 * @return
	 * @throws HospitalWithoutRightExcption 
	 */
	public PacAndLisResp detectionReportCloudSync(List<TDetectionReportSync> detectionReportSyncList) throws HospitalWithoutRightExcption;
}
