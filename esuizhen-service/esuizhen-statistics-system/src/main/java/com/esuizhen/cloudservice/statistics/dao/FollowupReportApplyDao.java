/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.dao;<br/>  
 * <b>文件名：</b>FollowupReportApplyDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午8:20:59<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.statistics.bean.TFollowupReportApply;

/** 
* @ClassName: FollowupReportApplyDao
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午8:20:59  
*/
public interface FollowupReportApplyDao {
	//获取未发送的随访报告申请
	public List<TFollowupReportApply> queryNotSendFollowupReportApply();
	//修改随访报告申请
	public Integer modifyFollowupReportApply(@Param("productapplyId")String productapplyId);
	//检查为ToB
	public Integer queryToBNum();
	
}
