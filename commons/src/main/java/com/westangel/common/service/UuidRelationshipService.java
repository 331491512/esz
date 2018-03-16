package com.westangel.common.service;

import com.westangel.common.bean.sync.UuidRelationship;

/**
 * 匹配中间库中的uuid映射关系管理接口
 * @author YYCHEN
 *
 */
public interface UuidRelationshipService {
	/**
	 * 添加uuid映射关系
	 * @param uuidRelationship
	 * @return
	 */
	public boolean save(UuidRelationship uuidRelationship);
}
