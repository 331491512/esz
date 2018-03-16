package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.MedialRecordForwardReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalPhotoOcrs;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;

/**
* @ClassName: EmedicalRecordDao 
* @Description: 电子病例数据操作接口
* @author wang_hw
* @date 2015年12月15日 下午2:26:17
 */
public interface EmedicalRecordDao{
	
	/**
	 * @author wang_hw
	 * @title :insertEmedicalRecord
	 * @Description:录入电子病例信息
	 * @return void
	 * @date 2015年12月15日 下午2:25:42
	 */
	public void insertEmedicalRecord(EmedicalRecord emedicalRecord);
	
	/**
	 * @author wang_hw
	 * @title :updateEmedicalRecord
	 * @Description:电子病例修改
	 * @return void
	 * @date 2015年12月15日 下午2:55:04
	 */
	public void updateEmedicalRecord(EmedicalRecord emedicalRecord);
	
	/**
	 * @author wang_hw
	 * @title :deleteEmedicalRecord
	 * @Description:根据ID删除电子病例
	 * @return void
	 * @date 2015年12月15日 下午4:26:00
	 */
	public void deleteEmedicalRecord(String emrId);
	
	/**
	 * @author wang_hw
	 * @title :queryEmedicalRecord
	 * @Description:查询电子病例明细
	 * @return EmedicalRecord
	 * @date 2015年12月15日 下午2:26:04
	 */
	public EmedicalRecord queryEmedicalRecordById(String emrId);
	
	/**
	 * @author wang_hw
	 * @title :queryEmedicalRecordCountByParam
	 * @Description:获取病历数
	 * @return Integer
	 * @date 2016年3月8日 下午4:02:17
	 */
	public Integer queryEmedicalRecordCountByParam(@Param("patientId")Long patientId, @Param("creatorId")Long creatorId, @Param("visibleFlag")String visibleFlag, @Param("sourceFlag")Integer sourceFlag);
	/**
	 * @author wang_hw
	 * @title :selectEmedicalRecordList
	 * @Description:根据患者ID查询电子病例
	 * @return List<EmedicalRecord>
	 * @date 2015年12月15日 下午4:27:11
	 */
	public List<EmedicalRecord> selectEmedicalRecordListByPatientId(Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :selectEmedicalRecordListByUserId
	 * @Description:根据UserId查询电子病历
	 * @return List<EmedicalRecord>
	 * @date 2015年12月26日 上午11:52:55
	 */
	public List<EmedicalRecord> selectEmedicalRecordListByUserId(@Param("userId")Long userId , @Param("patientId")Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :queryMedicalPhotoOcrsByEmrId
	 * @Description:查看电子病历ORC图片列表
	 * @return List<EmedicalPhotoOcrs>
	 * @date 2015年12月26日 下午5:25:41
	 */
	public List<EmedicalPhotoOcrs> queryMedicalPhotoOcrsByEmrId(String emrId);
	
	/**
	 * 获取患者UserId
	 * @author wang_hw
	 * @title :queryPatientById
	 * @Description:TODO
	 * @return LinkedHashMap<String,Object>
	 * @date 2016年1月25日 下午1:59:46
	 */
	public LinkedHashMap<String , Object> queryPatientById(@Param("doctorId")Long doctorId , @Param("patientId")Long patientId);
		
	
	/**
	 * 获取患者UserId
	 * @author wang_hw
	 * @title :queryPatientById
	 * @Description:TODO
	 * @return LinkedHashMap<String,Object>
	 * @date 2016年1月25日 下午1:59:46
	 */
	public LinkedHashMap<String , Object> queryPatientMdtById(@Param("doctorId")Long doctorId , @Param("patientId")Long patientId ,@Param("productApplyId") String productApplyId);
	
	/**
	 * 
	* @Title: queryEmrIdOfPateint 
	* @Description: 根据病案号获取患者的emrId 
	* @param @param patientId
	* @param @param patientNo
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public List<String> queryEmrIdOfPateint(
			@Param("patientId") Long patientId, 
			@Param("patientNo") String patientNo,
			@Param("hospitalId") Integer hospitalId);

	/**
	 * <p>Title:forwardMDTMedicalRecord</p>
	 * <p>Description:转发MDT会诊资料给患者</p>
	 * @author YYCHEN
	 * @date 2016年12月1日 上午10:12:58
	 * @param medialRecordForwardReq
	 * @return
	 */
	public int forwardMDTMedicalRecord(MedialRecordForwardReq medialRecordForwardReq);

}
