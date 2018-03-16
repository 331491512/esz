package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultGenenalPhysicalExamination</p>
 * <p>Description:患者体格检查-常规体检结果bean</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:03:05
 */
public class TCrfResultPainScaleInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfPainScaleResultId;
	//Crf结果ID
	private String crfResultId;
	//疼痛系数：取值1~10
	private Integer result;
	//填写日期
	private Date fillDate;
	//创建时间（单据上传时间）
	private Date createTime;
	//更新时间
	private Date updateTime;
	public String getCrfPainScaleResultId() {
		return crfPainScaleResultId;
	}
	public void setCrfPainScaleResultId(String crfPainScaleResultId) {
		this.crfPainScaleResultId = crfPainScaleResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public Date getFillDate() {
		return fillDate;
	}
	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
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
