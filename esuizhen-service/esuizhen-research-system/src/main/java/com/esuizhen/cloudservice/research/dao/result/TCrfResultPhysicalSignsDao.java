package com.esuizhen.cloudservice.research.dao.result;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalSigns;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
 * <p>Title:CrfResultPhysicalSignsDao</p>
 * <p>Description:患者体格检查-体征情况结果数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午6:31:20
 */
public interface TCrfResultPhysicalSignsDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:添加体格检查-体征情况结果</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午7:23:33
	 * @param crfResultPhysicalSigns
	 * @return
	 */
	public int insert(TCrfResultPhysicalSigns crfResultPhysicalSigns);
	
	/**
	 * <p>Title:insertByBatch</p>
	 * <p>Description:批量保存体征检查</p>
	 * @author YYCHEN
	 * @date 2016年6月8日 下午7:21:40
	 * @param crfResultPhysicalSignss
	 * @return
	 */
	public int insertByBatch(@Param("crfResultPhysicalSignss")List<TCrfResultPhysicalSigns> crfResultPhysicalSignss);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:修改体格检查-体征情况结果</p>
	 * @author YYCHEN
	 * @date 2016年5月30日 下午7:24:01
	 * @param crfResultPhysicalSigns
	 * @return
	 */
	public int update(TCrfResultPhysicalSigns crfResultPhysicalSigns);

	/**
	 * <p>Title:findCrfResultPhysicalSigns</p>
	 * <p>Description:CRF患者体征情况信息查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:57:58
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	public TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> findCrfResultPhysicalSigns(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);
	
	/**
	 * <p>Title:findCrfResultPhysicalSignsRecordByCheckDate</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月28日 上午10:53:47
	 * @param checkDate
	 * @param patientId
	 * @return
	 */
	public List<TCrfResultPhysicalSigns> findCrfResultPhysicalSignsRecordByCheckDate(@Param("checkDate")Date checkDate, @Param("patientId")Long patientId);

	/**
	 * <p>Title:findCrfResultPhysicalSignsRecord</p>
	 * <p>Description:CRF患者体征记录查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:59:29
	 * @param projectId
	 * @param patientId
	 * @return
	 */
	public List<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>> findCrfResultPhysicalSignsRecord(@Param("projectId")String projectId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByCrfResultIdAndPatientId</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午5:02:01
	 * @param crfObserveId
	 * @param patientId
	 * @return
	 */
	public int deleteByCrfObserveIdAndPatientId(@Param("crfObserveId")String crfObserveId, @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:23:12
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
}
