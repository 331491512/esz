/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.dao.report;<br/>  
 * <b>文件名：</b>InspectionReportDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午9:47:17<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.dao.report;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.TDetectionReportDetailInfo;
import com.esuizhen.cloudservice.ehr.bean.TExamReportDetailInfo;
import com.esuizhen.cloudservice.ehr.bean.TReportSimpleInfo;

/** 
* @ClassName: InspectionReportDao
* @Description: 检查报告相关查询 
* @author lichenghao
* @date 2016年5月3日 上午9:47:17  
*/
public interface InspectionReportDao {
	//获取报告简要信息
	public List<TReportSimpleInfo> queryReportList(Object param);
	
	//获取检验报告详情
	public TDetectionReportDetailInfo queryDetectionReportInfoByReportId(@Param("detectionReportId") String detectionReportId);
	
	//修改检验报告为已读详情
	public Integer updateDetectionReportIsRead(@Param("detectionReportId") String detectionReportId);
	
	//获取检查报告详情
	public TExamReportDetailInfo queryExamReportInfoByReportId(@Param("examReportId") String examReportId);
	
	//修改检查报告为已读详情
	public Integer updateExamReportIsRead(@Param("examReportId") String examReportId);
}
