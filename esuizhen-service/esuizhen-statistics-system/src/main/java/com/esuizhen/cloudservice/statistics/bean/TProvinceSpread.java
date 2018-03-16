/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TProvinceSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午7:02:28<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.List;

/** 
* @ClassName: TProvinceSpread
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午7:02:28  
*/
public class TProvinceSpread {
	private List<TProvinceSpreadItem> spread;

	public List<TProvinceSpreadItem> getSpread() {
		return spread;
	}

	public void setSpread(List<TProvinceSpreadItem> spread) {
		this.spread = spread;
	}
}
