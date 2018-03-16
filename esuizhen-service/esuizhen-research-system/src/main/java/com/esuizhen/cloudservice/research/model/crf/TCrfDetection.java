package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;


public class TCrfDetection
{
	private String crfObserveId;
	
	private List<TCrfDetectionDetail> dataList;

	public String getCrfObserveId()
	{
		return crfObserveId;
	}

	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}

	public List<TCrfDetectionDetail> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<TCrfDetectionDetail> dataList)
	{
		this.dataList = dataList;
	}
	
	
}

