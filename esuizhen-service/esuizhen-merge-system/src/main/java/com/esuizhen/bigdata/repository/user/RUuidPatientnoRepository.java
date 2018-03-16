package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.RUuidPatientno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nidan on 2017年03月21 下午 14:57
 */
public interface RUuidPatientnoRepository extends JpaRepository<RUuidPatientno, Long> {

    public RUuidPatientno findByPatientNo(String patientNo);

}
