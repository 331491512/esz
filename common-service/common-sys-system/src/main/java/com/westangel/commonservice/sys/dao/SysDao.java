/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.dao;<br/>  
 * <b>文件名：</b>SysDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日上午9:50:29<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.dao;

import com.westangel.commonservice.sys.bean.ActivityReq;
import com.westangel.commonservice.sys.bean.TActivitySignup;
import com.westangel.commonservice.sys.bean.TAppVersion;
import com.westangel.commonservice.sys.bean.TFeedBack;
import com.westangel.commonservice.sys.model.TActivityDetailInfo;
import com.westangel.commonservice.sys.model.TBannerInfo;
import com.westangel.commonservice.sys.model.TbannerItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** 
* @ClassName: SysDao
* @Description: 底层服务dao
* @author lichenghao
* @date 2015年12月17日 上午9:50:29  
*/
public interface SysDao {
	//用户意见反馈
	public void createFeedBack(TFeedBack feeback);
	//获取最新版本
	public TAppVersion quertNewAppVersion(TAppVersion appVersion);
	//获取首页Banner
	public List<TBannerInfo> queryBannerList(Map<String, Object> params);
	public List<TbannerItemInfo> queryBannerItems(Map<String, Object> params);
	//获取活动
	public List<TActivityDetailInfo> queryActivity(Object params);
	//活动报名获取
	public String queryActivityMobile(TActivitySignup signup);
	//活动报名
	public void createSignupActivity(TActivitySignup signup);
	
	//活动报名修改
	public int updateActivity(@Param("activityId")String activityId);
	
	//获取rtf的数据
	public List<LinkedHashMap<String,Object>> quyerExamIsRTF();
	
	//修改rft数据
	public void modifyExamRtfToText(Object param);
	
	public void progessState(Map<String, Object> map);

	List<TActivityDetailInfo> findActivityListByRule(@Param("req") ActivityReq req,@Param("activityTypes") List<Integer> activityTypes);
}
