package com.esuizhen.cloudservice.business.service.business.mdt;

import com.esuizhen.cloudservice.business.bean.MdtReq;
import com.esuizhen.cloudservice.business.bean.TMDTApplyInfo;
import com.esuizhen.cloudservice.business.bean.TMDTWaxExpressReq;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.InsufficientParameterExcption;

public interface MdtProductService {
	/**
	 * 查看MDT人次
	 * @param vendor
	 * @param mdtFlowStateId
	 * @param flag
	 * @param mdtRole
	 * @param userRole
	 * @return
	 */
	int getMdtStatis(Long vendor, Integer mdtFlowStateId,Integer flag,Integer mdtRole, Integer userRole);
	/**
	 * 查看MDT列表信息
	 * @param req
	 * @return
	 */
	Page<TMDTApplyInfo> queryMdtList(MdtReq req);
	
	/**
	 * <p>Title:expressMDTWax</p>
	 * <p>Description:MDT服务流程，邮寄蜡片。</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午5:28:10
	 * @param waxExpressReq
	 * @return
	 * @throws InsufficientParameterExcption
	 */
	boolean expressMDTWax(TMDTWaxExpressReq waxExpressReq) throws InsufficientParameterExcption;
	
	/**
	 * @author wang_hw
	 * @title :findSMdtAppleByUserId
	 * @Description:根据用户ID获取mdt待处理数
	 * @return Integer
	 * @date 2017年1月20日 上午10:26:00
	 */
	public Integer findSMdtAppleByUserId(Long userId);
}
