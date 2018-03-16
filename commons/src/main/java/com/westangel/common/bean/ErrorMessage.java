package com.westangel.common.bean;

/**
 * 错误代码枚举类
 * @author wang_hw
 *
 */
public enum ErrorMessage {
	SUCCESS(0, "success"),
	SUCCESSSMSCAPTCHASEND(0, "sms.captcha.send.success"),
	SUCCESSSMSCAPTCHACHECK(0, "sms.captcha.check.success"),
	ERRORSMSCAPTCHACHECK(0, "sms.captcha.send.error"),
	SUCCESSSMSMSGSEND(0, "sms.msg.send.success"),
	SUCCESSSMSTEMPLATESEND(0, "sms.template.send.success"),
	SUCCESSCALL(0, "call.success"),
	E1300(1300, "error.e1300"),
	E1400(1400, "error.e1400"),
	E1401(1401, "error.e1401"),
	E1402(1402, "error.e1402"),
	E1403(1403, "error.e1403"),
	E1404(1404, "error.e1404"),
	E1405(1405, "error.e1405"),
	E1406(1406, "error.e1406"),
	E1408(1408, "error.e1408"),
	E1409(1409, "error.e1409"),
	E140901(140901, "error.e140901"),
	E140902(140902, "error.e140902"),
	E140903(140903, "error.e140903"),
	E140904(140904, "error.e140904"),
	E1410(1415, "error.e1410"),
	E1415(1415, "error.e1415"),
	E1417(1417, "error.e1417"),
	E1418(1418, "error.e1418"),
	E1419(1419, "error.e1419"),
	E1420(1420, "error.e1420"),
	E1421(1421, "error.e1421"),
	E1422(1422, "error.e1422"),
	E1423(1423, "error.e1423"),
	E1424(1424, "error.e1424"),
	E1425(1425, "error.e1425"),
	E1500(1500, "error.e1500"),
	//同一设备注册数量超过三个
	E1501(1501, "error.e1501"),
	//同一个设备24小时内只能注册一个账号
	E1502(1502, "error.e1502"),
	//用户名正确，密码错误
	E1503(1503,"error.e1503"),
	//患者信息不存在
	E1504(1504,"error.e1504"),
	//医生信息不存在
	E1505(1505,"error.e1505"),
	E1506(1506,"error.e1506"),
	E1550(1550,"call remote dubbo service failure"),
	//验证码
	E1600(1600,"error.e1600"),
	E1601(1601,"error.e1601"),
	E1602(1602,"error.e1602"),
	//短信
	E1603(1603,"error.e1603"),
	E1604(1604,"error.e1604"),
	E1605(1605,"error.e1605"),
	//拨打电话
	E1606(1606,"error.e1606"),
	//专题已结束
	E1700(1700, "error.e1700"),
	E1701(1701, "error.e1701"),
	E1702(1702, "error.e1702"),
	E1703(1703, "error.e1703");
	/**
	 * 错误代码
	 */
	public Integer code;

	/**
	 * 提示信息
	 */
	public String info;
	

	ErrorMessage(Integer code, String info) 
	{
		this.code = code;
		this.info = info;

	}

	public Integer getCode() 
	{
		return code;
	}

	public void setCode(Integer code) 
	{
		this.code = code;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info) 
	{
		this.info = info;
	}
	
	static public ErrorMessage getInfoViaCode(Integer code)
	{
		for (ErrorMessage msg:values()){
			if (msg.code == code) {
				return msg;
			}
		}
		return null;
	}	
}
