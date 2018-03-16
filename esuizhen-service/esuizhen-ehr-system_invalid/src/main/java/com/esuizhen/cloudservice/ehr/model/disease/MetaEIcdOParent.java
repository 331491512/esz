package com.esuizhen.cloudservice.ehr.model.disease;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title:MetaEIcdOParent</p>
 * <p>Description:ICD-O父器官元数据bean</p>
 * @author YYCHEN
 * @date 2016年6月16日 上午10:31:01
 */
public class MetaEIcdOParent implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键ID
	private Integer organId;
	//器官ID
	private String organCode;
	//器官名
	private String organName;
	//显示名称
	private String showName;
	//创建时间
	private Date createTime;
	
	//子器官列表
	private List<MetaEIcdO> childList;
	
	public List<MetaEIcdO> getChildList() {
		return childList;
	}
	public void setChildList(List<MetaEIcdO> childList) {
		this.childList = childList;
	}
	public Integer getOrganId() {
		return organId;
	}
	public void setOrganId(Integer organId) {
		this.organId = organId;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
}
