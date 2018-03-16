/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TReportProfile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午11:32:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/** 
* @ClassName: TReportProfile
* @Description: 报告基本信息
* @author lichenghao
* @date 2016年5月3日 上午11:32:53  
*/
public class TReportSimpleInfo {
	
	//报告Id
	private String reportId;
	//申请时间
	private Date applyTime;
	//报告类型 1: 检查报告 2: 检验报告
	private Integer reportType;
	//检查内容
	private String inspectionContent;
	
	
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	public Integer getReportType() {
		return reportType;
	}
	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}
	public String getInspectionContent() {
		return inspectionContent;
	}
	public void setInspectionContent(String inspectionContent) {
		this.inspectionContent = inspectionContent;
	}
}
