package com.esuizhen.cloudservice.research.service.result;

import java.io.UnsupportedEncodingException;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;

public interface TProjectInvitationService {

	boolean addProjectInvitation(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws UnsupportedEncodingException;
}
