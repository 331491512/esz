package com.esuizhen.cloudservice.user.bean;
/**
 * 
* @ClassName: TWeixinDiseaseProfile 
* @Description: 疾病 
* @author LIPENG
* @date 2016年2月26日 下午3:21:33 
*
 */
public class TWeixinDiseaseProfile {
	private String postion;
	private String species;
	private String diagnosis;
	/** 
	* @return postion 
	*/
	public String getPostion() {
		return postion;
	}
	/** 
	* @param postion 要设置的 postion 
	*/
	public void setPostion(String postion) {
		this.postion = postion;
	}
	/** 
	* @return species 
	*/
	public String getSpecies() {
		return species;
	}
	/** 
	* @param species 要设置的 species 
	*/
	public void setSpecies(String species) {
		this.species = species;
	}
	/** 
	* @return diagnosis 
	*/
	public String getDiagnosis() {
		return diagnosis;
	}
	/** 
	* @param diagnosis 要设置的 diagnosis 
	*/
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
}
