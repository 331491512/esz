package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultGenenalPhysicalExamination</p>
 * <p>Description:患者检查结果详情bean</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:03:05
 */
public class TCrfResultExamDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//检查详情结果记录ID
	private String crfExamResultDetailId;
	//检查结果ID
	private String crfExamResultId;
	//检验项目序号
	private Integer seqNo;
	//检查器官编码
	private String organCode;
	//器官
	private String organ;
	//病灶编码
	private String nidusCode;
	//病灶
	private String nidus;
	//1:原发；2：继发
	private Integer nidusSourceFlag;
	//最长径。单位：mm
	private Float longestDiameter;
	//垂直最短径。单位：mm
	private Float shortestDiameter;
	//靶病灶
	private Integer flag;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public String getCrfExamResultDetailId() {
		return crfExamResultDetailId;
	}
	public void setCrfExamResultDetailId(String crfExamResultDetailId) {
		this.crfExamResultDetailId = crfExamResultDetailId;
	}
	public String getCrfExamResultId() {
		return crfExamResultId;
	}
	public void setCrfExamResultId(String crfExamResultId) {
		this.crfExamResultId = crfExamResultId;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getOrgan() {
		return organ;
	}
	public void setOrgan(String organ) {
		this.organ = organ;
	}
	public String getNidusCode() {
		return nidusCode;
	}
	public void setNidusCode(String nidusCode) {
		this.nidusCode = nidusCode;
	}
	public String getNidus() {
		return nidus;
	}
	public void setNidus(String nidus) {
		this.nidus = nidus;
	}
	public Integer getNidusSourceFlag() {
		return nidusSourceFlag;
	}
	public void setNidusSourceFlag(Integer nidusSourceFlag) {
		this.nidusSourceFlag = nidusSourceFlag;
	}
	public Float getLongestDiameter() {
		return longestDiameter;
	}
	public void setLongestDiameter(Float longestDiameter) {
		this.longestDiameter = longestDiameter;
	}
	public Float getShortestDiameter() {
		return shortestDiameter;
	}
	public void setShortestDiameter(Float shortestDiameter) {
		this.shortestDiameter = shortestDiameter;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
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
