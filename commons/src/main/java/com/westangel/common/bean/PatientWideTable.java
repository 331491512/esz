package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

public class PatientWideTable implements Serializable{
	private Integer id;

    private Long patientId;

    private String sourceDiagnosisId;

    private String sourceDiagnosisId2;

    private String inhospitalId;

    private String inhospitalId2;

    private String familyName1;

    private Integer patientRelationId1;

    private String patientRelation1;

    private String familyPhone1;

    private String address1;

    private Integer isValid1;

    private String familyName2;

    private Integer patientRelationId2;

    private String patientRelation2;

    private String familyPhone2;

    private String address2;

    private Integer isValid2;

    private String familyName3;

    private Integer patientRelationId3;

    private String patientRelation3;

    private String familyPhone3;

    private String address3;

    private Integer isValid3;

    private Date familyCreateTime3;

    private Integer sourceInhospitalWay;

    private String sourceInhospitalWayName;

    private Date sourceInhospitalDate;

    private Date sourceOuthospitalDate;

    private Integer sourceInhospitalDeptId;

    private String sourceInhospitalDeptName;

    private Integer sourceOuthospitalDeptId;

    private String sourceOuthospitalDeptName;

    private Integer sourceTurnDeptId;

    private String sourceTurnDeptName;

    private Integer sourceDeptDoctor;

    private String sourceDeptDoctorName;

    private Integer sourceDirectorDoctor;

    private String sourceDirectorDoctorName;

    private Integer sourceInchargeDoctor;

    private String sourceInchargeDoctorName;

    private Integer sourceInhospitalDoctor;

    private String sourceInhospitalDoctorName;

    private Integer sourceAttendingDoctor;

    private String sourceAttendingDoctorName;

    private Integer sourceCancerNum;

    private Date confirmedDate;

    private Integer confirmedAge;

    private Integer sourceDiseaseTypeId;

    private String sourceDiseaseTypeName;

    private String sourceDiagnosis;

    private String sourceDiseaseCode;

    private String secondaryDiagnosis;

    private String secondaryDiseaseCode;

    private String secondaryPathologyDiagnosis;

    private String secondaryPathologyDiseaseCode;

    private String sourceDiagnosis2;

    private String sourceDiseaseCode2;

    private String sourcePathologyDiagnosis2;

    private String sourcePathologyDiseaseCode2;

    private String tumourPeriodizationClinic;

    private String tumourPeriodizationTNM;

    private String diagnosis1;

    private String diagnosis2;

    private String diagnosis3;

    private String diagnosis4;

    private String diagnosis5;

    private String diseaseCode1;

    private String diseaseCode2;

    private String diseaseCode3;

    private String diseaseCode4;

    private String diseaseCode5;

    private String pathologyDiagnosis1;

    private String pathologyDiagnosis2;

    private String pathologyDiagnosis3;

    private String pathologyDiagnosis4;

    private String pathologyDiagnosis5;

    private String pathologyDiagnosisCode1;

    private String pathologyDiagnosisCode2;

    private String pathologyDiagnosisCode3;

    private String pathologyDiagnosisCode4;

    private String pathologyDiagnosisCode5;

    private Integer disagnosisPeriodizationId1;

    private Integer disagnosisPeriodizationId2;

    private Integer disagnosisPeriodizationId3;

    private Integer disagnosisPeriodizationId4;

    private Integer disagnosisPeriodizationId5;

    private String disagnosisPeriodizationName1;

    private String disagnosisPeriodizationName2;

    private String disagnosisPeriodizationName3;

    private String disagnosisPeriodizationName4;

    private String disagnosisPeriodizationName5;

    private Date surgeryDate1;

    private Date surgeryDate2;

    private Date surgeryDate3;

    private Date surgeryDate4;

    private Date surgeryDate5;

    private Date surgeryDate6;

    private Date surgeryDate7;

    private Date surgeryDate8;

    private String surgeryName1;

    private String surgeryName2;

    private String surgeryName3;

    private String surgeryName4;

    private String surgeryName5;

    private String surgeryName6;

    private String surgeryName7;

    private String surgeryName8;

    private String opCode1;

    private String opCode2;

    private String opCode3;

    private String opCode4;

    private String opCode5;

    private String opCode6;

    private String opCode7;

    private String opCode8;

    private Long surgeryDoctor1;

    private Long surgeryDoctor2;

    private Long surgeryDoctor3;

    private Long surgeryDoctor4;

    private Long surgeryDoctor5;

    private Long surgeryDoctor6;

    private Long surgeryDoctor7;

    private Long surgeryDoctor8;

    private String surgeryDoctorName1;

    private String surgeryDoctorName2;

    private String surgeryDoctorName3;

    private String surgeryDoctorName4;

    private String surgeryDoctorName5;

    private String surgeryDoctorName6;

    private String surgeryDoctorName7;

    private String surgeryDoctorName8;

    private Date familyCreateTime1;

    private Date familyCreateTime2;

    private Date diagnosisCreateTime1;

    private Date diagnosisCreateTime2;

    private Date diagnosisCreateTime3;

    private Date diagnosisCreateTime4;

    private Date diagnosisCreateTime5;

    private Integer diagnosisType1;

