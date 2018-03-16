package com.esuizhen.cloudservice.business.service.business.mdt.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.business.bean.MdtDoctorOptionInfo;
import com.esuizhen.cloudservice.business.bean.MetaMDTProductStateListReq;
import com.esuizhen.cloudservice.business.bean.TProductApply;
import com.esuizhen.cloudservice.business.dao.business.DoctorDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.mdt.MdtDoctorOptionDao;
import com.esuizhen.cloudservice.business.dao.business.mdt.MetaMDTProductDao;
import com.esuizhen.cloudservice.business.dao.business.mdt.SMDTApplyDao;
import com.esuizhen.cloudservice.business.model.business.SMDTApply;
import com.esuizhen.cloudservice.business.service.business.mdt.MDTDoctorOptionService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.structuration.TBottomInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushClientEventInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;

/** 
 * @ClassName: MDTDoctorOptionServiceImpl.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
@Service
public class MDTDoctorOptionServiceImpl implements MDTDoctorOptionService {
	private Locale locale = Locale.getDefault();
	@Autowired
	private MdtDoctorOptionDao doctorOptionDao; 
	@Autowired
	private MetaMDTProductDao metaMDTProductDao;
	@Autowired
	private ProductApplyDao productApplyDao;
	
	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private MessageInnerService messageService;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SMDTApplyDao sMDTApplyDao;
	@Autowired
	private PushInnerService pushService;
	
	@Override
	public void submitMdtDoctorOption(MdtDoctorOptionInfo mdtOption) {
		// TODO Auto-generated method stub
		if(mdtOption.getProductApplyId()!=null){
			if(mdtOption.getMdtFlowStateId()!=null && mdtOption.getFlag()!=null && mdtOption.getFlag()==1){
				mdtOption.setTemporaryFlag(1);//提交标识
				HashMap<String, Object> hm = new HashMap<String, Object>();
				int stepNum = 1;
				if(mdtOption.getNeedRadiateFlag()!=null && mdtOption.getNeedRadiateFlag()==0){
					stepNum=3;
					//hm.put("ruleState", 3);
				}
				//推送消息代码
				Integer groupType = mdtOption.getGroupType();
				if(groupType!=null){
					String tipContent = this.messageSource.getMessage("text.mdt.title", null, locale);
					TProductApply productApply = this.productApplyDao.findApplyInfo(mdtOption.getProductApplyId());
					SMDTApply sMDTApply = sMDTApplyDao.findByProductApplyId(mdtOption.getProductApplyId());
					if(groupType==1){
						if(mdtOption.getSpecimenIntactFlag()!=null){//标本检查
							mdtOption.setAcceptanceTimeFlag(1);//标识更新标本检查时间
							Doctor doctor = this.doctorDao.findPathologyDoctor(mdtOption.getProductApplyId());
							if (doctor != null) {
								String description = messageSource.getMessage("push.service.mdt.apply.basic.pathology.doctor.expert.news",
										new String[]{doctor.getTrueName(), productApply.getPatientName()}, locale);
								this.sendNewsToDoctor(tipContent, description, doctor.getUserId());
								
								push(sMDTApply , productApply , this.doctorDao.findByUserId(mdtOption.getDoctorUserId()) , stepNum);
							}
						}else{//病理提建议
							/*
							Doctor doctor = this.doctorDao.findProductGroupDoctor(mdtOption.getProductApplyId(), 2);
							String description = messageSource.getMessage("push.service.mdt.apply.internal.doctor.expert.news", new String[]{doctor.getTrueName(), productApply.getAgentApplicantName()}, locale);
							this.sendNewsToDoctor(tipContent, description, doctor.getUserId());
							 */
							Doctor doctor = this.doctorDao.findByUserId(productApply.getAgentApplicant());
							String description = messageSource.getMessage("push.service.mdt.apply.doctor.finished.pathology.doctor",
									new String[]{doctor.getTrueName(), productApply.getPatientName()}, locale);
							this.sendNewsToDoctor(tipContent, description, productApply.getAgentApplicant());
						}
					}else if(groupType==2){//内科
						Doctor doctor = this.doctorDao.findByUserId(productApply.getAgentApplicant());
						String description = null;
						if (mdtOption.getNeedRadiateFlag() == 1) {//需要放射检查
							/*
							DoctorSimpleInfo doctorSimpleInfo = this.doctorDao.queryDoctorSimpleInfo(null, mdtOption.getRadiateUserId());
							String description = messageSource.getMessage("push.service.mdt.apply.radiology.doctor.expert.news", new String[]{doctorSimpleInfo.getTrueName(), productApply.getAgentApplicantName()}, locale);
							this.sendNewsToDoctor(tipContent, description, doctorSimpleInfo.getUserId());
							 */
							description = messageSource.getMessage("push.service.mdt.apply.doctor.finished.internal.doctor",
									new String[]{doctor.getTrueName(), productApply.getPatientName()}, locale);
						} else {//不需要放射科检查
							description = messageSource.getMessage("push.service.mdt.apply.basic.doctor.expert.news",
									new String[]{doctor.getTrueName(), productApply.getPatientName()}, locale);
						}
						this.sendNewsToDoctor(tipContent, description, productApply.getAgentApplicant());
					}else if(groupType==3){//放射
						stepNum=2;
						Doctor doctor = this.doctorDao.findByUserId(productApply.getAgentApplicant());
						TProductApply tProductApply = this.productApplyDao.findApplyInfo(mdtOption.getProductApplyId());
						String description = messageSource.getMessage("push.service.mdt.apply.basic.doctor.expert.news",
								new String[]{doctor.getTrueName(), productApply.getPatientName()}, locale);
						this.sendNewsToDoctor(tipContent, description, tProductApply.getAgentApplicant());
					}
					
					hm.put("ruleState", stepNum);
					
					hm.put("mdtFlowStateId", mdtOption.getMdtFlowStateId());
					List<MetaMDTProductStateListReq> list = metaMDTProductDao.getMetaMDTProductStateList(hm);
					mdtOption.setMdtFlowStateId(list.get(0).getMdtFlowStateId());
					
					if("报告完成".equals(list.get(0).getShowName()))
					{
						push2(sMDTApply , productApply , list.get(0).getMdtFlowStateId());
					}
				}
			}else{
				mdtOption.setTemporaryFlag(0);//暂存标识
			}
			this.doctorOptionDao.updateMdtapplyInfo(mdtOption);
		}
		if(mdtOption.getSpecimenIntactFlag()==null){//非切片标本损坏时走存意见，切片环节不走
			if(mdtOption.getId()!=null){//建议的id，为空时新增，当不为空是更新
				doctorOptionDao.updateDoctorOption(mdtOption);
			}else{
				doctorOptionDao.insertDoctorOption(mdtOption);
			}
		}
	}

	//给医生推送消息
	private void sendNewsToDoctor(String tipContent, String description, Long doctorUserId) {
		String content = ImMessageUtil.getPicTextMessage(description, null);
		ImMessageInfo message = ImMessageUtil.getEDoctorAssistCustomMessage(doctorUserId, content, tipContent);
		//message.setServiceId(1);
		this.messageService.sendInnerMessage(message);
	}

	
	public void push(SMDTApply sMDTApply , TProductApply productApply , Doctor doctor , int stepNum)
	{
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("ruleState", stepNum);
		hm.put("mdtFlowStateId", sMDTApply.getMdtFlowStateId());
		List<MetaMDTProductStateListReq> list = metaMDTProductDao.getMetaMDTProductStateList(hm);
		
		String message = messageSource.getMessage("push.service.mdt.state2", new Object[] {doctor.getTrueName(), productApply.getApplyHospitalName(),productApply.getAgentApplicantName() , productApply.getPatientName() }, Locale.getDefault());
		TStructuredMsg<TButtonMsg> struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		// 设置标题。带颜色
		buttonMsg.setTitle(null);
		buttonMsg.setDescription(message);
		buttonMsg.setPrice(null);
		buttonMsg.setButton(null);
		TBottomInfo bottomInfo = new TBottomInfo();
		buttonMsg.setBottom(bottomInfo);
		bottomInfo.setText("填写病理会诊意见");
		bottomInfo.setUrl("event://mdt/pathology/write?id="+sMDTApply.getId()+"&mdtFlowStateId="+list.get(0).getMdtFlowStateId()+"&doctorId="+doctor.getDoctorId()+"&userId="+doctor.getUserId() +"&cardType=2" );
		ImMessageInfo im = ImMessageUtil.getEDoctorAssistCustomMessage(doctor.getUserId(),
				JsonUtil.toJson(struMsg), message);

		// pushcontent
		Map<String,Object> eventInfo = new HashMap<String, Object>();
		eventInfo.put("userId", Constant.User.SuizhenAssist);
		PushClientEventInfo event = new PushClientEventInfo();
		event.setEventType(Constant.Push.EVENT_TYPE_MDT_STATE2);
		event.setEventTip(message);
		event.setEventInfo(JsonUtil.toJson(eventInfo));

		// set pushcontent
		im.setPushContent(JsonUtil.toJson(event));
		messageService.sendInnerMessage(im);
	}
	
	public void push2(SMDTApply sMDTApply , TProductApply productApply , int mdtFlowStateId )
	{
		
		String message = messageSource.getMessage("push.service.mdt.state6", new Object[] {productApply.getAgentApplicantName() , productApply.getPatientName() }, Locale.getDefault());
		TStructuredMsg<TButtonMsg> struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		// 设置标题。带颜色
		buttonMsg.setTitle(null);
		buttonMsg.setDescription(message);
		buttonMsg.setPrice(null);
		buttonMsg.setButton(null);
		TBottomInfo bottomInfo = new TBottomInfo();
		buttonMsg.setBottom(bottomInfo);
		bottomInfo.setText("点击查看会诊报告");
		bottomInfo.setUrl("event://mdt/pathology/write?id="+sMDTApply.getId()+"&mdtFlowStateId="+mdtFlowStateId+"&doctorId="+productApply.getAgentApplicantId()+"&userId="+productApply.getAgentApplicant() +"&cardType=14" );
		ImMessageInfo im = ImMessageUtil.getEDoctorAssistCustomMessage(productApply.getAgentApplicant(),
				JsonUtil.toJson(struMsg), message);

		// pushcontent
		Map<String,Object> eventInfo = new HashMap<String, Object>();
		eventInfo.put("userId", Constant.User.SuizhenAssist);
		PushClientEventInfo event = new PushClientEventInfo();
		event.setEventType(Constant.Push.EVENT_TYPE_MDT_STATE6);
		event.setEventTip(message);
		event.setEventInfo(JsonUtil.toJson(eventInfo));

		// set pushcontent
		im.setPushContent(JsonUtil.toJson(event));
		messageService.sendInnerMessage(im);
	}
}
