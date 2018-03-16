/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.dao.server;<br/>  
 * <b>文件名：</b>DoctorDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月25日下午3:43:56<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.dao.server;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.model.server.TDoctor;

/** 
* @ClassName: DoctorDao
* @Description: 
* @author lichenghao
* @date 2017年3月25日 下午3:43:56  
*/
public interface DoctorDao {
	public int insert(Object obj);
	public int update(Object object);
	
	public TDoctor queryDoctorByUserId(@Param("userId")Long userId);
	
	public TDoctor queryDoctorByUuid(@Param("uuid")String uuid);
	
	public Integer queryDoctorByMobileUnique(Object obj);
	
	public int delete(@Param("doctorId")Long doctorId);
}
