package com.esuizhen.cloudservice.user.dao;

import com.esuizhen.cloudservice.user.bean.DoctorHospitalSimpleInfo;
import com.esuizhen.cloudservice.user.bean.DoctorListReq;
import com.esuizhen.cloudservice.user.bean.TDoctorMinInfo;
import com.esuizhen.cloudservice.user.bean.TDoctorStatisProfile;
import com.westangel.common.bean.*;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.bean.user.TTobeconfirmedDoctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author YYCHEN
 *
 */
public interface DoctorDao {

	public int deleteByPrimaryKey(Long doctorId);

	public long insert(Doctor record);

	public Doctor selectByPrimaryKey(Long doctorid);

	public int updateByPrimaryKey(Doctor record);

	public Doctor searchDoctor(String mobile);

	public Doctor findByUserId(Long userId);

	public List<DoctorTag> searchDoctorTagList();
	
	public List<Map<String, Object>> screenDoctor(Map<String, Object> param);
	
	public int updateDoctor(@Param("record") Doctor record);
	
	public DoctorProfile selectDoctorProfileByDoctorId(@Param("doctorId") Long doctorId, @Param("patientId") Long patientId,
			@Param("defaultManPicUrl")String defaultManPicUrl,
			@Param("defaultWomanPicUrl")String defaultWomanPicUrl);
	
	public DoctorProfile selectDoctorProfileByUserId(@Param("userId") Long userId, @Param("patientId") Long patientId,
			@Param("defaultManPicUrl")String defaultManPicUrl,
			@Param("defaultWomanPicUrl")String defaultWomanPicUrl);
	
	public int deleteDoctorByUserId(@Param("userId") Long userId);
	
	public List<DoctorSimpleInfo> recommendDoctor(@Param("patientId") Long patientId,
			@Param("hospitalId") Long hospitalId,
			@Param("defaultManPicUrl")String defaultManPicUrl,
			@Param("defaultWomanPicUrl")String defaultWomanPicUrl);
	
	public Long findDoctorIdByUserId(@Param("userId") Long userId);
	
	/**
	 * 
	* @Title: findDoctorHospitalSimpleInfoes 
	* @Description: 根据城市和关键词查询医生 
	* @param @param cityCode
	* @param @param keyword
	* @param @return    设定文件 
	* @return List<DoctorHospitalSimpleInfo>    返回类型 
	* @throws
	 */
	public List<DoctorHospitalSimpleInfo> findDoctorHospitalSimpleInfoes(Object param);
	
	
	/**
	 * 
	* @Title: findDoctorHospitalSimpleInfoesCount 
	* @Description: 根据城市和关键词查询医生个数 
	* @param @param cityCode
	* @param @param keyword
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer findDoctorHospitalSimpleInfoesCount(Object param);
	
	public List<ProductSimpleInfo> findDoctorProductByUserId(@Param("userId") Long userId);

	/**
	 * 
	 * @param patientId
	 * @param productType
	 * @return
	 */
	public List<DoctorSimpleInfo> findByPatientIdAndProductType(@Param("patientId") Long patientId, @Param("productType") Long productType,
			@Param("defaultManPicUrl")String defaultManPicUrl,
			@Param("defaultWomanPicUrl")String defaultWomanPicUrl);
	
	
	public List<DoctorSimpleInfo> findByBuyerAndProductType(@Param("buyer") Long buyer, @Param("productType") Long productType,
			@Param("defaultManPicUrl")String defaultManPicUrl,
			@Param("defaultWomanPicUrl")String defaultWomanPicUrl);
	
	public List<DoctorSimpleInfo> findByPatientId(@Param("patientId") Long patientId,
			@Param("defaultManPicUrl")String defaultManPicUrl,
			@Param("defaultWomanPicUrl")String defaultWomanPicUrl);
	
	public List<DoctorSimpleInfo> findDoctorIdAndNameByPatientIdOrPatientUserId(@Param("id") Long id, @Param("tag") String tag);

	public Long getUserIdByDoctorId(Long doctorId);
	/**
	 * 
	* @Title: selectToconfirmedDoctor 
	* @Description: 根据用户ID获取医生待确认信息 
	* @param @return    设定文件 
	* @return TTobeconfirmedDoctor    返回类型 
	* @throws
	 */
	public TTobeconfirmedDoctor selectToconfirmedDoctor(@Param("userId") Long userId);
    
    public int findByIdentificationCount(@Param("idType")Integer idType, @Param("identification")String identification, @Param("auditState") Integer auditState);
    
    //获取医生患者数
    public TDoctorStatisProfile queryDoctorPatientNum(Object obj);
    
    /**
	 * 
	* @Title: findDoctorHospitalSimpleInfoes 
	* @Description: 根据城市、关键词、医院 查询医生 
	* @param @param cityCode
	* @param @param keyword
	* @param @return    设定文件 
	* @return List<DoctorHospitalSimpleInfo>    返回类型 
	* @throws
	 */
	public List<DoctorSimpleInfo> findDoctorSimpleInfoes(Object param);
	public Integer findDoctorSimpleInfoesCount(Object param);
	/**
	 * 
	 * @author lichenghao
	 * @title :findDoctorSimpleInfoesByHospitalTrueName
	 * @Description :根据城市、关键词、医院名称查询医生
	 * @return List<DoctorSimpleInfo>
	 * @date 2016年6月7日 下午2:15:51
	 */
	public List<DoctorSimpleInfo> findDoctorSimpleInfoesByHospitalTrueName(Map<String, Object> param);
	public Integer findDoctorSimpleInfoesByHospitalTrueNameCount(Object param);
	public List<TDoctorMinInfo> getDoctorList(DoctorListReq req);

	public Integer selectDoctorHospitalBydoctorId(Long doctorId);

	/**
	 * 获取医院推荐的医生
	 * @param patientId
	 * @return
	 */
	List<DoctorSimpleInfo> recommendDoctorByHospital(@Param("patientId") Long patientId,
													 @Param("defaultManPicUrl")String defaultManPicUrl,
													 @Param("defaultWomanPicUrl")String defaultWomanPicUrl);

	/**
	 * 根据患者的病种标签获取推荐的医生
	 * @param tagInfos
	 * @return
	 */
	List<DoctorSimpleInfo> recommendDoctorByTag(@Param("tags") List<TagInfo> tagInfos,@Param("defaultManPicUrl")String defaultManPicUrl,
												@Param("defaultWomanPicUrl")String defaultWomanPicUrl);


	Integer getActivateRight(@Param("doctorId")Long doctorId);
	
	void modifyActivateDate(@Param("doctorId")Long doctorId);
}