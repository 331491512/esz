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

import com.esuizhen.cloudservice.user.dao.ProfessionalRankDao;
import com.esuizhen.cloudservice.user.service.ProfessionalRankService;
import com.westangel.common.bean.ProfessionalRankSimpleInfo;

/** 
* @ClassName: ProfessionalRankServiceImpl 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月9日 下午5:54:20  
*/
@Service(value = "professionalRankService")
public class ProfessionalRankServiceImpl implements ProfessionalRankService, com.westangel.common.service.ProfessionalRankService {
	@Autowired
	private ProfessionalRankDao dao;

	/**(非 Javadoc) 
	* <p>Title: searchDoctor</p> 
	* <p>Description: 根据医生编号查询医生详细信息</p> 
	* @param id
	* @return 
	* @see com.esuizhen.cloudservice.user.service.DoctorService#searchDoctor(java.lang.Long) 
	*/
	@Override
	public List<ProfessionalRankSimpleInfo> getProfessionalranks() {
		return this.dao.findProfessionalRanks();
	}
	
}
