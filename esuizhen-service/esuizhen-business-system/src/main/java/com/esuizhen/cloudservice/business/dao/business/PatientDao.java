/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>BusinessDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:42:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import com.westangel.common.bean.Patient;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>Title:PatientDao</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年10月8日 下午9:07:21
 */
public interface PatientDao {
	/**
	 * <p>Title:findHospitalProfile</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年10月8日 下午9:10:39
	 * @param hospitalId
	 * @param patientId
	 * @return
	 */
	HospitalPatientBriefInfo findHospitalProfile(@Param("hospitalId")Integer hospitalId, @Param("patientUserId")Long patientUserId);

	Patient findByUserId(Long userId);

	int inserHospitalPatientBriefInfo(HospitalPatientBriefInfo hospitalPatientBriefInfo);

	int updatePatientNo(@Param("hospitalId")Integer hospitalId, @Param("patientId")Long patientId, @Param("patientNo")String patientNo);
	
	LinkedHashMap<String,String> queryPatientInfoCard(Object param);

	Integer findByPatientId(Long patientId);

	List<TagInfo> getPatientTags(Long patientId);

	LinkedHashMap<String,Object> queryPatientIsOutHospital(@Param("inhospitalIds") List<String> inhospitalIds);

	HashMap<String,Object> getHospitalByPatientUserId(@Param("userId") Long userId);
}
