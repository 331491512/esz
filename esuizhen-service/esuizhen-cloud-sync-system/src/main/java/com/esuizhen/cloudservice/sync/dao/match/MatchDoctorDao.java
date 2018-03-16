package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.user.TTobeconfirmedDoctor;

/**
 * 匹配数据库医生数据访问接口
 * @author YYCHEN
 *
 */
public interface MatchDoctorDao {
	
	public long insert(Doctor doctor);
	
	public int delete(Long doctorId);
	
	public List<TTobeconfirmedDoctor> selectNopushDoctors();
	
	public Doctor findByUserId(Long userId);

	public TTobeconfirmedDoctor selectNopushDoctor(Long userId);
	
	public Integer findDoctorByUuId(String doctorUuId);
	
	public int setNotifyDoctorAgain();
	
	public int updatePushFlag(@Param("matchUuids")List<String> userUuids, @Param("pushFlag") Integer pushFlag);

	public int setAffirm(Object params);

	public Integer findAffirmByMatchUuid(String uuid);
}
