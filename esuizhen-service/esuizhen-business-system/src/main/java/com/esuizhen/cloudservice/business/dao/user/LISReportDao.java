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

import java.util.LinkedHashMap;
import java.util.List;

import com.esuizhen.cloudservice.business.bean.TReportPatientStatiesDetailInfo;

/** 
* @ClassName: LisReportDao
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午3:12:04  
*/
public interface LISReportDao {
	//查询未发送的医生报告
	List<LinkedHashMap> queryNotSendReportLis(Object obj);
	//更新统计报告发送状态
	int updateExamDetectionReportStatisSendState(Object obj);
	//查询医生的检查检验报告患者列表
	List<TReportPatientStatiesDetailInfo> queryDoctorReportPatientList(Object obj);
}
