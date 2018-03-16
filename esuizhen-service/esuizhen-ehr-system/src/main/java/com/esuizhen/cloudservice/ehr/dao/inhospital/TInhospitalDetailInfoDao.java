package com.esuizhen.cloudservice.ehr.dao.inhospital;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalInfo;

public interface TInhospitalDetailInfoDao {

	/**
	 * @author wang_hw
	 * @title :updateInhospitalDetail
	 * @Description:修改住院明细信息
	 * @return void
	 * @date 2016年6月28日 下午3:40:13
	 */
	public void updateInhospitalDetail(TInhospitalDetailInfo inhospitalDetailInfo);

	/**
	 * @author wang_hw
	 * @title :updateInhospitalFiling
	 * @Description:住院信息归档及取消归档
	 * @return void
	 * @date 2016年6月28日 下午4:02:56
	 */
	public void updateInhospitalFiling(@Param("inhospitalId") String inhospitalId, @Param("flag") Integer flag);

	/**
	 * @author wang_hw
	 * @title :deleteInhospitalDetail
	 * @Description:删除住院信息
	 * @return void
	 * @date 2016年6月28日 下午3:40:18
	 */
	public void deleteInhospitalDetail(@Param("inhospitalId") String inhospitalId);

	/**
	 * @author wang_hw
	 * @title :
	 *        queryInhospitalDetailByInhospitalId
	 * @Description:查询住院信息明细
	 * @return TInhospitalDetailInfo
	 * @date 2016年6月28日 下午3:40:22
	 */
	public TInhospitalDetailInfo queryInhospitalDetailByInhospitalId(@Param("inhospitalId") String inhospitalId);

	/**
	 * 查找上次的住院次数
	 * 
	 * @param patientId
	 * @param inhospitalDate
	 * @return
	 */
	public Integer queryInhospitalTime(@Param("patientId") Long patientId, @Param("inhospitalDate") Date inhospitalDate);

	/**
	 * @author wang_hw
	 * @title :
	 *        queryInhospitalInfoByInhospitalId
	 * @Description:查询住院简要信息
	 * @return TInhospitalInfo
	 * @date 2016年6月28日 下午3:40:27
	 */
	public List<TInhospitalInfo> queryInhospitalInfoByPatientId(Map<String, Object> paraMap);

	/**
	 * @author raox
	 * @title :createInhospitalDetail
	 * @Description:创建住院明细信息
	 * @return TInhospitalDetailInfo
	 * @date 2016年7月9日 下午3:08:22
	 */
	public void createInhospitalDetail(TInhospitalDetailInfo inhospitalDetailInfo);

	/**
	 * @author yuanwenming
	 * @title :
	 *        queryInhospitalDetailByInhospitalId
	 * @Description:查询住院信息明细
	 * @return TInhospitalDetailInfo
	 * @date 2016年6月28日 下午3:40:22
	 */
	public TInhospitalDetailInfo queryInhospitalDetailByPrimaryKeyId(@Param("inhospitalId") String inhospitalId);

	/**
	 * @author yuanwenming
	 * @title :updateInhospitalDetail
	 * @Description:修改住院明细信息
	 * @return void
	 * @date 2016年6月28日 下午3:40:13
	 */
	public void updateInhospitalDetailSelective(TInhospitalDetailInfo inhospitalDetailInfo);

	/**
	 * 修改住院次数
	 * 
	 * @param patientId
	 */
	public void updateInhospitalTimes(@Param("patientId") Long patientId);

	public void updateInhospitalByCode(TInhospitalDetailInfo inhospitalDetailInfo);

	public void updateInhospitalAge(@Param("patientId") Long patientId, @Param("birthDate") Date birthDate);

	/**
	 * 修改住院、诊断、手术信息，更新宽表
	 * 
	 * @param patientId
	 */
	void freshPatientWideTable(Long patientId);

}
