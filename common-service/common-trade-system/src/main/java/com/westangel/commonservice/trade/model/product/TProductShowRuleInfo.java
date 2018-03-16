/**
 * 
 */
package com.westangel.commonservice.trade.model.product;

/**
 * @author chenghao
 * @date  2017年2月17日 下午7:56:26
 */
public class TProductShowRuleInfo {
	private String ruleId;//规则编号
	private String pageTitle;//页面标题
	private int pageNum=10;//页面显示条数
	private int sortRule=1;//商品排序规则
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getSortRule() {
		return sortRule;
	}
	public void setSortRule(int sortRule) {
		this.sortRule = sortRule;
	}
}
