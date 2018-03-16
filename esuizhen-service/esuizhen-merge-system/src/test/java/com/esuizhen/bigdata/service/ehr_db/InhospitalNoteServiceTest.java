/*
package com.esuizhen.bigdata.service.ehr_db;

import com.esuizhen.bigdata.service.ehr.InhospitalNoteService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Nidan on 2017年01月04 下午 14:40
 *//*

@RunWith(SpringRunner.class)
@Transactional
//@SpringBootTest
public class InhospitalNoteServiceTest {

    @Autowired
    private InhospitalNoteService inhospitalNoteService;

    @Test
    @Ignore
    public void testMergeInhospitalNote() {
        Long goalPatientId = 393131L;
        List<Long> otherPatientIds = new ArrayList<>();
        otherPatientIds.add(411543L);
        otherPatientIds.add(434755L);
        inhospitalNoteService.mergeInhospitalNote(goalPatientId, otherPatientIds);
    }

    @Test
    public void testRevokeMergeInhospitalNote() {
        Long goalPatientId = 393131L;
        inhospitalNoteService.revokeMergeInhospitalNote(goalPatientId);

    }

}
*/
