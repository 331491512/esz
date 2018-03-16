package com.esuizhen.bigdata.controller.followup;

import com.esuizhen.bigdata.common.ResponseResult;
import com.esuizhen.bigdata.common.RestResultGenerator;
import com.esuizhen.bigdata.domain.followup.FollowupResult;
import com.esuizhen.bigdata.repository.followup.FollowupResultRepository;
import com.esuizhen.bigdata.service.followup.FollowupResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fqc on 11/29/16.
 */
@RestController
@RequestMapping("/followup_result")
public class FollowUPResultController {

    @Autowired
    FollowupResultService followUPResultService;

    @Autowired
    FollowupResultRepository followupResultRepository;

    @RequestMapping("")
    public ResponseResult getFollowupResult() {
        List<FollowupResult> followupResults = followUPResultService.findFollowupResult();
        return RestResultGenerator.genResult(followupResults, "ok");
    }

    @RequestMapping("/save")
    public ResponseResult saveResult() {
        FollowupResult followupResult = new FollowupResult();
        FollowupResult bean = followupResultRepository.save(followupResult);
        return RestResultGenerator.genResult(bean, "ok");
    }


}
