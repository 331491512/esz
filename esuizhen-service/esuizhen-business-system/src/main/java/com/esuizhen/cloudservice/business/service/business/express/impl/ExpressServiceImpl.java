/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.service.business.express.impl;<br/>  
 * <b>文件名：</b>ExpressServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日下午3:07:57<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.service.business.express.impl;

import com.esuizhen.cloudservice.business.bean.MedicaRecordCopyServiceStateUpdateReq;
import com.esuizhen.cloudservice.business.bean.ServiceColumnReq;
import com.esuizhen.cloudservice.business.bean.ServiceColumnResult;
import com.esuizhen.cloudservice.business.dao.business.ExpressServiceDetailDao;
import com.esuizhen.cloudservice.business.dao.business.PatientDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.ServiceColumnDao;
import com.esuizhen.cloudservice.business.model.business.ExpressServiceDetail;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.notify.sender.ExpressNotifySender;
import com.esuizhen.cloudservice.business.service.business.BusinessProductProcessService;
import com.esuizhen.cloudservice.business.service.business.ProductApplyService;
import com.esuizhen.cloudservice.business.service.business.express.ExpressService;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/** 
* @ClassName: ExpressServiceImpl
* @Description: 
* @author lichenghao
* @date 2017年1月6日 下午3:07:57  
*/
@Service
public class ExpressServiceImpl implements ExpressService {
	
	@Autowired
	private ProductApplyDao productApplyDao;
	@Autowired
	private ExpressNotifySender expressNofifySender;
	@Autowired
	private ExpressServiceDetailDao dao;
	@Autowired
	private ProductApplyService productApplyService;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private ServiceColumnDao serviceColumnDao;

	@Autowired
	private BusinessProductProcessService productProcessService;

	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	
	/*@Override
	public void updateExpressServiceState(ExpressServiceStateUpdateReq req) {
		// TODO Auto-generated method stub
		if(req==null||StringUtils.isEmpty(req.getProductApplyId())||req.getState()==null)
			throw new EmptyParamExcption("param error");
		ProductServiceApply psa = productApplyDao.getProductServiceApplyInfo(req.getProductApplyId());
		if(StringUtils.isNotEmpty(req.getCause()))
			psa.setCause(req.getCause());
		if(psa.getProgressState()==null)
			psa.setProgressState(0);
		int progressFlag = req.getState();
		if(StringUtils.isNotEmpty(req.getInhospitalNo())){
			dao.modifyDetailState(req);
		}
		//判断状态是否可修改
		if(chekeProgressState(psa,progressFlag)){
			if(psa.getAuditState()==0||psa.getAuditState()==1){//如果auditState还未处理 变成处理状态
				psa.setAuditState(2);
				productApplyDao.modifyProductServiceApplyAuditState(psa);
			}
			productApplyDao.modifyProductServiceApplyProgressState(psa);
			expressNofifySender.sendExpressProgressNotify(psa);
			if(psa.getProgressState()==5&&StringUtils.isNotEmpty(req.getExpressNo())){//如果有快递单号，保存并修改服务状态
				productApplyService.updateExpressNum(req.getProductApplyId(), req.getExpressNo(), null);
			}
		}
	}*/

	@Override
	public void updateMedicalrecordServiceState(MedicaRecordCopyServiceStateUpdateReq req) {
		// TODO Auto-generated method stub
		if(req==null||StringUtils.isEmpty(req.getProductApplyId())||req.getState()==null)
			throw new EmptyParamExcption("param error");
		ProductServiceApply psa = productApplyDao.getProductServiceApplyInfo(req.getProductApplyId());
		if(!checkProductSubTypeWithState(psa,req.getState()))
			throw new EmptyParamExcption("param error");
		if(StringUtils.isNotEmpty(req.getCause()))
			psa.setCause(req.getCause());
		if(psa.getProgressState()==null)
			psa.setProgressState(0);
		int progressFlag = req.getState();
		if(StringUtils.isNotEmpty(req.getInhospitalNo())){
			dao.modifyDetailState(req);
		}
		if(psa.getProductSubType()!=null&&psa.getProductSubType().equals(Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_RECEIVE)){
			if(psa.getServiceCode()==null||!psa.getServiceCode().equals(req.getServiceCode())){
				throw new EmptyParamExcption("param serviceCode is error");
			}
		}
		//判断状态是否可修改
		if(chekeProgressState(psa,progressFlag)){
			//if(psa.getAuditState()==0||psa.getAuditState()==1){//如果auditState还未处理 变成处理状态
			//	psa.setAuditState(2);
			//	productApplyDao.modifyProductServiceApplyAuditState(psa);
			//}
			productApplyDao.modifyProductServiceApplyProgressState(psa);

			//3.产品业务流程处理
			productProcessService.businessProcessMonitoring(psa.getProductApplyId());
			expressNofifySender.sendExpressProgressNotify(psa);
			/*String url=serverUrlRoot+"/business/product/process/monitor?productApplyId="+psa.getProductApplyId();
			String result= HttpUtil.get(url);
			if(result!=null) {
				com.westangel.common.bean.TMsgResponse resp =  JsonUtil.toObject(result, com.westangel.common.bean.TMsgResponse.class);
				if(resp==null||resp.respCode!=0){
					LogUtil.logError.error("业务流程处理失败:{}",resp.getRespMsg());
				}else if(resp!=null&&resp.respCode==0){
				}
			}*/
			if(psa.getProgressState()==5){//如果有快递单号，保存并修改服务状态
				productApplyService.updateExpressNum(req.getProductApplyId(), req.getExpressNo(), null);
			}

		}
	}

