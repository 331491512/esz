/**
 * @author: Da Loong
 * @date:   2016年4月7日 下午4:48:20
 */
package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.TMetaDiagnosisPeriodization;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoAdverseReaction;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoDetectionItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoDetectionType;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoEcog;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoExamItem;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoExamType;
import com.esuizhen.cloudservice.ehr.bean.TMetaInfoICDO3;
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

/**
 * @author Da Loong
 * @date   2016年4月7日 下午4:48:20
 */
public interface MetaInfoDao {

	List<TMetaInfoPhysicalSigns> queryMetaInfoPhysicalSignsList();

	List<TMetaInfoKps> queryMetaInfoKps();

	List<TMetaInfoEcog> queryMetaInfoEcog();

	List<TMetaInfoExamType> queryMetaInfoChildExamType(@Param("parentId")Integer parentId, @Param("flag")Integer flag);

	List<TMetaInfoExamItem> queryMetaInfoExamItemList(int examTypeId);

	List<TMetaInfoDetectionType> queryMetaInfoChildDetectionType(@Param("parentId")Integer parentId, @Param("flag")Integer flag);

	List<TMetaInfoDetectionItem> queryMetaInfoDetectionItemList(@Param("detectionTypeId")Integer detectionTypeId, @Param("flag")Integer flag);

	List<TMetaInfoSymptom> queryMetaInfoSymptoms();

	List<TMetaInfoMedicationItem> queryMetaInfoMedicationItemList(@Param("medicationType")Integer medicationType);

	List<TMetaInfoAdverseReaction> queryMetaInfoAdverseReaction();

	List<TMetaInfoQualityoflifeScaleItem> querytMetaInfoQualityoflifeScale(@Param("scaleTypeId") int scaleTypeId, @Param("isUseGeneralOptions") Integer isUseGeneralOptions);

	List<TMetaInfoTcmSymptom> queryMetaInfoTcmSymptoms();

	Integer getUseGeneralOptions(int scaleTypeId);

	List<TMetaInfoTreatmentScheme> queryMetaInfoTreatmentSchemeList(@Param("treatmentTypeId")Integer treatmentTypeId);

	List<TMetaInfoMedicationItem> queryMetaInfoTreatmentSchemeItemList(int treatmentSchemeId);

	List<TMetaInfoIcd9Cm3> queryMetaInfoIcd9Cm3();

	List<TMetaDiagnosisPeriodization> queryMetaInfoDiagnosisPeriodization(@Param("timeFlag")String timeFlag);

	List<TMetaInfoICDO3> queryMetaInfoICDO3(@Param("timeFlag")String timeFlag);
	
	/**
	 * <p>Title:queryMetaInfoIcdOAll</p>
	 * <p>Description:获取所有器官元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 上午10:38:27
	 * @return
	 */
	List<MetaEIcdOParent> queryMetaInfoIcdOAll(@Param("reqFlag")Integer reqFlag);

	/**
	 * <p>Title:queryMetaInfoDiagnosisPeriodizationAll</p>
	 * <p>Description:获取诊断分期元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午12:00:19
	 * @return
	 */
	List<TDiagnosisPeriodizationInfo> queryMetaInfoDiagnosisPeriodizationAll();

	/**
	 * <p>Title:queryMetaInfoTreatmentTypeList</p>
	 * <p>Description:查询治疗类型元数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午2:37:16
	 * @param flag
	 * @return
	 */
	List<TMetaInfoTreatmentType> queryMetaInfoTreatmentTypeList(@Param("flag")Integer flag,@Param("showFlag")Integer showFlag,@Param("treatmentTypeName")String treatmentTypeName);
	List<TMetaInfoDiseaseTypeIcd> queryMetaInfoDiseaseTypeIcdList(Object params);
	List<TMetaInfoDiseaseTypeIcd> queryMetaInfoDiseaseTypeIcdPageList(Object params);
	List<MetaEicd10> searchMetaInfoIcd10(Object params);

	/**
	 * <p>Title:findMetaInfoDetectionUnit</p>
	 * <p>Description:查询检验使用的单位</p>
	 * @author YYCHEN
	 * @date 2016年11月17日 下午4:42:42
	 * @return
	 */
	List<TMetaDetectionUnit> findMetaInfoDetectionUnit();
}