    private Integer diagnosisType2;

    private Integer diagnosisType3;

    private Integer diagnosisType4;

    private Integer diagnosisType5;

    private String diagnosisId1;

    private String diagnosisId2;

    private String diagnosisId3;

    private String diagnosisId4;

    private String diagnosisId5;

    private Date surgeryCreateTime1;

    private Date surgeryCreateTime2;

    private Date surgeryCreateTime3;

    private Date surgeryCreateTime4;

    private Date surgeryCreateTime5;

    private Date surgeryCreateTime6;

    private Date surgeryCreateTime7;

    private Date surgeryCreateTime8;

    private String treatmentNames;

    private String treatmentHistory;

    private Integer firstOuthospitalDeptId;

    private String firstOuthospitalDeptName;

    private Integer latestOuthospitalDeptId;

    private String latestOuthospitalDeptName;

    private Date latestClinicDate;

    private Date latestInhospitalDate;

    private Date latestOuthospitalDate;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getSourceDiagnosisId() {
        return sourceDiagnosisId;
    }

    public void setSourceDiagnosisId(String sourceDiagnosisId) {
        this.sourceDiagnosisId = sourceDiagnosisId;
    }

    public String getSourceDiagnosisId2() {
        return sourceDiagnosisId2;
    }

    public void setSourceDiagnosisId2(String sourceDiagnosisId2) {
        this.sourceDiagnosisId2 = sourceDiagnosisId2;
    }

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    public String getInhospitalId2() {
        return inhospitalId2;
    }

    public void setInhospitalId2(String inhospitalId2) {
        this.inhospitalId2 = inhospitalId2;
    }

    public String getFamilyName1() {
        return familyName1;
    }

    public void setFamilyName1(String familyName1) {
        this.familyName1 = familyName1;
    }

    public Integer getPatientRelationId1() {
        return patientRelationId1;
    }

    public void setPatientRelationId1(Integer patientRelationId1) {
        this.patientRelationId1 = patientRelationId1;
    }

    public String getPatientRelation1() {
        return patientRelation1;
    }

    public void setPatientRelation1(String patientRelation1) {
        this.patientRelation1 = patientRelation1;
    }

    public String getFamilyPhone1() {
        return familyPhone1;
    }

