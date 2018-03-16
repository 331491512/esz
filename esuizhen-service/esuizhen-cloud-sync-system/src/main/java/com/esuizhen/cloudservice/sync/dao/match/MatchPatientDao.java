package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.Patient;
import com.westangel.common.bean.user.TTobeconfirmedPatient;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MatchPatientDao {
	
	public long insert(Patient patient);

	public int delete(Long patientId);
	
	public Patient findByUserId(Long userId);
	
	/**
	 * <p>Title:findByUuid</p>
	 * <p>Description:通过uuid值查找患者</p>
	 * @author YYCHEN
	 * @date 2016年6月17日 下午5:02:43
	 * @param uuid
	 * @return
	 */
	public Patient findByUuid(String uuid);

	public List<TTobeconfirmedPatient> selectNopushPatients();
	
	/**
	 * <p>Title:findNotCombinedDiagnosis</p>
	 * <p>Description:查询未合并诊断信息的患者</p>
	 * @author YYCHEN
	 * @date 2016年7月29日 上午10:14:27
	 * @return
	 */
	List<Patient> findNotCombinedDiagnosis();
	/**
	 * <p>Title:findNotCombinedSurgery</p>
	 * <p>Description:查询未合并手术信息的患者</p>
	 * @author YYCHEN
	 * @date 2016年7月29日 上午10:26:40
	 * @return
	 */
	List<Patient> findNotCombinedSurgery();
	/**
	 * <p>Title:findNotCombinedInhospital</p>
	 * <p>Description:查询未合并住院信息的患者</p>
	 * @author YYCHEN
	 * @date 2016年7月29日 上午10:26:44
	 * @return
	 */
	List<Patient> findNotCombinedInhospital();
	/**
	 * <p>Title:findNotCombinedFollowupResult</p>
	 * <p>Description:查询未合并随访结果信息的患者</p>
	 * @author YYCHEN
	 * @date 2016年7月29日 上午10:26:47
	 * @return
	 */
	List<Patient> findNotCombinedFollowupResult();
	
	/**
	 * 
	 * @author lichenghao
	 * @title :setNotifyPatientAgain
	 * @Description:未推送患者消息刷新
	 * @return int
	 * @date 2017年4月5日 下午3:26:44
	 */
	int setNotifyPatientAgain();
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updatePushFlag
	 * @Description:修改批次推送状态
	 * @return int
	 * @date 2017年4月5日 下午3:57:51
	 */
	public int updatePushFlag(@Param("matchUuids")List<String> userUuids, @Param("pushFlag") Integer pushFlag);
	
	public Integer findAffirmByMatchUuid(@Param("matchUuid")String uuid);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :setAffirm
	 * @Description:TODO
	 * @return int
	 * @date 2017年4月5日 下午6:00:33
	 */
	public int setAffirm(Object obj);
}
