package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.PatientSimpleInfo;

/**
 * <p>Title:RSubcenterPatientService</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月31日 下午1:50:51
 */
public interface TRSubcenterPatientService {
	/**
	 * <p>Title:addByBatch</p>
	 * <p>Description:批量添加患者与分中心关系</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午1:53:20
	 * @param crfResultMainInfo
	 * @return
	 */
	boolean addByBatch(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo);
}
