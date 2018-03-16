package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.model.EciDetectionReport;

public interface CloudEciDetectionReportDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月6日 下午6:53:02
	 * @param eciDetectionReport
	 * @return
	 */
	public int insert(EciDetectionReport eciDetectionReport);

	/**
	 * <p>Title:findByDetectionReportId</p>
	 * <p>Description:通过LIS数据ID查询LIS数据</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午5:10:13
	 * @param detectionReportId
	 * @return
	 */
	public EciDetectionReport findByDetectionReportId(String detectionReportId);
}
