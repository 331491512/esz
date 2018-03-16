/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ExpressServiceStateUpdateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日下午2:25:58<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ExpressServiceStateUpdateReq
* @Description: 
* @author lichenghao
* @date 2017年1月6日 下午2:25:58  
*/
public class ExpressServiceStateUpdateReq {
	//住院流水号
	private String inhospitalNo;
	//服务申请号
	private String productApplyId;
	//进行状态
	private Integer state;
	//快递单号
	private String expressNo;
	//原因
	private String cause;
	public String getInhospitalNo() {
		return inhospitalNo;
	}
	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getExpressNo() {
		return expressNo;
	}
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
}
