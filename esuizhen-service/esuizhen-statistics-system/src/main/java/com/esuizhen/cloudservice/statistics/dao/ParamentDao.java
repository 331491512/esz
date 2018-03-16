/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.dao;<br/>  
 * <b>文件名：</b>ParamentDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日上午10:51:42<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.TRetrievalParamentInfo;

/** 
* @ClassName: ParamentDao
* @Description: 
* @author lichenghao
* @date 2016年8月10日 上午10:51:42  
*/
public interface ParamentDao {
	List<TRetrievalParamentInfo> queryParaments();
}
