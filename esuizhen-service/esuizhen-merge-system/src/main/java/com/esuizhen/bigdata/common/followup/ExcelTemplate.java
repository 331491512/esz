package com.esuizhen.bigdata.common.followup;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 获取excel导出where 条件
	 * @param searchMap
	 * @return
	 */
	public static String getWhereCondition(Map<String,Object> searchMap) {
		StringBuffer whereBuffer = new StringBuffer();
		if(searchMap != null && searchMap.size() > 0) {
			whereBuffer.append("WHERE t.outPatientFlag=2 ");
			//查询范围
			Integer patientRangeFlag = (Integer)searchMap.get("patientRangeFlag");
			//随访范围
			Integer followupRangeFlag = (Integer)searchMap.get("followupRangeFlag");
			if(patientRangeFlag==null){
				//全部患者 无需约束
			}else{
				boolean isIn = patientRangeFlag==1;
				if(followupRangeFlag==0||followupRangeFlag==1){//判断患者肿瘤类型
					String notMalignantTumorFlag = (String)searchMap.get("notMalignantTumorFlag");//非恶心肿瘤
					whereBuffer.append(" AND t.sourceTumorFlag ").append(isIn?" in ":" not in ").append("(1");
					if(followupRangeFlag==1&& StringUtils.isNotEmpty(notMalignantTumorFlag))
						whereBuffer.append(",").append(notMalignantTumorFlag);
					whereBuffer.append(")");	
				}else if(followupRangeFlag==3){//编码表
					whereBuffer.append(" AND t.icdDiseaseTypeId ")
					.append(isIn?" in ":" not in ")
					.append("(select icdDiseaseTypeId from followup_db.conf_followup_range_icd)");
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
				whereBuffer.append(" AND t.patientNo LIKE '%").append(obj).append("%'");
			}
			//患者病案号数组
			obj = searchMap.get("batchPatientNo");
			if(obj != null) {
				whereBuffer.append(" AND t.patientNo IN(").append(obj).append(")");
			}
			//手机号
			obj = searchMap.get("mobile");
			if(obj != null) {
				whereBuffer.append(" AND t.mobile LIKE '%").append(obj).append("%'");
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
			//主要诊断集合
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
			//出院次数
			obj = searchMap.get("outhospitalTimes");
			//出院起始时间
			Object outhospitalDateStart = searchMap.get("outhospitalDateStart");
			//出院结束时间
			Object outhospitalDateEnd = searchMap.get("outhospitalDateEnd");
			if(obj!=null||outhospitalDateStart!=null||outhospitalDateEnd!=null){
				whereBuffer.append(" AND EXISTS (SELECT 1 FROM ehr_db.ei_inhospital_note note WHERE note.patientId=t.patientId ");
				if(obj!=null){
					Integer outhospitalTimes = (Integer)obj;
					if(outhospitalTimes==1){
						whereBuffer.append(" AND inhospitalTimes = 1");
					}else if(outhospitalTimes==2){
						whereBuffer.append(" AND inhospitalLastTime = 1");
					}
				}
				if(outhospitalDateStart!=null)
					whereBuffer.append(" AND DATE_FORMAT(outhospitalDate,'%Y-%m-%d') >=").append("'").append(outhospitalDateStart+"").append("'");
				if(outhospitalDateEnd!=null)
					whereBuffer.append(" AND DATE_FORMAT(outhospitalDate,'%Y-%m-%d') <=").append("'").append(outhospitalDateEnd+"").append("'");
				whereBuffer.append(" ) "); 
			}
			//缺失类型/错误类型
			obj = searchMap.get("faultType");
			if(obj != null) {
				whereBuffer.append(" AND (t.patientNoDataFlag=0 OR t.contactDataFlag IN(0,-1) OR t.diagnosisDataFlag=0 OR t.diseaseCodeDataFlag IN(0,-1) OR t.IdentificationDataFlag IN(0,-1) OR t.trueNameDataFlag=-1 OR diseaseTypeDataFlag=0)");
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
						whereBuffer.append(" AND diseaseCodeDataFlag=0");
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
					else if(missingType ==99) {
						whereBuffer.append(" AND ("
								+ "t.patientNoDataFlag=0 "
								+ "OR t.contactDataFlag=0 "
								+ "OR t.diagnosisDataFlag=0 "
								+ "OR diseaseCodeDataFlag=0 "
								+ "OR t.IdentificationDataFlag=0 "
								+ "OR diseaseTypeDataFlag=0"
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
				whereBuffer.append(" AND t.patientId IN(SELECT pm.patientid FROM uuid_patient_merge pm WHERE pm.patientid=t.patientId AND pm.repeatflag=1 and pm.cancelflag=0)");
			}
			//随访标识
			obj = searchMap.get("followupFlag");
			if(obj != null && ((Integer)obj)==2) {
				whereBuffer.append(" AND t.followupFlag=").append(obj);
				obj = searchMap.get("lostFollowupCauseResultValue");
				if(obj != null) {
					whereBuffer.append(" AND t.lostFollowupCauseResultValue=").append(obj);
				}
			}
			//随访结果
			obj = searchMap.get("followupResultValue");
			if(obj != null) {
				whereBuffer.append(" AND t.patientId IN(SELECT f.patientId FROM followup_db.var_patient_followup f WHERE f.followupResultValue=").append(obj).append(")");
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
			if(obj==null){//任意次
				if(followupOperator!=null||followupTimeStart!=null||followupTimeEnd!=null){
					whereBuffer.append(" AND EXISTS (SELECT 1 FROM followup_db.followup_result fr WHERE fr.patientId=t.patientId ");
					if(followupOperator!=null)
						whereBuffer.append(" AND fr.operator = ").append(followupOperator);
					if(followupTimeStart!=null)
						whereBuffer.append(" AND fr.followupTime >= ").append("'").append(followupTimeStart).append("'");
					if(followupTimeEnd !=null)
						whereBuffer.append(" AND fr.followupTime <= ").append("'").append(followupTimeEnd).append("'");
					whereBuffer.append(")");
				}
			}else if((Integer)obj==-1){//末次
				if(followupOperator!=null||followupTimeStart!=null||followupTimeEnd!=null){
					if(followupOperator!=null)
						whereBuffer.append(" AND f.followupOperator = ").append(followupOperator);
					if(followupTimeStart!=null)
						whereBuffer.append(" AND f.latestFollowupTime >= ").append("'").append(followupTimeStart).append("'");
					if(followupTimeEnd !=null)
						whereBuffer.append(" AND f.latestFollowupTime <= ").append("'").append(followupTimeEnd).append("'");
				}
			}
			//合并患者标识
			Object mergeFlag = searchMap.get("mergeFlag");
			if(mergeFlag != null) {
				whereBuffer.append(" AND t.mergeFlag=").append(mergeFlag);
			}
		}
		return whereBuffer.toString();
	}
	
	/**
	 * 根据属性key获取标题list
	 * @param key
	 * @return
	 */
	/*public static Collection<String> getTitle(String key) {
		Collection<String> titles = new ArrayList<String>();
		String tmp = TemplateUtil.getExcelExportInfo(key);
		LOGGER.info("打印标题列表:" + tmp);
		String[] titleSplit = tmp.split(",");
		for(String title : titleSplit) {
			titles.add(title);
		}
		return titles;
	}*/
}
