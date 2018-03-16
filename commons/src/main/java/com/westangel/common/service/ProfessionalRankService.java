/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>DoctorService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:00:45<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.service;

import java.util.List;

import com.westangel.common.bean.ProfessionalRankSimpleInfo;

/** 
* @ClassName: ProfessionalrankService 
* @Description: 职称业务
* @author YYCHEN
* @date 2015年12月14日 下午19:00:45  
*/
public interface ProfessionalRankService {

   /**
   * @Title: getProfessionalranks 
   * @Description: 查询所有职称
   * @return 职称列表
    */
   public List<ProfessionalRankSimpleInfo> getProfessionalranks();
}
