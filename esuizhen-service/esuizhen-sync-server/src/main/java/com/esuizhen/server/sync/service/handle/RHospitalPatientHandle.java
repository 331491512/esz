package com.esuizhen.server.sync.service.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.server.HospitalPatientRes;
import com.esuizhen.server.sync.dao.server.RHospitalPatientDao;

/**
 * Created by Nidan on 2017年03月30 下午 14:09
 */
@Component
public class RHospitalPatientHandle {

    @Autowired
    private RHospitalPatientDao hospitalPatientDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncHospitalPatient(HospitalPatientRes hospitalPatient) {
        if(hospitalPatient.getOpFlag().equals(1)) {
            hospitalPatientDao.insert(hospitalPatient);
        }else{
            hospitalPatientDao.update(hospitalPatient);
        }
    }

}
