package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;

/** 
* @ClassName: TProjectCountInfo 
* @Description: 科研专题统计信息
* @author YYCHEN
* @date 2016年04月01日 下午17:45:01  
*/
public class TProjectCountInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//共有专题项目个数
	private Integer totalProjectCount;
	//创建并管理的项目个数
	private Integer manageProjectCount;
	//参与研究的项目个数
	private Integer participateCount;
	//尚未设置完成的项目个数
	private Integer unfinishedCount;
	//进行中的项目个数
	private Integer runningCount;
	//已完成的项目个数
	private Integer completeCount;
	
	public Integer getTotalProjectCount() {
		return totalProjectCount;
	}
	public void setTotalProjectCount(Integer totalProjectCount) {
		this.totalProjectCount = totalProjectCount;
	}
	public Integer getManageProjectCount() {
		return manageProjectCount;
	}
	public void setManageProjectCount(Integer manageProjectCount) {
		this.manageProjectCount = manageProjectCount;
	}
	public Integer getParticipateCount() {
		return participateCount;
	}
	public void setParticipateCount(Integer participateCount) {
		this.participateCount = participateCount;
	}
	public Integer getUnfinishedCount() {
		return unfinishedCount;
	}
	public void setUnfinishedCount(Integer unfinishedCount) {
		this.unfinishedCount = unfinishedCount;
	}
	public Integer getRunningCount() {
		return runningCount;
	}
	public void setRunningCount(Integer runningCount) {
		this.runningCount = runningCount;
	}
	public Integer getCompleteCount() {
		return completeCount;
	}
	public void setCompleteCount(Integer completeCount) {
		this.completeCount = completeCount;
	}
}
