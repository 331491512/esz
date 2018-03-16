package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: DoctorSimpleInfo 
* @Description: 医生信息bean
* @author YYCHEN
* @date 2015年12月25日 下午14:53:33  
*/
public class DoctorSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long doctorId;
	private String trueName;
	private Integer sex;
	private String professionalRank;
	private String deptName;
	private String childDept;
	private String hospitalName;
	private String mobile;
	private String tel;
	private String tagIds;
	private String tags;
	private String userPictureUrl;
	private Integer hospitalId;
	private List<DoctorTag> tagList;
	private List<ProductSimpleInfo> productList;
	private Date createTime;
	private Date updateTime;
	private Integer accountType;

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTagIds() {
		return tagIds;
	}
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public String getChildDept() {
		return childDept;
	}
	public void setChildDept(String childDept) {
		this.childDept = childDept;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Long getUserId() {
		return userId;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getProfessionalRank() {
		return professionalRank;
	}
	public void setProfessionalRank(String professionalRank) {
		this.professionalRank = professionalRank;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<DoctorTag> getTagList() {
		return tagList;
	}
	public void setTagList(List<DoctorTag> tagList) {
		this.tagList = tagList;
	}
	public List<ProductSimpleInfo> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductSimpleInfo> productList) {
		this.productList = productList;
	}
	/**
	 * @return the userPictureUrl
	 */
	public String getUserPictureUrl() {
		return userPictureUrl;
	}
	/**
	 * @param userPictureUrl the userPictureUrl to set
	 */
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
}
