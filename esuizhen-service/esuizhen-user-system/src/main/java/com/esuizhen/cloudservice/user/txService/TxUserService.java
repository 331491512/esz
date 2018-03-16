package com.esuizhen.cloudservice.user.txService;

import com.westangel.common.bean.User;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.excption.BindingDataExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;

public interface TxUserService {
	/**
	 * <p>Title:confirmInfo</p>
	 * <p>Description:合并ToB导入的用户信息</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 下午4:08:51
	 * @param confirmUserReq
	 * @return
	 * @throws EmptyParamExcption
	 */
	public TConfirmUserResp confirmInfo(TConfirmUserReq confirmUserReq) throws EmptyParamExcption;
	
	/**
	 * <p>Title:wxFuse</p>
	 * <p>Description:微信融合</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 下午4:09:47
	 * @param confirmUserReq
	 * @return
	 * @throws BindingDataExcption 
	 * @throws ObjectAlreadyExistExcption 
	 */
	public TConfirmUserResp wxFuse(TConfirmUserReq confirmUserReq) throws BindingDataExcption, ObjectAlreadyExistExcption;
	
	public void createUserToStrategy(User user);
}
