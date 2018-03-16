package com.esuizhen.cloudservice.business.dao.business.mdt;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.business.bean.TMDTApplyInfo;

public interface MdtProductDao {
	/**
	 * 查看MDT人次
	 * @param paramsMap
	 * @return
	 */
	int getMdtStatis(Map<String,Object> paramsMap);
	/**
	 * 查看MDT列表信息
	 * @param req
	 * @return
	 */
	List<TMDTApplyInfo> queryMdtList(Map<String,Object> paramsMap);
}
