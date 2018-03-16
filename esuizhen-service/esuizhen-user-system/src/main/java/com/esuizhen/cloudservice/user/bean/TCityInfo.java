/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>TCityInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日上午10:38:56<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;

/** 
* @ClassName: TCityInfo
* @Description: 
* @author lichenghao
* @date 2016年5月2日 上午10:38:56  
*/
public class TCityInfo implements Serializable{
	//城市名称
	private String cityName;
	//城市编码
	private String cityCode;
	
	private Integer cityId;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
}
