/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.business;<br/>  
 * <b>文件名：</b>HospitalDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日下午3:09:25<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/** 
* @ClassName: HospitalDao
* @Description: 
* @author lichenghao
* @date 2016年5月2日 下午3:09:25  
*/
public interface HospitalDao {
	
	
	/**
	 * 返回患者服务期内申请的检查报告
	 * hospitalId patientId serverApplyTime
	 * @author lichenghao
	 * @title :queryReportCount
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年5月4日 下午2:58:14
	 */
	public List<LinkedHashMap<String,Object>> queryNoReadReportList(Object param);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryProductApplySimpleInfo
	 * @Description:TODO:根据服务申请ID查询服务简要信息
	 * @return LinkedHashMap<String,Object>
	 * @date 2016年5月3日 下午6:33:26
	 */
	public LinkedHashMap<String, Object> queryProductApplySimpleInfo(@Param("productApplyId")String productApplyId);
	
	/**
	 * 修改报告阅读状态
	 * @author lichenghao
	 * @title :updateReportReadFlag
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年5月4日 下午6:55:02
	 */
	public Integer updateReportReadFlag(@Param("reportId")String reportId,@Param("reportType")Integer reportType);
}
