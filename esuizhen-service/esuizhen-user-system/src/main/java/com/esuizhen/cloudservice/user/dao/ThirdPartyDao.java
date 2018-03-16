package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.westangel.common.bean.ThirdParty;

/**
 * 
 * @author YYCHEN
 *
 */
public interface ThirdPartyDao {

	public int deleteByPrimaryKey(Integer id);

	public long insert(ThirdParty record);

	public List<ThirdParty> findByUserId(Long userId);

	public int updateByPrimaryKey(ThirdParty record);

	public ThirdParty searchThirdPartyByOpenId(String openId);
}