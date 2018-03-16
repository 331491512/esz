package com.esuizhen.cloudservice.user.dao.followuppatient;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.followuppatient.PatientConfirmedDateReq;
import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.model.followuppatient.FollowupPatientProfile;
import com.esuizhen.cloudservice.user.model.followuppatient.PatientCallBackInfo;
import com.esuizhen.cloudservice.user.model.followuppatient.TFaultSimilarPatientSpread;
import com.esuizhen.cloudservice.user.model.followuppatient.TPatientSpreadItem;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.search.SearchInfo;
import com.westangel.common.excption.EmptyParamExcption;

public interface FollowupPatientDao {
	
    int deleteByPrimaryKey(Long patientId);

    int insert(PatientProfile record);

    int insertSelective(PatientProfile record);

    PatientProfile selectByPrimaryKey(Long patientId);

    int updateByPrimaryKeySelective(PatientProfile record);

    int updateByPrimaryKey(PatientProfile record);
    
    /**
     * 根据条件获取患者总数,这个总数用于插入到预查询搜索条件表中  要保证随访结果始终唯一
     * @param paramsMap
     * @return
     * @throws EmptyParamExcption
     */
    int searchPatientSimpleInfoCount(Map<String,Object> paramsMap) throws EmptyParamExcption;
    
    /**
     * 分页查询患者信息
     * @param paramsMap
     * @return
     */
    List<PatientSimpleInfo> queryPagePatientSimpleList(Map<String,Object> paramsMap);
    
    /**
     * 分页查询患者信息(内部)
     * @param paramsMap
     * @return
     */
    List<PatientSimpleInfo> queryInternalPagePatientSimpleList(Map<String,Object> paramsMap);
    
    /**
     * 统计患者条数,排除疑似重复患者，考虑到疑似重复患者数据量比较小，就直接用查询接口
     * @param paramsMap
     * @return
     */
    int countPatientSimpleNum(Map<String,Object> paramsMap);
    
    /**
     * 分页查询疑似重复患者信息
     * @param paramsMap
     * @return
     */
    List<PatientSimpleInfo> queryPageSimilarPatientSimpleList(Map<String,Object> paramsMap);
    
   /**
    * 通过患者id获取患者明细以及患者家属
    * @param patientId
    * @return
    */
    FollowupPatientProfile getPatientProfileAndFimilyById(Map<String,Object> paramsMap);
    
    /**
     * 更新失访患者状态
     * @param patientId
     * @return
     */
    int updateLostFollowupPatientState(Long  patientId);
    
    /**
     *  统计随访状态数量
     * @param type
     * @return
     */
    TPatientSpreadItem countFollowupStatusNum(Map<String,Object> paramsMap);
    
    /**
     * 更新患者最近门诊时间
     * @param patientId
     * @return
     */
    int updateLatestClinicDate(Map<String,Object> paramsMap);
    
    /**
     * 通过姓名分组，获取疑似重复组数
     * @param paramsMap
     * @return
     */
	int getGroupsOfPatientByName(Map<String,Object> paramsMap);
	
	/**
	 * 统计缺失患者、错误患者数量
	 * @param paramsMap
	 * @return
	 */
	TFaultSimilarPatientSpread statisticsFaultPatient(Map<String,Object> paramsMap);
	
	/**
	 * 更新疑似患者合并标示
	 * @param paramsMap
	 * @return
	 */
	int updateMergeflag(Map<String,Object> paramsMap);
	
	/**
	 * 调用存储过程合并患者
	 * @param paramsMap
	 */
	void mergePatientWithProcedure(Map<String,Object> paramsMap);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryPatientInfoBySql
	 * @Description:导出患者信息
	 * @return List<LinkedHashMap<String,String>>
	 * @date 2016年8月30日 上午9:15:38
	 */
	List<LinkedHashMap<String, Object>> queryPatientInfoBySql(@Param("sql")String sqlContent);
	
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
	 * 
	 * @author lichenghao
	 * @title :countDataNum
	 * @Description:查询导出数据量
	 * @return Integer
	 * @date 2016年9月7日 上午11:26:26
	 */
	Integer countDataNum(@Param("sql")String sql);
	
