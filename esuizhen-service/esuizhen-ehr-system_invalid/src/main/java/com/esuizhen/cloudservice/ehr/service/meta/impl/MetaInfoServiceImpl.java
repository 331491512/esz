/**
 * @author: Da Loong
 * @date:   2016年4月7日 下午4:45:07
 */
package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.TMetaDiagnosisPeriodization;
import com.esuizhen.cloudservice.ehr.bean.TMetaDiseaseTypeIcdListReq;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoAdverseReaction;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoDetectionItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoDetectionType;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoEcog;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoExamItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoExamType;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoICDO3;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoIcd10Req;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoIcd9Cm3;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoKps;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoMedicationItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoPhysicalSigns;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoQualityoflifeScaleItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoSymptom;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoTcmSymptom;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoTreatmentScheme;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoDao;
import com.esuizhen.cloudservice.ehr.model.disease.MetaEIcdOParent;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisPeriodizationInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TMetaInfoDiseaseTypeIcd;
import com.esuizhen.cloudservice.ehr.model.disease.TMetaInfoTreatmentType;
import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaDetectionUnit;
import com.esuizhen.cloudservice.ehr.service.meta.MetaInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

/**
 * @author Da Loong
 * @date   2016年4月7日 下午4:45:07
 */
@Service
public class MetaInfoServiceImpl implements MetaInfoService {

	/* (non-Javadoc)
	 * @see com.esuizhen.cloudservice.ehr.service.meta.MetaInfoService#listMetaInfoPhysicalSigns()
	 */
	@Autowired
	private MetaInfoDao dao;
	
	@Override
	public List<TMetaInfoPhysicalSigns> listMetaInfoPhysicalSigns() {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoPhysicalSignsList();
	}

	@Override
	public List<TMetaInfoKps> getMetaInfoKps() {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoKps();
	}

	@Override
	public List<TMetaInfoEcog> getMetaInfoEcog() {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoEcog();
	}

