package com.esuizhen.cloudservice.research.service.pro;

import com.esuizhen.cloudservice.research.bean.TProjectCountInfo;
import com.esuizhen.cloudservice.research.bean.TProjectDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RejectRequestExcption;

/** 
* @ClassName: ProjectService 
* @Description: 科研专题业务层接口
* @author YYCHEN
* @date 2016年04月01日 下午15:58:01  
*/
public interface ProjectService {
	/**
	 * 创建科研专题
	 * @param projectDetailInfo
	 * @return
	 * @throws RejectRequestExcption 
	 */
	public TProjectSimpleInfo createProject(TProjectSimpleInfo projectSimpleInfo) throws EmptyParamExcption, RejectRequestExcption;

	/**
	 * 修改科研专题
	 * @param projectSimpleInfo
	 * @return
	 * @throws EmptyParamExcption
	 * @throws RejectRequestExcption 
	 */
	public int projectModify(TProjectSimpleInfo projectSimpleInfo) throws EmptyParamExcption, RejectRequestExcption;
	
	/**
	 * <p>Title:listProject</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午11:17:28
	 * @param doctorId
	 * @param stateFlag
	 * @param state
	 * @param attributeFlag
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws EmptyParamExcption
	 */
	public Page<TProjectSimpleInfo> listProject(Long doctorId, Integer stateFlag, Integer state, Integer attributeFlag, Integer pageNum, Integer pageSize) throws EmptyParamExcption;
	
	public TProjectCountInfo queryProjectStatistics(String projectId, Long doctorId) throws EmptyParamExcption;
	
	public TProjectDetailInfo queryProjectDetail(String projectId, Long subcenterId, Long doctorId) throws EmptyParamExcption;

	public int removeProject(String projectId, Long doctorId);

	/**
	 * <p>Title:releaseProject</p>
	 * <p>Description:专题发布</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午11:49:40
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	public boolean releaseProject(String projectId, Long doctorId);
	
	//public boolean timedUpdateProjectState(TProjectSimpleInfo projectSimpleInfo);
}
