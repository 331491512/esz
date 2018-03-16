/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.service.impl;<br/>  
 * <b>文件名：</b>MetaServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日上午10:29:40<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.MetaDao;
import com.esuizhen.cloudservice.user.model.TMetaInfoNation;
import com.esuizhen.cloudservice.user.model.TMetaInfoNationality;
import com.esuizhen.cloudservice.user.model.TMetaInfoOccupation;
import com.esuizhen.cloudservice.user.model.TMetaInfoRelatives;
import com.esuizhen.cloudservice.user.model.TMetaInfoFaultType;
import com.esuizhen.cloudservice.user.service.MetaService;
import com.westangel.common.excption.EmptyObjectExcption;

/** 
* @ClassName: MetaServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年5月2日 上午10:29:40  
*/
@Service(value="metaService")
public class MetaServiceImpl implements MetaService {
	@Autowired
	private MetaDao metaDao;
	
	@Override
	public Object getCityInfo(Integer level, String cityCode)throws EmptyObjectExcption {
		// TODO Auto-generated method stub
		Map<String,Object> param = new HashMap<String,Object> ();
		if(level==null||level==1)
			param.put("cityCode", "%0000");
		else if(StringUtils.isEmpty(cityCode)){
			throw new EmptyObjectExcption("cityCode is not null");
		}
		else if(level==2 && cityCode!=null){
			param.put("cityCode", cityCode.substring(0, 2)+"%00");
			param.put("notCityCode", "%0000");
		}else if(level==3 && cityCode!=null){
			param.put("cityCode", cityCode.substring(0, 4)+"%");
			param.put("notCityCode", "%00");
		}
		return metaDao.queryCity(param);
	}

	@Override
	public List<TMetaInfoNationality> getMetaInfoNationalityList(String nationalityName) {
		return this.metaDao.queryMetaInfoNationalityList(nationalityName);
	}

	@Override
	public List<TMetaInfoNation> getMetaInfoNationList(String nationName) {
		return this.metaDao.queryMetaInfoNationList(nationName);
	}

	@Override
	public List<TMetaInfoOccupation> getMetaInfoOccupationList(String occupationName) {
		return this.metaDao.queryMetaInfoOccupationList(occupationName);
	}

	@Override
	public List<TMetaInfoRelatives> getMetaInfoRelativesList() {
		return this.metaDao.queryMetaInfoRelativesList();
	}

	@Override
	public List<TMetaInfoFaultType> getMetaInfoMissingTypeList() {
		return this.metaDao.queryMetaInfoMissingTypeList();
	}

	@Override
	public List<TMetaInfoFaultType> getMetaInfoInvalidTypeList() {
		return this.metaDao.queryMetaInfoInvalidTypeList();
	}
	
}
