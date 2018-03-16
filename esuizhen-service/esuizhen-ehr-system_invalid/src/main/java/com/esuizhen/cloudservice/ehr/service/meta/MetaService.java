/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.meta<br/>  
 * <b>文件名：</b>MetaService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日上午11:24:13<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.HashMap;
import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.TMetaEIcdO;
import com.esuizhen.cloudservice.ehr.model.disease.TAnesthesiaWayInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisBasisInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisTypeInfo;

/** 
* @ClassName: MetaService
* @Description: 元数据服务接口（2） ——> MetaInfoService
* @author NiDan
* @date 2016年8月15日上午11:24:13 
*/
public interface MetaService {
	
	/**
	 * icdo列表展示
	 * @author Nidan
	 * @title:queryMetaEIcdOList
	 * @Description:
	 * @return List<MetaEIcdO>
	 * @date 2016年8月15日上午10:13:12
	 */
	public List<TMetaEIcdO> queryMetaEIcdOList();
	
	/**
	 * 诊断类型列表展示
	 * @author Nidan
	 * @title:queryDiagnosisTypeList
	 * @Description:
	 * @return List<TDiagnosisTypeInfo>
	 * @date 2016年8月15日上午10:22:27
	 */
	public List<TDiagnosisTypeInfo> queryDiagnosisTypeList(Integer flag);
	
	/**
	 * 诊断依据列表展示
	 * @author Nidan
	 * @title:queryDiagnosisBasisList
	 * @Description:
	 * @return List<TDiagnosisBasisInfo>
	 * @date 2016年8月15日上午10:26:51
	 */
	public List<TDiagnosisBasisInfo> queryDiagnosisBasisList();
	
	/**
	 * 麻醉方式列表展示
	 * @author Nidan
	 * @title:queryAnesthesiaWayList
	 * @Description:
	 * @return List<TAnesthesiaWayInfo>
	 * @date 2016年8月15日上午10:30:50
	 */
	public List<TAnesthesiaWayInfo> queryAnesthesiaWayList();
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description  根据传入表名获取元数据
	* @return
	 */
	public List<HashMap<String,Object>> getMetaListByTableName(String tableName,String condition);
}
