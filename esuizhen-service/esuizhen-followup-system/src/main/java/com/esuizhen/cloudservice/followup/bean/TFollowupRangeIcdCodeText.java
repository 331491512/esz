package com.esuizhen.cloudservice.followup.bean;

public class TFollowupRangeIcdCodeText {

	private Integer id;
	
	private String diseaseCodeStart;
	
	private String diseaseCodeEnd;
	
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiseaseCodeStart() {
		return diseaseCodeStart;
	}

	public void setDiseaseCodeStart(String diseaseCodeStart) {
		this.diseaseCodeStart = diseaseCodeStart;
	}

	public String getDiseaseCodeEnd() {
		return diseaseCodeEnd;
	}

	public void setDiseaseCodeEnd(String diseaseCodeEnd) {
		this.diseaseCodeEnd = diseaseCodeEnd;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
