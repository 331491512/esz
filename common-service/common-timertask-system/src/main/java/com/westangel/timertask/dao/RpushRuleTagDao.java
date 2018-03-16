package com.westangel.timertask.dao;

import com.westangel.timertask.model.RpushRuleTag;

public interface RpushRuleTagDao{
	
	public void insertRpushRuleTag(RpushRuleTag rpushRuleTag);
	
	public void updateRpushRuleTag(RpushRuleTag rpushRuleTag);
	
	public void deleteRpushRuleTag(Long rpushRuleTagId);
	
	public RpushRuleTag queryRpushRuleTag(Long rpushRuleTagId);
	
}
