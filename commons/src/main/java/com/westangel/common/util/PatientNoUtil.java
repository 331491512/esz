/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util;<br/>  
 * <b>文件名：</b>PatientNoUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午11:56:28<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;

import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: PatientNoUtil
* @Description: 
* @author lichenghao
* @date 2016年8月8日 上午11:56:28  
*/
public class PatientNoUtil {
	
	public static List<String> loadPatientNo(List<String> patientNos,Integer num){
		if(patientNos==null) return null;
		List<String> pNos=new ArrayList<String>();
		for(int i = 0;i<patientNos.size();i++){
			pNos.add(loadPatientNo(patientNos.get(i), num));
		}
		return pNos;
	}
	
	public static String loadPatientNo(String patientNo,Integer num){
		if(patientNo.length()<num){
			String str_m = patientNo;
			String str = initStringNumber(num);
			patientNo=str.substring(0, num-str_m.length())+str_m;
		}
		return patientNo;
	}
	
	//加载0的数字字符
	public static String initStringNumber(int num){
		int i = 0;
		String format = "%0"+num+"d";
		String str = String.format(format, i);
		return str;
	}
}
