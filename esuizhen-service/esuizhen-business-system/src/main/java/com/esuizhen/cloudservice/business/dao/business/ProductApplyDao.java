/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>BusinessDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:42:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import com.esuizhen.cloudservice.business.bean.*;
import com.esuizhen.cloudservice.business.model.business.*;
import com.westangel.common.bean.ExpressCompany;
import com.westangel.common.bean.user.ServiceSubscriptionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/** 
* @ClassName: BusinessDao.java
* @Description: 
* @author lichenghao, DaLoong
* @date 2015年12月12日 下午4:42:10  
*/
public interface ProductApplyDao {
	
	/**
	 * 获取产品类型
	 * @author lichenghao
	 * @title :getProductTypeByProductId,getProductTypeByproductApplyId
	 * @Description:TODO
	 * @return Integer
	 * @date 2015年12月15日 下午5:01:02
	 */
	public Integer getProductTypeByProductId(String productId);
	public Integer getProductTypeByproductApplyId(ProductServiceApply productServiceApply);
	
	/**
	 * 创建服务申请
	 * @author lichenghao
	 * @title :createProductServiceApply
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月15日 下午5:22:50
	 */
	public void createProductServiceApply(ProductServiceApply psa);
		
	
	/**
	 * 修改电话咨询时间
	 * @author lichenghao
	 * @title :modifyMonitorTelConsultAlert
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月15日 下午7:38:28
	 */
	public void modifyTelConsultingTime(TProductApply productApply);

	/**
	 * 更新服务申请状态
	 * @author lichenghao
	 * @title :modifyProductServerApply,modifyProductServerApplyState
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月15日 下午8:31:54
	 */
	public void modifyProductServiceApply(TProductApply productApply);
	public void modifyProductServiceApplyState(ProductServiceApply productServiceApply);
	public void modifyProductServiceApplyTips(ProductServiceApply productServiceApply);
	public void modifyProductServiceApplyTipsAndQuotaUsage(ProductServiceApply psa);
	public int modifyProductServiceApplyAuditState(ProductServiceApply psa);
	public int modifyProductServiceApplyProgressState(Object psa);

	/**
	 * 获得服务申请内容
	 * @param productApplyId
	 * @return
	 */
	public ProductServiceApply getProductServiceApplyInfo(String productApplyId);
	public String getProductServiceApplyRecommendedDoctor(String productApplyId);
	
	/**
	 * 获得服务患者对医生的评价
	 * @param productApplyId
	 * @return
	 */
	public ProductServiceApply getProductServiceApplyScoreInfo(String productApplyId);
	
	/**
	 * 获取存在服务中的订购关系的ProductApplyId
	 * @param buyer
	 * @param vendor
	 * @param productType
	 * @param productId 
	 * @return productApplyId
	 */
	public TProductSubscriptionInfo getProductSubcriptionInService(@Param("buyer") Long buyer,@Param("vendor") Long vendor,
			@Param("productType") Integer productType, @Param("productId") String productId);
	
	/**
	 * 查询订单状态
	 * @param buyer
	 * @param orderId
	 * @return
	 */
	public TProductSubscriptionInfo queryProductOrderState(@Param("buyer") Long buyer,
			@Param("orderId") String orderId);
	
	/**
	 * 读取服务配置
	 * 如果有多条，则只返回第一个
	 * @param productType
	 * @return
	 */
	public ProductServiceConf getProductServiceConf(int productType);
	
	/**
	 * 读取服务配置
	 * @param productTemplateId
	 * @return
	 */
	public ProductServiceConf getProductServiceConfById(String productTemplateId);
	
	
	/**
	 * 
	* @Title: queryMDTDetail 
	* @Description: MDT详情 
	* @param @param orderId
	* @param @return    设定文件 
	* @return TMDTDetailInfo    返回类型 
	* @throws
	 */
	public TMDTDetailInfo queryMDTDetail(@Param("orderId")String orderId,@Param("role")Integer role);
	
