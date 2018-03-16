package com.esuizhen.cloudservice.user.bean.followuppatient;

import java.util.List;

import com.westangel.common.bean.search.RetrievalParamentReq;

public class PatientSeniorScreenReq {
	//操作人
	private Long operator;
	//是否展示无联系方式的患者
	private Integer needContactFlag;
	//最近随访人员
	private Long latestOperator;
	//随访周期
	private Integer followupCycle;
	//高级检索
	private List<RetrievalParamentReq> paraments;
	
	/**
     * 失访标示,用来标示是全部患者还是失访患者。全部患者不传，失访患者传2
     */
    private Integer followupFlag;
    /**
     * 用户角色
     */
    private Integer userRole;
    
    private Integer hospitalId;
    /**
  	 * 编目状态
  	 */
  	private Integer catalogState;
  	/**
  	 * 编目后更新
  	 */
  	private Integer catalogWithUpdate;
    
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public Integer getNeedContactFlag() {
		return needContactFlag;
	}
	public void setNeedContactFlag(Integer needContactFlag) {
		this.needContactFlag = needContactFlag;
	}
	public Long getLatestOperator() {
		return latestOperator;
	}
	public void setLatestOperator(Long latestOperator) {
		this.latestOperator = latestOperator;
	}
	public Integer getFollowupCycle() {
		return followupCycle;
	}
	public void setFollowupCycle(Integer followupCycle) {
		this.followupCycle = followupCycle;
	}
	public List<RetrievalParamentReq> getParaments() {
		return paraments;
	}
	public void setParaments(List<RetrievalParamentReq> paraments) {
		this.paraments = paraments;
	}
	public Integer getFollowupFlag() {
		return followupFlag;
	}
	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getCatalogState() {
		return catalogState;
	}
	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}
	public Integer getCatalogWithUpdate() {
		return catalogWithUpdate;
	}
	public void setCatalogWithUpdate(Integer catalogWithUpdate) {
		this.catalogWithUpdate = catalogWithUpdate;
	}
}
