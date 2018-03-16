package com.esuizhen.cloudservice.business.service.business.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.esuizhen.cloudservice.business.bean.ServiceProgressResp;
import com.esuizhen.cloudservice.business.dao.business.PatientDao;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.notify.sender.ExpressNotifySender;
import com.esuizhen.cloudservice.business.service.business.BusinessProductProcessService;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Nidan on 2017年05月15 下午 17:31
 */
@Service
public class BusinessProductProcessServiceImpl implements BusinessProductProcessService {

    @Autowired
    private ProductApplyDao dao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private ExpressNotifySender expressNotifySender;

    /**
     * 业务流程处理
     * @param productApplyId
     */
    @Override
    public void businessProcessMonitoring(String productApplyId) {
        ProductServiceApply productServiceApply=dao.getProductServiceApplyInfo(productApplyId);
        switch (productServiceApply.getProductType()){
            case Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL: this.productSubTypeMonitor(productServiceApply);
        }
    }

    /**
     * 子产品类型流程处理
     * @param productServiceApply
     */
    private void productSubTypeMonitor(ProductServiceApply productServiceApply){
        switch (productServiceApply.getProductSubType()){
            case Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL_EXPRESS:this.expressProcessHandle(productServiceApply);
            case Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_RECEIVE:this.sceneReceiveProcessHandle(productServiceApply);
        }
    }

    /**
     * 病案复印邮寄流程处理
     * @param apply
     */
    private void expressProcessHandle(ProductServiceApply apply) {
        List<ServiceProgressResp> serviceProgress=dao.getServiceProgressInfos(apply.getProductApplyId());
        ServiceProgressResp lastServiceProcess=null;
        int status=-1;
        if(serviceProgress!=null&&serviceProgress.size()>0){
            lastServiceProcess=serviceProgress.get(0);
            status=lastServiceProcess.getProcessState();
        }
        //正在进行中的服务才处理
        if(status<apply.getProgressState()&&apply.getState()<5&&apply.getState()!=3&&apply.getAuditState()<5&&apply.getAuditState()!=3) {
            switch (apply.getProgressState()){
                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_EXPRESS_STATUS:
                    addIsNotExistStatus(serviceProgress,apply,Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_EXPRESS_STATUS);

                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS:
                    addIsNotExistStatus(serviceProgress,apply,Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS);

                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS:
                    addIsNotExistStatus(serviceProgress,apply,Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS);

                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS:
                    addIsNotExistStatus(serviceProgress,apply,Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS);

                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_APPLY_STATUS:
                    addIsNotExistStatus(serviceProgress,apply,Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_APPLY_STATUS);

            }
        }
    }

    private void addIsNotExistStatus(List<ServiceProgressResp> serviceProgress,ProductServiceApply apply,int status){
        if(!isExistThisStatus(serviceProgress,status)&&status<=apply.getProgressState()){
            switch (status){
                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_APPLY_STATUS:
                    this.addExpressApplyStatus(apply);
                    break;
                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS:
                    this.addExpressOutHospitalStatus(apply);
                    break;
                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS:
                    this.addExpressFileStatus(apply);
                    break;
                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS:
                    this.addExpressDuplicateStatus(apply);
                    break;
                case Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_EXPRESS_STATUS:
                    this.addExpressMailStatus(apply);
                    break;
            }
        }
    }

    private boolean isExistThisStatus(List<ServiceProgressResp> serviceProgress,int status){
        boolean result=false;
        for (ServiceProgressResp sp : serviceProgress){
            if(sp.getProcessState().equals(status)){
                result=true;
            }
        }
        return result;
    }

    /**
     * 出院状态
     * @param apply
     */
    private void addExpressOutHospitalStatus(ProductServiceApply apply) {
        LinkedHashMap<String,Object> map=findPatientOuthospitalState(apply.getDescription());
        Date outhospitalDate=null;
        if(map.get("outhospitalDate")!=null){
            outhospitalDate=DateUtil.convertToDate(map.get("outhospitalDate").toString());
        }
        ServiceProgressResp serviceProgress=new ServiceProgressResp();
        serviceProgress.setProductApplyId(apply.getProductApplyId());
        serviceProgress.setProgressName("患者出院");
        serviceProgress.setProcessState(Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS);
        serviceProgress.setHappenTime(outhospitalDate);
        dao.insertServiceProgress(serviceProgress);
    }

    /**
     * 归档状态
     * @param apply
     */
    private void addExpressFileStatus(ProductServiceApply apply) {
        LinkedHashMap<String,Object> map=findPatientOuthospitalState(apply.getDescription());
        int infoState=1;
        Date outhospitalDate=null;

        if(map.get("outhospitalDate")!=null)
            outhospitalDate=DateUtil.convertToDate(map.get("outhospitalDate").toString());

        if(map.get("infoState")!=null)
            infoState=Integer.valueOf(map.get("infoState").toString());

        ServiceProgressResp serviceProgress=new ServiceProgressResp();
        serviceProgress.setProductApplyId(apply.getProductApplyId());
        serviceProgress.setProgressName("病案已归档");
        serviceProgress.setProcessState(Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS);
        serviceProgress.setHappenTime(outhospitalDate);
        dao.insertServiceProgress(serviceProgress);
    }

    /**
     * 已复印
     * @param apply
     */
    private void addExpressDuplicateStatus(ProductServiceApply apply) {
        ServiceProgressResp serviceProgress=new ServiceProgressResp();
        serviceProgress.setProductApplyId(apply.getProductApplyId());
        serviceProgress.setProgressName("病案已复印");
        serviceProgress.setProcessState(Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS);
        serviceProgress.setHappenTime(new Date());
        dao.insertServiceProgress(serviceProgress);
    }

