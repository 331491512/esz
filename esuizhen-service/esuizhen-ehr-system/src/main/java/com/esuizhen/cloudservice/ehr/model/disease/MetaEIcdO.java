package com.esuizhen.cloudservice.ehr.model.disease;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:MetaEIcdOParent</p>
 * <p>Description:ICD-O器官元数据bean</p>
 * @author YYCHEN
 * @date 2016年6月16日 上午10:31:01
 */
public class MetaEIcdO implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键ID
	private Integer organId;
	//器官编码
	private String organCode;
	//器官名
	private String organName;
	//创建时间
	private Date createTime;
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
}
