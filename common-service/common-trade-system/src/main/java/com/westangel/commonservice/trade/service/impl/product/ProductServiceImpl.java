/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.bean.trade.ProductInfoAddReq;
import com.westangel.common.bean.trade.ProductInfoGetReq;
import com.westangel.common.bean.trade.ProductInfoListGetReq;
import com.westangel.common.bean.trade.ProductInfoUpdateReq;
import com.westangel.common.bean.trade.ProductStateUpdateReq;
import com.westangel.common.bean.trade.ProductTemplateListReq;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.bean.trade.TProductGroupMemberInfo;
import com.westangel.common.bean.trade.TProductInfo;
import com.westangel.common.bean.trade.TProductSubTemplateInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.commonservice.trade.bean.ProductGetReq;
import com.westangel.commonservice.trade.bean.ProductListRuleGetReq;
import com.westangel.commonservice.trade.bean.THospitalProductInfo;
import com.westangel.commonservice.trade.bean.THospitalProductInitInfo;
import com.westangel.commonservice.trade.bean.TProductTemplateInfo;
import com.westangel.commonservice.trade.dao.AccountDao;
import com.westangel.commonservice.trade.dao.ProductCategoryDao;
import com.westangel.commonservice.trade.dao.ProductDao;
import com.westangel.commonservice.trade.dao.ProductShowRuleDao;
import com.westangel.commonservice.trade.dao.ProductTagDao;
import com.westangel.commonservice.trade.model.product.TProductInitInfo;
import com.westangel.commonservice.trade.model.product.TProductShowRuleInfo;
import com.westangel.commonservice.trade.service.account.AccountService;
import com.westangel.commonservice.trade.service.product.ProductService;

