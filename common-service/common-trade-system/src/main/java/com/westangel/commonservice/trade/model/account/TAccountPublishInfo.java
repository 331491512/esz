/**
 * 
 */
package com.westangel.commonservice.trade.model.account;

/**
 * @author bigdragon
 * @date  2016-1-5 下午7:12:16
 */
public class TAccountPublishInfo {
	
	private Long accountId;
	
	private Long userId;
	
	private String accountNo;
	
	private int  role;
	
	private String roleName;
	
	private String accountName;
	
	private int    accountClass;

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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the accountClass
	 */
	public int getAccountClass() {
		return accountClass;
	}

	/**
	 * @param accountClass the accountClass to set
	 */
	public void setAccountClass(int accountClass) {
		this.accountClass = accountClass;
	}
	
	
}
