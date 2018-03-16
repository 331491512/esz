package com.esuizhen.cloudservice.research.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.bean.PatientParamentInfo;
import com.esuizhen.cloudservice.research.bean.TMetaInfoCRFSubjectElement;
import com.esuizhen.cloudservice.research.model.meta.MetaRole;

public interface CrfMetaInfoDao {
	
	/**
	 * 获取观察模板子标题元素信息
	 * @param parentId
	 * @return
	 */
	List<TMetaInfoCRFSubjectElement> queryMetaInfoCrfSubjectElementChildList(@Param("parentId") String parentId);

	List<PatientParamentInfo> queryParaments();

	/**
	 * <p>Title:findMetaSubcenterRoleList</p>
	 * <p>Description:查询专题分中心医生角色元数据</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午5:49:45
	 * @return
	 */
	List<MetaRole> findMetaSubcenterRoleList();

}
