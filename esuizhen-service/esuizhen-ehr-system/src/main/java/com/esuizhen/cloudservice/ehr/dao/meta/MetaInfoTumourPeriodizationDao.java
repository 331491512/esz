package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDiagnosisperiodization;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoTumourPeriodization;


public interface MetaInfoTumourPeriodizationDao {

	public List<TMetaInfoTumourPeriodization>getMetaInfoTumourPeriodizationList(@Param("tumourCode") String tumourCode);
	
	/**
	 * 查询所有的诊断分期
	 * @param param
	 * @return
	 */
	List<TMetaInfoDiagnosisperiodization> queryListAll();
}
