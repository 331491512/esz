package com.esuizhen.cloudservice.research.service.result;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.westangel.common.bean.Doctor;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
 * <p>Title:DoctorService</p>
 * <p>Description:专题对应医生基本信息的操作-业务层</p>
 * @author YYCHEN
 * @date 2016年10月20日 上午11:13:58
 */
public interface DoctorService {

	/**
	 * <p>Title:createDoctor</p>
	 * <p>Description:使用分中心信息创建一个医生基本信息和医生账号</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 上午11:15:37
	 * @param projectSubcenterDetailInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 */
	Doctor createDoctor(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws ParameterCannotBeNullException;

	/**
	 * <p>Title:supplyDoctorInfo</p>
	 * <p>Description:使用分中心医生信息补充库中医生信息</p>
	 * @author YYCHEN
	 * @date 2016年10月29日 下午3:55:04
	 * @param doctor
	 * @param projectSubcenterDetailInfo
	 * @return
	 */
	boolean supplyDoctorInfo(Doctor doctor, TProjectSubcenterDetailInfo projectSubcenterDetailInfo);
	
}
