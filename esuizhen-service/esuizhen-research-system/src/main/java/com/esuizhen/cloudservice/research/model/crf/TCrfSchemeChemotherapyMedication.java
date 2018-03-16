package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;

/**
* @ClassName: TCrfSchemeChemotherapyMedication 
* @Description:CRF化疗/靶向用药方案信息实体
* @author wang_hw
* @date 2016年4月14日 下午6:07:04
 */
public class TCrfSchemeChemotherapyMedication{
	
	/**
	 * 观察项ID
	 */
	private String crfObserveId;
	
	/**
	 * 方案列表
	 */
	private List<TCrfScheme> dataList;


	public String getCrfObserveId()
	{
		return crfObserveId;
	}


	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}


	public List<TCrfScheme> getDataList()
	{
		return dataList;
	}


	public void setDataList(List<TCrfScheme> dataList)
	{
		this.dataList = dataList;
	}
	
	

}

