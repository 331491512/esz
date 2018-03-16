package com.esuizhen.cloudservice.followup.service.followupresult;


public class FollowupResultHelper {

	public static String getDeathCause(Integer isInHospitalDeath,Integer isTumourDeath){
		StringBuffer deathCause = new StringBuffer("");
		if (isInHospitalDeath!=null) {
			if (1 == isInHospitalDeath) {
				deathCause.append("在院死亡");
			} else {
				deathCause.append("非在院死亡");
			}
		}
		if (isTumourDeath!=null) {
			if (1 == isTumourDeath) {
				deathCause.append("肿瘤死亡");
			} else {
				deathCause.append("非肿瘤死亡");
			}
		}
		return deathCause.toString();
	}
}