    public void setFamilyPhone1(String familyPhone1) {
        this.familyPhone1 = familyPhone1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public Integer getIsValid1() {
        return isValid1;
    }

    public void setIsValid1(Integer isValid1) {
        this.isValid1 = isValid1;
    }

    public String getFamilyName2() {
        return familyName2;
    }

    public void setFamilyName2(String familyName2) {
        this.familyName2 = familyName2;
    }

    public Integer getPatientRelationId2() {
        return patientRelationId2;
    }

    public void setPatientRelationId2(Integer patientRelationId2) {
        this.patientRelationId2 = patientRelationId2;
    }

    public String getPatientRelation2() {
        return patientRelation2;
    }

    public void setPatientRelation2(String patientRelation2) {
        this.patientRelation2 = patientRelation2;
    }

    public String getFamilyPhone2() {
        return familyPhone2;
    }

    public void setFamilyPhone2(String familyPhone2) {
        this.familyPhone2 = familyPhone2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Integer getIsValid2() {
        return isValid2;
    }

    public void setIsValid2(Integer isValid2) {
        this.isValid2 = isValid2;
    }

    public String getFamilyName3() {
        return familyName3;
    }

    public void setFamilyName3(String familyName3) {
        this.familyName3 = familyName3;
    }

    public Integer getPatientRelationId3() {
        return patientRelationId3;
    }

    public void setPatientRelationId3(Integer patientRelationId3) {
        this.patientRelationId3 = patientRelationId3;
    }

    public String getPatientRelation3() {
        return patientRelation3;
    }

    public void setPatientRelation3(String patientRelation3) {
        this.patientRelation3 = patientRelation3;
    }

    public String getFamilyPhone3() {
        return familyPhone3;
    }

    public void setFamilyPhone3(String familyPhone3) {
        this.familyPhone3 = familyPhone3;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public Integer getIsValid3() {
        return isValid3;
    }

    public void setIsValid3(Integer isValid3) {
        this.isValid3 = isValid3;
    }

    public Date getFamilyCreateTime3() {
        return familyCreateTime3;
    }

    public void setFamilyCreateTime3(Date familyCreateTime3) {
        this.familyCreateTime3 = familyCreateTime3;
    }

    public Integer getSourceInhospitalWay() {
        return sourceInhospitalWay;
    }

    public void setSourceInhospitalWay(Integer sourceInhospitalWay) {
        this.sourceInhospitalWay = sourceInhospitalWay;
    }

    public String getSourceInhospitalWayName() {
        return sourceInhospitalWayName;
    }

    public void setSourceInhospitalWayName(String sourceInhospitalWayName) {
        this.sourceInhospitalWayName = sourceInhospitalWayName;
    }

    public Date getSourceInhospitalDate() {
        return sourceInhospitalDate;
    }

    public void setSourceInhospitalDate(Date sourceInhospitalDate) {
        this.sourceInhospitalDate = sourceInhospitalDate;
    }

    public Date getSourceOuthospitalDate() {
        return sourceOuthospitalDate;
    }

    public void setSourceOuthospitalDate(Date sourceOuthospitalDate) {
        this.sourceOuthospitalDate = sourceOuthospitalDate;
    }

    public Integer getSourceInhospitalDeptId() {
        return sourceInhospitalDeptId;
    }

    public void setSourceInhospitalDeptId(Integer sourceInhospitalDeptId) {
        this.sourceInhospitalDeptId = sourceInhospitalDeptId;
    }

    public String getSourceInhospitalDeptName() {
        return sourceInhospitalDeptName;
    }

    public void setSourceInhospitalDeptName(String sourceInhospitalDeptName) {
        this.sourceInhospitalDeptName = sourceInhospitalDeptName;
    }

    public Integer getSourceOuthospitalDeptId() {
        return sourceOuthospitalDeptId;
    }

    public void setSourceOuthospitalDeptId(Integer sourceOuthospitalDeptId) {
        this.sourceOuthospitalDeptId = sourceOuthospitalDeptId;
    }

    public String getSourceOuthospitalDeptName() {
        return sourceOuthospitalDeptName;
    }

    public void setSourceOuthospitalDeptName(String sourceOuthospitalDeptName) {
        this.sourceOuthospitalDeptName = sourceOuthospitalDeptName;
    }

    public Integer getSourceTurnDeptId() {
        return sourceTurnDeptId;
    }

    public void setSourceTurnDeptId(Integer sourceTurnDeptId) {
        this.sourceTurnDeptId = sourceTurnDeptId;
    }

    public String getSourceTurnDeptName() {
        return sourceTurnDeptName;
    }

    public void setSourceTurnDeptName(String sourceTurnDeptName) {
        this.sourceTurnDeptName = sourceTurnDeptName;
    }

    public Integer getSourceDeptDoctor() {
        return sourceDeptDoctor;
    }

    public void setSourceDeptDoctor(Integer sourceDeptDoctor) {
        this.sourceDeptDoctor = sourceDeptDoctor;
    }

    public String getSourceDeptDoctorName() {
        return sourceDeptDoctorName;
    }

    public void setSourceDeptDoctorName(String sourceDeptDoctorName) {
        this.sourceDeptDoctorName = sourceDeptDoctorName;
    }

    public Integer getSourceDirectorDoctor() {
        return sourceDirectorDoctor;
    }

    public void setSourceDirectorDoctor(Integer sourceDirectorDoctor) {
        this.sourceDirectorDoctor = sourceDirectorDoctor;
    }

    public String getSourceDirectorDoctorName() {
        return sourceDirectorDoctorName;
    }

    public void setSourceDirectorDoctorName(String sourceDirectorDoctorName) {
        this.sourceDirectorDoctorName = sourceDirectorDoctorName;
    }

    public Integer getSourceInchargeDoctor() {
        return sourceInchargeDoctor;
    }

    public void setSourceInchargeDoctor(Integer sourceInchargeDoctor) {
        this.sourceInchargeDoctor = sourceInchargeDoctor;
    }

    public String getSourceInchargeDoctorName() {
        return sourceInchargeDoctorName;
    }

    public void setSourceInchargeDoctorName(String sourceInchargeDoctorName) {
        this.sourceInchargeDoctorName = sourceInchargeDoctorName;
    }

    public Integer getSourceInhospitalDoctor() {
        return sourceInhospitalDoctor;
    }

    public void setSourceInhospitalDoctor(Integer sourceInhospitalDoctor) {
        this.sourceInhospitalDoctor = sourceInhospitalDoctor;
    }

    public String getSourceInhospitalDoctorName() {
        return sourceInhospitalDoctorName;
    }

    public void setSourceInhospitalDoctorName(String sourceInhospitalDoctorName) {
        this.sourceInhospitalDoctorName = sourceInhospitalDoctorName;
    }

    public Integer getSourceAttendingDoctor() {
        return sourceAttendingDoctor;
    }

    public void setSourceAttendingDoctor(Integer sourceAttendingDoctor) {
        this.sourceAttendingDoctor = sourceAttendingDoctor;
    }

    public String getSourceAttendingDoctorName() {
        return sourceAttendingDoctorName;
    }

    public void setSourceAttendingDoctorName(String sourceAttendingDoctorName) {
        this.sourceAttendingDoctorName = sourceAttendingDoctorName;
    }

    public Integer getSourceCancerNum() {
        return sourceCancerNum;
    }

    public void setSourceCancerNum(Integer sourceCancerNum) {
        this.sourceCancerNum = sourceCancerNum;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public Integer getConfirmedAge() {
        return confirmedAge;
    }

    public void setConfirmedAge(Integer confirmedAge) {
        this.confirmedAge = confirmedAge;
    }

    public Integer getSourceDiseaseTypeId() {
        return sourceDiseaseTypeId;
    }

    public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
        this.sourceDiseaseTypeId = sourceDiseaseTypeId;
    }

    public String getSourceDiseaseTypeName() {
        return sourceDiseaseTypeName;
    }

    public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
        this.sourceDiseaseTypeName = sourceDiseaseTypeName;
    }

    public String getSourceDiagnosis() {
        return sourceDiagnosis;
    }

    public void setSourceDiagnosis(String sourceDiagnosis) {
        this.sourceDiagnosis = sourceDiagnosis;
    }

    public String getSourceDiseaseCode() {
        return sourceDiseaseCode;
    }

    public void setSourceDiseaseCode(String sourceDiseaseCode) {
        this.sourceDiseaseCode = sourceDiseaseCode;
    }

    public String getSecondaryDiagnosis() {
        return secondaryDiagnosis;
    }

    public void setSecondaryDiagnosis(String secondaryDiagnosis) {
        this.secondaryDiagnosis = secondaryDiagnosis;
    }

    public String getSecondaryDiseaseCode() {
        return secondaryDiseaseCode;
    }

    public void setSecondaryDiseaseCode(String secondaryDiseaseCode) {
        this.secondaryDiseaseCode = secondaryDiseaseCode;
    }

    public String getSecondaryPathologyDiagnosis() {
        return secondaryPathologyDiagnosis;
    }

    public void setSecondaryPathologyDiagnosis(String secondaryPathologyDiagnosis) {
        this.secondaryPathologyDiagnosis = secondaryPathologyDiagnosis;
    }

    public String getSecondaryPathologyDiseaseCode() {
        return secondaryPathologyDiseaseCode;
    }

    public void setSecondaryPathologyDiseaseCode(String secondaryPathologyDiseaseCode) {
        this.secondaryPathologyDiseaseCode = secondaryPathologyDiseaseCode;
    }

    public String getSourceDiagnosis2() {
        return sourceDiagnosis2;
    }

    public void setSourceDiagnosis2(String sourceDiagnosis2) {
        this.sourceDiagnosis2 = sourceDiagnosis2;
    }

    public String getSourceDiseaseCode2() {
        return sourceDiseaseCode2;
    }

    public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
        this.sourceDiseaseCode2 = sourceDiseaseCode2;
    }

    public String getSourcePathologyDiagnosis2() {
        return sourcePathologyDiagnosis2;
    }

    public void setSourcePathologyDiagnosis2(String sourcePathologyDiagnosis2) {
        this.sourcePathologyDiagnosis2 = sourcePathologyDiagnosis2;
    }

    public String getSourcePathologyDiseaseCode2() {
        return sourcePathologyDiseaseCode2;
    }

    public void setSourcePathologyDiseaseCode2(String sourcePathologyDiseaseCode2) {
        this.sourcePathologyDiseaseCode2 = sourcePathologyDiseaseCode2;
    }

    public String getTumourPeriodizationClinic() {
        return tumourPeriodizationClinic;
    }

    public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
        this.tumourPeriodizationClinic = tumourPeriodizationClinic;
    }

