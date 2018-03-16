/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.service.impl;<br/>  
 * <b>文件名：</b>SysServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日上午10:05:57<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.util.*;
import com.westangel.commonservice.sys.bean.*;
import com.westangel.commonservice.sys.dao.SysDao;
import com.westangel.commonservice.sys.dao.SysTagDao;
import com.westangel.commonservice.sys.model.TActivityDetailInfo;
import com.westangel.commonservice.sys.model.TBannerInfo;
import com.westangel.commonservice.sys.model.TbannerItemInfo;
import com.westangel.commonservice.sys.service.SysService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: SysServiceImpl
 * @Description:
 * @author lichenghao
 * @date 2015年12月17日 上午10:05:57
 */
@Service
@Transactional
public class SysServiceImpl implements SysService {

	@Autowired
	private SysDao dao;

	@Autowired
	private SysTagDao sysTagDao;
	
	@Autowired
	private MessageInnerService messageInnerService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Value("${system.feedback.push}")
	private String feedbackPush;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void createFeedBack(TFeedBack feeback) {
		// TODO Auto-generated method stub
		dao.createFeedBack(feeback);
	}

	@Override
	public TAppVersion getAppVersion(String bussinessId,String productId,String version,Integer versionCode,Integer deviceType) {
		// TODO Auto-generated method stub
		TAppVersion appVersion = new TAppVersion();
		appVersion.setBusinessId(bussinessId);
		appVersion.setProductId(productId);
		appVersion.setVersion(version);
		appVersion.setVersionCode(versionCode);
		appVersion.setDeviceType(deviceType);
		appVersion = dao.quertNewAppVersion(appVersion);
		if (appVersion == null)
			appVersion = new TAppVersion();
		if (appVersion.getUpdate() == null) {
			appVersion.setUpdate(0);
		}

		return appVersion;
	}

	@Override
	public List<TBannerInfo> getListBanner(Integer reqFlag, Long userId, Integer role,String appVersion) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		role = role==null?2:role==2?1:2;
		params.put("placeType", reqFlag);
		params.put("placeCode", "banner");
		params.put("isPublish", 1);
		if(StringUtils.isNotEmpty(appVersion))
		params.put("appVersion", appVersion);
		List<TBannerInfo> bannerList = dao.queryBannerList(params);
		if(bannerList!=null)
			for(TBannerInfo bannerInfo : bannerList){
				params.clear();
				params.put("contentId", bannerInfo.getBannerId());
				for(TbannerItemInfo item : dao.queryBannerItems(params)){
					String content = item.getContent();
					switch (item.getItemType()) {
					case 1:
						bannerInfo.setShareTitle(content);
						break;
					case 2:
						bannerInfo.setShareText(content);
						break;
					case 3:
						bannerInfo.setImageUrl(content);
						break;
					case 4:
						bannerInfo.setShareThumbnail(content);
						break;
					case 5:
						bannerInfo.setContentLink(content);
						break;
					}
					bannerInfo.setBannerId(null);
				}
			}
		return bannerList;
	}

	@Override
	public List<TActivityDetailInfo> getQuseryActivity(SystemActivityQueryReq req) {
		if(req.getIsPublish() == null || (req.getIsPublish() != null &&req.getIsPublish() != 2))req.setIsPublish(1);
		req.setSeate(new Integer[]{0,1});
		List<TActivityDetailInfo> res = dao.queryActivity(req);
		List<Map<String,Object>> list  = new ArrayList<Map<String,Object>>();
		for(TActivityDetailInfo tem : res){
			int progressState = 0;
			long startTime = DateUtil.stringToDate(tem.getActivityBeginTime(), "yyyy-MM-dd HH:mm:ss").getTime();
			long endTime = DateUtil.stringToDate(tem.getActivityEndTime(), "yyyy-MM-dd HH:mm:ss").getTime();
			long now = (new Date()).getTime();
			if(now < startTime)continue;
			if(now < endTime){
				if(tem.getSignupCounter() < tem.getSignupLimit()){
					progressState = 1;
				}else{
					progressState = 3;
				}
			}
			if(now > endTime){
				progressState = 2;
			}
			if(progressState != tem.getProgressState()){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("id",tem.getActivityId());
				map.put("progressState", progressState);
				tem.setProgressState(progressState);
				list.add(map);
			}
		}
		if(list.size() > 0){
			for(Map<String,Object> tem : list){
				dao.progessState(tem);
			}
		}
		return res;
	}

	@Override
	public Page<TActivityDetailInfo> getActivityHistoryList(SystemActivityQueryReq req) {
		List<TActivityDetailInfo> list =null;
		if(req.getRuleId()!=null){
			ActivityReq activityReq=new ActivityReq();
			activityReq.setRuleId(req.getRuleId());
			activityReq.setNum(req.getNum());
			activityReq.setPage(req.getPage());
			List<TagInfo> tagInfos=sysTagDao.findContentTagsByRule(activityReq.getRuleId());
			List<Integer> activityTypes=getActivityType(req.getSourceType());
			if(tagInfos!=null&&tagInfos.size()>0){
				activityReq.setTagInfos(tagInfos);
				PageHelper.startPage(req.getPage()+1,req.getNum());
				list=dao.findActivityListByRule(activityReq,activityTypes);
			}else{
				Page<TActivityDetailInfo> page=new Page<TActivityDetailInfo>();
				page.setTotalNum(0);
				page.setCurrPage(0);
				page.setCurrSize(0);
				page.setTotalPage(0);
				return page;
			}
		}else{
			// TODO Auto-generated method stub
			PageHelper.startPage(req.getPage()+1, req.getNum());
			req.setSeate(new Integer[]{2});
			req.setIsPublish(1);
			list= dao.queryActivity(req);
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<TActivityDetailInfo>)list);
	}

	private List<Integer> getActivityType(String sourceType) {
		List<Integer> activityTypes=null;
		if(!StringUtils.isBlank(sourceType)){
			activityTypes=new ArrayList<Integer>();
			String [] s=sourceType.split(",");
			for (String str : s){
				activityTypes.add(Integer.valueOf(str));
			}
		}
		return activityTypes;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void singupActivity(TActivitySignup signup) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(signup.getActivityId()))
			throw new EmptyParamExcption("activityId is null");
		if(StringUtils.isEmpty(signup.getMobile()))
			throw new EmptyParamExcption("mobile is null");
		/*if(StringUtils.isEmpty(signup.getPersonName()))
			throw new EmptyParamExcption("personName is null");*/
