/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>ColumnDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月13日下午7:17:54<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import java.util.List;
import java.util.Map;

import com.westangel.common.bean.column.TColumnInfo;

/** 
* @ClassName: ColumnDao
* @Description: 
* @author lichenghao
* @date 2016年7月13日 下午7:17:54  
*/
public interface ColumnDao {

	//获取医院栏目
	List<TColumnInfo> queryColumnByHospital(Object param);
	//获取医院默认栏目
	List<TColumnInfo> queryDefaultColumnByHospital(Object param);
	
}
