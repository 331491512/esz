package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.UPatientFamily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by fqc on 16/12/19.
 */
//@RepositoryRestController
//@Transactional
public interface UPatientFamilyRepository extends //RevisionRepository<UPatientFamily, Long, Integer>
        JpaRepository<UPatientFamily, Long> {
    //patientId`,`familyPhone`,`familyName`,`address
    UPatientFamily findByPatientIdAndFamilyPhoneAndFamilyNameAndAddress(Long patientId, String familyPhone, String familyName, String address);

    List<UPatientFamily> findByPatientId(long patientId);

    List<UPatientFamily> findAllByPatientIdIn(Iterable<Long> mergePatientIds);

    List<UPatientFamily> findByPatientIdInAndCreateTimeGreaterThan(List<Long> patientIds, Timestamp lostFollowupTime);

    List<UPatientFamily> findByPatientIdAndIsDefault(Long targetPatientId, Integer isDefaultPhone);

    UPatientFamily findByPatientIdAndFamilyNameAndFamilyPhoneAndAddress(Long patientId, String familyName, String familyPhone, String address);

    List<UPatientFamily> findByMergeTarget(Long targetPatientId);
}
