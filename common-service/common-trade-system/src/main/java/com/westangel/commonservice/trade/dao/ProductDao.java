/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.bean.trade.TProductGroupMemberInfo;
import com.westangel.common.bean.trade.TProductInfo;
import com.westangel.common.bean.trade.TProductSubTemplateInfo;
import com.westangel.commonservice.trade.bean.THospitalProductInfo;
import com.westangel.commonservice.trade.bean.THospitalProductInitInfo;
import com.westangel.commonservice.trade.bean.TProductTemplateInfo;
import com.westangel.commonservice.trade.model.product.TProductInitInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 商品（服务）Dao
 * @author bigdragon
 * @date  2015-12-19 下午6:04:56
 */
public interface ProductDao {

	/**
	 * @param userId
	 * @param reqFlag 
	 * @return
	 */
	public List<TProductDetailInfo> queryProductList(@Param("userId") Long userId, @Param("reqFlag") Long reqFlag);
	

	/**
	 * @param params
	 * @return
	 */
	public List<TProductDetailInfo> getProduct(Map<String, Object> params);


	/**
	 * @param product
	 */
	public void createProduct(TProductDetailInfo product);


	/**
	 * @param product
	 */
	public int updateProduct(TProductDetailInfo product);


	/**
	 * @param productId
	 */
	public int updateProductOffShelf(String productId);


	
	/**
	 * @param buyer
	 * @param vendor
	 * @param productType
	 * @return
	 */
	public int queryProductSubscription(@Param("buyer") Long buyer, @Param("vendor") Long vendor,
			@Param("productType") Integer productType);


	
	/**
	 * 根据productId获得产品详情
	 * @param productId
	 * @return
	 */
	public TProductDetailInfo getProductById(@Param("productId") String productId,@Param("buyer") Long buyer,
											 @Param("productSubType") Integer productSubType);


	
	/**
	 * 获得产品组的提供商列表
	 * @param productId
	 * @return
	 */
	public List<TProductGroupMemberInfo> getGroupMemberList(@Param("productId")String productId);
	
	public List<TProductGroupMemberInfo> getGroupMemberListByProductIdAndOrderId(@Param("productId")String productId,@Param("orderId")String orderId);


	
	/**
	 * 获得初始化产品列表,从产品模板和价格参考表关联获得
	 * @param userId
	 * @param professionalRankId
	 * @return
	 */
	public List<TProductInitInfo> getProductInitInfoList(@Param("userId")Long userId, @Param("professionalRankId")int professionalRankId);
	/**
	 * 获取初始化单一产品
	 * @param userId
	 * @param professionalRankId
	 * @return
	 */
	public TProductInitInfo getProductInitInfo(@Param("userId")Long userId, @Param("productTemplateId")String productTemplateId);


	/**
	 * @param productInitList
	 */
	public void initProduct(List<TProductInitInfo> productInitList);


	/**
	 * 根据产品模板，获得标准产品列表。用于卖家查看（enable标识为0，表示不能修改）。
	 * @return
	 */
	public List<TProductDetailInfo> getProductTemplateList();

	

	/**
	 * 获取产品模板信息
	 * 由运营系统调用
	 * By Da Loong
	 * 2016/6/2
	 * @return
	 */
	public List<TProductTemplateInfo> getProductTemplateInfoList(Object obj);


	/**
	 * 修改商品模板
	 * By Da Loong
	 * 2016/6/2
	 */
	public void updateProductTemplate(TProductTemplateInfo req);


	/**
	 * @param userId
	 * @param productTemplateId
	 * @return
	 */
	public String getProductId(@Param("userId")Long userId,@Param("productTemplateId") String productTemplateId);


	/**
	 * @param productId
	 * @param state
	 */
	public void updateProductState(@Param("productId")String productId, @Param("state")Integer state);

	/**
	 * @param productId
	 * @param state
	 */
	public void updateProductStateWithProductSubTypes(@Param("productId")String productId, @Param("state")Integer state,@Param("productSubTypes") String productSubTypes);


	/**
	 * @param userId
	 * @param productTemplateId
	 */
	public void createProductByTemplate(@Param("userId")Long userId, @Param("productTemplateId")String productTemplateId,
			@Param("productId")String productId,@Param("productNo") String productNo,@Param("productSubTypes") String productSubTypes);


	/**
	 * @param req
	 * @return
	 */
	public void setProductCertificationMode(THospitalProductInfo req);


	/**
	 * 设置医院服务产品
	 * @param req
	 */
	public void setProductHospitalInfo(THospitalProductInfo req);
	
	
	/**
	 * 获取商品列表<运营平台>
	 * @param obj
	 * @return
	 */
	public List<TProductInfo> getProductInfoList(Object obj);
	/**
	 * 获取商品信息〈运营平台〉
	 * @param obj
	 * @return
	 */
	public TProductInfo getProductInfo(TProductInfo obj);
	/**
	 * 更新商品信息
	 * @param obj
	 * @return
	 */
	public int updateProductInfo(TProductInfo obj);

	/**
	 * 获取商品子模板名称
	 * @param productTemplateId
	 * @param productSubType
	 * @return
	 */
    String findProductSubTemplate(@Param("productTemplateId") String productTemplateId,
								  @Param("productSubType") String productSubType);

	/**
	 * 获取产品子模板
	 * @param productId
	 * @return
	 */
	List<TProductSubTemplateInfo> findProductSubTemplateListByProductId(@Param("productId") String productId);

	/**
	 * 查询产品是否存在
	 * @param productId
	 * @return
	 */
	TProductDetailInfo findProductByProductId(String productId);

	/**
	 * 将
	 * @param userId
	 * @param productList
	 */
	void updateHospitalProduct(@Param("userId") Long userId,@Param("state") Integer state,
							   @Param("productList") List<THospitalProductInitInfo> productList);

    List<TProductDetailInfo> getProductByRuleIdList(@Param("tagInfos") List<TagInfo> tagInfos,
													@Param("productTemplates") List<String> productTemplates);

    /**
     * 
     * @author lichenghao
     * @title :queryProductSize
     * @Description:查询提供商此类商品总数
     * @return int
     * @date 2017年9月29日 上午9:02:29
     */
	public Integer queryProductSize(@Param("vendor")Long userId, @Param("productType")Integer productType);
}
