package com.esuizhen.bigdata.repository.impl;

import com.esuizhen.bigdata.repository.user.PatientMergeRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 * Created by Nidan on 2016年12月24 上午 11:38
 */
public class PatientMergeRepositoryImpl implements PatientMergeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int patientMerge(String patientIds,Long i_operator,String i_mergeReason) {
        StoredProcedureQuery query=entityManager.createStoredProcedureQuery("patientMerge");
        query.registerStoredProcedureParameter("patientIds",String.class, ParameterMode.IN);
        query.setParameter("patientIds",patientIds);
        query.registerStoredProcedureParameter("i_operator",Long.class,ParameterMode.IN);
        query.setParameter("i_operator",i_operator);
        query.registerStoredProcedureParameter("i_mergeReason",String.class,ParameterMode.IN);
        query.setParameter("i_mergeReason",i_mergeReason);
        query.registerStoredProcedureParameter("res",Integer.class,ParameterMode.OUT);
        query.execute();
        Integer value=(Integer)query.getOutputParameterValue("res");
        return value;
    }

    @Override
    public boolean flushTaskPatientStateAndNumber() {
        StoredProcedureQuery query=entityManager.createStoredProcedureQuery("flushTaskPatientStateAndNumber");
        return query.execute();
    }

    @Override
    public int flushVarPatientFollowUp() {
        StoredProcedureQuery query=entityManager.createStoredProcedureQuery("flushVarPatientFollowUp");
        query.registerStoredProcedureParameter("r_error",Integer.class,ParameterMode.OUT);
        query.execute();
        Integer value=(Integer)query.getOutputParameterValue("r_error");
        return value;
    }
}
