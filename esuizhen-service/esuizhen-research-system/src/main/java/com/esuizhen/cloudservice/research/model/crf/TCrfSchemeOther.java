package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;


/**
* @ClassName: TCrfSchemeOhter 
* @Description: crf观察项方案（其他）
* @author wang_hw
* @date 2016年4月20日 上午11:37:53
 */
public class TCrfSchemeOther{
	
	/**
	 * 观察项ID。外键。
	 */
	private String crfObserveId;
	
	
	/**
	 * 方案列表
	 */
	private List<TCrfSchemeOtherInfo> dataList;


	public String getCrfObserveId()
	{
		return crfObserveId;
	}


	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}


	public List<TCrfSchemeOtherInfo> getDataList()
	{
		return dataList;
	}


	public void setDataList(List<TCrfSchemeOtherInfo> dataList)
	{
		this.dataList = dataList;
	}
	

	
}

