package com.esuizhen.cloudservice.ehr.model.meta;

import java.util.Date;

public class TMetaInfoIncisionHealing {
    private Integer incisionHealingId;

    private String incisionHealingGroup;

    private String incisionHealingLevel;
    
    private String incisionHealing;
    
    private String incisionHealingDesc;
    
    private String incisionHealingPy;

    private Date createTime;

    public Integer getIncisionHealingId() {
		return incisionHealingId;
	}

	public void setIncisionHealingId(Integer incisionHealingId) {
		this.incisionHealingId = incisionHealingId;
	}

	public String getIncisionHealingGroup() {
		return incisionHealingGroup;
	}

	public void setIncisionHealingGroup(String incisionHealingGroup) {
		this.incisionHealingGroup = incisionHealingGroup;
	}

	public String getIncisionHealingLevel() {
		return incisionHealingLevel;
	}

	public void setIncisionHealingLevel(String incisionHealingLevel) {
		this.incisionHealingLevel = incisionHealingLevel;
	}

	public String getIncisionHealingDesc() {
		return incisionHealingDesc;
	}

	public void setIncisionHealingDesc(String incisionHealingDesc) {
		this.incisionHealingDesc = incisionHealingDesc;
	}

	public String getIncisionHealingPy() {
		return incisionHealingPy;
	}

	public void setIncisionHealingPy(String incisionHealingPy) {
		this.incisionHealingPy = incisionHealingPy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIncisionHealing() {
		return incisionHealing;
	}

	public void setIncisionHealing(String incisionHealing) {
		this.incisionHealing = incisionHealing;
	}
    
}