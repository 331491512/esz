package com.esuizhen.cloudservice.research.service.result;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.westangel.common.bean.User;

/**
 * <p>Title:DoctorService</p>
 * <p>Description:专题对应用户基本信息的操作-业务层</p>
 * @author YYCHEN
 * @date 2016年10月20日 上午11:13:58
 */
public interface UserService {

	User createUser(TProjectSubcenterDetailInfo projectSubcenterDetailInfo);

}
