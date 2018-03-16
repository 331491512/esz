/**
 * 
 */
package com.westangel.commonservice.trade.model.account;

/**
 * 记账单信息
 * @author bigdragon
 * @date  2015-12-29 下午7:17:28
 */
public class TDebitCreditRecordItemInfo {

	private String recId; //DEBIYYYYMMDDHHMMSSnnnnnnn
	
	private String recRelatedId;//关联ID
	
	private String refId; //
	
	private String refTable;
	
	private Long   accountId;
	
	private float  debit; //借（收益）
	
	private float  credit;//贷（支出)
	
	private String accountingTitleCode;
	
	private String remark;
	

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

	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * @return the refTable
	 */
	public String getRefTable() {
		return refTable;
	}

	/**
	 * @param refTable the refTable to set
	 */
	public void setRefTable(String refTable) {
		this.refTable = refTable;
	}

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the debit
	 */
	public float getDebit() {
		return debit;
	}

	/**
	 * @param debit the debit to set
	 */
	public void setDebit(float debit) {
		this.debit = debit;
	}

	/**
	 * @return the credit
	 */
	public float getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(float credit) {
		this.credit = credit;
	}

	/**
	 * @return the accountingTitleCode
	 */
	public String getAccountingTitleCode() {
		return accountingTitleCode;
	}

	/**
	 * @param accountingTitleCode the accountingTitleCode to set
	 */
	public void setAccountingTitleCode(String accountingTitleCode) {
		this.accountingTitleCode = accountingTitleCode;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the recRelatedId
	 */
	public String getRecRelatedId() {
		return recRelatedId;
	}

	/**
	 * @param recRelatedId the recRelatedId to set
	 */
	public void setRecRelatedId(String recRelatedId) {
		this.recRelatedId = recRelatedId;
	}


	

}
