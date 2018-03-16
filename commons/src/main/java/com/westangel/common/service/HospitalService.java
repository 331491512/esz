package com.westangel.common.service;

import java.util.List;

import com.westangel.common.bean.DepartmentProfile;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.HospitalSearchReq;
import com.westangel.common.bean.TWeixinProductIdInfo;

/**
 * 医院相关业务提供的公共服务功能
 * @author YYCHEN
 *
 */
public interface HospitalService {
	/**
	 * 医院模糊查询
	 * 根据cityCode=010和hospitalName=NAME
	 * 其中hospitalName查询时是模糊匹配
	 * @param hospitalSearchReq 请求参数封装bean
	 * @return 医院信息列表
	 */
	public List<HospitalProfile> getHospitals(HospitalSearchReq hospitalSearchReq);
	
	/**
	 * 根据医院获取该医院的科室列表
	 * @param hospitalId 医院ID
	 * @return 科室信息列表
	 */
	public List<DepartmentProfile> getDepartmentsByHospitalId(Integer hospitalId);
	
	/**
	 * 获取医院详细信息
	 * @param hospitalId
	 * @return
	 */
	public HospitalProfile getHospitalDetail(Integer hospitalId);
	
	/**
	 * 通过微信ID(toUserName)反查公众号对应的produtId。
	 * By Da Loong
	 * 2016/6/1
	 * @param weixinId
	 * @return
	 */
	public TWeixinProductIdInfo queryWxProductId(String weixinId);
}
