/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.user;<br/>  
 * <b>文件名：</b>LisReportDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月14日下午3:12:04<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.business.bean.TReportPatientPushBatch;

/** 
* @ClassName: LisReportDao
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午3:12:04  
*/
public interface LISReportToPatientDao {
	//查询待推送列表
	List<TReportPatientPushBatch> queryWaitPushBatch(Object obj);
	int updatePushBatchWait(TReportPatientPushBatch pushBatch);
	int createPushBatchWaitHistory(@Param("reportPushBatchList")List<TReportPatientPushBatch> list);
	int createPushBatchDetailWaitHistory(@Param("reportPushBatchList")List<TReportPatientPushBatch> list);
	int deletePushBatchWait();
}
