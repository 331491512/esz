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
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCondition;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCounty;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDiagnosisperiodization;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDoctor;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNation;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNationality;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoOccupation;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoPayChannel;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoSurgeryIntensive;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoTumourPeriodization;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfotreatmentHistory;
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

	List<TMetaInfoTreatmentScheme> getMetaInfoTreatmentSchemeList(Integer treatmentTypeId,String treatmentSchemeName);

	List<TMetaInfoMedicationItem> getMetaInfoTreatmentSchemeItemList(int treatmentSchemeId);

	List<TMetaInfoIcd9Cm3> getMetaInfoIcd9Cm3(String key);

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
	
	//add by emc start
	
	public List<TMetaInfoPayChannel> getMetaInfoPayChannelList(String payChannelName);
	
	public List<TMetaInfoOccupation> getMetaInfoOccupationList(String occupationName);
	
	public List<TMetaInfoNation> getMetaInfoNationList(String nationName);
	
	public List<TMetaInfoCounty> getMetaInfoCountyList(String provinceCode, String cityCode, String countyCode);
	
	public List<TMetaInfoNationality> getMetaInfoNationalityList(String nationalityName);
	
	public List<TMetaInfoCondition> getMetaInfoConditionList(String bussinessType);
	
	public List<TMetaInfotreatmentHistory> getMetaInfoTreatmentHistoryList(String treatmentHistoryName);
	/**
	 * 重症监护室元数据查询
	 */
	public List<TMetaInfoSurgeryIntensive> getMetaInfoSurgeryIntensiveList(String surgeryCode,String surgeryName);
	/**
	 * 手术元数据列表
	 */
	public List<TMetaInfoIcd9Cm3> getMetaInfoIcd9Cm3List(String key,String opCode, String opName, String mnemonicCode);
	/**
	 * 肿瘤分期元数据列表
	 */
	public List<TMetaInfoTumourPeriodization> getMetaInfoTumourPeriodizationList(String tumourCode);
	
	public List<TMetaInfoDoctor> getMetaInfoDoctorList(String trueName);
	
	/**
	 * 查询所有的诊断分期
	 * @param param
	 * @return
	 */
	List<TMetaInfoDiagnosisperiodization> queryListAll();
	//add by emc end
}
