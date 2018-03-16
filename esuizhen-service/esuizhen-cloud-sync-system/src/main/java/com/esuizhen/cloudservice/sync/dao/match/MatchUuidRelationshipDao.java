package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 匹配数据库B端uuid与C端uuid对应关系数据访问接口
 * @author YYCHEN
 *
 */
public interface MatchUuidRelationshipDao {
	/**
	 * 新增一条uuid关系
	 * @param uuidRelationship
	 * @return
	 */
	public long insert(UuidRelationship uuidRelationship);
	
	public int update(UuidRelationship uuidRelationship);
	
	public int delete(Long id);
	
	/**
	 * 使用B端传入的uuid值查找关系
	 * @param uuid
	 * @return
	 */
	public UuidRelationship findByUuid(String uuid);
	
	/**
	 * 
	 * @param uuidFinal
	 * @param uuid
	 * @return
	 */
	public int find(@Param("uuidFinal")String uuidFinal, @Param("uuid")String uuid);
	/**
	 * 通过B端给的Uuid查找C端的Uuid
	 * @param uuid
	 * @return
	 */
	public String findUuidFinalByUuid(String uuid);
	
	public String findUuidFinalByUserId(Long userId);
	
	public List<UuidRelationship> findByFinalUuid(String finalUuid);
}
