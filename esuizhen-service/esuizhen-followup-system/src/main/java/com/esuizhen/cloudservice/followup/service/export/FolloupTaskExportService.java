package com.esuizhen.cloudservice.followup.service.export;

import java.util.Map;


public interface FolloupTaskExportService {
	/**
	 * 随访任务详情-导出随访任务。
	 * @param req
	 * @return
	 */
	String exportFollowupTaskDetail(Map<String,String> req);
}
