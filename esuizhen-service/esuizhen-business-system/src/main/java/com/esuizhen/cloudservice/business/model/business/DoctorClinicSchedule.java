/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>DoctorClinicSchedule.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午3:38:08<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;

/**
 * @ClassName: DoctorClinicSchedule.java
 * @Description: 医生门诊时间实体
 * @author lichenghao
 * @date 2015年12月12日 下午3:38:08
 */
public class DoctorClinicSchedule {
	
	/**
	 * 门诊编号
	 */
	private Long id;
	
	/**
	 * 医生编号
	 */
	private Long DoctorId;
	
	/**
	 * 医院编号
	 */
	private Long hospitalId;
	
	/**
	 * 值班日
	 */
	private int clinicDay;
	
	/**
	 * 门诊类别, 费用。中间逗号分隔 上中晚
	 */
	private String moningSchedule;
	
	private String afternoonSchedule;
	
	private String eveningSchedule;
	
	/**
	 * 记录时间
	 */
	private Date createTime;
	
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(Long doctorId) {
		DoctorId = doctorId;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public int getClinicDay() {
		return clinicDay;
	}

	public void setClinicDay(int clinicDay) {
		this.clinicDay = clinicDay;
	}

	public String getMoningSchedule() {
		return moningSchedule;
	}

	public void setMoningSchedule(String moningSchedule) {
		this.moningSchedule = moningSchedule;
	}

	public String getAfternoonSchedule() {
		return afternoonSchedule;
	}

	public void setAfternoonSchedule(String afternoonSchedule) {
		this.afternoonSchedule = afternoonSchedule;
	}

	public String getEveningSchedule() {
		return eveningSchedule;
	}

	public void setEveningSchedule(String eveningSchedule) {
		this.eveningSchedule = eveningSchedule;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
