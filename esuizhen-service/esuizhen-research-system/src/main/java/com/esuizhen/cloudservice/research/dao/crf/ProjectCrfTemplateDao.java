package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.TProjectTemplateDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface ProjectCrfTemplateDao {
	/**
	 * 
	 * @param projectTemplateDeatilInfo
	 * @return
	 */
	public int insert(TProjectTemplateDetailInfo projectTemplateDeatilInfo);

	/**
	 * <p>Title: setProjectTemplatePublish</p>
	 * <p>Description: </p>
	 * @date 2016年4月25日 下午4:19:59
	 * @param author
	 * @param crfTemplateId
	 * @return
	 */
	public int setProjectTemplatePublish(@Param("author")Long author, @Param("crfTemplateId")String crfTemplateId);
	
	/**
	 * <p>Title: increaseCitations</p>
	 * <p>Description: 专题模板引用次数增加1</p>
	 * @date 2016年4月26日 下午6:25:33
	 * @param crfTemplateId
	 * @return
	 */
	public int increaseCitations(String crfTemplateId);
	
	/**
	 * <p>Title: setIsBaselineCopied</p>
	 * <p>Description: 设置基线手动拷贝标识。手动拷贝基线观察项设置到其他周期后，其他周期各观察项才点亮并允许设置</p>
	 * @date 2016年4月25日 下午4:20:33
	 * @param crfTemplateId
	 * @return
	 */
	public int setIsBaselineCopied(String crfTemplateId);
	
	/**
	 * <p>Title:updateCrfTemplateIdcrfTemplateId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月11日 上午11:01:49
	 * @param crfTemplateId
	 * @param followupStartMark
	 * @return
	 */
	public int updateCrfTemplateIdcrfTemplateId(@Param("crfTemplateId")String crfTemplateId, @Param("followupStartMark")Integer followupStartMark);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:修改专题模板基本信息</p>
	 * @author YYCHEN
	 * @date 2016年5月20日 上午11:00:26
	 * @param projectTemplateSimpleInfo
	 * @return
	 */
	public int update(TProjectTemplateSimpleInfo projectTemplateSimpleInfo);
	
	/**
	 * <p>Title: proCrfTemplateItemsCreate</p>
	 * <p>Description: 创建专题观察项</p>
	 * @date 2016年4月8日 下午4:15:38
	 * @param params
	 */
	public void proCrfTemplateItemsCreate(Map<String, Object> params);
	
	/**
	 * <p>Title: proCrfTemplateItemsDelete</p>
	 * <p>Description: 删除专题模板</p>
	 * @date 2016年4月8日 下午4:15:43
	 * @param params
	 */
	public void proCrfTemplateItemsDelete(Map<String, Object> params);
	
	/**
	 * <p>Title: proCrfTemplateModify</p>
	 * <p>Description: 修改专题模板随访周期时调用，生成随访观察项</p>
	 * @date 2016年4月13日 下午3:28:14
	 * @param params
	 */
	public void proCrfTemplateModify(Map<String, Object> params);
	
	/**
	 * <p>Title: proCrfTemplateDetailDelete</p>
	 * <p>Description: 删除专题模板观察项</p>
	 * @date 2016年4月13日 下午3:57:22
	 * @param params
	 */
	public void proCrfTemplateDetailDelete(Map<String, Object> params);
	
	/**
	 * <p>Title: pro_crf_template_copy_delete</p>
	 * <p>Description: </p>
	 * @date 2016年4月29日 下午12:04:46
	 * @param params
	 */
	public void proCrfTemplateCopyDelete(Map<String, Object> params);
	
	/**
	 * <p>Title: proCrfTemplateReference</p>
	 * <p>Description: 引用专题模板</p>
	 * @date 2016年4月13日 上午10:28:37
	 * @param params
	 */
	public void proCrfTemplateReference(Map<String, Object> params);
	
	/**
	 * <p>Title: queryPublicTemplate</p>
	 * <p>Description: 根据创建人ID和病种ID查询专题模板简要信息列表</p>
	 * @date 2016年4月11日 下午5:04:42
	 * @param author
	 * @param mainDiseaseTypeId
	 * @return
	 */
	public List<TProjectTemplateSimpleInfo> queryPublicTemplate(@Param("author")Long author, @Param("mainDiseaseTypeId")Integer mainDiseaseTypeId);

	/**
	 * <p>Title: findProjectTemplateDetail</p>
	 * <p>Description: 通过专题模板ID获取专题模板详细信息</p>
	 * @date 2016年4月11日 下午5:04:19
	 * @param crfTemplateId
	 * @return
	 */
	public TProjectTemplateDetailInfo findProjectTemplateDetail(String crfTemplateId);

	/**
	 * <p>Title: findByCrfTemplateId</p>
	 * <p>Description: 通过专题模板ID获取专题模板信息</p>
	 * @date 2016年4月11日 下午5:03:58
	 * @param crfTemplateId
	 * @return
	 */
	public TProjectTemplateSimpleInfo findByCrfTemplateId(String crfTemplateId);
	
	/**
	 * <p>Title:findByProjectId</p>
	 * <p>Description:通过专题ID获取模板信息</p>
	 * @author YYCHEN
	 * @date 2016年6月8日 下午5:30:38
	 * @param projectId
	 * @return
	 */
	public TProjectTemplateSimpleInfo findByProjectId(String projectId);
}
