package com.esuizhen.cloudservice.business.dao.business;

import com.esuizhen.cloudservice.business.bean.ServiceColumnReq;
import com.esuizhen.cloudservice.business.bean.ServiceColumnResult;

import java.util.List;

/**
 * Created by Nidan on 2017年02月20 下午 12:42
 */
public interface ServiceColumnDao {

    List<ServiceColumnResult> findServiceColumns(ServiceColumnReq req);

    List<ServiceColumnResult> findServiceColumnByIsShow(Integer isShow);
}
