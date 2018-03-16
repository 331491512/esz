package com.westangel.common.service;

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
    */
   public List<PositionTitleSimpleInfo> getPositionTitleSimpleInfos();
}
