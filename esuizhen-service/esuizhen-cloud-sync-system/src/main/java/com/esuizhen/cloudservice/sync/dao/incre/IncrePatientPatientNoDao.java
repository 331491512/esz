/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.dao.incre;<br/>  
 * <b>文件名：</b>IncrePatientPatientNoDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月20日下午3:13:16<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.bean.TPatientAndPatientNoRelationSync;

/** 
* @ClassName: IncrePatientPatientNoDao
* @Description: 
* @author lichenghao
* @date 2016年12月20日 下午3:13:16  
*/
public interface IncrePatientPatientNoDao {

	void insert(TPatientAndPatientNoRelationSync patientOfPatientNo);

}
