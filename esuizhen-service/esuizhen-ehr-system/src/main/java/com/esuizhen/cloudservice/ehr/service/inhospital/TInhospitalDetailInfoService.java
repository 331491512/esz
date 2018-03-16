package com.esuizhen.cloudservice.ehr.service.inhospital;

import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.PatientInfoReq;
import com.westangel.common.bean.Page;

/**
* @ClassName: TInhospitalDetailInfoService 
* @Description: 住院信息服务接口
* @author wang_hw
* @date 2016年6月28日 下午3:12:53
 */
public interface TInhospitalDetailInfoService{

	/**
	 * @author wang_hw
	 * @title :queryInhospitalInfo
	 * @Description:住院信息简要查询
	 * @return TInhospitalInfo
	 * @date 2016年6月28日 下午3:13:08
	 */
	public Page<TInhospitalInfo> queryInhospitalInfo(Long patientId,String outhospitalDateStart,String outhospitalDateEnd,Integer outhospitalDeptId,Integer page,Integer num);
	
	/**
	 * @author wang_hw
	 * @title :queryInhospitalDetail
	 * @Description:住院信息明细查询
	 * @return TInhospitalDetailInfo
	 * @date 2016年6月28日 下午3:13:24
	 */
	public TInhospitalDetailInfo queryInhospitalDetail(String inhospitalId);
	
	/**
	 * @author wang_hw
	 * @title :deleteInhospitalDetail
	 * @Description:住院信息删除
	 * @return void
	 * @date 2016年6月28日 下午3:13:39
	 */
	public void deleteInhospitalDetail(String inhospitalId);
	
	/**
	 * @author wang_hw
	 * @title :updateInhospitalDetail
	 * @Description:住院信息修改
	 * @return void
	 * @date 2016年6月28日 下午3:13:50
	 */
	public void updateInhospitalDetail(TInhospitalDetailInfo inhospitalDetailInfo);
	
	/**
	 * @author wang_hw
	 * @title :updateInhospitalFiling
	 * @Description:住院信息归档及取消归档
	 * @return void
	 * @date 2016年6月28日 下午3:14:05
	 */
	public void updateInhospitalFiling(PatientInfoReq req);

	/**
	* @Title: createInhospitalDetail
	* @Description: 住院信息添加
	* @return void 
	 */
	public TInhospitalDetailInfo createInhospitalDetail(TInhospitalDetailInfo inhospitalDetailInfo);
}
