package com.esuizhen.cloudservice.business.bean;

import com.westangel.common.bean.sys.TagInfo;

import java.util.List;

/**
 * Created by Nidan on 2017年02月20 上午 10:48
 */
public class ServiceColumnReq {

    private Long patientId;

    private List<TagInfo> tags;

    public List<TagInfo> getTags() {
        return tags;
    }

    public void setTags(List<TagInfo> tags) {
        this.tags = tags;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
