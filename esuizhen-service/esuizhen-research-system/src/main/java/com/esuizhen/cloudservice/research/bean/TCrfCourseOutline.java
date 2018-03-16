package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfObservationSubjectElement;

/** 
* @ClassName: TCrfCourseOutline 
* @Description: CRF随访周期概览
* @author YYCHEN
* @date 2016年04月06日 下午16:51:01  
*/
public class TCrfCourseOutline implements Serializable {
	private static final long serialVersionUID = 1L;

	//CRF随访周期ID
	private String crfCourseId;
	//周期名
	private String crfCourseItemName;
	//周期序号
	private Integer crfCourseIndex;
	//仅返回本随访周期第一个courseItem的二级标题列表
	private List<TCrfObservationSubjectElement> crfObserveList;
	
	public String getCrfCourseId() {
		return crfCourseId;
	}
	public void setCrfCourseId(String crfCourseId) {
		this.crfCourseId = crfCourseId;
	}
	public String getCrfCourseItemName() {
		return crfCourseItemName;
	}
	public void setCrfCourseItemName(String crfCourseItemName) {
		this.crfCourseItemName = crfCourseItemName;
	}
	public Integer getCrfCourseIndex() {
		return crfCourseIndex;
	}
	public void setCrfCourseIndex(Integer crfCourseIndex) {
		this.crfCourseIndex = crfCourseIndex;
	}
	public List<TCrfObservationSubjectElement> getCrfObserveList() {
		return crfObserveList;
	}
	public void setCrfObserveList(List<TCrfObservationSubjectElement> crfObserveList) {
		this.crfObserveList = crfObserveList;
	}
}
