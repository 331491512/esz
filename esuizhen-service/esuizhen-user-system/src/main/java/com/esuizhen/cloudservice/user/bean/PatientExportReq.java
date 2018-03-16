/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>PatientExportReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月30日上午8:02:41<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: PatientExportReq
* @Description: 
* @author lichenghao
* @date 2016年8月30日 上午8:02:41  
*/
public class PatientExportReq {
	/**
	 * 查询Id
	 */
	private Integer searchId;
	/**
	 * 文件名称
	 */
	private String title;
	/**
	 * 导出模版名称
	 */
	private String exportTemplateId;
	public String outFilePath;
	private String num;
	/**
	 * 导出列表 0 全部患者  1 随访患者
	 */
	private Integer reqFlag;
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExportTemplateId() {
		return exportTemplateId;
	}
	public void setExportTemplateId(String exportTemplateId) {
		this.exportTemplateId = exportTemplateId;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
}
