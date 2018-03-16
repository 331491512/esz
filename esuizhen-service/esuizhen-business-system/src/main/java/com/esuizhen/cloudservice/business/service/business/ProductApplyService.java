/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business;<br/>  
 * <b>文件名：</b>BusinessService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:49:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business;

import com.esuizhen.cloudservice.business.bean.*;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.TMDTDetailInfo;
import com.esuizhen.cloudservice.business.model.business.TMDTEmrInfo;
import com.esuizhen.cloudservice.business.model.business.TServiceSubscriptionInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.trade.TProductApplySync;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/** 
* @ClassName: BusinessService.java
* @Description: 
* @author lichenghao
* @date 2015年12月12日 下午4:49:58  
*/
public interface ProductApplyService {
	
	/**
	 * 
	 * @author lichenghao，DaLoong
	 * @title :createApplyProduct
	 * @Description:申请服务
	 * @return void
	 * @throws Exception 
	 * @date 2015年12月15日 下午3:21:04
	 */
	public TMsgResponse<Map<String, Object>> createApplyProduct(TProductApply productApply) throws Exception;
	/**
	 * 服务接受/同意/拒绝/取消
	 * @author lichenghao, DaLoong
	 * @title :setAcceptProduct
	 * @Description:TODO
	 * @return respCode
	 * @date 2015年12月15日 下午5:36:20
	 */
	public int setAcceptProduct(String productApplyId,int acceptFlag,Date consultOrderTime);
	
	/**
	 * 修改电话咨询时间
	 * @author lichenghao,DaLoong
	 * @title :modifyTelConsultingTime
	 * @Description:TODO
	 * @return void
	 * @throws Exception 
	 * @date 2015年12月15日 下午7:49:29
	 */
	public void modifyTelConsultingTime(TProductApply productApply) throws Exception;
	
	
	/**
	 * 图文咨询医生总结
	 * @author lichenghao,DaLoong
	 * @title :setSummarizeRichtextChatConsulting
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月15日 下午8:04:17
	 */
	public void setSummarizeRichtextChatConsulting(TProductApply productApply);
	
	/**
	 * 患者对医生评价
	 * @author lichenghao
	 * @title :setProductServiceEvaluate
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月15日 下午8:09:39
	 */
	public void setProductServiceEvaluate(TProductApply productApply);
	
	/**
	 * 获取患者对医生的评价
	 * @author lichenghao
	 * @title :getProductServiceEvaluation
	 * @Description:TODO
	 * @return void
	 * @date 2016年1月22日 下午3:57:17
	 */
	public ProductServiceApply getProductServiceEvaluation(String productApplyId);

	/**
	 * 检查订购关系
	 * @author DaLoong
	 * @date 2016/1/5
	 * @param buyer
	 * @param vendor
	 * @param productType
	 * @param productId 
	 * @return result.state: 0： 无订购关系； 1：有订购关系
	 */
	public TProductSubscriptionInfo checkProductSubscription(Long buyer, Long vendor,
			Integer productType, String productId);

	/**
	 * 查询订单状态信息
	 * @author DaLoong
	 * @date 2016/1/5
	 * @param buyer
	 * @param orderId
	 * @return
	 */
	public TProductSubscriptionInfo queryProductOrderState(Long buyer,
			String orderId);

	/**
	 * 产品申请同步
	 * @author DaLoong
	 * @date 2016/1/10
	 * @param productApplySync
	 * @return
	 * @throws Exception 
	 */
	public TMsgResponse<Map<String, Object>> createApplyProductSync(
			TProductApplySync productApplySync) throws Exception;

	/**
	 * 电话拨号
	 * @param productApply
	 * @author DaLoong
	 * @date 2016/1/14
	 * @return 
	 */
	public TMsgResponse<String> makeCallForTelConsulting(TProductApply productApply);
	/**
	 * 
	* @Title: queryMDTDetail 
	* @Description: 获取MDT详情 
	* @param @param orderId
	* @param @return    设定文件 
	* @return TMDTDetailInfo    返回类型 
	* @throws
	 */
	public TMDTDetailInfo queryMDTDetail(String orderId,Integer role,Long id);
	/**
	 * 
	* @Title: uploadMDTEmr 
	* @Description: 上传MDTEmr 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void uploadMDTEmr(MdtEmrUploadReq req);
	/**
	 * 
	* @Title: submitMDTEmr 
	* @Description: 提交MDTEmr 
	* @param @param req    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void submitMDTEmr(MdtEmrSubmitReq req);
	
	/**
	 * 查询产品订购关系列表
	 * @param buyer
	 * @param vendor
	 * @param productType
	 * @param sort 
	 * @return
	 */
	public List<TProductSubscriptionSimpleInfo> listProductSubscription(ProductSubscriptionReq req);
	/**
	 * 
	* @Title: listServiceSubscriptionInfo 
	* @Description: 查询医生的VIP订购列表 
	* @param @param vendor
	* @param @return    设定文件 
	* @return List<TServiceSubscriptionInfo>    返回类型 
	* @throws
	 */
	public List<TServiceSubscriptionInfo> listServiceSubscriptionInfo(Long vendor);
	
