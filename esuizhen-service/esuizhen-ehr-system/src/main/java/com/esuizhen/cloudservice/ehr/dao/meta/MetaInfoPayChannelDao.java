package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoPayChannel;

public interface MetaInfoPayChannelDao{
	
	public List<TMetaInfoPayChannel> getMetaInfoPayChannelList(@Param("payChannelName")String payChannelName);
	
}
