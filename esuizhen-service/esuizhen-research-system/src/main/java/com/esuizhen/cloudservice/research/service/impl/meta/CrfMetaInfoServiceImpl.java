/**
 * 
 */
package com.esuizhen.cloudservice.research.service.impl.meta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.bean.PatientParamentInfo;
import com.esuizhen.cloudservice.research.bean.TMetaInfoCRFSubjectElement;
import com.esuizhen.cloudservice.research.dao.meta.CrfMetaInfoDao;
import com.esuizhen.cloudservice.research.model.meta.MetaRole;
import com.esuizhen.cloudservice.research.service.meta.CrfMetaInfoService;

/**
 * 元数据服务
 * 
 * @author Da Loong
 * @date 2016/4/5 17:00
 *
 */
@Service
public class CrfMetaInfoServiceImpl implements CrfMetaInfoService {

	@Autowired
	private CrfMetaInfoDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.esuizhen.cloudservice.research.service.meta.CrfMetaInfoService#
	 * listMetaInfoCrfSubjectElementChild(java.lang.String)
	 */
	@Override
	public List<TMetaInfoCRFSubjectElement> listMetaInfoCrfSubjectElementChild(String parentId) {
		return dao.queryMetaInfoCrfSubjectElementChildList(parentId);
	}

	@Override
	public List<PatientParamentInfo> getPatientsParament() {
		return this.dao.queryParaments();
	}

	@Override
	public List<MetaRole> getMetaSubcenterRoleList() {
		return this.dao.findMetaSubcenterRoleList();
	}
}
