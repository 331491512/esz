/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.service;<br/>  
 * <b>文件名：</b>DataSyncServer.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月18日下午7:32:31<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.service;

import com.esuizhen.client.sync.model.TBatchDetailInfo;

/** 
* @ClassName: DataSyncServer
* @Description: 
* @author lichenghao
* @date 2017年3月18日 下午7:32:31  
*/
public interface DataSyncService {
	//向推送数据  并返回推送条数
	public int pushDataToServer(TBatchDetailInfo detailInfo);
	//从云端拉取结果 并返回结果条数
	public int getResultFromServer(TBatchDetailInfo detailInfo);
}
