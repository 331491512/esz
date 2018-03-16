/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.dao.cloud;<br/>  
 * <b>文件名：</b>CloudPatientPatientNoDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月20日下午4:01:29<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.dao.cloud;

import com.westangel.common.bean.TPatientAndPatientNoRelation;

/** 
* @ClassName: CloudPatientPatientNoDao
* @Description: 
* @author lichenghao
* @date 2016年12月20日 下午4:01:29  
*/
public interface CloudPatientPatientNoDao {
	void insert(TPatientAndPatientNoRelation patientOfPatientNo);
}
