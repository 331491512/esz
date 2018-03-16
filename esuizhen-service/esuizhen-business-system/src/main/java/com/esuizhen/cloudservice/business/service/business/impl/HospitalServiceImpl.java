/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business.impl;<br/>  
 * <b>文件名：</b>HospitalServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日下午3:06:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.business.dao.business.ColumnDao;
import com.esuizhen.cloudservice.business.dao.business.HospitalDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.service.business.HospitalService;
import com.westangel.common.bean.column.HospitalColumnReq;
import com.westangel.common.bean.column.TColumnInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushNotifyUtil;
import com.westangel.common.util.PushUtil;

/** 
* @ClassName: HospitalServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年5月2日 下午3:06:02  
*/
@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private ColumnDao columnDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PushInnerService pushService;
	@Autowired
	private MessageSource messageSource;
	
	@Value("${server.wx.url.root}")
	private String wxUrlRoot;
	
	@Value("${server.wx.service.url.root}")
	private String wxRoot;
	
	@Value("${server.h5.report.list.page}")
	private String wxReportPage;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void checkInspectionReportOut(String productApplyId){
		// TODO Auto-generated method stub
		LinkedHashMap<String , Object> map = hospitalDao.queryProductApplySimpleInfo(productApplyId);
		if(map==null)
			return;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("patientId", map.get("patientId"));
		param.put("hospitalId", map.get("hospitalId"));
		param.put("serverApplyDate", map.get("createTime"));
		
		
		List<LinkedHashMap<String, Object>> list = hospitalDao.queryNoReadReportList(param);
		if(list==null||list.size()==0){
			LogUtil.logError.debug("report list is null");
			return;
		}
		StringBuffer projects= new StringBuffer();
		String applyTime = null;
		for(LinkedHashMap<String, Object> report : list){
			if(StringUtils.isNotEmpty(report.get("typeName")+"")&&(report.get("typeName")+"").trim().length()>0){
				if(projects.length()>0)
					projects.append(",");
				else
					applyTime = DateUtil.getDateStr((Date)report.get("applyTime"));
				projects.append(report.get("typeName")+"");
			}
			hospitalDao.updateReportReadFlag((String)report.get("reportId"), Integer.parseInt(report.get("reportType")+""));
		}
		List<String> values = new ArrayList<String>();
		values.add(pushService.getMessage(PushContentUtil.getBusinessPushContent("push.report.notify.info")));
		values.add(projects.toString());
		values.add(map.get("patientName")+"");
		values.add(applyTime);
		values.add(pushService.getMessage(PushContentUtil.getBusinessPushContent("push.report.notify.info.1")));
		
		String openId = userDao.getOpenIdByUserId((Long)map.get("patientUserId"),(Integer)map.get("wxProductId"));
		
		String url = wxUrlRoot+wxReportPage+"?fromUserName="+openId+"&hospitalId="+map.get("hospitalId")+"&patientId="+map.get("patientId");
		
		PushNotifyInfo pushInfo = PushUtil.getWxTemplatePushNotifyInfo("jianchabaogaotixing", url, values);
		pushInfo.setUserId((Long)map.get("patientUserId"));
		PushNotifyUtil.setSendWxProductId(pushInfo, (Integer)map.get("wxProductId"));
		pushService.push(pushInfo);
	}

	@Override
	public List<TColumnInfo> getHospitalColumnList(HospitalColumnReq req) {
		// TODO Auto-generated method stub
		if(req.getHospitalId()==null)
			throw new EmptyParamExcption("hospitalId is null");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("hospitalId", req.getHospitalId());
		map.put("columnType", req.getColumnType());
		map.put("reqFlag", req.getReqFlag());
		map.put("wxUrl", wxRoot);
		List<TColumnInfo> list = columnDao.queryColumnByHospital(map);
		if(list==null||list.size()==0)
			list = columnDao.queryDefaultColumnByHospital(map);
		return list;
	}

}
