package com.esuizhen.cloudservice.statistics.bean;

import java.util.List;
import java.util.Map;

public class TFollowupWayStatisticInfo {
	
	/**
	 * 随访方式-表头
	 */
	private List<TStatisticTitleInfo> followupWayTitles;
	
	/**
	 * 随访方式-结果值
	 */
	private List<Map<String, Object>> followupWayValues;
	
	
	/**
	 * 门诊/住院复诊-表头
	 */
	private List<TStatisticTitleInfo> outPatientFlagTitles;
	
	/**
	 * 门诊/住院复诊-结果值
	 */
	private List<Map<String, Object>> outPatientFlagValues;
	
	
	/**
	 * 随访方式合计-表头
	 */
	private List<TStatisticTitleInfo> followupWayTotalTitles;
	
	/**
	 * 门诊/住院复诊-结果值
	 */
	private List<Map<String, Object>> followupWayTotalValues;

	public List<TStatisticTitleInfo> getFollowupWayTitles() {
		return followupWayTitles;
	}

	public void setFollowupWayTitles(List<TStatisticTitleInfo> followupWayTitles) {
		this.followupWayTitles = followupWayTitles;
	}

	public List<Map<String, Object>> getFollowupWayValues() {
		return followupWayValues;
	}

	public void setFollowupWayValues(List<Map<String, Object>> followupWayValues) {
		this.followupWayValues = followupWayValues;
	}

	public List<TStatisticTitleInfo> getOutPatientFlagTitles() {
		return outPatientFlagTitles;
	}

	public void setOutPatientFlagTitles(
			List<TStatisticTitleInfo> outPatientFlagTitles) {
		this.outPatientFlagTitles = outPatientFlagTitles;
	}

	public List<Map<String, Object>> getOutPatientFlagValues() {
		return outPatientFlagValues;
	}

	public void setOutPatientFlagValues(
			List<Map<String, Object>> outPatientFlagValues) {
		this.outPatientFlagValues = outPatientFlagValues;
	}

	public List<TStatisticTitleInfo> getFollowupWayTotalTitles() {
		return followupWayTotalTitles;
	}

	public void setFollowupWayTotalTitles(
			List<TStatisticTitleInfo> followupWayTotalTitles) {
		this.followupWayTotalTitles = followupWayTotalTitles;
	}

	public List<Map<String, Object>> getFollowupWayTotalValues() {
		return followupWayTotalValues;
	}

	public void setFollowupWayTotalValues(
			List<Map<String, Object>> followupWayTotalValues) {
		this.followupWayTotalValues = followupWayTotalValues;
	}
}
