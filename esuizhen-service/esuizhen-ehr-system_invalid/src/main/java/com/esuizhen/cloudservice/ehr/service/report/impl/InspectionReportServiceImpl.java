/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.report.impl;<br/>  
 * <b>文件名：</b>InspectionReportServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午9:44:41<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.report.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.TDetectionReportDetailInfo;
import com.esuizhen.cloudservice.ehr.bean.TExamReportDetailInfo;
import com.esuizhen.cloudservice.ehr.bean.TReportSimpleInfo;
import com.esuizhen.cloudservice.ehr.dao.report.InspectionReportDao;
import com.esuizhen.cloudservice.ehr.service.report.InspectionReportService;
import com.westangel.common.bean.Page;
import com.github.pagehelper.PageHelper;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: InspectionReportServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年5月3日 上午9:44:41  
*/
@Service
public class InspectionReportServiceImpl implements InspectionReportService {
	
	@Autowired
	private InspectionReportDao dao;
	
	@Override
	public Page<TReportSimpleInfo> getInspectionResultList(Long patientId, Integer hospitalId, Integer resultFlag,
			Integer sortFlag, Integer page, Integer num)throws EmptyObjectExcption {
		// TODO Auto-generated method stub
		if(patientId==null){
			throw new EmptyObjectExcption("patientId is empty");
		}
		if(hospitalId==null){
			throw new EmptyObjectExcption("hospitalId is empty");
		}
		if(page==null){
			page = 0;
		}
		if(num==null){
			num = 0;
		}
		PageHelper.startPage(page+1, num);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("patientId", patientId);
		param.put("hospitalId", hospitalId);
		param.put("resultFlag", resultFlag);
		param.put("sortFlag", sortFlag);
		List list = dao.queryReportList(param);
		return PageUtil.returnPage((com.github.pagehelper.Page<TReportSimpleInfo>)list);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TDetectionReportDetailInfo getDetectionReportDetail(String reportId)throws EmptyObjectExcption {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(reportId)){
			throw new EmptyObjectExcption("reportId is empty");
		}
		dao.updateDetectionReportIsRead(reportId);
		return dao.queryDetectionReportInfoByReportId(reportId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TExamReportDetailInfo getExamReportDetail(String reportId)throws EmptyObjectExcption {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(reportId)){
			throw new EmptyObjectExcption("reportId is empty");
		}
		dao.updateExamReportIsRead(reportId);
		return dao.queryExamReportInfoByReportId(reportId);
	}

}
