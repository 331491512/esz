/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.meta;<br/>  
 * <b>文件名：</b>TReviewItemInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年3月27日下午6:51:09<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.meta;

import java.util.List;

/** 
* @ClassName: TReviewItemInfo
* @Description: 
* @author lichenghao
* @date 2016年3月27日 下午6:51:09  
*/
public class TReviewItemInfo {
	
	private Integer ItemId;
	
	private String ItemName;
	
	private List<TReviewItemInfo> chileItems;

	public Integer getItemId() {
		return ItemId;
	}

	public void setItemId(Integer itemId) {
		ItemId = itemId;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public List<TReviewItemInfo> getChileItems() {
		return chileItems;
	}

	public void setChileItems(List<TReviewItemInfo> chileItems) {
		this.chileItems = chileItems;
	}
	
}
