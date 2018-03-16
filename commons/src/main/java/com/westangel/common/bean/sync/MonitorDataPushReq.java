/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.sync;<br/>  
 * <b>文件名：</b>MonitorDataPushReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月19日下午4:03:22<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.sync;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: MonitorDataPushReq
* @Description: 
* @author lichenghao
* @date 2017年7月19日 下午4:03:22  
*/
public class MonitorDataPushReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List clientTempDataMonitor;
	private List clientFormalDataMonitor;
	private List clientSyncDataMonitor;
	
	public List getClientTempDataMonitor() {
		return clientTempDataMonitor;
	}





	public void setClientTempDataMonitor(List clientTempDataMonitor) {
		this.clientTempDataMonitor = clientTempDataMonitor;
	}





	public List getClientFormalDataMonitor() {
		return clientFormalDataMonitor;
	}





	public void setClientFormalDataMonitor(List clientFormalDataMonitor) {
		this.clientFormalDataMonitor = clientFormalDataMonitor;
	}





	public List getClientSyncDataMonitor() {
		return clientSyncDataMonitor;
	}





	public void setClientSyncDataMonitor(List clientSyncDataMonitor) {
		this.clientSyncDataMonitor = clientSyncDataMonitor;
	}





	public static void main(String[] args) {
		String strs = "monitorDate,hospitalId,hospitalName,remark,doctorSyncAdd,doctorSyncAddSuccess,doctorSyncAddFail,doctorSyncAddHandle,doctorNotSyncAdd,doctoSyncUpdate,doctorNotSyncUpdate,patientSimilar,patientSyncAdd,patientSyncAdddSuccess,patientSyncAddFail,patientSyncAddHandle,patientNotSyncAdd,patientSyncUpdate,patientNotSyncUpdate,patientNoSimilar,patientNoSyncAdd,patientNoSyncAddSuccess,patientNoSyncAddFail,patientNoSyncAddHandle,patientNoNotSyncAdd,patientFamilySimilar,patientFamilySyncAdd,patientFamilySyncAddSuuccess,patientFamilySyncAddFail,patientFamilySyncAddHandle,patientFamilyNotSyncAdd,patientFamilySyncUpdat,patientFamilyNotSyncUpdate,doctorPatientSimilar,doctorPatientSyncAdd,doctorPatientSyncAddSuccess,doctorPatientSyncAddFail,doctorPatientSyncAddHandle,doctorPatientNotSyncAdd,doctorPatientSyncUpdate,doctorPatientNotSyncUpdate,deptPatientSimilar,deptPatientSyncAdd,deptPatientSyncAddSuccess,deptPatientSyncAddFail,deptPatientSyncAddHandle,deptPatientNotSyncAdd,inhospitaSimilar,inhospitalSyncAdd,inhospitalSyncAddSuccess,inhospitalSyncAddFail,inhospitalSyncAddHandle,inhospitalNotSyncAdd,inhospitalSyncUpdate,inhospitalNotSyncUpdate,diagnosisSimilar,diagnosisSyncAdd,diagnosisSyncAddSuccess,diagnosisiSyncAddFail,diagnosisSyncAddHandle,diagnosisNotSyncAdd,surgerySimilar,surgerySyncAdd,surgerySyncAddSuccess,surgerySyncAddFail,surgerySyncAddHandle,surgeryNotSyncAdd,radiationSimilar,radiationSyncAdd,radiationSyncAddSuccess,radiationSyncAddFail,radiationSyncAddHandle,radiationNotSyncAdd,chemotherapySimilar,chemotherapySyncAdd,chemotherapySyncAddSuccess,chemotherapySyncAddFalil,chemotherapySyncAddHandle,chemotherapyNotSyncAdd,treatmentSimilar,treatmentSyncAdd,treatmentSyncAddSuccess,treatmentSyncAddFail,treatmentSyncAddHandle,treatmentNotSyncAdd,outhospitalSimilar,outhospitalSyncAdd,outhospitalSyncAddSuccess,outhospitalSyncAddFail,outhospitalSyncAddHandle,outhospitalNotSyncAdd,clinicMedicalSimilar,clinicMedicalSyncAdd,clinicMedicalSyncAddSuccess,clinicMedicalSyncAddFail,clinicMedicalSyncAddHandle,clinicMedicalNotSyncAdd,examReportSimilar,examReportSyncAdd,examReportSyncAddSuccess,examReportSyncAddFail,examReportSyncAddHandle,examReportNotSyncAdd,detectionReportSimilar,detectionRepotSyncAdd,detectionReportSyncAddSuccess,detectionReportSyncAddFail,detectionReportSyncAddHandle,detectionReportNotSyncAdd,detectionDetailSimilar,detectionDetailSyncAdd,detectionDetailSyncAddSuccess,detectionDetailSyncAddFail,detectionDetailSyncAddHandle,detectionDetailNotSyncAdd,followupResultSimilar,followupResultSyncAdd,followupResultSyncAddSuccess,followupResultSyncAddFail,followupResultSyncAddHandle,followupResultNotSyncAdd,followupResultSyncUpdate,followupResultNotSyncUpdate,followupResultBuffSimilar,followupResultBuffSyncAdd,followupResultBuffSyncAddSuccess,followupResultBuffSyncAddFail,followupResultBuffSyncAddHandle,followupResultBuffNotSyncAdd,followupResultBuffSyncUpdate,followupResultBuffNotSyncUpdate,createTime,updateTime";
		for(String str:strs.split(",")){
//			System.out.print("#{"+str+"},");
			System.out.println(str+"=VALUES("+str+"),");
		}
	}
}
