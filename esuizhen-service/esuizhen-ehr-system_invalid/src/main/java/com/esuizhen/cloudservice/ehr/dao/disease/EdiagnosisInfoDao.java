package com.esuizhen.cloudservice.ehr.dao.disease;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.TEmrDiagnosisInfo;

/**
 * 
* @ClassName: EdiagnosisInfoDao 
* @Description: 疾病信息 
* @author LIPENG
* @date 2016年3月1日 下午2:48:05 
*
 */
public interface EdiagnosisInfoDao {
	/**
	 * 
	* @Title: deleteDiagnosisOfPatient 
	* @Description: 删除患者的病历 
	* @param @param patientId
	* @param @param patientNo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteDiagnosisByEmrId(@Param("emrId") String emrId);
	/**
	 * 
	* @Title: insertDiagnosis 
	* @Description: 出入诊断信息 
	* @param @param list    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void insertDiagnosis(List<TEmrDiagnosisInfo> list);
}
