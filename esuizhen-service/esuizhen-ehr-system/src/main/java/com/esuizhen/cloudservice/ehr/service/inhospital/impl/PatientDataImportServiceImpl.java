package com.esuizhen.cloudservice.ehr.service.inhospital.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.common.Common;
import com.esuizhen.cloudservice.ehr.dao.diagnose.TDiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.dao.hospitalinfo.HospitalPatientDao;
import com.esuizhen.cloudservice.ehr.dao.hospitalinfo.THospitalDeptInfoDao;
import com.esuizhen.cloudservice.ehr.dao.inhospital.TInhospitalDetailInfoDao;
import com.esuizhen.cloudservice.ehr.dao.inhospitalcost.TInhospitalCostInfoDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoAnesthesiaWayDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoDoctorDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoNationDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoNationalityDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoPayChannelDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetainfoOccupationDao;
import com.esuizhen.cloudservice.ehr.dao.meta.TMetaInfoIncisionHealingDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.PatientFamilyDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TPatientInfoDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TUserInfoDao;
import com.esuizhen.cloudservice.ehr.dao.treatment.PatientSurgeryDao;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.model.hospitalinfo.THospitalDeptInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.model.inhospitalcost.TInhospitalCostInfo;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoAnesthesiaWay;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDoctor;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoIncisionHealing;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNation;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoNationality;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoOccupation;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientProfile;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TUserInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;
import com.esuizhen.cloudservice.ehr.service.inhospital.PatientDataImportService;
import com.esuizhen.cloudservice.ehr.service.patientinfo.TPatientInfoService;
import com.esuizhen.cloudservice.ehr.util.BigDecimalExt;
import com.esuizhen.cloudservice.ehr.util.FileReaderWriterUtils;
import com.esuizhen.cloudservice.ehr.util.PoiUtils;
import com.westangel.common.bean.DoctorPatient;
import com.westangel.common.bean.HospitalSearchReq;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;

@Transactional(rollbackFor = Exception.class)
@Service
public class PatientDataImportServiceImpl implements PatientDataImportService {
	@Autowired
	private TUserInfoDao userInfoDao;

	@Autowired
	private TPatientInfoDao patientInfoDao;
	@Autowired
	private TInhospitalDetailInfoDao inhospitalDetailInfoDao;
	@Autowired
	private TDiagnosisInfoDao<TDiagnosisInfo> diagnosisInfoDao;
	@Autowired
	PatientSurgeryDao patientSurgeryDao;
	@Autowired
	private TInhospitalCostInfoDao inhospitalCostInfoDao;
	@Autowired
	private MetaInfoPayChannelDao payChannelDao;
	@Autowired
	private MetaInfoNationalityDao nationalityDao;
	@Autowired
	private MetaInfoNationDao nationDao;
	@Autowired
	private MetainfoOccupationDao occupationDao;
	@Autowired
	private THospitalDeptInfoDao hospitalDeptInfoDao;
	@Autowired
	private MetaInfoDoctorDao doctorDao;
	@Autowired
	private TMetaInfoIncisionHealingDao<TMetaInfoIncisionHealing> incisionHealingDao;

	@Autowired
	private TPatientInfoService patientInfoService;

	@Autowired
	private HospitalPatientDao hospitalPatientDao;

	@Autowired
	private MetaInfoAnesthesiaWayDao metaInfoAnesthesiaWayDao;
	@Autowired
	private PatientFamilyDao patientFamilyDao;

	public static Logger log = LoggerFactory.getLogger("importPatientLog");