	public TMDTDetailInfo queryMDTDetailWeb(@Param("orderId")String orderId,@Param("role")Integer role,@Param("id") Long id);
	/**
	 * 
	* @Title: uploadMDTEmr 
	* @Description: 上传MDT病历资料
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void uploadMDTEmr(MdtEmrUploadReq req);
	/**
	 * 
	* @Title: submitMDTEmr 
	* @Description: 提交MDT病历资料 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void submitMDTEmr(MdtEmrSubmitReq req);
	
	/**
	 * 
	* @Title: changeMDTState 
	* @Description: 修改MDT状态 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void changeMDTState(MDTChangeStateReq req);
	/**
	 * 创建套餐配额。例如私人医生，可以有n次图文咨询、n次电话咨询、n次预约加号。
	 * @param psa
	 */
	public void setPackageProductQuota(ProductServiceApply psa);
	
	
	/**
	 * 获取套餐配额使用情况
	 * @param vendor 
	 * @param buyer 
	 * @param productType
	 * @return
	 */
	public List<TProductPackageQuotaUsageInfo> getProductPackageUsage(@Param("buyer") Long buyer, @Param("vendor") Long vendor, @Param("productType") int productType);
	
	/**
	 * 更新产品套餐配额使用值
	 * @param quotaUsageId
	 * @param productType
	 * @return
	 */
	public int updatePackageProductQuota(@Param("quotaUsageId") long quotaUsageId,@Param("productType") Integer productType);
	
	/**
	 * 根据订单号查询服务申请是否存在
	 * @param orderId
	 * @return
	 */
	public int isExistProductApplyByOrderId(String orderId);
	
	/**
	 * 退还套餐内产品使用配额
	 * @param quotaUsageId
	 * @param productType
	 * @return
	 */
	public int giveBackPackageProductQuota(@Param("quotaUsageId") long quotaUsageId, @Param("productType") Integer productType);
	
	/**
	 * 更新VIP标识
	 * @param info
	 * @return
	 */
	public int updateVipFlag(ServiceSubscriptionInfo info);
	
	/**
	 * 插入一条vip标识
	 * @param info
	 */
	public void insertVipFlag(ServiceSubscriptionInfo info);
	
	/**
	 * 更新订购关系标识
	 * @param info
	 * @return
	 */
	public int updateSubscriptionFlag(ServiceSubscriptionInfo info);
	
	/**
	 * 插入一条订购关系标识
	 * 
	 * @param info
	 */
	public void insertSubscriptionFlag(ServiceSubscriptionInfo info);
	
	/**
	 * 更新代理关系标识
	 * @param info
	 * @return
	 */
	public int updateAgentApplyFlag(ServiceSubscriptionInfo info);
	
	/**
	 * 插入一条代理关系标识
	 * 
	 * @param info
	 */
	public void insertAgentApplyFlag(ServiceSubscriptionInfo info);
	
	/**
	 * 查询产品订购关系列表
	 * @param buyer
	 * @param vendor
	 * @param productType
	 * @param reqFlag 
	 * @param sort 
	 * @return
	 */
	public List<TProductSubscriptionSimpleInfo> listProductSubscription(@Param("buyer") Long buyer,
			@Param("vendor") Long vendor,@Param("productType") Integer productType,
			@Param("reqFlag") Integer reqFlag, @Param("sort")Integer sort,@Param("num") Integer num);
	
	/**
	 * 在var_patient_business表中查询订购关系
	 * @return
	 */
	public ServiceSubscriptionInfo queryServiceSubscriptionInfo(@Param("doctorId") Long doctorId,@Param("patientId") Long patientId);
	
	/**
	 * 
	* @Title: listServiceSubscriptionInfo 
	* @Description: 获取医生的VIP患者列表 
	* @param @param vendor
	* @param @return    设定文件 
	* @return List<TServiceSubscriptionInfo>    返回类型 
	* @throws
	 */
	public List<TServiceSubscriptionInfo> listServiceSubscriptionInfo(@Param("vendor") Long vendor);
	
	/**
	 * 查看Mdt病情评估
	 * @author lichenghao
	 * @title :queryMdtDiseaseEvaluation
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月8日 上午11:13:00
	 */
	public MdtDiseaseEvaluationSubmitReq queryMdtDiseaseEvaluation(String productApplyId);
	
