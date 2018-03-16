/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.utils;<br/>  
 * <b>文件名：</b>SyncResultUtile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月30日上午11:48:57<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.util;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.westangel.common.util.JsonUtil;

/** 
* @ClassName: SyncResultUtil
* @Description: 
* @author lichenghao
* @date 2017年3月30日 上午11:48:57  
*/
public class SyncResultUtil {
	public static TBatchDataResultInfo trunkToSyncResult(Object obj,TBatchDetailInfo detail){
		TBatchDataResultInfo result = JsonUtil.toObject(JsonUtil.toJson(obj), TBatchDataResultInfo.class);
		if(result==null)
			return result;
		result.setBatchId(detail.getBatchId());
		result.setTableId(detail.getTableId());
		//处理数据处理
		detail.handleSyncFlag(result);
		return result;
	}
}
