/**
 * 
 */
package com.westangel.commonservice.trade.model.account;

/**
 * 收支明细
 * @author bigdragon
 * @date  2015-12-23 上午12:52:09
 */
public class TIncomeExpensesItemInfo {
	
	private String recId; //收益记录单号

	private String item; //明细项目
	
	private float  income; //收支；对于支出是负数
	
	private String createTime; //发生时间
	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * @return the income
	 */
	public float getIncome() {
		return income;
	}
	/**
	 * @param income the income to set
	 */
	public void setIncome(float income) {
		this.income = income;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the recId
	 */
	public String getRecId() {
		return recId;
	}
	/**
	 * @param recId the recId to set
	 */
	public void setRecId(String recId) {
		this.recId = recId;
	}
	
	
}
