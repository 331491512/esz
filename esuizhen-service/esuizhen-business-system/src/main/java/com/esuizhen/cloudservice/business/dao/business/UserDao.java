package com.esuizhen.cloudservice.business.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.push.PushUser;

/**
 * 用户简单数据查询。内部使用。
 * @author bigdragon
 *
 */
public interface UserDao {

	String getUserTrueName(@Param("userId") Long userId,@Param("role") int role);

	String getUserMobile(@Param("userId") Long fromUserId);

	Long getDoctorId(Long vendor);

	Long getPatientId(Long buyer);
	
	String getOpenIdByUserId(@Param("userId") Long userId,@Param("productId") Integer productId);
	/**
	 * 返回 userId productId
	 * @author lichenghao
	 * @title :getPushOpenIdByUserId
	 * @Description:TODO
	 * @return PushUser
	 * @date 2016年6月24日 上午10:54:19
	 */
	PushUser getPushOpenIdByUserId(@Param("userId") Long userId);
	
	List getPatientInfo(Object param);
	
	//病种分组患者获取
	List<Long> queryDieaseGroupPatientUserId(Object param);
	//自定义分组患者获取
	List<Long> queryCustomGroupPatientUserId(Object param);
	//MDT组患者获取
	List<Long> queryMdtGroupPatientUserId(Object param);
	
	//获取患者的UserId
	Long querUserIdByPatientUuid(@Param("patientUuid")String buyerUuid);
	//获取医院的UserId
	Long queryUserIdByHospitalId(@Param("hospitalId")Integer hospitalId);
	
	//比较版本号
	Integer compareAppVersion(@Param("appVersion")String appVersion,@Param("userId")Long userId);

}
