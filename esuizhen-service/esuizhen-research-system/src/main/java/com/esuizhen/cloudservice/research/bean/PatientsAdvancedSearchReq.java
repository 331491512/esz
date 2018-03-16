/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.research.bean<br/>  
 * <b>文件名：</b>PatientsAdvancedSearchReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月13日下午3:09:48<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.research.bean;

import java.util.List;

import com.westangel.common.bean.search.RetrievalParamentReq;

/** 
* @ClassName: PatientsAdvancedSearchReq
* @Description: 
* @author NiDan
* @date 2016年10月13日下午3:09:48 
*/
public class PatientsAdvancedSearchReq {
	
	private String projectId;
	
	private Long doctorId;
	//是否查询有有效联系方式的患者  1：是  0：否
	private Integer effectiveContactMethodFlag = 0;
	
	private Integer followupStartMark = 0;
	
	private List<RetrievalParamentReq> paraments;
	
	private Integer page;
	
	private Integer num;
	
	public PatientsAdvancedSearchReq(){
		this.page = 0;
		this.num  = 10;
	}

	public String getProjectId() {
		return projectId;
	}

	public Integer getFollowupStartMark() {
		return followupStartMark;
	}

	public void setFollowupStartMark(Integer followupStartMark) {
		this.followupStartMark = followupStartMark;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	
	public List<RetrievalParamentReq> getParaments() {
		return paraments;
	}

	public Integer getEffectiveContactMethodFlag() {
		return effectiveContactMethodFlag;
	}

	public void setEffectiveContactMethodFlag(Integer effectiveContactMethodFlag) {
		this.effectiveContactMethodFlag = effectiveContactMethodFlag;
	}

	public void setParaments(List<RetrievalParamentReq> paraments) {
		this.paraments = paraments;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
