package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

/**
* @ClassName: EmedicalPhotoOcrs 
* @Description: OCR数据实体
* @author wang_hw
* @date 2015年12月15日 上午11:13:24
 */
public class EmedicalPhotoOcrs{
	
	/**
	 * 标识。主键
	 */
	private String emrPhotoId;
	/**
	 * 电子病历ID
	 */
	private String emrId;
	/**
	 * OCR申请。0：否（默认）；1：是
	 */
	private Integer ocrApply=0;
	/**
	 * OCR识别标识。0: 识别；1：已识别
	 */
	private Integer ocrFlag;
	/**
	 * 单据/拍照 原始文件URL
	 */
	private String picFileUrl;
	/**
	 * 结构化数据的平面文本显示格式。ocrFlag =1时有效。 1：普通txt文本 2：xml格式文本 3：html格式文本 4: 内容为一个url地址，指向一个html文件。
	 */
	private Integer plainContentType;
	/**
	 * 平面文本内容。如果是url地址，则客户端通过访问此地址进行显示。
	 */
	private String plainContent;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public void setEmrPhotoId(String value) {
		this.emrPhotoId = value;
	}
	
	public String getEmrPhotoId() {
		return this.emrPhotoId;
	}
	public void setEmrId(String value) {
		this.emrId = value;
	}
	
	public String getEmrId() {
		return this.emrId;
	}
	public void setOcrApply(Integer value) {
		this.ocrApply = value;
	}
	
	public Integer getOcrApply() {
		return this.ocrApply;
	}
	public void setOcrFlag(Integer value) {
		this.ocrFlag = value;
	}
	
	public Integer getOcrFlag() {
		return this.ocrFlag;
	}
	public void setPicFileUrl(String value) {
		this.picFileUrl = value;
	}
	
	public String getPicFileUrl() {
		return this.picFileUrl;
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


}

