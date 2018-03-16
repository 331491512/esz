package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientWeixinOpenIdInfo;
import com.westangel.common.bean.Patient;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudPatientDao {
	
	public Patient findByUserId(Long userId);

	public List<Patient> findByMobile(@Param("mobile")String mobile, @Param("patientRelation")Integer patientRelation);

	public Long insert(Patient patient);
	
	public int update(Patient patient);
	
	/**
	 * <p>Title:setPatientDeatch</p>
	 * <p>Description:将患者的生存状态改为死亡</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午7:17:02
	 * @param patient
	 * @return
	 */
	public int setPatientDeatch(Patient patient);

	public Patient findByUuid(String uuid);
	/**
	 * 
	* @Title: incrWeixinPatientOfHostpital 
	* @Description: 获取微信患者增量 
	* @param @param hospitalId
	* @param @return    设定文件 
	* @return List<TPatientWeixinOpenIdInfo>    返回类型 
	* @throws
	 */
	public List<TPatientWeixinOpenIdInfo> getIncrWeixinPatientOfHospital(Integer hospitalId);

	/**
	 * <p>Title:findById</p>
	 * <p>Description:通过patientId查找患者信息</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午7:11:47
	 * @param patientId
	 * @return
	 */
	public Patient findById(Long patientId);
	
	/**
     * 获取微信用户
     * @param uuid 患者uuid
     * @return
     */
    Map<String, Object> getWxUser(@Param("uuid") String uuid);
}
