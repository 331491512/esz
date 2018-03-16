package com.esuizhen.cloudservice.followup.model.statis;

/**
* @ClassName: TStatisMetadata 
* @Description: 统计分享元数据类型
* @author wang_hw
* @date 2016年1月15日 下午8:47:39
 */
public class TStatisMetadata
{
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 标识
	 */
	private String id;
	
	/**
	 * 输出名称
	 */
	private String displayName;
	
	/**
	 * 值类型
	 */
	private String valueType;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getValueType()
	{
		return valueType;
	}

	public void setValueType(String valueType)
	{
		this.valueType = valueType;
	}
	
	
	
}
