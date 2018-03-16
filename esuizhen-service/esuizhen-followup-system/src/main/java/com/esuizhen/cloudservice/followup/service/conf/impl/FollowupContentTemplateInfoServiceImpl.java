/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf.impl<br/>  
 * <b>文件名：</b>FollowupContentTemplateInfoServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午3:01:16<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.conf.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateResultRes;
import com.esuizhen.cloudservice.followup.common.DataAccessFilter;
import com.esuizhen.cloudservice.followup.dao.conf.FollowupContentTemplateInfoDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.followup.service.conf.FollowupContentTemplateInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: FollowupContentTemplateInfoServiceImpl
* @Description: 
* @author NiDan
* @date 2016年8月11日下午3:01:16 
*/
@Service("followupContentTemplateInfoService")
@Transactional
public class FollowupContentTemplateInfoServiceImpl implements FollowupContentTemplateInfoService {
	
	@Autowired
	private FollowupContentTemplateInfoDao followupContentTemplateInfoDao;
	
	@Autowired
	private DataAccessFilter dataAccessFilter;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo) {
		if(followupContentTemplateInfo.getIsPublish()==null){
			followupContentTemplateInfo.setIsPublish(0);
		}
		followupContentTemplateInfo.setContentTemplateId(GeneralUtil.generateUniqueID("CONT"));
		followupContentTemplateInfoDao.insertFollowupContentTemplateInfo(followupContentTemplateInfo);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void modifyFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo) {
		followupContentTemplateInfo.setUpdateTime(new Date());
		followupContentTemplateInfoDao.updateFollowupContentTemplateInfo(followupContentTemplateInfo);
	}

	@Override
	public TFollowupContentTemplateInfo queryFollowupContentTemplateInfo(String contentTemplateId) {
		TFollowupContentTemplateInfo followupContentTemplateInfo=followupContentTemplateInfoDao.queryFollowupContentTemplateInfo(contentTemplateId);
		return followupContentTemplateInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<FollowupContentTemplateResultRes> selectTFollowupContentTemplateInfos(FollowupContentTemplateQueryReq req) {
		List<FollowupContentTemplateResultRes>  followupContentTemplateInfos=null;
		
		// 数据筛选
		Map<String,Object> paramsMap=dataAccessFilter.decorteDataAccessParams(req,req.getAuthor());
		//page,num传null默认查询所有
		if(req==null||req.getPage()==null||req.getNum()==null){
			followupContentTemplateInfos=followupContentTemplateInfoDao.selectFollowupContentTemplateInfo(paramsMap);
			Page<FollowupContentTemplateResultRes> page=new Page<FollowupContentTemplateResultRes>();
			page.setDataList(followupContentTemplateInfos);
			return page;
		}else{
			PageHelper.startPage(req.getPage()+1, req.getNum());
			followupContentTemplateInfos=followupContentTemplateInfoDao.selectFollowupContentTemplateInfo(paramsMap);
			return PageUtil.returnPage((com.github.pagehelper.Page<?>) followupContentTemplateInfos);
		}
	}

	@Override
	public void deleteFollowupContentTemplateInfo(TFollowupContentTemplateInfo FollowupContentTemplate) {
		followupContentTemplateInfoDao.deleteFollowupContentTemplateById(FollowupContentTemplate.getContentTemplateId());
	}

}
