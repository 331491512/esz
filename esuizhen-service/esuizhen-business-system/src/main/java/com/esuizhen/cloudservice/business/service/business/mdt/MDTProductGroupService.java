package com.esuizhen.cloudservice.business.service.business.mdt;

import java.util.List;

import com.esuizhen.cloudservice.business.bean.TMDTDoctorInProductGroupInfo;
import com.esuizhen.cloudservice.business.bean.TProductGroupInfo;
import com.westangel.common.excption.InsufficientParameterExcption;

public interface MDTProductGroupService {

	/**
	 * <p>Title:getMDTExpertGroupDetail</p>
	 * <p>Description:获取MDT产品组信息</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午3:05:32
	 * @param userId
	 * @param productId
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	TProductGroupInfo getMDTExpertGroupDetail(Long userId, String productId) throws InsufficientParameterExcption;

	/**
	 * <p>Title:getMDTDoctorInProductGroupList</p>
	 * <p>Description:获取MDT产品组内医生列表。</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午5:00:41
	 * @param productId
	 * @param groupType
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	List<TMDTDoctorInProductGroupInfo> getMDTDoctorInProductGroupList(String productId, Integer groupType) throws InsufficientParameterExcption;

	/**
	 * <p>Title:getMDTProductList</p>
	 * <p>Description:获取MDT产品列表</p>
	 * @author YYCHEN
	 * @date 2016年9月29日 下午4:32:45
	 * @param hospitalId
	 * @param userId
	 * @return
	 */
	List<TMDTDoctorInProductGroupInfo> getMDTProductList(Integer hospitalId, Long userId);

}
