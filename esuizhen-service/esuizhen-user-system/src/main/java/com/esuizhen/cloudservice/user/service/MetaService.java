/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.service;<br/>  
 * <b>文件名：</b>MetaService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日上午10:14:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import java.util.List;

import com.esuizhen.cloudservice.user.model.TMetaInfoNation;
import com.esuizhen.cloudservice.user.model.TMetaInfoNationality;
import com.esuizhen.cloudservice.user.model.TMetaInfoOccupation;
import com.esuizhen.cloudservice.user.model.TMetaInfoRelatives;
import com.esuizhen.cloudservice.user.model.TMetaInfoFaultType;


/** 
* @ClassName: MetaService
* @Description: 
* @author lichenghao
* @date 2016年5月2日 上午10:14:53  
*/
public interface MetaService {
	
	/*获取城市信息*/
	public Object getCityInfo(Integer level,String cityCode);

	/**
	 * <p>Title:getMetaInfoNationalityList</p>
	 * <p>Description:获取国籍元数据列表</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午10:56:28
	 * @param nationalityName
	 * @return
	 */
	public List<TMetaInfoNationality> getMetaInfoNationalityList(String nationalityName);

	/**
	 * <p>Title:getMetaInfoNationList</p>
	 * <p>Description:获取民族元数据列表</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午11:08:11
	 * @param nationName
	 * @return
	 */
	public List<TMetaInfoNation> getMetaInfoNationList(String nationName);

	/**
	 * <p>Title:getMetaInfoOccupationList</p>
	 * <p>Description:获取职业元数据列表</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午11:18:18
	 * @param occupationName
	 * @return
	 */
	public List<TMetaInfoOccupation> getMetaInfoOccupationList(String occupationName);
	
	public List<TMetaInfoRelatives> getMetaInfoRelativesList();
	
	public List<TMetaInfoFaultType> getMetaInfoMissingTypeList();
	
	public List<TMetaInfoFaultType> getMetaInfoInvalidTypeList();
}
