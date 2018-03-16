/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>ProductInfoUpdateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月17日上午11:20:55<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.util.List;

import com.westangel.common.bean.sys.TagInfo;

/** 
* @ClassName: ProductInfoUpdateReq
* @Description: 
* @author lichenghao
* @date 2017年2月17日 上午11:20:55  
*/
public class ProductInfoUpdateReq {
	// 模版Id
	private String productId;
	// 提供商
	private Long vendor;
	// 商品名称
	private String productName;
	// 商品介绍
	private String introduction;
	// 单价
	private float unitPrice = 0;
	// 参考价格
	private float refPrice = 0;
	// 折扣价格
	private float discountPrice = 0;
	// 商品来源
	private int productSource = 0;
	// 商品排序
	private Integer sortIndex;
	// 商品详情
	private String description;
	// 商品图片地址
	private String productPictureUrls;
	// 商品第三方提供商
	private String provider;
	// 客服电话
	private String customerMobile;
	// 标签集和
	private List<TagInfo> tags;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Long getVendor() {
		return vendor;
	}
	public void setVendor(Long vendor) {
		this.vendor = vendor;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(float refPrice) {
		this.refPrice = refPrice;
	}
	public float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getProductSource() {
		return productSource;
	}
	public void setProductSource(int productSource) {
		this.productSource = productSource;
	}
	public Integer getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductPictureUrls() {
		return productPictureUrls;
	}
	public void setProductPictureUrls(String productPictureUrls) {
		this.productPictureUrls = productPictureUrls;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public List<TagInfo> getTags() {
		return tags;
	}
	public void setTags(List<TagInfo> tags) {
		this.tags = tags;
	}
}
