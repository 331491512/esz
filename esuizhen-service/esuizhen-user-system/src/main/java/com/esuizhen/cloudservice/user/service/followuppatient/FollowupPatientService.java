/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:00:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.followuppatient;

import java.util.HashMap;
import java.util.List;

import com.esuizhen.cloudservice.user.bean.PatientExportReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.PatientConfirmedDateReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.esuizhen.cloudservice.user.model.followuppatient.FollowupPatientProfile;
import com.esuizhen.cloudservice.user.model.followuppatient.PatientCallBackInfo;
import com.esuizhen.cloudservice.user.model.followuppatient.TFaultSimilarPatientSpread;
import com.esuizhen.cloudservice.user.model.followuppatient.TPatientSpreadItem;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.excption.EmptyParamExcption;

/** 
* @ClassName: PatientService 
* @author yuan_wm
* @date 2015年12月3日 下午6:00:58  
*/
public interface FollowupPatientService {
	
	int saveMiddlePatientSimpleInfo(TPatientSearchInfo patientSearchInfo) throws EmptyParamExcption;
    
	 /**
     * 分页查询患者信息列表
     * @param patientSearchInfo
     * @param page
     * @param num
     * @return
     * @throws EmptyParamExcption
     */
	public Page<PatientSimpleInfo> searchPatientSimpleInfoList(TwiceSearchReq twiceSearchReq) throws EmptyParamExcption;
	
	/**
     * 统计患者条数,排除疑似重复患者，考虑到疑似重复患者数据量比较小，就直接用查询接口
     * @param paramsMap
     * @return
     */
    Integer countPatientSimpleNum(TwiceSearchReq twiceSearchReq);
	
	/**
	 * 分页查询疑似重复患者信息列表
	 * @param twiceSearchReq
	 * @return
	 * @throws EmptyParamExcption
	 */
	Page<PatientSimpleInfo> searchSimilarPatientSimpleInfoList(TwiceSearchReq twiceSearchReq) throws Exception;
	
	/**
	 * 更新患者信息
	 * @param patientSimpleInfo
	 * @return
	 * @throws EmptyParamExcption
	 */
	int updatePatientProfileSeletive(PatientProfile patientProfile) throws EmptyParamExcption;
	
	/**
	 * 更新失访患者状态
	 * @param patientId
	 * @return
	 * @throws EmptyParamExcption
	 */
	int updateLostFollowupPatientState(Long  patientId) throws EmptyParamExcption;
	
	/**
	 * 根据患者编号查询患者详细信息以及患者家属信息
	 * @param patientId
	 * @return
	 */
	public FollowupPatientProfile getPatientProfileAndFimilyById(Long patientId,Integer dataId);
	
	/**
	* 
	* @Title: savePatient 
	* @Description: 保存患者及其家属信息
	* @param 
	* @return int
	* @throws
	*/
	public int savePatientAndFamily(FollowupPatientProfile patientProfile) throws Exception;
	
	/**
	 * 获取患者数量,包括患者总数、待随访总数、随访进行中患者总数，无需随访患者总数、失访患者总数，疑似重复患者总数、核心数据缺失/疑似错误患者总数（其中数据缺失患者总数、疑似数据错误患者总数）
	 * @return
	 */
	TPatientSpreadItem countFollowupStatusNum(Integer type,Integer userRole,Integer operator);
	
	/**
	 * 核心数据缺失/疑似错误的患者数及占比
	 * @param searchId
	 * @return
	 */
	TFaultSimilarPatientSpread statisticsFaultPatient(Integer searchId);
	
	/**
	 * 通过姓名分组，获取分组数量
	 * @param twiceSearchReq
	 * @return
	 * @throws Exception
	 */
	int getGroupsOfPatientByName(TwiceSearchReq twiceSearchReq) throws Exception;
	
	/**
	 * 合并疑似重复患者
	 * @param ids
	 * @throws Exception
	 */
	void mergeSimilarPatient(List<Long> ids) throws Exception;

	/**
	 * 
	 * @author lichenghao
	 * @title :exportPatient
	 * @Description:患者导出
	 * @return String
	 * @date 2016年8月30日 上午8:08:15
	 */
	String exportPatient(PatientExportReq req);
	/**
	* @author fanpanwei
	* @date 2017年3月8日
	* @param 
	* @description:查询当前条件下随访表可导出数目
	* @return
	 */
	Integer getFollowupTableTotal(PatientExportReq req);
	/**
	* @author fanpanwei
	* @date 2017年3月8日
	* @param 
	* @description:随访表导出
	* @return
	 */
	String exportFollowupTable(PatientExportReq req);
	
	/**
	 * 撤销疑似重复患者
	 * @param patientId
	 * @return
	 * @throws EmptyParamExcption
	 */
	int revokeSimilarPatient(Long  patientId) throws Exception;
	
	/**
	 * 查询患者来电信息
	 * @param phone
	 * @return
	 */
	List<PatientCallBackInfo> queryPatientCallBackInfo(String phone);
	/**
	 * 按诊断名称分病种统计患者
	 * @param patientSearchInfo
	 * @return
	 */
	int statisticsPatientByDiseaseType(TPatientSearchInfo  patientSearchInfo);

	/**
	 * 获取符合随访任务查询的凝似重复患者列表
	 * @param req
	 * @return
	 */
	Page<PatientSimpleInfo> queryDemandMightRepeatPatientList(TwiceSearchReq req);

	
	/**
	 * 失访患者批量撤销
	 * @param patientIds
	 * @return
	 * @throws EmptyParamExcption
	 */
	int batchRevokeLostFollowPatient(List<Long>  patientIds) throws EmptyParamExcption;

	/**
	 * 查询第一页到当前页疑似患者总数
	 * @param twiceSearchReq
	 * @return
	 */
	int getGroupsOfPatientSortCount(TwiceSearchReq twiceSearchReq);
	
	/**
	 * 分页查询患者信息列表(用户系统使用)
	 * @param twiceSearchReq
	 * @return
	 * @throws EmptyParamExcption
	 */
	public Page<PatientSimpleInfo> queryPatientInfoList(TwiceSearchReq twiceSearchReq) throws EmptyParamExcption;

	/**
	* @author fanpanwei
	* @date 2017年7月3日
	* @param 
	* @description 处理批量查询明细信息的接口
	* @return
	 */
	public HashMap<String,Object> dealBatchQueryDetailInfo(TwiceSearchReq twiceSearchReq) throws EmptyParamExcption;
	
	/**
	 * 修改患者的确诊时间和状态
	 * @author zhuguo
	 * @date 2017-8-8 17:20:09
	 */
	int patientConfirmedDateModify(PatientConfirmedDateReq req);
}
