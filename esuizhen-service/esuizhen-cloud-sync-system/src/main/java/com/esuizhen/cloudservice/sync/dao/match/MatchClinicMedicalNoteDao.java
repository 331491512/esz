package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.westangel.common.bean.sync.UuidRelationship;

public interface MatchClinicMedicalNoteDao {

	/**
	 * <p>Title:insert</p>
	 * <p>Description:保存患者门诊信息到匹配库</p>
	 * @author YYCHEN
	 * @date 2016年9月8日 上午11:10:17
	 * @param clinicMedicalInfo
	 * @return
	 */
	int insert(TClinicMedicalNoteInfo clinicMedicalInfo);

	/**
	 * <p>Title:updatePatientUuid</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年9月8日 上午11:29:09
	 * @param patientFinalUuid
	 * @param uuidRelationships
	 * @return
	 */
	int updatePatientUuid(@Param("patientFinalUuid")String patientFinalUuid, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);

	/**
	 * <p>Title:findByPatientUuid</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年9月8日 上午11:29:38
	 * @param patientUuid
	 * @return
	 */
	List<TClinicMedicalNoteInfo> findByPatientUuid(String patientUuid);

	/**
	 * <p>Title:delete</p>
	 * <p>Description:删除门诊数据</p>
	 * @author YYCHEN
	 * @date 2016年9月8日 下午4:49:25
	 * @param clinicMedicalId
	 * @return
	 */
	int delete(String clinicMedicalId);

}
