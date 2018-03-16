package com.esuizhen.bigdata.service.user.impl;

import com.esuizhen.bigdata.bean.MergeLogResult;
import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.user.UMergeLog;
import com.esuizhen.bigdata.domain.user.UPatient;
import com.esuizhen.bigdata.domain.user.UUser;
import com.esuizhen.bigdata.repository.user.MergeLogRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.repository.user.UUserRepository;
import com.esuizhen.bigdata.service.user.MergeLogService;
import com.westangel.common.bean.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nidan on 2016年12月23 下午 15:42
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)//add by fqc 尤其是错误日志需新开启事务
public class MergeLogServiceImpl implements MergeLogService {

    @Autowired
    private MergeLogRepository mergeLogRepository;
    @Autowired
    private UPatientRepository patientRepository;
    @Autowired
    private UUserRepository userRepository;

    /**
     * @param mergePatientReqInfo
     * @param mergeResult
     * @author fqc
     * @time 2017/1/7
     */
    @Override
    public void log(MergePatientReq mergePatientReqInfo, Integer mergeResult) {
        Long goalPatientId = mergePatientReqInfo.getGoalPatientId();
        List<Long> otherPatientIds = mergePatientReqInfo.getOtherPatientIds();
        String mergeReason = mergePatientReqInfo.getMergeReason();
        String mergeTime = TimeUtils.getCurrentTimestamp().toString();
        //Timestamp mergeTime = TimeUtils.getCurrentTimestamp();
        Long operatorId = mergePatientReqInfo.getOperatorId();
        UMergeLog mergeLogBean = new UMergeLog(goalPatientId, otherPatientIds.toString().trim().replace("[", "").replace("]", ""), mergeReason, mergeTime, mergeResult, operatorId);
        mergeLogRepository.save(mergeLogBean);
    }

    @Override
    public Page<MergeLogResult> selectMergePatientLogList(Integer num, Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "mergeTime");
        Pageable pageable = new PageRequest(page, num, sort);
        org.springframework.data.domain.Page<UMergeLog> page1 = mergeLogRepository.findAll(pageable);
        Page<MergeLogResult> page2 = new Page<>();
        page2.setTotalPage(page1.getTotalPages());
        page2.setCurrSize(page1.getContent().size());
        page2.setCurrPage(page);
        page2.setTotalNum((int) page1.getTotalElements());
        List<MergeLogResult> mergeLogResults = new ArrayList<>();
        MergeLogResult mergeLogResult = null;
        StringBuffer sf = null;
        for (UMergeLog mergeLog : page1.getContent()) {
            mergeLogResult = new MergeLogResult();
            mergeLogResult.setMergeTime(mergeLog.getMergeTime());
            mergeLogResult.setGolPatientId(mergeLog.getGoalPatientId());
            mergeLogResult.setMergeReason(mergeLog.getMergeReason());
            UUser user = userRepository.findOne(mergeLog.getOperator());
            mergeLogResult.setOperator(user.getTrueName());
            String[] patientIds = mergeLog.getOtherPatientIds().split(",");
            UPatient p = patientRepository.findByPatientId(mergeLog.getGoalPatientId());
            if (p != null) {
                sf = new StringBuffer("将");
                sf.append(p.getTrueName() + "(" + p.getPatientNo() + "),");
                for (String patientId : patientIds) {
                    UPatient patient = patientRepository.findByPatientId(Long.valueOf(patientId.trim()));//[401021, 568773] [401021,568773]
                    sf.append(patient.getTrueName() + "(" + patient.getPatientNo() + "),");
                }
                sf.delete(sf.length() - 1, sf.length());
                sf.append("合并为" + p.getTrueName() + "(" + p.getPatientNo() + ")");
                mergeLogResult.setMergeResult(mergeLog.getMergeResult().toString());
                mergeLogResult.setMergeContent(sf.toString());
                // mergeLogResult.setMergeContent(mergeLog.getGoalPatientId());
                mergeLogResults.add(mergeLogResult);
            }

        }
        page2.setDataList(mergeLogResults);
        return page2;
    }


}
