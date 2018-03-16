/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>ProductInfoListGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月17日上午11:27:45<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;
/** 
* @ClassName: ProductInfoListGetReq
* @Description: 
* @author lichenghao
* @date 2017年2月17日 上午11:27:45  
*/
public class ProductInfoListGetReq {
	//商品模版
	private String productTemplateId;
	//商品类型
	private Integer productType;
	//商品名称
	private String productName;
	//标签Id
	private Integer tagId;
	//商品提供商
	private Long vendor;
	//商品状态
	private Integer state;
	//是否返回全部商品  0全部 1平台
	private int reqFlag=1;
	//页码 默认0
	private int pageSize=0;
	//每页显示条数 默认 10 
	private int num=10;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Long getVendor() {
		return vendor;
	}
	public void setVendor(Long vendor) {
		this.vendor = vendor;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public int getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(int reqFlag) {
		this.reqFlag = reqFlag;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getProductTemplateId() {
		return productTemplateId;
	}
	public void setProductTemplateId(String productTemplateId) {
		this.productTemplateId = productTemplateId;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
}
