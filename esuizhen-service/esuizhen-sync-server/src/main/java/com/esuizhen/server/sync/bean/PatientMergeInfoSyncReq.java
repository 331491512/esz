/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.bean;<br/>
 * <b>文件名：</b>PatientMergeInfoSyncReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午9:06:49<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: PatientMergeInfoSyncReq
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午9:06:49  
*/
public class PatientMergeInfoSyncReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer mergeFlag=2;
	private String mergeFromUuid;
	private String mergeTargetUuid;
	private Date mergeTime;
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Date getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}

	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}

	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
}
