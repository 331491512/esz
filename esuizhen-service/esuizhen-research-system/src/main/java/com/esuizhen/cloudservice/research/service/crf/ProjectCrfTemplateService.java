package com.esuizhen.cloudservice.research.service.crf;

import com.esuizhen.cloudservice.research.bean.TProjectTemplateDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RejectRequestExcption;

/**
 * 
 * @author YYCHEN
 *
 */
public interface ProjectCrfTemplateService {

	public RCrftemplateProject createProjectTemplate(TProjectTemplateDetailInfo projectTemplateDeatilInfo) throws EmptyParamExcption;

	public Page<TProjectTemplateSimpleInfo> listProjectPublicTempaltes(Long author, Integer mainDiseaseTypeId,
			Integer pageNum, Integer pageSize);

	public boolean projectTemplatePublish(Long author, String crfTemplateId) throws EmptyParamExcption;

	public TProjectTemplateDetailInfo projectTempalatePreview(Long doctorId, String crfTemplateId) throws EmptyParamExcption;

	/**
	 * <p>Title: projectTemplateCopy</p>
	 * <p>Description: 引用专题模板</p>
	 * @date 2016年4月11日 下午4:52:45
	 * @param projectId 专题ID
	 * @param crfTemplateId 被引用的专题模板ID
	 * @param doctorId 操作医生ID
	 * @return
	 * @throws RejectRequestExcption 
	 */
	public RCrftemplateProject projectTemplateCopy(String projectId, String crfTemplateId, Long doctorId) throws EmptyParamExcption, EmptyObjectExcption, RejectRequestExcption;
}
