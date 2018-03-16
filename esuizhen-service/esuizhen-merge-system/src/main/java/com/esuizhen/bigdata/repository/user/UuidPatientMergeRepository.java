package com.esuizhen.bigdata.repository.user;

import com.esuizhen.bigdata.domain.user.UuidPatientMerge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fqc on 16/12/6.
 */
@RepositoryRestResource
@Transactional
public interface UuidPatientMergeRepository extends //RevisionRepository<UuidPatientMerge, Long, Integer>
        JpaRepository<UuidPatientMerge, Long> {
    //    UuidPatientMerge findByPatientId(Long patientId);
    //注入与数据库字段一致
    List<UuidPatientMerge> findAllOrderByPatientidAndRepeatflag(Long patientId, Integer repeatFlag);

    List<UuidPatientMerge> findByPatientidIn(Iterable patientIds);

    /**
     * uuidPatientMerge表中待合并的患者
     *
     * @param iterable
     * @return
     */
    List<UuidPatientMerge> findAllOrderByPatientidInAndRepeatflag(Iterable iterable, Integer repeatFlag);

    //where uuidpatien0_.patientid=(? , ?)
    @Deprecated
    List<UuidPatientMerge> findAllOrderByPatientid(Iterable iterable);

    /**
     * 查询目标患者 merge  patientId=goalPatientId
     *
     * @param goalPatientId
     * @param repeatFlag
     * @return
     */
    UuidPatientMerge findByPatientidAndRepeatflag(Long goalPatientId, Integer repeatFlag);

    /**
     * 合并组
     *
     * @param goalPatientId
     * @param repeatFlag
     * @return
     */
    List<UuidPatientMerge> findAllOrderByGoalpatientidAndRepeatflag(Long goalPatientId, Integer repeatFlag);

    /**
     * 被合并成功的患者，为回退准备
     *
     * @param goalPatientId
     * @param repeatFlag
     * @param resultFlag
     * @return
     */
    List<UuidPatientMerge> findByGoalpatientidAndRepeatflagAndResultflag(Long goalPatientId, Integer repeatFlag, Integer resultFlag);
    //org.springframework.data.mapping.PropertyReferenceException: No property findall found for type UuidPatientMerge!
    //如果重新定制了，需要显示的写出默认的  //最终是发现不是这样傻的，是因为findallOrderBy....   findall ,也不应该是尼玛 findALL
//    List<UuidPatientMerge> findAll(Iterable iterable);

    // 默认的 findAll语句
//    select uuidpatien0_.id as id1_293_, uuidpatien0_.goalpatientid as goalpati2_293_, uuidpatien0_.increflag as increfla3_293_,
//    uuidpatien0_.mergeflag as mergefla4_293_, uuidpatien0_.newmedicalrecordno as newmedic5_293_, uuidpatien0_.newuuid as newuuid6_293_,
//    uuidpatien0_.oldmedicalrecordno as oldmedic7_293_, uuidpatien0_.olduuid as olduuid8_293_, uuidpatien0_.patientid as patienti9_293_,
//    uuidpatien0_.remark as remark10_293_, uuidpatien0_.repeatflag as repeatf11_293_, uuidpatien0_.resultflag as resultf12_293_
//    from uuid_patient_merge uuidpatien0_ where uuidpatien0_.id in (? , ?)

//    Set<String> findByRemarkGroup();

    @Query("select a.remark from UuidPatientMerge a")
    List<String> getRemarkInfo();

    @Query(nativeQuery = true, value = "SELECT a.id , count(a.patientid) AS cn FROM uuid_patient_merge a GROUP BY a.patientId HAVING cn = 1;")
    List<Object> getSimilarPatientButJustOne();

    /**
     * 查询疑似患者列表
     * @param goalPatientId
     * @param repeatflag
     * @param cancelflag
     */
    List<UuidPatientMerge> findByGoalpatientidAndRepeatflagAndCancelflag(Long goalPatientId, Integer repeatflag, Integer cancelflag);
}

