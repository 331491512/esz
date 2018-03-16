/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util;<br/>  
 * <b>文件名：</b>TimerUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月12日上午11:51:21<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;
/** 
* @ClassName: TimerUtil
* @Description: 
* @author lichenghao
* @date 2017年4月12日 上午11:51:21  
*/
public class TimerUtil {
	private long startTime;
	private long times;
	
	public TimerUtil(){
		start();
	}
	
	public void start(){
		startTime = System.currentTimeMillis();
	}
	
	public long end(){
		times = System.currentTimeMillis()-startTime;
		return times;
	}
}
