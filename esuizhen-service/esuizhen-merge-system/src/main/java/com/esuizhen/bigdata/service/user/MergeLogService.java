package com.esuizhen.bigdata.service.user;

import com.esuizhen.bigdata.bean.MergeLogResult;
import com.esuizhen.bigdata.bean.MergePatientReq;
import com.westangel.common.bean.Page;

/**
 * Created by Nidan on 2016年12月23 下午 15:37
 */
public interface MergeLogService {
    Page<MergeLogResult> selectMergePatientLogList(Integer num, Integer page);

    /**
     * @param mergePatientReqInfo
     * @param mergeResult
     * @author fqc
     * @time 2017/1/7
     */
    void log(MergePatientReq mergePatientReqInfo, Integer mergeResult);
}
