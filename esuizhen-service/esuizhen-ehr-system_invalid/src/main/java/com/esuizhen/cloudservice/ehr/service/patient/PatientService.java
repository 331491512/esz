/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.patient;<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午11:47:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.patient;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.PatientDiagnosisListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientInHospitalNoteListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentReq;
import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.esuizhen.cloudservice.ehr.bean.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.bean.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.bean.TOutHospitalInfo;
import com.esuizhen.cloudservice.ehr.bean.TTreatmentInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientDiagnosisReq;

/** 
* @ClassName: PatientService
* @Description: 
* @author lichenghao
* @date 2016年5月18日 上午11:47:58  
*/
public interface PatientService {
	//获取患者入院信息
	Page<TInhospitalInfo> getPatienInhospitalList(PatientInHospitalNoteListReq req);
	
	/**
	 * 获取患者出院时间
	 * @author lichenghao
	 * @title :getOutHospitalDate
	 * @Description:TODO
	 * @return List<Object>
	 * @date 2016年5月2日 下午3:22:46
	 */
	public List<TOutHospitalInfo> getOutHospitalDateList(Long patientId,Integer hospitalId);
	
	//获取患者诊断列表
	Page<TDiagnosisInfo> getPatientDiagnosisList(PatientDiagnosisListReq req);
	
	//创建患者诊断
	void createPatientDiagnosis(PatientDiagnosisReq req);
	
	//修改患者诊断
	void modifyPatientDiagnosis(PatientDiagnosisReq req);
	
	//删除患者诊断信息
	public void delPatientDiagnosis(PatientDiagnosisReq req);
	
	//获取患者既往治疗
	Page<TTreatmentInfo> getPatientPastTreatmentList(PatientPastTreatmentListReq req);

	//新建既往治疗
	void addPatientPastTreatment(PatientPastTreatmentReq req);

	//修改既往治疗
	void modifyPatientPastTreatment(PatientPastTreatmentReq req);

	//删除既往治疗
	void delPatientPastTreatment(PatientPastTreatmentReq req);
	/**
	 * 患者症状信息列表查询
	 * @param patientId
	 * @param inhospitalId
	 * @param symptomName
	 * @return
	 */
	List<PatientSymptomInfo> patientSymptomList(Map<String,Object> paramsMap);
	/**
	 * 患者症状信息保存
	 * @param patientSymptom
	 * @return
	 */
	int savePatientSymptom(List<PatientSymptomInfo> patientSymptom);
	
	/**
	 * 删除患者症状信息
	 * @param patientSymptom
	 * @return
	 */
	int deletePatientSymptom(Map<String,Object> paramsMap);
}
