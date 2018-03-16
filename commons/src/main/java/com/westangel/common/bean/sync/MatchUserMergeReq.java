/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.sync;<br/>  
 * <b>文件名：</b>MatchUserMergeReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月6日上午10:10:00<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.sync;

import java.io.Serializable;

/** 
* @ClassName: MatchUserMergeReq
* @Description: 
* @author lichenghao
* @date 2017年4月6日 上午10:10:00  
*/
public class MatchUserMergeReq  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String matchUuid;
	private String targetUuid;
	private Integer role;
	public String getMatchUuid() {
		return matchUuid;
	}
	public void setMatchUuid(String matchUuid) {
		this.matchUuid = matchUuid;
	}
	public String getTargetUuid() {
		return targetUuid;
	}
	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	public MatchUserMergeReq(String matchUuid, String targetUuid, Integer role) {
		super();
		this.matchUuid = matchUuid;
		this.targetUuid = targetUuid;
		this.role = role;
	}
}
