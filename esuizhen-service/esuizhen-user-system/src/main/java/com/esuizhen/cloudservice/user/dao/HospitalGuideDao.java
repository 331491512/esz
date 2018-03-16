/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.dao;<br/>  
 * <b>文件名：</b>HospitalGuideDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月19日下午7:08:02<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.esuizhen.cloudservice.user.bean.THospitalGuideInfo;

/** 
* @ClassName: HospitalGuideDao
* @Description: 
* @author lichenghao
* @date 2016年7月19日 下午7:08:02  
*/
public interface HospitalGuideDao {
	//获取就医指南列表
	public List<THospitalGuideInfo> queryHospitalGuideList(Object params);
	//获取就医指南信息
	public THospitalGuideInfo queryHospitalGuideInfo(Object params);
}
