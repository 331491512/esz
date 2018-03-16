package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.DoctorHospitalSimpleInfo;
import com.esuizhen.cloudservice.user.bean.THospitalSimpleInfo;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.HospitalSearchReq;
import com.westangel.common.bean.THospitalSpecialtyInfo;
import com.westangel.common.bean.TWeixinProductIdInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface HospitalDao {
	/**
	 * 获取医院列表
	 * @return 医院列表
	 */
	public List<HospitalProfile> searchHospitals(HospitalSearchReq hospitalSearchReq);
	
	/**
	 * 
	 * @param keyword
	 * @return
	 */
	public List<DoctorHospitalSimpleInfo> findDoctorHospitalSimpleInfoes(Object param);
	/**
	 * 
	* @Title: findDoctorHospitalSimpleInfoesCount 
	* @Description:  
	* @param @param cityCode
	* @param @param keyword
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer findDoctorHospitalSimpleInfoesCount(Object param);
	
	/**
	 * 通过医院ID获取医院详细信息
	 * @param hospitalId
	 * @return
	 */
	public HospitalProfile selectHospital(@Param("hospitalId")Integer hospitalId,@Param("reqFlag")Integer reqFlag);
	
	/**
	 * 
	* @Title: addHospital 
	* @Description: 添加医院 
	* @param @param hospital    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addHospital(HospitalProfile hospital);
	/**
	 * 
	* @Title: updateHospital 
	* @Description: 修改医院信息 
	* @param @param hospital    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateHospital(HospitalProfile hospital);

	public List<HospitalProfile> findHospitalUuidByPatientUserId(Long userId);

	public List<HospitalProfile> findHospitalUuidByDoctorUserId(Long userId);

	public int existHospital(Integer hospitalId);

	public List<THospitalSimpleInfo> getHospitalsOfPatientList(@Param("patientId")Long patientId,@Param("productType")Integer productType,@Param("defaultHospitalPictureUrl")String defaultHospitalPictureUrl);

	/**
	 * 查询开通院级服务的医院列表
	 * By Da Loong
	 * @return
	 */
	public List<HospitalProfile> queryHospitalHavingService();


	 
	/**
	 * 查询医院Profile
	 * by Da Loong
	 **/
	 public HospitalProfile findHospitalProfileById(@Param("hospitalId")Integer hospitalId,@Param("defaultHospitalPictureUrl")String defaultHospitalPictureUrl);

	/**
	 * 查询患者医院认证列表
	 * by Da Loong
	 * 2016/6/1
	 * @param req
	 * @return
	 */
	 public List<THospitalSimpleInfo> findHospitalsCertificatedOfPatient(Object req);
	 /**
	  * 查询患者医院认证审核列表
	  * @param req
	  * @return
	  */
	public List<THospitalSimpleInfo> findHospitalsCertificatedOfPatientExam(Object req);

	/**
	 * 根据wxProductId，获取独立公众号医院名称
	 * @param wxProductId
	 * @return
	 */
	public List<THospitalSimpleInfo> getHospitalNameByProductId(Integer wxProductId);

	/**
	 * 通过微信Id反查公众号对应的productId
	 * By Da Loong
	 * 2016/6/1
	 */
	public TWeixinProductIdInfo getWxProductIdInfo(String weixinId);
	
	/**
	 * 移除医院特色专科
	 * @author lichenghao
	 * @title :removeHospitalSpecialtyList
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月14日 下午7:44:18
	 */
	public void removeHospitalSpecialtyList(@Param("hospitalId")Integer hospitalId);
	/**
	 * 增加医院特色专科
	 * @author lichenghao
	 * @title :insertHospitalSpecialty
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月14日 下午7:44:35
	 */
	public void insertHospitalSpecialty(@Param("hospitalId")Integer hospitalId,@Param("specialtys") List<THospitalSpecialtyInfo> specialtyList);

	/**
	 * <p>Title:querySignHospitals</p>
	 * <p>Description:获取已签约医院列表数据</p>
	 * @author YYCHEN
	 * @date 2016年7月4日 上午10:20:28
	 * @return
	 */
	public List<HospitalProfile> querySignHospitals();

	public List<HospitalProfile> findHospitalListInfo(HospitalSearchReq hospitalSearchReq);
}