	private boolean checkProductSubTypeWithState(ProductServiceApply psa,int state){
		boolean result=false;
		if(psa!=null&&psa.getProductSubType().equals(901)){
			switch (state){
				case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS:
				case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS:
				case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS:
				case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_EXPRESS_STATUS:
				case -1:
				case -2:
				case -3:
					result=true;break;
			}
		}else if(psa!=null&&psa.getProductSubType().equals(902)){
			switch (state) {
				case Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_RECEIVE_STATUS:
				case -1:
				case -2:
				case -3:
					result = true;
					break;
			}
		}
		return result;
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :chekeProgressState
	 * @Description:状态检查
	 * @return boolean
	 * @date 2017年1月10日 下午2:04:15
	 */
	private boolean chekeProgressState(ProductServiceApply psa, int progressFlag) {
		//检查服务自身状态是否是拒绝、过期、结束
		boolean result=true;
		if(psa.getState()>=5||psa.getState()==3||psa.getProgressState()<0||psa.getProgressState()>=6){
			result = false;
		}else{
			if(progressFlag>0&&progressFlag>psa.getProgressState()){
				psa.setProgressState(progressFlag);
				if(progressFlag==6){
					productApplyService.setAcceptProduct(psa.getProductApplyId(),5,null);
					if(psa.getSyncFlag().equals(0)){
						psa.setSyncFlag(3);
					}else if(psa.getSyncFlag().equals(1)){
						psa.setSyncFlag(2);
					}
					psa.setState(5);
					psa.setAuditState(5);
				}else if(progressFlag==4){
					psa.setState(4);
					psa.setAuditState(2);
				}else if(progressFlag==5){
					psa.setState(4);
					psa.setAuditState(4);
					if(psa.getSyncFlag().equals(0)){
						psa.setSyncFlag(3);
					}else if(psa.getSyncFlag().equals(1)){
						psa.setSyncFlag(2);
					}
				}
				//在邮寄时已进行相应处理
				//productApplyService.setAcceptProduct(psa.getProductApplyId(),4,null);
				result = true;
			}else if(progressFlag<0){
				if(psa.getProgressState()>4){
					LogUtil.log.info("com.esuizhen.cloudservice.business.service.business.express.impl.ExpressServiceImpl.chekeProgressState---->病案复印：服务已邮寄，不可取消。");
					return false;
				}
				if(psa.getSyncFlag().equals(0)){
					psa.setSyncFlag(3);
				}else if(psa.getSyncFlag().equals(1)){
					psa.setSyncFlag(2);
				}
				psa.setProgressState(progressFlag);
				psa.setAuditState(3);
				psa.setState(7);
				productApplyService.setAcceptProduct(psa.getProductApplyId(),7,null);
				result = true;
			}else{
				result = false;
			}
		}
		return result;

		/*switch (psa.getState()) {
		case 3:
		case 6:
		case 7:
			return false;
		default:
			break;
		}
		//检查服务状态是否可修改
		if((progressFlag==-1||progressFlag==-3)&&psa.getProgressState()!=progressFlag) {
			psa.setProgressState(progressFlag);
			return true;
		}else if(psa.getProgressState()==5){
			psa.setProgressState(progressFlag);
			return true;
		}else if(progressFlag>0&&progressFlag>psa.getProgressState()){
			psa.setProgressState(progressFlag);
			return true;
		}else{
			return false;
		}*/
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void handleSubDetail(String productApplyId,String description) {
		// TODO Auto-generated method stub
		Map<String,Object> object = JsonUtil.toObject(description, LinkedHashMap.class);
		if(object==null)
			return;
		List<Object> list = (List<Object>)object.get("copyApplyList");
		if(list==null&&list.isEmpty())
			return;
		List<ExpressServiceDetail> details = new ArrayList<ExpressServiceDetail>();
		for(Object obj : list){
			ExpressServiceDetail detail = JsonUtil.toObject(JsonUtil.toJson(obj), ExpressServiceDetail.class);
			detail.setProductApplyId(productApplyId);
			detail.setState(0);
			details.add(detail);
		}
		dao.insert(details);
		dao.updateDetailsState(productApplyId,null);
		Map<String,Object> psa = new HashMap<String, Object>();
		//是否在院检查
		int result = dao.checkEmrIsInHospital(productApplyId);
		if(result>0){
			psa.put("progressState", 0);
		}else{
			//归档检查
			int isFile = dao.checkEmrIsNotFile(productApplyId);
			//如果归档状态为3 未归档 状态为2
			psa.put("progressState", isFile>0?2:3);
		}
		psa.put("productApplyId", productApplyId);
		productApplyDao.modifyProductServiceApplyProgressState(psa);

		//产品业务流程处理
		productProcessService.businessProcessMonitoring(productApplyId);

	}

	@Override
	public List<ServiceColumnResult> selectServiceColumnList(ServiceColumnReq req) {
		if(req==null||req.getPatientId()==null)
			throw new EmptyParamExcption("param error");
		List<TagInfo> tagInfos=patientDao.getPatientTags(req.getPatientId());
		List<ServiceColumnResult> list=null;
		if(tagInfos!=null&&tagInfos.size()>0){
			req.setTags(tagInfos);
			list=serviceColumnDao.findServiceColumns(req);
		}else{
			list=serviceColumnDao.findServiceColumnByIsShow(1);
		}
		return list;
	}
}
