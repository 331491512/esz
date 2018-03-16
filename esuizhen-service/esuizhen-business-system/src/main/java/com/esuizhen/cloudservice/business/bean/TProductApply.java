/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TProductApply.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日上午11:15:34<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.westangel.common.bean.TToBApplyInfo;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.TradeUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/** 
* @ClassName: TProductApply
* @Description: 服务申请
* @author lichenghao
* @date 2015年12月15日 上午11:15:34  
*/
public class TProductApply {
	
	//产品订购信息
	private TOrderPublishInfo orderInfo;
	
	//B端信息
	private TToBApplyInfo toBApplyInfo;
	
	//支付信息（实际上不再需要）
	private TOrderPayInfo payInfo;
	
	//服务申请编号
	private String productApplyId;
	
	//MDT详情
	private TMDTApplyInfo mdtApplyInfo;
	
	//接收状态
	private int acceptFlag;
	
	
	//图文医生总结内容
	private String summarization;
	
	//患者评价等级
	private int   serviceLevel;
	
	//患者对医生总结
	private String evaluationRemark;
	
	//商品类型 1:图文咨询；2:电话咨询；3:预约挂号；4:MDT（专家组会诊);5: 私人医生;6:医院便利包；7：医院病情监控包
	private int productType;
	
	//预定咨询时间
	private Date consultOrderTime;
	
	//过期时间
	private Date expireTime;
	
	private String mobile; //患者电话
	
	private String fromMobile;//医生电话。当医生拨号时，可以修改电话，此即为修改后的电话，否则为医生的注册手机号
	
	//付款方
	private Long buyer;
	//患者姓名
	private String patientName;
	//申请医生的用户ID
	private Long agentApplicant;
	//申请医生ID
	private Long agentApplicantId;
	//申请医生姓名
	private String agentApplicantName;
	//申请单位ID
	private Integer applyHospitalId;
	//申请单位名称
	private String applyHospitalName;
    //专家组名称	
	private String groupName;
	//患者ID
	private Long patientId;

