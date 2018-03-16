/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TProvinceSpreadItem.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午7:03:16<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: TProvinceSpreadItem
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午7:03:16  
*/
public class TProvinceSpreadItem {
	
	//省份ID
	private String provinceId;
	//省份名称
	private String provinceName;
	//人数
	private Integer number;
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}
