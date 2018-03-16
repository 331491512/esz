package com.westangel.commonservice.push.model;

public class EventInfo{
	
	private String eventTip ;
	
	private Integer eventType;

	private String eventInfo;

	public String getEventTip()
	{
		return eventTip;
	}

	public void setEventTip(String eventTip)
	{
		this.eventTip = eventTip;
	}

	public Integer getEventType()
	{
		return eventType;
	}

	public void setEventType(Integer eventType)
	{
		this.eventType = eventType;
	}

	public String getEventInfo()
	{
		return eventInfo;
	}

	public void setEventInfo(String eventInfo)
	{
		this.eventInfo = eventInfo;
	}

	@Override
	public String toString()
	{
		return "EventInfo [eventTip=" + eventTip + ", eventType=" + eventType + ", eventInfo=" + eventInfo + "]";
	}
	
	
}

