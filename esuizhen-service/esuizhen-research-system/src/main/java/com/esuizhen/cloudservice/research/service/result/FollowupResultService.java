package com.esuizhen.cloudservice.research.service.result;

import com.esuizhen.cloudservice.research.bean.FollowupRecordInfo;
import com.westangel.common.bean.Page;

/**
 * <p>Title:FollowupResultService</p>
 * <p>Description:随访结果业务层接口</p>
 * @author YYCHEN
 * @date 2016年6月8日 上午10:33:28
 */
public interface FollowupResultService {

	/**
	 * <p>Title:followupRecordList</p>
	 * <p>Description:获取患者所有随访结果信息</p>
	 * @author YYCHEN
	 * @date 2016年6月24日 上午10:18:57
	 * @param patientId
	 * @param page
	 * @param num
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	Page<FollowupRecordInfo> followupRecordList(Long patientId, Integer page, Integer num, String orderBy, String orderType);

}
