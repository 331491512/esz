/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>MdtDiseaseEvaluationSubmitReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年3月7日下午10:49:45<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

/**
 * @ClassName: MdtDiseaseEvaluationSubmitReq
 * @Description:
 * @author lichenghao
 * @date 2016年3月7日 下午10:49:45
 */
public class MdtDiseaseEvaluationSubmitReq {
	
	//产品申请号
	private String productApplyId;
	
	//主要诊断
	private String diagnosis;
	
	//病理诊断
	private String pathologyDiagnosis;
	
	//病情描述
	private String description;
	
	//要求和目标
	private String goal;
	
	//推荐医生
	private String recommendedDoctor;
	
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getRecommendedDoctor() {
		return recommendedDoctor;
	}
	public void setRecommendedDoctor(String recommendedDoctor) {
		this.recommendedDoctor = recommendedDoctor;
	}
}
