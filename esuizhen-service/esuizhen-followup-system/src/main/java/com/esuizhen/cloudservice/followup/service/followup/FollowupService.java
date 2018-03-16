package com.esuizhen.cloudservice.followup.service.followup;

import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplate;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlan;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanDetialInfo;
import com.esuizhen.cloudservice.followup.model.followup.TPatientSimpleInfo;
import com.westangel.common.bean.Page;


/**
 * 
* @ClassName: FollowupService 
* @Description: 随访，随访模版接口
* @author wang_hw
* @date 2015年12月2日 下午6:18:53
 */
public interface FollowupService extends com.westangel.common.service.FollowupService
{
	/**
	 * @author wang_hw
	 * @title :createFollowupPlanTemplate
	 * @Description:创建随访计划模版
	 * @return void
	 * @date 2015年12月2日 下午6:22:47
	 */
	public void createFollowupPlanTemplate(FollowupPlanTemplate template);
	
	/**
	 * @author wang_hw
	 * @title :deleteFollowupPlanTemplate
	 * @Description:删除随访计划模版
	 * @return void
	 * @date 2015年12月3日 下午5:12:42
	 */
	public void deleteFollowupPlanTemplate(String planTemplateId);
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupPlanTemplate
	 * @Description:查询随访计划模版详情
	 * @return void
	 * @date 2015年12月3日 下午6:21:36
	 */
	public FollowupPlanTemplate queryFollowupPlanTemplate(String planTemplateId);
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupPlanDetailInfo
	 * @Description:根据医生ID 患者ID查询患者随访计划
	 * @return TFollowupPlan
	 * @date 2015年12月10日 下午8:37:27
	 */
	public TFollowupPlan queryFollowupPlanDetailInfo(Long doctorId , Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :updateFollowupPlanTemplate
	 * @Description:修改随访计划模版
	 * @return void
	 * @date 2015年12月3日 下午5:38:25
	 */
	public void updateFollowupPlanTemplate(FollowupPlanTemplate template);
	
	/**
	 * @author wang_hw
	 * @title :selectFollowupPlanTemplate
	 * @Description:查看公开的随访计划
	 * @return Page
	 * @date 2015年12月9日 下午5:22:26
	 */
	public Page selectFollowupPlanTemplate(String doctorId , Integer page , Integer num);
	
	/**
	 * @author wang_hw
	 * @title :followupPatientList
	 * @Description:我的随访患者
	 * @return Page
	 * @date 2015年12月11日 下午3:09:25
	 */
	public Page<TPatientSimpleInfo> followupPatientList(Long doctorId , Integer page , Integer num , Integer sortFlag);
	
	
	/**
	 * 复查提醒元数据
	 * @author lichenghao
	 * @title :followupReviewList
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月27日 下午6:57:47
	 */
	public Object followupReviewList();

	void updateFollowupPlanDetail(TFollowupPlanDetialInfo followupPlanDetialInfo);
}
