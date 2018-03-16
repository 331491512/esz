/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util.search;<br/>  
 * <b>文件名：</b>RetrievalParamentUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午4:12:17<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.westangel.common.bean.search.RetrievalConditionReq;
import com.westangel.common.bean.search.RetrievalParamentReq;
import com.westangel.common.util.JsonUtil;

/**
 * @ClassName: RetrievalParamentUtil
 * @Description:
 * @author lichenghao
 * @date 2016年8月10日 下午4:12:17
 */
public class RetrievalParamentUtil {
	// 库表对应关系
	public static Map<String, String> table_db;
	// 数据库表
	public static String[] tables = { "u_patient", "u_patient_family", "u_user", "r_hospital_patient", "eci_surgery_note", "eci_treatment_note", "ec_clinic_medical_note",
			"ei_inhospital_note", "e_diagnosis_info", "var_patient_medical", "followup_result", "ei_inhospital_cost", "ei_outhospital_note",
			"eci_treatment_chemotherapy_medication_detail", "e_symptom_info", "eci_treatment_chemotherapy_medication_detail", "e_tumour_family_history", "e_riskfactors",
			"e_qualityoflife_info" };

	// 加载Map元数据对应表
	public static void initTableDBMap(Map<String, String> table_db) {
		// 用户库
		table_db.put("u_patient", "user_db");
		table_db.put("u_patient_family", "user_db");
		table_db.put("u_user", "user_db");
		table_db.put("r_hospital_patient", "user_db");
		// 电子病历库
		table_db.put("eci_surgery_note", "ehr_db");
		table_db.put("eci_treatment_note", "ehr_db");
		table_db.put("ec_clinic_medical_note", "ehr_db");
		table_db.put("ei_inhospital_note", "ehr_db");
		table_db.put("e_diagnosis_info", "ehr_db");
		table_db.put("var_patient_medical", "ehr_db");
		// add by fanpanwei
		table_db.put("ei_inhospital_cost", "ehr_db");
		table_db.put("ei_outhospital_note", "ehr_db");
		table_db.put("eci_treatment_chemotherapy_medication_detail", "ehr_db");
		table_db.put("e_symptom_info", "ehr_db");
		table_db.put("eci_treatment_chemotherapy_medication_detail", "ehr_db");
		table_db.put("e_tumour_family_history", "ehr_db");
		table_db.put("e_riskfactors", "ehr_db");
		table_db.put("e_qualityoflife_info", "ehr_db");
		// 随访库
		table_db.put("followup_result", "followup_db");
	}

