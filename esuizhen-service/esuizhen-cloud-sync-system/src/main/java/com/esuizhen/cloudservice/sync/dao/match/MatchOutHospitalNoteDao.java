package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;
import com.westangel.common.bean.sync.UuidRelationship;

public interface MatchOutHospitalNoteDao {

	/**
	 * <p>Title:insert</p>
	 * <p>Description:将出院小结保存到匹配端库</p>
	 * @author fanpanwei
	 * @date 2016年9月7日 下午5:49:39
	 * @param clinicMedicalNoteInfo
	 * @return
	 */
	int insert(TOutHospitalNoteInfo outHospitalNoteInfo);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updatePatientUuid
	 * @Description:出院小结uuid更正
	 * @return int
	 * @date 2016年12月25日 下午2:54:17
	 */
	public int updatePatientUuid(@Param("uuidFinal")String uuidFinal, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :delete
	 * @Description:删除出院小结
	 * @return int
	 * @date 2016年12月25日 下午2:54:40
	 */
	public int delete(@Param("outhospitalId")String outhospitalId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :findByPatientUuid
	 * @Description:获取出院小结
	 * @return List<TOutHospitalNoteInfo>
	 * @date 2016年12月25日 下午2:55:54
	 */
	public List<TOutHospitalNoteInfo> findByPatientUuid(@Param("patientUuid")String patientUuid);
}
