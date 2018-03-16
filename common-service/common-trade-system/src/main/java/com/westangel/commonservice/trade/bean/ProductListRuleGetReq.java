/**
 * 
 */
package com.westangel.commonservice.trade.bean;

/**
 * @author chenghao
 * @date  2017年2月17日 下午7:46:01
 */
public class ProductListRuleGetReq {
	private String ruleId;//商品规则Id
	private int pageSize=0;//页面编号
	private int page;
	private int num;

	private String sourceType;

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
