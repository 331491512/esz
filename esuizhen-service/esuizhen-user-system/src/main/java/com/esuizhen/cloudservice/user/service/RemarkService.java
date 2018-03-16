/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.service;<br/>  
 * <b>文件名：</b>RemarkService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月20日下午2:40:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import java.util.List;

import com.esuizhen.cloudservice.user.bean.PatientRemarkReq;
import com.esuizhen.cloudservice.user.bean.PatientRemarkListReq;
import com.esuizhen.cloudservice.user.bean.TPatientRemark;
import com.westangel.common.bean.Page;

/** 
* @ClassName: RemarkService
* @Description: 
* @author lichenghao
* @date 2016年5月20日 下午2:40:58  
*/
public interface RemarkService {
	/**
	 * 获取医生对患者备注信息
	 * @author lichenghao
	 * @title :getPatientRemarkList
	 * @Description:TODO
	 * @return Page<TPatientRemark>
	 * @date 2016年5月20日 下午2:39:55
	 */
	public Page<TPatientRemark> getPatientRemarkList(PatientRemarkListReq req);
	/**
	 * 创建医生对患者的备注
	 * @author lichenghao
	 * @title :createPatientRemark
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年5月20日 下午4:30:09
	 */
	public Integer createPatientRemark(PatientRemarkReq req);
	/**
	 * 修改医生对患者的备注
	 * @author lichenghao
	 * @title :modifyPatientRemark
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月20日 下午4:30:29
	 */
	public void modifyPatientRemark(PatientRemarkReq req);
	/**
	 * 删除医生对患者的备注
	 * @author lichenghao
	 * @title :deletePatientRemark
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月20日 下午4:30:42
	 */
	public void deletePatientRemark(PatientRemarkReq req);
}
