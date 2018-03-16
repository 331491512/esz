package com.esuizhen.cloudservice.ehr.util;

public enum FileSuffixEnum {
	EXCEL(".xls"),ZIP(".zip");
	
	private final String value;

	private FileSuffixEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
