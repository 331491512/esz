package com.esuizhen.cloudservice.research.service.pro;

import java.util.List;

import com.esuizhen.cloudservice.research.bean.TProjectGroupInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;

public interface ProjectGroupService {

	boolean addProjectGroup(TProjectSimpleInfo projectSimpleInfo);

	/**
	 * <p>Title:queryProjectGroupList</p>
	 * <p>Description:获取专题患者组列表</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午2:42:31
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	List<TProjectGroupInfo> queryProjectGroupList(String projectId, Long doctorId);

}
