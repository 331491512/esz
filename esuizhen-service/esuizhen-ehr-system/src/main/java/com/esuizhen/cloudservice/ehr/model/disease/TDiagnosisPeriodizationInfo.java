package com.esuizhen.cloudservice.ehr.model.disease;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TDiagnosisPeriodizationInfo</p>
 * <p>Description:诊断分期bean</p>
 * @author YYCHEN
 * @date 2016年6月22日 上午11:56:10
 */
public class TDiagnosisPeriodizationInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	//分期ID
	private Integer disagnosisPeriodizationId;
	//分期代码
	private String disagnosisPeriodizationCode;
	//分期名称
	private String disagnosisPeriodizationName;
	//阶段。1~n，对应I、II、III等
	private Integer phase;
	//排序索引
	private Integer index;
	//创建时间
	private Date createTime;
	public Integer getDisagnosisPeriodizationId() {
		return disagnosisPeriodizationId;
	}
	public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
		this.disagnosisPeriodizationId = disagnosisPeriodizationId;
	}
	public String getDisagnosisPeriodizationCode() {
		return disagnosisPeriodizationCode;
	}
	public void setDisagnosisPeriodizationCode(String disagnosisPeriodizationCode) {
		this.disagnosisPeriodizationCode = disagnosisPeriodizationCode;
	}
	public String getDisagnosisPeriodizationName() {
		return disagnosisPeriodizationName;
	}
	public void setDisagnosisPeriodizationName(String disagnosisPeriodizationName) {
		this.disagnosisPeriodizationName = disagnosisPeriodizationName;
	}
	public Integer getPhase() {
		return phase;
	}
	public void setPhase(Integer phase) {
		this.phase = phase;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
