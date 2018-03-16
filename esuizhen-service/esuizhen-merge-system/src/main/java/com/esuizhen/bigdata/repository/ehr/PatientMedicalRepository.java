package com.esuizhen.bigdata.repository.ehr;

import com.esuizhen.bigdata.domain.ehr.VarPatientMedical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;

/**
 * Created by Nidan on 2017年01月06 下午 15:05
 */
public interface PatientMedicalRepository extends JpaRepository<VarPatientMedical,Long> {

    public VarPatientMedical findByPatientIdAndLatestClinicDateGreaterThan(Long patientId, Timestamp followupTime);

    public VarPatientMedical findByPatientIdAndLatestOutHospitalDateGreaterThan(Long patientId, Timestamp followupTime);
}