	// 初始化查询sql
	public static String loadingParaments(List<RetrievalParamentReq> list) {
		Map<String, String> tableMap = new LinkedHashMap<String, String>();
		Map<String, String> sqlMap = new HashMap<String, String>();
		Map<String, String> sqlMap2 = new HashMap<String, String>();
		Map<String, String> treamentMap = new HashMap<String, String>();
		int t = 1;
		if (table_db == null) {
			table_db = new HashMap<String, String>();
			initTableDBMap(table_db);
		}

		String conSql = "";
		String conSql2 = "";
		// tableMap.put("u_patient",
		// "t");
		// boolean uflag = true;
		if (list != null && !list.isEmpty()) {
			// 循环参数
			for (RetrievalParamentReq parament : list) {
				if (parament.getChildParaments() != null && parament.getChildParaments().length() > 0) {
					String[] table_column = parament.getChildParaments().split("\\.");
					String table = table_column[0];
					String column = table_column[1];
					if (tableMap.get(table) == null)
						tableMap.put(table, "t" + t++);

					if (tableMap.containsKey("u_user")) {
						if (tableMap.get("u_patient") == null)
							tableMap.put("u_patient", "t");
					}
					String alias = tableMap.get(table);
					// 添加相同表的条件
					String con = "";
					String paramentName = parament.getParamentName();
					if (paramentName != null) {
						if (paramentName.contains("首次")) {
							con = " AND " + alias + ".inhospitalTimes =1";
						} else if (paramentName.contains("末次")) {
							con = " AND " + alias + ".inhospitalLastTime =1";
						}
					}

					if (paramentName != null && (paramentName.equals("入院时间") || paramentName.equals("出院时间") || paramentName.equals("入院科室") || paramentName.equals("出院科室"))) {
						String tN1 = tableMap.get("ei_inhospital_note");
						String tN2 = tableMap.get("u_patient");
						if (StringUtils.isNotEmpty(tN1) && StringUtils.isNotEmpty(tN2)) {
							conSql = " and " + tN1 + ".inhospitalId=" + tN2 + ".inhospitalId";
						}
					}
					if (paramentName != null && paramentName.equals("治疗方式") && parament.getParamentType().equals("4")) {
						String tN1 = tableMap.get("eci_treatment_note");
						String tN2 = tableMap.get("u_patient");
						if (StringUtils.isNotEmpty(tN1) && StringUtils.isNotEmpty(tN2)) {
							conSql2 = " and " + tN1 + ".inhospitalId=" + tN2 + ".inhospitalId";
						}
					}
					if (paramentName != null && paramentName.equals("治疗方式") && parament.getParamentType().equals("5")) {
						if (parament.getConditions() != null) {
							String value = "";
							String unvalue = "";
							List<String> conditionVs = new ArrayList<String>();
							List<String> conditionNVs = new ArrayList<String>();
							Map<String, Integer> eqIndex = new HashMap<String, Integer>();
							Map<String, Integer> ueqIndex = new HashMap<String, Integer>();

							for (int i = 0; i < parament.getConditions().size(); i++) {
								Integer pconditonId = parament.getConditions().get(i).getConditionId();
								List<String> vL = parament.getConditions().get(i).getValues();
								if (pconditonId != null && pconditonId == 1 && vL.size() == 1) {
									if (!value.equals("")) {
										value += ",";
									}
									value += parament.getConditions().get(i).getValues().get(0);
									if (eqIndex.get("eqIndex") == null) {
										eqIndex.put("eqIndex", i);
									}
									parament.getConditions().get(i).setValues(new ArrayList());
								}
								if (pconditonId != null && pconditonId == 4 && vL.size() == 1) {
									if (!unvalue.equals("")) {
										unvalue += ",";
									}
									unvalue += parament.getConditions().get(i).getValues().get(0);
									if (ueqIndex.get("ueqIndex") == null) {
										ueqIndex.put("ueqIndex", i);
									}
									parament.getConditions().get(i).setValues(new ArrayList());
								}
							}
							conditionVs.add(value);
							conditionNVs.add(unvalue);
							if (eqIndex.get("eqIndex") != null) {
								parament.getConditions().get(eqIndex.get("eqIndex")).setValues(conditionVs);
							}
							if (ueqIndex.get("ueqIndex") != null) {
								parament.getConditions().get(ueqIndex.get("ueqIndex")).setValues(conditionNVs);
							}
						}
					}
					if (paramentName != null && paramentName.equals("治疗方式")) {
						String treatmentAlias = "t1";
						if (tableMap.containsValue("t")) {
							treatmentAlias = "t";
						}
						if (parament.getConditions() != null) {
							StringBuilder treatmentTypeSqlB11 = new StringBuilder();
							// StringBuilder
							// treatmentTypeSqlB22
							// = new
							// StringBuilder();
							StringBuilder treatmentTypeSqlB33 = new StringBuilder();
							StringBuilder treatmentTypeSqlB0 = new StringBuilder();
							// StringBuilder
							// treatmentTypeSqlB01
							// = new
							// StringBuilder();
							// StringBuilder
							// treatmentTypeSqlB44
							// = new
							// StringBuilder();
							for (int i = 0; i < parament.getConditions().size(); i++) {
								Integer pconditonId = parament.getConditions().get(i).getConditionId();
								if (pconditonId != null) {
									List<String> conditionVs = parament.getConditions().get(i).getValues();
									boolean conditionFlag = false;
									if (conditionVs.size() > 1) {
										conditionFlag = true;
									}
									if (conditionVs.size() > 0) {
										if (pconditonId == 1) { // 等于
											String values = conditionVs.get(0);
											if (parament.getParamentType().equals("5")) { // and

												if (values.indexOf(",") > 0) {
													treatmentTypeSqlB11.append(" select t1.patientId from ehr_db.eci_treatment_note t1 ");
													String[] vs = values.split(",");
													for (int j = 0; j < vs.length; j++) {
														treatmentTypeSqlB11.append(" join (select patientId from ehr_db.eci_treatment_note n where n.treatmentTypeId =");
														treatmentTypeSqlB11.append(vs[j]).append(")v").append(j).append(" on ").append(treatmentAlias).append(".patientId = v")
																.append(j).append(".patientId");
													}
													conditionVs.remove(0);
													parament.getConditions().get(i).setValues(conditionVs);
												} else {
													treatmentTypeSqlB11.append(" select t1.patientId from ehr_db.eci_treatment_note t1 ");
													treatmentTypeSqlB11.append(" where ").append(treatmentAlias).append(".treatmentTypeId = ").append(values);
													conditionVs.remove(0);
													parament.getConditions().get(i).setValues(conditionVs);
													// if
													// (conditionFlag){
													// String
													// cg
													// =
													// conditionVs.get(1);
													// if(cg.indexOf(",")
													// >
													// 0){
													// treatmentTypeSqlB11.append(" where ").append(treatmentAlias).append(".treatmentTypeId = ").append(values);
													// conditionVs.remove(0);
													// parament.getConditions().get(i).setValues(conditionVs);
													// }
													// }
												}
											}
											if (conditionFlag) { // or
												if (parament.getParamentType().equals("5")) {
													for (int f = 0; f < conditionVs.size(); f++) {
														String values2 = conditionVs.get(f);
														if (values2.indexOf(",") > 0) {
															String[] vs = values2.split(",");
															treatmentTypeSqlB11.append(" union all ");
															treatmentTypeSqlB11.append(" select nls.patientId from ehr_db.eci_treatment_note nls ");
															for (int j = 0; j < vs.length; j++) {
																treatmentTypeSqlB11.append(" join (select patientId from ehr_db.eci_treatment_note n where n.treatmentTypeId =");
																treatmentTypeSqlB11.append(vs[j]).append(" ) ns").append(j).append(" on ns").append(j)
																		.append(".patientId=nls.patientId");
															}
															// conditionVs.remove(values2);
															// parament.getConditions().get(i).setValues(conditionVs);
														} else {
															if (values.indexOf(",") > 0) {
																treatmentTypeSqlB11.append(" union all ");
																treatmentTypeSqlB11.append(" select nls.patientId from ehr_db.eci_treatment_note nls ");
																treatmentTypeSqlB11.append(" where nls.treatmentTypeId = ").append(values2);
																// conditionVs.remove(values2);
																// parament.getConditions().get(i).setValues(conditionVs);
																// conditionVs.add(values2);
															}
														}

													}
													parament.getConditions().get(i).setValues(new ArrayList());
												}
											}
										} else if (pconditonId == 4) { // 不等于
											String values = conditionVs.get(0);
											if (parament.getParamentType().equals("5")) { // and

												treatmentTypeSqlB33.append(" select nls.patientId from ehr_db.eci_treatment_note nls where nls.patientId not in ");
												// .append(" GROUP BY np.patientId ");
												treatmentTypeSqlB33.append(" (select patientId from ehr_db.eci_treatment_note n where n.treatmentTypeId in(");
												treatmentTypeSqlB33.append(values).append(")").append(")");
												// .append(" GROUP BY ").append(treatmentAlias).append(".patientId ");

												parament.getConditions().get(i).setValues(new ArrayList());
											}
											if (conditionVs.size() > 1) { // or
												treatmentTypeSqlB33.append(" union all ");
												if (parament.getParamentType().equals("5")) {

													conditionVs.remove(0);
													for (int f = 0; f < conditionVs.size(); f++) {
														String values2 = conditionVs.get(f);
														treatmentTypeSqlB33.append("select nls.patientId from ehr_db.eci_treatment_note nls where nls.patientId not in ");
														treatmentTypeSqlB33.append(" (select patientId from ehr_db.eci_treatment_note n where n.treatmentTypeId in(");
														treatmentTypeSqlB33.append(values2).append(")");
														treatmentTypeSqlB33.append(")");
														// .append(" GROUP BY np.patientId ");
													}
													parament.getConditions().get(i).setValues(new ArrayList());
												}
											}
										}
									}
								}
							}
							String sb1 = treatmentTypeSqlB11.toString();
							String sb3 = treatmentTypeSqlB33.toString();
							if (StringUtils.isNotEmpty(sb1)) {
								treatmentTypeSqlB0.append(" join ");
								treatmentTypeSqlB0.append("(");
								treatmentTypeSqlB0.append(treatmentTypeSqlB11);
								treatmentTypeSqlB0.append(") p1 on p1.patientId=t1.patientId ");
							}
							if (StringUtils.isNotEmpty(sb3)) {
								if (StringUtils.isNotEmpty(sb1)) {
									treatmentTypeSqlB0.append(" join (");
									treatmentTypeSqlB0.append(treatmentTypeSqlB33);
									treatmentTypeSqlB0.append(" ) treat on treat.patientId=t1.patientId");
								} else {
									treatmentTypeSqlB0.append(treatmentTypeSqlB33);
								}
							}
							if (StringUtils.isNotEmpty(treatmentTypeSqlB0.toString())) {
								treamentMap.put("treatment", treatmentTypeSqlB0.toString());
							}
						}
					}

					String conditonSql = sqlMap.get(table);
					if (StringUtils.isNotEmpty(loadingConditions(alias + "." + column, parament.getConditions(), parament.getParamentType()))) {
						if (conditonSql != null && !conditonSql.equals("()"))
							conditonSql += " AND ";
						else
							conditonSql = "";
						conditonSql += "(" + loadingConditions(alias + "." + column, parament.getConditions(), parament.getParamentType()) + ")";
					}
					String condition = sqlMap2.get(con);
					if (!con.equals("") && condition == null) {
						conditonSql += con;
						sqlMap2.put(con, con);
					}
					sqlMap.put(table, conditonSql);
				}
			}
		}
		// 主sql
		StringBuffer sql = new StringBuffer();
		// 条件sql
		String treatmentAlias = "t1";
		if (tableMap.containsValue("t")) {
			treatmentAlias = "t";
		}
		StringBuffer conditionsql = new StringBuffer();
		for (Map.Entry<String, String> entry : tableMap.entrySet()) {
			String tableAlias = entry.getValue();
			String table = entry.getKey();
			boolean flag = sql.length() > 0;
			String treatmentS = treamentMap.get("treatment");
			if (StringUtils.isEmpty(treatmentS)) {
				if (flag)
					sql.append(" LEFT JOIN ");
			}
			sql.append(table_db.get(table)).append(".").append(table).append(" ").append(tableAlias);
			if (flag) {
				if (StringUtils.isEmpty(treatmentS)) {
					sql.append(" ON ").append(tableAlias).append(".");

					if (table.equals("u_user"))
						sql.append("userId").append(" = ").append(treatmentAlias).append(".userId");
					else
						sql.append("patientId").append(" = ").append(treatmentAlias).append(".patientId");
					if (!conSql.equals("") && table.equals("ei_inhospital_note")) {
						sql.append(conSql);
					}
					if (!conSql2.equals("") && table.equals("eci_treatment_note")) {
						sql.append(conSql2);
					}
				}

			}
			if (StringUtils.isNotEmpty(treatmentS)) {
				sql.append(treatmentS);
				treamentMap.remove("treatment");
			}
			if (StringUtils.isNotEmpty(sqlMap.get(table)) && !sqlMap.get(table).equals("()")) {
				if (conditionsql.length() > 0)
					conditionsql.append(" AND ");
				conditionsql.append("(").append(sqlMap.get(table)).append(")");
			}
		}
		// }
		// 添加头部信息
		if (tableMap.containsValue("t")) {
			sql.insert(0, "SELECT t.patientId FROM ");
		} else {
			sql.insert(0, "SELECT t1.patientId FROM ");
		}

		// 添加WHERE 条件
		if (conditionsql.length() > 0) {
			sql.append(" WHERE ").append(conditionsql.toString());
		}
		// String treatmentS2 =
		// treamentMap.get("treatment2");
		// if
		// (StringUtils.isNotEmpty(treatmentS2))
		// {
		// if (tableMap.size() == 1 &&
		// tableMap.containsKey("eci_treatment_note"))
		// {
		// sql.append(" where ");
		// } else {
		// if (!treatmentS2.substring(0,
		// 6).contains("union")) {
		// sql.append(" and ");
		// }
		// }
		// sql.append(treatmentS2);
		// }
		return sql.toString();
	}

