/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.service.impl;<br/>  
 * <b>文件名：</b>RetrievalServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日上午11:00:40<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.statistics.bean.TRetrievalParamentInfo;
import com.esuizhen.cloudservice.statistics.dao.ParamentDao;
import com.esuizhen.cloudservice.statistics.dao.RetrievalParamentMouldDao;
import com.esuizhen.cloudservice.statistics.model.TRetrievalParamentMould;
import com.esuizhen.cloudservice.statistics.service.RetrievalService;
import com.westangel.common.util.GeneralUtil;

/** 
* @ClassName: RetrievalServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年8月10日 上午11:00:40  
*/
@Service
@Transactional
public class RetrievalServiceImpl implements RetrievalService {
	@Autowired
	private ParamentDao paramentDao;
	@Autowired
	private RetrievalParamentMouldDao retrievalParamentMouldDao;
	
	@Override
	public List<TRetrievalParamentInfo> getRetrievalParament() {
		return paramentDao.queryParaments();
	}
	@Override
	public boolean saveRetrievalParamentMould(TRetrievalParamentMould retrievalParamentMould) {
		if (StringUtils.isNotEmpty(retrievalParamentMould.getMouldId())) {//已存在则修改
			this.retrievalParamentMouldDao.update(retrievalParamentMould);
		} else {//不存在时则新增
			retrievalParamentMould.setMouldId(GeneralUtil.generateUniqueID("MOID"));
			this.retrievalParamentMouldDao.insert(retrievalParamentMould);
		}
		return true;
	}
	@Override
	public List<TRetrievalParamentMould> searchRetrievalParamentMouldList(TRetrievalParamentMould retrievalParamentMould) {
		return this.retrievalParamentMouldDao.findRetrievalParamentMouldList(retrievalParamentMould);
	}
	@Override
	public TRetrievalParamentMould getRetrievalParamentMouldDetail(String mouldId) {
		return this.retrievalParamentMouldDao.findRetrievalParamentMouldDetail(mouldId);
	}
	@Override
	public boolean removeRetrievalParamentMould(TRetrievalParamentMould retrievalParamentMould) {
		return this.retrievalParamentMouldDao.delete(retrievalParamentMould.getMouldId()) > 0;
	}
	
}
