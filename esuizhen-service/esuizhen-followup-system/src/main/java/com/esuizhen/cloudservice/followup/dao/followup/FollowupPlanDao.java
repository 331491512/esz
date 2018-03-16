package com.esuizhen.cloudservice.followup.dao.followup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplate;
import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplateDetialInfo;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlan;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanDetialInfo;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanTemplateSimpleInfo;
import com.esuizhen.cloudservice.followup.model.followup.TPatientSimpleInfo;

/**
 * 
* @ClassName: ProjectDao 
* @Description: 随访服务接口
* @author wang_hw
* @date 2015年12月2日 下午4:55:56
 */
public interface FollowupPlanDao
{
	/**
	 * @author wang_hw
	 * @title :createFollowupPlanTemplate
	 * @Description:创建随访计划模版
	 * @return void
	 * @date 2015年12月2日 下午6:28:28
	 */
	public void createFollowupPlanTemplate(FollowupPlanTemplate followupPlanTemplate);
	
	/**
	 * @author wang_hw
	 * @title :createFollowupPlan
	 * @Description:创建随访计划
	 * @return void
	 * @date 2015年12月28日 下午2:58:18
	 */
	public void createFollowupPlan(Map<String , Object> followupPlan);
	
	/**
	 * @author wang_hw
	 * @title :updateFollowupPlanTemplate
	 * @Description:修改随访计划模版
	 * @return void
	 * @date 2015年12月3日 下午5:42:52
	 */
	public void updateFollowupPlanTemplate(FollowupPlanTemplate followupPlanTemplate);
	
	/**
	 * @author wang_hw
	 * @title :updateFollowupPlanDetail
	 * @Description:修改随访计划
	 * @return void
	 * @date 2016年2月24日 下午1:02:00
	 */
	public void updateFollowupPlanDetail(TFollowupPlanDetialInfo followupPlanDetialInfo);
	
	/**
	 * @author wang_hw
	 * @title :addFollowupPlanTemplateDetialInfo
	 * @Description:添加随访计划模版详情
	 * @return void
	 * @date 2015年12月3日 下午3:51:48
	 */
	public void addFollowupPlanTemplateDetialInfo(List<FollowupPlanTemplateDetialInfo> detialInfoList);
	
	/**
	 * @author wang_hw
	 * @title :addFollowupPlanDetialInfo
	 * @Description:添加随访计划详情
	 * @return void
	 * @date 2015年12月28日 下午3:00:51
	 */
	public void addFollowupPlanDetialInfo(TFollowupPlanDetialInfo followupPlanDetialInfo);
	
	/**
	 * @author wang_hw
	 * @title :addFollowupPlanDetialInfoParam
	 * @Description:添加随访计划详情
	 * @return void
	 * @date 2016年1月27日 下午4:25:33
	 */
	public void addFollowupPlanDetialInfoParam(TFollowupPlanDetialInfo followupPlanDetialInfo);
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupPlanTemplate
	 * @Description:查询随访计划模版详情
	 * @return FollowupPlanTemplate
	 * @date 2015年12月3日 下午6:27:15
	 */
	public FollowupPlanTemplate queryFollowupPlanTemplate(String planTemplateId);
	
	/**
	 * 
	 * @author wang_hw
	 * @title :deleteFollowupPlanTemplateById
	 * @Description:根据随访计划模版ID删除随访计划模版
	 * @return void
	 * @date 2015年12月3日 下午5:22:43
	 */
	public void deleteFollowupPlanTemplateById(String planTemplateId);
	
	/**
	 * 
	 * @author wang_hw
	 * @title :deleteFollowupPlanTemplateDetialInfoById
	 * @Description:根据随访计划模版详情ID删除随访计划模版详情
	 * @return void
	 * @date 2015年12月3日 下午5:22:49
	 */
	public void deleteFollowupPlanTemplateDetialInfoById(String planTemplateItemId);
	
	/**
	 * @author wang_hw
	 * @title :deleteFollowupPlanTemplateDetialInfoByPlanId
	 * @Description: 根据随访计划模版ID删除随访计划模版详情
	 * @return void
	 * @date 2015年12月3日 下午5:22:54
	 */
	public void deleteFollowupPlanTemplateDetialInfoByPlanId(String planTemplateId);
	
	/**
	 * @author wang_hw
	 * @title :selectFollowupPlanTemplate
	 * @Description:查看公开的随访计划
	 * @return List<TFollowupPlanTemplateSimpleInfo>
	 * @date 2015年12月9日 下午5:22:26
	 */
	public List<TFollowupPlanTemplateSimpleInfo> selectFollowupPlanTemplate();
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupPlanDetailInfo
	 * @Description:查询患者随访计划明细
	 * @return TFollowupPlan
	 * @date 2015年12月10日 下午8:39:24
	 */
	public TFollowupPlan queryFollowupPlanDetailInfo(LinkedHashMap<String , Object> param);
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupPlanId
	 * @Description:查询随访计划ID
	 * @return String
	 * @date 2016年3月10日 下午6:04:29
	 */
	public String queryFollowupPlanId(String patientId);
	/**
	 * @author wang_hw
	 * @title :queryFollowupPlanInfo
	 * @Description:查询随访计划
	 * @return TFollowupPlan
	 * @date 2016年1月27日 下午2:51:12
	 */
	public TFollowupPlan queryFollowupPlanInfo(LinkedHashMap<String , Object> param);
	
	/**
	 * @author wang_hw
	 * @title :selectFollowupPatientList
	 * @Description:我的随访患者
	 * @return List<TPatientSimpleInfo>
	 * @date 2015年12月11日 下午4:37:32
	 */
	public List<TPatientSimpleInfo> selectFollowupPatientList(Map<String , Object> param);
	
	/**
	 * @author wang_hw
	 * @title :queryintervalDaysByPatientId
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年1月28日 下午9:06:58
	 */
	public Integer queryintervalDaysByPatientId(String patientId);
	
	/**
	 * 根据患者ID查询上下十天随访计划明细ID
	 * @author wang_hw
	 * @title :queryFollowupDetailByPatientId
	 * @Description:TODO
	 * @return HashMap<String,String>
	 * @date 2016年2月14日 下午6:28:49
	 */
	public HashMap<String , String> queryFollowupDetailByPatientId(String patientId);
	
	/**
	 * @author wang_hw
	 * @title :queryplanTemplateIdByPatientId
	 * @Description:查询患者模版ID
	 * @return Integer
	 * @date 2016年2月17日 上午10:34:31
	 */
	public String queryplanTemplateIdByPatientId(@Param("patientId")Long patientId , @Param("diseaseTypeId")Long diseaseTypeId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryPatientSource
	 * @Description:获取患者来源信息
	 * @return LinkedHashMap<String,String>
	 * @date 2016年7月20日 下午4:09:52
	 */
	public LinkedHashMap<String, String> queryPatientSource(@Param("patientId")Long patientId, @Param("productId")Integer wxProductId);
	
	public void updateFollowupPlanByPatientId(@Param("patientId")Long patientId, @Param("state")String state);
}
