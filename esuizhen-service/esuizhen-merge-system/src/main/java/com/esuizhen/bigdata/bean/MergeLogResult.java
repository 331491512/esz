package com.esuizhen.bigdata.bean;

/**
 * Created by Nidan on 2016年12月23 下午 15:12
 */
public class MergeLogResult {

    private String mergeTime;
    private String mergeContent;
    private String mergeResult;
    private Long golPatientId;
    private String operator;
    private String mergeReason;

    public String getMergeReason() {
        return mergeReason;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }

    public String getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(String mergeTime) {
        this.mergeTime = mergeTime;
    }

    public String getMergeContent() {
        return mergeContent;
    }

    public void setMergeContent(String mergeContent) {
        this.mergeContent = mergeContent;
    }

    public String getMergeResult() {
        return mergeResult;
    }

    public void setMergeResult(String mergeResult) {
        this.mergeResult = mergeResult;
    }

    public Long getGolPatientId() {
        return golPatientId;
    }

    public void setGolPatientId(Long golPatientId) {
        this.golPatientId = golPatientId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
