package com.esuizhen.cloudservice.ehr.service.medicalRecord;

import com.esuizhen.cloudservice.ehr.bean.MedialRecordForwardReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.resp.MedialRecordUploadResp;
import com.westangel.common.bean.Page;

/**
* @ClassName: EmedicalRecordService 
* @Description: 电子病例服务接口
* @author wang_hw
* @date 2015年12月15日 下午2:12:21
 */
public interface EmedicalRecordService{
	
	/**
	 * @author wang_hw
	 * @title :insertEmedicalRecord
	 * @Description:电子病例数据录入
	 * @return void
	 * @date 2015年12月15日 下午2:12:35
	 */
	public MedialRecordUploadResp insertEmedicalRecord(EmedicalRecord emedicalRecord);
	
	/**
	 * @author wang_hw
	 * @title :updateEmedicalRecord
	 * @Description:电子病例信息修改
	 * @return void
	 * @date 2015年12月15日 下午2:56:31
	 */
	public void updateEmedicalRecord(EmedicalRecord emedicalRecord);
	
	/**
	 * @author wang_hw
	 * @title :deleteEmedicalRecord
	 * @Description:根据ID删除电子病例
	 * @return void
	 * @date 2015年12月15日 下午3:13:07
	 */
	public void deleteEmedicalRecord(String emrId);
	
	/**
	 * @author wang_hw
	 * @title :queryEmedicalRecord
	 * @Description:电子病例明细查询
	 * @return EmedicalRecord
	 * @date 2015年12月15日 下午2:20:18
	 */
	public EmedicalRecord queryEmedicalRecordById(String emrId);
	
	/**
	 * @author wang_hw
	 * @title :selectEmedicalRecordList
	 * @Description:根据患者ID查询电子病例
	 * @return Page<EmedicalRecord>
	 * @date 2015年12月15日 下午4:27:11
	 */
	public Page<EmedicalRecord> selectEmedicalRecordList(Long userId , Integer role , Long patientId , Integer page , Integer num);

	/**
	 * <p>Title:forwardMedicalRecord2Patient</p>
	 * <p>Description:将上传的病历转发给患者</p>
	 * @author YYCHEN
	 * @date 2016年12月1日 上午10:01:18
	 * @param medialRecordForwardReq
	 * @return
	 */
	boolean forwardMedicalRecord2Patient(MedialRecordForwardReq medialRecordForwardReq);
}
