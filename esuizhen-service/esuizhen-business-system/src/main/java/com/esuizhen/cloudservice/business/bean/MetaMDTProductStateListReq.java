package com.esuizhen.cloudservice.business.bean;
/** 
 * @ClassName: MetaMDTProductStateListReq.java
 * @Description:  MDT产品元数据
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public class MetaMDTProductStateListReq {

	private Integer mdtFlowStateId;
	private String mdtFlowStateName;
	private String showName;
	private Integer sortIndex;
	
	public Integer getMdtFlowStateId() {
		return mdtFlowStateId;
	}
	public void setMdtFlowStateId(Integer mdtFlowStateId) {
		this.mdtFlowStateId = mdtFlowStateId;
	}
	public String getMdtFlowStateName() {
		return mdtFlowStateName;
	}
	public void setMdtFlowStateName(String mdtFlowStateName) {
		this.mdtFlowStateName = mdtFlowStateName;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public Integer getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}
	
	
}