    public String getTumourPeriodizationTNM() {
        return tumourPeriodizationTNM;
    }

    public void setTumourPeriodizationTNM(String tumourPeriodizationTNM) {
        this.tumourPeriodizationTNM = tumourPeriodizationTNM;
    }

    public String getDiagnosis1() {
        return diagnosis1;
    }

    public void setDiagnosis1(String diagnosis1) {
        this.diagnosis1 = diagnosis1;
    }

    public String getDiagnosis2() {
        return diagnosis2;
    }

    public void setDiagnosis2(String diagnosis2) {
        this.diagnosis2 = diagnosis2;
    }

    public String getDiagnosis3() {
        return diagnosis3;
    }

    public void setDiagnosis3(String diagnosis3) {
        this.diagnosis3 = diagnosis3;
    }

    public String getDiagnosis4() {
        return diagnosis4;
    }

    public void setDiagnosis4(String diagnosis4) {
        this.diagnosis4 = diagnosis4;
    }

    public String getDiagnosis5() {
        return diagnosis5;
    }

    public void setDiagnosis5(String diagnosis5) {
        this.diagnosis5 = diagnosis5;
    }

    public String getDiseaseCode1() {
        return diseaseCode1;
    }

    public void setDiseaseCode1(String diseaseCode1) {
        this.diseaseCode1 = diseaseCode1;
    }

    public String getDiseaseCode2() {
        return diseaseCode2;
    }

    public void setDiseaseCode2(String diseaseCode2) {
        this.diseaseCode2 = diseaseCode2;
    }

    public String getDiseaseCode3() {
        return diseaseCode3;
    }

    public void setDiseaseCode3(String diseaseCode3) {
        this.diseaseCode3 = diseaseCode3;
    }

    public String getDiseaseCode4() {
        return diseaseCode4;
    }

    public void setDiseaseCode4(String diseaseCode4) {
        this.diseaseCode4 = diseaseCode4;
    }

    public String getDiseaseCode5() {
        return diseaseCode5;
    }

    public void setDiseaseCode5(String diseaseCode5) {
        this.diseaseCode5 = diseaseCode5;
    }

    public String getPathologyDiagnosis1() {
        return pathologyDiagnosis1;
    }

    public void setPathologyDiagnosis1(String pathologyDiagnosis1) {
        this.pathologyDiagnosis1 = pathologyDiagnosis1;
    }

    public String getPathologyDiagnosis2() {
        return pathologyDiagnosis2;
    }

