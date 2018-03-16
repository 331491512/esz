package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;

/**
* @ClassName: TCrfSymptom 
* @Description: 诊断配置信息
* @author wang_hw
* @date 2016年4月5日 下午8:21:50
 */
public class TCrfSymptom
{
	private String crfObserveId;

	private List<TCrfSymptomInfo> dataList;

	public String getCrfObserveId()
	{
		return crfObserveId;
	}

	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}

	public List<TCrfSymptomInfo> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<TCrfSymptomInfo> dataList)
	{
		this.dataList = dataList;
	}
	
	

}
