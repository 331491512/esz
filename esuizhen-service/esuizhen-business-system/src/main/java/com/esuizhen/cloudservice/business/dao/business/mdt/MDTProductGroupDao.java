package com.esuizhen.cloudservice.business.dao.business.mdt;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.business.bean.TMDTDoctorInProductGroupInfo;
import com.esuizhen.cloudservice.business.bean.TProductGroupInfo;

/**
 * <p>Title:MDTProductGroupDao</p>
 * <p>Description:MDT产品组数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年9月28日 下午2:54:51
 */
public interface MDTProductGroupDao {
	/**
	 * <p>Title:findByProductId</p>
	 * <p>Description:通过产品ID获取MDT组信息</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午2:55:45
	 * @param productId
	 * @return
	 */
	TProductGroupInfo findByProductId(@Param("productId")String productId);
	
	/**
	 * <p>Title:findMDTInProductGroupList</p>
	 * <p>Description:查询MDT产品组内医生列表</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 下午4:43:49
	 * @param groupType
	 * @return
	 */
	List<TMDTDoctorInProductGroupInfo> findMDTInProductGroupList(@Param("productId")String productId, @Param("groupType")Integer groupType);

	/**
	 * <p>Title:findMDTProducts</p>
	 * <p>Description:查询MDT产品列表</p>
	 * @author YYCHEN
	 * @date 2016年9月29日 下午4:35:28
	 * @param hospitalId
	 * @param userId
	 * @return
	 */
	List<TMDTDoctorInProductGroupInfo> findMDTProducts(@Param("hospitalId")Integer hospitalId, @Param("userId")Long userId);
	
	/**
	 * 通过产品id获取签名
	 * @param productId
	 * @return
	 */
	List<TMDTDoctorInProductGroupInfo> getProductGroupList(@Param("productId")String productId);
}
