package com.esuizhen.cloudservice.ehr.service.presentationmorbidity.impl;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.CommonService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

public abstract class CommonServiceImpl<T> implements CommonService<T> {

	@Override
	public List<T> queryList(Object obj) {
		return this.getCommonDao().queryList(obj);
	}

	@Override
	public T queryOne(Object obj) {
		return this.getCommonDao().queryOne(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> queryPageList(Map<String, Object> paramsMap) {
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
	public int save(T t) {
		return this.getCommonDao().insert(t);
	}

	@Override
	public int deleteByPrimaryKey(String primaryKeyId) {
		return this.getCommonDao().deleteByPrimaryKey(primaryKeyId);
	}
}
