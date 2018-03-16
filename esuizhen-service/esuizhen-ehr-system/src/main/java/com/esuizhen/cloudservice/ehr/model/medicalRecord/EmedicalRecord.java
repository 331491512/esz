package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;
import java.util.List;

/**
* @ClassName: EmedicalRecord 
* @Description: 电子病例实体 
* @author wang_hw
* @date 2015年12月15日 上午11:08:49
 */
public class EmedicalRecord{
	
	/**
	 * emrId
	 */
	private String emrId;
	/**
	 * 电子病历登记号
	 */
	private String emrNo;
	/**
	 * 数据更新索引。通过此字段与客户端保持增量更新。全局唯一
	 */
	private Long cacheIndex;
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 病案号
	 */
	private String patientNo;
	/**
	 * 用户全局唯一标识
	 */
	private String uuid;
	/**
	 * 病历类型。1：门（急）诊诊疗记录2：住院诊疗记录3：健康体检记录4：转诊（院）记录5：法定医学证明和报告9：其他
	 */
	private Integer emrType;
	/**
	 * 病历子类型。0~99
	 */
	private Integer emrSubType;
	
	/**
	 * 病例子类型名称
	 */
	private String emrSubTypeName;
	
	/**
	 * 细分类型。emrSubType =2时：1：细胞学检查2：病理学检查3：医学影像学检查9：其他检查
	 */
	private Integer subdivision;
	/**
	 * 描述、备注
	 */
	private String remark;
	/**
	 * 创建人ID
	 */
	private Long creatorId;
	
	/**
	 * 创建人姓名
	 */
	private String creatorName;
	/**
	 * 就诊医院ID
	 */
	private Integer hospitalId;
	/**
	 * 数据来源标识
	 */
	private Integer sourceFlag;
	/**
	 * 结构化标识:0：未结构化（原始拍照单据）1：已结构化（如从医院HIS数据表同步
	 */
	private Integer structFlag;
	/**
	 * 结构化数据的平面文本显示格式。structFlag=1时有效。1：普通txt文本2：xml格式文本3：html格式文本4: 内容为一个url地址，指向一个html文件。
	 */
	private Integer plainContentType;
	/**
	 * 平面文本内容
	 */
	private String plainContent;
	/**
	 * 可见标识。1：仅患者本人可见2：仅所属医生可见3：患者和所属医生可见（默认）4: 本医院可见
	 */
	private Integer visibleFlag;
	/**
	 * 医疗记录发生时间、就诊时间（实际发生时间）
	 */
	private Date visitTime;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	/**
	 * OCR图片列表
	 */
	private List<EmedicalPhotoOcrs> medicalPicInfoList;
	
	/**
	 * 是否新上传
	 * 0或null：是新上传；
	 * 1：续传；
	 */
	private Integer repeat;

	public void setEmrId(String value) {
		this.emrId = value;
	}
	
	public String getEmrId() {
		return this.emrId;
	}
	public void setEmrNo(String value) {
		this.emrNo = value;
	}
	
	public String getEmrNo() {
		return this.emrNo;
	}
	public void setCacheIndex(Long value) {
		this.cacheIndex = value;
	}
	
	public Integer getRepeat() {
		return repeat;
	}

	public void setRepeat(Integer repeat) {
		this.repeat = repeat;
	}

	public Long getCacheIndex() {
		return this.cacheIndex;
	}
	public void setPatientId(Long value) {
		this.patientId = value;
	}
	
	public Long getPatientId() {
		return this.patientId;
	}
	public void setPatientNo(String value) {
		this.patientNo = value;
	}
	
	public String getPatientNo() {
		return this.patientNo;
	}
	public void setUuid(String value) {
		this.uuid = value;
	}
	
	public String getUuid() {
		return this.uuid;
	}
	public void setEmrType(Integer value) {
		this.emrType = value;
	}
	
	public Integer getEmrType() {
		return this.emrType;
	}
	public void setEmrSubType(Integer value) {
		this.emrSubType = value;
	}
	
	public Integer getEmrSubType() {
		return this.emrSubType;
	}
	public void setSubdivision(Integer value) {
		this.subdivision = value;
	}
	
	public Integer getSubdivision() {
		return this.subdivision;
	}
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
	}
	public void setCreatorId(Long value) {
		this.creatorId = value;
	}
	
	public Long getCreatorId() {
		return this.creatorId;
	}
	public void setHospitalId(Integer value) {
		this.hospitalId = value;
	}
	
	public Integer getHospitalId() {
		return this.hospitalId;
	}
	public void setSourceFlag(Integer value) {
		this.sourceFlag = value;
	}
	
	public Integer getSourceFlag() {
		return this.sourceFlag;
	}
	public void setStructFlag(Integer value) {
		this.structFlag = value;
	}
	
	public Integer getStructFlag() {
		return this.structFlag;
	}
	public void setPlainContentType(Integer value) {
		this.plainContentType = value;
	}
	
	public Integer getPlainContentType() {
		return this.plainContentType;
	}
	public void setPlainContent(String value) {
		this.plainContent = value;
	}
	
	public String getPlainContent() {
		return this.plainContent;
	}
	public void setVisibleFlag(Integer value) {
		this.visibleFlag = value;
	}
	
	public Integer getVisibleFlag() {
		return this.visibleFlag;
	}
	public void setVisitTime(Date value) {
		this.visitTime = value;
	}
	
	public Date getVisitTime() {
		return this.visitTime;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public String getCreatorName()
	{
		return creatorName;
	}

	public void setCreatorName(String creatorName)
	{
		this.creatorName = creatorName;
	}

	public List<EmedicalPhotoOcrs> getMedicalPicInfoList()
	{
		return medicalPicInfoList;
	}

	public void setMedicalPicInfoList(List<EmedicalPhotoOcrs> medicalPicInfoList)
	{
		this.medicalPicInfoList = medicalPicInfoList;
	}

	public String getEmrSubTypeName()
	{
		return emrSubTypeName;
	}

	public void setEmrSubTypeName(String emrSubTypeName)
	{
		this.emrSubTypeName = emrSubTypeName;
	}

	

}

