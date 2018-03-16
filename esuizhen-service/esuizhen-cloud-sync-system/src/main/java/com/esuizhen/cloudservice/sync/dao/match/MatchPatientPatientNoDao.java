/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.dao.match;<br/>  
 * <b>文件名：</b>MatchPatientPatientNoDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月20日下午4:04:43<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.bean.TPatientAndPatientNoRelationSync;
import com.westangel.common.bean.TPatientAndPatientNoRelation;
import com.westangel.common.bean.sync.UuidRelationship;

/** 
* @ClassName: MatchPatientPatientNoDao
* @Description: 
* @author lichenghao
* @date 2016年12月20日 下午4:04:43  
*/
public interface MatchPatientPatientNoDao {

	void insert(TPatientAndPatientNoRelationSync patientOfPatientNo);
	
	List<TPatientAndPatientNoRelation> getPatientPatientNoByUuid(@Param("uuid")String uuid);
	
	void delete(@Param("id")Integer id);

	int updatePatientUuid(@Param("uuidFinal")String patientFinalUuid,  @Param("uuidRelationships")List<UuidRelationship> uuidRelationships);
}
