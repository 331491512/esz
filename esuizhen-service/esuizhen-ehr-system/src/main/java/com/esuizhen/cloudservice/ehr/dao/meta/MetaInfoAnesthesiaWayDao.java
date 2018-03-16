package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoAnesthesiaWay;

public interface MetaInfoAnesthesiaWayDao {

	public List<TMetaInfoAnesthesiaWay> getMetaInfoAnesthesiaWayList(
			@Param("anesthesiaCode")String anesthesiaCode,
			@Param("anesthesiaName")String anesthesiaName);
}
