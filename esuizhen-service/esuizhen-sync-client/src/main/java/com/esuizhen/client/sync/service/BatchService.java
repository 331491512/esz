/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.service;<br/>  
 * <b>文件名：</b>BatchService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月18日下午6:31:03<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.service;
/** 
* @ClassName: BatchService
* @Description: 
* @author lichenghao
* @date 2017年3月18日 下午6:31:03  
*/
public interface BatchService {
	public void initSyncCtl();

	public void runBatchPush();

	public void runBatchGetResult();

	public void runPatientMerger();
	
	public void runIncreSyncResult();

	public void loadingBatch();

	public void pushMonitorToServer(String date);
}
