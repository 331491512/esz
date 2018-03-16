package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoFrequency {
    private Integer frequencyId;

    private String metaDataType;

    private String frequencyName;

    public Integer getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Integer frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getMetaDataType() {
		return metaDataType;
	}

	public void setMetaDataType(String metaDataType) {
		this.metaDataType = metaDataType;
	}

	public String getFrequencyName() {
        return frequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        this.frequencyName = frequencyName;
    }
}