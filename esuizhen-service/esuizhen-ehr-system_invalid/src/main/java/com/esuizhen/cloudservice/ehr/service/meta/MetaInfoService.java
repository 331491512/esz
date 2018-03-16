/**
 * @author: Da Loong
 * @date:   2016年4月7日 下午4:36:52
 */
package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.List;

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
import com.esuizhen.cloudservice.ehr.model.disease.MetaEIcdOParent;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisPeriodizationInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TMetaInfoDiseaseTypeIcd;
import com.esuizhen.cloudservice.ehr.model.disease.TMetaInfoTreatmentType;
import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaDetectionUnit;
import com.westangel.common.bean.Page;

/**
 * @author Da Loong
 * @date   2016年4月7日 下午4:36:52
 */
public interface MetaInfoService {

	List<TMetaInfoPhysicalSigns> listMetaInfoPhysicalSigns();

	List<TMetaInfoKps> getMetaInfoKps();

	List<TMetaInfoEcog> getMetaInfoEcog();

	/**
	 * <p>Title:getMetaInfoChildExamType</p>
	 * <p>Description:获取检查方式元数据</p>
	 * @author YYCHEN
	 * @date 2016年7月19日 下午2:30:24
	 * @param parentId 检查类型
	 * @param flag 是否专题使用
	 * @return
	 */
	List<TMetaInfoExamType> getMetaInfoChildExamType(Integer parentId, Integer flag);

	List<TMetaInfoExamItem> getMetaInfoExamItemList(int examTypeId);

	List<TMetaInfoDetectionType> getMetaInfoChildDetectionType(int parentId, Integer flag);

	List<TMetaInfoDetectionItem> getMetaInfoDetectionItemList(Integer detectionTypeId, Integer flag);

	List<TMetaInfoSymptom> getMetaInfoSymptoms();

	List<TMetaInfoMedicationItem> getMetaInfoMedicationItemList(Integer medicationType);

	
	List<TMetaInfoAdverseReaction> getMetaInfoAdverseReaction();

	List<TMetaInfoQualityoflifeScaleItem> getMetaInfoQualityoflifeScale(int scaleTypeId);

	List<TMetaInfoTcmSymptom> getMetaInfoTcmSymptoms();

	List<TMetaInfoTreatmentScheme> getMetaInfoTreatmentSchemeList(Integer treatmentTypeId);

	List<TMetaInfoMedicationItem> getMetaInfoTreatmentSchemeItemList(int treatmentSchemeId);

	List<TMetaInfoIcd9Cm3> getMetaInfoIcd9Cm3();

	List<TMetaDiagnosisPeriodization> getMetaInfoDiagnosisPeriodization(String timeFlag);

	List<TMetaInfoICDO3> listMetaInfoIcdO3(String timeFlag);
	
	/**
	 * <p>Title:getMetaInfoIcdOAll</p>
	 * <p>Description:获取所有器官元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 上午10:37:07
	 * @return
	 */
	List<MetaEIcdOParent> getMetaInfoIcdOAll(Integer reqFlag);

	/**
	 * <p>Title:getMetaInfoDiagnosisPeriodizationAll</p>
	 * <p>Description:获取诊断分期元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 上午11:59:25
	 * @return
	 */
	List<TDiagnosisPeriodizationInfo> getMetaInfoDiagnosisPeriodizationAll();

	/**
	 * <p>Title:getMetaInfoTreatmentTypeList</p>
	 * <p>Description:获取治疗类型元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午2:38:08
	 * @param flag
	 * @return
	 */
	List<TMetaInfoTreatmentType> getMetaInfoTreatmentTypeList(Integer flag,Integer showFlag,String treatmentTypeName);
	Page<TMetaInfoDiseaseTypeIcd> queryMetaInfoDiseaseTypeIcdPageList(TMetaDiseaseTypeIcdListReq req);
	List<TMetaInfoDiseaseTypeIcd> queryMetaInfoDiseaseTypeIcdList(TMetaDiseaseTypeIcdListReq req);
	Page<MetaEicd10> searchMetaInfoIcd10(TMetaInfoIcd10Req req);

	/**
	 * <p>Title:getMetaInfoDetectionUnit</p>
	 * <p>Description:获取检验数据使用的单位</p>
	 * @author YYCHEN
	 * @date 2016年11月17日 下午4:40:21
	 * @return
	 */
	List<TMetaDetectionUnit> getMetaInfoDetectionUnit();
}
