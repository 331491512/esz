/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ProductServiceStateCheckReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月28日上午10:18:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ProductServiceStateCheckReq
* @Description: 服务是否开通
* @author lichenghao
* @date 2015年12月28日 上午10:18:53  
*/
public class ProductServiceStateCheckReq {
	
	//产品类型 1:图文咨询；2:电话咨询；3:预约挂号；4:MDT（专家组会诊);5: 私人医生
	private Integer productType;
	//医生ID
	private Long doctroId;
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public Long getDoctroId() {
		return doctroId;
	}
	public void setDoctroId(Long doctroId) {
		this.doctroId = doctroId;
	}
}
