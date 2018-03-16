package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.westangel.common.bean.ProfessionalRankSimpleInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface ProfessionalRankDao {

	/**
	 * 获取职称列表
	 * @return
	 */
	public List<ProfessionalRankSimpleInfo> findProfessionalRanks();
}