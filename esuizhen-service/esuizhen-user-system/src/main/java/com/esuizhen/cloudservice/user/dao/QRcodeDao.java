package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.user.QRCode;
import com.westangel.common.bean.user.UserLoginOutResp;

/**
 * 
 * @author YYCHEN
 *
 */
public interface QRcodeDao {
	public int insert(QRCode qrCode);
	/**
	 * 通过ticket查询二维码信息
	 * @param ticket
	 * @return
	 */
	public QRCode findByTicket(String ticket);
	
	public int delete(Long id);
	/**
	 * 
	 * @param ticket
	 * @return
	 */
	public UserLoginOutResp findUserLoginOutRespByTicket(String ticket);
	
	public QRCode findByUserId(@Param("userId")Long userId, @Param("role")Integer role);
}