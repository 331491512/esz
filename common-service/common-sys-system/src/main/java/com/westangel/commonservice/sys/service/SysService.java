/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.service;<br/>  
 * <b>文件名：</b>SysService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日上午10:04:16<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.service;

import com.westangel.common.bean.Page;
import com.westangel.commonservice.sys.bean.*;
import com.westangel.commonservice.sys.model.TActivityDetailInfo;
import com.westangel.commonservice.sys.model.TBannerInfo;

import java.util.List;

/** 
* @ClassName: SysService
* @Description: 底层服务接口类
* @author lichenghao
* @date 2015年12月17日 上午10:04:16  
*/
public interface SysService {

	/**
	 * 用户反馈击入
	 * @author lichenghao
	 * @title :createFeedBack
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 上午11:02:21
	 */
	void createFeedBack(TFeedBack feeback);
	
	/**
	 * 获取最新版本
	 * @author lichenghao
	 * @title :getAppVersion
	 * @Description:TODO
	 * @return TAppVersion
	 * @date 2015年12月17日 下午1:56:25
	 */
	TAppVersion getAppVersion(String bussinessId,String productId,String version,Integer versionCode,Integer deviceType);

	
	/**
	 * 获取首页
	 * @author lichenghao
	 * @title :getListBanner
	 * @Description:TODO
	 * @return TAppVersion
	 * @date 2015年12月17日 下午5:10:41
	 */
	List<TBannerInfo> getListBanner(Integer reqFlag, Long userId, Integer role,String appVersion);
	
	/**
	 * 获取活动预告
	 * @author lichenghao
	 * @title :getQuseryActivity
	 * @Description:TODO
	 * @return List<TActivityDetailInfo>
	 * @date 2015年12月17日 下午5:19:07
	 */
	List<TActivityDetailInfo> getQuseryActivity(SystemActivityQueryReq req);

	/**
	 * 获取往期活动
	 * @author lichenghao
	 * @title :getActivityHistoryList
	 * @Description:TODO
	 * @return Page<TActivityDetailInfo>
	 * @date 2015年12月17日 下午5:24:34
	 */
	Page<TActivityDetailInfo> getActivityHistoryList(SystemActivityQueryReq req);
	
	/**
	 * 活动报名
	 * @author lichenghao
	 * @title :singupActivity
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 下午5:32:26
	 */
	void singupActivity(TActivitySignup signup);
	
	
	/**
	 * RTF转换
	 * @author lichenghao
	 * @title :reloadRTFToText
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月11日 上午9:59:09
	 */
	void reloadRTFToText();
	
	
	/**
	 * 意见反馈消息推送
	 * @author lichenghao
	 * @title :createFeedBackPush
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月3日 下午12:01:36
	 */
	void createFeedBackPush(FeedBackReq req);

	Page getActivityByRule(ActivityReq req);

}
