/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ReportPatientStatisLiistGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月14日下午4:01:26<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ReportPatientStatisLiistGetReq
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午4:01:26  
*/
public class ReportPatientStatisLiistGetReq {
	private int page;
	private int num;
	private String statisBatchId;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStatisBatchId() {
		return statisBatchId;
	}
	public void setStatisBatchId(String statisBatchId) {
		this.statisBatchId = statisBatchId;
	}
}
