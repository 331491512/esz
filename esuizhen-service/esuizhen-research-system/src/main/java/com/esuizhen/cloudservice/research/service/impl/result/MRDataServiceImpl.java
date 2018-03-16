package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.research.dao.result.TCrfResultExamDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTestInfoDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.MRDataService;
import com.westangel.common.excption.InsufficientParameterExcption;

@Service
public class MRDataServiceImpl implements MRDataService {
	@Autowired
	private TCrfResultExamDao crfResultExamDao;
	@Autowired
	private TCrfResultTestInfoDao crfResultTestInfoDao;

	@Override
	public List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>> queryCrfDataSources(
			TCrfResultMainInfo<Void> crfResultMainInfo) throws InsufficientParameterExcption {
		//验证参数
		if (crfResultMainInfo.getMedicalRecordType() == null ||
				crfResultMainInfo.getTypeId() == null ||
				crfResultMainInfo.getSubTypeId() == null ||
				crfResultMainInfo.getPatientId() == null ||
				crfResultMainInfo.getHospitalId() == null ||
				crfResultMainInfo.getCrfCourseItemTime() == null) {
			throw new InsufficientParameterExcption("parameters cannot be empty!");
		}
		switch (crfResultMainInfo.getMedicalRecordType()) {
		case 1://检查
			return this.getExamDataSources(crfResultMainInfo);
		case 2://检验
			return this.getTestDataSources(crfResultMainInfo);
		}
		return null;
	}
	/**
	 * <p>Title:getExamData</p>
	 * <p>Description:获取患者病历中检查数据数据源</p>
	 * @author YYCHEN
	 * @date 2016年7月26日 下午5:12:30
	 * @param crfResultMainInfo
	 * @return
	 */
	private List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>> getExamDataSources(TCrfResultMainInfo<Void> crfResultMainInfo){
		List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>> crfResultMainInfos = null;
		//查询院内同步的数据
		crfResultMainInfo.setSourceFlag(3);
		List<TCrfResultMainInfo<Void>> hospitalMainInfos = this.crfResultExamDao.queryMedicalRecordDataSources(crfResultMainInfo);
		if (hospitalMainInfos != null && !hospitalMainInfos.isEmpty()) {
			crfResultMainInfos = new ArrayList<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>>(2);
			TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>> info = new TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>();
			info.setDataSourceType(3);
			info.setDataSourceTypeName("院内检查");
			info.setCrfResult(hospitalMainInfos);
			crfResultMainInfos.add(info);
		}
		//患者和医生上传的数据
		crfResultMainInfo.setSourceFlag(1);
		List<TCrfResultMainInfo<Void>> patientMainInfos = this.crfResultExamDao.queryMedicalRecordDataSources(crfResultMainInfo);
		if (patientMainInfos != null && !patientMainInfos.isEmpty()) {
			if (crfResultMainInfos == null) {
				crfResultMainInfos = new ArrayList<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>>(1);
			}
			TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>> info = new TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>();
			info.setDataSourceType(1);
			info.setDataSourceTypeName("患者上传");
			info.setCrfResult(patientMainInfos);
			crfResultMainInfos.add(info);
		}
		return crfResultMainInfos;
	}
	/**
	 * <p>Title:getTestData</p>
	 * <p>Description:获取患者病历中检验数据数据源</p>
	 * @author YYCHEN
	 * @date 2016年7月26日 下午5:14:20
	 * @param crfResultMainInfo
	 * @return
	 */
	private List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>> getTestDataSources(TCrfResultMainInfo<Void> crfResultMainInfo){
		List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>> crfResultMainInfos = null;
		//查询院内同步的数据
		crfResultMainInfo.setSourceFlag(3);
		List<TCrfResultMainInfo<Void>> hospitalMainInfos = this.crfResultTestInfoDao.queryMedicalRecordDataSources(crfResultMainInfo);
		if (hospitalMainInfos != null && !hospitalMainInfos.isEmpty()) {
			crfResultMainInfos = new ArrayList<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>>(2);
			TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>> info = new TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>();
			info.setDataSourceType(3);
			info.setDataSourceTypeName("院内检查");
			info.setCrfResult(hospitalMainInfos);
			crfResultMainInfos.add(info);
		}
		//患者和医生上传的数据
		crfResultMainInfo.setSourceFlag(1);
		List<TCrfResultMainInfo<Void>> patientMainInfos = this.crfResultTestInfoDao.queryMedicalRecordDataSources(crfResultMainInfo);
		if (patientMainInfos != null && !patientMainInfos.isEmpty()) {
			if (crfResultMainInfos == null) {
				crfResultMainInfos = new ArrayList<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>>(1);
			}
			TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>> info = new TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>();
			info.setDataSourceType(1);
			info.setDataSourceTypeName("患者上传");
			info.setCrfResult(patientMainInfos);
			crfResultMainInfos.add(info);
		}
		return crfResultMainInfos;
	}

	@Override
	public TCrfResultMainInfo<?> queryCrfDataSourceData(Integer medicalRecordType, String emrId, Long patientId) throws InsufficientParameterExcption {
		//验证参数
		if (medicalRecordType == null ||
				StringUtils.isEmpty(emrId)) {
			throw new InsufficientParameterExcption("parameters cannot be empty!");
		}
		switch (medicalRecordType) {
		case 1://检查
			return this.crfResultExamDao.queryMedicalRecordData(emrId);
		case 2://检验
			return this.crfResultTestInfoDao.queryMedicalRecordData(emrId);
		}
		return null;
	}
	
}
