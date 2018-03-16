/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.westangel.common.bean<br/>  
 * <b>文件名：</b>DoctorPatient.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月14日-下午2:37:05<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: DoctorPatient 
* @Description: 医生与患者关系表
* @author YYCHEN
* @date 2015年12月14日 下午2:37:05  
*/
public class DoctorPatient implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	* 患者编号
	*/
	private Long patientId;
	/**
	 * 患者uuid
	 */
	private String patientUuid;
	/**
	 * 医生编号
	 */
	private Long doctorId;
	
	/**
	 * 医生uuid
	 */
	private String doctorUuid;
	/**
	* 是否有病历
	*/
	private Integer hasMedicalRecord;
	/**
	 * 关注时间
	 */
	private Date attentionTime;
	
	/**
	 * 来源
	 */
	private Integer sourceFlag;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public String getPatientUuid() {
		return patientUuid;
	}

	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}

	public String getDoctorUuid() {
		return doctorUuid;
	}

	public void setDoctorUuid(String doctorUuid) {
		this.doctorUuid = doctorUuid;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getHasMedicalRecord() {
		return hasMedicalRecord;
	}

	public void setHasMedicalRecord(Integer hasMedicalRecord) {
		this.hasMedicalRecord = hasMedicalRecord;
	}

	public Date getAttentionTime() {
		return attentionTime;
	}

	public void setAttentionTime(Date attentionTime) {
		this.attentionTime = attentionTime;
	}

	/**
	 * @return the sourceFlag
	 */
	public Integer getSourceFlag() {
		return sourceFlag;
	}

	/**
	 * @param sourceFlag the sourceFlag to set
	 */
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
