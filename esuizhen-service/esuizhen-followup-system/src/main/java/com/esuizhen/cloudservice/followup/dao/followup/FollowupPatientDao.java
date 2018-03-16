/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.dao.followup;<br/>  
 * <b>文件名：</b>FollowupPatientDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日下午5:11:38<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.dao.followup;

import com.esuizhen.cloudservice.followup.bean.TFollowupPatientStatisInfo;

/** 
* @ClassName: FollowupPatientDao
* @Description: 
* @author lichenghao
* @date 2016年8月8日 下午5:11:38  
*/
public interface FollowupPatientDao {
	//更新动态患者表随访状态
	public int updateSearchFollowupPatient(Object obj);
	
	//常规检索
	public int insertSearchFollowupPatient(Object obj);
	
	//人数查询统计
	public TFollowupPatientStatisInfo queryFollowupPatientStatis(Object obj);
}
