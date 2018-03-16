package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.westangel.common.bean.sync.UuidRelationship;

/**
 * <p>Title:CloudEciTreatmentNoteDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月19日 下午4:00:07
 */
public interface MatchEciTreatmentNoteDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增治疗记录</p>
	 * @author fanpanwei
	 * @date 2016年5月19日 下午4:00:34
	 * @param eciTreatmentNote
	 * @return
	 */
	public int insert(EciTreatmentNote eciTreatmentNote);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updatePatientUuid
	 * @Description:修改uuid 成最终的uuid
	 * @return void
	 * @date 2016年12月24日 下午5:56:04
	 */
	public int updatePatientUuid(@Param("uuidFinal")String patientFinalUuid, @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :findByPatientUuid
	 * @Description:通过uuid查找匹配库中的治疗记录
	 * @return List<EciTreatmentNote>
	 * @date 2016年12月24日 下午5:56:36
	 */
	public List<EciTreatmentNote> findByPatientUuid(@Param("patientUuid")String patientFinalUuid);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :delete
	 * @Description:删除治疗信息
	 * @return int
	 * @date 2016年12月24日 下午6:04:03
	 */
	public int delete(@Param("treatmentId")String treatmentId);
}
