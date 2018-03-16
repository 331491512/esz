/**
 * 
 * @author Da Loong
 * @date  2016年6月6日 下午5:16:44
 */
package com.westangel.commonservice.trade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.commonservice.trade.bean.TExpressCompanyInfo;

/**
 * @author Da Loong
 * @date  2016年6月6日 下午5:16:44
 */
public interface MetaInfoDao {

	/**
	 * @param hospitalId
	 * @return
	 */
	List<TExpressCompanyInfo> queryMetaInfoExpressCompanyList(@Param("hospitalId")Integer hospitalId);

}