	public TOrderPublishInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(TOrderPublishInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public TOrderPayInfo getPayInfo() {
		return payInfo;
	}

	public Long getAgentApplicant() {
		return agentApplicant;
	}

	public void setAgentApplicant(Long agentApplicant) {
		this.agentApplicant = agentApplicant;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAgentApplicantName() {
		return agentApplicantName;
	}

	public void setAgentApplicantName(String agentApplicantName) {
		this.agentApplicantName = agentApplicantName;
	}

	public Integer getApplyHospitalId() {
		return applyHospitalId;
	}

	public void setApplyHospitalId(Integer applyHospitalId) {
		this.applyHospitalId = applyHospitalId;
	}

	public void setAcceptFlag(int acceptFlag) {
		this.acceptFlag = acceptFlag;
	}

	public void setServiceLevel(int serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public void setPayInfo(TOrderPayInfo payInfo) {
		this.payInfo = payInfo;
	}
	
	public String getProductApplyId() {
		return productApplyId;
	}

	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}

	public int getAcceptFlag() {
		return acceptFlag;
	}

	public void setAcceptFlag(Integer acceptFlag) {
		this.acceptFlag = acceptFlag;
	}

	
	public String getSummarization() {
		return summarization;
	}

	public void setSummarization(String summarization) {
		this.summarization = summarization;
	}

	public int getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(Integer serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getEvaluationRemark() {
		return evaluationRemark;
	}

	public void setEvaluationRemark(String evaluateRemark) {
		this.evaluationRemark = evaluateRemark;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public ProductServiceApply createProductServiceApply() {
		// TODO Auto-generated method stub
		ProductServiceApply psa = new ProductServiceApply();
		if(orderInfo!=null){
			if(StringUtils.isNotEmpty(productApplyId))
				psa.setProductApplyId(productApplyId);
			else
				psa.setProductApplyId(GeneralUtil.generatorUUID("APPL"));
			psa.setBuyer(orderInfo.getBuyer());
			psa.setVendor(orderInfo.getVendor());
			psa.setProductId(orderInfo.getProductId());
			psa.setProductType(orderInfo.getProductType());
			psa.setProductSubType(orderInfo.getProductSubType());
			psa.setOrderTitle(orderInfo.getOrderTitle());
			if(orderInfo.getContactMobile()==null)
				orderInfo.setContactMobile("");
			psa.setContactMobile(orderInfo.getContactMobile());
			if(orderInfo.getInPackage()==1) 
				orderInfo.setState(1); //套餐内产品，直接置为state=1(已支付）
			else if(orderInfo.getRealPrice()==0)
				orderInfo.setState(1);//0元产品，直接置为state=1(已支付)
			else if(orderInfo.getDiscountPrice()!=null&&orderInfo.getRealPrice()==orderInfo.getDiscountPrice())
				orderInfo.setState(1);//实际价格 等于 抵扣价格
			psa.setState(orderInfo.getState());
			psa.setSubscriptionFlag(TradeUtil.getSubscriptionFlag(psa.getState()));
			psa.setInPackage(orderInfo.getInPackage());
			psa.setRealPrice(orderInfo.getRealPrice());
			if(orderInfo.getRemark()!=null && !orderInfo.getRemark().isEmpty())
				psa.setRemark(orderInfo.getRemark());
			else
				psa.setRemark(orderInfo.getOrderTitle());
			//设置超时时间。超过这个时间仍未处理，则取消服务。目前统一设为24小时。可在conf_product_service表配置
			psa.setIdleCancelTime(DateUtil.getOffsetDate(Constant.Business.SERVICE_TIMEOUT));
			psa.setDescription(orderInfo.getDescription());
			psa.setTreatmentCourse(orderInfo.getTreatmentCourse());
			psa.setExplain(orderInfo.getExplain());
			if(orderInfo.getAgentApplicant()!=null)
				psa.setAgentApplicant(orderInfo.getAgentApplicant());
			if(orderInfo.getRecommendedDoctor()!=null)
				psa.setRecommendedDoctor(orderInfo.getRecommendedDoctor());
			
			//申请来源
			if(orderInfo.getWxProductId()!=null)
				psa.setWxProductId(orderInfo.getWxProductId());
			else if(orderInfo.getAgentApplicant()==null)//如果不是医生申请
				psa.setWxProductId(Constant.Push.WEIXIN_BIND_DEFAULT_PRODUCT_ID);
			psa.setApplySource(orderInfo.getApplySource()); 
			
			//关联服务处理
			if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_GRATUITY&&StringUtils.isNotEmpty(orderInfo.getDescription())){//如果为打赏服务
				psa.setrProductApplyId(orderInfo.getDescription());
			}
		}
		return psa;
	}

	/**
	 * @return the consultOrderTime
	 */
	public Date getConsultOrderTime() {
		return consultOrderTime;
	}

	/**
	 * @param consultOrderTime the consultOrderTime to set
	 */
	public void setConsultOrderTime(Date consultOrderTime) {
		this.consultOrderTime = consultOrderTime;
	}

	/**
	 * @return the expireTime
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the fromMobile
	 */
	public String getFromMobile() {
		return fromMobile;
	}

	/**
	 * @param fromMobile the fromMobile to set
	 */
	public void setFromMobile(String fromMobile) {
		this.fromMobile = fromMobile;
	}

	public TMDTApplyInfo getMdtApplyInfo() {
		return mdtApplyInfo;
	}

	public void setMdtApplyInfo(TMDTApplyInfo mdtApplyInfo) {
		this.mdtApplyInfo = mdtApplyInfo;
	}

	public Long getBuyer() {
		return buyer;
	}

	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	public TToBApplyInfo getToBApplyInfo() {
		return toBApplyInfo;
	}

	public void setToBApplyInfo(TToBApplyInfo toBApplyInfo) {
		this.toBApplyInfo = toBApplyInfo;
	}

	public String getApplyHospitalName()
	{
		return applyHospitalName;
	}

	public void setApplyHospitalName(String applyHospitalName)
	{
		this.applyHospitalName = applyHospitalName;
	}

	public Long getAgentApplicantId()
	{
		return agentApplicantId;
	}

	public void setAgentApplicantId(Long agentApplicantId)
	{
		this.agentApplicantId = agentApplicantId;
	}

	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	public Long getPatientId()
	{
		return patientId;
	}

	public void setPatientId(Long patientId)
	{
		this.patientId = patientId;
	}	
	
	
	
}
