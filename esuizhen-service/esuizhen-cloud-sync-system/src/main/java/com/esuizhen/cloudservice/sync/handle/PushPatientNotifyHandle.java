/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.handle;<br/>  
 * <b>文件名：</b>PushPatientNotifyHandle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月5日上午11:16:49<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.handle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.user.TTobeconfirmedPatient;
import com.westangel.common.constant.Constant;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushUtil;

/** 
* @ClassName: PushPatientNotifyHandle
* @Description: 
* @author lichenghao
* @date 2017年4月5日 上午11:16:49  
*/
@Component
public class PushPatientNotifyHandle {
	@Autowired
	private PushInnerService pushService;
	@Autowired
	private MessageSource messageSource;
	private Locale locale = Locale.getDefault();
	
	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;
	@Value("${server.h5.patient.confirm.match.info.content}")
	private String patientConfirmMatchInfoContent;
	/**
	 * 通知患者已与ToB导入的患者信息相似，需要确认合并
	 * @param user
	 * @param name
	 * @param diseaseTypeName
	 */
	private void sendNotifyToPatientForMatchMobilePatient(TTobeconfirmedPatient tobeconfirmedPatient) {
		StringBuilder text = new StringBuilder();
		if (tobeconfirmedPatient.getSex() != null && tobeconfirmedPatient.getSex() != 0) {
			text.append("性别=");
			text.append(tobeconfirmedPatient.getSex() == Constant.SEX_WOMAN ? "女" : "男");
		}
		if (tobeconfirmedPatient.getBirthDate() != null) {
			text.append(",出生日期=" + DateUtils.formatDate(tobeconfirmedPatient.getBirthDate(), "yyyy年MM月dd日"));
		}
		text.append(",手机号=" + tobeconfirmedPatient.getMobile());
		if (StringUtils.isNotEmpty(tobeconfirmedPatient.getHospitalName())) {
			text.append(",就诊医院=" + tobeconfirmedPatient.getHospitalName());
		}
		if (tobeconfirmedPatient.getInhospitalDate() != null) {
			text.append(",入院日期=" + DateUtils.formatDate(tobeconfirmedPatient.getInhospitalDate(), "yyyy年MM月dd日"));
		}
		if (StringUtils.isNotEmpty(tobeconfirmedPatient.getDiseaseTypeName())) {
			text.append(",主要诊断=" + tobeconfirmedPatient.getDiseaseTypeName());
		}
		if (text.toString().indexOf(",") == 0) {
			text = text.replace(0, 1, "");
		}
		try{
			if(tobeconfirmedPatient != null && tobeconfirmedPatient.getUserId() > 0&&tobeconfirmedPatient.getProductId()!=null){
				String mobile = tobeconfirmedPatient.getMobile().substring(0, 3);
				String content = messageSource.getMessage("push.patient.match.mobile.tobpatient", new String[]{mobile + "xxxx" + tobeconfirmedPatient.getMobile().substring(7)}, locale);
				List<String> values = new ArrayList<String>();
				values.add(content);
				values.add(tobeconfirmedPatient.getTrueName());
				values.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
				values.add("确认身份信息");
				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(followuWxTtemplateName, this.serverH5UrlRoot + this.patientConfirmMatchInfoContent + 
						"?trueName=" + tobeconfirmedPatient.getTrueName() + "&tipText=" + text + ",uuid:" + tobeconfirmedPatient.getUuid() + ",userId:" + tobeconfirmedPatient.getUserId() + ",userRole:1", values);
				notify.setUserId(tobeconfirmedPatient.getUserId());
				notify.setProductId(tobeconfirmedPatient.getProductId());
				this.pushService.push(notify);
			}
		} catch (Exception e){
			e.printStackTrace();
			LogUtil.logError.error("sendNotifyToPatientForRealnameAuthentication() failed:" + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendNotifyToPatientForMatchIdenficationPatient
	 * @Description:身份证号匹配
	 * @return void
	 * @date 2017年4月14日 下午3:48:51
	 */
	private void sendNotifyToPatientForMatchIdentificationPatient(TTobeconfirmedPatient tobeconfirmedPatient) {
		StringBuilder text = new StringBuilder();
		if (tobeconfirmedPatient.getSex() != null && tobeconfirmedPatient.getSex() != 0) {
			text.append("性别=");
			text.append(tobeconfirmedPatient.getSex() == Constant.SEX_WOMAN ? "女" : "男");
		}
		if (tobeconfirmedPatient.getBirthDate() != null) {
			text.append(",出生日期=" + DateUtils.formatDate(tobeconfirmedPatient.getBirthDate(), "yyyy年MM月dd日"));
		}
		text.append(",证件号=" + tobeconfirmedPatient.getIdentification());
		if (StringUtils.isNotEmpty(tobeconfirmedPatient.getHospitalName())) {
			text.append(",就诊医院=" + tobeconfirmedPatient.getHospitalName());
		}
		if (tobeconfirmedPatient.getInhospitalDate() != null) {
			text.append(",入院日期=" + DateUtils.formatDate(tobeconfirmedPatient.getInhospitalDate(), "yyyy年MM月dd日"));
		}
		if (StringUtils.isNotEmpty(tobeconfirmedPatient.getDiseaseTypeName())) {
			text.append(",主要诊断=" + tobeconfirmedPatient.getDiseaseTypeName());
		}
		if (text.toString().indexOf(",") == 0) {
			text = text.replace(0, 1, "");
		}
		try{
			if(tobeconfirmedPatient != null && tobeconfirmedPatient.getUserId() > 0&&tobeconfirmedPatient.getProductId()!=null){
				String identification = tobeconfirmedPatient.getIdentification();
				identification = identification.substring(0,identification.length()-4)+"xxxx";
				String content = messageSource.getMessage("push.patient.match.identification.tobpatient", new String[]{identification}, locale);
				List<String> values = new ArrayList<String>();
				values.add(content);
				values.add(tobeconfirmedPatient.getTrueName());
				values.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
				values.add("确认身份信息");
				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(followuWxTtemplateName, this.serverH5UrlRoot + this.patientConfirmMatchInfoContent + 
						"?trueName=" + tobeconfirmedPatient.getTrueName() + "&tipText=" + text + ",uuid:" + tobeconfirmedPatient.getUuid() + ",userId:" + tobeconfirmedPatient.getUserId() + ",userRole:1", values);
				notify.setUserId(tobeconfirmedPatient.getUserId());
				notify.setProductId(tobeconfirmedPatient.getProductId());
				this.pushService.push(notify);
			}
		} catch (Exception e){
			e.printStackTrace();
			LogUtil.logError.error("sendNotifyToPatientForRealnameAuthentication() failed:" + e.getMessage());
		}
	}
	
	//给患者推送消息
	public void pushNotifyToPatient(TTobeconfirmedPatient patient) {
		if(patient.getMatchType()==ConstantSync.MATCH_TYPE_MOBILE)
			this.sendNotifyToPatientForMatchMobilePatient(patient);
		if(patient.getMatchType()==ConstantSync.MATCH_TYPE_IDENTIFICATION)
			this.sendNotifyToPatientForMatchIdentificationPatient(patient);
	}
}
