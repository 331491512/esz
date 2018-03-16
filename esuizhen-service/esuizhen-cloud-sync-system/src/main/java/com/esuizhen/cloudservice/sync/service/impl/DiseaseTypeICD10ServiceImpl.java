package com.esuizhen.cloudservice.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.sync.dao.cloud.CloudDiseaseTypeICD10Dao;
import com.esuizhen.cloudservice.sync.model.DiseaseTypeICD10;
import com.esuizhen.cloudservice.sync.service.DiseaseTypeICD10Service;
import com.github.pagehelper.PageHelper;

@Service
public class DiseaseTypeICD10ServiceImpl implements DiseaseTypeICD10Service {
	@Autowired
	private CloudDiseaseTypeICD10Dao cloudDiseaseTypeICD10Dao;

	@Override
	public DiseaseTypeICD10 getDiseaseTypeIdByDiseaseCode(String diseaseCode) {
		if (StringUtils.isEmpty(diseaseCode)) {
			return null;
		}
		//使用完整的ICD-10编码查找病种
		PageHelper.startPage(1, 1);
		List<DiseaseTypeICD10> diseaseTypeICD10s = this.cloudDiseaseTypeICD10Dao.findByDiseaseCode(0, diseaseCode, diseaseCode.length());
		if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
			return diseaseTypeICD10s.get(0);
		}
		//使用完整的ICD-10编码的前4位查找病种
		if (diseaseCode.indexOf('.') > 0) {
			PageHelper.startPage(1, 1);
			diseaseTypeICD10s = this.cloudDiseaseTypeICD10Dao.findByDiseaseCode(0, diseaseCode.substring(0, 5), 5);
			if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
				return diseaseTypeICD10s.get(0);
			}
		}else{
			PageHelper.startPage(1, 1);
			diseaseTypeICD10s = this.cloudDiseaseTypeICD10Dao.findByDiseaseCode(0, diseaseCode.substring(0, 4), 4);
			if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
				return diseaseTypeICD10s.get(0);
			}
		}
		//使用完整的ICD-10编码的前3位查找病种
		PageHelper.startPage(1, 1);
		diseaseTypeICD10s = this.cloudDiseaseTypeICD10Dao.findByDiseaseCode(0, diseaseCode.substring(0, 3), 3);
		if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
			return diseaseTypeICD10s.get(0);
		}
		//匹配库中配置的诊断编码(匹配关键字)
		
		return null;
	}
}
