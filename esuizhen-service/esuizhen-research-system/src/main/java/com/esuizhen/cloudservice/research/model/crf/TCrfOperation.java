package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;


public class TCrfOperation{
	
	/**
	 * 观察项ID
	 */
	private String crfObserveId;
	
	/**
	 * 手术明细列表
	 */
	private List<TCrfOperationInfo> dataList;

	public String getCrfObserveId()
	{
		return crfObserveId;
	}

	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}

	public List<TCrfOperationInfo> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<TCrfOperationInfo> dataList)
	{
		this.dataList = dataList;
	}
	
	
}

