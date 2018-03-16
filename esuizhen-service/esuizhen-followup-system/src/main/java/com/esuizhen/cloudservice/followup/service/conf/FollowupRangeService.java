package com.esuizhen.cloudservice.followup.service.conf;

import java.util.List;

import com.esuizhen.cloudservice.followup.bean.TFollowupConfigDiseaseType;
import com.esuizhen.cloudservice.followup.bean.TFollowupRangeIcdCodeText;

public interface FollowupRangeService {
	
	public void saveFollowupConfigDiseaseType(List<TFollowupConfigDiseaseType> followupConfigDiseaseTypeList);
	
	public List<TFollowupConfigDiseaseType> getFollowupConfigDiseaseTypeList();

	public List<TFollowupRangeIcdCodeText> getFollowupConfigIcdCodeList();
	
	public void saveFollowupConfigIcdCode(List<TFollowupRangeIcdCodeText> followupRangeIcdCodeTextList);
	
}
