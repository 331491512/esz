package com.esuizhen.cloudservice.user.followuppatient.util;

public enum FileSuffixEnum {
	EXCEL(".xls"),ZIP(".zip"),CSV(".csv");
	
	private final String value;

	private FileSuffixEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
