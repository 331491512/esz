package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;


public class TCrfSymptomTcm{
	
	/**
	 * crfObserveId
	 */
	private String crfObserveId;
	
	
	private List<TCrfSymptomTcmInfo> dataList;


	public String getCrfObserveId()
	{
		return crfObserveId;
	}


	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}


	public List<TCrfSymptomTcmInfo> getDataList()
	{
		return dataList;
	}


	public void setDataList(List<TCrfSymptomTcmInfo> dataList)
	{
		this.dataList = dataList;
	}
	
	

}

