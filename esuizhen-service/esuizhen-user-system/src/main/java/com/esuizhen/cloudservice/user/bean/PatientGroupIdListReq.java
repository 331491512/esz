/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>PatientGroupIdListResp.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日下午3:55:42<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: PatientGroupIdListResp
* @Description: 
* @author lichenghao
* @date 2016年5月18日 下午3:55:42  
*/
public class PatientGroupIdListReq {
	
	//医生编号
	private Long doctorId;
	//自定义分组编号
	private String groupNo;
	//病种分组编号
	private Integer groupId;
	//分组类型
	private Integer groupWay;
	//分组页码
	private int page;
	//医生级别
	private Integer doctorLevel;
	//分组个数
	private int num;
	
	public String sql;
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getGroupWay() {
		return groupWay;
	}
	public void setGroupWay(Integer groupWay) {
		this.groupWay = groupWay;
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
	public Integer getDoctorLevel()
	{
		return doctorLevel;
	}
	public void setDoctorLevel(Integer doctorLevel)
	{
		this.doctorLevel = doctorLevel;
	}
	public String getSql() {
		return sql;
	}
}
