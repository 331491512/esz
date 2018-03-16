/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.push.dao;<br/>  
 * <b>文件名：</b>PushHistoryDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月9日下午12:36:54<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.push.dao;

import com.westangel.commonservice.push.model.PushHistory;

/** 
* @ClassName: PushHistoryDao
* @Description: 
* @author lichenghao
* @date 2017年2月9日 下午12:36:54  
*/
public interface PushHistoryDao {
/**
 * 	
 * @author lichenghao
 * @title :insert
 * @Description:插入推送记录
 * @return int
 * @date 2017年2月9日 下午12:39:46
 */
  int insert(PushHistory info);
}
