package com.esuizhen.cloudservice.demoa.model;

import java.sql.Timestamp;

public class UpdateBean
{
	private Long id;
	
	private Timestamp createTime;
	
	private Long tableId;

	public UpdateBean()
	{
		
	}
	
	public UpdateBean(Timestamp createTime , Long tableId)
	{
		this.createTime=createTime;
		this.tableId=tableId;
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public Long getTableId()
	{
		return tableId;
	}

	public void setTableId(Long tableId)
	{
		this.tableId = tableId;
	}

	@Override
	public String toString()
	{
		return "UpdateBean [createTime=" + createTime + ", id=" + id + ", tableId=" + tableId + "]";
	}
	
	
}
