package com.westangel.common.bean;

public class UserDefinedMetaData {
	
	private int id;

	private String metaDataTable;
	
	private String mainKeyField;
	
	private String mainKeyCodeField;
	
	private String metaNameField;
	
	private String parentKeyField;
	
	private String mainKey;
	
	private String mainKeyCode;
	
	private String metaName;
	
	private String parentKey;
	
	private Long creator;
	
	private Integer useCount;
	
	private Integer flagKey;
	
	private String flagKeyField;
	
	private String queryCondition;

	public String getMetaDataTable() {
		return metaDataTable;
	}

	public void setMetaDataTable(String metaDataTable) {
		this.metaDataTable = metaDataTable;
	}

	public String getMainKeyField() {
		return mainKeyField;
	}

	public void setMainKeyField(String mainKeyField) {
		this.mainKeyField = mainKeyField;
	}

	public String getMetaNameField() {
		return metaNameField;
	}

	public void setMetaNameField(String metaNameField) {
		this.metaNameField = metaNameField;
	}

	public String getMainKey() {
		return mainKey;
	}

	public void setMainKey(String mainKey) {
		this.mainKey = mainKey;
	}

	public String getMetaName() {
		return metaName;
	}

	public void setMetaName(String metaName) {
		this.metaName = metaName;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Integer getUseCount() {
		return useCount;
	}

	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	public String getParentKeyField() {
		return parentKeyField;
	}

	public void setParentKeyField(String parentKeyField) {
		this.parentKeyField = parentKeyField;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getFlagKey() {
		return flagKey;
	}

	public void setFlagKey(Integer flagKey) {
		this.flagKey = flagKey;
	}

	public String getFlagKeyField() {
		return flagKeyField;
	}

	public void setFlagKeyField(String flagKeyField) {
		this.flagKeyField = flagKeyField;
	}

	public String getMainKeyCodeField() {
		return mainKeyCodeField;
	}

	public void setMainKeyCodeField(String mainKeyCodeField) {
		this.mainKeyCodeField = mainKeyCodeField;
	}

	public String getMainKeyCode() {
		return mainKeyCode;
	}

	public void setMainKeyCode(String mainKeyCode) {
		this.mainKeyCode = mainKeyCode;
	}

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}
}
