package com.esuizhen.cloudservice.user.service;

import com.westangel.common.bean.User;

public interface UuidRelationshipService {
	/**
	 * <p>Title:saveUuidMapper</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午3:06:44
	 * @param user
	 * @param uuid
	 * @return
	 */
	public boolean saveUuidMapper(User user, String uuid);
}
