/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.user;<br/>  
 * <b>文件名：</b>LISReportServer.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月14日下午4:15:09<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.user;

import com.esuizhen.cloudservice.business.bean.ReportPatientStatisLiistGetReq;
import com.esuizhen.cloudservice.business.bean.TReportPatientStatiesDetailInfo;
import com.westangel.common.bean.Page;

/** 
* @ClassName: LISReportServer
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午4:15:09  
*/
public interface LISReportServer {
	//发送报告给医生
	void sendPatientReportToDoctor();
	//查询医生报告列表
	Page<TReportPatientStatiesDetailInfo> getReportPatientStatisList(ReportPatientStatisLiistGetReq req);
	void sendPatientReport();
}
