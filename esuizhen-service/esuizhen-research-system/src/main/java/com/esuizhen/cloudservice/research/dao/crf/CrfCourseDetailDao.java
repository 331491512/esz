package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.CrfCourseDetail;

/**
 * 随访周期明细数据访问层接口
 * @author YYCHEN
 *
 */
public interface CrfCourseDetailDao {
	/**
	 * 新增随访明细信息 
	 * @param courseDetail 随访明细
	 * @return
	 */
	public int insert(CrfCourseDetail courseDetail);
	
	/**
	 * <p>Title: delete</p>
	 * <p>Description: 删除随访明细</p>
	 * @date 2016年4月7日 下午2:54:22
	 * @param crfCourseItemId
	 * @return
	 */
	public int delete(String crfCourseItemId);
	
	/**
	 * 通过随访周期ID获取随访明细
	 * @param crfCourseId 随访周期ID
	 * @return 随访明细
	 */
	public List<CrfCourseDetail> queryCourseDetailsByCourseId(String crfCourseId);

	/**
	 * <p>Title: findFirstCourseDetailInfo</p>
	 * <p>Description: 通过随访周期ID获取第一个随访明细</p>
	 * @date 2016年4月11日 上午10:39:08
	 * @param crftCourseId
	 * @return
	 */
	public List<CrfCourseDetail> queryCourseDetailInfoes(String crftCourseId);
}