    public void setPathologyDiagnosis2(String pathologyDiagnosis2) {
        this.pathologyDiagnosis2 = pathologyDiagnosis2;
    }

    public String getPathologyDiagnosis3() {
        return pathologyDiagnosis3;
    }

    public void setPathologyDiagnosis3(String pathologyDiagnosis3) {
        this.pathologyDiagnosis3 = pathologyDiagnosis3;
    }

    public String getPathologyDiagnosis4() {
        return pathologyDiagnosis4;
    }

    public void setPathologyDiagnosis4(String pathologyDiagnosis4) {
        this.pathologyDiagnosis4 = pathologyDiagnosis4;
    }

    public String getPathologyDiagnosis5() {
        return pathologyDiagnosis5;
    }

    public void setPathologyDiagnosis5(String pathologyDiagnosis5) {
        this.pathologyDiagnosis5 = pathologyDiagnosis5;
    }

    public String getPathologyDiagnosisCode1() {
        return pathologyDiagnosisCode1;
    }

    public void setPathologyDiagnosisCode1(String pathologyDiagnosisCode1) {
        this.pathologyDiagnosisCode1 = pathologyDiagnosisCode1;
    }

    public String getPathologyDiagnosisCode2() {
        return pathologyDiagnosisCode2;
    }

    public void setPathologyDiagnosisCode2(String pathologyDiagnosisCode2) {
        this.pathologyDiagnosisCode2 = pathologyDiagnosisCode2;
    }

    public String getPathologyDiagnosisCode3() {
        return pathologyDiagnosisCode3;
    }

    public void setPathologyDiagnosisCode3(String pathologyDiagnosisCode3) {
        this.pathologyDiagnosisCode3 = pathologyDiagnosisCode3;
    }

    public String getPathologyDiagnosisCode4() {
        return pathologyDiagnosisCode4;
    }

    public void setPathologyDiagnosisCode4(String pathologyDiagnosisCode4) {
        this.pathologyDiagnosisCode4 = pathologyDiagnosisCode4;
    }

    public String getPathologyDiagnosisCode5() {
        return pathologyDiagnosisCode5;
    }

    public void setPathologyDiagnosisCode5(String pathologyDiagnosisCode5) {
        this.pathologyDiagnosisCode5 = pathologyDiagnosisCode5;
    }

    public Integer getDisagnosisPeriodizationId1() {
        return disagnosisPeriodizationId1;
    }

    public void setDisagnosisPeriodizationId1(Integer disagnosisPeriodizationId1) {
        this.disagnosisPeriodizationId1 = disagnosisPeriodizationId1;
    }

    public Integer getDisagnosisPeriodizationId2() {
        return disagnosisPeriodizationId2;
    }

    public void setDisagnosisPeriodizationId2(Integer disagnosisPeriodizationId2) {
        this.disagnosisPeriodizationId2 = disagnosisPeriodizationId2;
    }

    public Integer getDisagnosisPeriodizationId3() {
        return disagnosisPeriodizationId3;
    }

    public void setDisagnosisPeriodizationId3(Integer disagnosisPeriodizationId3) {
        this.disagnosisPeriodizationId3 = disagnosisPeriodizationId3;
    }

    public Integer getDisagnosisPeriodizationId4() {
        return disagnosisPeriodizationId4;
    }

    public void setDisagnosisPeriodizationId4(Integer disagnosisPeriodizationId4) {
        this.disagnosisPeriodizationId4 = disagnosisPeriodizationId4;
    }

    public Integer getDisagnosisPeriodizationId5() {
        return disagnosisPeriodizationId5;
    }

    public void setDisagnosisPeriodizationId5(Integer disagnosisPeriodizationId5) {
        this.disagnosisPeriodizationId5 = disagnosisPeriodizationId5;
    }

    public String getDisagnosisPeriodizationName1() {
        return disagnosisPeriodizationName1;
    }

    public void setDisagnosisPeriodizationName1(String disagnosisPeriodizationName1) {
        this.disagnosisPeriodizationName1 = disagnosisPeriodizationName1;
    }

    public String getDisagnosisPeriodizationName2() {
        return disagnosisPeriodizationName2;
    }

    public void setDisagnosisPeriodizationName2(String disagnosisPeriodizationName2) {
        this.disagnosisPeriodizationName2 = disagnosisPeriodizationName2;
    }

    public String getDisagnosisPeriodizationName3() {
        return disagnosisPeriodizationName3;
    }

    public void setDisagnosisPeriodizationName3(String disagnosisPeriodizationName3) {
        this.disagnosisPeriodizationName3 = disagnosisPeriodizationName3;
    }

    public String getDisagnosisPeriodizationName4() {
        return disagnosisPeriodizationName4;
    }

    public void setDisagnosisPeriodizationName4(String disagnosisPeriodizationName4) {
        this.disagnosisPeriodizationName4 = disagnosisPeriodizationName4;
    }

    public String getDisagnosisPeriodizationName5() {
        return disagnosisPeriodizationName5;
    }

    public void setDisagnosisPeriodizationName5(String disagnosisPeriodizationName5) {
        this.disagnosisPeriodizationName5 = disagnosisPeriodizationName5;
    }

