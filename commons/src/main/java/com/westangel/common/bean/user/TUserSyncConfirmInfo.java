package com.westangel.common.bean.user;
/**
 * 
* @ClassName: TUserSyncConfirmInfo 
* @Description: 用户确认信息 
* @author LIPENG
* @date 2016年2月5日 下午6:32:19 
*
 */
public class TUserSyncConfirmInfo {
	/**
	 * 用户Id
	 */
	private Long userId;	
	/**
	 * uuid
	 */
	private String uuid;
	/**
	 * 用户名
	 */
	private String trueName;
	/**
	 * 提示语
	 */
	private String tipText;
	
	//匹配类型
	private Integer matchType;
	public Integer getMatchType() {
		return matchType;
	}
	public void setMatchType(Integer matchType) {
		this.matchType = matchType;
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
	/** 
	* @return tipText 
	*/
	public String getTipText() {
		return tipText;
	}
	/** 
	* @param tipText 要设置的 tipText 
	*/
	public void setTipText(String tipText) {
		this.tipText = tipText;
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
}
