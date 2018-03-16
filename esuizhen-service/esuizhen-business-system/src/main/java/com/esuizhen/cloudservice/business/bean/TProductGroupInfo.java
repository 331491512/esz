package com.esuizhen.cloudservice.business.bean;

import java.io.Serializable;

/**
 * <p>Title:TProductGroupInfo</p>
 * <p>Description:MDT组信息</p>
 * @author YYCHEN
 * @date 2016年9月28日 下午2:49:21
 */
public class TProductGroupInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//MDT产品ID
	private String productId;
	//MDT产品名称
	private String productName;
	//预期会诊天数
	private Integer mdtProductExpectConsultDay;
	//实际价格
	private Float unitPrice;
	//参考价格
	private Float refPrice;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getMdtProductExpectConsultDay() {
		return mdtProductExpectConsultDay;
	}
	public void setMdtProductExpectConsultDay(Integer mdtProductExpectConsultDay) {
		this.mdtProductExpectConsultDay = mdtProductExpectConsultDay;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Float getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(Float refPrice) {
		this.refPrice = refPrice;
	}
}
