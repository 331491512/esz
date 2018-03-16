package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.ExamReportRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TExamReportDao {

    void insertSelective(ExamReportRes record);

    void updateByPrimaryKeySelective(ExamReportRes record);

    /**
     * 向实时库中添加数据
     * @param examReport
     */
    void insertRealtimeSelective(ExamReportRes examReport);

    /**
     * 向实时库中更新数据
     * @param examReport
     */
    void updateRealtimeByPrimaryKeySelective(ExamReportRes examReport);
}