	@Override
	public int importInhospitalInfo(InputStream in, int type, String templateFileName, HttpSession session) throws Exception {
		int res = 0;
		/**
		 * 先检查表头是否与模板定义的表头长度一样,并且是连续的。
		 * 提取机构名称，通过机构名称检索机构信息，如果存在，放入map中，不存在则插入一条机构信息。 提取病案号，通过病案号查询患者基本信息，
		 * 如果存在，放入map，不存在则插入一条患者记录。（查询患者基本信息是，先检查map里面是否有病案号）
		 * 元数据字段与库里面的元数据是否匹配，不匹配，填写与数据库不匹配等字样。 插入之前检查是否有重复记录 进行插入操作
		 */
		String path = Common.IMPORT_LOG;
		LogUtil.log.info("templateFileName = " + templateFileName);
		if (StringUtils.isEmpty(templateFileName)) {
			templateFileName = "tt.txt";
		}
		FileReaderWriterUtils frw = new FileReaderWriterUtils(path + templateFileName + ".txt", true);

		List<TMetaInfoIncisionHealing> incisionHealingList = incisionHealingDao.selectByListAll();

		List<String[]> list = PoiUtils.readRecordsInputStream(in, type, false, 0);
		int total = list.size() - 1; // 总条数
		frw.writeLine("导入中，请稍后....    0/" + total);
		int repeat = 0; // 重复记录条数
		int fail = 0; // 导入失败条数
		for (int i = 1; i < list.size(); i++) {
			try {
				session.setAttribute(templateFileName, i);
				ServletContext context = session.getServletContext();
				context.setAttribute("session", session);
				LogUtil.log.info("templateFileName :" + context.getAttribute("session"));
				LogUtil.log.info("##########templateFileName###############:" + session.getAttribute(templateFileName));
				TUserInfo userInfo = null;
				TPatientInfo patient = null;
				TInhospitalDetailInfo inhospitalinfo = null;
				TInhospitalCostInfo costInfo = null;

				String hospitalName = list.get(i)[0];
				String patientNo = list.get(i)[4];
				if (StringUtils.isEmpty(patientNo) || StringUtils.isEmpty(hospitalName)) {
					LogUtil.log.info("第" + i + "条， 医院名字和病案号不能为空！");
					fail++;
					frw.writeLine("第" + i + "行导入失败，原因：医院名字和病案号为空！");
					continue;
				}
				Date inHospitalDate = null;
				if (StringUtils.isNotEmpty(list.get(i)[32])) {
					inHospitalDate = DateUtil.stringToDate(list.get(i)[32], "yyyy-MM-dd");
				}
				// TODO;根据patientNo, hospitalName，入院时间进行判断，如果存在就不插入，如果patientNo,
				// hospitalName存在，就更新patient,user表，关系表不管，其他表插入

				TPatientProfile tPatientProfile = patientInfoDao.queryPatientByHospitalName(patientNo, hospitalName);
				if (tPatientProfile != null) {
					if (inHospitalDate != null) {

						Map<String, Object> paraMap = new HashMap<String, Object>();
						paraMap.put("patientId", tPatientProfile.getPatientId());
						// paraMap.put("patientNo",
						// tPatientProfile.getPatientNo());
						paraMap.put("inhospitalDate", inHospitalDate);
						List<TInhospitalInfo> inhospitalInfoList = inhospitalDetailInfoDao.queryInhospitalInfoByPatientId(paraMap);
						if (inhospitalInfoList != null && inhospitalInfoList.size() > 0) {
							LogUtil.log.info("医院名称为：" + hospitalName + ", 病案号为：" + patientNo + "的记录，已经导入过了，不可重复导入！");
							frw.writeLine("第" + i + "行患者住院记录已存在；");
							repeat++;
							continue;
						}
					}
				}

				// 录入住院信息
				Integer hospitalId = null;
				if (StringUtils.isNotEmpty(hospitalName)) {
					List<HospitalSearchReq> hospitalList = userInfoDao.queryHospitalByName(hospitalName);
					if (hospitalList != null && hospitalList.size() > 0) {
						hospitalId = hospitalList.get(0).getHospitalId();
					}
				}

				if (hospitalId == null) {
					fail++;
					frw.writeLine("第" + i + "行导入失败，原因：医院不存在！");
					LogUtil.log.info("第" + i + "行导入失败，原因：医院不存在！");
					continue;
				}
				userInfo = new TUserInfo();
				patient = new TPatientInfo();
				inhospitalinfo = new TInhospitalDetailInfo();
				costInfo = new TInhospitalCostInfo();

				// 用户信息
				String sex = list.get(i)[6];
				Integer sexId = 0;
				if (StringUtils.isNotEmpty(sex)) {
					if (sex.equals("女") || sex.equals("2")) {
						sexId = 2;
					} else if (sex.equals("男") || sex.equals("1")) {
						sexId = 1;
					}
				}
				String country = list.get(i)[9];
				Integer nationalityId = null;
				if (StringUtils.isNotEmpty(country)) {
					List<TMetaInfoNationality> nationalityList = nationalityDao.getMetaInfoNationalityListByName(country);
					if (nationalityList != null && nationalityList.size() > 0) {
						nationalityId = nationalityList.get(0).getNationalityId();
					}
				}
				String nation = list.get(i)[15];
				Integer nationId = null;
				if (StringUtils.isNotEmpty(nation)) {
					List<TMetaInfoNation> nationList = nationDao.getMetaInfoNationListByName(nation);
					if (nationList != null && nationList.size() > 0) {
						nationId = nationList.get(0).getNationId();
					}
				}
				String profession = list.get(i)[17];
				Integer occupationId = null;
				if (StringUtils.isNotEmpty(profession)) {
					List<TMetaInfoOccupation> occupationList = occupationDao.getMetaInfoOccupationListByName(profession);
					if (occupationList != null && occupationList.size() > 0) {
						occupationId = occupationList.get(0).getOccupationId();
					}
				}
				String marriageStatus = list.get(i)[18];
				Integer marriageStatusInt = null;
				if (StringUtils.isNotEmpty(marriageStatus)) {

					if (marriageStatus.equals("未婚") || marriageStatus.equals("1")) {
						marriageStatusInt = 1;
					}
					if (marriageStatus.equals("已婚") || marriageStatus.equals("2")) {
						marriageStatusInt = 2;
					}
					if (marriageStatus.equals("丧偶") || marriageStatus.equals("3")) {
						marriageStatusInt = 3;
					}
					if (marriageStatus.equals("离婚") || marriageStatus.equals("4")) {
						marriageStatusInt = 4;
					}
					if (marriageStatus.equals("其他") || marriageStatus.equals("9")) {
						marriageStatusInt = 9;
					}
				}
				userInfo.setSex(sexId);
				userInfo.setTrueName(list.get(i)[5]);
				userInfo.setBirthDate(DateUtil.stringToDate(list.get(i)[7], "yyyy-MM-dd"));
				userInfo.setNationalityId(nationalityId);
				userInfo.setCountry(country);
				userInfo.setBirthPlaceAddress(list.get(i)[13]);
				userInfo.setNativePlace(list.get(i)[14]);
				userInfo.setNationId(nationId);
				userInfo.setNation(nation);
				userInfo.setIdentification(list.get(i)[16]);
				userInfo.setOccupationId(occupationId);
				userInfo.setProfession(profession);
				// 1未婚、2已婚、3丧偶、4离婚、9其他
				userInfo.setMarriageStatus(marriageStatusInt);
				userInfo.setAddress(list.get(i)[19]);
				String phone = list.get(i)[20];
				String mobile = null;
				if (StringUtils.isNotEmpty(phone) && phone.startsWith("1")) {
					mobile = phone;
				}
				userInfo.setMobile(mobile);

				// 患者信息
				patient.setPatientNo(list.get(i)[4]);
				patient.setTrueName(userInfo.getTrueName());
				patient.setMobile(mobile);
				patient.setFamilyPhone(phone);
				patient.setSex(userInfo.getSex());
				patient.setBirthDate(userInfo.getBirthDate());
				patient.setLiveStatus(1);
				patient.setCreateTime(new Date());
				patient.setUpdateTime(new Date());
				String medicalPayType = list.get(i)[1];
				if (StringUtils.isNotEmpty(medicalPayType)) {
					patient.setMedicalPayType(Integer.parseInt(medicalPayType));
				}
				// Integer payChannelId = null;
				// if(StringUtils.isNotEmpty(medicalPayType)){
				// List<TMetaInfoPayChannel> payChannelList =
				// payChannelDao.getMetaInfoPayChannelList(null);
				// if(payChannelList != null && payChannelList.size() > 0){
				// payChannelId = payChannelList.get(0).getPayChannelId();
				// }
				// }
				PatientFamily patientFamily = new PatientFamily();
				patientFamily.setFamilyName(list.get(i)[27]);
				if (StringUtils.isNotEmpty(list.get(i)[28])) {
					try {
						patientFamily.setPatientRelation(Integer.parseInt(list.get(i)[28]));
					} catch (Exception e) {
						LogUtil.log.info("setPatientRelation===" + e.getMessage());
					}
				}
				patientFamily.setFamilyPhone(list.get(i)[30]);
				patientFamily.setAddress(list.get(i)[29]);
				patientFamily.setZipcode(list.get(i)[26]);

				PatientFamily patientFamilyNow = new PatientFamily();
				patientFamilyNow.setFamilyPhone(list.get(i)[20]);
				patientFamilyNow.setAddress(list.get(i)[19]);
				patientFamilyNow.setZipcode(list.get(i)[21]);
				patientFamilyNow.setFamilyName(list.get(i)[5]);
				patientFamilyNow.setPatientRelation(0);

				PatientFamily patientFamilyRegist = new PatientFamily();
				// patientFamilyRegist.setFamilyPhone("0");
				patientFamilyRegist.setAddress(list.get(i)[22]);
				patientFamilyRegist.setZipcode(list.get(i)[23]);
				patientFamilyRegist.setFamilyName(list.get(i)[5]);
				patientFamilyRegist.setPatientRelation(14);

				PatientFamily patientFamilyCompany = new PatientFamily();
				patientFamilyCompany.setAddress(list.get(i)[24]);
				patientFamilyCompany.setFamilyPhone(list.get(i)[25]);
				patientFamilyCompany.setZipcode(list.get(i)[26]);
				patientFamilyCompany.setFamilyName(list.get(i)[5]);
				patientFamilyCompany.setPatientRelation(15);

				List<PatientFamily> patientFamilyList = new ArrayList<PatientFamily>();
				patientFamilyList.add(patientFamily);
				patientFamilyList.add(patientFamilyNow);
				patientFamilyList.add(patientFamilyRegist);
				patientFamilyList.add(patientFamilyCompany);
				String inhospitalWay = list.get(i)[31];
				Integer inhospitalWayInt = null;
				if (StringUtils.isNotEmpty(inhospitalWay)) {

					if (inhospitalWay.equals("急诊") || inhospitalWay.equals("1")) {
						inhospitalWayInt = 1;
					}
					if (inhospitalWay.equals("门诊") || inhospitalWay.equals("2")) {
						inhospitalWayInt = 2;
					}
					if (inhospitalWay.equals("其他医疗机构转入") || inhospitalWay.equals("3")) {
						inhospitalWayInt = 3;
					}
					if (inhospitalWay.equals("其他") || inhospitalWay.equals("9")) {
						inhospitalWayInt = 9;
					}
				}
				String inhospitalDepName = list.get(i)[34];
				Integer inhospitalDeptId = null;
				List<THospitalDeptInfo> hospitalDeptList = hospitalDeptInfoDao.getHospitalDeptList(Long.valueOf(hospitalId));
				Iterator<THospitalDeptInfo> hospitalDeptItor = hospitalDeptList.iterator();
				while (hospitalDeptItor.hasNext()) {
					THospitalDeptInfo hospitalDept = hospitalDeptItor.next();
					if (StringUtils.isNotEmpty(inhospitalDepName) && hospitalDept.getDeptName().contains(inhospitalDepName)) {
						inhospitalDeptId = hospitalDept.getDeptId();
						break;
					}
				}
				String turnDeptName = list.get(i)[36];
				Integer turnDeptId = null;
				while (hospitalDeptItor.hasNext()) {
					THospitalDeptInfo hospitalDept = hospitalDeptItor.next();
					if (StringUtils.isNotEmpty(turnDeptName) && hospitalDept.getDeptName().contains(turnDeptName)) {
						turnDeptId = hospitalDept.getDeptId();
						break;
					}
				}
				String outhospitalDeptName = list.get(i)[39];
				Integer outhospitalDeptId = null;
				while (hospitalDeptItor.hasNext()) {
					THospitalDeptInfo hospitalDept = hospitalDeptItor.next();
					if (StringUtils.isNotEmpty(outhospitalDeptName) && hospitalDept.getDeptName().contains(outhospitalDeptName)) {
						outhospitalDeptId = hospitalDept.getDeptId();
						break;
					}
				}

				String inhospitalWard = list.get(i)[35];
				String outhospitalWard = list.get(i)[40];
				String diagnose = list.get(i)[42];
				String diseaseCode = list.get(i)[43];
				String mainDiagnosis = list.get(i)[44];
				String mainDiagnosisCode = list.get(i)[45];
				String inhospitalCondition = list.get(i)[46];
				Integer inhospitalConditionInt = null;
				if (inhospitalCondition.matches("\\d+")) {
					inhospitalConditionInt = Integer.parseInt(inhospitalCondition);
				} else {
					inhospitalConditionInt = 4;// 无
				}
				inhospitalinfo.setHospitalId(hospitalId);
				if (StringUtils.isNotEmpty(list.get(i)[28])) {
					inhospitalinfo.setPatientRelation(Integer.parseInt(list.get(i)[28]));
				}
				inhospitalinfo.setRecHospitalName(hospitalName);
				inhospitalinfo.setHospitalName(hospitalName);
				if (StringUtils.isNotEmpty(list.get(i)[1])) {
					inhospitalinfo.setMedicalPayType(Integer.parseInt(list.get(i)[1]));
				}
				inhospitalinfo.setHealthCardNo(list.get(i)[2]);
				inhospitalinfo.setInhospitalTimes(Integer.valueOf(list.get(i)[3]));
				inhospitalinfo.setAge(Integer.valueOf(list.get(i)[8]));
				if (nationalityId != null) {
					inhospitalinfo.setNationalityId(nationalityId);
				}
				String babyAge = list.get(i)[10];
				String babyBornWeight = list.get(i)[11];
				String babyWeightInHospital = list.get(i)[12];
				if (babyAge.matches("\\d+")) {
					inhospitalinfo.setBabyAge(babyAge);
				}
				if (babyBornWeight.matches("\\d+")) {
					inhospitalinfo.setBabyBornWeight(babyBornWeight);
				}
				if (babyWeightInHospital.matches("\\d+")) {
					inhospitalinfo.setBabyWeightInHospital(babyWeightInHospital);
				}
				inhospitalinfo.setNativePlaceAddress(list.get(i)[14]);
				inhospitalinfo.setIdentification(list.get(i)[16]);
				if (StringUtils.isNotEmpty(list.get(i)[17])) {
					inhospitalinfo.setOccupationId(Integer.parseInt(list.get(i)[17]));
				}
				if (StringUtils.isNotEmpty(list.get(i)[18])) {
					inhospitalinfo.setMarriageStatus(marriageStatusInt);
				}
				inhospitalinfo.setLiveAddress(list.get(i)[19]);
				inhospitalinfo.setLiveTel(list.get(i)[20]);
				inhospitalinfo.setLiveZipCode(list.get(i)[21]);
				inhospitalinfo.setHouseholdAddress(list.get(i)[22]);
				inhospitalinfo.setHouseholdZipCode(list.get(i)[23]);
				inhospitalinfo.setCompanyAddress(list.get(i)[24]);
				inhospitalinfo.setCompanyTel(list.get(i)[25]);
				inhospitalinfo.setCompanyZipCode(list.get(i)[26]);
				inhospitalinfo.setFamilyName(list.get(i)[27]);
				// 缺联系人关系
				inhospitalinfo.setFamilyAddress(list.get(i)[29]);
				inhospitalinfo.setFamilyTel(list.get(i)[30]);
				// 1、急诊2、门诊3、其他医疗机构转入9、其他
				inhospitalinfo.setInhospitalWay(inhospitalWayInt);
				// 需要加上小时list.get(i)[32]+list.get(i)[33]
				if (StringUtils.isNotEmpty(list.get(i)[32])) {
					inhospitalinfo.setInhospitalDate(DateUtil.stringToDate(list.get(i)[32], "yyyy-MM-dd"));
				}
				inhospitalinfo.setInhospitalDeptName(inhospitalDepName);
				inhospitalinfo.setInhospitalDeptId(inhospitalDeptId);
				inhospitalinfo.setInhospitalWard(inhospitalWard);
				inhospitalinfo.setTurnDeptId(turnDeptId);
				inhospitalinfo.setTurnDept(turnDeptName);
				// 需要加上小时list.get(i)[37]+list.get(i)[38]
				inhospitalinfo.setOuthospitalDate(DateUtil.stringToDate(list.get(i)[37], "yyyy-MM-dd"));
				inhospitalinfo.setOuthospitalDeptName(outhospitalDeptName);
				inhospitalinfo.setOuthospitalDeptId(outhospitalDeptId);
				inhospitalinfo.setOuthospitalWard(outhospitalWard);
				if (StringUtils.isNotEmpty(list.get(i)[32])) {
					inhospitalinfo.setInhospitalDays(Integer.valueOf(list.get(i)[41]));
				}
				inhospitalinfo.setDiagnose(diagnose);
				inhospitalinfo.setDiseaseCode(diseaseCode);
				inhospitalinfo.setMainDiagnosis(mainDiagnosis);
				inhospitalinfo.setMainDiagnosisCode(mainDiagnosisCode);
				inhospitalinfo.setInhospitalCondition(inhospitalConditionInt);
				inhospitalinfo.setPoisoningReason(list.get(i)[92]);
				inhospitalinfo.setPoisoningDiseaseCode(list.get(i)[93]);
				inhospitalinfo.setPathologyDiagnosis(list.get(i)[94]);
				inhospitalinfo.setPathologyDiagnosisCode(list.get(i)[95]);
				inhospitalinfo.setPathologyNo(list.get(i)[96]);
				String isAllergy = list.get(i)[97];
				String isAut = list.get(i)[99];
				String aboBlood = list.get(i)[100];
				String rhBlood = list.get(i)[101];
				if (StringUtils.isNotEmpty(isAllergy) && isAllergy.matches("\\d+")) {
					inhospitalinfo.setIsAllergy(Integer.parseInt(isAllergy));
				}
				inhospitalinfo.setAllergyDesc(list.get(i)[98]);
				if (StringUtils.isNotEmpty(isAut) && isAut.matches("\\d+")) {
					inhospitalinfo.setIsAut(Integer.parseInt(isAut));
				}
				if (StringUtils.isNotEmpty(aboBlood) && aboBlood.matches("\\d+")) {
					inhospitalinfo.setAboBlood(Integer.parseInt(aboBlood));
				}
				if (StringUtils.isNotEmpty(rhBlood) && rhBlood.matches("\\d+")) {
					inhospitalinfo.setRhBlood(Integer.parseInt(rhBlood));
				}
				String deptDoctor = list.get(i)[102];
				List<TMetaInfoDoctor> deptDoctorList = null;
				if (StringUtils.isNotEmpty(deptDoctor)) {
					deptDoctorList = doctorDao.getMetaInfoDoctorList(deptDoctor);
				}
				String directorDoctor = list.get(i)[103];
				List<TMetaInfoDoctor> directorDoctorList = null;
				if (StringUtils.isNotEmpty(directorDoctor)) {
					directorDoctorList = doctorDao.getMetaInfoDoctorList(directorDoctor);
				}
				String inchargeDoctor = list.get(i)[104];
				List<TMetaInfoDoctor> inchargeDoctorList = null;
				if (StringUtils.isNotEmpty(inchargeDoctor)) {
					inchargeDoctorList = doctorDao.getMetaInfoDoctorList(inchargeDoctor);
				}
				String inhospitalDoctor = list.get(i)[105];
				List<TMetaInfoDoctor> inhospitalDoctorList = null;
				if (StringUtils.isNotEmpty(inhospitalDoctor)) {
					inhospitalDoctorList = doctorDao.getMetaInfoDoctorList(inhospitalDoctor);
				}
				String dutyNurse = list.get(i)[106];
				List<TMetaInfoDoctor> dutyNurseList = null;
				if (StringUtils.isNotEmpty(dutyNurse)) {
					dutyNurseList = doctorDao.getMetaInfoDoctorList(dutyNurse);
				}
				String postgraduateDoctor = list.get(i)[107];
				List<TMetaInfoDoctor> postgraduateDoctorList = null;
				if (StringUtils.isNotEmpty(postgraduateDoctor)) {
					postgraduateDoctorList = doctorDao.getMetaInfoDoctorList(postgraduateDoctor);
				}
				String internshipDoctor = list.get(i)[108];
				List<TMetaInfoDoctor> internshipDoctorList = null;
				if (StringUtils.isNotEmpty(internshipDoctor)) {
					internshipDoctorList = doctorDao.getMetaInfoDoctorList(internshipDoctor);
				}
				String codePerson = list.get(i)[109];
				List<TMetaInfoDoctor> codePersonList = null;
				if (StringUtils.isNotEmpty(codePerson)) {
					codePersonList = doctorDao.getMetaInfoDoctorList(codePerson);
				}
				String qualityControlDoctor = list.get(i)[111];
				List<TMetaInfoDoctor> qualityControlDoctorList = null;
				if (StringUtils.isNotEmpty(qualityControlDoctor)) {
					qualityControlDoctorList = doctorDao.getMetaInfoDoctorList(qualityControlDoctor);
				}
				String qualityControlNurse = list.get(i)[112];
				List<TMetaInfoDoctor> qualityControlNurseList = null;
				if (StringUtils.isNotEmpty(qualityControlNurse)) {
					qualityControlNurseList = doctorDao.getMetaInfoDoctorList(qualityControlNurse);
				}

				inhospitalinfo.setDeptDoctor(deptDoctorList == null || deptDoctorList.size() == 0 ? null : deptDoctorList.get(0).getDoctorId());
				inhospitalinfo.setDeptDoctorName(deptDoctor);
				inhospitalinfo.setDirectorDoctor(directorDoctorList == null || directorDoctorList.size() == 0 ? null : directorDoctorList.get(0).getDoctorId());
				inhospitalinfo.setDirectorDoctorName(directorDoctor);
				if (inchargeDoctorList != null && inchargeDoctorList.size() > 0) {
					inhospitalinfo.setInchargeDoctor(inchargeDoctorList.get(0).getDoctorId());
				}
				inhospitalinfo.setInchargeDoctorName(inchargeDoctor);
				inhospitalinfo.setInhospitalDoctor(inhospitalDoctorList == null || inhospitalDoctorList.size() == 0 ? null : inhospitalDoctorList.get(0).getDoctorId());
				inhospitalinfo.setInhospitalDoctorName(inhospitalDoctor);
				inhospitalinfo.setDutyNurse(dutyNurseList == null || dutyNurseList.size() == 0 ? null : dutyNurseList.get(0).getDoctorId());
				inhospitalinfo.setDutyNurseName(dutyNurse);
				inhospitalinfo.setPostgraduateDoctor(postgraduateDoctorList == null || postgraduateDoctorList.size() == 0 ? null : postgraduateDoctorList.get(0).getDoctorId());
				inhospitalinfo.setPostgraduateDoctorName(postgraduateDoctor);
				inhospitalinfo.setInternshipDoctor(internshipDoctorList == null || internshipDoctorList.size() == 0 ? null : internshipDoctorList.get(0).getDoctorId());
				inhospitalinfo.setInternshipDoctorName(internshipDoctor);

				inhospitalinfo.setCodePerson(codePersonList == null || codePersonList.size() == 0 ? null : codePersonList.get(0).getDoctorId().intValue());
				inhospitalinfo.setCodePersonName(codePerson);
				String medicalRecordsQuality = list.get(i)[110];
				if (medicalRecordsQuality.matches("\\d+")) {
					inhospitalinfo.setMedicalRecordsQuality(Integer.parseInt(list.get(i)[110]));// 病案质量
				} else {
					LogUtil.log.info("medicalRecordsQuality is value==>" + medicalRecordsQuality);
				}
				inhospitalinfo.setQualityControlDoctor(qualityControlDoctorList == null || qualityControlDoctorList.size() == 0 ? null : qualityControlDoctorList.get(0)
						.getDoctorId());
				inhospitalinfo.setQualityControlDoctorName(qualityControlDoctor);
				inhospitalinfo.setQualityControlNurse(qualityControlNurseList == null || qualityControlNurseList.size() == 0 ? null : qualityControlNurseList.get(0).getDoctorId());
				inhospitalinfo.setQualityControlNurseName(qualityControlNurse);
				inhospitalinfo.setQualityControlDate(DateUtil.stringToDate(list.get(i)[113], "yyyy-MM-dd"));
				String outhoispitalWay = list.get(i)[191];
				if (StringUtils.isEmpty(outhoispitalWay)) {
					LogUtil.log.info("outhoispitalWay is value==>" + outhoispitalWay);
				} else {
					if (outhoispitalWay.equals("1") || outhoispitalWay.equals("医嘱离院")) {
						inhospitalinfo.setOuthoispitalWay(1);
					}
					if (outhoispitalWay.equals("2") || outhoispitalWay.equals("医嘱转院")) {
						inhospitalinfo.setOuthoispitalWay(2);
						inhospitalinfo.setRecHospitalName(list.get(i)[192]);
					}
					if (outhoispitalWay.equals("3") || outhoispitalWay.equals("医嘱转社区卫生服务机构")) {
						inhospitalinfo.setOuthoispitalWay(3);
						inhospitalinfo.setRecHospitalName(list.get(i)[193]);
					}
					if (outhoispitalWay.equals("4") || outhoispitalWay.equals("非医嘱离院")) {
						inhospitalinfo.setOuthoispitalWay(4);
					}
					if (outhoispitalWay.equals("5") || outhoispitalWay.equals("死亡")) {
						inhospitalinfo.setOuthoispitalWay(5);
					}
					if (outhoispitalWay.equals("9") || outhoispitalWay.equals("其他")) {
						inhospitalinfo.setOuthoispitalWay(9);
					}
				}
				String reInhospitalPlan31Days = list.get(i)[194];
				if (reInhospitalPlan31Days != null && reInhospitalPlan31Days.matches("\\d+")) {
					inhospitalinfo.setReInhospitalPlan31Days(Integer.parseInt(list.get(i)[194]));
				}
				inhospitalinfo.setReInhospitalTarget31Days(list.get(i)[195]);
				// 入院前昏迷-天，数据库没有这个字段。
				String preComaHour = list.get(i)[197];
				if (preComaHour != null && preComaHour.matches("\\d+")) {
					inhospitalinfo.setPreComaHour(Integer.parseInt(preComaHour));
				}
				String comaMinute = list.get(i)[198];
				if (comaMinute != null && comaMinute.matches("\\d+")) {
					inhospitalinfo.setPreComaMinute(Integer.parseInt(comaMinute));
				}
				String inComaHour = list.get(i)[200];
				if (inComaHour != null && inComaHour.matches("\\d+")) {
					inhospitalinfo.setInComaHour(Integer.parseInt(inComaHour));
				}
				String inComaMinute = list.get(i)[201];
				if (inComaMinute != null && inComaMinute.matches("\\d+")) {
					inhospitalinfo.setInComaMinute(Integer.parseInt(inComaMinute));
				}

				// 诊断信息
				List<TDiagnosisInfo> diagnosisList = new ArrayList<TDiagnosisInfo>();

				TDiagnosisInfo mainDiagnosisInfo = new TDiagnosisInfo();

				// mainDiagnosisInfo.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// mainDiagnosisInfo.setEmrId(GeneralUtil.generateUniqueID("EMRI"));

				mainDiagnosisInfo.setDiagnosis(mainDiagnosis);
				mainDiagnosisInfo.setDiagnosisCode(mainDiagnosisCode);
				mainDiagnosisInfo.setInHospitalCondition(inhospitalConditionInt);
				mainDiagnosisInfo.setDiagnosisTypeId(1);

				TDiagnosisInfo diagnosisOne = new TDiagnosisInfo();
				String inhospitalConditionOne = list.get(i)[49];
				Integer inhospitalConditionOneInt = null;
				if (inhospitalConditionOne.matches("\\d+")) {
					inhospitalConditionOneInt = Integer.parseInt(inhospitalConditionOne);
				} else {
					inhospitalConditionOneInt = 4;// 无
				}
				// diagnosisOne.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisOne.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisOne.setDiagnosis(list.get(i)[47]);
				diagnosisOne.setDiagnosisCode(list.get(i)[48]);
				diagnosisOne.setInHospitalCondition(inhospitalConditionOneInt);
				diagnosisOne.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisTwo = new TDiagnosisInfo();
				// diagnosisTwo.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisTwo.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisTwo.setDiagnosis(list.get(i)[50]);
				diagnosisTwo.setDiagnosisCode(list.get(i)[51]);
				String inhospitalConditionTwo = list.get(i)[52];
				Integer inhospitalConditionTwoInt = null;
				if (inhospitalConditionTwo.matches("\\d+")) {
					inhospitalConditionTwoInt = Integer.parseInt(inhospitalConditionTwo);
				} else {
					inhospitalConditionTwoInt = 4;// 无
				}
				diagnosisTwo.setInHospitalCondition(inhospitalConditionTwoInt);
				diagnosisTwo.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisThree = new TDiagnosisInfo();
				diagnosisThree.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				diagnosisThree.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisThree.setDiagnosis(list.get(i)[53]);
				diagnosisThree.setDiagnosisCode(list.get(i)[54]);
				String inhospitalConditionThree = list.get(i)[55];
				Integer inhospitalConditionThreeInt = null;
				if (inhospitalConditionThree.matches("\\d+")) {
					inhospitalConditionThreeInt = Integer.parseInt(inhospitalConditionThree);
				} else {
					inhospitalConditionThreeInt = 4;// 无
				}
				diagnosisThree.setInHospitalCondition(inhospitalConditionThreeInt);
				diagnosisThree.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisFour = new TDiagnosisInfo();
				// diagnosisFour.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisFour.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisFour.setDiagnosis(list.get(i)[56]);
				diagnosisFour.setDiagnosisCode(list.get(i)[57]);
				String inhospitalConditionFour = list.get(i)[58];
				Integer inhospitalConditionFourInt = null;
				if (inhospitalConditionFour.matches("\\d+")) {
					inhospitalConditionFourInt = Integer.parseInt(inhospitalConditionFour);
				} else {
					inhospitalConditionFourInt = 4;// 无
				}
				diagnosisFour.setInHospitalCondition(inhospitalConditionFourInt);
				diagnosisFour.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisFive = new TDiagnosisInfo();
				// diagnosisFive.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisFive.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisFive.setDiagnosis(list.get(i)[59]);
				diagnosisFive.setDiagnosisCode(list.get(i)[60]);
				String inhospitalConditionFive = list.get(i)[61];
				Integer inhospitalConditionFiveInt = null;
				if (inhospitalConditionFive.matches("\\d+")) {
					inhospitalConditionFiveInt = Integer.parseInt(inhospitalConditionFive);
				} else {
					inhospitalConditionFiveInt = 4;// 无
				}
				diagnosisFive.setInHospitalCondition(inhospitalConditionFiveInt);
				diagnosisFive.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisSix = new TDiagnosisInfo();
				// diagnosisSix.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisSix.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisSix.setDiagnosis(list.get(i)[62]);
				diagnosisSix.setDiagnosisCode(list.get(i)[63]);
				String inhospitalConditionSix = list.get(i)[64];
				Integer inhospitalConditionSixInt = null;
				if (inhospitalConditionSix.matches("\\d+")) {
					inhospitalConditionSixInt = Integer.parseInt(inhospitalConditionSix);
				} else {
					inhospitalConditionSixInt = 4;// 无
				}
				diagnosisSix.setInHospitalCondition(inhospitalConditionSixInt);
				diagnosisSix.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisSeven = new TDiagnosisInfo();
				// diagnosisSeven.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisSeven.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisSeven.setDiagnosis(list.get(i)[65]);
				diagnosisSeven.setDiagnosisCode(list.get(i)[66]);
				String inhospitalConditionSeven = list.get(i)[67];
				Integer inhospitalConditionSevenInt = null;
				if (inhospitalConditionSeven.matches("\\d+")) {
					inhospitalConditionSevenInt = Integer.parseInt(inhospitalConditionSeven);
				} else {
					inhospitalConditionSevenInt = 4;// 无
				}
				diagnosisSeven.setInHospitalCondition(inhospitalConditionSevenInt);
				diagnosisSeven.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisEight = new TDiagnosisInfo();
				// diagnosisEight.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisEight.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisEight.setDiagnosis(list.get(i)[68]);
				diagnosisEight.setDiagnosisCode(list.get(i)[69]);
				String inhospitalConditionEight = list.get(i)[70];
				Integer inhospitalConditionEightInt = null;
				if (inhospitalConditionEight.matches("\\d+")) {
					inhospitalConditionEightInt = Integer.parseInt(inhospitalConditionEight);
				} else {
					inhospitalConditionEightInt = 4;// 无
				}
				diagnosisEight.setInHospitalCondition(inhospitalConditionEightInt);
				diagnosisEight.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisNine = new TDiagnosisInfo();
				// diagnosisNine.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisNine.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisNine.setDiagnosis(list.get(i)[71]);
				diagnosisNine.setDiagnosisCode(list.get(i)[72]);
				String inhospitalConditionNine = list.get(i)[73];
				Integer inhospitalConditionNineInt = null;
				if (inhospitalConditionNine.matches("\\d+")) {
					inhospitalConditionNineInt = Integer.parseInt(inhospitalConditionNine);
				} else {
					inhospitalConditionNineInt = 4;// 无
				}
				diagnosisNine.setInHospitalCondition(inhospitalConditionNineInt);
				diagnosisNine.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisTen = new TDiagnosisInfo();
				// diagnosisTen.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisTen.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisTen.setDiagnosis(list.get(i)[74]);
				diagnosisTen.setDiagnosisCode(list.get(i)[75]);
				String inhospitalConditionTen = list.get(i)[76];
				Integer inhospitalConditionTenInt = null;
				if (inhospitalConditionTen.matches("\\d+")) {
					inhospitalConditionTenInt = Integer.parseInt(inhospitalConditionTen);
				} else {
					inhospitalConditionTenInt = 4;// 无
				}
				diagnosisTen.setInHospitalCondition(inhospitalConditionTenInt);
				diagnosisTen.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisEleven = new TDiagnosisInfo();
				// diagnosisEleven.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisEleven.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisEleven.setDiagnosis(list.get(i)[77]);
				diagnosisEleven.setDiagnosisCode(list.get(i)[78]);
				String inhospitalConditionEleven = list.get(i)[79];
				Integer inhospitalConditionElevenInt = null;
				if (inhospitalConditionEleven.matches("\\d+")) {
					inhospitalConditionElevenInt = Integer.parseInt(inhospitalConditionEleven);
				} else {
					inhospitalConditionElevenInt = 4;// 无
				}
				diagnosisEleven.setInHospitalCondition(inhospitalConditionElevenInt);
				diagnosisEleven.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisTwelve = new TDiagnosisInfo();
				// diagnosisTwelve.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisTwelve.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisTwelve.setDiagnosis(list.get(i)[80]);
				diagnosisTwelve.setDiagnosisCode(list.get(i)[81]);
				String inhospitalConditionTwelve = list.get(i)[82];
				Integer inhospitalConditionTwelveInt = null;
				if (inhospitalConditionTwelve.matches("\\d+")) {
					inhospitalConditionTwelveInt = Integer.parseInt(inhospitalConditionTwelve);
				} else {
					inhospitalConditionTwelveInt = 4;// 无
				}
				diagnosisTwelve.setInHospitalCondition(inhospitalConditionTwelveInt);
				diagnosisTwelve.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisThirteen = new TDiagnosisInfo();
				// diagnosisThirteen.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisThirteen.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisThirteen.setDiagnosis(list.get(i)[83]);
				diagnosisThirteen.setDiagnosisCode(list.get(i)[84]);
				String inhospitalConditionThirteen = list.get(i)[85];
				Integer inhospitalConditionThirteenInt = null;
				if (inhospitalConditionThirteen.matches("\\d+")) {
					inhospitalConditionThirteenInt = Integer.parseInt(inhospitalConditionThirteen);
				} else {
					inhospitalConditionThirteenInt = 4;// 无
				}
				diagnosisThirteen.setInHospitalCondition(inhospitalConditionThirteenInt);
				diagnosisThirteen.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisFourteen = new TDiagnosisInfo();
				// diagnosisFourteen.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisFourteen.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisFourteen.setDiagnosis(list.get(i)[86]);
				diagnosisFourteen.setDiagnosisCode(list.get(i)[87]);
				String inhospitalConditionFourteen = list.get(i)[88];
				Integer inhospitalConditionFourteenInt = null;
				if (inhospitalConditionFourteen != null && inhospitalConditionFourteen.matches("\\d+")) {
					inhospitalConditionFourteenInt = Integer.parseInt(inhospitalConditionFourteen);
				} else {
					inhospitalConditionFourteenInt = 4;// 无
				}
				diagnosisFourteen.setInHospitalCondition(inhospitalConditionFourteenInt);
				diagnosisFourteen.setDiagnosisTypeId(2);

				TDiagnosisInfo diagnosisFifteen = new TDiagnosisInfo();
				// diagnosisFifteen.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				// diagnosisFifteen.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisFifteen.setDiagnosis(list.get(i)[89]);
				diagnosisFifteen.setDiagnosisCode(list.get(i)[90]);
				String inhospitalConditionFifteen = list.get(i)[91];
				Integer inhospitalConditionFifteenInt = null;
				if (inhospitalConditionFifteen.matches("\\d+")) {
					inhospitalConditionFifteenInt = Integer.parseInt(inhospitalConditionFifteen);
				} else {
					inhospitalConditionFifteenInt = 4;// 无
				}
				diagnosisFifteen.setInHospitalCondition(inhospitalConditionFifteenInt);
				diagnosisFifteen.setDiagnosisTypeId(2);

				diagnosisList.add(mainDiagnosisInfo);
				diagnosisList.add(diagnosisOne);
				diagnosisList.add(diagnosisTwo);
				diagnosisList.add(diagnosisThree);
				diagnosisList.add(diagnosisFour);
				diagnosisList.add(diagnosisFive);
				diagnosisList.add(diagnosisSix);
				diagnosisList.add(diagnosisSeven);
				diagnosisList.add(diagnosisEight);
				diagnosisList.add(diagnosisNine);
				diagnosisList.add(diagnosisTen);
				diagnosisList.add(diagnosisEleven);
				diagnosisList.add(diagnosisTwelve);
				diagnosisList.add(diagnosisThirteen);
				diagnosisList.add(diagnosisFourteen);
				diagnosisList.add(diagnosisFifteen);

				// 手术治疗信息
				List<TPatientSurgeryInfo> surgeryList = new ArrayList<TPatientSurgeryInfo>();
				// 手术1
				TPatientSurgeryInfo surgeryInfoOne = new TPatientSurgeryInfo();
				surgeryInfoOne.setOpCode(list.get(i)[114]);
				surgeryInfoOne.setSurgeryDate(DateUtil.stringToDate(list.get(i)[115], "yyyy-MM-dd"));
				if (StringUtils.isNotEmpty(list.get(i)[116])) {
					surgeryInfoOne.setOpLevel(Integer.parseInt(list.get(i)[116]));
				}
				surgeryInfoOne.setSurgeryName(list.get(i)[117]);
				surgeryInfoOne.setSurgeryDoctorName(list.get(i)[118]);
				surgeryInfoOne.setSurgeryAssistant1Name(list.get(i)[119]);
				surgeryInfoOne.setSurgeryAssistant2Name(list.get(i)[120]);
				String incisionHealingLevel1 = list.get(i)[121];
				String incisionHealingGroup1 = list.get(i)[122];
				if (incisionHealingList != null && incisionHealingList.size() > 0) {
					Iterator<TMetaInfoIncisionHealing> incisionHealingItor = incisionHealingList.iterator();
					while (incisionHealingItor.hasNext()) {
						TMetaInfoIncisionHealing metaInfoIncisionHealing = incisionHealingItor.next();
						if (metaInfoIncisionHealing.getIncisionHealingLevel().equals(incisionHealingLevel1)
								&& metaInfoIncisionHealing.getIncisionHealingGroup().equals(incisionHealingGroup1)) {
							surgeryInfoOne.setIncisionHealingId(metaInfoIncisionHealing.getIncisionHealingId());
							break;
						}
					}
				}
				surgeryInfoOne.setIncisionHealingLevel(incisionHealingGroup1 + "/" + incisionHealingLevel1);
				surgeryInfoOne.setAnesthesiaWay(list.get(i)[123]);
				if (StringUtils.isNotEmpty(list.get(i)[123])) {
					List<TMetaInfoAnesthesiaWay> anesthesiaWayList = metaInfoAnesthesiaWayDao.getMetaInfoAnesthesiaWayList(list.get(i)[123], list.get(i)[123]);
					if (anesthesiaWayList != null && anesthesiaWayList.size() > 0) {
						surgeryInfoOne.setAnesthesiaWayId(anesthesiaWayList.get(0).getAnesthesiaId());
					}
				}
				surgeryInfoOne.setAnesthesiaDoctorName(list.get(i)[124]);
				// 手术2
				TPatientSurgeryInfo surgeryInfoTwo = new TPatientSurgeryInfo();
				surgeryInfoTwo.setOpCode(list.get(i)[125]);
				surgeryInfoTwo.setSurgeryDate(DateUtil.stringToDate(list.get(i)[126], "yyyy-MM-dd"));
				if (list.get(i)[127].matches("\\d+")) {
					surgeryInfoTwo.setOpLevel(Integer.parseInt(list.get(i)[127]));
				}
				surgeryInfoTwo.setSurgeryName(list.get(i)[128]);
				surgeryInfoTwo.setSurgeryDoctorName(list.get(i)[129]);
				surgeryInfoTwo.setSurgeryAssistant1Name(list.get(i)[130]);
				surgeryInfoTwo.setSurgeryAssistant2Name(list.get(i)[131]);
				// 切口等级
				String incisionHealingLevel2 = list.get(i)[132];
				String incisionHealingGroup2 = list.get(i)[133];
				if (incisionHealingList != null && incisionHealingList.size() > 0) {
					Iterator<TMetaInfoIncisionHealing> incisionHealingItor = incisionHealingList.iterator();
					while (incisionHealingItor.hasNext()) {
						TMetaInfoIncisionHealing metaInfoIncisionHealing = incisionHealingItor.next();
						if (metaInfoIncisionHealing.getIncisionHealingLevel().equals(incisionHealingLevel2)
								&& metaInfoIncisionHealing.getIncisionHealingGroup().equals(incisionHealingGroup2)) {
							surgeryInfoTwo.setIncisionHealingId(metaInfoIncisionHealing.getIncisionHealingId());
							break;
						}
					}
				}
				surgeryInfoTwo.setIncisionHealingLevel(incisionHealingGroup2 + "/" + incisionHealingLevel2);
				surgeryInfoTwo.setAnesthesiaWay(list.get(i)[134]);
				if (StringUtils.isNotEmpty(list.get(i)[134])) {
					List<TMetaInfoAnesthesiaWay> anesthesiaWayList = metaInfoAnesthesiaWayDao.getMetaInfoAnesthesiaWayList(list.get(i)[134], list.get(i)[134]);
					if (anesthesiaWayList != null && anesthesiaWayList.size() > 0) {
						surgeryInfoTwo.setAnesthesiaWayId(anesthesiaWayList.get(0).getAnesthesiaId());
					}
				}
				surgeryInfoTwo.setAnesthesiaDoctorName(list.get(i)[135]);
				// 手术3
				TPatientSurgeryInfo surgeryInfoThree = new TPatientSurgeryInfo();
				surgeryInfoThree.setOpCode(list.get(i)[136]);
				surgeryInfoThree.setSurgeryDate(DateUtil.stringToDate(list.get(i)[137], "yyyy-MM-dd"));
				if (list.get(i)[138].matches("\\d+")) {
					surgeryInfoThree.setOpLevel(Integer.parseInt(list.get(i)[138]));
				}
				surgeryInfoThree.setSurgeryName(list.get(i)[139]);
				surgeryInfoThree.setSurgeryDoctorName(list.get(i)[140]);
				surgeryInfoThree.setSurgeryAssistant1Name(list.get(i)[141]);
				surgeryInfoThree.setSurgeryAssistant2Name(list.get(i)[142]);
				// 切口等级
				String incisionHealingLevel3 = list.get(i)[143];
				String incisionHealingGroup3 = list.get(i)[144];
				if (incisionHealingList != null && incisionHealingList.size() > 0) {
					Iterator<TMetaInfoIncisionHealing> incisionHealingItor = incisionHealingList.iterator();
					while (incisionHealingItor.hasNext()) {
						TMetaInfoIncisionHealing metaInfoIncisionHealing = incisionHealingItor.next();
						if (metaInfoIncisionHealing.getIncisionHealingLevel().equals(incisionHealingLevel3)
								&& metaInfoIncisionHealing.getIncisionHealingGroup().equals(incisionHealingGroup3)) {
							surgeryInfoThree.setIncisionHealingId(metaInfoIncisionHealing.getIncisionHealingId());
							break;
						}
					}
				}
				surgeryInfoThree.setIncisionHealingLevel(incisionHealingGroup3 + "/" + incisionHealingLevel3);
				surgeryInfoThree.setAnesthesiaWay(list.get(i)[145]);
				if (StringUtils.isNotEmpty(list.get(i)[145])) {
					List<TMetaInfoAnesthesiaWay> anesthesiaWayList = metaInfoAnesthesiaWayDao.getMetaInfoAnesthesiaWayList(list.get(i)[145], list.get(i)[145]);
					if (anesthesiaWayList != null && anesthesiaWayList.size() > 0) {
						surgeryInfoThree.setAnesthesiaWayId(anesthesiaWayList.get(0).getAnesthesiaId());
					}
				}
				surgeryInfoThree.setAnesthesiaDoctorName(list.get(i)[146]);
				// 手术4
				TPatientSurgeryInfo surgeryInfoFour = new TPatientSurgeryInfo();
				surgeryInfoFour.setOpCode(list.get(i)[147]);
				surgeryInfoFour.setSurgeryDate(DateUtil.stringToDate(list.get(i)[148], "yyyy-MM-dd"));
				if (list.get(i)[149].matches("\\d+")) {
					surgeryInfoFour.setOpLevel(Integer.parseInt(list.get(i)[149]));
				}
				surgeryInfoFour.setSurgeryName(list.get(i)[150]);
				surgeryInfoFour.setSurgeryDoctorName(list.get(i)[151]);
				surgeryInfoFour.setSurgeryAssistant1Name(list.get(i)[152]);
				surgeryInfoFour.setSurgeryAssistant2Name(list.get(i)[153]);
				// 切口等级
				String incisionHealingLevel4 = list.get(i)[154];
				String incisionHealingGroup4 = list.get(i)[155];
				if (incisionHealingList != null && incisionHealingList.size() > 0) {
					Iterator<TMetaInfoIncisionHealing> incisionHealingItor = incisionHealingList.iterator();
					while (incisionHealingItor.hasNext()) {
						TMetaInfoIncisionHealing metaInfoIncisionHealing = incisionHealingItor.next();
						if (metaInfoIncisionHealing.getIncisionHealingLevel().equals(incisionHealingLevel4)
								&& metaInfoIncisionHealing.getIncisionHealingGroup().equals(incisionHealingGroup4)) {
							surgeryInfoFour.setIncisionHealingId(metaInfoIncisionHealing.getIncisionHealingId());
							break;
						}
					}
				}
				surgeryInfoFour.setIncisionHealingLevel(incisionHealingGroup4 + "/" + incisionHealingLevel4);
				surgeryInfoFour.setAnesthesiaWay(list.get(i)[156]);
				if (StringUtils.isNotEmpty(list.get(i)[156])) {
					List<TMetaInfoAnesthesiaWay> anesthesiaWayList = metaInfoAnesthesiaWayDao.getMetaInfoAnesthesiaWayList(list.get(i)[156], list.get(i)[156]);
					if (anesthesiaWayList != null && anesthesiaWayList.size() > 0) {
						surgeryInfoFour.setAnesthesiaWayId(anesthesiaWayList.get(0).getAnesthesiaId());
					}
				}
				surgeryInfoFour.setAnesthesiaDoctorName(list.get(i)[157]);
				// 手术5
				TPatientSurgeryInfo surgeryInfoFive = new TPatientSurgeryInfo();
				surgeryInfoFive.setOpCode(list.get(i)[158]);
				surgeryInfoFive.setSurgeryDate(DateUtil.stringToDate(list.get(i)[159], "yyyy-MM-dd"));
				if (list.get(i)[160].matches("\\d+")) {
					surgeryInfoFive.setOpLevel(Integer.parseInt(list.get(i)[160]));
				}
				surgeryInfoFive.setSurgeryName(list.get(i)[161]);
				surgeryInfoFive.setSurgeryDoctorName(list.get(i)[162]);
				surgeryInfoFive.setSurgeryAssistant1Name(list.get(i)[163]);
				surgeryInfoFive.setSurgeryAssistant2Name(list.get(i)[164]);
				// 切口等级
				String incisionHealingLevel5 = list.get(i)[165];
				String incisionHealingGroup5 = list.get(i)[166];
				if (incisionHealingList != null && incisionHealingList.size() > 0) {
					Iterator<TMetaInfoIncisionHealing> incisionHealingItor = incisionHealingList.iterator();
					while (incisionHealingItor.hasNext()) {
						TMetaInfoIncisionHealing metaInfoIncisionHealing = incisionHealingItor.next();
						if (metaInfoIncisionHealing.getIncisionHealingLevel().equals(incisionHealingLevel5)
								&& metaInfoIncisionHealing.getIncisionHealingGroup().equals(incisionHealingGroup5)) {
							surgeryInfoFive.setIncisionHealingId(metaInfoIncisionHealing.getIncisionHealingId());
							break;
						}
					}
				}
				surgeryInfoFive.setIncisionHealingLevel(incisionHealingGroup5 + "/" + incisionHealingLevel5);
				surgeryInfoFive.setAnesthesiaWay(list.get(i)[167]);
				if (StringUtils.isNotEmpty(list.get(i)[167])) {
					List<TMetaInfoAnesthesiaWay> anesthesiaWayList = metaInfoAnesthesiaWayDao.getMetaInfoAnesthesiaWayList(list.get(i)[167], list.get(i)[167]);
					if (anesthesiaWayList != null && anesthesiaWayList.size() > 0) {
						surgeryInfoFive.setAnesthesiaWayId(anesthesiaWayList.get(0).getAnesthesiaId());
					}
				}
				surgeryInfoFive.setAnesthesiaDoctorName(list.get(i)[168]);
				// 手术6
				TPatientSurgeryInfo surgeryInfoSix = new TPatientSurgeryInfo();
				surgeryInfoSix.setOpCode(list.get(i)[169]);
				surgeryInfoSix.setSurgeryDate(DateUtil.stringToDate(list.get(i)[170], "yyyy-MM-dd"));
				if (list.get(i)[171].matches("\\d+")) {
					surgeryInfoSix.setOpLevel(Integer.parseInt(list.get(i)[171]));
				}
				surgeryInfoSix.setSurgeryName(list.get(i)[172]);
				surgeryInfoSix.setSurgeryDoctorName(list.get(i)[173]);
				surgeryInfoSix.setSurgeryAssistant1Name(list.get(i)[174]);
				surgeryInfoSix.setSurgeryAssistant2Name(list.get(i)[175]);
				// 切口等级
				String incisionHealingLevel6 = list.get(i)[176];
				String incisionHealingGroup6 = list.get(i)[177];
				if (incisionHealingList != null && incisionHealingList.size() > 0) {
					Iterator<TMetaInfoIncisionHealing> incisionHealingItor = incisionHealingList.iterator();
					while (incisionHealingItor.hasNext()) {
						TMetaInfoIncisionHealing metaInfoIncisionHealing = incisionHealingItor.next();
						if (metaInfoIncisionHealing.getIncisionHealingLevel().equals(incisionHealingLevel6)
								&& metaInfoIncisionHealing.getIncisionHealingGroup().equals(incisionHealingGroup6)) {
							surgeryInfoSix.setIncisionHealingId(metaInfoIncisionHealing.getIncisionHealingId());
							break;
						}
					}
				}
				surgeryInfoSix.setIncisionHealingLevel(incisionHealingGroup6 + "/" + incisionHealingLevel6);
				surgeryInfoSix.setAnesthesiaWay(list.get(i)[178]);
				if (StringUtils.isNotEmpty(list.get(i)[178])) {
					List<TMetaInfoAnesthesiaWay> anesthesiaWayList = metaInfoAnesthesiaWayDao.getMetaInfoAnesthesiaWayList(list.get(i)[178], list.get(i)[178]);
					if (anesthesiaWayList != null && anesthesiaWayList.size() > 0) {
						surgeryInfoSix.setAnesthesiaWayId(anesthesiaWayList.get(0).getAnesthesiaId());
					}
				}
				surgeryInfoSix.setAnesthesiaDoctorName(list.get(i)[179]);
				// 手术7
				TPatientSurgeryInfo surgeryInfoSeven = new TPatientSurgeryInfo();
				surgeryInfoSeven.setOpCode(list.get(i)[180]);
				surgeryInfoSeven.setSurgeryDate(DateUtil.stringToDate(list.get(i)[181], "yyyy-MM-dd"));
				if (list.get(i)[182].matches("\\d+")) {
					surgeryInfoSeven.setOpLevel(Integer.parseInt(list.get(i)[182]));
				}
				surgeryInfoSeven.setSurgeryName(list.get(i)[183]);
				surgeryInfoSeven.setSurgeryDoctorName(list.get(i)[184]);
				surgeryInfoSeven.setSurgeryAssistant1Name(list.get(i)[185]);
				surgeryInfoSeven.setSurgeryAssistant2Name(list.get(i)[186]);
				// 切口等级
				String incisionHealingLevel7 = list.get(i)[187];
				String incisionHealingGroup7 = list.get(i)[188];
				if (incisionHealingList != null && incisionHealingList.size() > 0) {
					Iterator<TMetaInfoIncisionHealing> incisionHealingItor = incisionHealingList.iterator();
					while (incisionHealingItor.hasNext()) {
						TMetaInfoIncisionHealing metaInfoIncisionHealing = incisionHealingItor.next();
						if (metaInfoIncisionHealing.getIncisionHealingLevel().equals(incisionHealingLevel7)
								&& metaInfoIncisionHealing.getIncisionHealingGroup().equals(incisionHealingGroup7)) {
							surgeryInfoSeven.setIncisionHealingId(metaInfoIncisionHealing.getIncisionHealingId());
							break;
						}
					}
				}
				surgeryInfoSeven.setIncisionHealingLevel(incisionHealingGroup7 + "/" + incisionHealingLevel7);
				surgeryInfoSeven.setAnesthesiaWay(list.get(i)[189]);
				if (StringUtils.isNotEmpty(list.get(i)[189])) {
					List<TMetaInfoAnesthesiaWay> anesthesiaWayList = metaInfoAnesthesiaWayDao.getMetaInfoAnesthesiaWayList(list.get(i)[189], list.get(i)[189]);
					if (anesthesiaWayList != null && anesthesiaWayList.size() > 0) {
						surgeryInfoSeven.setAnesthesiaWayId(anesthesiaWayList.get(0).getAnesthesiaId());
					}
				}
				surgeryInfoSeven.setAnesthesiaDoctorName(list.get(i)[190]);
				surgeryList.add(surgeryInfoOne);
				surgeryList.add(surgeryInfoTwo);
				surgeryList.add(surgeryInfoThree);
				surgeryList.add(surgeryInfoFour);
				surgeryList.add(surgeryInfoFive);
				surgeryList.add(surgeryInfoSix);
				surgeryList.add(surgeryInfoSeven);

				// 住院费用
				costInfo.setTotalCost(new BigDecimalExt().toDecimal(list.get(i)[202]));
				costInfo.setSelfCost(new BigDecimalExt().toDecimal(list.get(i)[203]));
				costInfo.setGeneralMedicalServices(new BigDecimalExt().toDecimal(list.get(i)[204]));
				costInfo.setCommonMedicalProceduresCost(new BigDecimalExt().toDecimal(list.get(i)[205]));
				costInfo.setNursingFees(new BigDecimalExt().toDecimal(list.get(i)[206]));
				costInfo.setGeneralMedicalOther(new BigDecimalExt().toDecimal(list.get(i)[207]));
				costInfo.setPathologicalDiagnosis(new BigDecimalExt().toDecimal(list.get(i)[208]));
				costInfo.setLaboratoryDiagnosis(new BigDecimalExt().toDecimal(list.get(i)[209]));
				costInfo.setImagingDiagnosis(new BigDecimalExt().toDecimal(list.get(i)[210]));
				costInfo.setClinicalDiagnosis(new BigDecimalExt().toDecimal(list.get(i)[211]));
				costInfo.setNonSurgicalTreatmentProgram(new BigDecimalExt().toDecimal(list.get(i)[212]));
				costInfo.setClinicalPhysicalTherapyFee(new BigDecimalExt().toDecimal(list.get(i)[213]));
				costInfo.setSurgicalTreatmentCosts(new BigDecimalExt().toDecimal(list.get(i)[214]));
				costInfo.setAnesthesiaFees(new BigDecimalExt().toDecimal(list.get(i)[215]));
				costInfo.setSurgeryFees(new BigDecimalExt().toDecimal(list.get(i)[216]));
				costInfo.setRehabilitationCosts(new BigDecimalExt().toDecimal(list.get(i)[217]));
				costInfo.setTcmTreatmentCosts(new BigDecimalExt().toDecimal(list.get(i)[218]));
				costInfo.setMedicineCosts(new BigDecimalExt().toDecimal(list.get(i)[219]));
				costInfo.setAntimicrobialDrugCosts(new BigDecimalExt().toDecimal(list.get(i)[220]));
				costInfo.setMedicineCosts2(new BigDecimalExt().toDecimal(list.get(i)[221]));
				costInfo.setHerbalFee(new BigDecimalExt().toDecimal(list.get(i)[222]));
				costInfo.setBloodFee(new BigDecimalExt().toDecimal(list.get(i)[223]));
				costInfo.setAlbuminFee(new BigDecimalExt().toDecimal(list.get(i)[224]));
				costInfo.setGlobulinFee(new BigDecimalExt().toDecimal(list.get(i)[225]));
				costInfo.setCoagulationFactorfee(new BigDecimalExt().toDecimal(list.get(i)[226]));
				costInfo.setCytokinesFee(new BigDecimalExt().toDecimal(list.get(i)[227]));
				costInfo.setCheckDisposableMedicalMaterialCosts(new BigDecimalExt().toDecimal(list.get(i)[228]));
				costInfo.setTherapeuticDisposableMedicalCosts(new BigDecimalExt().toDecimal(list.get(i)[229]));
				costInfo.setSurgicalDisposableMedicalCosts(new BigDecimalExt().toDecimal(list.get(i)[230]));
				costInfo.setOtherCosts(new BigDecimalExt().toDecimal(list.get(i)[231]));
				int flag = save(userInfo, patient, inhospitalinfo, diagnosisList, surgeryList, costInfo, i, tPatientProfile, patientFamilyList);
				if (flag == -1) {
					fail++;
				}
			} catch (Exception e) {
				frw.writeLine("第" + i + "行导入失败，原因：" + e.getMessage());
				LogUtil.log.error(e.getMessage());
				fail++;
			}
		}
		res = 1;
		int impor = total - repeat - fail;
		frw.writeLine("导入完成！");
		frw.writeLine("成功为您导入" + impor + "名患者，失败" + fail + "例，处理重复导入住院记录患者" + repeat + "例");
		frw.close();
		return res;
	}

