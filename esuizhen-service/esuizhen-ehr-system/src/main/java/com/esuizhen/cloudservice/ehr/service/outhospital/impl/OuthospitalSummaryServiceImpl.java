package com.esuizhen.cloudservice.ehr.service.outhospital.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.OuthospitalSummaryDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.TOuthospitalSummaryInfo;
import com.esuizhen.cloudservice.ehr.service.outhospital.OuthospitalSummaryService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

@Service
public class OuthospitalSummaryServiceImpl implements OuthospitalSummaryService {
	
	@Autowired
	private OuthospitalSummaryDao outhospitalSummaryDao;

	@Override
	public TOuthospitalSummaryInfo queryOuthospitalSummary(String inhospitalId) {
		return outhospitalSummaryDao.queryOuthospitalSummary(inhospitalId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TOuthospitalSummaryInfo> queryPageOuthospitalList(CommonReq req) {
		Integer page = req.getPage();
		if(page != null) {
			PageHelper.startPage(page+1, req.getNum());
		}
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("patientId", req.getPatientId());
		paraMap.put("inhospitalId", req.getInhospitalId());
		paraMap.put("page", req.getPage());
		paraMap.put("num", req.getNum());
		List<TOuthospitalSummaryInfo> list = outhospitalSummaryDao.queryOuthospitalList(paraMap);
		Page<TOuthospitalSummaryInfo> pages=null;
		if(page != null) {
			pages=PageUtil.returnPage((com.github.pagehelper.Page<TOuthospitalSummaryInfo>)list);
		}else {
			pages= new Page<TOuthospitalSummaryInfo>();
			pages.setDataList(list);
		}
		return pages;
	}

}
