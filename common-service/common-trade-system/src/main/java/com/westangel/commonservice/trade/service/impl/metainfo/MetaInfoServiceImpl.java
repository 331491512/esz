/**
 * 
 * @author Da Loong
 * @date  2016年6月6日 下午5:12:30
 */
package com.westangel.commonservice.trade.service.impl.metainfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.westangel.commonservice.trade.bean.TExpressCompanyInfo;
import com.westangel.commonservice.trade.dao.MetaInfoDao;
import com.westangel.commonservice.trade.service.metainfo.MetaInfoService;

/**
 * @author Da Loong
 * @date  2016年6月6日 下午5:12:30
 */
@Service
public class MetaInfoServiceImpl implements MetaInfoService {

	@Autowired
	private MetaInfoDao   dao;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	
	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.metainfo.MetaInfoService#listMetaInfoExpressCompany(java.lang.Integer)
	 */
	@Override
	public List<TExpressCompanyInfo> listMetaInfoExpressCompany(Integer hospitalId) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoExpressCompanyList(hospitalId);
	}

}
