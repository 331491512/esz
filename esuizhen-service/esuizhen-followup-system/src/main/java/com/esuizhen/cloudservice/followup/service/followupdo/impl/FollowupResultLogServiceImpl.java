package com.esuizhen.cloudservice.followup.service.followupdo.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.bean.FollowupResultLogReq;
import com.esuizhen.cloudservice.followup.dao.followupdo.FollowupResultLogDao;
import com.esuizhen.cloudservice.followup.dao.user.DoctorDao;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupResultLog;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupResultLogService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultHelper;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

@Service
public class FollowupResultLogServiceImpl implements FollowupResultLogService {
	@Autowired
	private FollowupResultLogDao followupResultLogDao;
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Override
	public void saveFollowupResultLog(TFollowupResultDetailInfo oldFollowupResult,TFollowupResultDetailInfo currFollowupResult,Integer actionType) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String oldDeathCause=null;
       
		TFollowupResultLog log=new TFollowupResultLog();
		if(UtilValidate.isNotEmpty(oldFollowupResult)){
			log.setFollowupTime(oldFollowupResult.getFollowupTime());
			log.setFollowupOperatorId(oldFollowupResult.getOperator());
			log.setFollowupOperatorName(oldFollowupResult.getOperatorName());
			log.setPatientId(oldFollowupResult.getPatientId());
			log.setFollowupTaskId(oldFollowupResult.getFollowupTaskId());
			oldDeathCause=FollowupResultHelper.getDeathCause(oldFollowupResult.getIsInHospitalDeath(), oldFollowupResult.getIsTumourDeath());
		}else{
			log.setFollowupTime(currFollowupResult.getFollowupTime());
			log.setFollowupOperatorId(currFollowupResult.getOperator());
			log.setFollowupOperatorName(currFollowupResult.getOperatorName());
			log.setPatientId(currFollowupResult.getPatientId());
		}
		log.setOperatorId(currFollowupResult.getUpdateOperator());
		if(StringUtils.isBlank(currFollowupResult.getUpdateOperatorName())){
			Doctor doctor = doctorDao.getDoctorById(currFollowupResult.getUpdateOperator());
			if(doctor!=null)
				log.setOperatorTrueName(doctor.getTrueName());
		}else{
			log.setOperatorTrueName(currFollowupResult.getUpdateOperatorName());
		}
		log.setActionType(actionType);
		if(UtilValidate.isNotEmpty(oldFollowupResult) && UtilValidate.isNotEmpty(oldFollowupResult.getOperator())){
			Doctor doctor = doctorDao.getDoctorById(oldFollowupResult.getOperator());
			if(doctor!=null)
				log.setFollowupOperatorName(doctor.getTrueName());
		}
		String currDeathCause=FollowupResultHelper.getDeathCause(currFollowupResult.getIsInHospitalDeath(), currFollowupResult.getIsTumourDeath());
		
		StringBuffer content=new StringBuffer();
		if(actionType==3){//修改
			content.append("随访结果(");
			content.append(oldFollowupResult.getFollowupResultValueName());
			if(UtilValidate.isNotEmpty(oldFollowupResult.getRelapseParts())){
				content.append(","+oldFollowupResult.getRelapseParts());
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getRelapseDate())){
				content.append(","+ sdf.format(oldFollowupResult.getRelapseDate()));
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getTransferParts())){
				content.append(","+oldFollowupResult.getTransferParts());
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getTransferDate())){
				content.append(","+sdf.format(oldFollowupResult.getTransferDate()));
			}
			if(UtilValidate.isNotEmpty(oldDeathCause)){
				content.append(","+oldDeathCause);
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getDeathDate())){
				content.append(","+sdf.format(oldFollowupResult.getDeathDate()));
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getOtherCause())){
				content.append(","+oldFollowupResult.getOtherCause());
			}
			content.append("修改为");
			content.append(currFollowupResult.getFollowupResultValueName());
			if(UtilValidate.isNotEmpty(currFollowupResult.getRelapseParts())){
				content.append(","+currFollowupResult.getRelapseParts());
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getRelapseDate())){
				content.append(","+sdf.format(currFollowupResult.getRelapseDate()));
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getTransferParts())){
				content.append(","+currFollowupResult.getTransferParts());
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getTransferDate())){
				content.append(","+sdf.format(currFollowupResult.getTransferDate()));
			}
			if(UtilValidate.isNotEmpty(currDeathCause)){
				content.append(","+currDeathCause);
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getDeathDate())){
				content.append(","+sdf.format(currFollowupResult.getDeathDate()));
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getOtherCause())){
				content.append(","+currFollowupResult.getOtherCause());
			}
			content.append(")");
			if(UtilValidate.isNotEmpty(currFollowupResult.getRemark())){
				String oldRemark=oldFollowupResult.getRemark();
				if(UtilValidate.isEmpty(oldRemark)){
					oldRemark="\" \"";
				}
				content.append("备注（"+oldRemark+"修改为"+currFollowupResult.getRemark()+")");
			}
		}else if(actionType==2){
			content.append("删除随访结果(");
			content.append(oldFollowupResult.getFollowupResultValueName());
			if(UtilValidate.isNotEmpty(oldFollowupResult.getRelapseParts())){
				content.append(","+oldFollowupResult.getRelapseParts());
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getRelapseDate())){
				content.append(","+sdf.format(oldFollowupResult.getRelapseDate()));
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getTransferParts())){
				content.append(","+oldFollowupResult.getTransferParts());
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getTransferDate())){
				content.append(","+sdf.format(oldFollowupResult.getTransferDate()));
			}
			if(UtilValidate.isNotEmpty(oldDeathCause)){
				content.append(","+oldDeathCause);
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getDeathDate())){
				content.append(","+sdf.format(oldFollowupResult.getDeathDate()));
			}
			if(UtilValidate.isNotEmpty(oldFollowupResult.getOtherCause())){
				content.append(","+oldFollowupResult.getOtherCause());
			}
			content.append(")");
		}else if(actionType==1){
			content.append("添加随访结果(");
			content.append(currFollowupResult.getFollowupResultValueName());
			if(UtilValidate.isNotEmpty(currFollowupResult.getRelapseParts())){
				content.append(","+currFollowupResult.getRelapseParts());
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getRelapseDate())){
				content.append(","+sdf.format(currFollowupResult.getRelapseDate()));
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getTransferParts())){
				content.append(","+currFollowupResult.getTransferParts());
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getTransferDate())){
				content.append(","+sdf.format(currFollowupResult.getTransferDate()));
			}
			if(UtilValidate.isNotEmpty(currDeathCause)){
				content.append(","+currDeathCause);
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getDeathDate())){
				content.append(","+sdf.format(currFollowupResult.getDeathDate()));
			}
			if(UtilValidate.isNotEmpty(currFollowupResult.getOtherCause())){
				content.append(","+currFollowupResult.getOtherCause());
			}
			content.append(")");
			if(UtilValidate.isNotEmpty(currFollowupResult.getRemark())){
				content.append("备注("+currFollowupResult.getRemark()+")");
			}
		}
		log.setDescription(content.toString());
		followupResultLogDao.insertFollowupResultLog(log);
	}

	@Override
	public Page<TFollowupResultLog> queryFollowupResultLog(FollowupResultLogReq followupResultLogReq) {
		PageHelper.startPage(followupResultLogReq.getPage() + 1, followupResultLogReq.getNum());
		// 数据筛选
		List<TFollowupResultLog> list = followupResultLogDao.queryFollowupResultLog(followupResultLogReq.getPatientId());
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupResultLog>) list);
	}

}
