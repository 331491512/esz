/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.common;<br/>  
 * <b>文件名：</b>GroupWay.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年9月26日下午3:16:41<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.common;
/** 
* @ClassName: GroupWay
* @Description: 
* @author lichenghao
* @date 2016年9月26日 下午3:16:41  
*/
public class PatientGroupConstant {
	//全部
	public static final Integer GROUP_WAY_ALL_GROUP=0;
	//按病种分组
	public static final Integer GROUP_WAY_DISEASE_GROUP = 1;
	//按医生关注分组
	public static final Integer GROUP_WAY_DOCTORFOCUS_GROUP = 8;
	//按MDT分组
	public static final Integer GROUP_WAY_MDT_GROUP = 9;
	//按自定义分组
	public static final Integer GROUP_WAY_ZDY_GROUP = 10;
	//按住院门诊
	public static final Integer GROUP_WAY_INHOSPITAL_GROUP=11;
	//默认分组
	public static final Integer GROUP_WAY_DEFAULT_GROUP=111;
	
	//特殊分组
	public static final Integer GROUP_WAY_ZDY_INHOSPITAL_GROUP=1011;
	
	//关注
	//取消关注
	public static final Integer FOCUS_OFF = 0;
	//关注
	public static final Integer FOCUS_ON = 1;
	
}
