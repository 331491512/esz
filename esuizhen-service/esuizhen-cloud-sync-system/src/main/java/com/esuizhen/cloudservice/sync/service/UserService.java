package com.esuizhen.cloudservice.sync.service;

import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;

public interface UserService {
	public void scanning(boolean flag);

	public TConfirmUserResp affirm(TConfirmUserReq confirmUserReq);
}
