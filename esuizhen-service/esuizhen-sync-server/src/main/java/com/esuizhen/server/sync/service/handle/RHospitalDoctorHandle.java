package com.esuizhen.server.sync.service.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.server.HospitalDoctorRes;
import com.esuizhen.server.sync.dao.server.RHospitalDoctorDao;

/**
 * Created by Nidan on 2017年03月30 下午 14:05
 */
@Component
public class RHospitalDoctorHandle {

    @Autowired
    private RHospitalDoctorDao hospitalDoctorDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void syncHospitalDoctor(HospitalDoctorRes hospitalDoctor) {
        if(hospitalDoctor.getOpFlag().equals(1)) {
            hospitalDoctorDao.insert(hospitalDoctor);
        }else{
            hospitalDoctorDao.update(hospitalDoctor);
        }
    }

}
