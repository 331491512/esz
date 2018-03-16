package com.esuizhen.cloudservice.ehr.service;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esuizhen.cloudservice.ehr.dao.meta.userdefined.MetaDataDao;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.westangel.common.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class MetaDataServiceTest 
{
	
	@Autowired
	private MetaDataService metaDataService;
	
	@Autowired
	private MetaDataDao dao;
	
	
	@Test
	public  void addMetaDate()
	{
		//metaDataService.addMetaDate(MetaDataConstant.META_ANESTHESIA_WAY, null, "半麻半醉", 3L);
		LogUtil.log.info("---------------");
	}
}
