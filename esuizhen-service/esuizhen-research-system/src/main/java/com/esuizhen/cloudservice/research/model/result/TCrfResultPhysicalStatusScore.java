package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultGenenalPhysicalExamination</p>
 * <p>Description:患者身体状况评分结果bean</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:03:05
 */
public class TCrfResultPhysicalStatusScore implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfScoreResultId;
	//结果项Id。外键
	private String crfResultId;
	//检查日期
	private Date checkDate;
	//观察项
	private String subjectElementId;
	//KPS或ECOG评分
	private Integer score;
	//是否肿瘤死亡。1：是；0否。
	private Integer isTumourDeath;
	//死亡时间
	private Date deathDate;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public String getCrfScoreResultId() {
		return crfScoreResultId;
	}
	public void setCrfScoreResultId(String crfScoreResultId) {
		this.crfScoreResultId = crfScoreResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}
	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}
	public Date getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public String getSubjectElementId() {
		return subjectElementId;
	}
	public void setSubjectElementId(String subjectElementId) {
		this.subjectElementId = subjectElementId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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
