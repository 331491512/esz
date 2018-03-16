/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.sms;<br/>  
 * <b>文件名：</b>SmsSendReportInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月26日上午8:58:39<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.sms;
/** 
* @ClassName: SmsSendReportInfo
* @Description: 
* @author lichenghao
* @date 2016年8月26日 上午8:58:39  
*/
public class SmsSendReportInfo  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String desc;
	/**
	 * 报告时间
	 */
	private String reportTime;
	
	
	/**
	 * 通道名称
	 */
	private String channelName;
	
	/**
	 * 更新状态
	 */
	private Integer flag = 0;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
