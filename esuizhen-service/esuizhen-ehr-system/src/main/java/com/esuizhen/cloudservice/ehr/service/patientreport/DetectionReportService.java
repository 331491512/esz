/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.patient;<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午11:47:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.patientreport;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.TDetectionReportDetailInfo;
import com.esuizhen.cloudservice.ehr.model.detection.DetectionReport;

/** 
* @ClassName: DetectionReportService
* @Description: 
* @author fanpanwei
* @date 2017年5月18日 上午11:47:58  
*/
public interface DetectionReportService {
	/**
	* @author fanpanwei
	* @date 2017年4月1日
	* @param 
	* @description:保存校验报告集合
	* @return
	 */
	List<TDetectionReportDetailInfo> saveDetectionReportDetailList(List<TDetectionReportDetailInfo> tDetailInfoList) throws Exception;
	
	/**
	* @author fanpanwei
	* @date 2017年4月1日
	* @param 
	* @description：获取指定患者的检验报告列表信息
	* @return
	 */
	List<DetectionReport> getDetectionReportList(Long patientId);
	/**
	* @author fanpanwei
	* @date 2017年4月1日
	* @param 
	* @description:获取指定的检验报告
	* @return
	 */
	Map<String,Object> getSpecifyDetectionReport(String detectionReportId);
	
	/**
	 * 获取检验报告详情
	 * @author lichenghao
	 * @title :getDetectionReportDetail
	 * @Description:TODO
	 * @return TDetectionReportDetailInfo
	 * @date 2016年5月3日 下午4:18:36
	 */
	TDetectionReportDetailInfo getDetectionReportDetail(String reportId);
}
