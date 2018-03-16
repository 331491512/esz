package com.esuizhen.cloudservice.ehr.model.detection;

import java.util.List;

/** 
 * @ClassName: DetecTionItem.java
 * @Description: 
 * @author fanpanwei	
 * @date   2017年4月24日
 */
public class DetectionItemDetail {
	
	private String detectionTypeName;
	private Integer detectionItemId;
	private String detectionItemName;
	private String detectionItemEnglishName;
	private String refrenceRangeMax;
	private String refrenceRangeMin;
	private String refrenceRange;
	private String unit;
	private List<DetectionResult> detectionResults;
	public String getDetectionTypeName() {
		return detectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}
	public Integer getDetectionItemId() {
		return detectionItemId;
	}
	public void setDetectionItemId(Integer detectionItemId) {
		this.detectionItemId = detectionItemId;
	}
	public String getDetectionItemName() {
		return detectionItemName;
	}
	public void setDetectionItemName(String detectionItemName) {
		this.detectionItemName = detectionItemName;
	}
	public String getDetectionItemEnglishName() {
		return detectionItemEnglishName;
	}
	public void setDetectionItemEnglishName(String detectionItemEnglishName) {
		this.detectionItemEnglishName = detectionItemEnglishName;
	}
	public String getRefrenceRangeMax() {
		return refrenceRangeMax;
	}
	public void setRefrenceRangeMax(String refrenceRangeMax) {
		this.refrenceRangeMax = refrenceRangeMax;
	}
	public String getRefrenceRangeMin() {
		return refrenceRangeMin;
	}
	public void setRefrenceRangeMin(String refrenceRangeMin) {
		this.refrenceRangeMin = refrenceRangeMin;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public List<DetectionResult> getDetectionResults() {
		return detectionResults;
	}
	public void setDetectionResults(List<DetectionResult> detectionResults) {
		this.detectionResults = detectionResults;
	}
	public String getRefrenceRange() {
		return refrenceRange;
	}
	public void setRefrenceRange(String refrenceRange) {
		this.refrenceRange = refrenceRange;
	}
}
