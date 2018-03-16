/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>ExpressServiceDetailDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月10日下午3:06:05<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/** 
* @ClassName: ExpressServiceDetailDao
* @Description: 
* @author lichenghao
* @date 2017年1月10日 下午3:06:05  
*/
public interface ExpressServiceDetailDao {
	//详情列表插入
	public int insert(@Param("details")Object details);
	//修改详情状态
	public int updateDetailsState(@Param("productApplyId")String productApplyId, @Param("inhospitalNo")String inhospitalNo);
	//修改详情状态
	public int modifyDetailState(Object req);
	
	//获取住院时间
	public List<Date> queryInhospitalDate(@Param("productApplyId")String productApplyId);
	
	//未归档确认  0 归档  >0未归档
	public Integer checkEmrIsNotFile(@Param("productApplyId")String productApplyId);

    int checkEmrIsInHospital(@Param("productApplyId")String productApplyId);

	//获取邮寄公司名称
    String queryExpressCompany(@Param("productApplyId") String productApplyId);
}
