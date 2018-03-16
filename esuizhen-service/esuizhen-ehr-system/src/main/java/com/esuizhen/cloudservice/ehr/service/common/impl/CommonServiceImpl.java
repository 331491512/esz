package com.esuizhen.cloudservice.ehr.service.common.impl;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TPatientInfoDao;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientProfile;
import com.esuizhen.cloudservice.ehr.service.common.CommonService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.BeanUtils;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
@Transactional
public abstract class CommonServiceImpl<T> implements CommonService<T> {
	@Autowired
	protected TPatientInfoDao patientInfoDao;
	
	/**
	 * 采用公共的查询方法，方法的实现在子类中
	 * @param req
	 * @return
	 */
	protected List<T> queryImpl(CommonReq req){return null;}
	
	@Override
	public List<T> query(CommonReq req) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("patientId", req.getPatientId());
		TPatientProfile patientInfo = patientInfoDao.queryPatientById(req.getPatientId());
		if(patientInfo == null) {
			LogUtil.log.info("没有查询到此患者信息");
			return null;
		}
		LogUtil.log.info("查询患者patientId="+req.getPatientId()+",患者类型patientType="+patientInfo.getPatientType());
		req.setPatientType(patientInfo.getPatientType());
		return queryImpl(req);
	}
	
	/**
	 * 采用公共的保存方法，方法的实现在子类中
	 * @param t
	 * @return
	 */
	protected Map<String,Object> saveImpl(CommonReq req,List<T> t){return null;};
	
	@Override
	public Map<String,Object> save(CommonReq req,List<T> t) {
		TPatientProfile patientInfo = patientInfoDao.queryPatientById(req.getPatientId());
		if(patientInfo == null) {
			LogUtil.log.info("没有查询到此患者信息");
			return null;
		}
		LogUtil.log.info("查询患者patientId="+req.getPatientId()+",患者类型patientType="+patientInfo.getPatientType());
		req.setPatientType(patientInfo.getPatientType());
		return saveImpl(req,t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> queryPageList(Object obj) {
		Map<String,Object> paramsMap = BeanUtils.toMap(obj);
		Integer page = (Integer)paramsMap.get("page");
		Integer num = (Integer)paramsMap.get("num");
		if(page != null) {
			PageHelper.startPage(page+1, num);
		}
		List<T> list = this.getCommonDao().queryList(paramsMap);
		Page<T> pages=null;
		if(page != null) {
			pages=PageUtil.returnPage((com.github.pagehelper.Page<T>)list);
		}else {
			pages= new Page<T>();
			pages.setDataList(list);
		}
		return pages;
	}

	@Override
	public List<T> queryList(Object obj) {
		return this.getCommonDao().queryList(obj);
	}

	@Override
	public T queryOne(Object obj) {
		return this.getCommonDao().queryOne(obj);
	}

	@Override
	public int save(T t) {
		return this.getCommonDao().insert(t);
	}

	@Override
	public int update(T t) {
		return this.getCommonDao().updateByPrimaryKey(t);
	}

	@Override
	public int updateByPrimaryKeySelective(T t) {
		return this.getCommonDao().updateByPrimaryKeySelective(t);
	}

	@Override
	public Page<T> queryCustomPageList(Object obj) {
		Page<T> pages= new Page<T>();
		Map<String,Object> paramsMap = BeanUtils.toMap(obj);
		Integer page = (Integer)paramsMap.get("page");
		Integer num = (Integer)paramsMap.get("num");
		int totalNum = this.getCommonDao().countTotalNum(paramsMap);
		if(totalNum > 0) {
			int totalPage = totalNum/num;
			if(totalNum % num != 0) {
				totalPage++;
			}
			paramsMap.put("startRow", page*num);
			paramsMap.put("pageSize", num);
			List<T> list = this.getCommonDao().queryList(paramsMap);
			pages.setTotalNum(totalNum);
			pages.setTotalPage(totalPage);
			pages.setCurrPage(page);
			pages.setCurrSize(num);
			pages.setDataList(list);
		}else {
			List<T> list = new ArrayList<T>();
			pages.setDataList(list);
		}
		return pages;
	}
}
