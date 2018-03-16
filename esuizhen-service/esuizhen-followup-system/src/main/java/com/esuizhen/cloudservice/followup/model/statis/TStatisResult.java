package com.esuizhen.cloudservice.followup.model.statis;

import java.util.List;

/**
* @ClassName: TStatisResult 
* @Description: 统计结果数据
* @author wang_hw
* @date 2016年1月15日 下午8:34:34
 */
public class TStatisResult
{
	/**
	 * 数据类型
	 */
	private String dataType;
	
	/**
	 * 统计标题
	 */
	private String title;
	
	/**
	 * 总数
	 */
	private Integer totalSamples ;
	/**
	 * 元数据列表
	 */
	private List<TStatisMetadata> metaList;
	
	/**
	 * 数据列表
	 */
	private List<List<TStatisData>> dataList;

	public String getDataType()
	{
		return dataType;
	}

	public void setDataType(String dataType)
	{
		this.dataType = dataType;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public List<TStatisMetadata> getMetaList()
	{
		return metaList;
	}

	public void setMetaList(List<TStatisMetadata> metaList)
	{
		this.metaList = metaList;
	}

	public List<List<TStatisData>> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<List<TStatisData>> dataList)
	{
		this.dataList = dataList;
	}

	public Integer getTotalSamples()
	{
		return totalSamples;
	}

	public void setTotalSamples(Integer totalSamples)
	{
		this.totalSamples = totalSamples;
	}
	
	
}
