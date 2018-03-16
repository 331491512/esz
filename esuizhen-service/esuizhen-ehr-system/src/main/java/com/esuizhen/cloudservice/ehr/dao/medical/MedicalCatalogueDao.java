package com.esuizhen.cloudservice.ehr.dao.medical;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.medical.ChangeVersion;

/**
 * 
 * @author zhuguo
 * @date 2017-9-15 10:47:02
 */
public interface MedicalCatalogueDao {

	// 增
	public Integer insertChangeVersion(ChangeVersion changeVersion);

	// 删
	public Integer deleteChangeVersion(ChangeVersion changeVersion);

	// 查列表
	public List<ChangeVersion> queryChangeVersionList(@Param("patientId")Long patientId,@Param("hospitalId")Integer hospitalId,@Param("visitId")String visitId);

	// 查单个
	public ChangeVersion queryChangeVersionInfo(ChangeVersion changeVersion);

}
