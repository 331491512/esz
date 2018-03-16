package com.esuizhen.cloudservice.ehr.service.outhospital;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.TOutHospitalInfo;

public interface OuthospitalService {
	/**
	 * 获取患者出院时间
	 * @author lichenghao
	 * @title :getOutHospitalDate
	 * @Description:TODO
	 * @return List<Object>
	 * @date 2016年5月2日 下午3:22:46
	 */
	public List<TOutHospitalInfo> getOutHospitalDateList(Long patientId,Integer hospitalId);
}
