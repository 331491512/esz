package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.bean.TCrfCourseConf;
import com.esuizhen.cloudservice.research.bean.TCrfCourseDetailInfo;
import com.esuizhen.cloudservice.research.bean.TCrfCourseInfo;
import com.westangel.common.excption.EmptyParamExcption;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CrfCourseService {

	/**
	 * 修改随访周期
	 * @param crfCourseInfo
	 * @return
	 */
	public int pojectTemplateCrfCourseModify(TCrfCourseConf crfCourseConf) throws EmptyParamExcption;

	/**
	 * <p>Title: projectTemplateCrfCourseQuery</p>
	 * <p>Description: 获取专题模板的随访周期</p>
	 * @date 2016年4月11日 下午2:57:11
	 * @param crfTemplateId
	 * @param doctorId
	 * @return
	 */
	public TCrfCourseConf projectTemplateCrfCourseQuery(String crfTemplateId, Long doctorId);

	/**
	 * <p>Title: queryCrfObserve</p>
	 * <p>Description: CRF模板观察项查看</p>
	 * @date 2016年4月12日 下午5:54:33
	 * @param crfTemplateId
	 * @return
	 */
	public List<TCrfCourseInfo> queryCrfObserve(String crfTemplateId);

	public boolean projectTemplateCrfCopyBaseItems(String crfTemplateId);

	/**
	 * <p>Title:queryProjectCourseItems</p>
	 * <p>Description:随访周期查询</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 下午4:41:42
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	public List<TCrfCourseInfo> queryProjectCrfResultOutlineFirst(String projectId, Long patientId, Long doctorId);

	/**
	 * <p>Title:getFollowupDays</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月3日 下午4:37:21
	 * @param crfTemplateId
	 * @param crfCourseItemId
	 * @return
	 */
	public int getFollowupDays(String crfTemplateId, String crfCourseItemId);
	
	/**
	 * <p>Title:getCurrentCourseDetailInfo</p>
	 * <p>Description:获取当期随访的周期阶段</p>
	 * @author YYCHEN
	 * @date 2016年6月8日 下午6:02:39
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	public TCrfCourseDetailInfo getCurrentCourseDetailInfo(String projectId, Long patientId);
	
	/**
	 * <p>Title:getLastTCrfCourseDetailInfo</p>
	 * <p>Description:获取最后一个阶段的随访阶段</p>
	 * @author YYCHEN
	 * @date 2016年7月1日 下午6:08:18
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	public TCrfCourseDetailInfo getLastTCrfCourseDetailInfo(String projectId, Long patientId);
}
