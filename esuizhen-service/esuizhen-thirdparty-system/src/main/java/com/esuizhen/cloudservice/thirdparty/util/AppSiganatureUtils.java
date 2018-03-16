/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.util;<br/>  
 * <b>文件名：</b>AppSiganatureUtils.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月14日下午4:27:21<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.thirdparty.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import com.esuizhen.cloudservice.thirdparty.bean.yiyao.LoginReq;
import com.esuizhen.cloudservice.thirdparty.bean.yiyao.LoginResp;
import com.westangel.common.util.JsonUtil;

/** 
* @ClassName: AppSiganatureUtils
* @Description: 
* @author lichenghao
* @date 2016年7月14日 下午4:27:21  
*/
public class AppSiganatureUtils {
	//test
	//商户编号
	//private static String appId = "test001";
	//商户密码
	//private static String appSecret ="2770bcb4-7e35-498d-b83e-fe2d5377cf74";
	
	//正式
	//商户编号
	private static String appId = "ESUIZHEN";
	//商户密码
	private static String appSecret ="2e2a219e-cfe6-4611-b1b0-db4b434c8e20";
	
	//生成签名
	public static String getSiganature(String dataJson,String timestamp){
		StringBuffer str = new StringBuffer();
		str.append(appId)
		.append("@$@").append(appSecret)
		.append("@$@").append(dataJson)
		.append("@$@").append(timestamp)
		.append("@$@").append(appSecret)
		.append("@$@").append(appId);
		return DigestUtils.sha512Hex(str.toString());
//		return encrypt(str.toString(),"SHA-512");
	}
	
	private static String encrypt(String strSrc, String encName) {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt=null;
		try {
			bt = strSrc.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
        try {
            if (encName == null || encName.equals("")) {
                encName = "SHA-256";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }
	
	private static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
	
	//生成提交数据
	public static LoginResp initLoginResp(LoginReq req){
		LoginResp resp = new LoginResp();
		resp.setData(JsonUtil.toJson(req));
		resp.setTimestamp(System.currentTimeMillis()+"");
		resp.setAppId(appId);
		resp.setSiganature(getSiganature(resp.getData(), resp.getTimestamp()));
		return resp;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String json = "{\"targetUrl\":\"../partner/index.html#/redirect\",\"mobile\":\"13641855160\",\"name\":\"易加醫測試賬號1\",\"sex\":\"0\",\"birthday\":\"1982-01-22\",\"idcard\":\"310228198201222222\",\"socialSecurityCard\":\"1234567\",\"logoPath\":\"http: //xxxxx.jpg\"}";
		String timestamp = "1468980424840";
		String siganature = "f9543b7cfd5504501edf3e2f0b52d6d3ade0bc95bc7bd06663dba64fe6ab1914432434018693b0c8ddd41cc9c83cf9f77908ac4d385bd9e0b03c3bef15c891fc";
		System.out.println(getSiganature(json, timestamp));
		String s = new String(json.getBytes("ISO8859-1"), "UTF-8");
	}
}
