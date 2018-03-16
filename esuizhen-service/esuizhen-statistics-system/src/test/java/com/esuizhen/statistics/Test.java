/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.statistics;<br/>  
 * <b>文件名：</b>Test.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月21日上午11:27:23<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.statistics;
/** 
* @ClassName: Test
* @Description: 
* @author lichenghao
* @date 2016年4月21日 上午11:27:23  
*/
public class Test {
	public static void main(String[] args) {
//		String str = "CASE WHEN survivalMonth IS NOT NULL THEN (CASE WHEN survivalMonth>=3 THEN 1 ELSE 0 END) ELSE (CASE WHEN followupResultValue=4 THEN (CASE WHEN followupMonth>=3 THEN 1 ELSE 0 END) ELSE(CASE WHEN followupMonth>=3 THEN (CASE WHEN type=2 THEN (CASE WHEN followupMonth<6 THEN -1 ELSE 1 END) ELSE 1 END) END) END) END,";
//		for(int i =1;i<=20;i++){
//			System.out.println(str.replace("6", (i+1)*3+"").replace("3", i*3+""));
//		}
//		for(int i =6;i<=10;i++){
//			System.out.println(str.replace("6", (i+1)*12+"").replace("3", i*12+""));
//		}
//		String str = "SUM(CASE survival3 WHEN  1 THEN 1 ELSE 0 END) su3,SUM(CASE survival3 WHEN  -1 THEN 1 ELSE 0 END) los3,SUM(CASE survival3 WHEN 0 THEN 1 WHEN 1 THEN 1 ELSE 0 END) effective3,SUM(CASE WHEN survival3 IS NOT NULL THEN 1 ELSE 0 END) total3,";
//		for(int i =1;i<=20;i++){
//			System.out.println(str.replace("3", i*3+""));
//		}
//		for(int i =6;i<=10;i++){
//			System.out.println(str.replace("3", i*12+""));
//		}
		double a = 0/2;
	}
}
