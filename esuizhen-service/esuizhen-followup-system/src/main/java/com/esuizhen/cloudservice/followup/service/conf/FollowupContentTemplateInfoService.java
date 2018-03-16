/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf<br/>  
 * <b>文件名：</b>FollowupContentTemplateInfoService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日下午2:38:04<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.conf;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupContentTemplateResultRes;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupContentTemplateInfo;
import com.westangel.common.bean.Page;

/** 
* @ClassName: FollowupContentTemplateInfoService
* @Description: 随访内容模板服务接口
* @author NiDan
* @date 2016年8月11日下午2:38:04 
*/
public interface FollowupContentTemplateInfoService {
	
	/**
	 * 添加随访内容模板
	 * @author Nidan
	 * @title:addFollowupContentTemplateInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月11日下午2:53:25
	 */
	public void addFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo);
	
	/**
	 * 编辑随访内容模板
	 * @author Nidan
	 * @title:modifyFollowupContentTemplateInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月11日下午2:54:34
	 */
	public void modifyFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo);
	
	/**
	 * 查询随访内容模板详情
	 * @author Nidan
	 * @title:queryFollowupContentTemplateInfo
	 * @Description:
	 * @return TFollowupContentTemplateInfo
	 * @date 2016年8月11日下午2:55:53
	 */
	public TFollowupContentTemplateInfo queryFollowupContentTemplateInfo(String contentTemplateId);
	
	/**
	 * 查询随访内容列表
	 * @author Nidan
	 * @title:selectTFollowupContentTemplateInfos
	 * @Description:
	 * @return Page<TFollowupContentTemplateInfo>
	 * @date 2016年8月11日下午3:00:10
	 */
	public Page<FollowupContentTemplateResultRes> selectTFollowupContentTemplateInfos(FollowupContentTemplateQueryReq req);

	/**
	 * 删除随访内容模板
	 * @author Nidan
	 * @title:deleteFollowupContentTemplateInfo
	 * @Description:
	 * @return void
	 * @date 2016年8月30日下午2:36:04
	 */
	public void deleteFollowupContentTemplateInfo(TFollowupContentTemplateInfo followupContentTemplateInfo);

}