    /**
     * 已邮寄
     * @param apply
     */
    private void addExpressMailStatus(ProductServiceApply apply) {
        ServiceProgressResp serviceProgress=new ServiceProgressResp();
        serviceProgress.setProductApplyId(apply.getProductApplyId());
        serviceProgress.setProgressName("病案已邮寄");
        serviceProgress.setProcessState(Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_EXPRESS_STATUS);
        serviceProgress.setHappenTime(new Date());
        dao.insertServiceProgress(serviceProgress);
    }

    /**
     * 病案复印申请
     * @param apply
     */
    private void addExpressApplyStatus(ProductServiceApply apply){
        ServiceProgressResp sp = new ServiceProgressResp();
        sp.setProductApplyId(apply.getProductApplyId());
        sp.setProgressName("申请病案复印");
        sp.setProcessState(Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_APPLY_STATUS);
        sp.setHappenTime(apply.getCreateTime());
        dao.insertServiceProgress(sp);
    }

    /**
     * 邮寄流程
     * @param apply
     * @param status
     */
    private void updateMedicalRecordExpressProcess(ProductServiceApply apply, int status,int currentState) {
            if(status<apply.getProgressState()&&status<Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_APPLY_STATUS&&
                    currentState!=Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_APPLY_STATUS) {
                this.addExpressApplyStatus(apply);
                status=0;
            }

            if(status<apply.getProgressState()&&status<Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS&&
                    currentState!=Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS) {
                this.addExpressOutHospitalStatus(apply);
                status=1;
            }

            if(status<apply.getProgressState()&&status<Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS&&
                    currentState!=Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS) {
                this.addExpressFileStatus(apply);
                status=3;
            }

            if(status<apply.getProgressState()&&status<Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS&&
                    currentState!=Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS) {
                this.addExpressDuplicateStatus(apply);
                status=4;
            }

            /*if(status<apply.getProgressState()&&status<Constant.Business.MEDICAL_RECORD_EXPRESS_PROCESS_EXPRESS_STATUS) {
                this.addExpressMailStatus(apply);
                status=5;
            }*/
    }

    /**
     * 检查患者的出院状态
     * @param description
     */
    private LinkedHashMap<String,Object> findPatientOuthospitalState(String description){
        LinkedHashMap<String,Object> map=null;
        //获取患者的住院Id
        JSONObject jsonObject=JSON.parseObject(description);
        JSONArray jsonArray=(JSONArray)jsonObject.get("copyApplyList");
        List<String> inhospitalIds=new ArrayList<String>();
        for (Object json: jsonArray){
            JSONObject jsonObject1=(JSONObject)json;
            String inhospitalId=jsonObject1.get("inhospitalId").toString();
            if(!StringUtils.isBlank(inhospitalId)){
                inhospitalIds.add(inhospitalId);
            }
        }
        if(inhospitalIds.size()>0){
            map=patientDao.queryPatientIsOutHospital(inhospitalIds);
        }
        return map;
    }

    /**
     * 病案复印现场领取流程处理
     * @param apply
     */
    private void sceneReceiveProcessHandle(ProductServiceApply apply) {
        List<ServiceProgressResp> serviceProgress=dao.getServiceProgressInfos(apply.getProductApplyId());
        ServiceProgressResp lastServiceProcess=null;
        int status=-1;
        if(serviceProgress!=null&&serviceProgress.size()>0){
            lastServiceProcess=serviceProgress.get(0);
            status=lastServiceProcess.getProcessState();
        }
        if(status<apply.getProgressState()&&apply.getState()<5&&apply.getState()!=3&&apply.getAuditState()<5&&apply.getAuditState()!=3){
            switch (apply.getProgressState()){
                case Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_APPLY_STATUS:
                    this.addReceiveApplyStatus(apply);
                    break;
                case Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_RECEIVE_STATUS:
                    this.addReceiveGetStatus(apply);
                    this.updateMedicalRecordSceneReceiveProcess(apply,status,Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_RECEIVE_STATUS);
                    break;
            }
        }
    }

    /**
     * 现场领取申请
     * @param apply
     */
    private void addReceiveApplyStatus(ProductServiceApply apply) {
        ServiceProgressResp serviceProgress = new ServiceProgressResp();
        serviceProgress.setProductApplyId(apply.getProductApplyId());
        serviceProgress.setProgressName("申请病案复印");
        serviceProgress.setProcessState(Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_APPLY_STATUS);
        serviceProgress.setHappenTime(apply.getCreateTime());
        dao.insertServiceProgress(serviceProgress);
    }

    /**
     * 现场领取
     * @param apply
     */
    private void addReceiveGetStatus(ProductServiceApply apply) {
        ServiceProgressResp serviceProgress = new ServiceProgressResp();
        serviceProgress.setProductApplyId(apply.getProductApplyId());
        serviceProgress.setProgressName("病案已领取");
        serviceProgress.setProcessState(Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_RECEIVE_STATUS);
        serviceProgress.setHappenTime(new Date());
        dao.insertServiceProgress(serviceProgress);
        //expressNotifySender.sendExpressProgressNotify(apply);
    }

    /**
     * 现场领取流程
     * @param apply
     * @param status
     */
    private void updateMedicalRecordSceneReceiveProcess(ProductServiceApply apply,int status,int currentState){
        if(status<apply.getProgressState()&&status<Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_APPLY_STATUS&&
                currentState!=Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_APPLY_STATUS){
            this.addReceiveApplyStatus(apply);
            //status=0;
        }

        /*if(status<apply.getProgressState()&&status<Constant.Business.MEDICAL_RECORD_RECEIVE_PROCESS_RECEIVE_STATUS){
            this.addReceiveGetStatus(apply);
        }*/
    }

}
