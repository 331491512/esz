package com.esuizhen.cloudservice.statistics.util;

import java.math.BigDecimal;

/**
 * 
 * @author Markey
 * @date 2011-4-14
 */
public class MathUtils {

	// 这个类不能实例化

	private MathUtils() {

	}
	
	/**
	 * * 提供精确的减法运算
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 * 
	 */

	public static String sub(String v1, String v2,int scale) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).setScale(scale,BigDecimal.ROUND_HALF_EVEN).toString();
	}
	
	/**
	 * 提供精确的加法运算
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 * 
	 */
	public static String add(String v1, String v2,int scale) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).setScale(scale,BigDecimal.ROUND_HALF_EVEN).toString();
	}
	
	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 * 定精度，以后的数字四舍五入
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位
	 * @return 两个参数的商
	 * 
	 */

	public static String div(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();

	}
	
	/**
	 * 
	 * Description:两数相乘
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String mul(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).setScale(2).toString();
	}
	
	/**
	 * 
	 * Description:两数相比较
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static int compareTo(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.compareTo(b2);
	}
}