	/**
	 * 创建Mdt病情评估
	 * @author lichenghao
	 * @title :createMdtDiseaseEvaluation
	 * @Description:TODO
	 * @return void
	 * @date 2016年3月8日 上午11:14:43
	 */
	public void createMdtDiseaseEvaluation(Object req);
	/**
	 * <p>Title:updateMDTApplyByApplyId</p>
	 * <p>Description:针对MDT咨询，用于修改流程状态</p>
	 * @author YYCHEN
	 * @date 2016年9月30日 下午2:12:51
	 * @param tmdtApplyInfo
	 * @return
	 */
	public int updateMDTApplyByApplyId(TMDTApplyInfo tmdtApplyInfo);
	/**
	 * 修改mdt病情描述
	 * @author lichenghao
	 * @title :modifyMdtDescription
	 * @Description:TODO
	 * @return void
	 * @date 2016年3月8日 下午9:11:50
	 */
	public void modifyMdtDescription(MdtDiseaseEvaluationSubmitReq req);
	
	
	/**
	 * 医院服务简要信息列表获取
	 * @author lichenghao
	 * @title :getHospitalProductSimpleInfo
	 * @Description:TODO
	 * @return List<THospitalProduct>
	 * @date 2016年3月18日 下午4:21:04
	 */
	public List<THospitalProduct> getHospitalProductSimpleInfoList();
	
	
	/**
	 * 通过医院userId获取医院服务信息
	 * @author lichenghao
	 * @title :getHospitalProductByHospitalUserId
	 * @Description:TODO
	 * @return THospitalProduct
	 * @date 2016年3月18日 下午4:21:21
	 */
	public String getHospitalProductMobileByHospitalUserId(@Param("hospitalUserId")Long hospitalUserId);
	
	/**
	 * 服务简要信息
	 * @author lichenghao
	 * @title :getProductApplySimpleInfo
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月18日 下午5:36:43
	 */
	public TProductSubscriptionSimpleInfo getProductApplySimpleInfo(@Param("productApplyId")String productApplyId);
	
	/**
	 * 获取上一次申请的该服务
	 */
	public TProductSubscriptionSimpleInfo getPraveProductApplySimpleInfo(Object obj);
	
	/**
	 * 医院服务包返回信息
	 * @author lichenghao
	 * @title :listProductHospitalSubscription
	 * @Description:TODO
	 * @return List<TProductSubscriptionSimpleInfo>
	 * @date 2016年3月18日 下午6:44:31
	 */
	public List<TProductSubscriptionSimpleInfo> listProductHospitalSubscription(@Param("buyer")Long buyer);
	
	
	/**
	 * 代理申请列表
	 * @author lichenghao
	 * @title :getProductApplyListByAgentApplicant
	 * @Description:TODO
	 * @return List<TProductSubscriptionSimpleInfo>
	 * @date 2016年3月24日 下午4:21:14
	 */
	public List<TProductSubscriptionSimpleInfo> getProductApplyListByAgentApplicant(Object param);
	
	/**
	 * 通过orderId 获取 服务Id
	 * @author lichenghao
	 * @title :getProductApplyIdByOrderId
	 * @Description:TODO
	 * @return String
	 * @date 2016年3月25日 下午2:50:23
	 */
	public String getProductApplyIdByOrderId(@Param("orderId")String orderId);
	
	/**
	 * 获取该申请人的总点数
	 * @author lichenghao
	 * @title :queryDotCountByAgentApplicant
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年3月27日 下午5:36:10
	 */
	public Integer queryDotCountByAgentApplicant(Object param);
	
	/**
	 * 修改服务的点
	 * @author lichenghao
	 * @title :modifyProductServiceApplyDot
	 * @Description:TODO
	 * @return void
	 * @date 2016年3月27日 下午5:54:07
	 */
	public void modifyProductServiceApplyDot(Map<String, Object> param);
	
