package com.westangel.commonservice.sms.model.yixintong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.westangel.common.bean.sms.SmsSendReportInfo;

/** 
 * @ClassName: Item 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yzq 
 * @date Jul 17, 2015 4:43:07 PM
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class Item {
    
    @XmlAttribute  
    private String id;
    @XmlAttribute
    private String content;
    @XmlAttribute(name="from_mobile")
    private String from_mobile;
    @XmlAttribute(name="to_port")
    private String to_port;
    @XmlAttribute(name="rec_time")
    private String rec_time;
    
    //获取短信发送状态
    @XmlAttribute(name="to_mobile")
    private String to_mobile;
    @XmlAttribute(name="desc")
    private String desc;
    @XmlAttribute(name="reportTime")
    private String reportTime;
    @XmlAttribute(name="status")
    private Integer status;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFrom_mobile() {
		return from_mobile;
	}
	public void setFrom_mobile(String from_mobile) {
		this.from_mobile = from_mobile;
	}
	public String getTo_port() {
		return to_port;
	}
	public void setTo_port(String to_port) {
		this.to_port = to_port;
	}
	public String getRec_time() {
		return rec_time;
	}
	public void setRec_time(String rec_time) {
		this.rec_time = rec_time;
	}
	
	public String getTo_mobile() {
		return to_mobile;
	}
	public void setTo_mobile(String to_mobile) {
		this.to_mobile = to_mobile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :loadingSmsSendReportInfo
	 * @Description:生成状态报告info
	 * @return SmsSendReportInfo
	 * @date 2016年8月26日 上午9:13:00
	 */
	public SmsSendReportInfo loadingSmsSendReportInfo(String channelName){
		SmsSendReportInfo info = new SmsSendReportInfo();
		info.setMobile(this.to_mobile);
		info.setDesc(this.desc);
		info.setReportTime(this.reportTime);
		info.setStatus(this.status);
		info.setChannelName(channelName);
		return info;
	}
}