	// 拆分条件
	public static String loadingConditions(String aliasColumn, List<RetrievalConditionReq> list, String paramentType) {
		StringBuffer conditions = new StringBuffer();
		for (RetrievalConditionReq req : list) {
			if (!loadingCondition(aliasColumn, req, paramentType).equals("")) {
				if (conditions.length() > 0)
					conditions.append(" AND ");
				conditions.append("(").append(loadingCondition(aliasColumn, req, paramentType)).append(")");
			}
		}
		return conditions.toString();
	}

	// 条件判断
	public static String loadingCondition(String aliasColumn, RetrievalConditionReq req, String paramentType) {
		StringBuffer conditions = new StringBuffer();
		List<String> list = req.getValues();
		switch (req.getConditionId()) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			String sign = "";
			if (req.getConditionId() == Condition.eq.ordinal())
				sign = " = ";
			else if (req.getConditionId() == Condition.gt.ordinal())
				sign = " > ";
			else if (req.getConditionId() == Condition.lt.ordinal())
				sign = " < ";
			else if (req.getConditionId() == Condition.ne.ordinal())
				sign = " != ";
			else if (req.getConditionId() == Condition.ge.ordinal())
				sign = " >= ";
			else if (req.getConditionId() == Condition.le.ordinal())
				sign = " <= ";
			else if (req.getConditionId() == Condition.sm.ordinal() || req.getConditionId() == Condition.em.ordinal() || req.getConditionId() == Condition.in.ordinal()) {
				sign = " LIKE ";
			} else if (req.getConditionId() == Condition.notin.ordinal())
				sign = " NOT LIKE ";
			for (String value : list) {
				if (conditions.length() > 0)
					conditions.append(" OR ");
				conditions.append("( ");
				if (!paramentType.equals("1")) { // 多选的时候
					if (req.getConditionId() == Condition.in.ordinal()) {
						conditions.append(aliasColumn).append(" in ");
						conditions.append("(" + value + ")");
					} else if (req.getConditionId() == Condition.notin.ordinal()) {
						conditions.append(aliasColumn).append(" not in ");
						conditions.append("(" + value + ")");
					} else {
						String[] vs = value.split(",");
						for (int j = 0; j < vs.length; j++) {
							if (j > 0) {
								conditions.append(" and ");
							}
							conditions.append(aliasColumn).append(sign).append("\"");
							if (req.getConditionId() == Condition.em.ordinal() || req.getConditionId() == Condition.in.ordinal()
									|| req.getConditionId() == Condition.notin.ordinal())
								conditions.append("%");
							conditions.append(vs[j]);
							if (req.getConditionId() == Condition.sm.ordinal() || req.getConditionId() == Condition.in.ordinal()
									|| req.getConditionId() == Condition.notin.ordinal())
								conditions.append("%");
							conditions.append("\"");
						}
					}

				} else {

					conditions.append(aliasColumn).append(sign).append("\"");
					if (req.getConditionId() == Condition.em.ordinal() || req.getConditionId() == Condition.in.ordinal() || req.getConditionId() == Condition.notin.ordinal())
						conditions.append("%");
					conditions.append(value);
					if (req.getConditionId() == Condition.sm.ordinal() || req.getConditionId() == Condition.in.ordinal() || req.getConditionId() == Condition.notin.ordinal())
						conditions.append("%");
					conditions.append("\"");
				}
				conditions.append(") ");
			}
			break;
		case 11:
		case 12:
			conditions.append(aliasColumn);
			if (req.getConditionId() == Condition.isnull.ordinal())
				conditions.append(" IS NULL ");
			else
				conditions.append(" IS NOT NULL ");
			break;
		default:
			return conditions.toString();
		}
		return conditions.toString();
	}

	public static void main(String[] args) {
		try {
			String json = "{\"operator\":3,\"userRole\":12,\"staticType\":4,\"paraments\":[{\"parament\":\"ehr_db\",\"paramentId\":3,\"childParaments\":\"u_patient.sourceDiseaseTypeId\",\"childParamentsId\":303,\"paramentType\":\"4\",\"conditions\":[{\"conditionId\":1,\"values\":[\"1\"]}],\"paramentName\":\"病种\"},{\"parament\":\"ehr_db\",\"paramentId\":4,\"childParaments\":\"eci_treatment_note.treatmentTypeId\",\"childParamentsId\":401,\"paramentType\":\"5\",\"conditions\":[{\"conditionId\":1,\"values\":[\"2,4\",\"4\",\"3,5\"]}],\"paramentName\":\"治疗方式\"}],\"reqFlag\":1}";

			Map<String, Object> param = JsonUtil.toObject(json, Map.class);
			Object p1 = (Object) param.get("paraments");
			List p2 = JsonUtil.toObject(JsonUtil.toJson(p1), List.class);
			List<RetrievalParamentReq> paraments = new ArrayList<RetrievalParamentReq>();
			for (Object obj : p2) {
				paraments.add(JsonUtil.toObject(JsonUtil.toJson(obj), RetrievalParamentReq.class));
			}
			System.out.println(loadingParaments(paraments));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
