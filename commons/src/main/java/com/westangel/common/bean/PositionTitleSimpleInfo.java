package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: PositionTitleSimpleInfo 
* @Description: 职称简要信息bean
* @author YYCHEN
* @date 2016年1月3日 下午18:44:01  
*/
public class PositionTitleSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long positionTitleId;
	private String positionTitleName;
	
	public Long getPositionTitleId() {
		return positionTitleId;
	}
	public void setPositionTitleId(Long positionTitleId) {
		this.positionTitleId = positionTitleId;
	}
	public String getPositionTitleName() {
		return positionTitleName;
	}
	public void setPositionTitleName(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}
}
