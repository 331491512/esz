package com.westangel.common.bean.user;
/**
 * 
* @ClassName: TTobeconfirmedDoctor 
* @Description: 待确认医生信息 
* @author LIPENG
* @date 2016年2月15日 下午4:12:07 
*
 */
public class TTobeconfirmedDoctor {
	/**
	 * 匹配库中的user的uuid
	 */
	private String mathUserUuid;
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 医生ID
	 */
	private Long doctorId;
	/**
	 * 姓名
	 */
	private String trueName;
	
	private String mobile;
	/**
	 * 员工号
	 */
	private String staffNo;
	/**
	 * 医院名称
	 */
	private String hospitalName;
	/**
	 * 科室名称
	 */
	private String deptName;
	/**
	 * 子科室名称
	 */
	private String subDeptName;
	/**
	 * 职位
	 */
	private String positionTitleName;
	/**
	 * 职称
	 */
	private String professionalRankName;
	/**
	 * 匹配类型
	 */
	private Integer matchType;
	/**
	 * uuid
	 */
	private String uuid;
	/** 
	* @return userId 
	*/
	public Long getUserId() {
		return userId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMathUserUuid() {
		return mathUserUuid;
	}
	public void setMathUserUuid(String mathUserUuid) {
		this.mathUserUuid = mathUserUuid;
	}
	/** 
	* @param userId 要设置的 userId 
	*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/** 
	* @return trueName 
	*/
	public String getTrueName() {
		return trueName;
	}
	/** 
	* @param trueName 要设置的 trueName 
	*/
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getSubDeptName() {
		return subDeptName;
	}
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}
	/** 
	* @return staffNo 
	*/
	public String getStaffNo() {
		return staffNo;
	}
	/** 
	* @param staffNo 要设置的 staffNo 
	*/
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	/** 
	* @return hospitalName 
	*/
	public String getHospitalName() {
		return hospitalName;
	}
	/** 
	* @param hospitalName 要设置的 hospitalName 
	*/
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	/** 
	* @return deptName 
	*/
	public String getDeptName() {
		return deptName;
	}
	/** 
	* @param deptName 要设置的 deptName 
	*/
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/** 
	* @return uuid 
	*/
	public String getUuid() {
		return uuid;
	}
	/** 
	* @param uuid 要设置的 uuid 
	*/
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/** 
	* @return doctorId 
	*/
	public Long getDoctorId() {
		return doctorId;
	}
	/** 
	* @param doctorId 要设置的 doctorId 
	*/
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	/** 
	* @return positionTitleName 
	*/
	public String getPositionTitleName() {
		return positionTitleName;
	}
	/** 
	* @param positionTitleName 要设置的 positionTitleName 
	*/
	public void setPositionTitleName(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}
	/** 
	* @return professionalRankName 
	*/
	public String getProfessionalRankName() {
		return professionalRankName;
	}
	/** 
	* @param professionalRankName 要设置的 professionalRankName 
	*/
	public void setProfessionalRankName(String professionalRankName) {
		this.professionalRankName = professionalRankName;
	}
	public Integer getMatchType() {
		return matchType;
	}
	public void setMatchType(Integer matchType) {
		this.matchType = matchType;
	}
}
