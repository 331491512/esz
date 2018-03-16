/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.util;<br/>  
 * <b>文件名：</b>ProductUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月3日下午4:52:03<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.westangel.common.constant.Constant;

/** 
* @ClassName: ProductUtil
* @Description: 
* @author lichenghao
* @date 2016年6月3日 下午4:52:03  
*/
@Component
public class ProductUtil {
	//图文咨询
	public  static String richTextConsulting;
	//电话咨询
	public static String telconsult;
	//预约加号
	public static String clinic;
	//私人医生
	public static String privateDoctor;
	//MDT
	public static String mdt;
	
	@Value("${tips.richtextconsult.title}")
	public  void setRichTextConsulting(String richTextConsulting) {
		ProductUtil.richTextConsulting = richTextConsulting;
	}


	@Value("${tips.text.telconsult.title}")
	public  void setTelconsult(String telconsult) {
		ProductUtil.telconsult = telconsult;
	}


	@Value("${tips.clinic.title}")
	public void setClinic(String clinic) {
		ProductUtil.clinic = clinic;
	}


	@Value("${tips.private.doctor.title}")
	public void setPrivateDoctor(String privateDoctor) {
		ProductUtil.privateDoctor = privateDoctor;
	}


	@Value("${tips.mdt.title}")
	public static void setMdt(String mdt) {
		ProductUtil.mdt = mdt;
	}



	public static final String  getProductName(Integer productType){
		String productName=null;
		switch (productType) {
		case Constant.Business.PRODUCT_TYPE_RICHTEXT:
			productName = richTextConsulting;
			break;
		case Constant.Business.PRODUCT_TYPE_TEL:
			productName = telconsult;
			break;
		case Constant.Business.PRODUCT_TYPE_CLINIC:
			productName = clinic;
			break;
		case Constant.Business.PRODUCT_TYPE_MDT:
			productName = mdt;
			break;
		case Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR:
			productName = privateDoctor;
			break;
		case Constant.Business.PRODUCT_TYPE_CONVENIENT:
			break;
		case Constant.Business.PRODUCT_TYPE_MONITOR_ILLNESS:
			break;
		case Constant.Business.PRODUCT_TYPE_OFFLINE:
			break;
		case Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL:
			break;
		case Constant.Business.PRODUCT_TYPE_INSPECTION_RESULT:
			break;
		default:
			break;
		}
		return productName;
	}
}
