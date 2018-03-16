/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author bigdragon
 * @date  2016-1-11 上午12:53:33
 */

public interface UserDao {

	/**
	 * @param buyer
	 * @return
	 */
	//productId 为null 的情况下  默认查2
	public String getOpenId(@Param("userId") Long userId,@Param("productId") int productId);
	
	public String getUserTrueName(@Param("userId") Long userId);

	/**
	 * @param openid
	 * @return
	 */
	public Long getUserId(String openId);

    Integer findPatientByUserId(Long buyer);
}
