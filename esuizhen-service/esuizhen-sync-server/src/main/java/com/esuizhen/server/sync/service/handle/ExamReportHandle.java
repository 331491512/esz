package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.ExamReportRes;
import com.esuizhen.server.sync.dao.server.TExamReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nidan on 2017年03月28 下午 18:53
 */
@Component
public class ExamReportHandle {

    @Autowired
    private TExamReportDao examReportDao;

    public void syncAddExamReport(ExamReportRes examReport) {
        examReportDao.insertSelective(examReport);
    }

    public void syncUpdateExamReport(ExamReportRes examReport) {
        examReportDao.updateByPrimaryKeySelective(examReport);
    }

    public void syncAddRealtimeExamReport(ExamReportRes examReport) {
        examReportDao.insertRealtimeSelective(examReport);
    }

    public void syncUpdateRealtimeExamReport(ExamReportRes examReport) {
        examReportDao.updateRealtimeByPrimaryKeySelective(examReport);
    }
}
