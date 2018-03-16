package com.esuizhen.cloudservice.sync.txservice;

import java.util.List;

import com.esuizhen.cloudservice.sync.bean.TDetectionReportSync;
import com.esuizhen.cloudservice.sync.bean.TExamReportSync;
import com.esuizhen.cloudservice.sync.bean.TPatientDiagnosisNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;
import com.westangel.common.excption.RejectRequestExcption;

public interface TxDiagnosisInfoService {
	/**
	 * <p>Title:syncDiagnosisInfo</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月17日 上午11:24:46
	 * @param diagnosisNoteDetailInfo
	 * @return
	 */
	public DiagnosisInfo syncDiagnosisInfo(TPatientDiagnosisNoteDetailInfo diagnosisNoteDetailInfo);
	
	/**
	 * <p>Title:implementExamReportCoudSync</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月13日 下午5:07:47
	 * @param tExamReportSync
	 * @throws RejectRequestExcption
	 */
	public void implementExamReportCoudSync(TExamReportSync tExamReportSync) throws RejectRequestExcption;
	
	/**
	 * <p>Title:implementDetectionReportCloudSync</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月13日 下午5:07:51
	 * @param detectionReportSync
	 * @param failds
	 * @throws RejectRequestExcption
	 */
	public void implementDetectionReportCloudSync(TDetectionReportSync detectionReportSync, List<Object> failds) throws RejectRequestExcption;

	public boolean mergeDiagnosisInfo(String patientFinalUuid, Long patientId);
}
