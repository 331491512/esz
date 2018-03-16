/**
 * 
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;

/**
 * @author bigdragon
 * @date  2016年1月20日 上午8:27:14
 */
public class TProductGroupMemberInfo implements Serializable {
	private static final long serialVersionUID = 3L;
	
	private Long vendor;
	
	private String vendorName;
	
	private String hospitalName;
	
	private String deptName;
	
	private String professionalRankName;

	/**
	 * @return the vendor
	 */
	public Long getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Long vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}

	/**
	 * @param hospitalName the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the professionalRankName
	 */
	public String getProfessionalRankName() {
		return professionalRankName;
	}

	/**
	 * @param professionalRankName the professionalRankName to set
	 */
	public void setProfessionalRankName(String professionalRankName) {
		this.professionalRankName = professionalRankName;
	}
	
	

}
