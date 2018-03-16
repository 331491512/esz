package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: TCrfCourseConf 
* @Description: CRF随访周期信息
* @author YYCHEN
* @date 2016年04月06日 下午16:51:01  
*/
public class TCrfCourseConf implements Serializable {
	private static final long serialVersionUID = 1L;

	//Crf模板Id
	private String crfTemplateId;
	//随访周期起始时间开关
	private Integer followupStartMark;
	//随访周期信息列表
	private List<TCrfCourseConfInfo> crfCourseList;
	
	//随访明细个数
	private Integer courseDetailCount = 0;
	
	public String getCrfTemplateId() {
		return crfTemplateId;
	}
	public void setCrfTemplateId(String crfTemplateId) {
		this.crfTemplateId = crfTemplateId;
	}
	public Integer getFollowupStartMark() {
		return followupStartMark;
	}
	public void setFollowupStartMark(Integer followupStartMark) {
		this.followupStartMark = followupStartMark;
	}
	public List<TCrfCourseConfInfo> getCrfCourseList() {
		return crfCourseList;
	}
	public void setCrfCourseList(List<TCrfCourseConfInfo> crfCourseList) {
		this.crfCourseList = crfCourseList;
	}
	public Integer getCourseDetailCount() {
		return courseDetailCount;
	}
	public void setCourseDetailCount(Integer courseDetailCount) {
		this.courseDetailCount = courseDetailCount;
	}
}
