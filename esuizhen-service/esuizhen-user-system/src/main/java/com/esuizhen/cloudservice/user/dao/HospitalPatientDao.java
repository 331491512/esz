package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.model.PatientHospitalCertificateInfo;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface HospitalPatientDao {
	/**
	 * 
	* @Title: hasRelationOfHospitalPatient 
	* @Description: 是否已存在 
	* @param @param briefInfo
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer hasRelationOfHospitalPatient(HospitalPatientBriefInfo briefInfo);
	/**
	 * 
	* @Title: insertRelationOfHospitalPatient 
	* @Description: 插入关系 
	* @param @param briefInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public int insertRelationOfHospitalPatient(HospitalPatientBriefInfo briefInfo);
	
	public HospitalPatientBriefInfo find(@Param("hospitalId")Integer hospitalId, @Param("patientId")Long patientId);
	
	public int updateToBHospitalPatientToCloudRelation(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId, @Param("hospitalPatientBriefInfos")List<HospitalPatientBriefInfo> hospitalPatientBriefInfos);
	
	/**
	 * <p>Title:deleteByPatientId</p>
	 * <p>Description:通过患者ID删除医院患者关系</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午7:05:23
	 * @param patientId
	 * @return
	 */
	public int deleteByPatientId(Long patientId);
	/**
	 * <p>Title:update</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午6:15:13
	 * @param hospitalPatientBriefInfo
	 * @return
	 */
	public int update(HospitalPatientBriefInfo hospitalPatientBriefInfo);
	/**
	 * <p>Title: findANotNullPatientNo</p>
	 * <p>Description: 获取一个为空病案号的医院、患者关系</p>
	 * @date 2016年5月3日 下午2:13:01
	 * @param patientId
	 * @return
	 */
	public HospitalPatientBriefInfo findANotNullPatientNo(@Param("patientId")Long patientId,@Param("hospitalId")Integer hospitalId);
	
//	/**
//	 * 
//	* @Title: updateRelationOfHospitalPatient 
//	* @Description: 更新关系 
//	* @param @param briefInfo    设定文件 
//	* @return void    返回类型 
//	* @throws
//	 */
//	public void updateRelationOfHospitalPatient(HospitalPatientBriefInfo briefInfo);
	public List<HospitalPatientBriefInfo> screening(@Param("cloudPatientId")Long cloudPatientId, @Param("tobPatientId")Long tobPatientId);
	
	/**
	 * <p>Title:findByPatientId</p>
	 * <p>Description:通过患者ID查询医院患者关系</p>
	 * @author YYCHEN
	 * @date 2016年5月26日 下午6:01:55
	 * @param patientId
	 * @return
	 */
	public List<HospitalPatientBriefInfo> findByPatientId(Long patientId);
	
	/**
	 * <p>Title:findNoPatientNoes</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月17日 下午5:47:13
	 * @param patientId
	 * @return
	 */
	public List<HospitalPatientBriefInfo> findNoPatientNoes(Long patientId);
	
	/**
	 * <p>Title:findFirstHasPatientNo</p>
	 * <p>Description:通过患者ID获取第一个有病案号的医院患者信息</p>
	 * @author YYCHEN
	 * @date 2016年6月7日 下午7:12:36
	 * @param patientId
	 * @return
	 */
	public HospitalPatientBriefInfo findFirstHasPatientNo(Long patientId);
	
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
	/**
	 * <p>Title:delete</p>
	 * <p>Description:通过ID删除医院患者关系</p>
	 * @author YYCHEN
	 * @date 2016年5月26日 下午6:06:36
	 * @param id
	 * @return
	 */
	public int delete(Long id);
	
	/**
	 * 患者医院认证
	 * @param patientId
	 * @param hospitalId
	 * @param patientNo
	 * @return
	 */
	public Integer checkPatientNo(@Param("patientId")Long patientId, @Param("hospitalId")Integer hospitalId, @Param("patientNo")String patientNo);
	
	/**
	 * 查找此患者正在进行院级服务的医院
	 * @param patientId
	 * @return
	 */
	public Integer findHospitalInServiceOfPatient(Integer patientId);
	
	/**
	 * 查找此患者关注的一个医院
	 * @param patientId
	 * @return
	 */
	public Integer findHospitalOfPatient(Integer patientId);
	
	/**
	 * 更新医院认证标识
	 * @param id
	 */
	public void updateHospitalCertificateState(@Param("id")Integer id,@Param("hospitalCertificateState")Integer hospitalCertificateState);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :checkPatientNoInRelation
	 * @Description:检查患者病案号姓名对应表
	 * @return Integer
	 * @date 2017年1月9日 上午9:55:26
	 */
	public PatientHospitalCertificateInfo checkPatientNoInRelation(Object params);
	/**
	 * 
	 * @author lichenghao
	 * @title :checkPatientNoInMatchRelation
	 * @Description:检查患者病案号姓名对应在匹配库中
	 * @return Integer
	 * @date 2017年1月9日 上午9:55:26
	 */
	public PatientHospitalCertificateInfo checkPatientNoInMatchRelation(Object params);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateRelationHospitalCertificateState
	 * @Description:修改患者医院认证信息
	 * @return Integer
	 * @date 2017年1月9日 上午9:57:38
	 */
	public Integer updateRelationHospitalCertificateState(@Param("id")Integer id,@Param("hospitalCertificateState")Integer hospitalCertificateState);
	public void mergerInfo(@Param("tocPatientId")Long patientId, @Param("tobPatientId")Long patientId2);
}