	/**
	 * 获取购买人信息的列表
	 * @author jiayanzhao
	 * @title :
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月15日 下午5:54:07
	 */
	public List<TProductBuyerInfo> getBuyerInfoList(Map<String, Object> param);
	
	/**
	 * 更新快递单号以及状态
	 * @author jiayanzhao
	 * @title :
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月16日 下午5:54:07
	 */
	public void updateExpressNum(@Param("productApplyId")String productApplyId,@Param("expressNum")String expressNum);
	
	/**
	 * 统计服务申请数据
	 * @author lichenghao
	 * @title :queryProductApplyStatis
	 * @Description:TODO
	 * @return TProductApplyStatisInfo
	 * @date 2016年5月25日 下午5:20:31
	 */
	public TProductApplyStatisInfo queryProductApplyStatis(Object param);
	
	/**
	 * 获取服务列表
	 * @author lichenghao
	 * @title :queryProductApplyList
	 * @Description:TODO
	 * @return List<TProductApplyInfo>
	 * @date 2016年5月25日 下午7:01:02
	 */
	public List<TProductApplyInfo> queryProductApplyList(ProductApplyUntreatedReq req);
	
	/**
	 * 获取随访报告发送服务
	 * @author lichenghao
	 * @title :queryFollowupReportByUserId
	 * @Description:TODO
	 * @return Object
	 * @date 2016年5月27日 下午7:38:03
	 */
	public String queryFollowupReportByUserId(Object param);
	
	/**
	 * 插入随访报告申请记录
	 * @author lichenghao
	 * @title :addFollowupReportApply
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年5月27日 下午8:07:25
	 */
	public Integer addFollowupReportApply(Object param);
	
	/**
	 * 更新审核状态。病案复印邮件服务使用
	 * 
	 * @param 
	 */
	public Integer updateAuditStateFinished(@Param("productApplyId")String productApplyId,@Param("buyer")Long buyer);
	
	/**
	 * 通过productId查询快递公司信息
	 * @author lichenghao
	 * @title :queryExpressCompanyNameByProductId
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月21日 上午10:21:59
	 */
	public ExpressCompany queryExpressCompanyNameByProductId(@Param("productId")String productId);
	/**
	 * <p>Title:getMdtApplyNo</p>
	 * <p>Description：获取产品服务的流程号</p>
	 * @author YYCHEN
	 * @date 2016年10月8日 下午3:28:28
	 * @param prefix 前缀
	 * @param productType
	 * @return
	 */
	public String findMdtApplyNo(@Param("prefix")String prefix, @Param("productType")Integer productType);
	/**
	 * <p>Title:findApplyInfo</p>
	 * <p>Description:查询服务申请信息（目前只填充患者姓名，申请医生姓名和申请医院ID值）</p>
	 * @author YYCHEN
	 * @date 2016年10月8日 下午5:45:08
	 * @param productApplyId
	 * @return
	 */
	public TProductApply findApplyInfo(String productApplyId);
	/**
	 * <p>Title:findMDTEmr</p>
	 * <p>Description:查询会诊病历资料</p>
	 * @author YYCHEN
	 * @date 2016年11月21日 下午4:57:19
	 * @param req
	 * @return
	 */
	public List<TMDTEmrInfo> findMDTEmr(MdtEmrUploadReq req);
	
	/**
	 * <p>Title:findEmrForwardFlag</p>
	 * <p>Description:查询患者病历资料或会诊资料是否已转发给患者</p>
	 * @author YYCHEN
	 * @date 2016年12月8日 上午10:20:01
	 * @param detailInfo
	 * @return
	 */
	public Integer findEmrForwardFlag(TMDTDetailInfo detailInfo);

	/**
	 * 获取服务流程信息
	 * @param productApplyId
	 * @return
	 */
	List<ServiceProgressResp> getServiceProgressInfos(String productApplyId);

	/**
	 * 获取唯一的服务码
	 * @return
	 */
	String getRandomProductApplyServiceCode();

	/**
	 * 添加服务流程
	 * @param serviceProgress
	 * @return
	 */
	int insertServiceProgress(ServiceProgressResp serviceProgress);

	String getUserDataByCallsid(String callsid);
}
