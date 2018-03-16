package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esuizhen.cloudservice.ehr.model.medicalRecord.TVarPatientMedical;
import com.westangel.common.util.LogUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class TVarPatientMedicalDaoTest 
{
	
	@Autowired
	private TVarPatientMedicalDao dao;
	
	@Test
	public void insertVarPatientMedical() 
	{
		LogUtil.log.info("haha");
//		TVarPatientMedical varPatientMedical = new TVarPatientMedical();
//		varPatientMedical.setPatientId(29L);
//		varPatientMedical.setLatestMedicalRecordUploadTime(new Date());
//		dao.insertVarPatientMedical(varPatientMedical);
	}
}
