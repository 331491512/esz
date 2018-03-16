/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.utils;<br/>  
 * <b>文件名：</b>SyncResultUtile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月30日上午11:48:57<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.utils;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;

/** 
* @ClassName: SyncResultUtil
* @Description: 
* @author lichenghao
* @date 2017年3月30日 上午11:48:57  
*/
public class SyncResultUtil {
	public static void checkSyncResult(TBatchDataResultInfo result,TBatchDetailInfo detail){
		result.setBatchId(detail.getBatchId());
		result.setTableId(detail.getTableId());
		result.checkCause();
	}
}
