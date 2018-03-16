package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.esuizhen.cloudservice.user.common.followuppatient.ExcelTemplate;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.dao.search.SearchDao;

public class AsyncSearchServiceImpl implements Runnable{
	private SearchInfo search;
	private SearchDao searchDao;
	
	public SearchInfo getSearch() {
		return search;
	}

	public void setSearch(SearchInfo search) {
		this.search = search;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public void run() {
		try{
			System.out.println("===开始异步更新var_search表，sqlContent列===");
			String sqlContent = ExcelTemplate.EXPORT_SQL_CONTENT.toString();
			String req = search.getReq();
			if(req != null) {
				Map<String,Object> searchMap = JSON.parseObject(req);
				Object userId = searchMap.get("userId");
				if(userId != null) {
					searchMap.remove("userId");
				}
				if(searchMap.size()>0) {
					Object sql = searchMap.get("sql");
					if(sql != null && !sql.toString().trim().equals("")) {
						StringBuffer appendSql = new StringBuffer();
						appendSql.append(sql.toString());
						Object lostPatientChange = searchMap.get("lostPatientChange");
						if(lostPatientChange != null) {
							Integer lostPatientChangeInt = (Integer)lostPatientChange;
							if(lostPatientChangeInt == 1) {
								appendSql.append(" AND t.patientId IN(SELECT patientId FROM followup_db.var_patient_followup WHERE newVisitFlag=1)");
							}else if(lostPatientChangeInt == 2) {
								appendSql.append(" AND t.patientId IN(SELECT patientId FROM followup_db.var_patient_followup WHERE newContactFlag=1)");
							}else if(lostPatientChangeInt == 3) {
								appendSql.append(" AND t.patientId IN(SELECT patientId FROM followup_db.var_patient_followup WHERE newVisitFlag=1 AND newContactFlag=1)");
							}
						}
						Object followupFlag = searchMap.get("followupFlag");
						if(followupFlag != null && (Integer)followupFlag==2) {
							appendSql.append(" AND t.followupFlag="+followupFlag);
						}
						//增加医院id检索条件 add by yuanwenming start
						Object hospitalId = searchMap.get("hospitalId");
						if(hospitalId != null) {
							appendSql.append(" AND t.patientId IN(SELECT t2.patientId FROM user_db.r_hospital_patient t2 WHERE t2.hospitalId="+hospitalId+")");
						}
						//增加医院id检索条件 add by yuanwenming end
						appendSql.append(" GROUP BY t.patientId");
						sqlContent=appendSql.toString();
					}else {
						Object obj=searchMap.get("similarType");
						StringBuilder whereCondition=new StringBuilder();
						if(obj!=null){
							//疑似重复需要带出分组内的患者
							whereCondition.append(ExcelTemplate.EXPORT_SQL_SIMPLE.toString());
							whereCondition.append(ExcelTemplate.getWhereCondition(searchMap));
							whereCondition.append(") and t.outPatientFlag=2 AND t.patienttype=1 and pm.cancelflag=0 ORDER BY pm.goalpatientid)");
						}else{
							whereCondition.append(ExcelTemplate.getWhereCondition(searchMap));
						}
						sqlContent+=whereCondition.toString();
					}
					
				}
			}
			System.out.println("sqlContent="+sqlContent);
			search.setSqlContent(sqlContent);
			searchDao.update(search);
			System.out.println("===异步更新var_search表，sqlContent列结束===");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
