package com.westangel.commonservice.sms.model.yixintong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
* @ClassName: Response 
* @Description: 易信通短信回执
* @author lichenghao
* @date 2016年8月26日 上午9:25:04
 */
@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD) 

public class Response {
    
    private String Result;
    
    private String SmsId;
    
    /**
     * 短信回复内容报告
     */
    @XmlElement(name="Mo")
    private Mo Mo;
    
    /**
     * 发送状态内容报告
     */
    @XmlElement(name="Report")
    private Report report;
    
    
    private String Balance;
    
    private String Filtrates;

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getSmsId() {
        return SmsId;
    }

    public void setSmsId(String smsId) {
        SmsId = smsId;
    }

    public Mo getMo() {
        return Mo;
    }

    public void setMo(Mo mo) {
        Mo = mo;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public String getFiltrates() {
        return Filtrates;
    }

    public void setFiltrates(String filtrates) {
        Filtrates = filtrates;
    }

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
}
