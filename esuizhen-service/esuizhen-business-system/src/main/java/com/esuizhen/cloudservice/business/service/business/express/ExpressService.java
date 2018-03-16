/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business.express;<br/>  
 * <b>文件名：</b>ExpressService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日下午3:06:15<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business.express;

import com.esuizhen.cloudservice.business.bean.MedicaRecordCopyServiceStateUpdateReq;
import com.esuizhen.cloudservice.business.bean.ServiceColumnReq;
import com.esuizhen.cloudservice.business.bean.ServiceColumnResult;

import java.util.List;

/** 
* @ClassName: ExpressService
* @Description: 
* @author lichenghao
* @date 2017年1月6日 下午3:06:15  
*/
public interface ExpressService {
	//修改邮寄服务进展状态
	//public void updateExpressServiceState(ExpressServiceStateUpdateReq req);
	public void updateMedicalrecordServiceState(MedicaRecordCopyServiceStateUpdateReq req);
	//邮寄详情处理
	public void handleSubDetail(String productApplyId,String description);

	/**
	 * 获取服务栏目列表
	 * @param req
	 * @return
	 */
    List<ServiceColumnResult> selectServiceColumnList(ServiceColumnReq req);
}
