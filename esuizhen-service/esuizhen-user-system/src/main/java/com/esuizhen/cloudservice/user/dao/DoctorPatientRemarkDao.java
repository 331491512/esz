/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.dao;<br/>  
 * <b>文件名：</b>DoctorPatientRemarkDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月20日下午3:12:26<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.esuizhen.cloudservice.user.bean.PatientRemarkReq;
import com.esuizhen.cloudservice.user.bean.TPatientRemark;

/** 
* @ClassName: DoctorPatientRemarkDao
* @Description: 
* @author lichenghao
* @date 2016年5月20日 下午3:12:26  
*/
public interface DoctorPatientRemarkDao {
	//查询医生对患者的备注
		public List<TPatientRemark> queryPatientRemark(Object param);
		
		//新增医生对患者备注
		public void createRemark(Object param);
		
		//修改备注信息
		public int modifyRemark(PatientRemarkReq req);
		//删除备注
		public int deleteRemark(PatientRemarkReq req);
}
