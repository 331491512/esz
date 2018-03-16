/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sms.util;<br/>  
 * <b>文件名：</b>AuthCode.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月18日下午4:33:31<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sms.util;

import java.util.Random;

/**验证码生成类
 * @ClassName: AuthCodeUtil
 * @Description:
 * @author lichenghao
 * @date 2015年12月18日 下午4:33:31
 */
public class AuthCodeUtil {
	
	/**
	 * 生成方法   验证码长度   是否有字母
	 * @author lichenghao
	 * @title :RndNum
	 * @Description:TODO
	 * @return String
	 * @date 2015年12月18日 下午4:50:06
	 */
	public static String RndNum(int VcodeNum,boolean hasStr) {
		String code = "0,1,2,3,4,5,6,7,8,9";
		if(hasStr)
		code += ",A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		code = code.toLowerCase();
		String[] codes = code.split(",");
		String authCode = "";// 由于字符串很短，就不用StringBuilder了
		int temp = -1;// 记录上次随机数值，尽量避免生产几个一样的随机数
		// 采用一个简单的算法以保证生成随机数的不同
		Random rand = new Random();
		for (int i = 1; i < VcodeNum + 1; i++) {
			if (temp != -1) {
				rand = new Random();
			}
			int t = rand.nextInt(codes.length);
			if (temp != -1 && temp == t) {
				return RndNum(VcodeNum,hasStr);
			}
			temp = t;
			authCode += codes[t];

		}
		return authCode;
	}
	
	public static void main(String[] args) {
		String code = AuthCodeUtil.RndNum(5, false);
		System.out.println(code);
	}
}
