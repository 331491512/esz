package com.esuizhen.cloudservice.business.model.business;

/**
 * 套餐配额使用信息
 * @author DaLoong
 * @date   2016/1/21
 *
 */
public class TProductPackageQuotaUsageInfo {

	private long quotaUsageId;
	
	private int  packageUsageAvailable;
	
	private int  quota;
	
	private int  usage;
	
	private String parentProductName;

	/**
	 * @return the quotaUsageId
	 */
	public long getQuotaUsageId() {
		return quotaUsageId;
	}

	/**
	 * @param quotaUsageId the quotaUsageId to set
	 */
	public void setQuotaUsageId(long quotaUsageId) {
		this.quotaUsageId = quotaUsageId;
	}

	/**
	 * @return the packageUsage
	 */
	public int getPackageUsageAvailable() {
		return packageUsageAvailable;
	}

	/**
	 * @param packageUsage the packageUsage to set
	 */
	public void setPackageUsageAvailable(int packageUsageAvailable) {
		this.packageUsageAvailable = packageUsageAvailable;
	}

	/**
	 * @return the quota
	 */
	public int getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(int quota) {
		this.quota = quota;
	}

	/**
	 * @return the parentProductName
	 */
	public String getParentProductName() {
		return parentProductName;
	}

	/**
	 * @param parentProductName the parentProductName to set
	 */
	public void setParentProductName(String parentProductName) {
		this.parentProductName = parentProductName;
	}

	/**
	 * @return the usage
	 */
	public int getUsage() {
		return usage;
	}

	/**
	 * @param usage the usage to set
	 */
	public void setUsage(int usage) {
		this.usage = usage;
	}
	
	
	
}
