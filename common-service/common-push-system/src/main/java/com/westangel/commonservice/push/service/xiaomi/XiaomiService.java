package com.westangel.commonservice.push.service.xiaomi;

import java.util.List;

import com.westangel.commonservice.push.model.xiaomi.XiaomiChannelInfo;

public interface XiaomiService {
	public List<XiaomiChannelInfo> channelList();
	public void updateChannel(XiaomiChannelInfo channel);
}
