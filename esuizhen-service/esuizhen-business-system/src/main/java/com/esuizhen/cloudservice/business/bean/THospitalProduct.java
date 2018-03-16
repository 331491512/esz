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

import java.util.Date;

import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.TradeUtil;

/**
 * 医院服务
* @ClassName: THospitalProduct 
* @Description: (这里用一句话描述这个类的作用) 
* @author lichenghao
* @date 2016年3月18日 下午4:10:06
 */
public class THospitalProduct {
	
	private Long hospitalUserId;//医院用户名
	
	private Integer hospitalId;//医院id
	
	private String hospitalName;//医院名称
	
	private String contactName;//联系人姓名
	
	private String contactMobile;//联系人电话

	public Long getHospitalUserId() {
		return hospitalUserId;
	}

	public void setHospitalUserId(Long hospitalUserId) {
		this.hospitalUserId = hospitalUserId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	
}
