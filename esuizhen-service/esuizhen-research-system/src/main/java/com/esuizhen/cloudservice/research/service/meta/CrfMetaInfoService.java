/**
 * 
 */
package com.esuizhen.cloudservice.research.service.meta;

import java.util.List;

import com.esuizhen.cloudservice.research.bean.PatientParamentInfo;
import com.esuizhen.cloudservice.research.bean.TMetaInfoCRFSubjectElement;
import com.esuizhen.cloudservice.research.model.meta.MetaRole;

/**
 * @author Da Loong
 * @date 2016/4/5 17:00
 *
 */
public interface CrfMetaInfoService {

	public List<TMetaInfoCRFSubjectElement> listMetaInfoCrfSubjectElementChild(String parentId);

	public List<PatientParamentInfo> getPatientsParament();

	/**
	 * <p>Title:getMetaSubcenterRoleList</p>
	 * <p>Description:获取专题医生角色元数据</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午5:48:30
	 * @return
	 */
	public List<MetaRole> getMetaSubcenterRoleList();

}
