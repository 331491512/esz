/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business;<br/>  
 * <b>文件名：</b>HospitalService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日下午3:02:40<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.westangel.common.bean.column.HospitalColumnReq;
import com.westangel.common.bean.column.TColumnInfo;


/** 
* @ClassName: HospitalService
* @Description: 
* @author lichenghao
* @date 2016年5月2日 下午3:02:40  
*/
public interface HospitalService {
	
	
	/**
	 * 患者报告状态变更检查
	 * @author lichenghao
	 * @title :checkInspectionReportOut
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月3日 下午5:30:43
	 */
	public void checkInspectionReportOut(String productApplyId);
	
	/**
	 * 获取医院栏目
	 * @author lichenghao
	 * @title :getHospitalColumnList
	 * @Description:TODO
	 * @return List<TColumnInfo>
	 * @date 2016年7月13日 下午7:16:58
	 */
	public List<TColumnInfo> getHospitalColumnList(HospitalColumnReq req);
	
	
}
