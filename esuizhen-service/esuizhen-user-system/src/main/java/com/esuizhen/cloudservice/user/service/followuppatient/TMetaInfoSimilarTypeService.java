package com.esuizhen.cloudservice.user.service.followuppatient;

import java.util.List;

import com.esuizhen.cloudservice.user.model.followuppatient.TMetaInfoSimilarType;

public interface TMetaInfoSimilarTypeService {
	/**
	 * 查询所有疑似重复数据
	 * @return
	 */
	List<TMetaInfoSimilarType> selectAllList();
}
