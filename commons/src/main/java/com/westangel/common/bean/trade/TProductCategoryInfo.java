/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>TProductCategoryInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月28日下午1:31:06<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;

/** 
* @ClassName: TProductCategoryInfo
* @Description: 
* @author lichenghao
* @date 2017年8月28日 下午1:31:06  
*/
public class TProductCategoryInfo implements Serializable {
	private static final long serialVersionUID = 2L;
	//类别编号
	private Integer categoryId;
	//类别名称
	private String categoryName;
	//类别单价
	private float unitPrice;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
}
