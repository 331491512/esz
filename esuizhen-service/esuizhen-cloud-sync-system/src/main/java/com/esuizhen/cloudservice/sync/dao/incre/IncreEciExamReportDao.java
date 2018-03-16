package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.model.EciExamReport;

/**
 * <p>Title:EciDetectionDetailDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月7日 上午10:07:18
 */
public interface IncreEciExamReportDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月7日 上午10:26:38
	 * @param eciExamReport
	 * @return
	 */
	public int insert(EciExamReport eciExamReport);
}
