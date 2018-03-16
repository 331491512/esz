package com.westangel.common.service;

import com.westangel.common.bean.PatientDiagnosisReq;

/**
 * 
* @ClassName: EhrInnerService 
* @Description: 电子病历系统 
* @author LIPENG
* @date 2016年3月1日 下午1:46:18 
*
 */
public interface DiagInnerService {
	public void createcreateDiagnosis(PatientDiagnosisReq req);
}
