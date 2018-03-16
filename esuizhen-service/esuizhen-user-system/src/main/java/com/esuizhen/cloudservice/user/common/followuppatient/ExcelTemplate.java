package com.esuizhen.cloudservice.user.common.followuppatient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.esuizhen.cloudservice.user.followuppatient.util.TemplateUtil;

public class ExcelTemplate {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelTemplate.class);
	public static final StringBuffer HEADER = new StringBuffer(
            "<html xmlns:x=\"urn:schemas-microsoft-com:office:excel\">")
            .append("<head>")
            .append("<meta http-equiv=\"content-type\" content=\"application/vnd.ms-excel; charset=UTF-8\"/>")
            .append("<!--[if gte mso 9]><xml>").append("<x:ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">")
            .append("<x:ExcelWorksheets>").append("<x:ExcelWorksheet>").append(
                    "<x:Name>Sheet1</x:Name>").append("<x:WorksheetOptions>").append(
                    "<x:Print>").append("<x:ValidPrinterInfo />").append(
                    "</x:Print>").append("</x:WorksheetOptions>").append(
                    "</x:ExcelWorksheet>").append("</x:ExcelWorksheets>")
            .append("</x:ExcelWorkbook>").append("</xml><![endif]-->")
            .append("<style type=\"text/css\"><!-- ")
            .append(".txt{padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:black;font-size:11.0pt;font-weight:400;font-style:normal;text-decoration:none;font-family:宋体;mso-generic-font-family:auto;mso-font-charset:134;mso-number-format:\"\\@\";text-align:general;vertical-align:middle;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;} --> </style>")
            .append("</head>").append("<body>").append("<table>");
	
	public static final StringBuffer FOOTER = new StringBuffer("</table></body></html>");
	
	public static final StringBuffer EXPORT_SQL_CONTENT = new StringBuffer(1000)
    .append("SELECT t.patientId FROM u_patient t ")
    .append("INNER JOIN u_user u ON u.userId=t.userId ")
    .append("LEFT JOIN followup_db.var_patient_followup f ON f.patientId=t.patientId ")
    .append("LEFT JOIN ehr_db.var_patient_medical pm ON pm.patientId=t.patientId ");
	
	public static final StringBuffer EXPORT_SQL_SIMPLE = new StringBuffer(1000)
		    .append("where t.patientId in (SELECT t.patientId FROM u_patient t  "
		    		+ "INNER JOIN u_user u ON u.userId=t.userId "
		    		+ "INNER JOIN uuid_patient_merge pm ON pm.patientid=t.patientId AND pm.repeatflag=1 "
		    		+"where pm.goalpatientid in "
		    		+ "(SELECT pm.goalpatientid FROM u_patient t "
		    		+ "INNER JOIN u_user u ON u.userId=t.userId "
		    		+ "INNER JOIN uuid_patient_merge pm ON pm.patientid=t.patientId AND pm.repeatflag=1 ");
	
	/**
	 * 获取excel导出where 条件
	 * @param searchMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getWhereCondition(Map<String,Object> searchMap) {
		StringBuffer whereBuffer = new StringBuffer();
		if(searchMap != null && searchMap.size() > 0) {
			whereBuffer.append("WHERE t.outPatientFlag=2 AND t.patientType=1 AND t.mergeFlag!=2 ");
			//查询范围
			Integer patientRangeFlag = (Integer)searchMap.get("patientRangeFlag");
			//随访范围
			Integer followupRangeFlag = (Integer)searchMap.get("followupRangeFlag");
			if(patientRangeFlag==null){
				//全部患者 无需约束
			}else{
				boolean isIn = patientRangeFlag==1;

				if(followupRangeFlag==0){//判断患者肿瘤类型
					whereBuffer.append(" AND t.sourceTumorFlag ").append(isIn?" in ":" not in ").append("(1) ");
				}else if(followupRangeFlag==1){
					String notMalignantTumorFlag = (String)searchMap.get("notMalignantTumorFlag");//非恶心肿瘤
					whereBuffer.append(" AND t.sourceTumorFlag ").append(isIn?" in ":" not in ").append("(");
					if(StringUtils.isNotEmpty(notMalignantTumorFlag))
						whereBuffer.append(notMalignantTumorFlag);
					whereBuffer.append(")");	
				}else if(followupRangeFlag==2){//病种
					if(patientRangeFlag==1){
						whereBuffer.append(" AND (t1.sourceDiseaseTypeId in ")
						.append("(select diseaseTypeId from followup_db.conf_followup_range_disease_type)");
					}else{
						whereBuffer.append(" AND (t1.sourceDiseaseTypeId not in ")
						.append("(select diseaseTypeId from followup_db.conf_followup_range_disease_type)");
					}
				}else if(followupRangeFlag==3){//ICD
					if(patientRangeFlag==1){
						whereBuffer.append(" AND (t.icdDiseaseTypeId in ")
						.append("(select icdDiseaseTypeId from followup_db.conf_followup_range_icd where flag=1)")
						.append(" OR t.sourceDiseaseCode in ")
						.append("(select diseaseCode from followup_db.conf_followup_range_icd_code where flag=1))");
					}else{
						whereBuffer.append(" AND (t.icdDiseaseTypeId not in ")
						.append("(select icdDiseaseTypeId from followup_db.conf_followup_range_icd where flag=1)")
						.append(" and t.sourceDiseaseCode not in ")
						.append("(select diseaseCode from followup_db.conf_followup_range_icd_code where flag=1))");
					}
					}
				}
			//患者编号
			Object obj = searchMap.get("patientId");
			if(obj != null) {
				whereBuffer.append(" AND t.patientId=").append(obj);
			}
			//患者病案号
			obj = searchMap.get("patientNo");
			if(obj != null) {
				//whereBuffer.append(" AND t.patientNo LIKE '%").append(obj).append("%' ");
				//modify by fanpanwei
				whereBuffer.append(" AND (t.patientNo LIKE '%").append(obj).append("%' OR");
				whereBuffer.append(" EXISTS (SELECT 1 FROM user_db.r_uuid_patientno pn WHERE pn.patientId = t.patientId AND pn.patientNo LIKE '%").append(obj).append("%') )");
			}
			//患者病案号数组
			obj = searchMap.get("batchPatientNo");
			if(obj != null) {
				//whereBuffer.append(" AND t.patientNo IN(").append(obj).append(") ");
				//modify by fanpanwei
				whereBuffer.append(" AND (t.patientNo IN(").append(obj).append(") OR");
				whereBuffer.append(" EXISTS (SELECT 1 FROM user_db.r_uuid_patientno pn WHERE pn.patientId = t.patientId AND pn.patientNo  IN(").append(obj).append(")) )");
			}
			//手机号
			obj = searchMap.get("mobile");
			if(obj != null) {
				//whereBuffer.append(" AND t.mobile LIKE '%").append(obj).append("%'");
				//add by fanpanwei
				whereBuffer.append(" AND t.patientId IN(SELECT patientId FROM user_db.u_patient_family WHERE familyPhone LIKE '%").append(obj).append("%')");
			}
			//姓名
			obj = searchMap.get("trueName");
			if(obj != null) {
				whereBuffer.append(" AND t.trueName LIKE '%").append(obj).append("%'");
			}
			//原发诊断
			obj = searchMap.get("sourceDiagnosis");
			if(obj != null) {
				whereBuffer.append(" AND t.sourceDiagnosis LIKE '%").append(obj).append("%'");
			}
			//原发诊断编码
			obj = searchMap.get("sourceDiseaseCode");
			if(obj != null) {
				whereBuffer.append(" AND t.sourceDiseaseCode LIKE '%").append(obj).append("%'");
			}
			//主要诊断
			obj = searchMap.get("sourceDiseaseTypeId");
			if(obj != null) {
				whereBuffer.append(" AND t.sourceDiseaseTypeId=").append(obj);
			}
			//原发病种集合
			obj = searchMap.get("sourceDiseaseTypeIds");
			if(obj != null) {
				List<Integer> list = (List<Integer>)obj;
				if(list.size()>0){
					whereBuffer.append(" AND t.sourceDiseaseTypeId in (");
					int i = 0;
					for(Integer diseaseTypeId : list){
						if(i>0)
							whereBuffer.append(",");
						whereBuffer.append(diseaseTypeId+"");
						i++;
					}
					whereBuffer.append(")");
				}
			}
			//确诊起始时间
			obj = searchMap.get("confirmedDateStart");
			if(obj != null) {
				whereBuffer.append(" AND t.confirmedDate >=").append("'").append(obj+"").append("'");
			}
			//确诊结束时间
			obj = searchMap.get("confirmedDateEnd");
			if(obj != null) {
				whereBuffer.append(" AND t.confirmedDate <=").append("'").append(obj+"").append("'");
			}
			//原发病理诊断
			obj = searchMap.get("sourcePathologyDiagnosis");
			if(obj != null) {
				whereBuffer.append(" AND t.sourcePathologyDiagnosis LIKE '%").append(obj).append("%'");
			}
			//原发病理诊断编码
			obj = searchMap.get("sourcePathologyDiseaseCode");
			if(obj != null) {
				whereBuffer.append(" AND t.sourcePathologyDiseaseCode LIKE '%").append(obj).append("%'");
			}
			//治疗地标识
			obj = searchMap.get("treatmentPlaceState");
			if(obj != null) {
				if("2".equals(obj)){
					whereBuffer.append(" AND t.outPatientFlag=1");
				}else if(!"2".equals(obj)){
					whereBuffer.append(" AND t.inhospitalState=").append(obj);
				}
			}
			//入院日期
			Object inhospitalTimes = searchMap.get("inhospitalTimes");
			Object inhospitalDateStart = searchMap.get("inhospitalDateStart");
			Object inhospitalDateEnd = searchMap.get("inhospitalDateEnd");
			//入院科室
			Object inhospitalDeptTimes = searchMap.get("inhospitalDeptTimes");
			Object inhospitalDeptId = searchMap.get("inhospitalDeptId");
			//出院次数
			Object outhospitalTimes = searchMap.get("outhospitalTimes");
			//出院起始时间
			Object outhospitalDateStart = searchMap.get("outhospitalDateStart");
			//出院结束时间
			Object outhospitalDateEnd = searchMap.get("outhospitalDateEnd");
			//出院科别集合
			Object outHospitalDeptTimes = searchMap.get("outHospitalDeptTimes");
			Object outhospitalDeptId = searchMap.get("outhospitalDeptId");
			if((inhospitalDateStart != null || inhospitalDateEnd != null)||inhospitalTimes != null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if((inhospitalTimes != null && (Integer)inhospitalTimes == 9)){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(inhospitalTimes != null && (Integer)inhospitalTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if((inhospitalTimes != null && (Integer)inhospitalTimes == -1)) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				
				
				if(inhospitalDateStart != null) {
					whereBuffer.append(" AND DATE_FORMAT(note.inhospitalDate,'%Y-%m-%d')>=DATE_FORMAT('").append(inhospitalDateStart).append("','%Y-%m-%d')");			
				}
				if(inhospitalDateEnd != null) {
					whereBuffer.append(" AND DATE_FORMAT(note.inhospitalDate,'%Y-%m-%d')<=DATE_FORMAT('").append(inhospitalDateEnd).append("','%Y-%m-%d')");
				}
				whereBuffer.append(" ) "); 
			}
			
			if((inhospitalDeptId != null && ((List<Integer>)inhospitalDeptId).size() > 0)||inhospitalDeptTimes != null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if(inhospitalDeptTimes != null && (Integer)inhospitalDeptTimes == 9){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(inhospitalDeptTimes != null && (Integer)inhospitalDeptTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if(inhospitalDeptTimes != null && (Integer)inhospitalDeptTimes == -1) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				if(inhospitalDeptId != null && ((List<Integer>)inhospitalDeptId).size() > 0) {
					StringBuffer inhospitalDeptIdBuffer = new StringBuffer();
					List<Integer> inhospitalDeptIdList = ((List<Integer>) inhospitalDeptId);
					for(int i = 0;i < inhospitalDeptIdList.size();i++) {
						if(i < inhospitalDeptIdList.size()-1) {
							inhospitalDeptIdBuffer.append(inhospitalDeptIdList.get(i)).append(",");
						}else {
							inhospitalDeptIdBuffer.append(inhospitalDeptIdList.get(i));
						}
					}
					whereBuffer.append(" AND note.inhospitalDeptId IN(").append(inhospitalDeptIdBuffer.toString()).append(")");
				}
				whereBuffer.append(" ) "); 
			}
			
			if((outhospitalDateStart!=null||outhospitalDateEnd!=null)||outhospitalTimes!=null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if((outhospitalTimes!=null && (Integer)outhospitalTimes == 9)){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(outhospitalTimes!=null && (Integer)outhospitalTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if(outhospitalTimes!=null && (Integer)outhospitalTimes == -1) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				if(outhospitalDateStart!=null)
					whereBuffer.append(" AND DATE_FORMAT(note.outhospitalDate,'%Y-%m-%d') >=").append("DATE_FORMAT('").append(outhospitalDateStart+"").append("','%Y-%m-%d')");
				if(outhospitalDateEnd!=null)
					whereBuffer.append(" AND DATE_FORMAT(note.outhospitalDate,'%Y-%m-%d') <=").append("DATE_FORMAT('").append(outhospitalDateEnd+"").append("','%Y-%m-%d')");
				whereBuffer.append(" ) "); 
			}
			
			
			if(outhospitalDeptId != null && ((List<Integer>)outhospitalDeptId).size() > 0||outHospitalDeptTimes != null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if(outHospitalDeptTimes != null && (Integer)outHospitalDeptTimes == 9){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(outHospitalDeptTimes != null && (Integer)outHospitalDeptTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if(outHospitalDeptTimes != null && (Integer)outHospitalDeptTimes == -1) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				if(outhospitalDeptId != null && ((List<Integer>)outhospitalDeptId).size() > 0) {
					StringBuffer outhospitalDeptIdBuffer = new StringBuffer();
					List<Integer> outhospitalDeptIdList = ((List<Integer>) outhospitalDeptId);
					for(int i = 0;i < outhospitalDeptIdList.size();i++) {
						if(i < outhospitalDeptIdList.size()-1) {
							outhospitalDeptIdBuffer.append(outhospitalDeptIdList.get(i)).append(",");
						}else {
							outhospitalDeptIdBuffer.append(outhospitalDeptIdList.get(i));
						}
					}
					whereBuffer.append(" AND note.outhospitalDeptId IN(").append(outhospitalDeptIdBuffer.toString()).append(")");
				}
				whereBuffer.append(" ) "); 
			}
			//科主任
			Object deptDoctor = searchMap.get("deptDoctor");
			Object deptDoctorTimes = searchMap.get("deptDoctorTimes");
			if(deptDoctor != null || deptDoctorTimes != null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if(deptDoctorTimes != null && (Integer)deptDoctorTimes == 9){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(deptDoctorTimes != null && (Integer)deptDoctorTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if(deptDoctorTimes != null && (Integer)deptDoctorTimes == 2) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				if(deptDoctor != null) {
					whereBuffer.append(" AND note.deptDoctor=").append(deptDoctor);
				}
				whereBuffer.append(" ) "); 
			}
			//主任医师
			Object directorDoctor = searchMap.get("directorDoctor");
			Object directorDoctorTimes = searchMap.get("directorDoctorTimes");
			if(deptDoctor != null || directorDoctorTimes != null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if(directorDoctorTimes != null && (Integer)directorDoctorTimes == 9){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(directorDoctorTimes != null && (Integer)directorDoctorTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if(directorDoctorTimes != null && (Integer)directorDoctorTimes == 2) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				if(directorDoctor != null) {
					whereBuffer.append(" AND note.directorDoctor=").append(directorDoctor);
				}
				whereBuffer.append(" ) "); 
			}
			//主治医师
			Object inchargeDoctor = searchMap.get("inchargeDoctor");
			Object inchargeDoctorTimes = searchMap.get("inchargeDoctorTimes");
			if(deptDoctor != null || inchargeDoctorTimes != null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if(inchargeDoctorTimes != null && (Integer)inchargeDoctorTimes == 9){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(inchargeDoctorTimes != null && (Integer)inchargeDoctorTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if(inchargeDoctorTimes != null && (Integer)inchargeDoctorTimes == 2) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				if(inchargeDoctor != null) {
					whereBuffer.append(" AND note.inchargeDoctor=").append(inchargeDoctor);
				}
				whereBuffer.append(" ) "); 
			}
			//住院医师
			Object inhospitalDoctor = searchMap.get("inhospitalDoctor");
			Object inhospitalDoctorTimes = searchMap.get("inhospitalDoctorTimes");
			if(deptDoctor != null || inhospitalDoctorTimes != null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note ");
				if(inhospitalDoctorTimes != null && (Integer)inhospitalDoctorTimes == 9){
					whereBuffer.append("JOIN user_db.u_patient v1 ON note.patientId=v1.patientId AND note.inhospitalId=v1.inhospitalId ");
				}
				whereBuffer.append("WHERE note.patientId=t.patientId ");
				if(inhospitalDoctorTimes != null && (Integer)inhospitalDoctorTimes == 1){
					whereBuffer.append(" AND note.inhospitalTimes = 1");
				}
				if(inhospitalDoctorTimes != null && (Integer)inhospitalDoctorTimes == 2) {
					whereBuffer.append(" AND note.inhospitalLastTime = 1");
				}
				if(inhospitalDoctor != null) {
					whereBuffer.append(" AND note.inhospitalDoctor=").append(inhospitalDoctor);
				}
				whereBuffer.append(" ) "); 
			}
			
			//缺失类型/错误类型
			obj = searchMap.get("faultType");
			if(obj != null) {
				whereBuffer.append(" AND (t.patientNoDataFlag=0 OR t.contactDataFlag IN(0,-1) OR t.diagnosisDataFlag=0 OR t.diseaseCodeDataFlag IN(0,-1) OR t.IdentificationDataFlag IN(0,-1) OR t.trueNameDataFlag IN(0,-1) OR t.diseaseTypeDataFlag=0 OR t.treatmentTypeDataFlag=0 OR t.tumourPeriodizationDataFlag=0 OR t.pathologyDiseaseDataFlag=0 OR t.pathologyDiseaseCodeDataFlag=0)");
			}
			//缺失类型
			obj = searchMap.get("missingType");
			if(obj != null) {
				if(obj instanceof Integer) {
					Integer missingType = (Integer)obj;
					if(missingType ==1) {
						whereBuffer.append(" AND t.diagnosisDataFlag=0");
					}
					else if(missingType ==2) {
						whereBuffer.append(" AND t.diseaseCodeDataFlag=0");
					}
					else if(missingType ==3) {
						whereBuffer.append(" AND t.contactDataFlag=0");
					}
					else if(missingType ==4) {
						whereBuffer.append(" AND t.patientNoDataFlag=0");
					}
					else if(missingType ==5) {
						whereBuffer.append(" AND t.IdentificationDataFlag=0");
					}
					else if(missingType ==6) {
						whereBuffer.append(" AND t.diseaseTypeDataFlag=0");
					}
					else if(missingType ==7) {
						whereBuffer.append(" AND t.treatmentTypeDataFlag=0");
					}
					else if(missingType ==8) {
						whereBuffer.append(" AND t.tumourPeriodizationDataFlag=0");
					}
					else if(missingType ==9) {
						whereBuffer.append(" AND t.pathologyDiseaseDataFlag=0");
					}
					else if(missingType ==10) {
						whereBuffer.append(" AND t.pathologyDiseaseCodeDataFlag=0");
					}
					else if(missingType ==11) {
						whereBuffer.append(" AND t.trueNameDataFlag=0");
					}
					else if(missingType ==99) {
						whereBuffer.append(" AND ("
								+ "t.patientNoDataFlag=0 "
								+ "OR t.contactDataFlag=0 "
								+ "OR t.diagnosisDataFlag=0 "
								+ "OR t.diseaseCodeDataFlag=0 "
								+ "OR t.IdentificationDataFlag=0 "
								+ "OR t.diseaseTypeDataFlag=0 "
								+ "OR t.treatmentTypeDataFlag=0 "
								+ "OR t.tumourPeriodizationDataFlag=0 "
								+ "OR t.pathologyDiseaseDataFlag=0 "
								+ "OR t.pathologyDiseaseCodeDataFlag=0 "
								+ ")");
					}
				}
			}
			//错误类型
			obj = searchMap.get("invalidType");
			if(obj != null) {
				if(obj instanceof Integer) {
					Integer invalidType = (Integer)obj;
					if(invalidType == 1) {
						whereBuffer.append(" AND t.diseaseCodeDataFlag=-1");
					}
					else if(invalidType == 2) {
						whereBuffer.append(" AND t.contactDataFlag=-1");
					}
					else if(invalidType == 3) {
						whereBuffer.append(" AND t.IdentificationDataFlag=-1");
					}
					else if(invalidType == 4) {
						whereBuffer.append(" AND t.trueNameDataFlag=-1");
					}
					else if(invalidType == 99) {
						whereBuffer.append(" AND ("
								+ "t.diseaseCodeDataFlag =- 1 "
								+ "OR t.contactDataFlag =- 1 "
								+ "OR t.IdentificationDataFlag=-1 "
								+ "OR t.trueNameDataFlag=-1"
								+ ")");
					}
				}
			}
			//疑似重复类型
			obj = searchMap.get("similarType");
			if(obj != null) {
				whereBuffer.append(" AND EXISTS(SELECT pm.patientid FROM uuid_patient_merge pm WHERE pm.patientid=t.patientId AND pm.repeatflag=1 and pm.cancelflag=0)");
			}
			//随访标识
			obj = searchMap.get("followupFlag");
			if(obj != null && ((Integer)obj)==2) {
				whereBuffer.append(" AND t.followupFlag=").append(obj);
				obj = searchMap.get("lostFollowupCauseResultValue");
				if(obj != null) {
					if(obj.toString().contains("[")){
						JSONArray parse = JSONArray.parseArray(obj.toString());
						String valStr = "(";
						for (Iterator<Object> iterator = parse.iterator(); iterator
								.hasNext();) {
							valStr+=iterator.next().toString();
							if(iterator.hasNext()){
								valStr+=",";
							}
						}
						valStr+=")";
						whereBuffer.append(" AND t.lostFollowupCauseResultValue IN ").append(valStr);
					}else{
						whereBuffer.append(" AND t.lostFollowupCauseResultValue=").append(obj);
					}
				}
			}
			
			//全部疾病类型
			obj = searchMap.get("sourceTumorFlag");
			if(obj != null) {
				if("-2".equals(obj+""))
					whereBuffer.append(" AND (t.sourceDiseaseTypeId IS NULL OR t.sourceTumorFlag=").append(obj).append(")");
				else
					whereBuffer.append(" AND t.sourceTumorFlag=").append(obj);
			}
			
			//随访结果
			obj = searchMap.get("followupTimes");
			Object followupOperator = searchMap.get("followupOperator");
			Object followupTimeStart = searchMap.get("followupTimeStart");
			Object followupTimeEnd = searchMap.get("followupTimeEnd");
			//随访结果
			Object followupResultValue = searchMap.get("followupResultValue");
			if(obj==null){//任意次
				if(followupOperator!=null||followupTimeStart!=null||followupTimeEnd!=null || followupResultValue != null){
					whereBuffer.append(" AND EXISTS (SELECT 1 FROM followup_db.followup_result fr WHERE fr.patientId=t.patientId ");
					if(followupOperator!=null && ((List<Integer>) followupOperator).size() > 0){
						StringBuffer followupOperatorBuffer = new StringBuffer();
						List<Integer> followupOperatorList = ((List<Integer>) followupOperator);
						for(int i = 0;i < followupOperatorList.size();i++) {
							if(i < followupOperatorList.size()-1) {
								followupOperatorBuffer.append(followupOperatorList.get(i)).append(",");
							}else {
								followupOperatorBuffer.append(followupOperatorList.get(i));
							}
						}
						whereBuffer.append(" AND fr.operator IN (").append(followupOperatorBuffer.toString()).append(")");
					}
					if(followupResultValue != null && ((List<Integer>)followupResultValue).size() > 0) {
						StringBuffer followupResultValueBuffer = new StringBuffer();
						List<Integer> followupResultValueList = ((List<Integer>) followupResultValue);
						for(int i = 0;i < followupResultValueList.size();i++) {
							if(i < followupResultValueList.size()-1) {
								followupResultValueBuffer.append(followupResultValueList.get(i)).append(",");
							}else {
								followupResultValueBuffer.append(followupResultValueList.get(i));
							}
						}
						whereBuffer.append(" AND fr.followupResultValue IN(").append(followupResultValueBuffer).append(")");
					}
					if(followupTimeStart!=null)
						whereBuffer.append(" AND fr.followupTime >= ").append("'").append(followupTimeStart).append("'");
					if(followupTimeEnd !=null)
						whereBuffer.append(" AND fr.followupTime <= ").append("'").append(followupTimeEnd).append("'");
					whereBuffer.append(")");
				}
			}else if((Integer)obj==-1){//末次
				if(followupOperator!=null||followupTimeStart!=null||followupTimeEnd!=null || followupResultValue != null){
					if(followupOperator!=null && ((List<Integer>) followupOperator).size() > 0){//随访人员
						StringBuffer followupOperatorBuffer = new StringBuffer();
						List<Integer> followupOperatorList = ((List<Integer>) followupOperator);
						for(int i = 0;i < followupOperatorList.size();i++) {
							if(i < followupOperatorList.size()-1) {
								followupOperatorBuffer.append(followupOperatorList.get(i)).append(",");
							}else {
								followupOperatorBuffer.append(followupOperatorList.get(i));
							}
						}
						whereBuffer.append(" AND f.followupOperator IN (").append(followupOperatorBuffer.toString()).append(")");
					}
					if(followupTimeStart!=null)
						whereBuffer.append(" AND f.latestFollowupTime >= ").append("'").append(followupTimeStart).append("'");
					if(followupTimeEnd !=null)
						whereBuffer.append(" AND f.latestFollowupTime <= ").append("'").append(followupTimeEnd).append("'");
					if(followupResultValue != null && ((List<Integer>)followupResultValue).size() > 0) {
						StringBuffer followupResultValueBuffer = new StringBuffer();
						List<Integer> followupResultValueList = ((List<Integer>) followupResultValue);
						for(int i = 0;i < followupResultValueList.size();i++) {
							if(i < followupResultValueList.size()-1) {
								followupResultValueBuffer.append(followupResultValueList.get(i)).append(",");
							}else {
								followupResultValueBuffer.append(followupResultValueList.get(i));
							}
						}
						whereBuffer.append(" AND f.followupResultValue IN(").append(followupResultValueBuffer).append(")");
					}
				}
			}else if((Integer)obj==1) {//首次
				if(followupOperator!=null||followupTimeStart!=null||followupTimeEnd!=null || followupResultValue != null){
					whereBuffer.append(" AND EXISTS (SELECT 1 FROM followup_db.followup_result v1 JOIN (SELECT patientId,MIN(followupTime) maxFollowupTime FROM followup_db.followup_result GROUP BY patientId) v2 ON v1.patientId=v2.patientId AND v1.followupTime=v2.maxFollowupTime WHERE v1.patientId=t.patientId");
					if(followupOperator!=null && ((List<Integer>) followupOperator).size() > 0){//随访人员
						StringBuffer followupOperatorBuffer = new StringBuffer();
						List<Integer> followupOperatorList = ((List<Integer>) followupOperator);
						for(int i = 0;i < followupOperatorList.size();i++) {
							if(i < followupOperatorList.size()-1) {
								followupOperatorBuffer.append(followupOperatorList.get(i)).append(",");
							}else {
								followupOperatorBuffer.append(followupOperatorList.get(i));
							}
						}
						whereBuffer.append(" AND v1.operator IN (").append(followupOperatorBuffer.toString()).append(")");
					}
					if(followupResultValue != null && ((List<Integer>)followupResultValue).size() > 0) {
						StringBuffer followupResultValueBuffer = new StringBuffer();
						List<Integer> followupResultValueList = ((List<Integer>) followupResultValue);
						for(int i = 0;i < followupResultValueList.size();i++) {
							if(i < followupResultValueList.size()-1) {
								followupResultValueBuffer.append(followupResultValueList.get(i)).append(",");
							}else {
								followupResultValueBuffer.append(followupResultValueList.get(i));
							}
						}
						whereBuffer.append(" AND v1.followupResultValue IN(").append(followupResultValueBuffer).append(")");
					}
					if(followupTimeStart!=null)
						whereBuffer.append(" AND v1.followupTime >= ").append("'").append(followupTimeStart).append("'");
					if(followupTimeEnd !=null)
						whereBuffer.append(" AND v1.followupTime <= ").append("'").append(followupTimeEnd).append("'");
					whereBuffer.append(")");
				}
			}
			//261需求新增
			//性别集合
			obj = searchMap.get("sex");
			if(obj != null && ((List<Integer>) obj).size() > 0) {
				StringBuffer sexBuffer = new StringBuffer();
				List<Integer> sexList = ((List<Integer>) obj);
				for(int i = 0;i < sexList.size();i++) {
					if(i < sexList.size()-1) {
						sexBuffer.append(sexList.get(i)).append(",");
					}else {
						sexBuffer.append(sexList.get(i));
					}
				}
				whereBuffer.append(" AND t.sex IN(").append(sexBuffer.toString()).append(")");
			}
			//出生日期
			obj = searchMap.get("birthDateStart");
			if(obj != null) {
				whereBuffer.append(" AND DATE_FORMAT(t.birthDate,'%Y-%m-%d')>=DATE_FORMAT('").append(obj).append("','%Y-%m-%d')");
			}
			obj = searchMap.get("birthDateEnd");
			if(obj != null) {
				whereBuffer.append(" AND DATE_FORMAT(t.birthDate,'%Y-%m-%d')<=DATE_FORMAT('").append(obj).append("','%Y-%m-%d')");
			}
			//城市集合
			obj = searchMap.get("cityId");
			if(obj != null && ((List<Integer>) obj).size() > 0) {
				StringBuffer cityIdBuffer = new StringBuffer();
				List<Integer> cityIdList = ((List<Integer>) obj);
				for(int i = 0;i < cityIdList.size();i++) {
					if(i < cityIdList.size()-1) {
						cityIdBuffer.append(cityIdList.get(i)).append(",");
					}else {
						cityIdBuffer.append(cityIdList.get(i));
					}
				}
				whereBuffer.append(" AND EXISTS(SELECT userId FROM user_db.u_user WHERE userId=t.userId AND cityId IN(").append(cityIdBuffer.toString()).append(")");
			}
			//治疗方式集合
			obj = searchMap.get("treatmentTypeIds");
			if(obj != null && ((List<Integer>) obj).size() > 0) {
				StringBuffer treatmentTypeIdsBuffer = new StringBuffer();
				List<Integer> treatmentTypeIdsList = ((List<Integer>) obj);
				for(int i = 0;i < treatmentTypeIdsList.size();i++) {
					if(i < treatmentTypeIdsList.size()-1) {
						treatmentTypeIdsBuffer.append(treatmentTypeIdsList.get(i)).append(",");
					}else {
						treatmentTypeIdsBuffer.append(treatmentTypeIdsList.get(i));
					}
				}
				whereBuffer.append(" AND EXISTS(SELECT patientId FROM ehr_db.eci_treatment_note WHERE patientId=t.patientId AND treatmentTypeId IN(").append(treatmentTypeIdsBuffer.toString()).append("))");
			}
			//确诊日期
			obj = searchMap.get("confirmedAgeStart");
			if(obj != null) {
				whereBuffer.append(" AND t.confirmedAge>=").append(obj);
			}
			obj = searchMap.get("confirmedAgeEnd");
			if(obj != null) {
				whereBuffer.append(" AND t.confirmedAge<=").append(obj);
			}
			Object lostPatientChange = searchMap.get("lostPatientChange");
			if(lostPatientChange != null) {
				Integer lostPatientChangeInt = (Integer)lostPatientChange;
				if(lostPatientChangeInt == 1) {
					whereBuffer.append(" AND EXISTS(SELECT patientId FROM followup_db.var_patient_followup WHERE patientId=t.patientId AND newVisitFlag=1)");
				}else if(lostPatientChangeInt == 2) {
					whereBuffer.append(" AND EXISTS(SELECT patientId FROM followup_db.var_patient_followup WHERE patientId=t.patientId AND newContactFlag=1)");
				}else if(lostPatientChangeInt == 3) {
					whereBuffer.append(" AND EXISTS(SELECT patientId FROM followup_db.var_patient_followup WHERE patientId=t.patientId AND newVisitFlag=1 AND newContactFlag=1)");
				}
			}
			//合并患者标识
			Object mergeFlag = searchMap.get("mergeFlag");
			if(mergeFlag != null) {
				whereBuffer.append(" AND t.mergeFlag=").append(mergeFlag);
			}
			
			//263新增功能，数据质量分析-增加随访数据错误
			Object followupInvliadType = searchMap.get("followupInvliadType");
			if(followupInvliadType != null) {
				Integer followupInvliadTypeInt = (Integer)followupInvliadType;
				if(followupInvliadTypeInt == 1) {
					whereBuffer.append(" AND t.moreDeathFollowupResultFlag = -1");
				}
				if(followupInvliadTypeInt == 2) {
					whereBuffer.append(" AND t.deathNotFollowupResultFlag = -1");
				}
				if(followupInvliadTypeInt == 3) {
					whereBuffer.append(" AND t.deathNotFollowupTimeFlag = -1");
				}
				if(followupInvliadTypeInt == 4) {
					whereBuffer.append(" AND t.deathAfterHasFollowupResultFlag = -1");
				}
				if(followupInvliadTypeInt == 5) {
					whereBuffer.append(" AND t.medicalRecordNotFollowupResultFlag = -1");
				}
				if(followupInvliadTypeInt == 6) {
					whereBuffer.append(" AND t.deathPatientIntoTask = -1");
				}
				if(followupInvliadTypeInt == 7) {
					whereBuffer.append(" AND t.lostPatientIntoTask = -1");
				}
				if(followupInvliadTypeInt == 99) {
					whereBuffer.append(" AND (t.moreDeathFollowupResultFlag =- 1 ");
					whereBuffer.append(" OR t.deathNotFollowupResultFlag =- 1  ");
					whereBuffer.append(" OR t.deathNotFollowupTimeFlag =- 1  ");
					whereBuffer.append(" OR t.deathAfterHasFollowupResultFlag =- 1  ");
					whereBuffer.append(" OR t.medicalRecordNotFollowupResultFlag =- 1  ");
					whereBuffer.append(" OR t.deathPatientIntoTask =- 1 ");
					whereBuffer.append(" OR t.lostPatientIntoTask =- 1) ");
				}
			}
		}
		return whereBuffer.toString();
	}
	
	/**
	 * 根据属性key获取标题list
	 * @param key
	 * @return
	 */
	public static Collection<String> getTitle(String key) {
		Collection<String> titles = new ArrayList<String>();
		String tmp = TemplateUtil.getExcelExportInfo(key);
		LOGGER.info("打印标题列表:" + tmp);
		String[] titleSplit = tmp.split(",");
		for(String title : titleSplit) {
			titles.add(title);
		}
		return titles;
	}
}
