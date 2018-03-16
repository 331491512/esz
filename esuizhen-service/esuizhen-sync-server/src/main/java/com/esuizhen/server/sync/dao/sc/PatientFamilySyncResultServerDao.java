/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.dao.sc;<br/>  
 * <b>文件名：</b>PatientFamilySyncResultServerDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月26日下午9:06:01<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.dao.sc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

/** 
* @ClassName: PatientFamilySyncResultServerDao
* @Description: 
* @author lichenghao
* @date 2017年3月26日 下午9:06:01  
*/
public interface PatientFamilySyncResultServerDao {
	//插入结果
	public int insert(Object obj);
	//获取结果集
	List<TBatchDataResultInfo> getBatchDataResult(@Param("batchId")String batchId);
}
