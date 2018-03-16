package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;

/**
* @ClassName: TCrfPhysicalSigns 
* @Description: 体征信息实体
* @author wang_hw
* @date 2016年4月6日 上午10:59:41
 */
public class TCrfPhysicalSigns{
	
	private String crfObserveId;
	
	private List<TCrfPhysicalSignsInfo> physicalSignsList;

	public String getCrfObserveId()
	{
		return crfObserveId;
	}

	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}

	public List<TCrfPhysicalSignsInfo> getPhysicalSignsList()
	{
		return physicalSignsList;
	}

	public void setPhysicalSignsList(List<TCrfPhysicalSignsInfo> physicalSignsList)
	{
		this.physicalSignsList = physicalSignsList;
	}
	
	
}

