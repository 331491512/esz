/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TPatientSpreadInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午7:01:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.List;

/** 
* @ClassName: TPatientSpreadInfo
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午7:01:58  
*/
public class TPatientSpreadInfo {
	//患者性别年龄信息分布
	private TSexAgeSpread sexAge;
	
	//地区分布
	private List<TProvinceSpreadItem> province;
	
	//病种
	private TDiseaseSpread disease;
	
	//联系方式
	private TContactWaySpread contactWay;
	
	//随访
	private TFollowupSpread followup;
	
	//随访结果
	private TFollowupResultSpread followupResult;

	public TSexAgeSpread getSexAge() {
		return sexAge;
	}

	public void setSexAge(TSexAgeSpread sexAge) {
		this.sexAge = sexAge;
	}

	public List<TProvinceSpreadItem> getProvince() {
		return province;
	}

	public void setProvince(List<TProvinceSpreadItem> province) {
		this.province = province;
	}

	public TDiseaseSpread getDisease() {
		return disease;
	}

	public void setDisease(TDiseaseSpread disease) {
		this.disease = disease;
	}

	public TContactWaySpread getContactWay() {
		return contactWay;
	}

	public void setContactWay(TContactWaySpread contactWay) {
		this.contactWay = contactWay;
	}

	public TFollowupSpread getFollowup() {
		return followup;
	}

	public void setFollowup(TFollowupSpread followup) {
		this.followup = followup;
	}

	public TFollowupResultSpread getFollowupResult() {
		return followupResult;
	}

	public void setFollowupResult(TFollowupResultSpread followupResult) {
		this.followupResult = followupResult;
	}
}
