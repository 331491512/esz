package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: HospitalProfile 
* @Description: 医院详细信息bean
* @author YYCHEN
* @date 2015年12月23日 上午11:05:33  
*/
public class HospitalProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer hospitalId;
	private String uuid;
	private String hospitalName;
	private String nickName="";
	private Integer gradeId;
	private String specialClinics;
	private String address;
	private String busLines;
	private Integer cityId;
	private String cityCode;
	private String cityName;
	private String tel="";
	private String introduction="";
	private Long userId;
	private Float latitude=0.f;
	private Float longitude=0.f;
	private Date createTime;
	private Date updateTime;
	private String pictureUrl;
	private String contactName;
	private String contactMobile;
	private Integer state;
	private String fax;
	private List<THospitalSpecialtyInfo> specialtyList;
	
	private List<ProductSimpleInfo> productList; //Added by Da Loong. 2016/5/28
	
	/**
	 * 三位一体互通标识\r0：未互通（默认）；\r1：三位一体互通（初始同步）\r2：三位一体互通（初始+增量同步）
	 */
	private Integer interconnectionFlag;
	
	/**
	 * 签约标识。1：签约医院(默认)；0：非签约医院
	 */
	private Integer signedFlag;
	
	/**
	 * 元数据类型。0：标准定义（默认），1：用户定义
	 */
	private Integer metaDataType;
	/**
	 * 操作员（对应doctorId）
	 */
	private Long creator;
	/**
	 * 使用次数
	 */
	private Integer useCount;
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getSpecialClinics() {
		return specialClinics;
	}
	public void setSpecialClinics(String specialClinics) {
		this.specialClinics = specialClinics;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusLines() {
		return busLines;
	}
	public void setBusLines(String busLines) {
		this.busLines = busLines;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/** 
	* @return cityId 
	*/
	public Integer getCityId() {
		return cityId;
	}
	/** 
	* @param cityId 要设置的 cityId 
	*/
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/** 
	* @return createTime 
	*/
	public Date getCreateTime() {
		return createTime;
	}
	/** 
	* @param createTime 要设置的 createTime 
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** 
	* @return userId 
	*/
	public Long getUserId() {
		return userId;
	}
	/** 
	* @param userId 要设置的 userId 
	*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * @return the pictureUrl
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}
	/**
	 * @param pictureUrl the pictureUrl to set
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	/**
	 * @return the productList
	 */
	public List<ProductSimpleInfo> getProductList() {
		return productList;
	}
	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<ProductSimpleInfo> productList) {
		this.productList = productList;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public List<THospitalSpecialtyInfo> getSpecialtyList() {
		return specialtyList;
	}
	public void setSpecialtyList(List<THospitalSpecialtyInfo> specialtyList) {
		this.specialtyList = specialtyList;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Integer getInterconnectionFlag() {
		return interconnectionFlag;
	}
	public void setInterconnectionFlag(Integer interconnectionFlag) {
		this.interconnectionFlag = interconnectionFlag;
	}
	public Integer getSignedFlag() {
		return signedFlag;
	}
	public void setSignedFlag(Integer signedFlag) {
		this.signedFlag = signedFlag;
	}
	public Integer getMetaDataType() {
		return metaDataType;
	}
	public void setMetaDataType(Integer metaDataType) {
		this.metaDataType = metaDataType;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public Integer getUseCount() {
		return useCount;
	}
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}
}