	private int save(TUserInfo userInfo, TPatientInfo patient, TInhospitalDetailInfo inhospitalinfo, List<TDiagnosisInfo> diagnosisList, List<TPatientSurgeryInfo> surgeryList,
			TInhospitalCostInfo costInfo, int count, TPatientProfile tPatientProfile, List<PatientFamily> patientFamilyList) {

		patient.setHospitalId(inhospitalinfo.getHospitalId());

		if (tPatientProfile != null) { // 更新user表，和patient表
			try {
				userInfo.setUserId(tPatientProfile.getUserId());
				patient.setPatientId(tPatientProfile.getPatientId());
				patientInfoService.updateUserPatient(userInfo, patient);
				LogUtil.log.info("第" + count + "条 userInfo， patient 更新成功");
			} catch (Exception e) {
				LogUtil.log.info("第" + count + "条更新失败！");
				LogUtil.log.error(e.getMessage());
			}
		} else {
			patient.setMatchFlag(9);// 标记excel导入作为检索条件
			userInfo.setSourceFlag(7);// excel导入
			userInfo.setUserName(userInfo.getTrueName() + "_" + GeneralUtil.generatorUUID());
			userInfo.setMobile(null);
			// userInfo.setUuid(GeneralUtil.generatorTimeUUID());
			try {
				patientInfoService.insertUserInfo(userInfo);
				LogUtil.log.info("第" + count + "条userInfo插入！");
				if (userInfo.getUserId() != null) {
					TUserInfo ui = userInfoDao.selectByPrimaryKey(String.valueOf(userInfo.getUserId()));
					if (ui != null) {
						userInfo.setUuid(ui.getUuid());
					}
				}
			} catch (Exception e) {
				log.info("第" + count + "行导入失败，原因：" + e.getMessage());
				return -1;
			}
			patient.setUserId(userInfo.getUserId());
			patient.setUuid(userInfo.getUuid());
			try {
				patientInfoService.insert(patient);
				LogUtil.log.info("第" + count + "条patient插入！");
			} catch (Exception e) {
				log.info("第" + count + "行导入失败，原因：" + e.getMessage());
				return -1;
			}

			// 医生患者关系
			if (inhospitalinfo.getInhospitalDoctor() != null) {
				if (null == patientInfoDao.searchDoctorPatient(patient.getPatientId(), inhospitalinfo.getInhospitalDoctor())) {
					// 创建医患关系
					DoctorPatient doctorPatient = new DoctorPatient();
					doctorPatient.setDoctorId(inhospitalinfo.getInchargeDoctor());
					doctorPatient.setPatientId(patient.getPatientId());
					doctorPatient.setAttentionTime(new Date());
					doctorPatient.setCreateTime(new Date());
					doctorPatient.setHasMedicalRecord(1);
					doctorPatient.setSourceFlag(6);
					try {
						patientInfoDao.insertDoctorPatient(doctorPatient);
						LogUtil.log.info("第" + count + "条patientInfoDao插入！");
					} catch (Exception e) {
						LogUtil.log.error(e.getMessage() + e);
					}
				}
			}
			// 院患关系
			if (inhospitalinfo.getHospitalId() != null) {
				HospitalPatientBriefInfo briefInfo = new HospitalPatientBriefInfo();
				briefInfo.setPatientId(patient.getPatientId());
				briefInfo.setHospitalId(inhospitalinfo.getHospitalId());
				briefInfo.setPatientNo(patient.getPatientNo());
				if (hospitalPatientDao.hasRelationOfHospitalPatient(briefInfo) == 0) {
					briefInfo.setSourceFlag(9);
					try {
						hospitalPatientDao.insertRelationOfHospitalPatient(briefInfo);
						LogUtil.log.info("第" + count + "条hospitalPatientDao插入！");
					} catch (Exception e) {
						LogUtil.log.error(e.getMessage() + e);
					}
				}
			}
		}

		for (int i = 0; i < patientFamilyList.size(); i++) {
			patientFamilyList.get(i).setContactId(GeneralUtil.generateUniqueID("CONT"));
			patientFamilyList.get(i).setPatientId(patient.getPatientId());
			patientFamilyList.get(i).setSourceFlag(5);
			patientFamilyList.get(i).setIsDefault(1);
			patientFamilyList.get(i).setIsValid(1);
			try {
				patientFamilyDao.insert(patientFamilyList.get(i));
				LogUtil.log.info("第" + count + "条patientFamilyDao插入！");
			} catch (Exception e) {
				LogUtil.log.error(e.getMessage());
			}
		}
		// Map<String,Object> patientFamilyMap = new HashMap<String,Object>();
		// patientFamilyMap.put("patientFamilyList", patientFamilyList);
		// try{
		// patientFamilyDao.batchInsert(patientFamilyMap);
		// LogUtil.log.info("第"+count+"条patientFamilyDao插入！");
		// }catch(Exception e){
		// LogUtil.log.error(e.getMessage());
		// }
		//
		inhospitalinfo.setPatientId(patient.getPatientId());
		inhospitalinfo.setPatientNo(patient.getPatientNo());
		inhospitalinfo.setSourceflag(9);// excel导入
		inhospitalinfo.setInhospitalId(GeneralUtil.generatorUUID("EINH"));
		try {
			inhospitalDetailInfoDao.createInhospitalDetail(inhospitalinfo);
			LogUtil.log.info("第" + count + "条inhospitalDetailInfoDao插入！");
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage());
		}

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if (diagnosisList != null) {
			for (int i = 0; i < diagnosisList.size(); i++) {
				diagnosisList.get(i).setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
				diagnosisList.get(i).setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				diagnosisList.get(i).setPatientId(patient.getPatientId());
				diagnosisList.get(i).setPatientNo(patient.getPatientNo());
				diagnosisList.get(i).setHospitalId(inhospitalinfo.getHospitalId());
				diagnosisList.get(i).setVisitTime(inhospitalinfo.getInhospitalDate());
				diagnosisList.get(i).setInhospitalId(inhospitalinfo.getInhospitalId());
			}
		}
		paramsMap.put("diagnosisList", diagnosisList);
		try {
			diagnosisInfoDao.batchInsertTDiagnosisInfo(paramsMap);
			LogUtil.log.info("第" + count + "条diagnosisInfoDao插入！");
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage() + e);
		}
		paramsMap.clear();

		if (surgeryList != null) {
			for (int i = 0; i < surgeryList.size(); i++) {
				surgeryList.get(i).setSurgeryId(GeneralUtil.generatorUUID("ESUR"));
				surgeryList.get(i).setEmrId(GeneralUtil.generateUniqueID("EMRI"));
				surgeryList.get(i).setPatientId(inhospitalinfo.getPatientId());
				surgeryList.get(i).setPatientNo(inhospitalinfo.getPatientNo());
				surgeryList.get(i).setHospitalId(inhospitalinfo.getHospitalId());
				surgeryList.get(i).setInhospitalId(inhospitalinfo.getInhospitalId());
				// if(StringUtils.isEmpty(surgeryList.get(i).getSurgeryName()))
				// {
				// surgeryList.get(i).setSurgeryName("单元测试");
				// }
			}
		}
		paramsMap.put("surgeryList", surgeryList);
		try {
			patientSurgeryDao.batchInsertSurgeryInfo(paramsMap);
			LogUtil.log.info("第" + count + "条patientSurgeryDao插入！");
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage() + e);
		}
		paramsMap = null;
		costInfo.setCostId(GeneralUtil.generatorUUID("COST"));
		costInfo.setPatientid(inhospitalinfo.getPatientId());
		costInfo.setInhospitalId(inhospitalinfo.getInhospitalId());
		try {
			inhospitalCostInfoDao.insertEiInhospitalCost(costInfo);
			LogUtil.log.info("第" + count + "条inhospitalCostInfoDao插入！");
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage() + e);
		}
		LogUtil.log.info("第" + count + "条插入完毕！");
		return 0;
	}
}
