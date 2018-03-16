package com.esuizhen.cloudservice.business.service.business.mdt.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.business.bean.MdtReq;
import com.esuizhen.cloudservice.business.bean.MetaMDTProductStateListReq;
import com.esuizhen.cloudservice.business.bean.TMDTApplyInfo;
import com.esuizhen.cloudservice.business.bean.TMDTWaxExpressReq;
import com.esuizhen.cloudservice.business.bean.TProductApply;
import com.esuizhen.cloudservice.business.dao.business.DoctorDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.mdt.MdtProductDao;
import com.esuizhen.cloudservice.business.dao.business.mdt.SMDTApplyDao;
import com.esuizhen.cloudservice.business.model.business.SMDTApply;
import com.esuizhen.cloudservice.business.service.business.mdt.MdtProductService;
import com.esuizhen.cloudservice.business.service.business.mdt.MetaMDTDataUnitService;
import com.esuizhen.cloudservice.business.util.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.PageUtil;

@Service
public class MdtProductServiceImpl implements MdtProductService {
	private Locale locale = Locale.getDefault();

	@Autowired
	private MdtProductDao mdtDiagnosisDao;
	@Autowired
	private ProductApplyDao productApplyDao;
	@Autowired
	private SMDTApplyDao sMDTApplyDao;

	@Autowired
	private MessageInnerService messageService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MetaMDTDataUnitService metaMDTDataUnitService;

	@Autowired
	private DoctorDao doctorDao;

	public Integer findSMdtAppleByUserId(Long userId)
	{
		return sMDTApplyDao.findSMdtAppleByUserId(userId);
	}
	
	@Override
	public int getMdtStatis(Long userId, Integer mdtFlowStateId, Integer flag, Integer mdtRole, Integer userRole) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("userId", userId);
		paramsMap.put("mdtFlowStateId", mdtFlowStateId);
		paramsMap.put("flag", flag);
		paramsMap.put("mdtRole", mdtRole);
		paramsMap.put("userRole", userRole);
		return mdtDiagnosisDao.getMdtStatis(paramsMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TMDTApplyInfo> queryMdtList(MdtReq req) {
		Map<String, Object> paramsMap = BeanUtils.toMap(req);
		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TMDTApplyInfo> list = mdtDiagnosisDao.queryMdtList(paramsMap);
		return PageUtil.returnPage((com.github.pagehelper.Page<?>) list);
	}

	@Transactional
	@Override
	public boolean expressMDTWax(TMDTWaxExpressReq waxExpressReq) throws InsufficientParameterExcption {
		if (StringUtils.isEmpty(waxExpressReq.getProductApplyId())) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		if (waxExpressReq.getFlag() != null && waxExpressReq.getFlag() == 1) {
			SMDTApply smdtApply = this.sMDTApplyDao.findByProductApplyId(waxExpressReq.getProductApplyId());
			if (smdtApply == null || smdtApply.getMdtFlowStateId() == null) {
				smdtApply = new SMDTApply();
				smdtApply.setMdtFlowStateId(1);
			}
			List<MetaMDTProductStateListReq> mdtProductStateListReqs = this.metaMDTDataUnitService
					.getMetaMDTProductStateList(null, null, 1, new Long(smdtApply.getMdtFlowStateId()));
			waxExpressReq.setMdtFlowStateId(mdtProductStateListReqs.get(0).getMdtFlowStateId());
			
			//给申请医生通知样本已寄出
			TProductApply productApply = this.productApplyDao.findApplyInfo(waxExpressReq.getProductApplyId());
			Doctor doctor = this.doctorDao.findByUserId(productApply.getAgentApplicant());
			String tipContent = this.messageSource.getMessage("text.mdt.title", null, locale);
			String description = messageSource.getMessage("push.service.mdt.apply.doctor.finished.simple.mail.notice",
					new String[]{doctor.getTrueName(), productApply.getPatientName()}, locale);
			this.sendNewsToDoctor(tipContent, description, productApply.getAgentApplicant());
			
			/*
			// 给病理专家推送消息
			description = messageSource.getMessage("push.service.mdt.apply.pathology.doctor.expert.news",
					new String[] { doctor.getTrueName(), productApply.getAgentApplicantName() }, locale);
			doctor = this.doctorDao.findProductGroupDoctor(waxExpressReq.getProductApplyId(), 1);
			this.sendNewsToDoctor(description, tipContent, doctor.getUserId());
			*/
		} else {
			waxExpressReq.setMdtFlowStateId(null);
		}
		this.sMDTApplyDao.update(waxExpressReq);
		return true;
	}

	//给医生推送消息
	private void sendNewsToDoctor(String tipContent, String description, Long doctorUserId) {
		String content = ImMessageUtil.getPicTextMessage(description, null);
		ImMessageInfo message = ImMessageUtil.getEDoctorAssistCustomMessage(doctorUserId, content, tipContent);
		//message.setServiceId(1);
		this.messageService.sendInnerMessage(message);
	}
}
