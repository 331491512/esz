/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.dao.patient;<br/>  
 * <b>文件名：</b>DiagnosisDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日下午3:05:34<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.dao.patient;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.TDiagnosisInfo;
import com.westangel.common.bean.PatientDiagnosisReq;
import com.westangel.common.bean.ehr.DiagnosisInfo;

/** 
* @ClassName: DiagnosisDao
* @Description: 
* @author lichenghao
* @date 2016年5月18日 下午3:05:34  
*/
public interface DiagnosisDao {
	//删除诊断
	public int delDiagnosis(Object param);
	
	//获取诊断列表
	public List<TDiagnosisInfo> queryPatientDiagnosis(Object param);
	
	//获取诊断emrId
	public String queryPatientDiagnosisEmrIdByCreatorId(PatientDiagnosisReq req);
	
	//新增诊断信息
	public void createDiagnosis(Object param);
	
	//修改诊断信息
	public int modifyDiagnosis(Object param);

}
