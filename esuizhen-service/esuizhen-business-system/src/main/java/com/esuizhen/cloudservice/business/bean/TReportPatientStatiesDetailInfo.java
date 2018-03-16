/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TitemInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月14日下午4:22:19<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: TitemInfo
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午4:22:19  
*/
public class TReportPatientStatiesDetailInfo {
	private String trueName;
	private String pictureUrl;
	private String linkUrl;
	private Integer exceptionFlag;
	private Integer examReportNum;
	private Integer detectionReportNum;
	private String reportName;
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getExceptionFlag() {
		return exceptionFlag;
	}
	public void setExceptionFlag(Integer exceptionFlag) {
		this.exceptionFlag = exceptionFlag;
	}
	public Integer getExamReportNum() {
		return examReportNum;
	}
	public void setExamReportNum(Integer examReportNum) {
		this.examReportNum = examReportNum;
	}
	public Integer getDetectionReportNum() {
		return detectionReportNum;
	}
	public void setDetectionReportNum(Integer detectionReportNum) {
		this.detectionReportNum = detectionReportNum;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
}
