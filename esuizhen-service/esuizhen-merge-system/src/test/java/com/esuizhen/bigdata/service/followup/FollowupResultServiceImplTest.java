package com.esuizhen.bigdata.service.followup;

import com.esuizhen.bigdata.domain.followup.FollowupResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 17/1/8.
 */
//@RunWith(SpringRunner.class)
//@Transactional
//@SpringBootTest
public class FollowupResultServiceImplTest {

    @Autowired
    private FollowupResultService followupResultService;

    private Long targetPatientId = 419944L;
    private List<Long> otherPatientIds =new ArrayList<Long>(){{
        add(401021L);
        add(568773L);
    }};
            //Lists.newArrayList(401021L, 568773L);

    //@Test
    public void findFollowupResultsOfTargetPatient() throws Exception {
        List<FollowupResult> followupResultsOfTargetPatient = followupResultService.findFollowupResultsOfTargetPatient(targetPatientId);
        //followupResultsOfTargetPatient.forEach(System.out::println);
    }

    //@Test
    public void findFollowupResult() throws Exception {

    }


    //@Test
    public void merge() throws Exception {
        followupResultService.merge(targetPatientId, otherPatientIds);
    }

    //@Test
    public void rollback() throws Exception {
        followupResultService.rollback(targetPatientId);
    }

}