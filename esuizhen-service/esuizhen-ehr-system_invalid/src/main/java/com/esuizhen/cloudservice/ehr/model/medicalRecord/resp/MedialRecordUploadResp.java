package com.esuizhen.cloudservice.ehr.model.medicalRecord.resp;

import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.westangel.common.bean.PatientProfileDetailResp;

/**
* @ClassName: MedialRecordUploadResp 
* @Description: 上传病例返回信息
* @author wang_hw
* @date 2015年12月15日 下午5:20:41
 */
public class MedialRecordUploadResp
{
	private EmedicalRecord emrInfo;
	
	private PatientProfileDetailResp patientInfo;

	public EmedicalRecord getEmrInfo()
	{
		return emrInfo;
	}

	public void setEmrInfo(EmedicalRecord emrInfo)
	{
		this.emrInfo = emrInfo;
	}

	public PatientProfileDetailResp getPatientInfo()
	{
		return patientInfo;
	}

	public void setPatientInfo(PatientProfileDetailResp patientInfo)
	{
		this.patientInfo = patientInfo;
	}
	
	
}
