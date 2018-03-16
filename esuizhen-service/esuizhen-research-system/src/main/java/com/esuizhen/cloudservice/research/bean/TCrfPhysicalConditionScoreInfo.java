package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;

/** 
* @ClassName: TCrfCourseInfo 
* @Description: CRF随访周期信息
* @author YYCHEN
* @date 2016年04月06日 下午16:51:01  
*/
public class TCrfPhysicalConditionScoreInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//观察项ID
	private String crfObserveId;
	//
	private List<TCrfObservationSubjectElement> physicalConditionScoreList;
	public String getCrfObserveId() {
		return crfObserveId;
	}
	public void setCrfObserveId(String crfObserveId) {
		this.crfObserveId = crfObserveId;
	}
	public List<TCrfObservationSubjectElement> getPhysicalConditionScoreList() {
		return physicalConditionScoreList;
	}
	public void setPhysicalConditionScoreList(List<TCrfObservationSubjectElement> physicalConditionScoreList) {
		this.physicalConditionScoreList = physicalConditionScoreList;
	}
}
