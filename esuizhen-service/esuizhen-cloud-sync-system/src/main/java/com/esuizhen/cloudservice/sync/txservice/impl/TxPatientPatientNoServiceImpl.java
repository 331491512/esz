/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.txservice.impl;<br/>  
 * <b>文件名：</b>TxPatientPatientNoServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月20日下午3:36:17<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.bean.TPatientAndPatientNoRelationSync;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientPatientNoDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientPatientNoDao;
import com.esuizhen.cloudservice.sync.service.TxPatientPatientNoService;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.westangel.common.bean.TPatientAndPatientNoRelation;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: TxPatientPatientNoServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年12月20日 下午3:36:17  
*/
@Service
public class TxPatientPatientNoServiceImpl implements TxPatientPatientNoService {
	@Autowired
	private CloudPatientPatientNoDao cloudPatientPatientNoDao;
	@Autowired
	private MatchPatientPatientNoDao matchPatientPatientNoDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	/**
	 * 患者病案号同步
	 */
	@Override
	public void syncPatientPatientNo(TPatientAndPatientNoRelationSync patientOfPatientNo) {
		// TODO Auto-generated method stub
		TPatientAndPatientNoRelation patientPatientNoRelation = patientOfPatientNo.createPatientPatientNo();
		if(patientPatientNoRelation.getHospitalId()==null)
			throw new EmptyObjectExcption("sync error hospitalId is null");
		//从生产库中查找患者
		Long patientId = uuidRelationshipService.getPatientId(patientOfPatientNo.getUuid());
		if(patientId==null){
			//如果存在匹配库进匹配库
			if(matchPatientDao.findByUuid(patientOfPatientNo.getUuid())!=null){
				matchPatientPatientNoDao.insert(patientOfPatientNo);
			}else{//返回错误
				throw new EmptyObjectExcption("sync error patient not in match and cloud");
			}
		}else{//存在进入生产库
			patientOfPatientNo.setPatientId(patientId);
			cloudPatientPatientNoDao.insert(patientOfPatientNo.createPatientPatientNo());
		}
	}
	@Override
	public boolean mergePatientPatientNo(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with surgical data---------->>");
		//将患者诊断信息里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchPatientPatientNoDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<TPatientAndPatientNoRelation> patientPatientNos = this.matchPatientPatientNoDao.getPatientPatientNoByUuid(patientFinalUuid);
		if (patientPatientNos == null || patientPatientNos.isEmpty()) {
			return true;
		}
		for (int i = patientPatientNos.size() - 1; i >= 0; i--) {
			TPatientAndPatientNoRelation patientPatientNoInfo = patientPatientNos.get(i);
			patientPatientNoInfo.setPatientId(patientId);
			patientPatientNoInfo.setUuid(patientFinalUuid);
			patientPatientNoInfo.setSyncFlag(Constant.SYNC_OK);
			//保存到云端数据库
			this.cloudPatientPatientNoDao.insert(patientPatientNoInfo);
			//添加治疗记录
			//this.eciTreatmentNoteService.saveByDiagnosisInfo(surgeryNote);
			//将匹配中间库的数据删除
			this.matchPatientPatientNoDao.delete(patientPatientNoInfo.getId());
		}
		LogUtil.log.debug("合并患者病案号数据完成----------<<");
		return true;
	}

}
