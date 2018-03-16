package com.westangel.common.bean.ehr;

import java.io.Serializable;
import java.util.List;
/**
 * 
* @ClassName: TSyncDiagnosisInfo 
* @Description: 同步疾病信息 
* @author LIPENG
* @date 2016年3月1日 下午1:50:53 
*
 */
public class TSyncDiagnosisInfo implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	private Long patientId;
	private String patientNo;
	private Integer hospitalId;
	private List<String> diagnosis;
	/** 
	* @return patientId 
	*/
	public Long getPatientId() {
		return patientId;
	}
	/** 
	* @param patientId 要设置的 patientId 
	*/
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	/** 
	* @return patientNo 
	*/
	public String getPatientNo() {
		return patientNo;
	}
	/** 
	* @param patientNo 要设置的 patientNo 
	*/
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	/** 
	* @return hospital 
	*/
	public Integer getHospitalId() {
		return hospitalId;
	}
	/** 
	* @param hospital 要设置的 hospital 
	*/
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	/** 
	* @return diagnosis 
	*/
	public List<String> getDiagnosis() {
		return diagnosis;
	}
	/** 
	* @param diagnosis 要设置的 diagnosis 
	*/
	public void setDiagnosis(List<String> diagnosis) {
		this.diagnosis = diagnosis;
	}
}
