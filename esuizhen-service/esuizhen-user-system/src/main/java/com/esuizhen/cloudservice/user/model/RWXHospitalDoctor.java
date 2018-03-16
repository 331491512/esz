package com.esuizhen.cloudservice.user.model;

/**
 * 
* @ClassName: RWXHospitalDoctor 
* @Description: 微信默认患者关联医生列表 
* @author LIPENG
* @date 2016年3月3日 下午2:48:06 
*
 */
public class RWXHospitalDoctor {
	private Integer id;
	private Integer hospitalId;
	private Long doctorId;
	private Long doctorUserId;
	private String createTime;
	private String updateTime;
	/** 
	* @return id 
	*/
	public Integer getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Integer id) {
		this.id = id;
	}
	/** 
	* @return hospitalId 
	*/
	public Integer getHospitalId() {
		return hospitalId;
	}
	/** 
	* @param hospitalId 要设置的 hospitalId 
	*/
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	/** 
	* @return doctorId 
	*/
	public Long getDoctorId() {
		return doctorId;
	}
	/** 
	* @param doctorId 要设置的 doctorId 
	*/
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	/** 
	* @return createTime 
	*/
	public String getCreateTime() {
		return createTime;
	}
	/** 
	* @param createTime 要设置的 createTime 
	*/
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/** 
	* @return updateTime 
	*/
	public String getUpdateTime() {
		return updateTime;
	}
	/** 
	* @param updateTime 要设置的 updateTime 
	*/
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/** 
	* @return doctorUserId 
	*/
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	/** 
	* @param doctorUserId 要设置的 doctorUserId 
	*/
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
}
