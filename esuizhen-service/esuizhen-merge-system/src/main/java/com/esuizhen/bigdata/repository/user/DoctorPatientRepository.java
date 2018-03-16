package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.RDoctorPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.List;

/**
 * Created by Nidan on 2016年12月17 下午 15:53
 */
public interface DoctorPatientRepository extends JpaRepository<RDoctorPatient, Long> {

    public List<RDoctorPatient> findByPatientId(Long patientId);

   /* @Modifying
    @Query("update user_db.r_doctor_patient u set u.patientId=?1 where u.patientId=?2")
    public RDoctorPatient updateRDoctorPatient(Long patientId,List<Long> golPatientId);*/

    public RDoctorPatient save(RDoctorPatient doctorPatient);

    public void deleteByPatientIdIn(List<Long> otherPatientIds);

    public List<RDoctorPatient> findAllByPatientIdIn(List<Long> patientIds);

}
