/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>PatientnoListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日上午11;             //33;             //51<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName;             // PatientBaseDataStatisticsReq
* @Description;             // 
* @author fanpanwei
* @date 2017年03月30日 上午11;             //33;             //51  
*/
public class PatientBaseDataStatistics {
	
	private Integer patientTotal=0;   //患者总数
	private Integer inhospitalTotal=0;          //院内患者人数
	private Integer notInhospitalTotal=0;          //非院内患者人数
	private Integer newAddTotal=0;             //新增患者
	private Integer activedTotal=0;             //激活患者
	private Integer waitActivedTotal=0;             //待激活患者
	private Integer validFollowupTotal=0;             //有效随访总数
	private Integer stabileTotal=0;             // 稳定
	private Integer recidivationTotal=0;             //复发
	private Integer metastaticTotal=0;             //转移
	private Integer deathTotal=0;             //死亡
	public Integer getPatientTotal() {
		return patientTotal;
	}
	public void setPatientTotal(Integer patientTotal) {
		this.patientTotal = patientTotal;
	}
	public Integer getInhospitalTotal() {
		return inhospitalTotal;
	}
	public void setInhospitalTotal(Integer inhospitalTotal) {
		this.inhospitalTotal = inhospitalTotal;
	}
	public Integer getNotInhospitalTotal() {
		return notInhospitalTotal;
	}
	public void setNotInhospitalTotal(Integer notInhospitalTotal) {
		this.notInhospitalTotal = notInhospitalTotal;
	}
	public Integer getNewAddTotal() {
		return newAddTotal;
	}
	public void setNewAddTotal(Integer newAddTotal) {
		this.newAddTotal = newAddTotal;
	}
	public Integer getActivedTotal() {
		return activedTotal;
	}
	public void setActivedTotal(Integer activedTotal) {
		this.activedTotal = activedTotal;
	}
	public Integer getWaitActivedTotal() {
		return waitActivedTotal;
	}
	public void setWaitActivedTotal(Integer waitActivedTotal) {
		this.waitActivedTotal = waitActivedTotal;
	}
	public Integer getValidFollowupTotal() {
		return validFollowupTotal;
	}
	public void setValidFollowupTotal(Integer validFollowupTotal) {
		this.validFollowupTotal = validFollowupTotal;
	}
	public Integer getStabileTotal() {
		return stabileTotal;
	}
	public void setStabileTotal(Integer stabileTotal) {
		this.stabileTotal = stabileTotal;
	}
	public Integer getRecidivationTotal() {
		return recidivationTotal;
	}
	public void setRecidivationTotal(Integer recidivationTotal) {
		this.recidivationTotal = recidivationTotal;
	}
	public Integer getMetastaticTotal() {
		return metastaticTotal;
	}
	public void setMetastaticTotal(Integer metastaticTotal) {
		this.metastaticTotal = metastaticTotal;
	}
	public Integer getDeathTotal() {
		return deathTotal;
	}
	public void setDeathTotal(Integer deathTotal) {
		this.deathTotal = deathTotal;
	}
}
