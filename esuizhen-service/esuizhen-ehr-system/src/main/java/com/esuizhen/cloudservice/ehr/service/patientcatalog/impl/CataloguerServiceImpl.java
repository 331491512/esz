package com.esuizhen.cloudservice.ehr.service.patientcatalog.impl;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.patientcatalog.CatalogueInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.patientcatalog.CataloguerService;
import com.westangel.common.bean.Page;

@Service
public class CataloguerServiceImpl extends CommonServiceImpl<CatalogueInfo> implements CataloguerService {
	
	@Autowired
	private CommonDao<CatalogueInfo> cataloguerDao;

	@Override
	public CommonDao<CatalogueInfo> getCommonDao() {
		return cataloguerDao;
	}

	@Override
	public Page<CatalogueInfo> queryCataloguerIndex(String hospitalName, Integer page,
			Integer num) {
		CommonReq req = new CommonReq();
		req.setPage(page);
		req.setNum(num);
		req.setHospitalName(hospitalName);
//		return this.queryPageList(req);
		return this.queryCustomPageList(req);
	}
	
}
