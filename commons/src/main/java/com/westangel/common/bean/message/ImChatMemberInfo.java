package com.westangel.common.bean.message;

import java.io.Serializable;

/**
 * 
* @ClassName: ImChatMemberInfo 
* @Description: 聊天成员结构 
* @author LIPENG
* @date 2015年12月9日 下午10:21:20 
*
 */
public class ImChatMemberInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Long id;
	/**
	 * 角色
	 */
	private Integer role;
	/**
	 * 产品编号
	 */
	private Integer productId;
	
	/**
	 * 对方ID
	 */
	private Long peerId;
	/**
	 * 对方角色
	 */
	private Integer peerRole;
	
	/** 
	* @return id 
	*/
	public Long getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Long id) {
		this.id = id;
	}
	/** 
	* @return role 
	*/
	public Integer getRole() {
		return role;
	}
	/** 
	* @param role 要设置的 role 
	*/
	public void setRole(Integer role) {
		this.role = role;
	}
	/** 
	* @return peerId 
	*/
	public Long getPeerId() {
		return peerId;
	}
	/** 
	* @param peerId 要设置的 peerId 
	*/
	public void setPeerId(Long peerId) {
		this.peerId = peerId;
	}
	/** 
	* @return peerRole 
	*/
	public Integer getPeerRole() {
		return peerRole;
	}
	/** 
	* @param peerRole 要设置的 peerRole 
	*/
	public void setPeerRole(Integer peerRole) {
		this.peerRole = peerRole;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
