package com.esuizhen.cloudservice.ehr.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:MedialRecordForwardReq</p>
 * <p>Description:病历转发请求</p>
 * @author YYCHEN
 * @date 2016年12月1日 上午9:58:11
 */
public class MedialRecordForwardReq implements Serializable {
	private static final long serialVersionUID = 1L;

	//病历类型
	private Integer emrType;
	//患者ID
	private Long patientId;
	//处理医生
	private Long doctorId;
	//产品服务申请ID
	private String productApplyId;
	//可见标识
	private Integer visibleFlag;
	//具体病历类型
	private List<Map<String, Integer>> reportTypeList;
	public Integer getEmrType() {
		return emrType;
	}
	public void setEmrType(Integer emrType) {
		this.emrType = emrType;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getVisibleFlag() {
		return visibleFlag;
	}
	public void setVisibleFlag(Integer visibleFlag) {
		this.visibleFlag = visibleFlag;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public List<Map<String, Integer>> getReportTypeList() {
		return reportTypeList;
	}
	public void setReportTypeList(List<Map<String, Integer>> reportTypeList) {
		this.reportTypeList = reportTypeList;
	}
}