    public Date getSurgeryDate1() {
        return surgeryDate1;
    }

    public void setSurgeryDate1(Date surgeryDate1) {
        this.surgeryDate1 = surgeryDate1;
    }

    public Date getSurgeryDate2() {
        return surgeryDate2;
    }

    public void setSurgeryDate2(Date surgeryDate2) {
        this.surgeryDate2 = surgeryDate2;
    }

    public Date getSurgeryDate3() {
        return surgeryDate3;
    }

    public void setSurgeryDate3(Date surgeryDate3) {
        this.surgeryDate3 = surgeryDate3;
    }

    public Date getSurgeryDate4() {
        return surgeryDate4;
    }

    public void setSurgeryDate4(Date surgeryDate4) {
        this.surgeryDate4 = surgeryDate4;
    }

    public Date getSurgeryDate5() {
        return surgeryDate5;
    }

    public void setSurgeryDate5(Date surgeryDate5) {
        this.surgeryDate5 = surgeryDate5;
    }

    public Date getSurgeryDate6() {
        return surgeryDate6;
    }

    public void setSurgeryDate6(Date surgeryDate6) {
        this.surgeryDate6 = surgeryDate6;
    }

    public Date getSurgeryDate7() {
        return surgeryDate7;
    }

    public void setSurgeryDate7(Date surgeryDate7) {
        this.surgeryDate7 = surgeryDate7;
    }

    public Date getSurgeryDate8() {
        return surgeryDate8;
    }

    public void setSurgeryDate8(Date surgeryDate8) {
        this.surgeryDate8 = surgeryDate8;
    }

    public String getSurgeryName1() {
        return surgeryName1;
    }

    public void setSurgeryName1(String surgeryName1) {
        this.surgeryName1 = surgeryName1;
    }

    public String getSurgeryName2() {
        return surgeryName2;
    }

    public void setSurgeryName2(String surgeryName2) {
        this.surgeryName2 = surgeryName2;
    }

    public String getSurgeryName3() {
        return surgeryName3;
    }

    public void setSurgeryName3(String surgeryName3) {
        this.surgeryName3 = surgeryName3;
    }

    public String getSurgeryName4() {
        return surgeryName4;
    }

    public void setSurgeryName4(String surgeryName4) {
        this.surgeryName4 = surgeryName4;
    }

    public String getSurgeryName5() {
        return surgeryName5;
    }

    public void setSurgeryName5(String surgeryName5) {
        this.surgeryName5 = surgeryName5;
    }

    public String getSurgeryName6() {
        return surgeryName6;
    }

    public void setSurgeryName6(String surgeryName6) {
        this.surgeryName6 = surgeryName6;
    }

    public String getSurgeryName7() {
        return surgeryName7;
    }

    public void setSurgeryName7(String surgeryName7) {
        this.surgeryName7 = surgeryName7;
    }

    public String getSurgeryName8() {
        return surgeryName8;
    }

    public void setSurgeryName8(String surgeryName8) {
        this.surgeryName8 = surgeryName8;
    }

    public String getOpCode1() {
        return opCode1;
    }

    public void setOpCode1(String opCode1) {
        this.opCode1 = opCode1;
    }

    public String getOpCode2() {
        return opCode2;
    }

    public void setOpCode2(String opCode2) {
        this.opCode2 = opCode2;
    }

    public String getOpCode3() {
        return opCode3;
    }

    public void setOpCode3(String opCode3) {
        this.opCode3 = opCode3;
    }

    public String getOpCode4() {
        return opCode4;
    }

    public void setOpCode4(String opCode4) {
        this.opCode4 = opCode4;
    }

    public String getOpCode5() {
        return opCode5;
    }

    public void setOpCode5(String opCode5) {
        this.opCode5 = opCode5;
    }

    public String getOpCode6() {
        return opCode6;
    }

    public void setOpCode6(String opCode6) {
        this.opCode6 = opCode6;
    }

    public String getOpCode7() {
        return opCode7;
    }

    public void setOpCode7(String opCode7) {
        this.opCode7 = opCode7;
    }

    public String getOpCode8() {
        return opCode8;
    }

    public void setOpCode8(String opCode8) {
        this.opCode8 = opCode8;
    }

    public Long getSurgeryDoctor1() {
        return surgeryDoctor1;
    }

    public void setSurgeryDoctor1(Long surgeryDoctor1) {
        this.surgeryDoctor1 = surgeryDoctor1;
    }

    public Long getSurgeryDoctor2() {
        return surgeryDoctor2;
    }

    public void setSurgeryDoctor2(Long surgeryDoctor2) {
        this.surgeryDoctor2 = surgeryDoctor2;
    }

    public Long getSurgeryDoctor3() {
        return surgeryDoctor3;
    }

    public void setSurgeryDoctor3(Long surgeryDoctor3) {
        this.surgeryDoctor3 = surgeryDoctor3;
    }

    public Long getSurgeryDoctor4() {
        return surgeryDoctor4;
    }

    public void setSurgeryDoctor4(Long surgeryDoctor4) {
        this.surgeryDoctor4 = surgeryDoctor4;
    }

    public Long getSurgeryDoctor5() {
        return surgeryDoctor5;
    }

