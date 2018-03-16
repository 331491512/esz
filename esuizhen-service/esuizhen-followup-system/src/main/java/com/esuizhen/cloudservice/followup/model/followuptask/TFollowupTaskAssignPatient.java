/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.followuptask;

/**
 * @author DaLoong
 * @date  2016-8-11 下午8:12:06
 */
public class TFollowupTaskAssignPatient {

	String followupAssignId;
	String followupTaskId;
	Long   patientId;
	/**
	 * @return the followupAssignId
	 */
	public String getFollowupAssignId() {
		return followupAssignId;
	}
	/**
	 * @param followupAssignId the followupAssignId to set
	 */
	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}
	/**
	 * @return the followupTaskId
	 */
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	/**
	 * @param followupTaskId the followupTaskId to set
	 */
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	
}
