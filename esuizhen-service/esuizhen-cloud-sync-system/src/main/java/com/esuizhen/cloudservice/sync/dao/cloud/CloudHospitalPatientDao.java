package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TSyncRecord;
import com.esuizhen.cloudservice.sync.model.HospitalPatient;

/**
 * 云端数据库医院、患者关系数据访问接口
 * @author YYCHEN
 *
 */
public interface CloudHospitalPatientDao {
	int insert(HospitalPatient hospitalPatient);
	
	public int update(HospitalPatient hospitalPatient);
	
	public HospitalPatient findByHospitalUuidAndPatientUuid(@Param("hospitalUuid")String hospitalUuid, @Param("patientUuid")String patientUuid);

	public HospitalPatient find(HospitalPatient hospitalPatient);
	
	/**
	 * 
	* @Title: setWeixinSyncedFlag4Uuids 
	* @Description: 设置微信同步结果标记
	* @param @param uuids    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public int setWeixinSyncedFlag4Uuids(@Param("uuids")List<TSyncRecord> uuids);

	/**
	 * 
	* @Title: setSyncedFlag4Uuids 
	* @Description: 设置已同步的标志 
	* @param @param uuids    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public int setSyncedTime4Uuids(@Param("hospitalId")Integer hospitalId, @Param("uuids")List<TSyncRecord> uuids);

	/**
	 * <p>Title:findNoPatientNoes</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午6:28:50
	 * @param patientId
	 * @return
	 */
	public List<HospitalPatient> findNoPatientNoes(Long patientId);
	
	/**
	 * <p>Title:findPatientNo</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午6:10:40
	 * @param patientId
	 * @param hospitalId
	 * @return
	 */
	public String findPatientNo(@Param("patientId")Long patientId, @Param("hospitalId")Integer hospitalId);
}
