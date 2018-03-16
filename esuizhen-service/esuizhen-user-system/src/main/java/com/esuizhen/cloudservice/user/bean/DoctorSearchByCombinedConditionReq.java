/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>DoctorSearchByCombinedConditionReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月7日上午10:02:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: DoctorSearchByCombinedConditionReq
* @Description: 
* @author lichenghao
* @date 2016年6月7日 上午10:02:32  
*/
public class DoctorSearchByCombinedConditionReq {
	//城市编码
	private String cityCode;
	//病种
	private String tag;
	//查询关键词
	private String keyword;
	//医院Id
	private Integer hospitalId;
	//科室编号
	private Integer deptId;
	//查询用户
	private Long userId;
	//分页索引
	private int page;
	//每页返回个数
	private int num;
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
}
