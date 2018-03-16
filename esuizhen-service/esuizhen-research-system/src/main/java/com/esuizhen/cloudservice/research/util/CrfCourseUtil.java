package com.esuizhen.cloudservice.research.util;

/**
 * <p>Title: CrfCourseUtil</p>
 * <p>Description: 随访周期工具类</p>
 * @author YYCHEN
 * @date 2016年4月7日 下午2:01:46
 */
public final class CrfCourseUtil {
	/**
	 * <p>Title: unitConversion</p>
	 * <p>Description: 随访频率单位转换</p>
	 * @date 2016年4月7日 下午2:04:03
	 * @param unit
	 * @param num
	 * @return
	 */
	public final static String unitConversion(String unit, Integer num){
		if ("d".equalsIgnoreCase(unit)) {
			return "第" + num + "天";
		}
		if ("w".equalsIgnoreCase(unit)) {
			return "第" + num + "周";
		}
		if ("m".equalsIgnoreCase(unit)) {
			return "第" + num + "个月";
		}
		if ("y".equalsIgnoreCase(unit)) {
			return "第" + num + "年";
		}
		return "" + num;
	}
	
	/**
	 * <p>Title: unitConversionDaies</p>
	 * <p>Description: 通过频率单位和频率获取总天数</p>
	 * @date 2016年4月7日 下午4:03:02
	 * @param unit
	 * @return
	 */
	public final static Integer unitConversionDaies(String unit){
		Integer day = 0;
		if ("d".equalsIgnoreCase(unit)) {
			day = 1;
		}
		if ("w".equalsIgnoreCase(unit)) {
			day = 7;
		}
		if ("m".equalsIgnoreCase(unit)) {
			day = 30;
		}
		if ("y".equalsIgnoreCase(unit)) {
			day = 365;
		}
		return day;
	}
}