    public void setSurgeryDoctor5(Long surgeryDoctor5) {
        this.surgeryDoctor5 = surgeryDoctor5;
    }

    public Long getSurgeryDoctor6() {
        return surgeryDoctor6;
    }

    public void setSurgeryDoctor6(Long surgeryDoctor6) {
        this.surgeryDoctor6 = surgeryDoctor6;
    }

    public Long getSurgeryDoctor7() {
        return surgeryDoctor7;
    }

    public void setSurgeryDoctor7(Long surgeryDoctor7) {
        this.surgeryDoctor7 = surgeryDoctor7;
    }

    public Long getSurgeryDoctor8() {
        return surgeryDoctor8;
    }

    public void setSurgeryDoctor8(Long surgeryDoctor8) {
        this.surgeryDoctor8 = surgeryDoctor8;
    }

    public String getSurgeryDoctorName1() {
        return surgeryDoctorName1;
    }

    public void setSurgeryDoctorName1(String surgeryDoctorName1) {
        this.surgeryDoctorName1 = surgeryDoctorName1;
    }

    public String getSurgeryDoctorName2() {
        return surgeryDoctorName2;
    }

    public void setSurgeryDoctorName2(String surgeryDoctorName2) {
        this.surgeryDoctorName2 = surgeryDoctorName2;
    }

    public String getSurgeryDoctorName3() {
        return surgeryDoctorName3;
    }

    public void setSurgeryDoctorName3(String surgeryDoctorName3) {
        this.surgeryDoctorName3 = surgeryDoctorName3;
    }

    public String getSurgeryDoctorName4() {
        return surgeryDoctorName4;
    }

    public void setSurgeryDoctorName4(String surgeryDoctorName4) {
        this.surgeryDoctorName4 = surgeryDoctorName4;
    }

    public String getSurgeryDoctorName5() {
        return surgeryDoctorName5;
    }

    public void setSurgeryDoctorName5(String surgeryDoctorName5) {
        this.surgeryDoctorName5 = surgeryDoctorName5;
    }

    public String getSurgeryDoctorName6() {
        return surgeryDoctorName6;
    }

    public void setSurgeryDoctorName6(String surgeryDoctorName6) {
        this.surgeryDoctorName6 = surgeryDoctorName6;
    }

    public String getSurgeryDoctorName7() {
        return surgeryDoctorName7;
    }

    public void setSurgeryDoctorName7(String surgeryDoctorName7) {
        this.surgeryDoctorName7 = surgeryDoctorName7;
    }

    public String getSurgeryDoctorName8() {
        return surgeryDoctorName8;
    }

    public void setSurgeryDoctorName8(String surgeryDoctorName8) {
        this.surgeryDoctorName8 = surgeryDoctorName8;
    }

    public Date getFamilyCreateTime1() {
        return familyCreateTime1;
    }

    public void setFamilyCreateTime1(Date familyCreateTime1) {
        this.familyCreateTime1 = familyCreateTime1;
    }

    public Date getFamilyCreateTime2() {
        return familyCreateTime2;
    }

    public void setFamilyCreateTime2(Date familyCreateTime2) {
        this.familyCreateTime2 = familyCreateTime2;
    }

    public Date getDiagnosisCreateTime1() {
        return diagnosisCreateTime1;
    }

    public void setDiagnosisCreateTime1(Date diagnosisCreateTime1) {
        this.diagnosisCreateTime1 = diagnosisCreateTime1;
    }

    public Date getDiagnosisCreateTime2() {
        return diagnosisCreateTime2;
    }

    public void setDiagnosisCreateTime2(Date diagnosisCreateTime2) {
        this.diagnosisCreateTime2 = diagnosisCreateTime2;
    }

    public Date getDiagnosisCreateTime3() {
        return diagnosisCreateTime3;
    }

    public void setDiagnosisCreateTime3(Date diagnosisCreateTime3) {
        this.diagnosisCreateTime3 = diagnosisCreateTime3;
    }

    public Date getDiagnosisCreateTime4() {
        return diagnosisCreateTime4;
    }

    public void setDiagnosisCreateTime4(Date diagnosisCreateTime4) {
        this.diagnosisCreateTime4 = diagnosisCreateTime4;
    }

    public Date getDiagnosisCreateTime5() {
        return diagnosisCreateTime5;
    }

    public void setDiagnosisCreateTime5(Date diagnosisCreateTime5) {
        this.diagnosisCreateTime5 = diagnosisCreateTime5;
    }

    public Integer getDiagnosisType1() {
        return diagnosisType1;
    }

    public void setDiagnosisType1(Integer diagnosisType1) {
        this.diagnosisType1 = diagnosisType1;
    }

    public Integer getDiagnosisType2() {
        return diagnosisType2;
    }

    public void setDiagnosisType2(Integer diagnosisType2) {
        this.diagnosisType2 = diagnosisType2;
    }

    public Integer getDiagnosisType3() {
        return diagnosisType3;
    }

    public void setDiagnosisType3(Integer diagnosisType3) {
        this.diagnosisType3 = diagnosisType3;
    }

    public Integer getDiagnosisType4() {
        return diagnosisType4;
    }

