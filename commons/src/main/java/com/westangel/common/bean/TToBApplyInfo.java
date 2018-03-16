/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean;<br/>  
 * <b>文件名：</b>TToBApplyInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月21日下午3:14:27<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;
/** 
* @ClassName: TToBApplyInfo
* @Description: 
* @author lichenghao
* @date 2016年10月21日 下午3:14:27  
*/
public class TToBApplyInfo {
	
	//B端patient  uuId
	private String buyerUuid;
	//医院Id
	private Integer hospitalId;
	public String getBuyerUuid() {
		return buyerUuid;
	}
	public void setBuyerUuid(String buyerUuid) {
		this.buyerUuid = buyerUuid;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
