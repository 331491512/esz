/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ReviewAlertStatisReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年9月22日下午2:17:23<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ReviewAlertStatisReq
* @Description: 
* @author lichenghao
* @date 2017年9月22日 下午2:17:23  
*/
public class ReviewAlertStatisReq {
	private Long doctorId;
	private Integer domain;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getDomain() {
		return domain;
	}
	public void setDomain(Integer domain) {
		this.domain = domain;
	}
}
