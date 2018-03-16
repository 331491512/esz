package com.westangel.common.bean.message;

import java.io.Serializable;

/**
 * 
* @ClassName: ImSpeaker 
* @Description: 发言者 
* @author LIPENG
* @date 2015年12月9日 下午4:44:58 
*
 */
public class ImSpeaker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 186997771505339318L;
	/**
	 * 编号
	 */
	private Long id;
	/**
	 * 角色
	 */
	private Integer role;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 头像URL地址
	 */
	private String headUrl;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setRole(Integer role) {
		this.role = role;
	}
	
	public Integer getRole() {
		return role;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	
	public String getHeadUrl() {
		return headUrl;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