	@Override
	public List<TMetaInfoExamType> getMetaInfoChildExamType(Integer parentId, Integer flag) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoChildExamType(parentId, flag);
	}

	@Override
	public List<TMetaInfoExamItem> getMetaInfoExamItemList(int examTypeId) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoExamItemList(examTypeId);
	}

	@Override
	public List<TMetaInfoDetectionType> getMetaInfoChildDetectionType(int parentId, Integer flag) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoChildDetectionType(parentId, flag);	
	}

	@Override
	public List<TMetaInfoDetectionItem> getMetaInfoDetectionItemList(Integer detectionTypeId, Integer flag) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoDetectionItemList(detectionTypeId, flag);

	}

	@Override
	public List<TMetaInfoSymptom> getMetaInfoSymptoms() {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoSymptoms();
	}

	@Override
	public List<TMetaInfoMedicationItem> getMetaInfoMedicationItemList(Integer medicationType) {
		// TODO Auto-generated method stub
		return  dao.queryMetaInfoMedicationItemList(medicationType);
	}

	@Override
	public List<TMetaInfoAdverseReaction> getMetaInfoAdverseReaction() {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoAdverseReaction();
	}

	@Override
	public List<TMetaInfoQualityoflifeScaleItem> getMetaInfoQualityoflifeScale(int scaleTypeId) {
		// TODO Auto-generated method stub
		// modified by Da Loong. 2016/4/14
		// 增加itemOptionsList: 答案选项列表
		// 根据生存质量元数据表返回的isUseGeneralOptions，
		//  如果1： 查找meta_e_qualityoflife_scale_item_options
		//  如果0: 查找meta_e_qualityoflife_scale_general_options
		Integer isUseGeneralOptions = dao.getUseGeneralOptions(scaleTypeId);
		
		if(isUseGeneralOptions==null)
		{
			LogUtil.logError.error(Constant.LOGTAG.ERR+"getMetaInfoQualityoflifeScale failed: can not find such scaleTypeId: "+scaleTypeId);
			return null;
		}
		return dao.querytMetaInfoQualityoflifeScale(scaleTypeId,isUseGeneralOptions);
	}

	@Override
	public List<TMetaInfoTcmSymptom> getMetaInfoTcmSymptoms() {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoTcmSymptoms();
	}

	@Override
	public List<TMetaInfoTreatmentScheme> getMetaInfoTreatmentSchemeList(Integer treatmentTypeId) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoTreatmentSchemeList(treatmentTypeId);
	}

	@Override
	public List<TMetaInfoMedicationItem> getMetaInfoTreatmentSchemeItemList(int treatmentSchemeId) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoTreatmentSchemeItemList(treatmentSchemeId);
	}

	@Override
	public List<TMetaInfoIcd9Cm3> getMetaInfoIcd9Cm3() {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoIcd9Cm3();
	}

	@Override
	public List<TMetaDiagnosisPeriodization> getMetaInfoDiagnosisPeriodization(String timeFlag) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoDiagnosisPeriodization(timeFlag);
	}

	@Override
	public List<TMetaInfoICDO3> listMetaInfoIcdO3(String timeFlag) {
		// TODO Auto-generated method stub
		return dao.queryMetaInfoICDO3(timeFlag);
	}

	@Override
	public List<MetaEIcdOParent> getMetaInfoIcdOAll(Integer reqFlag) {
		return this.dao.queryMetaInfoIcdOAll(reqFlag);
	}

	@Override
	public List<TDiagnosisPeriodizationInfo> getMetaInfoDiagnosisPeriodizationAll() {
		return this.dao.queryMetaInfoDiagnosisPeriodizationAll();
	}

	@Override
	public List<TMetaInfoTreatmentType> getMetaInfoTreatmentTypeList(Integer flag,Integer showFlag,String treatmentTypeName) {
		return this.dao.queryMetaInfoTreatmentTypeList(flag,showFlag,treatmentTypeName);
	}

	@Override
	public List<TMetaInfoDiseaseTypeIcd> queryMetaInfoDiseaseTypeIcdList(
			TMetaDiseaseTypeIcdListReq req) {
		return dao.queryMetaInfoDiseaseTypeIcdList(req);
	}
	@Override
	public Page<TMetaInfoDiseaseTypeIcd> queryMetaInfoDiseaseTypeIcdPageList(
			TMetaDiseaseTypeIcdListReq req) {
		if(req==null){
			req = new TMetaDiseaseTypeIcdListReq();
			req.setNum(10);
			req.setPage(0);
		}else{
			if(req.getPage()==null)req.setPage(0);
			if(req.getNum()==null)req.setNum(10);
		}
		List<TMetaInfoDiseaseTypeIcd> list=this.dao.queryMetaInfoDiseaseTypeIcdPageList(req);
		
		int currPage = req.getPage()+1;
		int totalNum = list.size();
		int totalPage = (int) Math.ceil((double)totalNum/(double)req.getNum());//进位取整
		int currSize = currPage<totalPage?req.getNum():(totalNum%req.getNum()==0?req.getNum():totalNum%req.getNum());
		List<TMetaInfoDiseaseTypeIcd> subList = list.subList(req.getPage()*req.getNum(), req.getPage()*req.getNum()+currSize);
		Page page = new Page();
		page.setCurrPage(currPage);
		page.setTotalNum(totalNum);
		page.setTotalPage(totalPage);
		page.setDataList(subList);
		page.setCurrSize(currSize);
		
		return page;
	}

	@Override
	public Page<MetaEicd10> searchMetaInfoIcd10(TMetaInfoIcd10Req req) {
		if(req==null){
			PageHelper.startPage(1,10);
		}
		else if(req.getPage()==null){
			req.setPage(0);
			req.setNum(10);
			PageHelper.startPage(req.getPage()+1,req.getNum());
		}
		else PageHelper.startPage(req.getPage()+1,req.getNum());
		List<MetaEicd10> list=this.dao.searchMetaInfoIcd10(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<MetaEicd10>)list);
	}

	@Override
	public List<TMetaDetectionUnit> getMetaInfoDetectionUnit() {
		return this.dao.findMetaInfoDetectionUnit();
	}
	
	
}