//		if(StringUtils.isEmpty(signup.getPersonIdentity()))
//			throw new EmptyParamExcption("personIdentity is null");
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("activityId", signup.getActivityId());
		List<TActivityDetailInfo> list = dao.queryActivity(params);
		if(list!=null&&list.size()>0){
			TActivityDetailInfo activity = list.get(0);
			if(DateUtil.stringToDate(activity.getActivityEndTime(), "yyyy-MM-dd").getTime()<(new Date()).getTime())
				throw new EmptyObjectExcption(messageSource.getMessage("activity.end", null, null));
			if(activity.getSignupCounter()>=activity.getSignupLimit())
				throw new EmptyObjectExcption(messageSource.getMessage(ErrorMessage.E140904.info, null, null));
		}
		if(dao.queryActivityMobile(signup)!=null)
			throw new EmptyObjectExcption(messageSource.getMessage(ErrorMessage.E140903.info, null, null));
		dao.updateActivity(signup.getActivityId());
		dao.createSignupActivity(signup);
	}
	
	/**
	 *RTF字符串重载
	 */
	@Override
	public void reloadRTFToText() {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newFixedThreadPool(1);

		Runnable run = new Runnable() {
			@Override
			public void run() {
				boolean isFlag = true;
				while (isFlag) {
					List<LinkedHashMap<String, Object>> list = dao.quyerExamIsRTF();
					if(list==null||list.isEmpty()){
						isFlag = false;
						return;
					}
					int i = 0;
					while (i < 1000) {
						if (list.isEmpty()) {
							break;
						}
						LinkedHashMap<String, Object> map = list.get(0);
						LogUtil.log.debug("-----------------" + map.get("examReportId"));
						map.put("examConclusion",RtfUtil.readFromRtfString((String)map.get("examConclusion")));
						dao.modifyExamRtfToText(map);
						list.remove(0);
						i++;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		exec.execute(run);
	}


	@Override
	public void createFeedBackPush(FeedBackReq req) {
		// TODO Auto-generated method stub
		if(req.getUserId()==null)
			throw new EmptyParamExcption(" userId is null");
		if(req.getUserRole()==null)
			throw new EmptyParamExcption(" userRole is null");
		if(req.getBusinessId()==null)
			throw new EmptyParamExcption(" businessId is null");
		if(req.getProductId()==null)
			throw new EmptyParamExcption(" productId is null");
		if(StringUtils.isEmpty(req.getAppVersion()))
			throw new EmptyParamExcption(" version is null");
		ImMessageInfo im = ImMessageUtil.getSysImMessageInfo();
		im.setSpeakerId(Constant.User.SuizhenAssist);
		im.setSpeakerRole(Constant.User.ROLE_SYSTEM);
		im.setAudienceRole(req.getUserRole());
		im.setAudienceId(req.getUserId());
		im.setContent(feedbackPush);
		im.setProductId(req.getProductId());
		im.setBusinessId(req.getBusinessId());
		im.setContentType(1);
		im.setServiceId(1);
		messageInnerService.sendInnerMessage(im);
	}

	@Override
	public Page getActivityByRule(ActivityReq req) {
		//if(req.getRuleId()==null){
		//	throw new EmptyParamExcption("ruleId is null");
		//}
		//List<TagInfo> tagInfos=sysTagDao.findContentTagsByRule(req.getRuleId());
		//if(tagInfos!=null&&tagInfos.size()>0){
		//	req.setTagInfos(tagInfos);
		//}else{
		//	return null;
		//}
		//PageHelper.startPage(req.getPage()+1,req.getNum());
		//List<TActivityDetailInfo> activityDetailInfos=dao.findActivityListByRule(req);
		//return PageUtil.returnPage((com.github.pagehelper.Page<TActivityDetailInfo>)activityDetailInfos);
		return null;
	}
}
