/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.dao;<br/>  
 * <b>文件名：</b>PushDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午9:51:47<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;
/** 
* @ClassName: PushDao
* @Description: 
* @author lichenghao
* @date 2016年5月18日 上午9:51:47  
*/
public interface PushDao {
	//解除绑定
	public Integer removeBind(Object param);
}
