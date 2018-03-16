/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.dao.patient;<br/>  
 * <b>文件名：</b>TreatmentNoteDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日下午6:08:38<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.dao.patient;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentListReq;
import com.esuizhen.cloudservice.ehr.bean.TTreatmentInfo;

/** 
* @ClassName: TreatmentNoteDao
* @Description: 
* @author lichenghao
* @date 2016年5月24日 下午6:08:38  
*/
public interface TreatmentNoteDao {

	//获取患者既往治疗
	public List<TTreatmentInfo> queryPatientTreatment(PatientPastTreatmentListReq req);
	//既往治疗验证
	public String queryPatientTreatmentEmrIdByCreatorId(Object param);
	//删除既往治疗信息
	public int delPatientTreatment(Object param);
	/**
	 * 通过患者id删除治疗信息
	 * @param patientId
	 * @return
	 */
	int delPatientTreatmentByPatientId(@Param("patientId") Long patientId);
	//创建治疗信息
	public void createTreatment(Object param);
	//修改患者治疗信息
	public int modifyTreatment(Object param);
}
