package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.westangel.common.bean.PositionTitleSimpleInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface PositionTitleDao {

	/**
	 * 获取职务列表
	 * @return
	 */
	public List<PositionTitleSimpleInfo> findPositionTitleSimpleInfos();
}