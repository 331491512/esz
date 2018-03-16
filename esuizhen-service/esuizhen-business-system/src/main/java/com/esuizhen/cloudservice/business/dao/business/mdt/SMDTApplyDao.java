package com.esuizhen.cloudservice.business.dao.business.mdt;

import com.esuizhen.cloudservice.business.model.business.SMDTApply;

public interface SMDTApplyDao {

	public Integer findSMdtAppleByUserId(Long userId);
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增专家会诊咨询MDT申请</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午7:26:26
	 * @param smdtApply
	 * @return
	 */
	int insert(SMDTApply smdtApply);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:更新专家会诊咨询MDT申请</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午7:26:30
	 * @param obj
	 * @return
	 */
	int update(Object obj);

	SMDTApply findByProductApplyId(String productApplyId);
}
