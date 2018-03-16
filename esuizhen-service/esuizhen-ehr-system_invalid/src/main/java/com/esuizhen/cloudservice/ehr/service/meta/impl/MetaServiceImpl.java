/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.meta.impl<br/>  
 * <b>文件名：</b>MetaServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日下午2:47:28<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.TMetaEIcdO;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaDao;
import com.esuizhen.cloudservice.ehr.model.disease.TAnesthesiaWayInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisBasisInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisTypeInfo;
import com.esuizhen.cloudservice.ehr.service.meta.MetaService;

/** 
* @ClassName: MetaServiceImpl
* @Description: 
* @author NiDan
* @date 2016年8月15日下午2:47:28 
*/
@Service
public class MetaServiceImpl implements MetaService {
	
	@Autowired
	private MetaDao metaDao;

	@Override
	public List<TMetaEIcdO> queryMetaEIcdOList() {
		return metaDao.queryMetaEIcdOList();
	}

	@Override
	public List<TDiagnosisTypeInfo> queryDiagnosisTypeList(Integer flag) {
		return metaDao.queryDiagnosisTypeList(flag);
	}

	@Override
	public List<TDiagnosisBasisInfo> queryDiagnosisBasisList() {
		return metaDao.queryDiagnosisBasisList();
	}

	@Override
	public List<TAnesthesiaWayInfo> queryAnesthesiaWayList() {
		return metaDao.queryAnesthesiaWayList();
	}

	@Override
	public List<HashMap<String, Object>> getMetaListByTableName(String tableName,String condition) {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> hm = metaDao.getMetaListByTableName(tableName,condition);
		return hm;
	}

	
}
