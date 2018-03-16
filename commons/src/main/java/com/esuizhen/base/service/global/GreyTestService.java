package com.esuizhen.base.service.global;

import java.util.List;

import com.esuizhen.base.model.GreyTestPatient;

public interface GreyTestService {
	
	public Integer getTwGreyTestControl();
	
	public List<GreyTestPatient> listTwGreyTestPatient();

}
