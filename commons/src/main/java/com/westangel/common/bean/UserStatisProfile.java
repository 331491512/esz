package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: UserStatisProfile 
* @Description: 用户统计信息bean
* @author YYCHEN
* @date 2015年12月22日 下午16:51:10  
*/
public class UserStatisProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer totalOrderNum;
	private Integer questionnaireAnswerNum;
	//最后一次随访结果
	private TFollowupResultInfo latestFollowupResult;
	
	public Integer getTotalOrderNum() {
		return totalOrderNum;
	}
	public void setTotalOrderNum(Integer totalOrderNum) {
		this.totalOrderNum = totalOrderNum;
	}
	public Integer getQuestionnaireAnswerNum() {
		return questionnaireAnswerNum;
	}
	public void setQuestionnaireAnswerNum(Integer questionnaireAnswerNum) {
		this.questionnaireAnswerNum = questionnaireAnswerNum;
	}
	public TFollowupResultInfo getLatestFollowupResult() {
		return latestFollowupResult;
	}
	public void setLatestFollowupResult(TFollowupResultInfo latestFollowupResult) {
		this.latestFollowupResult = latestFollowupResult;
	}
}
