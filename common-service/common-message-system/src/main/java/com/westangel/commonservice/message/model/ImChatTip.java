package com.westangel.commonservice.message.model;
/**
 * 
* @ClassName: ImChatTip 
* @Description: 内容类型到tipText的映射关系 
* @author LIPENG
* @date 2015年12月11日 下午9:19:02 
*
 */
public class ImChatTip {
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 内容类型
	 */
	private Integer contentType;
	/**
	 * 提示语
	 */
	private String tipText;
	/** 
	* @return contentType 
	*/
	public Integer getContentType() {
		return contentType;
	}
	/** 
	* @param contentType 要设置的 contentType 
	*/
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
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
	* @return id 
	*/
	public Integer getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Integer id) {
		this.id = id;
	}
}
