/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.conf<br/>  
 * <b>文件名：</b>FollowupContentTemplateInfoDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午4:56:00<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.conf;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateResultRes;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;

/** 
* @ClassName: FollowupContentTemplateInfoDao
* @Description: 随访内容模板接口
* @author NiDan
* @date 2016年8月10日下午4:56:00 
*/
public interface FollowupContentTemplateInfoDao {
	
	/**
	 * 添加随访内容模板
	 * @author Nidan
	 * @title:insertFollowupContentTemplateInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午5:03:14
	 */
	public void insertFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo);
	
	/**
	 * 更新随访内容模板
	 * @author Nidan
	 * @title:updateFollowupContentTemplateInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月10日下午5:04:09
	 */
	public void updateFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo);
	
	/**
	 * 根据contentTemplateId查询随访内容模板
	 * @author Nidan
	 * @title:queryFollowupContentTemplateInfo
	 * @Description:
	 * @return TFollowupContentTemplateInfo
	 * @date 2016年8月10日下午5:04:30
	 */
	public TFollowupContentTemplateInfo queryFollowupContentTemplateInfo(String contentTemplateId);
	
	/**
	 * 查询随访内容模板列表
	 * @author Nidan
	 * @title:selectFollowupContentTemplateInfo
	 * @Description:
	 * @return List<TFollowupContentTemplateInfo>
	 * @date 2016年8月10日下午5:04:42
	 */
	public List<FollowupContentTemplateResultRes> selectFollowupContentTemplateInfo(Map<String,Object> req);
	
	/**
	 * 查询随访内容模板总数
	 * @author Nidan
	 * @title:selectFollowupContentTemplateInfoCount
	 * @Description:
	 * @return int
	 * @date 2016年8月11日下午3:44:39
	 */
	public int selectFollowupContentTemplateInfoTotalCount(Map<String, Object> params);

	/**
	 * 根据模板Id删除模板
	 * @author Nidan
	 * @title:deleteFollowupContentTemplateById
	 * @Description:
	 * @return void
	 * @date 2016年8月30日下午2:38:35
	 */
	public void deleteFollowupContentTemplateById(String contentTemplateId);

}
