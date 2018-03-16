package com.esuizhen.cloudservice.research.service.result;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;

public interface TCrfResultMainInfoService {
	
	/**
	 * <p>Title:createTCrfResultMainInfo</p>
	 * <p>Description:使用传入的专题信息创建患者CRF观察项结果</p>
	 * @author YYCHEN
	 * @date 2016年5月27日 下午4:32:10
	 * @param crfResultMainInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectNotAvailableExcption 
	 */
	public TCrfResultMainInfo<?> createTCrfResultMainInfo(TCrfResultMainInfo<?> crfResultMainInfo) throws ParameterCannotBeNullException, ObjectNotAvailableExcption;
}
