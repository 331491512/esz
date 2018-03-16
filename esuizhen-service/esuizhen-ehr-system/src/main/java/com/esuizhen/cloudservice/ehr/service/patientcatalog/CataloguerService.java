package com.esuizhen.cloudservice.ehr.service.patientcatalog;

import com.esuizhen.cloudservice.ehr.model.patientcatalog.CatalogueInfo;
import com.westangel.common.bean.Page;


public interface CataloguerService{
	Page<CatalogueInfo> queryCataloguerIndex(String hospitalName,Integer page,Integer num);
}
