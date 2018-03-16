package com.esuizhen.cloudservice.ehr.model.patientinfo;

import java.util.Date;


public class TUserInfo{
	
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 唯一标识一个用户
	 */
	private String uuid;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 角色
	 */
	private Integer role;
	/**
	 * 账号类型： -1：未激活的临时用户（无手机号） 0：未激活的被动用户（有手机号。对于此类用户患者，医生可以给其发短信通知激活）  （以下>0都是通过微信或者App注册的用户） 1：微信注册用户 2：微信注册且绑定了手机的用户 3：App手机注册用户 4：微信+App手机注册用户
	 */
	private Integer accountType;
	/**
	 * 信息填写状态：0：未填写个人信息1：填写完个人信息待审核(或医生提交资质信息待审核）2：审核成功3：审核失败
	 */
	private Integer infoState;
	/**
	 * 云端和ToB数据同步标志。 0：未同步（默认）；1：已同步（当同步成功之后设置）
	 */
	private Integer syncFlag;
	/**
	 * 真实姓名全名
	 */
	private String trueName;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 首次登录时间
	 */
	private Date firstLoginTime;
	/**
	 * 个人资料更新时间
	 */
	private Date updateTime;
	/**
	 * 用户密码
	 */
	private String cryptPasswd;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 用户手机号
	 */
	private String mobile;
	/**
	 * 性别. 0：未知；1：男；2：女
	 */
	private Integer sex;
	/**
	 * 生日
	 */
	private Date birthDate;
	/**
	 * 头像URL
	 */
	private String userPictureUrl;
	/**
	 * 用户邮箱号
	 */
	private String email;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 城市ID。外键: meta_city.cityId
	 */
	private Integer cityId;
	/**
	 * 城市代码。尽量不直接使用本字段，而是使用meta_city.cityId进行关联。将来被字段将去除。
	 */
	private String cityCode;
	/**
	 * 所在城市。冗余字段。
	 */
	private String city;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 籍贯
	 */
	private String nativePlace;
	/**
	 * 出生城市代码
	 */
	private String birthPlaceCode;
	/**
	 * 出生地详细地址
	 */
	private String birthPlaceAddress;
	/**
	 * 职业
	 */
	private String profession;
	/**
	 * company
	 */
	private String company;
	/**
	 * 证件类型。1：身份证（缺省）2：护照3：军官证
	 */
	private Integer idType;
	/**
	 * 身份证号/护照/军官证号。唯一性约束
	 */
	private String identification;
	/**
	 * 婚姻状况:1：未婚；2：已婚；3：丧偶；4：离婚9：其他
	 */
	private Integer marriageStatus;
	/**
	 * 个性签名
	 */
	private String signature;
	/**
	 * 文化程度:0：文盲；1：小学；2：初中；3：高中；4：大专；5：硕士研究生；6：博士研究生
	 */
	private Integer education;
	/**
	 * 毕业学校
	 */
	private String school;
	/**
	 * 兴趣爱好
	 */
	private String interest;
	/**
	 * 证件照片URL
	 */
	private String idFileUrl;
	/**
	 * 用户状态：1：正常（缺省）2：系统锁定或注销。锁定后的用户不可登录，需要申请解锁才能登录。
	 */
	private Integer state;
	/**
	 * 账号类型：0：普通账号（手机帐号，默认）子角色Ids。多个子角色之间通过逗号,分隔。一个用户可以拥有多个子角色。如院长, 科室主任，护士等。
	 */
	private String subroles;
	/**
	 * 积分（爱心）
	 */
	private Integer points;
	/**
	 * 最近登录时间（用于计算用户活跃度）
	 */
	private Date lastLoginTime;
	/**
	 * 用户来源标识。0：未知（默认）；1：扫码（医生）关注；2：微信关注；3：院内同步; 4:医生创建；5：扫码医院
	 */
	private Integer sourceFlag;
	/**
	 * 用户类型标识。0：一般用户(默认)；1：测试用户；2：医院内置用户（每一个有二维码的医院都会内建一个“医院”用户，在u_hospital表里存储对应的userId；9：系统内置用户
	 */
	private Integer userFlag;
	/**
	 * 迁移标识。0：非迁移用户；1：迁移用户
	 */
	private Integer migrateFlag;
	/**
	 * 关联userId。表示此两条记录实际指向相同用户。
	 */
	private Long relatedUserId;
	private Integer nationalityId;
	private Integer nationId;
	private Integer occupationId;
	
	/**
	 * 院内、院外标识。1：院内用户（tob用户）；0：院外用户（默认）
	 */
	private Integer tobFlag;
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUuid() {
		return this.uuid;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	public Integer getRole() {
		return this.role;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	
	public Integer getAccountType() {
		return this.accountType;
	}
	public void setInfoState(Integer infoState) {
		this.infoState = infoState;
	}
	
	public Integer getInfoState() {
		return this.infoState;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	
	public Integer getSyncFlag() {
		return this.syncFlag;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	public String getTrueName() {
		return this.trueName;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	
	public Date getFirstLoginTime() {
		return this.firstLoginTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	public void setCryptPasswd(String cryptPasswd) {
		this.cryptPasswd = cryptPasswd;
	}
	
	public String getCryptPasswd() {
		return this.cryptPasswd;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return this.nickName;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getSex() {
		return this.sex;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}
	
	public String getUserPictureUrl() {
		return this.userPictureUrl;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getNation() {
		return this.nation;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return this.country;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public Integer getCityId() {
		return this.cityId;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getCityCode() {
		return this.cityCode;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	public String getNativePlace() {
		return this.nativePlace;
	}
	public void setBirthPlaceCode(String birthPlaceCode) {
		this.birthPlaceCode = birthPlaceCode;
	}
	
	public String getBirthPlaceCode() {
		return this.birthPlaceCode;
	}
	public void setBirthPlaceAddress(String birthPlaceAddress) {
		this.birthPlaceAddress = birthPlaceAddress;
	}
	
	public String getBirthPlaceAddress() {
		return this.birthPlaceAddress;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String getProfession() {
		return this.profession;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getCompany() {
		return this.company;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	
	public Integer getIdType() {
		return this.idType;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public String getIdentification() {
		return this.identification;
	}
	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	
	public Integer getMarriageStatus() {
		return this.marriageStatus;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String getSignature() {
		return this.signature;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	
	public Integer getEducation() {
		return this.education;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getSchool() {
		return this.school;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public String getInterest() {
		return this.interest;
	}
	public void setIdFileUrl(String idFileUrl) {
		this.idFileUrl = idFileUrl;
	}
	
	public String getIdFileUrl() {
		return this.idFileUrl;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setSubroles(String subroles) {
		this.subroles = subroles;
	}
	
	public String getSubroles() {
		return this.subroles;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Integer getPoints() {
		return this.points;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	
	public Integer getSourceFlag() {
		return this.sourceFlag;
	}
	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}
	
	public Integer getUserFlag() {
		return this.userFlag;
	}
	public void setMigrateFlag(Integer migrateFlag) {
		this.migrateFlag = migrateFlag;
	}
	
	public Integer getMigrateFlag() {
		return this.migrateFlag;
	}
	public void setRelatedUserId(Long relatedUserId) {
		this.relatedUserId = relatedUserId;
	}
	
	public Long getRelatedUserId() {
		return this.relatedUserId;
	}

	public Integer getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	public Integer getNationId() {
		return nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getTobFlag() {
		return tobFlag;
	}

	public void setTobFlag(Integer tobFlag) {
		this.tobFlag = tobFlag;
	}


}

