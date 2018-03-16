/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.util;<br/>  
 * <b>文件名：</b>ClientRequestServerUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月20日上午11:00:20<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.esuizhen.client.sync.common.ConstantClient;
import com.westangel.common.util.HttpUtil;

/** 
* @ClassName: ClientRequestServerUtil
* @Description: 
* @author lichenghao
* @date 2017年3月20日 上午11:00:20  
*/
@Component
public class ClientRequestServerUtil {
	private static String getBaseInfoUrl;
	private static String updateBaseInfoStateUrl;
	private static String pushBaseInfoDataUrl;
	private static String getResultInfoUrl;
	private static String getpPatientMergerUrl;
	private static String pushMonitorData;
	
	@Value("${server.batch.get}")
	public void setGetBaseInfoUrl(String getBaseInfoUrl) {
		ClientRequestServerUtil.getBaseInfoUrl = getBaseInfoUrl;
	}
	@Value("${server.batch.state.update}")
	public void setUpdateBaseInfoStateUrl(String updateBaseInfoStateUrl) {
		ClientRequestServerUtil.updateBaseInfoStateUrl = updateBaseInfoStateUrl;
	}
	@Value("${server.batch.push}")
	public void setPushBaseInfoDataUrl(String pushBaseInfoDataUrl) {
		ClientRequestServerUtil.pushBaseInfoDataUrl = pushBaseInfoDataUrl;
	}
	@Value("${server.batch.result.get}")
	public void setGetResultInfoUrl(String getResultInfoUrl) {
		ClientRequestServerUtil.getResultInfoUrl = getResultInfoUrl;
	}
	@Value("${server.patient.merger}")
	public void setGetpPatientMergerUrl(String getpPatientMergerUrl) {
		ClientRequestServerUtil.getpPatientMergerUrl = getpPatientMergerUrl;
	}
	@Value("${server.push.monitor.data}")
	public void setPushMonitorData(String pushMonitorData) {
		ClientRequestServerUtil.pushMonitorData = pushMonitorData;
	}
	public static String getBatchInfo(String json){
		return HttpUtil.postWithJSON(ConstantClient.serverApiUrl+getBaseInfoUrl, json);
	}
	public static String pushBatchData(String json){
		return HttpUtil.postWithJSON(ConstantClient.serverApiUrl+pushBaseInfoDataUrl, json);
	}
	public static String getBatChDataResult(String json){
		return HttpUtil.postWithJSON(ConstantClient.serverApiUrl+getResultInfoUrl, json);
	}
	public static String updateBatchProcess(String json){
		return HttpUtil.postWithJSON(ConstantClient.serverApiUrl+updateBaseInfoStateUrl, json);
	}
	public static String pushPatientMerge(String json){
		return HttpUtil.postWithJSON(ConstantClient.serverApiUrl+getpPatientMergerUrl, json);
	}
	public static String pushMonitorData(String json) {
		// TODO Auto-generated method stub
		return HttpUtil.postWithJSON(ConstantClient.serverApiUrl+pushMonitorData, json);
	}
}
