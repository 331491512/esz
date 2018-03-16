package com.esuizhen.cloudservice.user.service.impl;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.user.common.followuppatient.BeanUtils;
import com.esuizhen.cloudservice.user.dao.CommonDao;
import com.esuizhen.cloudservice.user.service.CommonService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

public abstract class CommonServiceImpl<T> implements CommonService<T> {
	protected abstract CommonDao<T> getCommonDao();

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> queryList(Object obj,Integer page,Integer num) {
		Map<String,Object> beanMap = BeanUtils.toMap(obj);
		PageHelper.startPage(page+1, num);
		List<T> list = getCommonDao().queryList(beanMap);
		return PageUtil.returnPage((com.github.pagehelper.Page<T>) list);
	}

	@Override
	public int insert(T t) {
		return getCommonDao().insert(t);
	}

	@Override
	public T queryOne(Object obj) {
		return this.getCommonDao().queryOne(obj);
	}

	@Override
	public int update(T t) {
		return this.getCommonDao().update(t);
	}

}
