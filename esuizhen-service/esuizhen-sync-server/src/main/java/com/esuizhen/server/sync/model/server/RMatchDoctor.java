/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.model.server;<br/>  
 * <b>文件名：</b>RMatchPatient.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月23日下午2:04:12<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.model.server;
/** 
* @ClassName: RMatchPatient
* @Description: 
* @author lichenghao
* @date 2017年3月23日 下午2:04:12  
*/
public class RMatchDoctor {
	private Long matchUserId;
	private Long matchDoctorId;
	private String matchUuid;
	private Long targetUserId;
	private Long targetDoctorId;
	private String targetUuid;
	private Integer matchType;
	public Long getMatchUserId() {
		return matchUserId;
	}
	public void setMatchUserId(Long matchUserId) {
		this.matchUserId = matchUserId;
	}
	public String getMatchUuid() {
		return matchUuid;
	}
	public void setMatchUuid(String matchUuid) {
		this.matchUuid = matchUuid;
	}
	public Long getTargetUserId() {
		return targetUserId;
	}
	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}
	public String getTargetUuid() {
		return targetUuid;
	}
	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}
	public Long getMatchDoctorId() {
		return matchDoctorId;
	}
	public void setMatchDoctorId(Long matchDoctorId) {
		this.matchDoctorId = matchDoctorId;
	}
	public Long getTargetDoctorId() {
		return targetDoctorId;
	}
	public void setTargetDoctorId(Long targetDoctorId) {
		this.targetDoctorId = targetDoctorId;
	}
	public Integer getMatchType() {
		return matchType;
	}
	public void setMatchType(Integer matchType) {
		this.matchType = matchType;
	}
}
