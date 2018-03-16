/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service.impl<br/>  
 * <b>文件名：</b>DoctorServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月9日-下午5:54:20<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.PositionTitleDao;
import com.esuizhen.cloudservice.user.service.PositionTitleService;
import com.westangel.common.bean.PositionTitleSimpleInfo;

/** 
* @ClassName: PositionTitleServiceImpl 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月9日 下午5:54:20  
*/
@Service(value = "positionTitleService")
public class PositionTitleServiceImpl implements PositionTitleService, com.westangel.common.service.PositionTitleService {
	@Autowired
	private PositionTitleDao dao;

	@Override
	public List<PositionTitleSimpleInfo> getPositionTitleSimpleInfos() {
		return this.dao.findPositionTitleSimpleInfos();
	}

	
}