/**
 * 产品接口服务实现
 * @author bigdragon
 * @date  2015-12-19 下午5:53:25
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService,com.westangel.common.service.ProductService{
	
	@Autowired
	private AccountDao  accountDao;
	@Autowired
	private ProductDao   productDao;
	@Autowired
	private ProductTagDao   productTagDao;
	@Autowired
	private ProductShowRuleDao   productRuleDao;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	/** 
	 * 获取某个供应商产品（商品）列表
	 * param: reqFlag: 1: 患者端查看，会返回所有上架产品；0或者不传入时，医生端查看，不会返回packageFlag=-1（只能是套餐子元素产品，如预约加号）产品，但上架和下架都返回
	 * @see com.westangel.commonservice.trade.service.product.ProductService#listProduct(java.lang.Long)
	 */
	@Override
	public List<TProductDetailInfo> listProduct(Long userId,Long reqFlag) {
		List<TProductDetailInfo> list = productDao.queryProductList(userId,reqFlag);
		if(list!=null && list.size()>0){
			for(TProductDetailInfo info:list){
				if(info.getIsGroup()==1){
					productDetailInitGroup(info);//组成员判断
				}
			}
		}
		else{
			if(reqFlag==null || reqFlag==0 ){//只医生端查看
				//产品列表为空时，返回标准的产品列表。但用户不可更改
				list=productDao.getProductTemplateList();
				if(list!=null)
					LogUtil.log.info("listProduct(): return productTemplateList ok! size="+list.size());
			}
			
			
		}
		return list; 
	}

	/**
	 *  获取某个供应商单类商品（某个供应商某个指定类型商品）
	 * @see com.westangel.commonservice.trade.service.product.ProductService#getProduct(java.lang.Long)
	 */
	@Override
	public List<TProductDetailInfo> getProduct(ProductGetReq req) {
		// TODO Auto-generated method stub
		if(req==null||req.getUserId()==null)
			throw new EmptyParamExcption("getProduct error,param is null or userId is null");
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("userId", req.getUserId());
		params.put("productType", req.getProductType());
		if(req.getBuyer()!=null)
			params.put("buyer", req.getBuyer());
		if(req.getReqFlag()!=null&&req.getReqFlag()!=0)
			params.put("reqFalg", req.getReqFlag());
		if(req.getProductType()==Constant.Business.PRODUCT_TYPE_MDT&&req.getBuyer()!=null){
			//如果为MDT 且有购买者 通过标签查找
			List list = productTagDao.getPatientTags(req.getBuyer());
			if(list==null||list.size()==0)
				list=new ArrayList<TagInfo>();
			TagInfo tagInfo=new TagInfo();
			tagInfo.setTagId(Constant.TAGID);
			list.add(tagInfo);
			params.put("tags", list);
		}
		List<TProductDetailInfo> list = productDao.getProduct(params);
		List<TProductDetailInfo> subList=new ArrayList<>();
		if(list!=null && list.size()>0){
			for(TProductDetailInfo info:list){
				if(info.getIsGroup()==1){
					productDetailInitGroup(info);//组成员判断
				}
				//若有子产品类型则拆分
				if(!StringUtils.isBlank(info.getProductSubTypes())){
					String [] productSubTypes=info.getProductSubTypes().split(",");
					info.setProductSubTypes(null);
					int size=productSubTypes.length;
					for (int i = 0; i <size ; i++) {
						String productSubName=productDao.findProductSubTemplate(info.getProductTemplateId(),productSubTypes[i]);
						if(i==0){
							info.setProductName(productSubName);
							info.setProductSubType(Integer.valueOf(productSubTypes[0]));
						}else{
							TProductDetailInfo detailInfo=new TProductDetailInfo();
							BeanUtils.copyProperties(info,detailInfo);
							detailInfo.setProductSubType(Integer.valueOf(productSubTypes[i]));
							detailInfo.setProductName(productSubName);
							subList.add(detailInfo);
						}
					}
				}
				//插入产品类别
				info.setProductCategoryList(productCategoryDao.queryProductCategoryList(info.getProductId()));
			}
		}
		if(subList!=null&&subList.size()>0)
			list.addAll(subList);
		return list;
	}

	/**
	 * 商品上架（为医生创建产品服务或医生配置服务）
	 * @see com.westangel.commonservice.trade.service.product.ProductService#makeProductOnShelf(java.lang.Long, java.util.List)
	 */
	@Override
	public TMsgResponse makeProductOnShelf(Long userId,
			List<TProductDetailInfo> productList) {
		// TODO Auto-generated method stub
		TMsgResponse msg = new TMsgResponse();
		if(userId==0)
		{
			LogUtil.logError.error("parameter ERROR in makeProductOffShelf(): userId is 0.");
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = "paramer error: userId is 0.";
			return msg;
		}

		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=ErrorMessage.SUCCESS.info;
		int result = 0;
		int totalResult = 0;
		for(TProductDetailInfo product:productList){
			String productId = product.getProductId();
			if(product.getEnable()==0){
				LogUtil.logError.error(Constant.LOGTAG.ERR+"makeProductOnShelf failed: enable must be 1: enable="+product.getEnable()+". userId=" + userId+",productId="+productId);
				
				msg.respCode = ErrorMessage.E1406.code;
				msg.respMsg = "您不能修改服务设置！";
				msg.errorDesc = "parameter error: enable must be 1. enable="+product.getEnable()+",productType="+product.getProductType();
				return msg;		
	
			}
			if(productId==null || productId.isEmpty()){
				//当productId为空时，则创建一条新纪录。
				//生成一个唯一的productId
				productId = GeneralUtil.generateUniqueID("PROD");
				product.setProductId(productId);
				LogUtil.log.info("generateUniqueID succeed and we create product for userId=" + userId+",productId="+productId+",productType="+product.getProductType());
				
				productDao.createProduct(product);
			}
			else{
				//此时更新数据. 注意，只会更新state和unitPrice两个字段，其余字段忽略
				if(product.getState()!=1 && product.getState()!=2 )
				{
					//此时报错。
					LogUtil.logError.error("makeProductOnShelf failed: state must be 1 (onshelf) or 2 (offshelf): state="+product.getState()+". userId=" + userId+",productId="+productId);
					
					msg.respCode = ErrorMessage.E1400.code;
					msg.respMsg = "parameter error: state must be 1 (onshelf) or 2 (offshelf). state="+product.getState()+",productType="+product.getProductType();
					return msg;		
				}
				if(product.getUnitPrice()<0)
				{
					//此时报错。
					LogUtil.logError.error("makeProductOnShelf failed: unitPrice cannot be less than 0: unitPrice="+product.getUnitPrice()+". userId=" + userId+",productId="+productId+",productType="+product.getProductType());
					msg.respCode = ErrorMessage.E1400.code;
					msg.respMsg = "parameter error: unitPrice should not be less than 0. unitPrice="+product.getUnitPrice()+",productType="+product.getProductType();
					
					return msg;
				}
				if(product.getUnitPrice()>100000)
				{
					//此时报错。
					LogUtil.logError.error("makeProductOnShelf failed: unitPrice cannot be more than 1000000. userId=" + userId+",productId="+productId+",productType="+product.getProductType());
					msg.respCode = ErrorMessage.E1400.code;
					msg.respMsg = "parameter error: unitPrice cannot be more than 100000. unitPrice="+product.getUnitPrice()+",productType="+product.getProductType();
					return msg;
				}
				//执行更新
				result = productDao.updateProduct(product);
				totalResult+=result;
				if(result==0){
					//更新记录数为0，表示没有更新成功。没有找到相应的productId
					LogUtil.logError.error("makeProductOnShelf failed: productDao.updateProduct() return 0 and no records updated. Maybe the productId does not exist. userId=" + userId+",productId="+productId+",productType="+product.getProductType());
					msg.respCode = ErrorMessage.E1404.code;
					msg.respMsg = "parameter error: the productId not found: productId="+productId +",productType="+product.getProductType();
					return msg;
		
				}
				LogUtil.log.info("makeProductOnShelf succeed. update result: "+ totalResult+". userId=" + userId+",productId="+productId +",productType="+product.getProductType() );

			}
		}
	
		return msg;
	}

	/**
	 * 商品下架（为医生创建产品服务或医生配置服务）
	 * @see com.westangel.commonservice.trade.service.product.ProductService#makeProductOffShelf(java.lang.Long, java.util.List)
	 */
	@Override
	public TMsgResponse makeProductOffShelf(Long userId, List<String> productIdList) {
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=ErrorMessage.SUCCESS.info;
		if(userId==0)
		{
			LogUtil.logError.error("parameter ERROR in makeProductOffShelf(): userId is 0.");
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = "paramer error: userId is 0.";
			return msg;
		}
		
		if(productIdList==null ||productIdList.isEmpty()){
			LogUtil.logError.error("parameter ERROR in makeProductOffShelf(): productIdList is null.");
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = "paramer error: productIdList is empty.";
			return msg;
		}
	
		int result = 0;
		int totalResult = 0;
		for(String productId:productIdList){
			result = productDao.updateProductOffShelf(productId);
			if(result==0){
				//更新记录数为0，表示没有更新成功。没有找到相应的productId
				LogUtil.logError.error("makeProductOnShelf failed: productDao.updateProduct() return 0 and no records updated. Maybe the productId does not exist. userId=" + userId+",productId="+productId);
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = "parameter error: the productId not found: productId="+productId ;
				return msg;
			}
			LogUtil.log.info("makeProductOffShelf() succeed. userId=" + userId+",productId="+productId );
			
		}

		
		return msg;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.ProductService#queryProductSubscription(java.lang.Long, java.lang.Long, java.lang.Integer)
	 */
	@Override
	public Integer queryProductSubscription(Long buyer, Long vendor,
			Integer productType) {
		try{
		  return  productDao.queryProductSubscription(buyer,vendor,productType);
		}
		catch(Exception e){
			LogUtil.logError.error("queryProductSubscription failed: buyer="+buyer+",vendor="+vendor+",productType="+productType
					+". error:"+e.getMessage());
			//也返回0，不在外层抛异常
		}
		return 0;
	}

	
	/* (non-Javadoc)
	 * 获得产品详情
	 * @see com.westangel.commonservice.trade.service.product.ProductService#getProductDetail(java.lang.Integer)
	 */
	@Override
	public TProductDetailInfo getProductDetail(String productId,Integer productSubType) {
		return getProductDetail(productId,null,productSubType);
	}
	@Override
	public TProductDetailInfo getProductDetail(String productId, String orderId){
		return getProductDetail(productId,null,orderId,null);
	}
	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.product.ProductService#getProductPackageFlag(java.lang.String)
	 */
	@Override
	public int getProductPackageFlag(int productType) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * 初始化设置产品
	 * @see com.westangel.commonservice.trade.service.product.ProductService#initProduct(java.lang.Long, int)
	 */
	@Override
	public TMsgResponse initProduct(Long userId, int professionalRankId) {
		// TODO Auto-generated method stub
		LogUtil.log.info(Constant.LOGTAG.INF+"Begin to init product. userId="+userId+",professionalRankId="+professionalRankId);
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=ErrorMessage.SUCCESS.info;
	
		//1. 首先初始化一个账户
		int count = accountDao.isExistAccount(userId,1);
		if(count>0)return msg;
			
		boolean rt = accountService.createAccount(userId,2,1);
		if(rt){
			LogUtil.log.info(Constant.LOGTAG.OK+"create account for vendor userId "+ userId+" succeed.");
		}
		//2. 然后从产品模板和参考价表中获得初始化产品
		List<TProductInitInfo> productInitList = productDao.getProductInitInfoList(userId,professionalRankId);
		if(productInitList==null){
			LogUtil.log.error(Constant.LOGTAG.ERR+"init product failed! getProductInitInfoList return null. userId="+userId+",professionalRankId="+professionalRankId);
			msg.respCode = ErrorMessage.E1406.code;
			msg.respMsg = ErrorMessage.E1406.info;
			msg.errorDesc = "no configuration for the professionalRankId "+professionalRankId;
			return msg;
		}
		
		for(TProductInitInfo info:productInitList){
			info.setProductId(GeneralUtil.generateUniqueID("PROD"));
			info.setProductNo(GeneralUtil.generatorUUID(12));
		}
		
		//3. 插入到产品表
		productDao.initProduct(productInitList);
		LogUtil.log.info(Constant.LOGTAG.OK+"init product succeed. userId="+userId);
		return msg;
	}

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.product.ProductService#getProductDetail(java.lang.String, java.lang.Long)
	 */
	@Override
	public TProductDetailInfo getProductDetail(String productId, Long buyer,Integer productSubType) {
		// TODO Auto-generated method stub
		return getProductDetail(productId,buyer,null,productSubType);
	}
	
	public TProductDetailInfo getProductDetail(String productId, Long buyer,String orderId,Integer productSubType) {
		// TODO Auto-generated method stub
		try{
			TProductDetailInfo info =  productDao.getProductById(productId,buyer,productSubType);
			productDetailInitGroup(info);//组成员判断
			return info;
		}
		catch(Exception e){
			LogUtil.logError.error("getProductDetail error: productId="+productId+",error:"+e.getMessage());
			return null;
		}
	}

	/**
	 * 获取商品模板接口
	 * By Da Loong
	 * 2016/6/2
	 * @see com.westangel.commonservice.trade.service.product.ProductService#listProductTemplate()
	 */
	@Override
	public List<TProductTemplateInfo> listProductTemplate(ProductTemplateListReq req) {
		// TODO Auto-generated method stub
		return productDao.getProductTemplateInfoList(req);
	}

	/**
	 * 修改商品模板
	 * By Da Loong
	 * 2016/6/2
	 * @see com.westangel.commonservice.trade.service.product.ProductService#modifyProductTemplate(com.westangel.commonservice.trade.bean.TProductTemplateInfo)
	 */
	@Override
	public TMsgResponse modifyProductTemplate(TProductTemplateInfo req) {
		// TODO Auto-generated method stub
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=ErrorMessage.SUCCESS.info;
	
		productDao.updateProductTemplate(req);
		 
		return msg;
	}

	/**
	 * @see com.westangel.commonservice.trade.service.product.ProductService#initProduct(java.lang.Long, java.util.List)
	 */
	@Override
	public TMsgResponse initProduct(Long userId, List<THospitalProductInitInfo> productList) {
		// TODO Auto-generated method stub
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=ErrorMessage.SUCCESS.info;
	
		for(THospitalProductInitInfo product:productList){
			//先查询是否存在
			String productId=productDao.getProductId(userId,product.getProductTemplateId());
			if(productId!=null){
				//更新
				productDao.updateProductStateWithProductSubTypes(productId,product.getState(),product.getProductSubTypes());
			}
			else{
				//插入
				if(product.getState()==1){
					String productIdNew = GeneralUtil.generateUniqueID("PROH");
					String productNo = GeneralUtil.generatorUUID(12);
					productDao.createProductByTemplate(userId,product.getProductTemplateId(),productIdNew,productNo,product.getProductSubTypes());
				}
			}
		}

		//下架医院服务
		if(productList!=null&&productList.size()>0)
			productDao.updateHospitalProduct(userId,2,productList);

		return msg;
	}

	/**
	 * 设置医院服务认证模式
	 * @see com.westangel.commonservice.trade.service.product.ProductService#setProductCertificationMode(com.westangel.commonservice.trade.bean.THospitalProductInfo)
	 */
	@Override
	public TMsgResponse setProductCertificationMode(THospitalProductInfo req) {
		// TODO Auto-generated method stub
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=ErrorMessage.SUCCESS.info;
		productDao.setProductCertificationMode(req);
	
		return msg;
	}

	/** 
	 * 设置医院服务产品
	 * @see com.westangel.commonservice.trade.service.product.ProductService#setProductHospitalInfo(com.westangel.commonservice.trade.bean.THospitalProductInfo)
	 */
	@Override
	public TMsgResponse setProductHospitalInfo(THospitalProductInfo req) {
		// TODO Auto-generated method stub
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=ErrorMessage.SUCCESS.info;
		productDao.setProductHospitalInfo(req);
	
		return msg;
	}

	/**
	 * 获取商品列表
	 * @param req
	 * @return
	 */
	@Override
	public Page<TProductInfo> getProductInfoList(ProductInfoListGetReq req) {
		PageHelper.startPage(req.getPageSize() + 1, req.getNum());
		List<TProductInfo> list = productDao.getProductInfoList(req);
		if(list==null||list.size()==0)
			throw new EmptyObjectExcption(" getProductInfoList size 0,param:"+JsonUtil.toJson(req));
		return PageUtil.returnPage((com.github.pagehelper.Page<TProductInfo>)list);
	}

	/**
	 * 获取商品信息
	 * @param req
	 * @return
	 */
	@Override
	public TProductInfo getProductInfo(ProductInfoGetReq req) {
		if(req==null||StringUtils.isEmpty(req.getProductId()))
			throw new EmptyParamExcption("getProductInfo error: param error");
		TProductInfo info = checkProductInfo(req);
		if(info==null)
			throw new EmptyObjectExcption("getProductInfo error:message null, productId="+req.getProductId());
		info.setTags(productTagDao.getProductTags(info.getProductId()));
		return info;
	}

	/**
	 * 商品添加
	 */
	@Override
	public Object addProductInfo(ProductInfoAddReq req) {
		// TODO Auto-generated method stub
		if(req==null||StringUtils.isEmpty(req.getProductTemplateId())||req.getVendor()==null
				||StringUtils.isEmpty(req.getProductName())||(req.getState()!=1&&req.getState()!=2))
			throw new EmptyParamExcption("add productInfo param error");
		TProductDetailInfo detail = new TProductDetailInfo();
		//获取产品初始化信息
		TProductInitInfo initInfo = productDao.getProductInitInfo(req.getVendor(), req.getProductTemplateId());
		if(initInfo==null)
			throw new EmptyObjectExcption("add productInfo error,productTemplate="+req.getProductTemplateId());
		initInfo.setProductId(GeneralUtil.generateUniqueID("PROD"));
		initInfo.setProductNo(GeneralUtil.generatorUUID(12));
		initInfo.setProductName(req.getProductName());
		initInfo.setState(req.getState());
		List<TProductInitInfo> initProductList = new ArrayList<TProductInitInfo>();
		initProductList.add(initInfo);
		productDao.initProduct(initProductList);
		//更新其他信息
		TProductInfo info = new TProductInfo();
		BeanUtils.copyProperties(req, info);
		info.setProductId(initInfo.getProductId());
		productDao.updateProductInfo(info);
		if(req.getTags()!=null&&req.getTags().size()>0)//插入标签
			productTagDao.createtProductTagList(info.getProductId(), req.getTags());
		return null;
	}

	/**
	 * 更新商品信息
	 * @param req
	 * @return
	 */
	@Override
	public Object updateProductInfo(ProductInfoUpdateReq req) {
		if(req==null||StringUtils.isEmpty(req.getProductId())||req.getVendor()==null
				||StringUtils.isEmpty(req.getProductName()))
			throw new EmptyParamExcption("update productInfo param error");
		TProductInfo info = checkProductInfo(req);
		if(info==null)
			throw new EmptyObjectExcption("update productInfo error,productInfo is null ,productId="+req.getProductId()+",vendor="+req.getVendor());
		BeanUtils.copyProperties(req, info);
		productDao.updateProductInfo(info);
		productTagDao.deleteProductTag(req.getProductId());
		if(req.getTags()!=null&&req.getTags().size()>0)
			productTagDao.createtProductTagList(req.getProductId(), req.getTags());
		return null;
	}

	/**
	 * 商品状态更新
	 * @param req
	 * @return
	 */
	@Override
	public Object productStateUpdate(ProductStateUpdateReq req) {
		// TODO Auto-generated method stub
		if(req==null||StringUtils.isEmpty(req.getProductId())||req.getVendor()==null||req.getState()==null)
			throw new EmptyParamExcption("error param error");
		if(req.getState()!=1&&req.getState()!=2)
			throw new EmptyParamExcption("error param error,state="+req.getState());
		if(checkProductInfo(req)==null)
			throw new EmptyObjectExcption("error: product is null,productId:"+req.getProductId());
		productDao.updateProductState(req.getProductId(), req.getState());
		return null;
	}
	//检查商品
	private TProductInfo checkProductInfo(Object obj){
		TProductInfo productInfo = new TProductInfo();
		BeanUtils.copyProperties(obj, productInfo);
		productInfo = productDao.getProductInfo(productInfo);//获取商品
		return productInfo;
	}

	/**
	 * 通过规则获取商品页信息
	 */
	@Override
	public Page<TProductDetailInfo>  getProductByRule(ProductListRuleGetReq req) {
		if(req==null||StringUtils.isEmpty(req.getRuleId()))
			throw new EmptyParamExcption("getProductByRule error: param error");
		TProductShowRuleInfo ruleInfo = productRuleDao.getProductShowRule(req.getRuleId());
		if(ruleInfo==null)
			throw new EmptyObjectExcption("getProductByRule error: product show rule is null ,ruleId="+req.getRuleId());

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageTitle", ruleInfo.getPageTitle());
		List<TagInfo> tagInfos=productTagDao.findContentTagsByRule(req.getRuleId());
		List<String> productTemplates=getProductTemplate(req.getSourceType());
		if(tagInfos!=null&&tagInfos.size()>0){
			PageHelper.startPage(req.getPage()+1,req.getNum());
			List<TProductDetailInfo> products=productDao.getProductByRuleIdList(tagInfos,productTemplates);
			return PageUtil.returnPage((com.github.pagehelper.Page<TProductDetailInfo>)products);
		}else {
			Page<TProductDetailInfo> page = new Page<TProductDetailInfo>();
			page.setTotalNum(0);
			page.setCurrPage(0);
			page.setCurrSize(0);
			page.setTotalPage(0);
			return page;
		}


		//List tags = productTagDao.getRuleTags(req.getRuleId());
		/*if(tags!=null&&tags.size()>0){//有标签进行查询，无标签不考虑
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("sortRule", ruleInfo.getSortRule());
			params.put("tags", tags);
			PageHelper.startPage(req.getPageSize() + 1, ruleInfo.getPageNum());
			List<TProductDetailInfo> list = productDao.getProduct(params);
			if(list!=null && list.size()>0){
				for(TProductDetailInfo info:list){
					productDetailInitGroup(info);//组判断
				}
			}
			Page page = PageUtil.returnPage((com.github.pagehelper.Page<TProductDetailInfo>)list);
			map.put("totalNum", page.getTotalNum());
			map.put("totalPage", page.getTotalPage());
			map.put("currPage", page.getCurrSize());
			map.put("dataList", page.getDataList());
		}else{
			map.put("totalNum", 0);
			map.put("totalPage", 0);
			map.put("currPage", 0);
		}*/
	}

	private List<String> getProductTemplate(String sourceType) {
		List<String> productTemplates=null;
		if(!StringUtils.isBlank(sourceType)){
			productTemplates=new ArrayList<String>();
			String [] s=sourceType.split(",");
			for (String str : s){
				productTemplates.add(str);
			}
		}
		return productTemplates;
	}

	private void productDetailInitGroup(TProductDetailInfo info){
		if(info.getIsGroup()!=1)
			return;
		//如果是组，则返回成员列表。
		LogUtil.log.info("getProduct(): getGroupMemberList(): productId="+info.getProductId());
		List<TProductGroupMemberInfo> groupMemberList = productDao.getGroupMemberList(info.getProductId());
		info.setGroupMemberList(groupMemberList);
	}

	@Override
	public boolean checkProductIsExist(String productId, Integer productSubType) {
		boolean result=true;
		if(StringUtils.isBlank(productId)){
			LogUtil.log.info("productId is null");
			return false;
		}
		TProductDetailInfo info=productDao.findProductByProductId(productId);
		if(info==null){
			result=false;
		}else{
			List<TProductSubTemplateInfo> subTemplateInfos=productDao.findProductSubTemplateListByProductId(productId);
			if(subTemplateInfos!=null&&subTemplateInfos.size()>0){
				if(StringUtils.isBlank(info.getProductSubTypes())) {
					result = false;
				}else{
					if(productSubType==null){
						LogUtil.log.info("productSubType is null");
						return false;
					}
					//在模板中没有或者在产品（商品）中不存在这个productSubType，则这个产品（商品）不存在
					if(!existProductSubTypeInTemplateInfo(subTemplateInfos,productSubType)
							||!info.getProductSubTypes().contains(productSubType.toString())){
						result=false;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 检查子产品类型是否存在子模板中
	 * @param subTemplateInfos
	 * @param productSubType
	 * @return
	 */
	private boolean existProductSubTypeInTemplateInfo(List<TProductSubTemplateInfo> subTemplateInfos, Integer productSubType) {
		boolean result=false;
		for (TProductSubTemplateInfo subTemplateInfo : subTemplateInfos){
			if(productSubType.equals(subTemplateInfo.getProductSubType())){
				result=true;
			}
		}
		return result;
	}

	@Override
	public boolean checkUserProductIsExist(Long userId, Integer productType) {
		int count = productDao.queryProductSize(userId,productType);
		return count>0;
	}

}
