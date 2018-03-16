/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util;<br/>  
 * <b>文件名：</b>SurvivalUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月28日下午6:01:09<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;

import java.text.ParseException;
import java.util.Date;

/** 
* @ClassName: SurvivalUtil
* @Description: 
* @author lichenghao
* @date 2016年10月28日 下午6:01:09  
*/
public class SurvivalUtil {
	
	public static Date calculateDeathDate(Date deathDate, Date latestFollowupTime) {
		try {
			Date now = new Date();
			if (deathDate!=null) {
				return deathDate;
			}

			int day = DateUtil.daysBetween(latestFollowupTime, now);
			day = day / 2;
			return DateUtil.getOffsetDate(latestFollowupTime, day);

		} catch (ParseException e) {
			LogUtil.log.error("【死亡时间计算错误】" + e.getMessage());
		}
		return null;
	}
	
	public static float calculateLiveMonth(int liveDay) {
		try {
			return (float) ((liveDay / 365.25) * 12);
		} catch (Exception e) {
			LogUtil.log.error("calculate liveMonth error : " + e.getMessage());
		}
		return 0l;
	}
	
	public static void main(String[] args) {
		int liveDay = 46;
		float liveMonth = (float) ((liveDay / 365.25) * 12);
		System.out.println(liveMonth);
	}
}
