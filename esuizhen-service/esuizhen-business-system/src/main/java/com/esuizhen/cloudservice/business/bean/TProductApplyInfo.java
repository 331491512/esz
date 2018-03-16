/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TProductApplyInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月25日下午4:55:18<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;

/** 
* @ClassName: TProductApplyInfo
* @Description: 
* @author lichenghao
* @date 2016年5月25日 下午4:55:18  
*/
public class TProductApplyInfo {
	//服务申请号
	private String productApplyId;
	//服务类型
	private Integer productType;
	//申请服务名称
	private String orderTitle;
	//服务价格
	private Float realPrice;
	//付款人
	private Long buyer;
	//付款人名称
	private String buyerName;
	//头像路径
	private String userPictureUrl;
	//服务状态
	private String stateName;
	//申请时间
	private Date applyTime;
	//取消时间
	private Date idleCancelTime;
	//开始时间
	private Date consultOrderTime;
	//状态
	private Integer state;
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public String getOrderTitle() {
		return orderTitle;
	}
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}
	public Float getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Float realPrice) {
		this.realPrice = realPrice;
	}
	public Long getBuyer() {
		return buyer;
	}
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Date getIdleCancelTime() {
		return idleCancelTime;
	}
	public void setIdleCancelTime(Date idleCancelTime) {
		this.idleCancelTime = idleCancelTime;
	}
	public Date getConsultOrderTime() {
		return consultOrderTime;
	}
	public void setConsultOrderTime(Date consultOrderTime) {
		this.consultOrderTime = consultOrderTime;
	}
	public String getUserPictureUrl() {
		return userPictureUrl;
	}
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
}
