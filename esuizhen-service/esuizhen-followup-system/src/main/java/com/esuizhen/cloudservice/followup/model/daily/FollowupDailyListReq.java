/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.daily;<br/>  
 * <b>文件名：</b>FollowupDailyListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月26日上午11:50:06<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.daily;
/** 
* @ClassName: FollowupDailyListReq
* @Description: 
* @author lichenghao
* @date 2016年5月26日 上午11:50:06  
*/
public class FollowupDailyListReq {
	//医生编号
	private Long doctorId;
	//分页索引
	private int page;
	//每页数量
	private int num;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
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
}
