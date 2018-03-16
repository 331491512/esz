package com.esuizhen.cloudservice.ehr.service.presentationmorbidity;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;

public interface PresentationMorbidityService {
	
	int insertPresentationMorbidity(PresentationMorbidityInfo presentationMorbidity);
	
	PresentationMorbidityInfo queryPresentationMorbidity(CommonReq req);
}
