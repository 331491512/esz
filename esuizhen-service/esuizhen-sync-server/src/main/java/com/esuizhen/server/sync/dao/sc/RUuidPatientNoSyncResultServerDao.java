/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.dao.sc;<br/>
 * <b>文件名：</b>PatientSyncResultServer.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月22日下午3:38:31<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.dao.sc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

/** 
* @ClassName: RUuidPatientNoSyncResultServerDao
* @Description: 
* @author lichenghao
* @date 2017年3月22日 下午3:38:31  
*/
public interface RUuidPatientNoSyncResultServerDao {
	//插入结果
	public int insert(Object obj);
	//获取同步结果
	List<TBatchDataResultInfo> getBatchDataResult(@Param("batchId")String batchId);
}
