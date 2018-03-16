/**
 * 
 * @author Da Loong
 * @date  2016年6月6日 下午5:11:16
 */
package com.westangel.commonservice.trade.service.metainfo;

import java.util.List;

import com.westangel.commonservice.trade.bean.TExpressCompanyInfo;

/**
 * @author Da Loong
 * @date  2016年6月6日 下午5:11:16
 */
public interface MetaInfoService {

	
	/**
	 * @param hospitalId
	 * @return
	 */
	List<TExpressCompanyInfo> listMetaInfoExpressCompany(Integer hospitalId);

}
