/**
 * 
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;

/**
 * 账户基本信息。与用户的收益和支出相关汇总
 * @author bigdragon
 * @date  2015-12-23 上午12:40:13
 */
public class TAccountInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int   points; //积分(爱心)
	
	private int   totalOrderNum; //订单总数
	
	private float balance;	   //余额 = 充值额-消费额
	
	private float totalIncome; //总收益。（对卖家） , 用户收益表中的max(totalRevenue)
	
	private float totalExpenses;//总支出。（对买家）,收支流水中的payment
	
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * @return the totalOrderNum
	 */
	public int getTotalOrderNum() {
		return totalOrderNum;
	}
	/**
	 * @param totalOrderNum the totalOrderNum to set
	 */
	public void setTotalOrderNum(int totalOrderNum) {
		this.totalOrderNum = totalOrderNum;
	}
	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}
	/**
	 * @return the totalIncome
	 */
	public float getTotalIncome() {
		return totalIncome;
	}
	/**
	 * @param totalIncome the totalIncome to set
	 */
	public void setTotalIncome(float totalIncome) {
		this.totalIncome = totalIncome;
	}
	/**
	 * @return the totalExpenses
	 */
	public float getTotalExpenses() {
		return totalExpenses;
	}
	/**
	 * @param totalExpenses the totalExpenses to set
	 */
	public void setTotalExpenses(float totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	
}
