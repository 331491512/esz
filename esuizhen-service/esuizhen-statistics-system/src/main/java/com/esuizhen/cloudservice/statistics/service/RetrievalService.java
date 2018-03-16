/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.service;<br/>  
 * <b>文件名：</b>RetrievalService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日上午11:00:03<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.service;

import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.TRetrievalParamentInfo;
import com.esuizhen.cloudservice.statistics.model.TRetrievalParamentMould;

/** 
* @ClassName: RetrievalService
* @Description: 
* @author lichenghao
* @date 2016年8月10日 上午11:00:03  
*/
public interface RetrievalService {

	public List<TRetrievalParamentInfo> getRetrievalParament();

	/**
	 * 保存用户设置的高级查询模板。
	 * @param retrievalParamentMould
	 * @return
	 */
	public boolean saveRetrievalParamentMould(TRetrievalParamentMould retrievalParamentMould);

	/**
	 * 用户设置的高级查询模板列表数据
	 * @param userId
	 * @return
	 */
	public List<TRetrievalParamentMould> searchRetrievalParamentMouldList(TRetrievalParamentMould retrievalParamentMould);

	/**
	 * 用户设置的高级查询模板详细数据
	 * @param mouldId
	 * @return
	 */
	TRetrievalParamentMould getRetrievalParamentMouldDetail(String mouldId);

	/**
	 * 删除用户设置的高级查询模板数据
	 * @param retrievalParamentMould
	 * @return
	 */
	public boolean removeRetrievalParamentMould(TRetrievalParamentMould retrievalParamentMould);
}
