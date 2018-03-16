package com.esuizhen.cloudservice.followup.model.statis;

/**
* @ClassName: TSURMData 
* @Description: 统计数据
* @author wang_hw
* @date 2016年1月15日 下午8:30:44
 */
public class TStatisData
{
	/**
	 * 唯一标识
	 */
	private String id;
	
	/**
	 * 值
	 */
	private String value;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	
	public TStatisData(String id,String value){
		this.id=id;
		this.value = value;
	}
	public TStatisData(){}
	
}
