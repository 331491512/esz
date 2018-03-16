/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.followup;<br/>  
 * <b>文件名：</b>FollowupMetaDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年3月27日下午7:01:30<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.followup;

import java.util.List;

import com.esuizhen.cloudservice.followup.model.meta.TReviewItemInfo;

/** 
* @ClassName: FollowupMetaDao
* @Description: 
* @author lichenghao
* @date 2016年3月27日 下午7:01:30  
*/
public interface FollowupMetaDao {
	/**
	 * 复查提醒元数据
	 * @author lichenghao
	 * @title :queryFollowupReview
	 * @Description:TODO
	 * @return Object
	 * @date 2016年3月27日 下午6:59:42
	 */
	public List<TReviewItemInfo> queryFollowupReviewDetection();
	public List<TReviewItemInfo> queryFollowupReviewExam();
}
