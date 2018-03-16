package com.westangel.commonservice.authorization.dao;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.HospitalDoctor;

/**
 * <p>Title:RHospitalDoctorDao</p>
 * <p>Description:医院、医生关系数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午3:56:17
 */
public interface RHospitalDoctorDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增医院、医生关系</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午3:56:58
	 * @param hospitalDoctor
	 * @return
	 */
	int insert(HospitalDoctor hospitalDoctor);
	
	/**
	 * <p>Title:find</p>
	 * <p>Description:根据医院ID和医生ID查询医院与医生关系信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午3:57:46
	 * @param hospitalId
	 * @param doctorId
	 * @return
	 */
	HospitalDoctor find(@Param("hospitalId")Integer hospitalId, @Param("doctorId")Long doctorId);

	/**
	 * <p>Title:updateByDoctorId</p>
	 * <p>Description:更新医院医生关系数据</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午8:27:37
	 * @param hospitalDoctor
	 * @return
	 */
	int updateByDoctorId(HospitalDoctor hospitalDoctor);

	/**
	 * <p>Title:findStaffNo</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年9月2日 下午8:49:48
	 * @param hospitalId
	 * @param prefix
	 * @return
	 */
	String findStaffNo(@Param("hospitalId")Integer hospitalId, @Param("prefix")String prefix);
}
