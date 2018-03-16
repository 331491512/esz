/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.report;<br/>  
 * <b>文件名：</b>InspectionReportService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午9:43:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.report;

import com.esuizhen.cloudservice.ehr.bean.TDetectionReportDetailInfo;
import com.esuizhen.cloudservice.ehr.bean.TExamReportDetailInfo;
import com.esuizhen.cloudservice.ehr.bean.TReportSimpleInfo;
import com.westangel.common.bean.Page;

/** 
* @ClassName: InspectionReportService
* @Description: 
* @author lichenghao
* @date 2016年5月3日 上午9:43:58  
*/
public interface InspectionReportService {
	/**
	 * 获取检查报告列表
	 * @author lichenghao
	 * @title :getInspectionResultList
	 * @Description:TODO
	 * @return Page<TReportSimpleInfo>
	 * @date 2016年5月3日 下午4:18:12
	 */
	Page<TReportSimpleInfo> getInspectionResultList(Long patientId, Integer hospitalId, Integer resultFlag, Integer sortFlag,
			Integer page, Integer num);
	
	/**
	 * 获取检验报告详情
	 * @author lichenghao
	 * @title :getDetectionReportDetail
	 * @Description:TODO
	 * @return TDetectionReportDetailInfo
	 * @date 2016年5月3日 下午4:18:36
	 */
	TDetectionReportDetailInfo getDetectionReportDetail(String reportId);

	/**
	 * 获取检查报告详情
	 * @author lichenghao
	 * @title :getExamReportDetail
	 * @Description:TODO
	 * @return Object
	 * @date 2016年5月3日 下午4:18:56
	 */
	TExamReportDetailInfo getExamReportDetail(String reportId);
	
}
