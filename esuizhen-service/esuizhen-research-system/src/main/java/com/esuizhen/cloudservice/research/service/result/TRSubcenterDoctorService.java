package com.esuizhen.cloudservice.research.service.result;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterDoctor;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;

/**
 * <p>Title:RSubcenterDoctorService</p>
 * <p>Description:专题分中心医生关系业务层接口</p>
 * @author YYCHEN
 * @date 2016年6月22日 下午4:04:17
 */
public interface TRSubcenterDoctorService {

	/**
	 * <p>Title:searchSubcenterDoctorList</p>
	 * <p>Description:获取专题分中心医生数据</p>
	 * @author YYCHEN
	 * @date 2016年6月22日 下午4:04:59
	 * @param crfObserveId
	 * @param patientId
	 * @param allFlag
	 * @return
	 */
	List<TRSubcenterDoctor> searchSubcenterDoctorList(String projectId, Integer allFlag);

	/**
	 * <p>Title:getProjectSubcenterDoctor</p>
	 * <p>Description:获取专题分中心医生信息</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 上午9:53:50
	 * @param projectId
	 * @param subcenterId
	 * @param doctorId
	 * @return
	 * @throws ParameterCannotBeNullException 
	 */
	List<TProjectSubcenterDetailInfo> getProjectSubcenterDoctor(String projectId, Long subcenterId, Long doctorId) throws ParameterCannotBeNullException;

	/**
	 * <p>Title:addProjectSubcenterMember</p>
	 * <p>Description:添加分中心成员</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午5:26:19
	 * @param projectSubcenterDetailInfo
	 * @return
	 * @throws ParameterCannotBeNullException 
	 * @throws ObjectAlreadyExistExcption 
	 * @throws UnsupportedEncodingException 
	 */
	public boolean addProjectSubcenterMember(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws ParameterCannotBeNullException, ObjectAlreadyExistExcption, UnsupportedEncodingException;

	/**
	 * <p>Title:deleteProjectSubcenterMember</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 上午11:11:04
	 * @param projectSubcenterDetailInfo
	 * @return
	 * @throws RejectRequestExcption 
	 */
	boolean deleteProjectSubcenterMember(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws RejectRequestExcption;
}