	/**
	 * 查看MDT病情评估
	 * @author lichenghao
	 * @title :getMdtDiseaseEvaluationInfo
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月8日 上午11:06:51
	 */
	public Object getMdtDiseaseEvaluationInfo(String productApplyId);
	
	/**
	 * 提交MDT病情评估报告
	 * @author lichenghao
	 * @title :submitMdtDiseaseEvaluation
	 * @Description:TODO
	 * @return void
	 * @date 2016年3月8日 上午11:08:20
	 */
	public void submitMdtDiseaseEvaluation(MdtDiseaseEvaluationSubmitReq req);
	
	/**
	 * 获取医院服务数据
	 * @author lichenghao
	 * @title :getProductHospitalServicePackList
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月18日 下午5:13:20
	 */
	public Object getProductHospitalServicePackList();
	
	
	/**
	 * 获取服务简要信息
	 * @author lichenghao
	 * @title :getProductApplySimpleInfo
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月18日 下午5:31:30
	 */
	public Object getProductApplySimpleInfo(String productApplyId);
	
	/**
	 * 代理申请服务列表
	 * @author lichenghao
	 * @title :listProductApply
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月24日 下午3:19:16
	 */
	public Object listProductApply(Long agentApplicant, int productType, Integer reqFlag);
	
	/**
	 * 检查是否有红点的服务
	 * @author lichenghao
	 * @title :checkProductApplyDot
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年3月27日 下午2:56:10
	 */
	public TMsgResponse<Object> checkProductApplyDot(Long agentApplicant);
	
	/**
	 * 删除点
	 * @author lichenghao
	 * @title :deleteApplyDot
	 * @Description:TODO
	 * @return void
	 * @date 2016年3月27日 下午5:50:27
	 */
	public void cancelApplyDot(String orderId);
	
	/**
	 * 查询服务购买者的信息列表
	 * @author jiayanzhao
	 * @title :listBuyerInfo
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月16日 下午5:50:27
	 */
	public List<TProductBuyerInfo> listProductBuyerInfo(Long vendor,int productType);
	
	/**
	 * 查询服务购买者的信息列表
	 * @author jiayanzhao
	 * @title :updateExpressNum
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月16日 下午5:50:27
	 */
	public void updateExpressNum(String productApplyId,String expressNum,Long buyer);
	
	/**
	 * 服务申请统计
	 * @author lichenghao
	 * @title :getProductApplyStatis
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月25日 下午5:12:46
	 */
	public TProductApplyStatisInfo getProductApplyStatis(ProductApplyStatisGetReq req);
	
	/**
	 * 未处理服务列表
	 * @author lichenghao
	 * @title :getUntreatedProductApplyList
	 * @Description:TODO
	 * @return Page<TProductApplyInfo>
	 * @date 2016年5月25日 下午6:13:05
	 */
	public Page<TProductApplyInfo> getUntreatedProductApplyList(ProductApplyUntreatedReq req);
	
	/**
	 * 确认收件
	 * @param productApplyId
	 * @param buyer
	 */
	public void confirmReceipt(String productApplyId, Long buyer);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :firstSendMessageRichText
	 * @Description:图文咨询首次内容发送
	 * @return void
	 * @date 2016年10月17日 下午7:36:23
	 */
	public void firstSendMessageRichText(RichTextFirstSendMessageReq req);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :agentApplyProduct
	 * @Description:服务代理申请
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2016年10月19日 下午8:09:17
	 */
	public TMsgResponse<Map<String, Object>> agentApplyProduct(TProductApply req)throws Exception;
	/**
	 * <p>Title:getMDTEmr</p>
	 * <p>Description:获取会诊病历资料</p>
	 * @author YYCHEN
	 * @date 2016年11月21日 下午4:54:38
	 * @param req
	 * @return
	 */
	public List<TMDTEmrInfo> getMDTEmr(MdtEmrUploadReq req);

	/**
	 * 获取申请服务的详细信息
	 * @author nidan
	 * @param productApplyId
	 * @param orderId
	 */
	TProductSubscriptionSimpleInfo getProductSubscriptionDetail(String productApplyId, String orderId);
	/**
	* @author fanpanwei
	* @date 2017年9月19日
	* @param 
	* @description:云之讯回调接口处理方法
	* @return
	 * @throws Exception 
	 */
	public void dealInputStreamFromYZX(HttpServletRequest request) throws Exception;
}
