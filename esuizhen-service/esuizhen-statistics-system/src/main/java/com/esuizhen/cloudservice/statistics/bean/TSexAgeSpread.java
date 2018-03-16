/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TSexAgeSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午7:02:15<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: TSexAgeSpread
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午7:02:15  
*/
public class TSexAgeSpread {
	//男性人数
	private Integer male;
	//女性人数
	private Integer female;
	//未知性别人数
	private Integer unknownSex;
	//20岁以下
	private Integer age20;
	//20-40岁
	private Integer age40;
	//40-60岁
	private Integer age60;
	//60-80岁
	private Integer age80;
	//80岁以上
	private Integer ageMore;
	//未知年龄
	private Integer unknownAge;
	public Integer getMale() {
		return male;
	}
	public void setMale(Integer male) {
		this.male = male;
	}
	public Integer getFemale() {
		return female;
	}
	public void setFemale(Integer female) {
		this.female = female;
	}
	public Integer getUnknownSex() {
		return unknownSex;
	}
	public void setUnknownSex(Integer unknownSex) {
		this.unknownSex = unknownSex;
	}
	public Integer getAge20() {
		return age20;
	}
	public void setAge20(Integer age20) {
		this.age20 = age20;
	}
	public Integer getAge40() {
		return age40;
	}
	public void setAge40(Integer age40) {
		this.age40 = age40;
	}
	public Integer getAge60() {
		return age60;
	}
	public void setAge60(Integer age60) {
		this.age60 = age60;
	}
	public Integer getAge80() {
		return age80;
	}
	public void setAge80(Integer age80) {
		this.age80 = age80;
	}
	public Integer getAgeMore() {
		return ageMore;
	}
	public void setAgeMore(Integer ageMore) {
		this.ageMore = ageMore;
	}
	public Integer getUnknownAge() {
		return unknownAge;
	}
	public void setUnknownAge(Integer unknownAge) {
		this.unknownAge = unknownAge;
	}
	
}
