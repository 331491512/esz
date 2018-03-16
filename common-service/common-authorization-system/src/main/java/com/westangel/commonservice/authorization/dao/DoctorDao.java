package com.westangel.commonservice.authorization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorProfile;

/**
 * <p>Title:DoctorDao</p>
 * <p>Description:医生基本信息数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 上午9:50:00
 */
public interface DoctorDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增医生基本信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 上午11:16:10
	 * @param doctor
	 * @return
	 */
	int insert(Doctor doctor);

	/**
	 * <p>Title:findDoctorProfileByUserId</p>
	 * <p>Description:通过userId获取医生基本信息</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午6:53:06
	 * @param userId
	 * @return
	 */
	DoctorProfile findDoctorProfileByUserId(Long userId);
	
	/**
	 * <p>Title:findByUserId</p>
	 * <p>Description:通过userId获取医生信息</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午8:11:37
	 * @param userId
	 * @return
	 */
	Doctor findByUserId(Long userId);

	/**
	 * <p>Title:update</p>
	 * <p>Description:更新医生数据</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午8:21:50
	 * @param doctor
	 * @return
	 */
	int update(Doctor doctor);
	
	int updateParentId(Doctor doctor);
	
	/**
	 * <p>Title:updateSubordinate</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月4日 下午4:51:46
	 * @param parentId
	 * @param doctors
	 * @return
	 */
	int updateSubordinate(@Param("parentId")Long parentId, @Param("doctors")List<Doctor> doctors);
	
	/**
	 * <p>Title:removeParentRelation</p>
	 * <p>Description:去掉直接上级医生关系</p>
	 * @author YYCHEN
	 * @date 2016年8月4日 下午4:58:47
	 * @param parentId
	 * @return
	 */
	int removeParentRelation(@Param("parentId")Long parentId);
	
	/**
	 * <p>Title:findRoleDoctor</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月5日 下午5:29:03
	 * @param hospitalId
	 * @param userRole
	 * @return
	 */
	List<Doctor> findRoleDoctor(@Param("hospitalId")Integer hospitalId, @Param("userRole")Integer userRole);
	
	/**
	 * <p>Title:findPositionDoctor</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月24日 下午7:53:50
	 * @param hospitalId
	 * @param positionTitleId
	 * @return
	 */
	List<Doctor> findPositionDoctor(@Param("hospitalId")Integer hospitalId, @Param("positionTitleId")Integer positionTitleId);
	
	/**
	 * <p>Title:findSubordinateDoctors</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年8月5日 下午5:48:08
	 * @param hospitalId
	 * @param parentId
	 * @return
	 */
	List<Doctor> findSubordinateDoctors(@Param("hospitalId")Integer hospitalId, @Param("parentId")Long parentId);

	/**
	 * <p>Title:findSubordinateDoctorList</p>
	 * <p>Description:查询直接下级医师</p>
	 * @author YYCHEN
	 * @date 2016年8月20日 下午5:16:48
	 * @param doctorId
	 * @return
	 */
	List<Doctor> findSubordinateDoctorList(Long doctorId);

	Doctor findByDoctorId(Long doctorId);
}
