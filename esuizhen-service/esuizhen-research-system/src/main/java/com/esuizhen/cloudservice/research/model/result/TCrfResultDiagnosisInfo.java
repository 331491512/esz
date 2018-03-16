package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultBasicAllergies</p>
 * <p>Description:诊断信息结果bean</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:23:44
 */
public class TCrfResultDiagnosisInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private String crfDiagnosisResultId;
	//结果项Id
	private String crfResultId;
	//诊断类型
	private String diagnosisType;
	//诊断类别
	private String diagnosisCategory;
	//诊断名称
	private String diagnosisName;
	//诊断分期
	private String diagnosisStages;
	//诊断部位
	private Integer diagnosisBodyPart;
	//诊断医院
	private String diagnosisHospital;
	//诊断日期
	private Date diagnosisDate;
	//诊断编码
	private String diagnosisCode;
	//诊断依据
	private String diagnosisBasic;
	//肿瘤并发症
	private String diagnosisConcurrentDisease;
	//肿瘤合发症
	private String diagnosisHofaDisease;
	//伴随疾病
	private String diagnosisWithDisease;
	//中医诊断
	private String chineseMedicineDisease;
	//中医症候
	private String chineseSymptom;
	//排序索引
	private Integer index;
	//记录创建时间。
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getChineseSymptom() {
		return chineseSymptom;
	}
	public void setChineseSymptom(String chineseSymptom) {
		this.chineseSymptom = chineseSymptom;
	}
	public String getCrfDiagnosisResultId() {
		return crfDiagnosisResultId;
	}
	public void setCrfDiagnosisResultId(String crfDiagnosisResultId) {
		this.crfDiagnosisResultId = crfDiagnosisResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public String getDiagnosisType() {
		return diagnosisType;
	}
	public void setDiagnosisType(String diagnosisType) {
		this.diagnosisType = diagnosisType;
	}
	public String getDiagnosisCategory() {
		return diagnosisCategory;
	}
	public void setDiagnosisCategory(String diagnosisCategory) {
		this.diagnosisCategory = diagnosisCategory;
	}
	public String getDiagnosisName() {
		return diagnosisName;
	}
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}
	public String getDiagnosisStages() {
		return diagnosisStages;
	}
	public void setDiagnosisStages(String diagnosisStages) {
		this.diagnosisStages = diagnosisStages;
	}
	public Integer getDiagnosisBodyPart() {
		return diagnosisBodyPart;
	}
	public void setDiagnosisBodyPart(Integer diagnosisBodyPart) {
		this.diagnosisBodyPart = diagnosisBodyPart;
	}
	public String getDiagnosisHospital() {
		return diagnosisHospital;
	}
	public void setDiagnosisHospital(String diagnosisHospital) {
		this.diagnosisHospital = diagnosisHospital;
	}
	public Date getDiagnosisDate() {
		return diagnosisDate;
	}
	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}
	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
	public String getDiagnosisBasic() {
		return diagnosisBasic;
	}
	public void setDiagnosisBasic(String diagnosisBasic) {
		this.diagnosisBasic = diagnosisBasic;
	}
	public String getDiagnosisConcurrentDisease() {
		return diagnosisConcurrentDisease;
	}
	public void setDiagnosisConcurrentDisease(String diagnosisConcurrentDisease) {
		this.diagnosisConcurrentDisease = diagnosisConcurrentDisease;
	}
	public String getDiagnosisHofaDisease() {
		return diagnosisHofaDisease;
	}
	public void setDiagnosisHofaDisease(String diagnosisHofaDisease) {
		this.diagnosisHofaDisease = diagnosisHofaDisease;
	}
	public String getDiagnosisWithDisease() {
		return diagnosisWithDisease;
	}
	public void setDiagnosisWithDisease(String diagnosisWithDisease) {
		this.diagnosisWithDisease = diagnosisWithDisease;
	}
	public String getChineseMedicineDisease() {
		return chineseMedicineDisease;
	}
	public void setChineseMedicineDisease(String chineseMedicineDisease) {
		this.chineseMedicineDisease = chineseMedicineDisease;
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
