package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: ProfessionalRankSimpleInfo 
* @Description: 职称简要信息bean
* @author YYCHEN
* @date 2015年12月23日 上午10:44:01  
*/
public class ProfessionalRankSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String professionalRankCode;
	private String professionalRank;
	public String getProfessionalRankCode() {
		return professionalRankCode;
	}
	public void setProfessionalRankCode(String professionalRankCode) {
		this.professionalRankCode = professionalRankCode;
	}
	public String getProfessionalRank() {
		return professionalRank;
	}
	public void setProfessionalRank(String professionalRank) {
		this.professionalRank = professionalRank;
	}
}
