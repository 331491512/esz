/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>DoctorService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:00:45<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import java.util.List;

import com.westangel.common.bean.PositionTitleSimpleInfo;

/** 
* @ClassName: ProfessionalrankService 
* @Description: 职务业务
* @author YYCHEN
* @date 2015年12月14日 下午19:00:45  
*/
public interface PositionTitleService {

   /**
   * @Title: getProfessionalranks 
   * @Description: 查询所有职务
   * @return 职务列表
   * @throws
    */
   public List<PositionTitleSimpleInfo> getPositionTitleSimpleInfos();
}
