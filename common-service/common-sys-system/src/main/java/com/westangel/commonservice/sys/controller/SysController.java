/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.controller;<br/>  
 * <b>文件名：</b>SysController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月16日下午8:09:36<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.controller;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.sys.bean.*;
import com.westangel.commonservice.sys.model.TActivityDetailInfo;
import com.westangel.commonservice.sys.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/** 
* @ClassName: SysController
* @Description:  底层公共服务
* @author lichenghao
* @date 2015年12月16日 下午8:09:36  
*/
@Controller
//@RequestMapping("/system")
public class SysController {
	
	/**
	 * 服务接口
	 */
	@Autowired
	private SysService sysService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	
	@Value("${image.url}")
	private String imageUrl;
	
	@Value("${server.h5.url.root.app}")
	private String wxurl;
	
	/**
	 * 意见反馈
	 * @author lichenghao
	 * @title :systemFeedBack
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月17日 上午10:24:09
	 */
	@ResponseBody
	@RequestMapping(value="/feedback",method=RequestMethod.POST)
	public TMsgResponse<String> sysFeedBack(@RequestBody TFeedBack feeback,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			//意见反馈
			sysService.createFeedBack(feeback);
		} catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 意见反馈推送
	 * @author lichenghao
	 * @title :sysFeedBackPush
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年6月3日 上午11:59:11
	 */
	@ResponseBody
	@RequestMapping(value="/feedback/push",method=RequestMethod.POST)
	public TMsgResponse<String> sysFeedBackPush(@RequestBody FeedBackReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			//意见反馈
			sysService.createFeedBackPush(req);
		} catch (EmptyParamExcption e) {
			setTmgResponseCode(msg, ErrorMessage.E1419, locale);
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	/**
	 * 返回版本信息
	 * @author lichenghao
	 * @title :checkVersion
	 * @Description:TODO
	 * @return TMsgResponse<T>
	 * @date 2015年12月17日 上午10:29:50
	 */
	@ResponseBody
	@RequestMapping(value="/checkversion",method=RequestMethod.GET)
	public TMsgResponse<TAppVersion> sysCheckVersion(String businessId,String productId,String version,Integer versionCode,Integer deviceType,Locale locale){
		TMsgResponse<TAppVersion> msg = new TMsgResponse<TAppVersion>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			TAppVersion appVersion = sysService.getAppVersion(businessId,productId,version,versionCode,deviceType);
			msg.result = appVersion;
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	@ResponseBody
	/**
	 * 获取旧版升级
	 * @author lichenghao
	 * @title :sysCheckVersionForOld
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月4日 下午2:13:16
	 */
	@RequestMapping(value="/checkversion/for/old",method={RequestMethod.GET,RequestMethod.POST})
	public Object sysCheckVersionForOld( String version, String systemPlatform,Locale locale){
		Map map = new HashMap<String,Object>();
		try {
			TAppVersion appVersion = sysService.getAppVersion("1","1",version,1,"android".equals(systemPlatform)?3:4);
			if(appVersion!=null){
				Map map2 = new HashMap<String,Object>();
				map2.put("version", appVersion.getVersion());
				map2.put("desc", appVersion.getDesc());
				map2.put("url", appVersion.getUrl());
				map.put("result", map2);
			}
			map.put("code", 0);
			map.put("msg", messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 6001);
			map.put("msg","params error");
			map.put("result", "");
			LogUtil.logError.error(e.getMessage());
		}finally{
			return map;
		}
	}
	
	/**
	 * 获取banner首页
	 * @author lichenghao
	 * @title :sysListBanner
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月17日 下午4:42:31
	 */
	@ResponseBody
	@RequestMapping(value="/banner/list",method=RequestMethod.GET)
	public TMsgResponse<Map<String, Object>> sysListBanner(Integer reqFlag,Long userId,Integer role,String appVersion,Locale locale){
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bannerList", sysService.getListBanner(reqFlag,userId,role,appVersion));
			params.put("updateInterval", 300);
			msg.result = params;
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	/**
	 * 旧版获取banner首页
	 * @author lichenghao
	 * @title :sysListBanner
	 * @Description:TODO
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2016年3月4日 下午2:08:55
	 */
	@ResponseBody
	@RequestMapping(value="/banner/list/for/old")
	public Object sysListBannerForOld(String position,Locale locale){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			position = "1";
			if("1".equals(position)){
				map.put("code", 0);
				Map<String, Object> map2 = new HashMap<String, Object>();
				map.put("msg", "ok");
				map.put("result", map2);
				Map<String, Object> map3 = new HashMap<String, Object>();
				map2.put("nextRequestMinute", 5);
				map2.put("operations", new Object[]{map3});
				map3.put("image",imageUrl+"banner-new.png");
				map3.put("link",wxurl+"/more/app_download.html");
				map3.put("thumbnail", imageUrl+"banner_ico.png");
				map3.put("title", "易随诊app升级啦！");
				map3.put("text", "易随诊app升级啦！");
			}else{
				map.put("code", "");
				map.put("msg", "");
				map.put("result", "");
			}
		} catch (Exception e) {
			map.put("code", "");
			map.put("msg", "");
			map.put("result", "");
		}finally{
			return map;
		}
	}
	/**
	 * 获取活动预告
	 * @author lichenghao
	 * @title :sysQueryActivity
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月17日 下午4:48:06
	 */
	@ResponseBody
	@RequestMapping(value="/activity/query",method=RequestMethod.GET)
	public TMsgResponse<List<TActivityDetailInfo>> sysQueryActivity(SystemActivityQueryReq req,Locale locale){
		TMsgResponse<List<TActivityDetailInfo>> msg = new TMsgResponse<List<TActivityDetailInfo>>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			msg.result = sysService.getQuseryActivity(req);
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 获取往期活动
	 * @author lichenghao
	 * @title :sysListActivityHistory
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月17日 下午4:49:51
	 */
	@ResponseBody
	@RequestMapping(value="/activity/history/list",method=RequestMethod.GET)
	public TMsgResponse<Page<TActivityDetailInfo>> sysListActivityHistory(SystemActivityQueryReq req,Locale locale){
		TMsgResponse<Page<TActivityDetailInfo>> msg = new TMsgResponse<Page<TActivityDetailInfo>>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			msg.result = sysService.getActivityHistoryList(req);
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 活动报名
	 * @author lichenghao
	 * @title :sysSignupActivity
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月17日 下午5:04:38
	 */
	@ResponseBody
	@RequestMapping(value="/activity/signup",method=RequestMethod.POST)
	public TMsgResponse<String> sysSignupActivity(@RequestBody TActivitySignup signup,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			sysService.singupActivity(signup);
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1409.code);
			msg.setRespMsg(e.getMessage());
		}catch (Exception e) {
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * RTF转换
	 * @author lichenghao
	 * @title :reloadRtfToString
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2016年5月11日 上午9:59:22
	 */
	@ResponseBody
	@RequestMapping(value="/medicalrecord/reload/exam",method=RequestMethod.GET)
	public TMsgResponse<String> reloadRtfToString(Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		setTmgResponseCode(msg, ErrorMessage.SUCCESS, locale);
		try {
			sysService.reloadRTFToText();
		} catch (Exception e) {
			e.printStackTrace();
			setTmgResponseCode(msg, ErrorMessage.E1500, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 返回信息
	 * @author lichenghao
	 * @title :setTmgResponseCode
	 * @Description:TODO
	 * @return void
	 * @date 2015年12月17日 上午10:14:57
	 */
	public void setTmgResponseCode(TMsgResponse msg, ErrorMessage error, Locale locale) {
		msg.respCode = error.code;
		msg.respMsg =   messageSource.getMessage(error.getInfo(), null, locale);
	}


	/*@RequestMapping(value = "/activity/rule/list")
	@ResponseBody
	public TMsgResponse<Page> getKnowledgeArticleByRule(Locale locale, Integer ruleId,Integer page,Integer num){
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			ActivityReq req=new ActivityReq();
			req.setRuleId(ruleId);
			req.setNum(num);
			req.setPage(page);
			msg.result=sysService.getActivityByRule(req);
		} catch (EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}*/

}
