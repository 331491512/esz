package com.esuizhen.cloudservice.ehr.service.medical;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.medical.ChangeVersion;

/**
 * 
 * @author zhuguo
 * @date 2017-9-15 10:47:02
 */
public interface MedicalCatalogueService {

	// 增
	public Integer insertChangeVersion(ChangeVersion changeVersion);

	// 删
	public Integer deleteChangeVersion(ChangeVersion changeVersion);

	// 查列表
	public List<ChangeVersion> queryChangeVersionList(Long patientId,Integer hospitalId,String visitId);

	// 查单个
	public ChangeVersion queryChangeVersionInfo(ChangeVersion changeVersion);
}
