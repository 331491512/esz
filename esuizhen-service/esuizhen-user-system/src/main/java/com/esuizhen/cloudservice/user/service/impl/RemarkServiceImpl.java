/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.service.impl;<br/>  
 * <b>文件名：</b>RemarkServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月20日下午2:46:39<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.bean.PatientRemarkListReq;
import com.esuizhen.cloudservice.user.bean.PatientRemarkReq;
import com.esuizhen.cloudservice.user.bean.TPatientRemark;
import com.esuizhen.cloudservice.user.dao.DoctorPatientRemarkDao;
import com.esuizhen.cloudservice.user.service.RemarkService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: RemarkServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年5月20日 下午2:46:39  
*/
@Service
public class RemarkServiceImpl implements RemarkService {
	
	@Autowired
	private DoctorPatientRemarkDao dao;
	
	@Override
	public Page<TPatientRemark> getPatientRemarkList(PatientRemarkListReq req) {
		// TODO Auto-generated method stub
		if(req.getPatientId()==null)
			throw new EmptyParamExcption(" param error patientId is null");
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption(" param error doctorId is null");
		PageHelper.startPage(req.getPage()+1, req.getNum());
		List<TPatientRemark> list = dao.queryPatientRemark(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TPatientRemark>)list);
	}

	@Override
	public Integer createPatientRemark(PatientRemarkReq req) {
		// TODO Auto-generated method stub
		if(req.getPatientId()==null)
			throw new EmptyParamExcption(" param error patientId is null");
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption(" param error doctorId is null");
		if(StringUtils.isEmpty(req.getRemark()))
			throw new EmptyParamExcption(" param error remark is null");
		if(req.getRemark().trim().length()==0)
			throw new EmptyParamExcption(" param error remark is null");
		dao.createRemark(req);
		return req.getRemarkId();
	}

	@Override
	public void modifyPatientRemark(PatientRemarkReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption(" param error doctorId is null");
		if(req.getRemarkId()==null)
			throw new EmptyParamExcption(" param error remarkId is null");
		if(StringUtils.isEmpty(req.getRemark()))
			throw new EmptyParamExcption(" param error remark is null");
		if(req.getRemark().trim().length()==0)
			throw new EmptyParamExcption(" param error remark is null");
		if(dao.modifyRemark(req)==0){
			throw new EmptyObjectExcption("remark is null remarkId="+req.getRemarkId());
		}
	}

	@Override
	public void deletePatientRemark(PatientRemarkReq req) {
		// TODO Auto-generated method stub
		if(req.getDoctorId()==null)
			throw new EmptyParamExcption(" param error doctorId is null");
		if(req.getRemarkId()==null)
			throw new EmptyParamExcption(" param error remarkId is null");
		if(dao.deleteRemark(req)==0){
			throw new EmptyObjectExcption("remark is null remarkId="+req.getRemarkId());
		}
	}

}
