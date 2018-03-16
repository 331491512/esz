package com.esuizhen.cloudservice.sync.dao.cloud;

import com.westangel.common.bean.user.QRCode;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudQRcodeDao {
	public int insert(QRCode qrCode);
	/**
	 * 通过ticket查询二维码信息
	 * @param ticket
	 * @return
	 */
	public QRCode findByTicket(String ticket);
}
