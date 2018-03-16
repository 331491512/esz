package com.esuizhen.cloudservice.sync.dao.match;

import com.esuizhen.cloudservice.sync.model.EciDetectionDetail;

public interface MatchEciDetectionDetailDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月6日 下午6:53:14
	 * @param eciDetectionDetail
	 * @return
	 */
	public int insert(EciDetectionDetail eciDetectionDetail);

	/**
	 * <p>Title:findByDetectionDetailId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午5:19:06
	 * @param detectionDetailId
	 * @return
	 */
	public EciDetectionDetail findByDetectionDetailId(String detectionDetailId);
}
