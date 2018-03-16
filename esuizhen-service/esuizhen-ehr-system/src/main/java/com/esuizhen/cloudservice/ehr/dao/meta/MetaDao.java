/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.dao.meta<br/>  
 * <b>文件名：</b>MetaDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日上午10:07:22<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.TMetaEIcdO;
import com.esuizhen.cloudservice.ehr.model.disease.TAnesthesiaWayInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisBasisInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisTypeInfo;
import com.esuizhen.cloudservice.ehr.model.meta.NNISAnaesthesiaLevel;
import com.esuizhen.cloudservice.ehr.model.meta.NNISIncisionInfected;
import com.esuizhen.cloudservice.ehr.model.meta.NNISOperationContinuedTime;
import com.esuizhen.cloudservice.ehr.model.meta.NNISOperationIncisionClean;
import com.esuizhen.cloudservice.ehr.model.meta.NNISOperationLevel;
import com.esuizhen.cloudservice.ehr.model.meta.OperationNature;

/** 
* @ClassName: MetaDao
* @Description: 
* @author NiDan
* @date 2016年8月15日上午10:07:22 
*/
public interface MetaDao {
	
	/**
	 * 查询icdo列表
	 * @author Nidan
	 * @title:queryMetaEIcdOList
	 * @Description:
	 * @return List<MetaEIcdO>
	 * @date 2016年8月15日上午10:13:12
	 */
	public List<TMetaEIcdO> queryMetaEIcdOList();
	
	/**
	 * 查询诊断类型列表
	 * @author Nidan
	 * @title:queryDiagnosisTypeList
	 * @Description:
	 * @return List<TDiagnosisTypeInfo>
	 * @date 2016年8月15日上午10:22:27
	 */
	public List<TDiagnosisTypeInfo> queryDiagnosisTypeList(@Param("flag")Integer flag);
	
	/**
	 * 查询诊断依据列表
	 * @author Nidan
	 * @title:queryDiagnosisBasisList
	 * @Description:
	 * @return List<TDiagnosisBasisInfo>
	 * @date 2016年8月15日上午10:26:51
	 */
	public List<TDiagnosisBasisInfo> queryDiagnosisBasisList();
	
	/**
	 * 查询麻醉方式列表
	 * @author Nidan
	 * @title:queryAnesthesiaWayList
	 * @Description:
	 * @return List<TAnesthesiaWayInfo>
	 * @date 2016年8月15日上午10:30:50
	 */
	public List<TAnesthesiaWayInfo> queryAnesthesiaWayList(
			@Param("anesthesiaCode")String anesthesiaCode,
			@Param("anesthesiaName")String anesthesiaName);
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description 获取元数据的公共方法
	* @return
	 */
	List<HashMap<String, Object>> getMetaListByTableName(@Param("tableName") String tableName,@Param("condition") String condition);

	// add by zhuguo
	public List<OperationNature> queryOperationNature();

	public List<NNISOperationIncisionClean> queryNNISOperationIncisionClean();

	public List<NNISAnaesthesiaLevel> queryNNISAnaesthesiaLevel();

	public List<NNISOperationLevel> queryNNISOperationLevel();

	public List<NNISOperationContinuedTime> queryNNISOperationContinuedTime();

	public List<NNISIncisionInfected> queryNNISIncisionInfected();
	// end
}