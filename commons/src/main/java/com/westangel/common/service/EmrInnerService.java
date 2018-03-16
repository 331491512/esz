package com.westangel.common.service;

import java.util.List;

import com.westangel.common.bean.ehr.TSyncDiagnosisInfo;

/**
 * 
* @ClassName: EhrInnerService 
* @Description: 电子病历系统 
* @author LIPENG
* @date 2016年3月1日 下午1:46:18 
*
 */
public interface EmrInnerService {
	/**
	 * 
	* @Title: syncDiagnosis 
	* @Description: 同步疾病信息 
	* @param @param diagonsis    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void syncDiagnosis(TSyncDiagnosisInfo diagonsis);
	/**
	 * 
	* @Title: getDiseaseTypeIdViaDiagnosis 
	* @Description: 根据诊断反查疾病typeid 
	* @param @param diagnosis
	* @param @return    设定文件 
	* @return List<Integer>    返回类型 
	* @throws
	 */
	public List<Integer> getDiseaseTypeIdViaDiagnosis(String diagnosis);
}
