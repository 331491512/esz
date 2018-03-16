/**
 * 
 */
package com.westangel.commonservice.trade.service.product;

import java.util.List;

import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.ProductInfoAddReq;
import com.westangel.common.bean.trade.ProductInfoGetReq;
import com.westangel.common.bean.trade.ProductInfoListGetReq;
import com.westangel.common.bean.trade.ProductInfoUpdateReq;
import com.westangel.common.bean.trade.ProductStateUpdateReq;
import com.westangel.common.bean.trade.ProductTemplateListReq;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.bean.trade.TProductInfo;
import com.westangel.commonservice.trade.bean.ProductGetReq;
import com.westangel.commonservice.trade.bean.ProductListRuleGetReq;
import com.westangel.commonservice.trade.bean.THospitalProductInfo;
import com.westangel.commonservice.trade.bean.THospitalProductInitInfo;
import com.westangel.commonservice.trade.bean.TProductTemplateInfo;

/**
 * 交易系统-产品服务接口
 * @author bigdragon
 * @date 2015/12/21 
 */
public interface ProductService {

	/**
	 * 商品列表（某个供应商）
	 * @param userId
	 * @return
	 */
	public List<TProductDetailInfo> listProduct(Long userId,Long reqFlag);
	
	
	/**
	 * 获取某个供应商单类商品（某个供应商某个指定商品）
	 * @param userId
	 * @param buyer:传入此值时，会返回产品订购状态。
	 * @return TProductDetailInfo
	 */
	public List<TProductDetailInfo> getProduct(ProductGetReq req);

	
	/**
	 * 商品上架（为医生创建产品服务或医生配置服务）
	 * @param userId
	 * @param productList: 产品详情列表
	 * @return respCode: 错误码。0：success
	 */
	public TMsgResponse makeProductOnShelf(Long userId,List<TProductDetailInfo> productList);
	
	/**
	 * 商品下架（为医生创建产品服务或医生配置服务）
	 * @param userId
	 * @param productIdList: 产品ID数组
	 * @return respCode: 错误码。0：success
	 */
	public TMsgResponse makeProductOffShelf(Long userId,List<String> productIdList);

	/**
	 * 查询产品订购关系
	 * @param buyer
	 * @param vendor
	 * @param productType
	 * @return
	 */
	public Integer queryProductSubscription(Long buyer, Long vendor,
			Integer productType);

	/**
	 * 获得产品详情
	 * @param productId
	 * @return
	 */
	public TProductDetailInfo getProductDetail(String productId,Integer productSubType);
	
	/**
	 * 获得产品详情
	 * @param productId
	 * @return
	 */
	public TProductDetailInfo getProductDetail(String productId,Long buyer,Integer productSubType);
	
	//获得产品套餐标识。仅作为Dubbo服务向外提供
	//1: 套餐（如私人医生）；0：非套餐； -1：仅作为套餐的子元素，如预约挂号
	int getProductPackageFlag(int productType);


	/**
	 * 初始化设置产品
	 * @param userId
	 * @param professionalRankId
	 * @return
	 */
	public TMsgResponse initProduct(Long userId, int professionalRankId);


	/**
	 * 获取商品模板接口
	 * By Da Loong
	 * 2016/6/2
	 * @param req 
	 * @return
	 */
	public List<TProductTemplateInfo> listProductTemplate(ProductTemplateListReq req);


	/**
	 * 修改商品模板
	 * By Da Loong
	 * 2016/6/2
	 * @param req
	 * @return
	 */
	public TMsgResponse modifyProductTemplate(TProductTemplateInfo req);


	/**
	 * 初始化医院产品
	 * @param userId
	 * @param productList
	 * @return
	 */
	public TMsgResponse initProduct(Long userId, List<THospitalProductInitInfo> productList);


	/**
	 * @param req
	 * @return
	 */
	public TMsgResponse setProductCertificationMode(THospitalProductInfo req);


	/**
	 * 设置医院服务产品
	 * By Da Loong
	 * 2016/6/6
	 * @param req
	 * @return
	 */
	public TMsgResponse setProductHospitalInfo(THospitalProductInfo req);


	/**获取商品列表〈运营平台〉
	 * @param req
	 * @return
	 */
	public Page<TProductInfo> getProductInfoList(ProductInfoListGetReq req);


	/**获取商品信息〈运营平台〉
	 * @param req
	 * @return
	 */
	public TProductInfo getProductInfo(ProductInfoGetReq req);


	/**新增商品
	 * @param req
	 * @return
	 */
	public Object addProductInfo(ProductInfoAddReq req);


	/**更新商品
	 * @param req
	 * @return
	 */
	public Object updateProductInfo(ProductInfoUpdateReq req);


	/**更新商品上架下架
	 * @param req
	 * @return
	 */
	public Object productStateUpdate(ProductStateUpdateReq req);


	/**
	 * 通过规则获取商品页
	 * @param req
	 * @return
	 */
	public Object getProductByRule(ProductListRuleGetReq req);

	/**
	 *
	 * @param var1
	 * @param var2
	 * @return
	 */
	boolean checkProductIsExist(String var1, Integer var2);
	
}
