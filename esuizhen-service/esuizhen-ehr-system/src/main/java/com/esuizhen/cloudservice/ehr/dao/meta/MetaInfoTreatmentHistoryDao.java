package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List; 

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfotreatmentHistory;


/**
* @ClassName: MetaInfoTreatmentHistoryDao 
* @Description: 既往治疗元数据接口
* @author wang_hw
* @date 2016年6月29日 下午9:05:22
 */
public interface MetaInfoTreatmentHistoryDao
{
	/**
	 * @author wang_hw
	 * @title :getMetaInfoTreatmentHistoryList
	 * @Description:获取既往治疗元数据
	 * @return TMetaInfotreatmentHistory
	 * @date 2016年6月29日 下午9:05:38
	 */
	public List<TMetaInfotreatmentHistory> getMetaInfoTreatmentHistoryList(@Param("treatmentHistoryName")String treatmentHistoryName);
}
