/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf.impl<br/>  
 * <b>文件名：</b>FollowupReplyParseRulesInfoServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午4:07:04<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.conf.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.dao.conf.FollowupReplyParseRulesInfoDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupReplyParseRulesInfo;
import com.esuizhen.cloudservice.followup.service.conf.FollowupReplyParseRulesInfoService;

/**
 * @ClassName: FollowupReplyParseRulesInfoServiceImpl
 * @Description: 
 * @author NiDan
 * @date 2016年8月11日下午4:07:04 
 */
@Service("followupReplyParseRulesInfoService")
@Transactional
public class FollowupReplyParseRulesInfoServiceImpl implements FollowupReplyParseRulesInfoService {
	
	@Autowired
	private FollowupReplyParseRulesInfoDao FollowupReplyParseRulesInfoDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveFollowupReplyParseRulesInfo(List<TFollowupReplyParseRulesInfo> rules) {
		FollowupReplyParseRulesInfoDao.deleteAllFollowupReplyParseRulesInfo();
		FollowupReplyParseRulesInfoDao.insertFollowupReplyParseRulesInfo(rules);
	}

	@Override
	public List<TFollowupReplyParseRulesInfo> selectFollowupReplyParseRulesInfos() {
		List<TFollowupReplyParseRulesInfo> rules=FollowupReplyParseRulesInfoDao.selectFollowupReplyParseRulesInfo();
		return rules;
	}
	
	@Override
	public TFollowupReplyParseRulesInfo queryTFollowupReplyByReplyContent(String replyContent){
		replyContent=replyContent.trim();
		TFollowupReplyParseRulesInfo rule=FollowupReplyParseRulesInfoDao.queryTFollowupReplyByReplyContent(replyContent);
		return rule;
	}

}
