/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TDoctorAnnouncement.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月13日下午7:15:12<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.List;

import com.esuizhen.cloudservice.business.model.business.DoctorAnnouncement;

/**
 * @ClassName: TDoctorAnnouncement.java
 * @Description: 医生公告拓展
 * @author lichenghao
 * @date 2015年12月13日 下午7:15:12
 */
public class TDoctorAnnouncement {
	/**
	 * 医生编号
	 */
	private Long doctorId;

	/**
	 * 医院编号
	 */
	private Long hospitalId;

	/**
	 * 公告内容
	 */
	private String announcementContent;

	/**
	 * 患者数组
	 */
	private List<Long> patients;

	/**
	 * 公告编号
	 */
	private Integer[] announcements;

	/**
	 * 发布类型。1:发布到主页；2:发布给患者
	 */
	private Integer publishType = 2;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getAnnouncementContent() {
		return announcementContent;
	}

	public List<Long> getPatients() {
		return patients;
	}

	public void setPatients(List<Long> patients) {
		this.patients = patients;
	}

	public Integer[] getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Integer[] announcements) {
		this.announcements = announcements;
	}

	public Integer getPublishType() {
		return publishType;
	}

	public void setPublishType(Integer publishType) {
		this.publishType = publishType;
	}
	
	public void setDoctorAnnmouncement(DoctorAnnouncement announcement){
		announcement.setAnnouncement(this.announcementContent);
		announcement.setDoctorId(this.getDoctorId());
	}
	
	public void setAnnouncementContent(String announcementContent){
		this.announcementContent = announcementContent;
	}
}