	/**
	 *根据条件获取患者id列表
	 * @param paramsMap
	 * @return
	 */
	List<Long> searchPatientIdList(Map<String,Object> paramsMap);
	
	/**
	 * 修改住院、诊断、手术信息，更新宽表
	 * @param patientId
	 */
	void freshPatientWideTable(Long patientId);
	
	/**
	 * 按诊断名称分病种统计患者
	 * @param patientSearchInfo
	 * @return
	 */
	int statisticsPatientByDiseaseType(TPatientSearchInfo  patientSearchInfo);

	/**
	 * 通过患者反向查询患者
	 * @param patientId
	 * @return
	 */
	List<Long> reversePatientByPatientId(@Param("patientId") Long patientId);

	/**
	 * 查询符合随访任务查询的凝似重复患者列表
	 * @param req
	 * @param params
	 * @return
	 */
	List<PatientSimpleInfo> findDemandMightRepeatPatientList(@Param("req")SearchInfo req, @Param("params")List<PatientSimpleInfo> params);


	/**
	 * 查询符合随访任务查询的凝似重复患者组列表
	 * @param req
	 * @return
	 */
	public List<PatientSimpleInfo> findDemandMightRepeatPatientGroupList(SearchInfo req);
	
	/**
	 * 失访患者批量撤销
	 * @param patientIds
	 * @return
	 * @throws EmptyParamExcption
	 */
	int batchRevokeLostFollowPatient(Map<String,List<Long>>  paramsMap) throws EmptyParamExcption;

	/**
	 * 分页合并患者列表
	 * @param paramsMap
	 * @return
	 */
	List<PatientSimpleInfo> queryPageMergePatientSimpleList(Map<String, Object> paramsMap);
	
	/**
	 * 置var_patient_followup newContactFlag=1
	 * @param patientId
	 * @return
	 */
	int updateContactFlag(@Param("patientId") Long patientId);

	/**
	 * 疑似分组总数
	 * @param paramsMap
	 * @return
	 */
	int queryPageSimilarPatientSimpleTotalCount(Map<String, Object> paramsMap);

	int getGroupsOfPatientSortCount(Map<String, Object> paramsMap);
	//插入查询中间表 院际医生工作站  add by yuan_wm 20170217 start
	@SuppressWarnings("rawtypes")
	int insertSearchPatient(Map paramsMap);
	//插入查询中间表 院际医生工作站  add by yuan_wm 20170217 end
	
	Integer getfollowupTabTotalBySql(@Param("sql")String sqlContent);

	/**
	 * add by fanpanwei 根据传入病案号 ，获取被合并病案号
	 */
	List<HashMap<String,String>> getMergePatientNos(Map<String,Object> paramsMap);
	/**
	* @author fanpanwei
	* @date 2017年7月4日
	* @param 
	* @description:查出批量病案号中能查到记录的所有病案号集合
	* @return
	 */
	List<String> getHadRecordPatientNos(Map<String,Object> paramsMap);
	
	Integer queryInternalPagePatientSimpleTotal(Map<String, Object> paramsMap);
	
	// 修改患者的确诊时间和状态 add by zhuguo
	Integer patientConfirmedDateModify(PatientConfirmedDateReq req);
	
	// 根据操作员id，查询操作员姓名 add by zhuguo
	PatientConfirmedDateReq queryOperatorNameByOperatorId(PatientConfirmedDateReq req);
	
	// 修改患者的确诊时间和状态 add by zhuguo
	Integer insertOperationHistory(OperationHistory req);
	
	// 根据手机号查询归属地
	String queryPhoneHomeByPhone(String phone);
}