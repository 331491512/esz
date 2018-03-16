package com.esuizhen.cloudservice.ehr.controller.medical;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsExerciseInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsFoodInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSleepInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSmokeInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSotInfo;
import com.esuizhen.cloudservice.ehr.bean.TumourFamilyHistoryInfo;
import com.esuizhen.cloudservice.ehr.bean.medical.PatientMedicalRecordModifyFlag;
import com.esuizhen.cloudservice.ehr.bean.medical.PatientMedicalRecordReq;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.GenenalExaminationInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.PhysicalSigns;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;
import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationDetailInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationInfo;
import com.westangel.common.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class MedicalControllerTest{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void savePatientMedicalRecord() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		PatientMedicalRecordReq req = new PatientMedicalRecordReq();
		
		// 住院 - 测试通过
		TInhospitalDetailInfo tInhospitalDetailInfo = new TInhospitalDetailInfo();
		tInhospitalDetailInfo.setInhospitalId("EINH201612161304141000148988081");
		tInhospitalDetailInfo.setPatientId(617086l);
		tInhospitalDetailInfo.setTrueName("习平平");// 修改
		tInhospitalDetailInfo.setSex(1);
		tInhospitalDetailInfo.setBirthDate(sdf.parse("2012-09-01 00:00:00"));
		tInhospitalDetailInfo.setAge(8);
//		tInhospitalDetailInfo.setHospitalName("山西静乐县人民医院");
		tInhospitalDetailInfo.setHospitalName("鲁南肿瘤医院");// 修改
		
//		tInhospitalDetailInfo.setHospitalId(91);
		tInhospitalDetailInfo.setHospitalId(34946);// 修改
		tInhospitalDetailInfo.setMedicalPayType(1);
		tInhospitalDetailInfo.setHealthCardNo("20179211014356");// 修改
		tInhospitalDetailInfo.setInhospitalTimes(1);
		tInhospitalDetailInfo.setPatientNo("20179211014446");// 修改
		
		tInhospitalDetailInfo.setNationalityId(1);
		tInhospitalDetailInfo.setBabyAge("1");
		tInhospitalDetailInfo.setBabyBornWeight("2");
		tInhospitalDetailInfo.setBabyWeightInHospital("3");
		tInhospitalDetailInfo.setBirthPlaceCountyCode("110101");
		
		tInhospitalDetailInfo.setBirthPlaceAddress("4");
		tInhospitalDetailInfo.setNativePlaceCityCode("110100");
		tInhospitalDetailInfo.setNativePlaceAddress("5");
		tInhospitalDetailInfo.setNation("土家族");
		tInhospitalDetailInfo.setNationId(1);
		
		tInhospitalDetailInfo.setIdentification("123456789987654322");
		tInhospitalDetailInfo.setIdType(1);
		tInhospitalDetailInfo.setOccupationName("国家公务员");
		tInhospitalDetailInfo.setOccupationId(11);
		tInhospitalDetailInfo.setMarriageStatus(1);
		
		tInhospitalDetailInfo.setLiveCountyCode("110101");
		tInhospitalDetailInfo.setLiveAddress("6");
		tInhospitalDetailInfo.setLiveTel("66069599");
		tInhospitalDetailInfo.setLiveZipCode("100086");
		tInhospitalDetailInfo.setHouseholdCountyCode("110101");
		
		tInhospitalDetailInfo.setHouseholdAddress("7");
		tInhospitalDetailInfo.setHouseholdZipCode("100086");
		tInhospitalDetailInfo.setCompanyCountyCode("110101");
		tInhospitalDetailInfo.setCompanyAddress("8");
		tInhospitalDetailInfo.setCompanyTel("66039599");
		
		tInhospitalDetailInfo.setCompanyZipCode("100086");
		tInhospitalDetailInfo.setFamilyName("隔壁老王");
		tInhospitalDetailInfo.setPatientRelation(9);
		tInhospitalDetailInfo.setFamilyTel("66065899");
		tInhospitalDetailInfo.setFamilyCountyCode("110101");
		
		tInhospitalDetailInfo.setFamilyAddress("8");
		tInhospitalDetailInfo.setInhospitalWay(1);
		tInhospitalDetailInfo.setInhospitalDate(sdf.parse("2017-09-18 00:00:00"));
		tInhospitalDetailInfo.setInhospitalDeptName("");
		tInhospitalDetailInfo.setInhospitalWard("血液内科");
		
		tInhospitalDetailInfo.setTurnDept("转科情况");
		tInhospitalDetailInfo.setOuthospitalDate(sdf.parse("2017-09-21 23:59:59"));
		tInhospitalDetailInfo.setOuthospitalDeptId(null);
		tInhospitalDetailInfo.setOuthospitalDeptName("");
		tInhospitalDetailInfo.setOuthospitalWard("血液内科");
		
		tInhospitalDetailInfo.setInhospitalDays(3);
		tInhospitalDetailInfo.setOperatorId(19046l);
		tInhospitalDetailInfo.setOperatorName("李陈浩");
		tInhospitalDetailInfo.setEmrId("2");
		tInhospitalDetailInfo.setSourceflag(4);
		
		// 放到主类中
//		req.setInhospitalDetailInfo(tInhospitalDetailInfo);
		
		// *********************************************************************************************
		
		// 门诊 - 测试通过
		PatientClinicInfo patientClinicInfo = new PatientClinicInfo();
//		patientClinicInfo.setHospitalName("山西静乐县人民医院");
		patientClinicInfo.setHospitalName("鲁南肿瘤医院");// 修改
//		patientClinicInfo.setHospitalId(91);
		patientClinicInfo.setHospitalId(34946);// 修改
		patientClinicInfo.setMedicalPayType(1);
		patientClinicInfo.setHealthCardNo("20179211107402");// 修改
		patientClinicInfo.setPatientNo("20179211107472");// 修改
		
		patientClinicInfo.setPatientName("温宝宝");// 修改
		patientClinicInfo.setPatientSex(1);
		patientClinicInfo.setPatientBirth(sdf.parse("2017-09-21 00:00:00"));
		patientClinicInfo.setPatientAge(1);
		patientClinicInfo.setNationalityId(1);
		
		patientClinicInfo.setBabyAge(1);
		patientClinicInfo.setBabyBornWeight(2);
		patientClinicInfo.setBabyWeightInHospital(3);
		patientClinicInfo.setBirthPlaceCountyCode("110101");
		patientClinicInfo.setBirthPlaceAddress("4");
		
		patientClinicInfo.setNativePlaceCityCode("110100");
		patientClinicInfo.setNativePlaceAddress("5");
		patientClinicInfo.setNation("土家族");
		patientClinicInfo.setNationId(1);
		patientClinicInfo.setPatientIdno("854796542365005475");
		
		patientClinicInfo.setIdType(1);
		patientClinicInfo.setOccupationName("国家公务员");
		patientClinicInfo.setOccupationId(11);
		patientClinicInfo.setMarriageStatus(1);
		patientClinicInfo.setLiveProvinceCode("110000");
		
		patientClinicInfo.setLiveCityCode("110100");
		patientClinicInfo.setLiveCountyCode("110101");
		patientClinicInfo.setLiveAddress("6");
		patientClinicInfo.setLiveTel("66131399");
		patientClinicInfo.setLiveZipCode("100086");
		
		patientClinicInfo.setHouseholdProvinceCode("110000");
		patientClinicInfo.setHouseholdCityCode("110100");
		patientClinicInfo.setHouseholdCountyCode("110101");
		patientClinicInfo.setHouseholdAddress("7");
		patientClinicInfo.setHouseholdZipCode("100086");
		
		patientClinicInfo.setCompanyProvinceCode("110000");
		patientClinicInfo.setCompanyCityCode("110100");
		patientClinicInfo.setCompanyCountyCode("110101");
		patientClinicInfo.setCompanyAddress("8");
		patientClinicInfo.setCompanyTel("66529699");
		
		patientClinicInfo.setCompanyZipCode("100086");
		patientClinicInfo.setFamilyName("隔壁老王");
		patientClinicInfo.setPatientRelation(9);
		patientClinicInfo.setFamilyTel("66056988");
		patientClinicInfo.setFamilyProvinceCode("110000");
		
		patientClinicInfo.setFamilyCityCode("110100");
		patientClinicInfo.setFamilyCountyCode("110101");
		patientClinicInfo.setFamilyAddress("9");
		patientClinicInfo.setClinicWay(2);
		patientClinicInfo.setVisitTime("2017-09-21 00:00:00");
		
		patientClinicInfo.setDeptName("内科门诊");
		patientClinicInfo.setClinicWard("内科");
		patientClinicInfo.setOperatorId(19046l);
		patientClinicInfo.setEmrId("2");
		
		// 放到主类中
//		req.setPatientClinicInfo(patientClinicInfo);
		
		// *********************************************************************************************
		
		// 诊断 - 测试通过
		TDiagnosisInfo tDiagnosisInfo = new TDiagnosisInfo();
		tDiagnosisInfo.setDiagnosis("非霍奇金淋巴瘤(弥漫大B细胞)");
		tDiagnosisInfo.setDiagnosisId("EDIAG20170922120450454580");// 修改
		tDiagnosisInfo.setInhospitalId("EINH20170922120450454580");// 修改
		tDiagnosisInfo.setPatientId(3126626l);// 修改
		tDiagnosisInfo.setDiagnosisCode("C83.3M9680/3");
		
		tDiagnosisInfo.setInHospitalCondition(1);
		tDiagnosisInfo.setOuthospitalCondition(2);
		tDiagnosisInfo.setSuspectedDiagnosisFlag(0);
		tDiagnosisInfo.setDiagnosisExplain(2);
		tDiagnosisInfo.setOrganCode("C00.001");
		
		tDiagnosisInfo.setOrganName("上唇");
		tDiagnosisInfo.setDiagnosisBasisId(1);
		tDiagnosisInfo.setIsFollowup(1);
		tDiagnosisInfo.setSourceCancerCount(1);
		tDiagnosisInfo.setTreatmentHistory(1);
		
		tDiagnosisInfo.setOperatorId(19046l);
		tDiagnosisInfo.setDiagnosisTypeId(1);
		tDiagnosisInfo.setPathologyDiagnosis("恶性瘤，小细胞型");
		tDiagnosisInfo.setPathologyDiagnosisCode("8002/3");
		
		tDiagnosisInfo.setPathologyDiagnosis("恶性瘤，小细胞型");
		tDiagnosisInfo.setPathologyDiagnosisCode("8002/3");
		tDiagnosisInfo.setTumourPeriodizationT("T0");
		tDiagnosisInfo.setTumourPeriodizationTId("0");
		tDiagnosisInfo.setTumourPeriodizationN("N0");
		
		tDiagnosisInfo.setTumourPeriodizationNId("0");
		tDiagnosisInfo.setTumourPeriodizationM1("M0");
		tDiagnosisInfo.setTumourPeriodizationM1Id("0");
		tDiagnosisInfo.setTumourPeriodizationClinic("0期");
		
		List<TDiagnosisInfo> tDiagnosisInfoList = new ArrayList<TDiagnosisInfo>();
		tDiagnosisInfoList.add(tDiagnosisInfo);
		
		// 放到主类中
//		req.setDiagnosisList(tDiagnosisInfoList);
		
		// *********************************************************************************************
		
		// 手术 - 测试通过
		// 1.手术列表 数据
		TPatientSurgeryInfo tPatientSurgeryInfo = new TPatientSurgeryInfo();
		tPatientSurgeryInfo.setOpCharacter(1);
		tPatientSurgeryInfo.setPatientId(3123300l);
		tPatientSurgeryInfo.setInhospitalId("EINH20161216130414041178308");
		tPatientSurgeryInfo.setEmrId("1");
		tPatientSurgeryInfo.setSurgeryDate(sdf.parse("2011-06-18 00:00:00"));
		
		tPatientSurgeryInfo.setOpCode("00.4101");
		tPatientSurgeryInfo.setSurgeryName("两支血管的操作");
		tPatientSurgeryInfo.setSurgeryDoctor(10522);
		tPatientSurgeryInfo.setSurgeryDoctorName("张瑛");
		tPatientSurgeryInfo.setSurgeryAssistant1(10522);
		
		tPatientSurgeryInfo.setSurgeryAssistant1Name("张瑛");
		tPatientSurgeryInfo.setSurgeryAssistant2(10522);
		tPatientSurgeryInfo.setSurgeryAssistant2Name("张瑛");
		tPatientSurgeryInfo.setIncisionHealingId(0);
		tPatientSurgeryInfo.setAnesthesiaWayId(1000);
		
		tPatientSurgeryInfo.setAnesthesiaWay("全身麻醉");
		tPatientSurgeryInfo.setAnesthesiaDoctor(10522);
		tPatientSurgeryInfo.setAnesthesiaDoctorName("张瑛");
		tPatientSurgeryInfo.setOpLevel(1);
		tPatientSurgeryInfo.setSerialNum(0);
		
		List<TPatientSurgeryInfo> tPatientSurgeryInfoList = new ArrayList<TPatientSurgeryInfo>(); 
		tPatientSurgeryInfoList.add(tPatientSurgeryInfo);
		
		TInhospitalDetailInfo tInhospitalDetailInfo1 = new TInhospitalDetailInfo();
		tInhospitalDetailInfo1.setInhospitalId("EINH20161216130414041178308");
		
		// 放到主类中
//		req.setVisitType(1);
		req.setPatientNo("191930815");
		req.setHospitalId(19193);
//		req.setOperatorId(19046l);
//		req.setPatientId(3123300l);
//		req.setSurgeryList(tPatientSurgeryInfoList);
//		req.setInhospitalDetailInfo(tInhospitalDetailInfo1);
		
		// *********************************************************************************************
		
		// 重症 - 测试通过
		TPatientSurgeryIntensiveCareInfo tPatientSurgeryIntensiveCareInfo = new TPatientSurgeryIntensiveCareInfo();
		tPatientSurgeryIntensiveCareInfo.setIntensiveCareName("01");
		tPatientSurgeryIntensiveCareInfo.setInIntensiveCareTime(sdf.parse("2011-06-15 00:00:00"));
		tPatientSurgeryIntensiveCareInfo.setOutIntensiveCareTime(sdf.parse("2011-06-18 00:00:59"));
		
		List<TPatientSurgeryIntensiveCareInfo> tPatientSurgeryIntensiveCareInfoList = new ArrayList<TPatientSurgeryIntensiveCareInfo>();
		tPatientSurgeryIntensiveCareInfoList.add(tPatientSurgeryIntensiveCareInfo);
		
		TInhospitalDetailInfo tInhospitalDetailInfo2 = new TInhospitalDetailInfo();
		tInhospitalDetailInfo2.setInhospitalId("EINH20161216130414041178308");
		
		// 放到主类中
//		req.setSurgeryIntensiveCareList(tPatientSurgeryIntensiveCareInfoList);
//		req.setInhospitalDetailInfo(tInhospitalDetailInfo2);
		
		// *********************************************************************************************
		
		// 治疗及用药 - 测试成功
		// 1.化疗方案或靶向用药明细元数据表 meta_e_treatment_scheme_item_medication 数据
		TreatmentChemotherapyMedicationDetailInfo treatmentChemotherapyMedicationDetailInfo = new TreatmentChemotherapyMedicationDetailInfo();
		treatmentChemotherapyMedicationDetailInfo.setTreatmentTypeId(2);
		treatmentChemotherapyMedicationDetailInfo.setTreatmentName("PF");
		treatmentChemotherapyMedicationDetailInfo.setTreatmentId("ETRE2017040816010410001122494723");
		treatmentChemotherapyMedicationDetailInfo.setHospitalId(19193);
		treatmentChemotherapyMedicationDetailInfo.setMedicationName("卡铂");
		
		treatmentChemotherapyMedicationDetailInfo.setTreatmentSchemeId(252);
		treatmentChemotherapyMedicationDetailInfo.setMeasurementUnitName("g");
		treatmentChemotherapyMedicationDetailInfo.setRoute(1);
		treatmentChemotherapyMedicationDetailInfo.setFrequency(1);
		
		List<TreatmentChemotherapyMedicationDetailInfo> treatmentChemotherapyMedicationDetailInfoList = new ArrayList<TreatmentChemotherapyMedicationDetailInfo>();
		treatmentChemotherapyMedicationDetailInfoList.add(treatmentChemotherapyMedicationDetailInfo);
		
		// 2.化疗主表eci_treatment_chemotherapy_medication 数据
		TreatmentChemotherapyMedicationInfo treatmentChemotherapyMedicationInfo = new TreatmentChemotherapyMedicationInfo();
		// 添加上面元素数据
		treatmentChemotherapyMedicationInfo.setChemotherapyMedicationDetailInfos(treatmentChemotherapyMedicationDetailInfoList);
		treatmentChemotherapyMedicationInfo.setChemotherapyType(1);
		treatmentChemotherapyMedicationInfo.setChemotherapyTypeDesc("全身化疗");
		treatmentChemotherapyMedicationInfo.setHospitalId(19193);
		treatmentChemotherapyMedicationInfo.setSchemeCategory("1");
		
		treatmentChemotherapyMedicationInfo.setSchemeCategoryDesc("一线化疗");
		
		// 3.治疗总表-eci_treatment_note
		TPatientTreatmentInfo tPatientTreatmentInfo = new TPatientTreatmentInfo();
		// 添加上面化疗数据
		tPatientTreatmentInfo.setChemotherapyMedication(treatmentChemotherapyMedicationInfo);
		tPatientTreatmentInfo.setTreatmentTypeId(2);
		tPatientTreatmentInfo.setSourceFlag(2);
		tPatientTreatmentInfo.setInhospitalId("EINH2016121613041443364843555497");
		tPatientTreatmentInfo.setPatientId(785420l);
		
		tPatientTreatmentInfo.setEmrId("1");
		tPatientTreatmentInfo.setTreatmentId("ETRE2017040816010410001122494723");
		// 此处少了一个hospitalId
		tPatientTreatmentInfo.setTreatmentTypeName("化疗");
		tPatientTreatmentInfo.setTreatmentName("PF");
		tPatientTreatmentInfo.setTreatmentSchemeId(252);
		
		tPatientTreatmentInfo.setTreatmentCourse("1");
		tPatientTreatmentInfo.setTotalCourse("2");
		tPatientTreatmentInfo.setTreatmentBeginTime(sdf.parse("2017-09-19 00:00:00"));
		tPatientTreatmentInfo.setTreatmentEndTime(sdf.parse("2017-09-20 23:59:59"));
		tPatientTreatmentInfo.setTreatmentProcessFlag(1);
		
		tPatientTreatmentInfo.setTreatmentEffect("NE（无法评估）");
		tPatientTreatmentInfo.setSpecialDiseaseRegisterId(110l);
		
		List<TPatientTreatmentInfo> tPatientTreatmentInfoList = new ArrayList<TPatientTreatmentInfo>();
		tPatientTreatmentInfoList.add(tPatientTreatmentInfo);
		
		// 4.修改状态标识
		PatientMedicalRecordModifyFlag patientMedicalRecordModifyFlag = new PatientMedicalRecordModifyFlag();
		patientMedicalRecordModifyFlag.setInhospitalDetailModifyFlag(0);
		patientMedicalRecordModifyFlag.setPatientClinicInfoModifyFlag(0);
		patientMedicalRecordModifyFlag.setDiagnosisModifyFlag(0);
		patientMedicalRecordModifyFlag.setSurgeryTreatmentModifyFlag(0);
		
		// 放到主类中
		// 治疗总表
//		req.setTreatmentList(tPatientTreatmentInfoList);
		// 修改状态标识
//		req.setModifyFlag(patientMedicalRecordModifyFlag);
//		req.setPatientId(3123300l);
//		req.setHospitalId(34946);
		// 此处少了一个inhospitalId
//		req.setOperatorId(19046l);
		
		// *********************************************************************************************
		
		// 发现与发病
		// 1.症状表
		PatientSymptomInfo patientSymptomInfo = new PatientSymptomInfo();
		patientSymptomInfo.setPatientNo("1407748");
		patientSymptomInfo.setSymptomName("心悸");
		patientSymptomInfo.setSymptomTypeId(1);
		patientSymptomInfo.setPatientId(785420l);
		patientSymptomInfo.setOperatorId(19046l);
		patientSymptomInfo.setVisitTime(sdf.parse("2017-09-21 00:00:00"));
		patientSymptomInfo.setInhospitalId("EINH2016121613041443364843555497");
		patientSymptomInfo.setEmrId("1");
		patientSymptomInfo.setSustainTime("1");
		patientSymptomInfo.setSustainTimeUnit(1);
		
		List<PatientSymptomInfo> patientSymptomInfoList = new ArrayList<PatientSymptomInfo>();
		patientSymptomInfoList.add(patientSymptomInfo);
		
		// 2.肿瘤家族史表
		TumourFamilyHistoryInfo tumourFamilyHistoryInfo = new TumourFamilyHistoryInfo();
		tumourFamilyHistoryInfo.setRelationId(0);
		tumourFamilyHistoryInfo.setRelationName("本人");
		tumourFamilyHistoryInfo.setDiseaseTypeId("1");
		tumourFamilyHistoryInfo.setDiseaseTypeName("鼻咽癌");
		tumourFamilyHistoryInfo.setMorbidityTime(sdf.parse("2017-09-21 00:00:00"));
		tumourFamilyHistoryInfo.setInhospitalId("EINH2016121613041443364843555497");
		tumourFamilyHistoryInfo.setPatientId(785420l);
		
		List<TumourFamilyHistoryInfo> tumourFamilyHistoryInfoList = new ArrayList<TumourFamilyHistoryInfo>();
		tumourFamilyHistoryInfoList.add(tumourFamilyHistoryInfo);
		
		// 3.危险因素表
		RiskfactorsInfo riskfactorsInfo = new RiskfactorsInfo();
		riskfactorsInfo.setInhospitalId("EINH20161216130414041178308");
		riskfactorsInfo.setPatientId(3123300l);
		riskfactorsInfo.setRiskfactorsTypeId("1,2,3,4,5");
		
		// 吸烟
		RiskfactorsSmokeInfo riskfactorsSmokeInfo = new RiskfactorsSmokeInfo();
		riskfactorsSmokeInfo.setFirstAge(1);
		riskfactorsSmokeInfo.setSustainYear(1);
		riskfactorsSmokeInfo.setDailyCount(1);
		riskfactorsSmokeInfo.setAbstainYear(1);
		riskfactorsSmokeInfo.setPassivitySmoke(1);
		riskfactorsInfo.setSmokeInfo(riskfactorsSmokeInfo);
		
		// 喝酒
		RiskfactorsSotInfo riskfactorsSotInfo = new RiskfactorsSotInfo();
		riskfactorsSotInfo.setFirstAge(1);
		riskfactorsSotInfo.setSustainYear(1);
		riskfactorsSotInfo.setDailyMil(1);
		riskfactorsSotInfo.setAbstainYear(1);
		riskfactorsSotInfo.setDrinkTypeId("1");
		riskfactorsSotInfo.setWeekCount(1);
		riskfactorsSotInfo.setMonthCount(1);
		riskfactorsSotInfo.setYearCount(1);
		riskfactorsInfo.setSotInfo(riskfactorsSotInfo);
		
		// 饮食
		RiskfactorsFoodInfo riskfactorsFoodInfo = new RiskfactorsFoodInfo();
		riskfactorsFoodInfo.setFoodDes("1");
		riskfactorsInfo.setFoodInfo(riskfactorsFoodInfo);
		
		// 锻炼
		RiskfactorsExerciseInfo riskfactorsExerciseInfo = new RiskfactorsExerciseInfo();
		riskfactorsExerciseInfo.setSustainYear(1);
		riskfactorsExerciseInfo.setWeekCount(1);
		riskfactorsExerciseInfo.setEveryTimeMinute(1);
		riskfactorsExerciseInfo.setExerciseWay("1,2,3");		
		riskfactorsInfo.setExerciseInfo(riskfactorsExerciseInfo);
		
		// 睡眠
		RiskfactorsSleepInfo riskfactorsSleepInfo = new RiskfactorsSleepInfo();
		riskfactorsSleepInfo.setSleepDes(1);
		riskfactorsInfo.setSleepInfo(riskfactorsSleepInfo);
		
		TInhospitalDetailInfo tInhospitalDetailInfo3 = new TInhospitalDetailInfo();
		tInhospitalDetailInfo3.setInhospitalId("EINH20161216130414041178308");
		
		// 放到主类中
		PresentationMorbidityInfo presentationMorbidity = new PresentationMorbidityInfo();
		presentationMorbidity.setSymptomList(patientSymptomInfoList);
		presentationMorbidity.setFamilyHistoryList(tumourFamilyHistoryInfoList);
		presentationMorbidity.setRiskfactors(riskfactorsInfo);
//		req.setPresentationMorbidity(presentationMorbidity);
//		req.setSymptomList(patientSymptomInfoList);
//		req.setTumourFamilyHistoryList(tumourFamilyHistoryInfoList);
//		req.setRiskfactors(riskfactorsInfo);
//		req.setInhospitalDetailInfo(tInhospitalDetailInfo3);
		// 此处少个inhospitalId
//		req.setPatientId(3123300l);
//		req.setOperatorId(19046l);
		
		// *********************************************************************************************
		
		// 体格检查情况 - 测试通过
		// 1.常规体检项目
		GenenalExaminationInfo genenalExaminationInfo = new GenenalExaminationInfo();
		genenalExaminationInfo.setCheckDate(sdf.parse("2017-09-19 00:00:00"));
		genenalExaminationInfo.setHight(1);
		genenalExaminationInfo.setWeightLof(2000f);
		genenalExaminationInfo.setHeartRate(3);
		genenalExaminationInfo.setPulse(5);
		
		genenalExaminationInfo.setTemperature(8f);
		genenalExaminationInfo.setWaist(10f);
		genenalExaminationInfo.setNutritionStateId(1);
		genenalExaminationInfo.setBodilyId(1);
		genenalExaminationInfo.setIntonationId(1);
		
		genenalExaminationInfo.setBodyPositionId(1);
		genenalExaminationInfo.setGaitId(1);
		genenalExaminationInfo.setWeight(2f);
		genenalExaminationInfo.setBodyArea(-0.5700000000000001f);
		genenalExaminationInfo.setBreath(4);

		genenalExaminationInfo.setBloodHigh(6f);
		genenalExaminationInfo.setBloodLow(7f);
		genenalExaminationInfo.setHipline(9f);
		genenalExaminationInfo.setBust(111f);
		genenalExaminationInfo.setConsciouStateId(1);

		genenalExaminationInfo.setDevelopmentId(1);
		genenalExaminationInfo.setFaceId(1);
		genenalExaminationInfo.setPosture("12");
		genenalExaminationInfo.setPatientId(785420l);
		genenalExaminationInfo.setInhospitalId("EINH2016121613041443364843555497");
		
		// 2.体征情况
		PhysicalSigns physicalSigns = new PhysicalSigns();
		physicalSigns.setPhysicalSignsId(3);
		physicalSigns.setPhysicalSignsName("头部检查");
		physicalSigns.setSignsStatus(2);
		physicalSigns.setDescription("");
		physicalSigns.setCheckDate(sdf.parse("2017-09-19 00:00:00"));
		
		physicalSigns.setPatientId(785420l);
		physicalSigns.setInhospitalId("EINH2016121613041443364843555497");
		
		List<PhysicalSigns> physicalSignsList = new ArrayList<PhysicalSigns>();
		physicalSignsList.add(physicalSigns);
		GenenalExamSignsInfo genenalExamSignsInfo = new GenenalExamSignsInfo();
		genenalExamSignsInfo.setGenenalExamination(genenalExaminationInfo);
		genenalExamSignsInfo.setPhysicalSigns(physicalSignsList);
//		req.setGenenalExamSignsInfo(genenalExamSignsInfo);
		// 放到主类中
//		req.setGenenalPhysicalExaminationInfo(genenalExaminationInfo);
//		req.setPhysicalSignsList(physicalSignsList);
		
		// *********************************************************************************************
		
		// 身体状况评分 - 测试通过
		QualityoflifeInfo qualityoflifeInfo = new QualityoflifeInfo();
		qualityoflifeInfo.setVisitTime(sdf.parse("2017-09-19 00:00:00"));
		qualityoflifeInfo.setKpsValue(0);
		qualityoflifeInfo.setEcogValue(5);
		qualityoflifeInfo.setDeathDate(sdf.parse("2017-09-19 00:00:00"));
		qualityoflifeInfo.setIsTumourDeath(1);
		qualityoflifeInfo.setPatientId(3123300l);
		qualityoflifeInfo.setPatientNo("191930815");
		qualityoflifeInfo.setRemark("生产质量描述--生产质量描述--生产质量描述");
		qualityoflifeInfo.setInhospitalId("EINH20161216130414041178308");
		
		// 放到主类中
//		req.setQualityoflifeInfo(qualityoflifeInfo);
		
		// *********************************************************************************************
		
		// 不良反应情况 - 测试通过
		AdverseReactionResultInfo adverseReactionResultInfo = new AdverseReactionResultInfo();
		adverseReactionResultInfo.setAdverseReactionId(1);
		adverseReactionResultInfo.setAdverseReactionName("贫血");
		adverseReactionResultInfo.setBeginTime(sdf.parse("2017-09-17 00:00:00"));
		adverseReactionResultInfo.setEndTime(sdf.parse("2017-09-18 23:59:59"));
		adverseReactionResultInfo.setLevel(1);
		adverseReactionResultInfo.setTakeSteps("合并用药");
		adverseReactionResultInfo.setResearchRelationship("1");
		adverseReactionResultInfo.setTheOutcomeId(1);
		adverseReactionResultInfo.setTheOutcome("痊愈无后遗症");
		adverseReactionResultInfo.setPatientId(785420l);
		adverseReactionResultInfo.setInhospitalId("EINH2016121613041443364843555497");
		List<AdverseReactionResultInfo> AdverseReactionResultInfoList = new ArrayList<AdverseReactionResultInfo>();
		AdverseReactionResultInfoList.add(adverseReactionResultInfo);
		
		// 放到主类中
		req.setAdverseReactionResultList(AdverseReactionResultInfoList);
		
		// *********************************************************************************************
		
		// 记录日志
		TInhospitalDetailInfo tInhospitalDetailInfo4 = new TInhospitalDetailInfo();
		tInhospitalDetailInfo4.setInhospitalId("EINH20161216130414041178308");
		
		PatientClinicInfo patientClinicInfo1 = new PatientClinicInfo();
		patientClinicInfo1.setClinicMedicalId("");
		req.setOperatorId(3l);
		req.setInhospitalId("EINH201612161304141000148988081");
		req.setPatientId(617086l);
		req.setVisitType(1);
		req.setInhospitalDetailInfo(tInhospitalDetailInfo);
//		req.setPatientClinicInfo(patientClinicInfo1);
		
		
		
		// *********************************************************************************************
		
		System.out.println(JsonUtil.toJson(req));
		
		MockHttpServletRequestBuilder post = post("/patient/medicalrecord/save").content(JsonUtil.toJson(req)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(( post))
								  .andExpect(status().isOk())
								  .andDo(print())
								  .andReturn();
		logger.info("result=\n"+result.getResponse().getContentAsString());
	}
	
}

