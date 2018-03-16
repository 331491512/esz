package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultGenenalPhysicalExamination</p>
 * <p>Description:患者体格检查-常规体检结果bean</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:03:05
 */
public class TCrfResultGenenalPhysicalExamination implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfPhysicalExaminationResultId;
	//结果项Id。外键。
	private String crfResultId;
	//检查日期
	private Date checkDate;
	//身高
	private Integer hight;
	//体重指数
	private Float weightLof;
	//心率
	private Integer heartRate;
	//脉搏
	private Integer pulse;
	//体温
	private Float temperature;
	//腰围
	private Float waist;
	//体重
	private Float weight;
	//体表面积
	private Float bodyArea;
	//呼吸
	private Integer breath;
	//血压低压
	private Float bloodLow;
	//血压高压
	private Float bloodHigh;
	//臀围
	private Float hipline;
	//胸围
	private Float bust;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public String getCrfPhysicalExaminationResultId() {
		return crfPhysicalExaminationResultId;
	}
	public void setCrfPhysicalExaminationResultId(String crfPhysicalExaminationResultId) {
		this.crfPhysicalExaminationResultId = crfPhysicalExaminationResultId;
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
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Integer getHight() {
		return hight;
	}
	public void setHight(Integer hight) {
		this.hight = hight;
	}
	public Float getWeightLof() {
		return weightLof;
	}
	public void setWeightLof(Float weightLof) {
		this.weightLof = weightLof;
	}
	public Integer getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}
	public Integer getPulse() {
		return pulse;
	}
	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Float getWaist() {
		return waist;
	}
	public void setWaist(Float waist) {
		this.waist = waist;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getBodyArea() {
		return bodyArea;
	}
	public void setBodyArea(Float bodyArea) {
		this.bodyArea = bodyArea;
	}
	public Integer getBreath() {
		return breath;
	}
	public void setBreath(Integer breath) {
		this.breath = breath;
	}
	public Float getBloodLow() {
		return bloodLow;
	}
	public void setBloodLow(Float bloodLow) {
		this.bloodLow = bloodLow;
	}
	public Float getBloodHigh() {
		return bloodHigh;
	}
	public void setBloodHigh(Float bloodHigh) {
		this.bloodHigh = bloodHigh;
	}
	public Float getHipline() {
		return hipline;
	}
	public void setHipline(Float hipline) {
		this.hipline = hipline;
	}
	public Float getBust() {
		return bust;
	}
	public void setBust(Float bust) {
		this.bust = bust;
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
