package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultExamDetail;

/**
 * <p>Title:CrfResultExamDetailDao</p>
 * <p>Description:检查结果详情数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:30:11
 */
public interface TCrfResultExamDetailDao {
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:保存检查详情信息</p>
	 * @author YYCHEN
	 * @date 2016年6月8日 下午4:27:27
	 * @param crfResultExamDetails
	 * @return
	 */
	int insertByBatch(@Param("crfResultExamDetailDetails")List<TCrfResultExamDetail> crfResultExamDetails);
	
	/**
	 * <p>Title:deleteByCrfObserveId</p>
	 * <p>Description:根据观察项ID删除检查详情信息</p>
	 * @author YYCHEN
	 * @date 2016年6月8日 下午4:47:59
	 * @param crfObserveId
	 * @return
	 */
	int deleteByCrfObserveId(String crfObserveId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:17:35
	 * @param projectId
	 * @return
	 */
	int deleteByProjectId(String projectId);
}
