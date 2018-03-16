/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service;<br/>  
 * <b>文件名：</b>MatchService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月6日上午10:15:59<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service;

import com.westangel.common.bean.sync.MatchUserMergeReq;

/** 
* @ClassName: MatchService
* @Description: 
* @author lichenghao
* @date 2017年4月6日 上午10:15:59  
*/
public interface MatchService {

	void matchUserMerge(MatchUserMergeReq req);

}
