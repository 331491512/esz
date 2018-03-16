package com.esuizhen.cloudservice.business.service.business.mdt.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.business.bean.TMDTDoctorInProductGroupInfo;
import com.esuizhen.cloudservice.business.bean.TProductGroupInfo;
import com.esuizhen.cloudservice.business.dao.business.mdt.MDTProductGroupDao;
import com.esuizhen.cloudservice.business.service.business.mdt.MDTProductGroupService;
import com.westangel.common.excption.InsufficientParameterExcption;

@Service
public class MDTProductGroupServiceImpl implements MDTProductGroupService {
	@Autowired
	private MDTProductGroupDao productGroupDao;

	@Override
	public TProductGroupInfo getMDTExpertGroupDetail(Long userId, String productId) throws InsufficientParameterExcption {
		if (StringUtils.isEmpty(productId)) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		return this.productGroupDao.findByProductId(productId);
	}

	@Override
	public List<TMDTDoctorInProductGroupInfo> getMDTDoctorInProductGroupList(String productId, Integer groupType) throws InsufficientParameterExcption {
		if (StringUtils.isEmpty(productId)) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		return this.productGroupDao.findMDTInProductGroupList(productId, groupType);
	}

	@Override
	public List<TMDTDoctorInProductGroupInfo> getMDTProductList(Integer hospitalId, Long userId) {
		return this.productGroupDao.findMDTProducts(hospitalId, userId);
	}
}