    public void setDiagnosisType4(Integer diagnosisType4) {
        this.diagnosisType4 = diagnosisType4;
    }

    public Integer getDiagnosisType5() {
        return diagnosisType5;
    }

    public void setDiagnosisType5(Integer diagnosisType5) {
        this.diagnosisType5 = diagnosisType5;
    }

    public String getDiagnosisId1() {
        return diagnosisId1;
    }

    public void setDiagnosisId1(String diagnosisId1) {
        this.diagnosisId1 = diagnosisId1;
    }

    public String getDiagnosisId2() {
        return diagnosisId2;
    }

    public void setDiagnosisId2(String diagnosisId2) {
        this.diagnosisId2 = diagnosisId2;
    }

    public String getDiagnosisId3() {
        return diagnosisId3;
    }

    public void setDiagnosisId3(String diagnosisId3) {
        this.diagnosisId3 = diagnosisId3;
    }

    public String getDiagnosisId4() {
        return diagnosisId4;
    }

    public void setDiagnosisId4(String diagnosisId4) {
        this.diagnosisId4 = diagnosisId4;
    }

    public String getDiagnosisId5() {
        return diagnosisId5;
    }

    public void setDiagnosisId5(String diagnosisId5) {
        this.diagnosisId5 = diagnosisId5;
    }

    public Date getSurgeryCreateTime1() {
        return surgeryCreateTime1;
    }

    public void setSurgeryCreateTime1(Date surgeryCreateTime1) {
        this.surgeryCreateTime1 = surgeryCreateTime1;
    }

    public Date getSurgeryCreateTime2() {
        return surgeryCreateTime2;
    }

    public void setSurgeryCreateTime2(Date surgeryCreateTime2) {
        this.surgeryCreateTime2 = surgeryCreateTime2;
    }

    public Date getSurgeryCreateTime3() {
        return surgeryCreateTime3;
    }

    public void setSurgeryCreateTime3(Date surgeryCreateTime3) {
        this.surgeryCreateTime3 = surgeryCreateTime3;
    }

    public Date getSurgeryCreateTime4() {
        return surgeryCreateTime4;
    }

    public void setSurgeryCreateTime4(Date surgeryCreateTime4) {
        this.surgeryCreateTime4 = surgeryCreateTime4;
    }

    public Date getSurgeryCreateTime5() {
        return surgeryCreateTime5;
    }

    public void setSurgeryCreateTime5(Date surgeryCreateTime5) {
        this.surgeryCreateTime5 = surgeryCreateTime5;
    }

    public Date getSurgeryCreateTime6() {
        return surgeryCreateTime6;
    }

    public void setSurgeryCreateTime6(Date surgeryCreateTime6) {
        this.surgeryCreateTime6 = surgeryCreateTime6;
    }

    public Date getSurgeryCreateTime7() {
        return surgeryCreateTime7;
    }

    public void setSurgeryCreateTime7(Date surgeryCreateTime7) {
        this.surgeryCreateTime7 = surgeryCreateTime7;
    }

    public Date getSurgeryCreateTime8() {
        return surgeryCreateTime8;
    }

    public void setSurgeryCreateTime8(Date surgeryCreateTime8) {
        this.surgeryCreateTime8 = surgeryCreateTime8;
    }

    public String getTreatmentNames() {
        return treatmentNames;
    }

    public void setTreatmentNames(String treatmentNames) {
        this.treatmentNames = treatmentNames;
    }

    public String getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public Integer getFirstOuthospitalDeptId() {
        return firstOuthospitalDeptId;
    }

    public void setFirstOuthospitalDeptId(Integer firstOuthospitalDeptId) {
        this.firstOuthospitalDeptId = firstOuthospitalDeptId;
    }

    public String getFirstOuthospitalDeptName() {
        return firstOuthospitalDeptName;
    }

    public void setFirstOuthospitalDeptName(String firstOuthospitalDeptName) {
        this.firstOuthospitalDeptName = firstOuthospitalDeptName;
    }

    public Integer getLatestOuthospitalDeptId() {
        return latestOuthospitalDeptId;
    }

    public void setLatestOuthospitalDeptId(Integer latestOuthospitalDeptId) {
        this.latestOuthospitalDeptId = latestOuthospitalDeptId;
    }

    public String getLatestOuthospitalDeptName() {
        return latestOuthospitalDeptName;
    }

    public void setLatestOuthospitalDeptName(String latestOuthospitalDeptName) {
        this.latestOuthospitalDeptName = latestOuthospitalDeptName;
    }

    public Date getLatestClinicDate() {
        return latestClinicDate;
    }

    public void setLatestClinicDate(Date latestClinicDate) {
        this.latestClinicDate = latestClinicDate;
    }

    public Date getLatestInhospitalDate() {
        return latestInhospitalDate;
    }

    public void setLatestInhospitalDate(Date latestInhospitalDate) {
        this.latestInhospitalDate = latestInhospitalDate;
    }

    public Date getLatestOuthospitalDate() {
        return latestOuthospitalDate;
    }

    public void setLatestOuthospitalDate(Date latestOuthospitalDate) {
        this.latestOuthospitalDate = latestOuthospitalDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}