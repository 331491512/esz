/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.notify.sender;<br/>  
 * <b>文件名：</b>ExpressNotifySender.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日下午5:02:42<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.notify.sender;

import com.alibaba.fastjson.JSONObject;
import com.esuizhen.cloudservice.business.dao.business.ExpressServiceDetailDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: ExpressNotifySender
* @Description: 
* @author lichenghao
* @date 2017年1月6日 下午5:02:42  
*/
@Component
public class ExpressNotifySender {
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private ExpressServiceDetailDao dao;
	@Value("${server.wx.url.root}")
	private String serverH5UrlRoot;
	@Value("${url.api.business.record.post.index}")
	private String indexPage;
	
	public void sendExpressProgressNotify(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		if(psa.getProductSubType().equals(901)){
			switch(psa.getProgressState()){
				case -1: //失败
				case -3://地址错误
				case 1://已出院
				case 3: //已归档
				case 4: //已复印
					sendExpressMessageNotifyToPatient(psa);
					break;
				default:
					break; //do nothing
			}
		}else if(psa.getProductSubType().equals(902)){
			switch(psa.getProgressState()){
				case -1: //失败
				case -3://地址错误
				case 6://已领取
					sendExpressMessageNotifyToPatient(psa);
					break;
				default:
					break; //do nothing
			}
		}
	}
	
	public void sendExpressApplyNotifyToPatient(TOrderPublishInfo orderInfo){
		String inhospitalDates = getInhospitalDates(orderInfo.getProductApplyId());
		List<String> values = new ArrayList<String>();

		if(orderInfo.getProductSubType().equals(Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL_EXPRESS)){
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.apply.notify.first")));
			values.add(orderInfo.getOrderId());
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.apply.notify.keyword2",inhospitalDates)));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.apply.notify.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.remark")));
		}else if(orderInfo.getProductSubType().equals(Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_RECEIVE)){
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.medicalrecord.apply.notify.first")));
			values.add(orderInfo.getOrderId());
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.apply.notify.keyword2",inhospitalDates)));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.apply.notify.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.medicalrecord.progress.remark")));
		}
		String url = serverH5UrlRoot+indexPage+"?productSubType="+orderInfo.getProductSubType()+"&productApplyId="+orderInfo.getProductApplyId()
				+"&orderId="+orderInfo.getOrderId();
		PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("dingdanzhuangtaigenxingtongzhi", url,
				values);
		notifyInfo.setUserId(orderInfo.getBuyer());
		PushNotifyUtil.setSendWxProductId(notifyInfo, orderInfo.getWxProductId());
		pushInnerService.push(notifyInfo);
	}
	
	private void sendExpressMessageNotifyToPatient(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		List<String> values = getValues(psa);
		String url = serverH5UrlRoot+indexPage+"?productSubType="+psa.getProductSubType()+"&productApplyId="+psa.getProductApplyId()
				+"&orderId="+psa.getOrderId();
		PushNotifyInfo notifyInfo = PushUtil.getWxTemplatePushNotifyInfo("dingdanzhuangtaigenxingtongzhi", url,
				values);
		notifyInfo.setUserId(psa.getBuyer());
		if(psa.getWxProductId()!=null)
			notifyInfo.setProductId(psa.getWxProductId());
		PushNotifyUtil.setSendWxProductId(notifyInfo, psa.getWxProductId());
		pushInnerService.push(notifyInfo);
	}
	
	private List<String> getValues(ProductServiceApply psa){
		List<String> values = new ArrayList<String>();
		String inhospitalDates = getInhospitalDates(psa.getProductApplyId());
		if(psa.getProgressState()==-1||psa.getProgressState()==-3){//失败
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.-1.first", psa.getCause())));
			values.add(psa.getOrderId());
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.-1.keyword2")));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.-1.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.-1.remark")));
		}else if(psa.getProgressState()==3){//归档
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.3.first")));
			values.add(psa.getOrderId());
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.3.keyword2",inhospitalDates)));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.3.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.remark")));
		}else if(psa.getProgressState()==4){//复印
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.4.first")));
			values.add(psa.getOrderId());
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.4.keyword2",inhospitalDates)));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.4.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.remark")));
		}else if(psa.getProgressState()==6){//领取
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.6.first")));
			values.add(psa.getOrderId());
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.6.keyword2",inhospitalDates)));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.6.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.remark")));
		}else if(psa.getProgressState()==1){//离院
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.1.first")));
			values.add(psa.getOrderId());
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.1.keyword2",inhospitalDates)));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.1.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.remark")));
		}

		/*else if(psa.getProgressState()==5){//已邮寄,已处理
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.5.first",this.getExpressNo(psa))));
			values.add(psa.getOrderId());
			values.add(this.getExpressCompany(psa));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.5.keyword3")));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getBusinessPushContent("product.service.express.progress.remark")));
		}*/
		return values;
	}

	private String getExpressNo(ProductServiceApply psa){
		try {
			JSONObject json=JSONObject.parseObject(psa.getRemark());
			return json.get("expressNo").toString();
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
			return "";
		}
	}

	private String getExpressCompany(ProductServiceApply psa){
		return dao.queryExpressCompany(psa.getProductApplyId());
	}
	
	private String getInhospitalDates(String productApplyId){
		List<Date> list = dao.queryInhospitalDate(productApplyId);
		StringBuffer inhospitalDates = new StringBuffer();
		if(list!=null&&!list.isEmpty())
			for(Date date:list){
				if(inhospitalDates.length()>0)
					inhospitalDates.append(",");
				inhospitalDates.append(DateUtil.getDateStr(date));
			}
		return inhospitalDates.toString();
	}
}
