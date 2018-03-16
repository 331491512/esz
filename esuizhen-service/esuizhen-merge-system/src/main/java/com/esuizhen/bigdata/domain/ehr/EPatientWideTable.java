package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_patient_wide_table", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_patient_wide_table_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EPatientWideTable {
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
    private Timestamp familyCreateTime3;
    private Integer sourceInhospitalWay;
    private String sourceInhospitalWayName;
    private Timestamp sourceInhospitalDate;
    private Timestamp sourceOuthospitalDate;
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
    private String tumourPeriodizationTnm;
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
    private Timestamp surgeryDate1;
    private Timestamp surgeryDate2;
    private Timestamp surgeryDate3;
    private Timestamp surgeryDate4;
    private Timestamp surgeryDate5;
    private Timestamp surgeryDate6;
    private Timestamp surgeryDate7;
    private Timestamp surgeryDate8;
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
    private Timestamp familyCreateTime1;
    private Timestamp familyCreateTime2;
    private Timestamp diagnosisCreateTime1;
    private Timestamp diagnosisCreateTime2;
    private Timestamp diagnosisCreateTime3;
    private Timestamp diagnosisCreateTime4;
    private Timestamp diagnosisCreateTime5;
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
    private Timestamp surgeryCreateTime1;
    private Timestamp surgeryCreateTime2;
    private Timestamp surgeryCreateTime3;
    private Timestamp surgeryCreateTime4;
    private Timestamp surgeryCreateTime5;
    private Timestamp surgeryCreateTime6;
    private Timestamp surgeryCreateTime7;
    private Timestamp surgeryCreateTime8;
    private String treatmentNames;
    private String treatmentHistory;
    private Integer firstOuthospitalDeptId;
    private String firstOuthospitalDeptName;
    private Integer latestOuthospitalDeptId;
    private String latestOuthospitalDeptName;
    private Timestamp latestClinicDate;
    private Timestamp latestInhospitalDate;
    private Timestamp latestOuthospitalDate;
    private Timestamp createTime;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patientId", nullable = false)
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "sourceDiagnosisId", nullable = true, length = 128)
    public String getSourceDiagnosisId() {
        return sourceDiagnosisId;
    }

    public void setSourceDiagnosisId(String sourceDiagnosisId) {
        this.sourceDiagnosisId = sourceDiagnosisId;
    }

    @Basic
    @Column(name = "sourceDiagnosisId2", nullable = true, length = 128)
    public String getSourceDiagnosisId2() {
        return sourceDiagnosisId2;
    }

    public void setSourceDiagnosisId2(String sourceDiagnosisId2) {
        this.sourceDiagnosisId2 = sourceDiagnosisId2;
    }

    @Basic
    @Column(name = "inhospitalId", nullable = true, length = 128)
    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    @Basic
    @Column(name = "inhospitalId2", nullable = true, length = 128)
    public String getInhospitalId2() {
        return inhospitalId2;
    }

    public void setInhospitalId2(String inhospitalId2) {
        this.inhospitalId2 = inhospitalId2;
    }

    @Basic
    @Column(name = "familyName1", nullable = true, length = 50)
    public String getFamilyName1() {
        return familyName1;
    }

    public void setFamilyName1(String familyName1) {
        this.familyName1 = familyName1;
    }

    @Basic
    @Column(name = "patientRelationId1", nullable = true)
    public Integer getPatientRelationId1() {
        return patientRelationId1;
    }

    public void setPatientRelationId1(Integer patientRelationId1) {
        this.patientRelationId1 = patientRelationId1;
    }

    @Basic
    @Column(name = "patientRelation1", nullable = true, length = 50)
    public String getPatientRelation1() {
        return patientRelation1;
    }

    public void setPatientRelation1(String patientRelation1) {
        this.patientRelation1 = patientRelation1;
    }

    @Basic
    @Column(name = "familyPhone1", nullable = true, length = 128)
    public String getFamilyPhone1() {
        return familyPhone1;
    }

    public void setFamilyPhone1(String familyPhone1) {
        this.familyPhone1 = familyPhone1;
    }

    @Basic
    @Column(name = "address1", nullable = true, length = 255)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "isValid1", nullable = true)
    public Integer getIsValid1() {
        return isValid1;
    }

    public void setIsValid1(Integer isValid1) {
        this.isValid1 = isValid1;
    }

    @Basic
    @Column(name = "familyName2", nullable = true, length = 50)
    public String getFamilyName2() {
        return familyName2;
    }

    public void setFamilyName2(String familyName2) {
        this.familyName2 = familyName2;
    }

    @Basic
    @Column(name = "patientRelationId2", nullable = true)
    public Integer getPatientRelationId2() {
        return patientRelationId2;
    }

    public void setPatientRelationId2(Integer patientRelationId2) {
        this.patientRelationId2 = patientRelationId2;
    }

    @Basic
    @Column(name = "patientRelation2", nullable = true, length = 50)
    public String getPatientRelation2() {
        return patientRelation2;
    }

    public void setPatientRelation2(String patientRelation2) {
        this.patientRelation2 = patientRelation2;
    }

    @Basic
    @Column(name = "familyPhone2", nullable = true, length = 128)
    public String getFamilyPhone2() {
        return familyPhone2;
    }

    public void setFamilyPhone2(String familyPhone2) {
        this.familyPhone2 = familyPhone2;
    }

    @Basic
    @Column(name = "address2", nullable = true, length = 255)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "isValid2", nullable = true)
    public Integer getIsValid2() {
        return isValid2;
    }

    public void setIsValid2(Integer isValid2) {
        this.isValid2 = isValid2;
    }

    @Basic
    @Column(name = "familyName3", nullable = true, length = 50)
    public String getFamilyName3() {
        return familyName3;
    }

    public void setFamilyName3(String familyName3) {
        this.familyName3 = familyName3;
    }

    @Basic
    @Column(name = "patientRelationId3", nullable = true)
    public Integer getPatientRelationId3() {
        return patientRelationId3;
    }

    public void setPatientRelationId3(Integer patientRelationId3) {
        this.patientRelationId3 = patientRelationId3;
    }

    @Basic
    @Column(name = "patientRelation3", nullable = true, length = 50)
    public String getPatientRelation3() {
        return patientRelation3;
    }

    public void setPatientRelation3(String patientRelation3) {
        this.patientRelation3 = patientRelation3;
    }

    @Basic
    @Column(name = "familyPhone3", nullable = true, length = 128)
    public String getFamilyPhone3() {
        return familyPhone3;
    }

    public void setFamilyPhone3(String familyPhone3) {
        this.familyPhone3 = familyPhone3;
    }

    @Basic
    @Column(name = "address3", nullable = true, length = 255)
    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @Basic
    @Column(name = "isValid3", nullable = true)
    public Integer getIsValid3() {
        return isValid3;
    }

    public void setIsValid3(Integer isValid3) {
        this.isValid3 = isValid3;
    }

    @Basic
    @Column(name = "familyCreateTime3", nullable = true)
    public Timestamp getFamilyCreateTime3() {
        return familyCreateTime3;
    }

    public void setFamilyCreateTime3(Timestamp familyCreateTime3) {
        this.familyCreateTime3 = familyCreateTime3;
    }

    @Basic
    @Column(name = "sourceInhospitalWay", nullable = true)
    public Integer getSourceInhospitalWay() {
        return sourceInhospitalWay;
    }

    public void setSourceInhospitalWay(Integer sourceInhospitalWay) {
        this.sourceInhospitalWay = sourceInhospitalWay;
    }

    @Basic
    @Column(name = "sourceInhospitalWayName", nullable = true, length = 50)
    public String getSourceInhospitalWayName() {
        return sourceInhospitalWayName;
    }

    public void setSourceInhospitalWayName(String sourceInhospitalWayName) {
        this.sourceInhospitalWayName = sourceInhospitalWayName;
    }

    @Basic
    @Column(name = "sourceInhospitalDate", nullable = true)
    public Timestamp getSourceInhospitalDate() {
        return sourceInhospitalDate;
    }

    public void setSourceInhospitalDate(Timestamp sourceInhospitalDate) {
        this.sourceInhospitalDate = sourceInhospitalDate;
    }

    @Basic
    @Column(name = "sourceOuthospitalDate", nullable = true)
    public Timestamp getSourceOuthospitalDate() {
        return sourceOuthospitalDate;
    }

    public void setSourceOuthospitalDate(Timestamp sourceOuthospitalDate) {
        this.sourceOuthospitalDate = sourceOuthospitalDate;
    }

    @Basic
    @Column(name = "sourceInhospitalDeptId", nullable = true)
    public Integer getSourceInhospitalDeptId() {
        return sourceInhospitalDeptId;
    }

    public void setSourceInhospitalDeptId(Integer sourceInhospitalDeptId) {
        this.sourceInhospitalDeptId = sourceInhospitalDeptId;
    }

    @Basic
    @Column(name = "sourceInhospitalDeptName", nullable = true, length = 255)
    public String getSourceInhospitalDeptName() {
        return sourceInhospitalDeptName;
    }

    public void setSourceInhospitalDeptName(String sourceInhospitalDeptName) {
        this.sourceInhospitalDeptName = sourceInhospitalDeptName;
    }

    @Basic
    @Column(name = "sourceOuthospitalDeptId", nullable = true)
    public Integer getSourceOuthospitalDeptId() {
        return sourceOuthospitalDeptId;
    }

    public void setSourceOuthospitalDeptId(Integer sourceOuthospitalDeptId) {
        this.sourceOuthospitalDeptId = sourceOuthospitalDeptId;
    }

    @Basic
    @Column(name = "sourceOuthospitalDeptName", nullable = true, length = 255)
    public String getSourceOuthospitalDeptName() {
        return sourceOuthospitalDeptName;
    }

    public void setSourceOuthospitalDeptName(String sourceOuthospitalDeptName) {
        this.sourceOuthospitalDeptName = sourceOuthospitalDeptName;
    }

    @Basic
    @Column(name = "sourceTurnDeptId", nullable = true)
    public Integer getSourceTurnDeptId() {
        return sourceTurnDeptId;
    }

    public void setSourceTurnDeptId(Integer sourceTurnDeptId) {
        this.sourceTurnDeptId = sourceTurnDeptId;
    }

    @Basic
    @Column(name = "sourceTurnDeptName", nullable = true, length = 255)
    public String getSourceTurnDeptName() {
        return sourceTurnDeptName;
    }

    public void setSourceTurnDeptName(String sourceTurnDeptName) {
        this.sourceTurnDeptName = sourceTurnDeptName;
    }

    @Basic
    @Column(name = "sourceDeptDoctor", nullable = true)
    public Integer getSourceDeptDoctor() {
        return sourceDeptDoctor;
    }

    public void setSourceDeptDoctor(Integer sourceDeptDoctor) {
        this.sourceDeptDoctor = sourceDeptDoctor;
    }

    @Basic
    @Column(name = "sourceDeptDoctorName", nullable = true, length = 50)
    public String getSourceDeptDoctorName() {
        return sourceDeptDoctorName;
    }

    public void setSourceDeptDoctorName(String sourceDeptDoctorName) {
        this.sourceDeptDoctorName = sourceDeptDoctorName;
    }

    @Basic
    @Column(name = "sourceDirectorDoctor", nullable = true)
    public Integer getSourceDirectorDoctor() {
        return sourceDirectorDoctor;
    }

    public void setSourceDirectorDoctor(Integer sourceDirectorDoctor) {
        this.sourceDirectorDoctor = sourceDirectorDoctor;
    }

    @Basic
    @Column(name = "sourceDirectorDoctorName", nullable = true, length = 50)
    public String getSourceDirectorDoctorName() {
        return sourceDirectorDoctorName;
    }

    public void setSourceDirectorDoctorName(String sourceDirectorDoctorName) {
        this.sourceDirectorDoctorName = sourceDirectorDoctorName;
    }

    @Basic
    @Column(name = "sourceInchargeDoctor", nullable = true)
    public Integer getSourceInchargeDoctor() {
        return sourceInchargeDoctor;
    }

    public void setSourceInchargeDoctor(Integer sourceInchargeDoctor) {
        this.sourceInchargeDoctor = sourceInchargeDoctor;
    }

    @Basic
    @Column(name = "sourceInchargeDoctorName", nullable = true, length = 50)
    public String getSourceInchargeDoctorName() {
        return sourceInchargeDoctorName;
    }

    public void setSourceInchargeDoctorName(String sourceInchargeDoctorName) {
        this.sourceInchargeDoctorName = sourceInchargeDoctorName;
    }

    @Basic
    @Column(name = "sourceInhospitalDoctor", nullable = true)
    public Integer getSourceInhospitalDoctor() {
        return sourceInhospitalDoctor;
    }

    public void setSourceInhospitalDoctor(Integer sourceInhospitalDoctor) {
        this.sourceInhospitalDoctor = sourceInhospitalDoctor;
    }

    @Basic
    @Column(name = "sourceInhospitalDoctorName", nullable = true, length = 50)
    public String getSourceInhospitalDoctorName() {
        return sourceInhospitalDoctorName;
    }

    public void setSourceInhospitalDoctorName(String sourceInhospitalDoctorName) {
        this.sourceInhospitalDoctorName = sourceInhospitalDoctorName;
    }

    @Basic
    @Column(name = "sourceAttendingDoctor", nullable = true)
    public Integer getSourceAttendingDoctor() {
        return sourceAttendingDoctor;
    }

    public void setSourceAttendingDoctor(Integer sourceAttendingDoctor) {
        this.sourceAttendingDoctor = sourceAttendingDoctor;
    }

    @Basic
    @Column(name = "sourceAttendingDoctorName", nullable = true, length = 50)
    public String getSourceAttendingDoctorName() {
        return sourceAttendingDoctorName;
    }

    public void setSourceAttendingDoctorName(String sourceAttendingDoctorName) {
        this.sourceAttendingDoctorName = sourceAttendingDoctorName;
    }

    @Basic
    @Column(name = "sourceCancerNum", nullable = true)
    public Integer getSourceCancerNum() {
        return sourceCancerNum;
    }

    public void setSourceCancerNum(Integer sourceCancerNum) {
        this.sourceCancerNum = sourceCancerNum;
    }

    @Basic
    @Column(name = "confirmedDate", nullable = true)
    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    @Basic
    @Column(name = "confirmedAge", nullable = true)
    public Integer getConfirmedAge() {
        return confirmedAge;
    }

    public void setConfirmedAge(Integer confirmedAge) {
        this.confirmedAge = confirmedAge;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeId", nullable = true)
    public Integer getSourceDiseaseTypeId() {
        return sourceDiseaseTypeId;
    }

    public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
        this.sourceDiseaseTypeId = sourceDiseaseTypeId;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeName", nullable = true, length = 100)
    public String getSourceDiseaseTypeName() {
        return sourceDiseaseTypeName;
    }

    public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
        this.sourceDiseaseTypeName = sourceDiseaseTypeName;
    }

    @Basic
    @Column(name = "sourceDiagnosis", nullable = true, length = 255)
    public String getSourceDiagnosis() {
        return sourceDiagnosis;
    }

    public void setSourceDiagnosis(String sourceDiagnosis) {
        this.sourceDiagnosis = sourceDiagnosis;
    }

    @Basic
    @Column(name = "sourceDiseaseCode", nullable = true, length = 100)
    public String getSourceDiseaseCode() {
        return sourceDiseaseCode;
    }

    public void setSourceDiseaseCode(String sourceDiseaseCode) {
        this.sourceDiseaseCode = sourceDiseaseCode;
    }

    @Basic
    @Column(name = "secondaryDiagnosis", nullable = true, length = 255)
    public String getSecondaryDiagnosis() {
        return secondaryDiagnosis;
    }

    public void setSecondaryDiagnosis(String secondaryDiagnosis) {
        this.secondaryDiagnosis = secondaryDiagnosis;
    }

    @Basic
    @Column(name = "secondaryDiseaseCode", nullable = true, length = 100)
    public String getSecondaryDiseaseCode() {
        return secondaryDiseaseCode;
    }

    public void setSecondaryDiseaseCode(String secondaryDiseaseCode) {
        this.secondaryDiseaseCode = secondaryDiseaseCode;
    }

    @Basic
    @Column(name = "secondaryPathologyDiagnosis", nullable = true, length = 255)
    public String getSecondaryPathologyDiagnosis() {
        return secondaryPathologyDiagnosis;
    }

    public void setSecondaryPathologyDiagnosis(String secondaryPathologyDiagnosis) {
        this.secondaryPathologyDiagnosis = secondaryPathologyDiagnosis;
    }

    @Basic
    @Column(name = "secondaryPathologyDiseaseCode", nullable = true, length = 100)
    public String getSecondaryPathologyDiseaseCode() {
        return secondaryPathologyDiseaseCode;
    }

    public void setSecondaryPathologyDiseaseCode(String secondaryPathologyDiseaseCode) {
        this.secondaryPathologyDiseaseCode = secondaryPathologyDiseaseCode;
    }

    @Basic
    @Column(name = "sourceDiagnosis2", nullable = true, length = 255)
    public String getSourceDiagnosis2() {
        return sourceDiagnosis2;
    }

    public void setSourceDiagnosis2(String sourceDiagnosis2) {
        this.sourceDiagnosis2 = sourceDiagnosis2;
    }

    @Basic
    @Column(name = "sourceDiseaseCode2", nullable = true, length = 100)
    public String getSourceDiseaseCode2() {
        return sourceDiseaseCode2;
    }

    public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
        this.sourceDiseaseCode2 = sourceDiseaseCode2;
    }

    @Basic
    @Column(name = "sourcePathologyDiagnosis2", nullable = true, length = 255)
    public String getSourcePathologyDiagnosis2() {
        return sourcePathologyDiagnosis2;
    }

    public void setSourcePathologyDiagnosis2(String sourcePathologyDiagnosis2) {
        this.sourcePathologyDiagnosis2 = sourcePathologyDiagnosis2;
    }

    @Basic
    @Column(name = "sourcePathologyDiseaseCode2", nullable = true, length = 100)
    public String getSourcePathologyDiseaseCode2() {
        return sourcePathologyDiseaseCode2;
    }

    public void setSourcePathologyDiseaseCode2(String sourcePathologyDiseaseCode2) {
        this.sourcePathologyDiseaseCode2 = sourcePathologyDiseaseCode2;
    }

    @Basic
    @Column(name = "tumourPeriodizationClinic", nullable = true, length = 32)
    public String getTumourPeriodizationClinic() {
        return tumourPeriodizationClinic;
    }

    public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
        this.tumourPeriodizationClinic = tumourPeriodizationClinic;
    }

    @Basic
    @Column(name = "tumourPeriodizationTNM", nullable = true, length = 128)
    public String getTumourPeriodizationTnm() {
        return tumourPeriodizationTnm;
    }

    public void setTumourPeriodizationTnm(String tumourPeriodizationTnm) {
        this.tumourPeriodizationTnm = tumourPeriodizationTnm;
    }

    @Basic
    @Column(name = "diagnosis1", nullable = true, length = 512)
    public String getDiagnosis1() {
        return diagnosis1;
    }

    public void setDiagnosis1(String diagnosis1) {
        this.diagnosis1 = diagnosis1;
    }

    @Basic
    @Column(name = "diagnosis2", nullable = true, length = 512)
    public String getDiagnosis2() {
        return diagnosis2;
    }

    public void setDiagnosis2(String diagnosis2) {
        this.diagnosis2 = diagnosis2;
    }

    @Basic
    @Column(name = "diagnosis3", nullable = true, length = 512)
    public String getDiagnosis3() {
        return diagnosis3;
    }

    public void setDiagnosis3(String diagnosis3) {
        this.diagnosis3 = diagnosis3;
    }

    @Basic
    @Column(name = "diagnosis4", nullable = true, length = 512)
    public String getDiagnosis4() {
        return diagnosis4;
    }

    public void setDiagnosis4(String diagnosis4) {
        this.diagnosis4 = diagnosis4;
    }

    @Basic
    @Column(name = "diagnosis5", nullable = true, length = 512)
    public String getDiagnosis5() {
        return diagnosis5;
    }

    public void setDiagnosis5(String diagnosis5) {
        this.diagnosis5 = diagnosis5;
    }

    @Basic
    @Column(name = "diseaseCode1", nullable = true, length = 20)
    public String getDiseaseCode1() {
        return diseaseCode1;
    }

    public void setDiseaseCode1(String diseaseCode1) {
        this.diseaseCode1 = diseaseCode1;
    }

    @Basic
    @Column(name = "diseaseCode2", nullable = true, length = 20)
    public String getDiseaseCode2() {
        return diseaseCode2;
    }

    public void setDiseaseCode2(String diseaseCode2) {
        this.diseaseCode2 = diseaseCode2;
    }

    @Basic
    @Column(name = "diseaseCode3", nullable = true, length = 20)
    public String getDiseaseCode3() {
        return diseaseCode3;
    }

    public void setDiseaseCode3(String diseaseCode3) {
        this.diseaseCode3 = diseaseCode3;
    }

    @Basic
    @Column(name = "diseaseCode4", nullable = true, length = 20)
    public String getDiseaseCode4() {
        return diseaseCode4;
    }

    public void setDiseaseCode4(String diseaseCode4) {
        this.diseaseCode4 = diseaseCode4;
    }

    @Basic
    @Column(name = "diseaseCode5", nullable = true, length = 20)
    public String getDiseaseCode5() {
        return diseaseCode5;
    }

    public void setDiseaseCode5(String diseaseCode5) {
        this.diseaseCode5 = diseaseCode5;
    }

    @Basic
    @Column(name = "pathologyDiagnosis1", nullable = true, length = 512)
    public String getPathologyDiagnosis1() {
        return pathologyDiagnosis1;
    }

    public void setPathologyDiagnosis1(String pathologyDiagnosis1) {
        this.pathologyDiagnosis1 = pathologyDiagnosis1;
    }

    @Basic
    @Column(name = "pathologyDiagnosis2", nullable = true, length = 512)
    public String getPathologyDiagnosis2() {
        return pathologyDiagnosis2;
    }

    public void setPathologyDiagnosis2(String pathologyDiagnosis2) {
        this.pathologyDiagnosis2 = pathologyDiagnosis2;
    }

    @Basic
    @Column(name = "pathologyDiagnosis3", nullable = true, length = 512)
    public String getPathologyDiagnosis3() {
        return pathologyDiagnosis3;
    }

    public void setPathologyDiagnosis3(String pathologyDiagnosis3) {
        this.pathologyDiagnosis3 = pathologyDiagnosis3;
    }

    @Basic
    @Column(name = "pathologyDiagnosis4", nullable = true, length = 512)
    public String getPathologyDiagnosis4() {
        return pathologyDiagnosis4;
    }

    public void setPathologyDiagnosis4(String pathologyDiagnosis4) {
        this.pathologyDiagnosis4 = pathologyDiagnosis4;
    }

    @Basic
    @Column(name = "pathologyDiagnosis5", nullable = true, length = 512)
    public String getPathologyDiagnosis5() {
        return pathologyDiagnosis5;
    }

    public void setPathologyDiagnosis5(String pathologyDiagnosis5) {
        this.pathologyDiagnosis5 = pathologyDiagnosis5;
    }

    @Basic
    @Column(name = "pathologyDiagnosisCode1", nullable = true, length = 20)
    public String getPathologyDiagnosisCode1() {
        return pathologyDiagnosisCode1;
    }

    public void setPathologyDiagnosisCode1(String pathologyDiagnosisCode1) {
        this.pathologyDiagnosisCode1 = pathologyDiagnosisCode1;
    }

    @Basic
    @Column(name = "pathologyDiagnosisCode2", nullable = true, length = 20)
    public String getPathologyDiagnosisCode2() {
        return pathologyDiagnosisCode2;
    }

    public void setPathologyDiagnosisCode2(String pathologyDiagnosisCode2) {
        this.pathologyDiagnosisCode2 = pathologyDiagnosisCode2;
    }

    @Basic
    @Column(name = "pathologyDiagnosisCode3", nullable = true, length = 20)
    public String getPathologyDiagnosisCode3() {
        return pathologyDiagnosisCode3;
    }

    public void setPathologyDiagnosisCode3(String pathologyDiagnosisCode3) {
        this.pathologyDiagnosisCode3 = pathologyDiagnosisCode3;
    }

    @Basic
    @Column(name = "pathologyDiagnosisCode4", nullable = true, length = 20)
    public String getPathologyDiagnosisCode4() {
        return pathologyDiagnosisCode4;
    }

    public void setPathologyDiagnosisCode4(String pathologyDiagnosisCode4) {
        this.pathologyDiagnosisCode4 = pathologyDiagnosisCode4;
    }

    @Basic
    @Column(name = "pathologyDiagnosisCode5", nullable = true, length = 20)
    public String getPathologyDiagnosisCode5() {
        return pathologyDiagnosisCode5;
    }

    public void setPathologyDiagnosisCode5(String pathologyDiagnosisCode5) {
        this.pathologyDiagnosisCode5 = pathologyDiagnosisCode5;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationId1", nullable = true)
    public Integer getDisagnosisPeriodizationId1() {
        return disagnosisPeriodizationId1;
    }

    public void setDisagnosisPeriodizationId1(Integer disagnosisPeriodizationId1) {
        this.disagnosisPeriodizationId1 = disagnosisPeriodizationId1;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationId2", nullable = true)
    public Integer getDisagnosisPeriodizationId2() {
        return disagnosisPeriodizationId2;
    }

    public void setDisagnosisPeriodizationId2(Integer disagnosisPeriodizationId2) {
        this.disagnosisPeriodizationId2 = disagnosisPeriodizationId2;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationId3", nullable = true)
    public Integer getDisagnosisPeriodizationId3() {
        return disagnosisPeriodizationId3;
    }

    public void setDisagnosisPeriodizationId3(Integer disagnosisPeriodizationId3) {
        this.disagnosisPeriodizationId3 = disagnosisPeriodizationId3;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationId4", nullable = true)
    public Integer getDisagnosisPeriodizationId4() {
        return disagnosisPeriodizationId4;
    }

    public void setDisagnosisPeriodizationId4(Integer disagnosisPeriodizationId4) {
        this.disagnosisPeriodizationId4 = disagnosisPeriodizationId4;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationId5", nullable = true)
    public Integer getDisagnosisPeriodizationId5() {
        return disagnosisPeriodizationId5;
    }

    public void setDisagnosisPeriodizationId5(Integer disagnosisPeriodizationId5) {
        this.disagnosisPeriodizationId5 = disagnosisPeriodizationId5;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationName1", nullable = true, length = 100)
    public String getDisagnosisPeriodizationName1() {
        return disagnosisPeriodizationName1;
    }

    public void setDisagnosisPeriodizationName1(String disagnosisPeriodizationName1) {
        this.disagnosisPeriodizationName1 = disagnosisPeriodizationName1;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationName2", nullable = true, length = 100)
    public String getDisagnosisPeriodizationName2() {
        return disagnosisPeriodizationName2;
    }

    public void setDisagnosisPeriodizationName2(String disagnosisPeriodizationName2) {
        this.disagnosisPeriodizationName2 = disagnosisPeriodizationName2;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationName3", nullable = true, length = 100)
    public String getDisagnosisPeriodizationName3() {
        return disagnosisPeriodizationName3;
    }

    public void setDisagnosisPeriodizationName3(String disagnosisPeriodizationName3) {
        this.disagnosisPeriodizationName3 = disagnosisPeriodizationName3;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationName4", nullable = true, length = 100)
    public String getDisagnosisPeriodizationName4() {
        return disagnosisPeriodizationName4;
    }

    public void setDisagnosisPeriodizationName4(String disagnosisPeriodizationName4) {
        this.disagnosisPeriodizationName4 = disagnosisPeriodizationName4;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationName5", nullable = true, length = 100)
    public String getDisagnosisPeriodizationName5() {
        return disagnosisPeriodizationName5;
    }

    public void setDisagnosisPeriodizationName5(String disagnosisPeriodizationName5) {
        this.disagnosisPeriodizationName5 = disagnosisPeriodizationName5;
    }

    @Basic
    @Column(name = "surgeryDate1", nullable = true)
    public Timestamp getSurgeryDate1() {
        return surgeryDate1;
    }

    public void setSurgeryDate1(Timestamp surgeryDate1) {
        this.surgeryDate1 = surgeryDate1;
    }

    @Basic
    @Column(name = "surgeryDate2", nullable = true)
    public Timestamp getSurgeryDate2() {
        return surgeryDate2;
    }

    public void setSurgeryDate2(Timestamp surgeryDate2) {
        this.surgeryDate2 = surgeryDate2;
    }

    @Basic
    @Column(name = "surgeryDate3", nullable = true)
    public Timestamp getSurgeryDate3() {
        return surgeryDate3;
    }

    public void setSurgeryDate3(Timestamp surgeryDate3) {
        this.surgeryDate3 = surgeryDate3;
    }

    @Basic
    @Column(name = "surgeryDate4", nullable = true)
    public Timestamp getSurgeryDate4() {
        return surgeryDate4;
    }

    public void setSurgeryDate4(Timestamp surgeryDate4) {
        this.surgeryDate4 = surgeryDate4;
    }

    @Basic
    @Column(name = "surgeryDate5", nullable = true)
    public Timestamp getSurgeryDate5() {
        return surgeryDate5;
    }

    public void setSurgeryDate5(Timestamp surgeryDate5) {
        this.surgeryDate5 = surgeryDate5;
    }

    @Basic
    @Column(name = "surgeryDate6", nullable = true)
    public Timestamp getSurgeryDate6() {
        return surgeryDate6;
    }

    public void setSurgeryDate6(Timestamp surgeryDate6) {
        this.surgeryDate6 = surgeryDate6;
    }

    @Basic
    @Column(name = "surgeryDate7", nullable = true)
    public Timestamp getSurgeryDate7() {
        return surgeryDate7;
    }

    public void setSurgeryDate7(Timestamp surgeryDate7) {
        this.surgeryDate7 = surgeryDate7;
    }

    @Basic
    @Column(name = "surgeryDate8", nullable = true)
    public Timestamp getSurgeryDate8() {
        return surgeryDate8;
    }

    public void setSurgeryDate8(Timestamp surgeryDate8) {
        this.surgeryDate8 = surgeryDate8;
    }

    @Basic
    @Column(name = "surgeryName1", nullable = true, length = 512)
    public String getSurgeryName1() {
        return surgeryName1;
    }

    public void setSurgeryName1(String surgeryName1) {
        this.surgeryName1 = surgeryName1;
    }

    @Basic
    @Column(name = "surgeryName2", nullable = true, length = 512)
    public String getSurgeryName2() {
        return surgeryName2;
    }

    public void setSurgeryName2(String surgeryName2) {
        this.surgeryName2 = surgeryName2;
    }

    @Basic
    @Column(name = "surgeryName3", nullable = true, length = 512)
    public String getSurgeryName3() {
        return surgeryName3;
    }

    public void setSurgeryName3(String surgeryName3) {
        this.surgeryName3 = surgeryName3;
    }

    @Basic
    @Column(name = "surgeryName4", nullable = true, length = 512)
    public String getSurgeryName4() {
        return surgeryName4;
    }

    public void setSurgeryName4(String surgeryName4) {
        this.surgeryName4 = surgeryName4;
    }

    @Basic
    @Column(name = "surgeryName5", nullable = true, length = 512)
    public String getSurgeryName5() {
        return surgeryName5;
    }

    public void setSurgeryName5(String surgeryName5) {
        this.surgeryName5 = surgeryName5;
    }

    @Basic
    @Column(name = "surgeryName6", nullable = true, length = 512)
    public String getSurgeryName6() {
        return surgeryName6;
    }

    public void setSurgeryName6(String surgeryName6) {
        this.surgeryName6 = surgeryName6;
    }

    @Basic
    @Column(name = "surgeryName7", nullable = true, length = 512)
    public String getSurgeryName7() {
        return surgeryName7;
    }

    public void setSurgeryName7(String surgeryName7) {
        this.surgeryName7 = surgeryName7;
    }

    @Basic
    @Column(name = "surgeryName8", nullable = true, length = 512)
    public String getSurgeryName8() {
        return surgeryName8;
    }

    public void setSurgeryName8(String surgeryName8) {
        this.surgeryName8 = surgeryName8;
    }

    @Basic
    @Column(name = "opCode1", nullable = true, length = 30)
    public String getOpCode1() {
        return opCode1;
    }

    public void setOpCode1(String opCode1) {
        this.opCode1 = opCode1;
    }

    @Basic
    @Column(name = "opCode2", nullable = true, length = 30)
    public String getOpCode2() {
        return opCode2;
    }

    public void setOpCode2(String opCode2) {
        this.opCode2 = opCode2;
    }

    @Basic
    @Column(name = "opCode3", nullable = true, length = 30)
    public String getOpCode3() {
        return opCode3;
    }

    public void setOpCode3(String opCode3) {
        this.opCode3 = opCode3;
    }

    @Basic
    @Column(name = "opCode4", nullable = true, length = 30)
    public String getOpCode4() {
        return opCode4;
    }

    public void setOpCode4(String opCode4) {
        this.opCode4 = opCode4;
    }

    @Basic
    @Column(name = "opCode5", nullable = true, length = 30)
    public String getOpCode5() {
        return opCode5;
    }

    public void setOpCode5(String opCode5) {
        this.opCode5 = opCode5;
    }

    @Basic
    @Column(name = "opCode6", nullable = true, length = 30)
    public String getOpCode6() {
        return opCode6;
    }

    public void setOpCode6(String opCode6) {
        this.opCode6 = opCode6;
    }

    @Basic
    @Column(name = "opCode7", nullable = true, length = 30)
    public String getOpCode7() {
        return opCode7;
    }

    public void setOpCode7(String opCode7) {
        this.opCode7 = opCode7;
    }

    @Basic
    @Column(name = "opCode8", nullable = true, length = 30)
    public String getOpCode8() {
        return opCode8;
    }

    public void setOpCode8(String opCode8) {
        this.opCode8 = opCode8;
    }

    @Basic
    @Column(name = "surgeryDoctor1", nullable = true)
    public Long getSurgeryDoctor1() {
        return surgeryDoctor1;
    }

    public void setSurgeryDoctor1(Long surgeryDoctor1) {
        this.surgeryDoctor1 = surgeryDoctor1;
    }

    @Basic
    @Column(name = "surgeryDoctor2", nullable = true)
    public Long getSurgeryDoctor2() {
        return surgeryDoctor2;
    }

    public void setSurgeryDoctor2(Long surgeryDoctor2) {
        this.surgeryDoctor2 = surgeryDoctor2;
    }

    @Basic
    @Column(name = "surgeryDoctor3", nullable = true)
    public Long getSurgeryDoctor3() {
        return surgeryDoctor3;
    }

    public void setSurgeryDoctor3(Long surgeryDoctor3) {
        this.surgeryDoctor3 = surgeryDoctor3;
    }

    @Basic
    @Column(name = "surgeryDoctor4", nullable = true)
    public Long getSurgeryDoctor4() {
        return surgeryDoctor4;
    }

    public void setSurgeryDoctor4(Long surgeryDoctor4) {
        this.surgeryDoctor4 = surgeryDoctor4;
    }

    @Basic
    @Column(name = "surgeryDoctor5", nullable = true)
    public Long getSurgeryDoctor5() {
        return surgeryDoctor5;
    }

    public void setSurgeryDoctor5(Long surgeryDoctor5) {
        this.surgeryDoctor5 = surgeryDoctor5;
    }

    @Basic
    @Column(name = "surgeryDoctor6", nullable = true)
    public Long getSurgeryDoctor6() {
        return surgeryDoctor6;
    }

    public void setSurgeryDoctor6(Long surgeryDoctor6) {
        this.surgeryDoctor6 = surgeryDoctor6;
    }

    @Basic
    @Column(name = "surgeryDoctor7", nullable = true)
    public Long getSurgeryDoctor7() {
        return surgeryDoctor7;
    }

    public void setSurgeryDoctor7(Long surgeryDoctor7) {
        this.surgeryDoctor7 = surgeryDoctor7;
    }

    @Basic
    @Column(name = "surgeryDoctor8", nullable = true)
    public Long getSurgeryDoctor8() {
        return surgeryDoctor8;
    }

    public void setSurgeryDoctor8(Long surgeryDoctor8) {
        this.surgeryDoctor8 = surgeryDoctor8;
    }

    @Basic
    @Column(name = "surgeryDoctorName1", nullable = true, length = 50)
    public String getSurgeryDoctorName1() {
        return surgeryDoctorName1;
    }

    public void setSurgeryDoctorName1(String surgeryDoctorName1) {
        this.surgeryDoctorName1 = surgeryDoctorName1;
    }

    @Basic
    @Column(name = "surgeryDoctorName2", nullable = true, length = 50)
    public String getSurgeryDoctorName2() {
        return surgeryDoctorName2;
    }

    public void setSurgeryDoctorName2(String surgeryDoctorName2) {
        this.surgeryDoctorName2 = surgeryDoctorName2;
    }

    @Basic
    @Column(name = "surgeryDoctorName3", nullable = true, length = 50)
    public String getSurgeryDoctorName3() {
        return surgeryDoctorName3;
    }

    public void setSurgeryDoctorName3(String surgeryDoctorName3) {
        this.surgeryDoctorName3 = surgeryDoctorName3;
    }

    @Basic
    @Column(name = "surgeryDoctorName4", nullable = true, length = 50)
    public String getSurgeryDoctorName4() {
        return surgeryDoctorName4;
    }

    public void setSurgeryDoctorName4(String surgeryDoctorName4) {
        this.surgeryDoctorName4 = surgeryDoctorName4;
    }

    @Basic
    @Column(name = "surgeryDoctorName5", nullable = true, length = 50)
    public String getSurgeryDoctorName5() {
        return surgeryDoctorName5;
    }

    public void setSurgeryDoctorName5(String surgeryDoctorName5) {
        this.surgeryDoctorName5 = surgeryDoctorName5;
    }

    @Basic
    @Column(name = "surgeryDoctorName6", nullable = true, length = 50)
    public String getSurgeryDoctorName6() {
        return surgeryDoctorName6;
    }

    public void setSurgeryDoctorName6(String surgeryDoctorName6) {
        this.surgeryDoctorName6 = surgeryDoctorName6;
    }

    @Basic
    @Column(name = "surgeryDoctorName7", nullable = true, length = 50)
    public String getSurgeryDoctorName7() {
        return surgeryDoctorName7;
    }

    public void setSurgeryDoctorName7(String surgeryDoctorName7) {
        this.surgeryDoctorName7 = surgeryDoctorName7;
    }

    @Basic
    @Column(name = "surgeryDoctorName8", nullable = true, length = 50)
    public String getSurgeryDoctorName8() {
        return surgeryDoctorName8;
    }

    public void setSurgeryDoctorName8(String surgeryDoctorName8) {
        this.surgeryDoctorName8 = surgeryDoctorName8;
    }

    @Basic
    @Column(name = "familyCreateTime1", nullable = true)
    public Timestamp getFamilyCreateTime1() {
        return familyCreateTime1;
    }

    public void setFamilyCreateTime1(Timestamp familyCreateTime1) {
        this.familyCreateTime1 = familyCreateTime1;
    }

    @Basic
    @Column(name = "familyCreateTime2", nullable = true)
    public Timestamp getFamilyCreateTime2() {
        return familyCreateTime2;
    }

    public void setFamilyCreateTime2(Timestamp familyCreateTime2) {
        this.familyCreateTime2 = familyCreateTime2;
    }

    @Basic
    @Column(name = "diagnosisCreateTime1", nullable = true)
    public Timestamp getDiagnosisCreateTime1() {
        return diagnosisCreateTime1;
    }

    public void setDiagnosisCreateTime1(Timestamp diagnosisCreateTime1) {
        this.diagnosisCreateTime1 = diagnosisCreateTime1;
    }

    @Basic
    @Column(name = "diagnosisCreateTime2", nullable = true)
    public Timestamp getDiagnosisCreateTime2() {
        return diagnosisCreateTime2;
    }

    public void setDiagnosisCreateTime2(Timestamp diagnosisCreateTime2) {
        this.diagnosisCreateTime2 = diagnosisCreateTime2;
    }

    @Basic
    @Column(name = "diagnosisCreateTime3", nullable = true)
    public Timestamp getDiagnosisCreateTime3() {
        return diagnosisCreateTime3;
    }

    public void setDiagnosisCreateTime3(Timestamp diagnosisCreateTime3) {
        this.diagnosisCreateTime3 = diagnosisCreateTime3;
    }

    @Basic
    @Column(name = "diagnosisCreateTime4", nullable = true)
    public Timestamp getDiagnosisCreateTime4() {
        return diagnosisCreateTime4;
    }

    public void setDiagnosisCreateTime4(Timestamp diagnosisCreateTime4) {
        this.diagnosisCreateTime4 = diagnosisCreateTime4;
    }

    @Basic
    @Column(name = "diagnosisCreateTime5", nullable = true)
    public Timestamp getDiagnosisCreateTime5() {
        return diagnosisCreateTime5;
    }

    public void setDiagnosisCreateTime5(Timestamp diagnosisCreateTime5) {
        this.diagnosisCreateTime5 = diagnosisCreateTime5;
    }

    @Basic
    @Column(name = "diagnosisType1", nullable = true)
    public Integer getDiagnosisType1() {
        return diagnosisType1;
    }

    public void setDiagnosisType1(Integer diagnosisType1) {
        this.diagnosisType1 = diagnosisType1;
    }

    @Basic
    @Column(name = "diagnosisType2", nullable = true)
    public Integer getDiagnosisType2() {
        return diagnosisType2;
    }

    public void setDiagnosisType2(Integer diagnosisType2) {
        this.diagnosisType2 = diagnosisType2;
    }

    @Basic
    @Column(name = "diagnosisType3", nullable = true)
    public Integer getDiagnosisType3() {
        return diagnosisType3;
    }

    public void setDiagnosisType3(Integer diagnosisType3) {
        this.diagnosisType3 = diagnosisType3;
    }

    @Basic
    @Column(name = "diagnosisType4", nullable = true)
    public Integer getDiagnosisType4() {
        return diagnosisType4;
    }

    public void setDiagnosisType4(Integer diagnosisType4) {
        this.diagnosisType4 = diagnosisType4;
    }

    @Basic
    @Column(name = "diagnosisType5", nullable = true)
    public Integer getDiagnosisType5() {
        return diagnosisType5;
    }

    public void setDiagnosisType5(Integer diagnosisType5) {
        this.diagnosisType5 = diagnosisType5;
    }

    @Basic
    @Column(name = "diagnosisId1", nullable = true, length = 128)
    public String getDiagnosisId1() {
        return diagnosisId1;
    }

    public void setDiagnosisId1(String diagnosisId1) {
        this.diagnosisId1 = diagnosisId1;
    }

    @Basic
    @Column(name = "diagnosisId2", nullable = true, length = 128)
    public String getDiagnosisId2() {
        return diagnosisId2;
    }

    public void setDiagnosisId2(String diagnosisId2) {
        this.diagnosisId2 = diagnosisId2;
    }

    @Basic
    @Column(name = "diagnosisId3", nullable = true, length = 128)
    public String getDiagnosisId3() {
        return diagnosisId3;
    }

    public void setDiagnosisId3(String diagnosisId3) {
        this.diagnosisId3 = diagnosisId3;
    }

    @Basic
    @Column(name = "diagnosisId4", nullable = true, length = 128)
    public String getDiagnosisId4() {
        return diagnosisId4;
    }

    public void setDiagnosisId4(String diagnosisId4) {
        this.diagnosisId4 = diagnosisId4;
    }

    @Basic
    @Column(name = "diagnosisId5", nullable = true, length = 128)
    public String getDiagnosisId5() {
        return diagnosisId5;
    }

    public void setDiagnosisId5(String diagnosisId5) {
        this.diagnosisId5 = diagnosisId5;
    }

    @Basic
    @Column(name = "surgeryCreateTime1", nullable = true)
    public Timestamp getSurgeryCreateTime1() {
        return surgeryCreateTime1;
    }

    public void setSurgeryCreateTime1(Timestamp surgeryCreateTime1) {
        this.surgeryCreateTime1 = surgeryCreateTime1;
    }

    @Basic
    @Column(name = "surgeryCreateTime2", nullable = true)
    public Timestamp getSurgeryCreateTime2() {
        return surgeryCreateTime2;
    }

    public void setSurgeryCreateTime2(Timestamp surgeryCreateTime2) {
        this.surgeryCreateTime2 = surgeryCreateTime2;
    }

    @Basic
    @Column(name = "surgeryCreateTime3", nullable = true)
    public Timestamp getSurgeryCreateTime3() {
        return surgeryCreateTime3;
    }

    public void setSurgeryCreateTime3(Timestamp surgeryCreateTime3) {
        this.surgeryCreateTime3 = surgeryCreateTime3;
    }

    @Basic
    @Column(name = "surgeryCreateTime4", nullable = true)
    public Timestamp getSurgeryCreateTime4() {
        return surgeryCreateTime4;
    }

    public void setSurgeryCreateTime4(Timestamp surgeryCreateTime4) {
        this.surgeryCreateTime4 = surgeryCreateTime4;
    }

    @Basic
    @Column(name = "surgeryCreateTime5", nullable = true)
    public Timestamp getSurgeryCreateTime5() {
        return surgeryCreateTime5;
    }

    public void setSurgeryCreateTime5(Timestamp surgeryCreateTime5) {
        this.surgeryCreateTime5 = surgeryCreateTime5;
    }

    @Basic
    @Column(name = "surgeryCreateTime6", nullable = true)
    public Timestamp getSurgeryCreateTime6() {
        return surgeryCreateTime6;
    }

    public void setSurgeryCreateTime6(Timestamp surgeryCreateTime6) {
        this.surgeryCreateTime6 = surgeryCreateTime6;
    }

    @Basic
    @Column(name = "surgeryCreateTime7", nullable = true)
    public Timestamp getSurgeryCreateTime7() {
        return surgeryCreateTime7;
    }

    public void setSurgeryCreateTime7(Timestamp surgeryCreateTime7) {
        this.surgeryCreateTime7 = surgeryCreateTime7;
    }

    @Basic
    @Column(name = "surgeryCreateTime8", nullable = true)
    public Timestamp getSurgeryCreateTime8() {
        return surgeryCreateTime8;
    }

    public void setSurgeryCreateTime8(Timestamp surgeryCreateTime8) {
        this.surgeryCreateTime8 = surgeryCreateTime8;
    }

    @Basic
    @Column(name = "treatmentNames", nullable = true, length = 255)
    public String getTreatmentNames() {
        return treatmentNames;
    }

    public void setTreatmentNames(String treatmentNames) {
        this.treatmentNames = treatmentNames;
    }

    @Basic
    @Column(name = "treatmentHistory", nullable = true, length = 255)
    public String getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    @Basic
    @Column(name = "firstOuthospitalDeptId", nullable = true)
    public Integer getFirstOuthospitalDeptId() {
        return firstOuthospitalDeptId;
    }

    public void setFirstOuthospitalDeptId(Integer firstOuthospitalDeptId) {
        this.firstOuthospitalDeptId = firstOuthospitalDeptId;
    }

    @Basic
    @Column(name = "firstOuthospitalDeptName", nullable = true, length = 100)
    public String getFirstOuthospitalDeptName() {
        return firstOuthospitalDeptName;
    }

    public void setFirstOuthospitalDeptName(String firstOuthospitalDeptName) {
        this.firstOuthospitalDeptName = firstOuthospitalDeptName;
    }

    @Basic
    @Column(name = "latestOuthospitalDeptId", nullable = true)
    public Integer getLatestOuthospitalDeptId() {
        return latestOuthospitalDeptId;
    }

    public void setLatestOuthospitalDeptId(Integer latestOuthospitalDeptId) {
        this.latestOuthospitalDeptId = latestOuthospitalDeptId;
    }

    @Basic
    @Column(name = "latestOuthospitalDeptName", nullable = true, length = 100)
    public String getLatestOuthospitalDeptName() {
        return latestOuthospitalDeptName;
    }

    public void setLatestOuthospitalDeptName(String latestOuthospitalDeptName) {
        this.latestOuthospitalDeptName = latestOuthospitalDeptName;
    }

    @Basic
    @Column(name = "latestClinicDate", nullable = true)
    public Timestamp getLatestClinicDate() {
        return latestClinicDate;
    }

    public void setLatestClinicDate(Timestamp latestClinicDate) {
        this.latestClinicDate = latestClinicDate;
    }

    @Basic
    @Column(name = "latestInhospitalDate", nullable = true)
    public Timestamp getLatestInhospitalDate() {
        return latestInhospitalDate;
    }

    public void setLatestInhospitalDate(Timestamp latestInhospitalDate) {
        this.latestInhospitalDate = latestInhospitalDate;
    }

    @Basic
    @Column(name = "latestOuthospitalDate", nullable = true)
    public Timestamp getLatestOuthospitalDate() {
        return latestOuthospitalDate;
    }

    public void setLatestOuthospitalDate(Timestamp latestOuthospitalDate) {
        this.latestOuthospitalDate = latestOuthospitalDate;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EPatientWideTable that = (EPatientWideTable) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (sourceDiagnosisId != null ? !sourceDiagnosisId.equals(that.sourceDiagnosisId) : that.sourceDiagnosisId != null)
            return false;
        if (sourceDiagnosisId2 != null ? !sourceDiagnosisId2.equals(that.sourceDiagnosisId2) : that.sourceDiagnosisId2 != null)
            return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (inhospitalId2 != null ? !inhospitalId2.equals(that.inhospitalId2) : that.inhospitalId2 != null)
            return false;
        if (familyName1 != null ? !familyName1.equals(that.familyName1) : that.familyName1 != null) return false;
        if (patientRelationId1 != null ? !patientRelationId1.equals(that.patientRelationId1) : that.patientRelationId1 != null)
            return false;
        if (patientRelation1 != null ? !patientRelation1.equals(that.patientRelation1) : that.patientRelation1 != null)
            return false;
        if (familyPhone1 != null ? !familyPhone1.equals(that.familyPhone1) : that.familyPhone1 != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (isValid1 != null ? !isValid1.equals(that.isValid1) : that.isValid1 != null) return false;
        if (familyName2 != null ? !familyName2.equals(that.familyName2) : that.familyName2 != null) return false;
        if (patientRelationId2 != null ? !patientRelationId2.equals(that.patientRelationId2) : that.patientRelationId2 != null)
            return false;
        if (patientRelation2 != null ? !patientRelation2.equals(that.patientRelation2) : that.patientRelation2 != null)
            return false;
        if (familyPhone2 != null ? !familyPhone2.equals(that.familyPhone2) : that.familyPhone2 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (isValid2 != null ? !isValid2.equals(that.isValid2) : that.isValid2 != null) return false;
        if (familyName3 != null ? !familyName3.equals(that.familyName3) : that.familyName3 != null) return false;
        if (patientRelationId3 != null ? !patientRelationId3.equals(that.patientRelationId3) : that.patientRelationId3 != null)
            return false;
        if (patientRelation3 != null ? !patientRelation3.equals(that.patientRelation3) : that.patientRelation3 != null)
            return false;
        if (familyPhone3 != null ? !familyPhone3.equals(that.familyPhone3) : that.familyPhone3 != null) return false;
        if (address3 != null ? !address3.equals(that.address3) : that.address3 != null) return false;
        if (isValid3 != null ? !isValid3.equals(that.isValid3) : that.isValid3 != null) return false;
        if (familyCreateTime3 != null ? !familyCreateTime3.equals(that.familyCreateTime3) : that.familyCreateTime3 != null)
            return false;
        if (sourceInhospitalWay != null ? !sourceInhospitalWay.equals(that.sourceInhospitalWay) : that.sourceInhospitalWay != null)
            return false;
        if (sourceInhospitalWayName != null ? !sourceInhospitalWayName.equals(that.sourceInhospitalWayName) : that.sourceInhospitalWayName != null)
            return false;
        if (sourceInhospitalDate != null ? !sourceInhospitalDate.equals(that.sourceInhospitalDate) : that.sourceInhospitalDate != null)
            return false;
        if (sourceOuthospitalDate != null ? !sourceOuthospitalDate.equals(that.sourceOuthospitalDate) : that.sourceOuthospitalDate != null)
            return false;
        if (sourceInhospitalDeptId != null ? !sourceInhospitalDeptId.equals(that.sourceInhospitalDeptId) : that.sourceInhospitalDeptId != null)
            return false;
        if (sourceInhospitalDeptName != null ? !sourceInhospitalDeptName.equals(that.sourceInhospitalDeptName) : that.sourceInhospitalDeptName != null)
            return false;
        if (sourceOuthospitalDeptId != null ? !sourceOuthospitalDeptId.equals(that.sourceOuthospitalDeptId) : that.sourceOuthospitalDeptId != null)
            return false;
        if (sourceOuthospitalDeptName != null ? !sourceOuthospitalDeptName.equals(that.sourceOuthospitalDeptName) : that.sourceOuthospitalDeptName != null)
            return false;
        if (sourceTurnDeptId != null ? !sourceTurnDeptId.equals(that.sourceTurnDeptId) : that.sourceTurnDeptId != null)
            return false;
        if (sourceTurnDeptName != null ? !sourceTurnDeptName.equals(that.sourceTurnDeptName) : that.sourceTurnDeptName != null)
            return false;
        if (sourceDeptDoctor != null ? !sourceDeptDoctor.equals(that.sourceDeptDoctor) : that.sourceDeptDoctor != null)
            return false;
        if (sourceDeptDoctorName != null ? !sourceDeptDoctorName.equals(that.sourceDeptDoctorName) : that.sourceDeptDoctorName != null)
            return false;
        if (sourceDirectorDoctor != null ? !sourceDirectorDoctor.equals(that.sourceDirectorDoctor) : that.sourceDirectorDoctor != null)
            return false;
        if (sourceDirectorDoctorName != null ? !sourceDirectorDoctorName.equals(that.sourceDirectorDoctorName) : that.sourceDirectorDoctorName != null)
            return false;
        if (sourceInchargeDoctor != null ? !sourceInchargeDoctor.equals(that.sourceInchargeDoctor) : that.sourceInchargeDoctor != null)
            return false;
        if (sourceInchargeDoctorName != null ? !sourceInchargeDoctorName.equals(that.sourceInchargeDoctorName) : that.sourceInchargeDoctorName != null)
            return false;
        if (sourceInhospitalDoctor != null ? !sourceInhospitalDoctor.equals(that.sourceInhospitalDoctor) : that.sourceInhospitalDoctor != null)
            return false;
        if (sourceInhospitalDoctorName != null ? !sourceInhospitalDoctorName.equals(that.sourceInhospitalDoctorName) : that.sourceInhospitalDoctorName != null)
            return false;
        if (sourceAttendingDoctor != null ? !sourceAttendingDoctor.equals(that.sourceAttendingDoctor) : that.sourceAttendingDoctor != null)
            return false;
        if (sourceAttendingDoctorName != null ? !sourceAttendingDoctorName.equals(that.sourceAttendingDoctorName) : that.sourceAttendingDoctorName != null)
            return false;
        if (sourceCancerNum != null ? !sourceCancerNum.equals(that.sourceCancerNum) : that.sourceCancerNum != null)
            return false;
        if (confirmedDate != null ? !confirmedDate.equals(that.confirmedDate) : that.confirmedDate != null)
            return false;
        if (confirmedAge != null ? !confirmedAge.equals(that.confirmedAge) : that.confirmedAge != null) return false;
        if (sourceDiseaseTypeId != null ? !sourceDiseaseTypeId.equals(that.sourceDiseaseTypeId) : that.sourceDiseaseTypeId != null)
            return false;
        if (sourceDiseaseTypeName != null ? !sourceDiseaseTypeName.equals(that.sourceDiseaseTypeName) : that.sourceDiseaseTypeName != null)
            return false;
        if (sourceDiagnosis != null ? !sourceDiagnosis.equals(that.sourceDiagnosis) : that.sourceDiagnosis != null)
            return false;
        if (sourceDiseaseCode != null ? !sourceDiseaseCode.equals(that.sourceDiseaseCode) : that.sourceDiseaseCode != null)
            return false;
        if (secondaryDiagnosis != null ? !secondaryDiagnosis.equals(that.secondaryDiagnosis) : that.secondaryDiagnosis != null)
            return false;
        if (secondaryDiseaseCode != null ? !secondaryDiseaseCode.equals(that.secondaryDiseaseCode) : that.secondaryDiseaseCode != null)
            return false;
        if (secondaryPathologyDiagnosis != null ? !secondaryPathologyDiagnosis.equals(that.secondaryPathologyDiagnosis) : that.secondaryPathologyDiagnosis != null)
            return false;
        if (secondaryPathologyDiseaseCode != null ? !secondaryPathologyDiseaseCode.equals(that.secondaryPathologyDiseaseCode) : that.secondaryPathologyDiseaseCode != null)
            return false;
        if (sourceDiagnosis2 != null ? !sourceDiagnosis2.equals(that.sourceDiagnosis2) : that.sourceDiagnosis2 != null)
            return false;
        if (sourceDiseaseCode2 != null ? !sourceDiseaseCode2.equals(that.sourceDiseaseCode2) : that.sourceDiseaseCode2 != null)
            return false;
        if (sourcePathologyDiagnosis2 != null ? !sourcePathologyDiagnosis2.equals(that.sourcePathologyDiagnosis2) : that.sourcePathologyDiagnosis2 != null)
            return false;
        if (sourcePathologyDiseaseCode2 != null ? !sourcePathologyDiseaseCode2.equals(that.sourcePathologyDiseaseCode2) : that.sourcePathologyDiseaseCode2 != null)
            return false;
        if (tumourPeriodizationClinic != null ? !tumourPeriodizationClinic.equals(that.tumourPeriodizationClinic) : that.tumourPeriodizationClinic != null)
            return false;
        if (tumourPeriodizationTnm != null ? !tumourPeriodizationTnm.equals(that.tumourPeriodizationTnm) : that.tumourPeriodizationTnm != null)
            return false;
        if (diagnosis1 != null ? !diagnosis1.equals(that.diagnosis1) : that.diagnosis1 != null) return false;
        if (diagnosis2 != null ? !diagnosis2.equals(that.diagnosis2) : that.diagnosis2 != null) return false;
        if (diagnosis3 != null ? !diagnosis3.equals(that.diagnosis3) : that.diagnosis3 != null) return false;
        if (diagnosis4 != null ? !diagnosis4.equals(that.diagnosis4) : that.diagnosis4 != null) return false;
        if (diagnosis5 != null ? !diagnosis5.equals(that.diagnosis5) : that.diagnosis5 != null) return false;
        if (diseaseCode1 != null ? !diseaseCode1.equals(that.diseaseCode1) : that.diseaseCode1 != null) return false;
        if (diseaseCode2 != null ? !diseaseCode2.equals(that.diseaseCode2) : that.diseaseCode2 != null) return false;
        if (diseaseCode3 != null ? !diseaseCode3.equals(that.diseaseCode3) : that.diseaseCode3 != null) return false;
        if (diseaseCode4 != null ? !diseaseCode4.equals(that.diseaseCode4) : that.diseaseCode4 != null) return false;
        if (diseaseCode5 != null ? !diseaseCode5.equals(that.diseaseCode5) : that.diseaseCode5 != null) return false;
        if (pathologyDiagnosis1 != null ? !pathologyDiagnosis1.equals(that.pathologyDiagnosis1) : that.pathologyDiagnosis1 != null)
            return false;
        if (pathologyDiagnosis2 != null ? !pathologyDiagnosis2.equals(that.pathologyDiagnosis2) : that.pathologyDiagnosis2 != null)
            return false;
        if (pathologyDiagnosis3 != null ? !pathologyDiagnosis3.equals(that.pathologyDiagnosis3) : that.pathologyDiagnosis3 != null)
            return false;
        if (pathologyDiagnosis4 != null ? !pathologyDiagnosis4.equals(that.pathologyDiagnosis4) : that.pathologyDiagnosis4 != null)
            return false;
        if (pathologyDiagnosis5 != null ? !pathologyDiagnosis5.equals(that.pathologyDiagnosis5) : that.pathologyDiagnosis5 != null)
            return false;
        if (pathologyDiagnosisCode1 != null ? !pathologyDiagnosisCode1.equals(that.pathologyDiagnosisCode1) : that.pathologyDiagnosisCode1 != null)
            return false;
        if (pathologyDiagnosisCode2 != null ? !pathologyDiagnosisCode2.equals(that.pathologyDiagnosisCode2) : that.pathologyDiagnosisCode2 != null)
            return false;
        if (pathologyDiagnosisCode3 != null ? !pathologyDiagnosisCode3.equals(that.pathologyDiagnosisCode3) : that.pathologyDiagnosisCode3 != null)
            return false;
        if (pathologyDiagnosisCode4 != null ? !pathologyDiagnosisCode4.equals(that.pathologyDiagnosisCode4) : that.pathologyDiagnosisCode4 != null)
            return false;
        if (pathologyDiagnosisCode5 != null ? !pathologyDiagnosisCode5.equals(that.pathologyDiagnosisCode5) : that.pathologyDiagnosisCode5 != null)
            return false;
        if (disagnosisPeriodizationId1 != null ? !disagnosisPeriodizationId1.equals(that.disagnosisPeriodizationId1) : that.disagnosisPeriodizationId1 != null)
            return false;
        if (disagnosisPeriodizationId2 != null ? !disagnosisPeriodizationId2.equals(that.disagnosisPeriodizationId2) : that.disagnosisPeriodizationId2 != null)
            return false;
        if (disagnosisPeriodizationId3 != null ? !disagnosisPeriodizationId3.equals(that.disagnosisPeriodizationId3) : that.disagnosisPeriodizationId3 != null)
            return false;
        if (disagnosisPeriodizationId4 != null ? !disagnosisPeriodizationId4.equals(that.disagnosisPeriodizationId4) : that.disagnosisPeriodizationId4 != null)
            return false;
        if (disagnosisPeriodizationId5 != null ? !disagnosisPeriodizationId5.equals(that.disagnosisPeriodizationId5) : that.disagnosisPeriodizationId5 != null)
            return false;
        if (disagnosisPeriodizationName1 != null ? !disagnosisPeriodizationName1.equals(that.disagnosisPeriodizationName1) : that.disagnosisPeriodizationName1 != null)
            return false;
        if (disagnosisPeriodizationName2 != null ? !disagnosisPeriodizationName2.equals(that.disagnosisPeriodizationName2) : that.disagnosisPeriodizationName2 != null)
            return false;
        if (disagnosisPeriodizationName3 != null ? !disagnosisPeriodizationName3.equals(that.disagnosisPeriodizationName3) : that.disagnosisPeriodizationName3 != null)
            return false;
        if (disagnosisPeriodizationName4 != null ? !disagnosisPeriodizationName4.equals(that.disagnosisPeriodizationName4) : that.disagnosisPeriodizationName4 != null)
            return false;
        if (disagnosisPeriodizationName5 != null ? !disagnosisPeriodizationName5.equals(that.disagnosisPeriodizationName5) : that.disagnosisPeriodizationName5 != null)
            return false;
        if (surgeryDate1 != null ? !surgeryDate1.equals(that.surgeryDate1) : that.surgeryDate1 != null) return false;
        if (surgeryDate2 != null ? !surgeryDate2.equals(that.surgeryDate2) : that.surgeryDate2 != null) return false;
        if (surgeryDate3 != null ? !surgeryDate3.equals(that.surgeryDate3) : that.surgeryDate3 != null) return false;
        if (surgeryDate4 != null ? !surgeryDate4.equals(that.surgeryDate4) : that.surgeryDate4 != null) return false;
        if (surgeryDate5 != null ? !surgeryDate5.equals(that.surgeryDate5) : that.surgeryDate5 != null) return false;
        if (surgeryDate6 != null ? !surgeryDate6.equals(that.surgeryDate6) : that.surgeryDate6 != null) return false;
        if (surgeryDate7 != null ? !surgeryDate7.equals(that.surgeryDate7) : that.surgeryDate7 != null) return false;
        if (surgeryDate8 != null ? !surgeryDate8.equals(that.surgeryDate8) : that.surgeryDate8 != null) return false;
        if (surgeryName1 != null ? !surgeryName1.equals(that.surgeryName1) : that.surgeryName1 != null) return false;
        if (surgeryName2 != null ? !surgeryName2.equals(that.surgeryName2) : that.surgeryName2 != null) return false;
        if (surgeryName3 != null ? !surgeryName3.equals(that.surgeryName3) : that.surgeryName3 != null) return false;
        if (surgeryName4 != null ? !surgeryName4.equals(that.surgeryName4) : that.surgeryName4 != null) return false;
        if (surgeryName5 != null ? !surgeryName5.equals(that.surgeryName5) : that.surgeryName5 != null) return false;
        if (surgeryName6 != null ? !surgeryName6.equals(that.surgeryName6) : that.surgeryName6 != null) return false;
        if (surgeryName7 != null ? !surgeryName7.equals(that.surgeryName7) : that.surgeryName7 != null) return false;
        if (surgeryName8 != null ? !surgeryName8.equals(that.surgeryName8) : that.surgeryName8 != null) return false;
        if (opCode1 != null ? !opCode1.equals(that.opCode1) : that.opCode1 != null) return false;
        if (opCode2 != null ? !opCode2.equals(that.opCode2) : that.opCode2 != null) return false;
        if (opCode3 != null ? !opCode3.equals(that.opCode3) : that.opCode3 != null) return false;
        if (opCode4 != null ? !opCode4.equals(that.opCode4) : that.opCode4 != null) return false;
        if (opCode5 != null ? !opCode5.equals(that.opCode5) : that.opCode5 != null) return false;
        if (opCode6 != null ? !opCode6.equals(that.opCode6) : that.opCode6 != null) return false;
        if (opCode7 != null ? !opCode7.equals(that.opCode7) : that.opCode7 != null) return false;
        if (opCode8 != null ? !opCode8.equals(that.opCode8) : that.opCode8 != null) return false;
        if (surgeryDoctor1 != null ? !surgeryDoctor1.equals(that.surgeryDoctor1) : that.surgeryDoctor1 != null)
            return false;
        if (surgeryDoctor2 != null ? !surgeryDoctor2.equals(that.surgeryDoctor2) : that.surgeryDoctor2 != null)
            return false;
        if (surgeryDoctor3 != null ? !surgeryDoctor3.equals(that.surgeryDoctor3) : that.surgeryDoctor3 != null)
            return false;
        if (surgeryDoctor4 != null ? !surgeryDoctor4.equals(that.surgeryDoctor4) : that.surgeryDoctor4 != null)
            return false;
        if (surgeryDoctor5 != null ? !surgeryDoctor5.equals(that.surgeryDoctor5) : that.surgeryDoctor5 != null)
            return false;
        if (surgeryDoctor6 != null ? !surgeryDoctor6.equals(that.surgeryDoctor6) : that.surgeryDoctor6 != null)
            return false;
        if (surgeryDoctor7 != null ? !surgeryDoctor7.equals(that.surgeryDoctor7) : that.surgeryDoctor7 != null)
            return false;
        if (surgeryDoctor8 != null ? !surgeryDoctor8.equals(that.surgeryDoctor8) : that.surgeryDoctor8 != null)
            return false;
        if (surgeryDoctorName1 != null ? !surgeryDoctorName1.equals(that.surgeryDoctorName1) : that.surgeryDoctorName1 != null)
            return false;
        if (surgeryDoctorName2 != null ? !surgeryDoctorName2.equals(that.surgeryDoctorName2) : that.surgeryDoctorName2 != null)
            return false;
        if (surgeryDoctorName3 != null ? !surgeryDoctorName3.equals(that.surgeryDoctorName3) : that.surgeryDoctorName3 != null)
            return false;
        if (surgeryDoctorName4 != null ? !surgeryDoctorName4.equals(that.surgeryDoctorName4) : that.surgeryDoctorName4 != null)
            return false;
        if (surgeryDoctorName5 != null ? !surgeryDoctorName5.equals(that.surgeryDoctorName5) : that.surgeryDoctorName5 != null)
            return false;
        if (surgeryDoctorName6 != null ? !surgeryDoctorName6.equals(that.surgeryDoctorName6) : that.surgeryDoctorName6 != null)
            return false;
        if (surgeryDoctorName7 != null ? !surgeryDoctorName7.equals(that.surgeryDoctorName7) : that.surgeryDoctorName7 != null)
            return false;
        if (surgeryDoctorName8 != null ? !surgeryDoctorName8.equals(that.surgeryDoctorName8) : that.surgeryDoctorName8 != null)
            return false;
        if (familyCreateTime1 != null ? !familyCreateTime1.equals(that.familyCreateTime1) : that.familyCreateTime1 != null)
            return false;
        if (familyCreateTime2 != null ? !familyCreateTime2.equals(that.familyCreateTime2) : that.familyCreateTime2 != null)
            return false;
        if (diagnosisCreateTime1 != null ? !diagnosisCreateTime1.equals(that.diagnosisCreateTime1) : that.diagnosisCreateTime1 != null)
            return false;
        if (diagnosisCreateTime2 != null ? !diagnosisCreateTime2.equals(that.diagnosisCreateTime2) : that.diagnosisCreateTime2 != null)
            return false;
        if (diagnosisCreateTime3 != null ? !diagnosisCreateTime3.equals(that.diagnosisCreateTime3) : that.diagnosisCreateTime3 != null)
            return false;
        if (diagnosisCreateTime4 != null ? !diagnosisCreateTime4.equals(that.diagnosisCreateTime4) : that.diagnosisCreateTime4 != null)
            return false;
        if (diagnosisCreateTime5 != null ? !diagnosisCreateTime5.equals(that.diagnosisCreateTime5) : that.diagnosisCreateTime5 != null)
            return false;
        if (diagnosisType1 != null ? !diagnosisType1.equals(that.diagnosisType1) : that.diagnosisType1 != null)
            return false;
        if (diagnosisType2 != null ? !diagnosisType2.equals(that.diagnosisType2) : that.diagnosisType2 != null)
            return false;
        if (diagnosisType3 != null ? !diagnosisType3.equals(that.diagnosisType3) : that.diagnosisType3 != null)
            return false;
        if (diagnosisType4 != null ? !diagnosisType4.equals(that.diagnosisType4) : that.diagnosisType4 != null)
            return false;
        if (diagnosisType5 != null ? !diagnosisType5.equals(that.diagnosisType5) : that.diagnosisType5 != null)
            return false;
        if (diagnosisId1 != null ? !diagnosisId1.equals(that.diagnosisId1) : that.diagnosisId1 != null) return false;
        if (diagnosisId2 != null ? !diagnosisId2.equals(that.diagnosisId2) : that.diagnosisId2 != null) return false;
        if (diagnosisId3 != null ? !diagnosisId3.equals(that.diagnosisId3) : that.diagnosisId3 != null) return false;
        if (diagnosisId4 != null ? !diagnosisId4.equals(that.diagnosisId4) : that.diagnosisId4 != null) return false;
        if (diagnosisId5 != null ? !diagnosisId5.equals(that.diagnosisId5) : that.diagnosisId5 != null) return false;
        if (surgeryCreateTime1 != null ? !surgeryCreateTime1.equals(that.surgeryCreateTime1) : that.surgeryCreateTime1 != null)
            return false;
        if (surgeryCreateTime2 != null ? !surgeryCreateTime2.equals(that.surgeryCreateTime2) : that.surgeryCreateTime2 != null)
            return false;
        if (surgeryCreateTime3 != null ? !surgeryCreateTime3.equals(that.surgeryCreateTime3) : that.surgeryCreateTime3 != null)
            return false;
        if (surgeryCreateTime4 != null ? !surgeryCreateTime4.equals(that.surgeryCreateTime4) : that.surgeryCreateTime4 != null)
            return false;
        if (surgeryCreateTime5 != null ? !surgeryCreateTime5.equals(that.surgeryCreateTime5) : that.surgeryCreateTime5 != null)
            return false;
        if (surgeryCreateTime6 != null ? !surgeryCreateTime6.equals(that.surgeryCreateTime6) : that.surgeryCreateTime6 != null)
            return false;
        if (surgeryCreateTime7 != null ? !surgeryCreateTime7.equals(that.surgeryCreateTime7) : that.surgeryCreateTime7 != null)
            return false;
        if (surgeryCreateTime8 != null ? !surgeryCreateTime8.equals(that.surgeryCreateTime8) : that.surgeryCreateTime8 != null)
            return false;
        if (treatmentNames != null ? !treatmentNames.equals(that.treatmentNames) : that.treatmentNames != null)
            return false;
        if (treatmentHistory != null ? !treatmentHistory.equals(that.treatmentHistory) : that.treatmentHistory != null)
            return false;
        if (firstOuthospitalDeptId != null ? !firstOuthospitalDeptId.equals(that.firstOuthospitalDeptId) : that.firstOuthospitalDeptId != null)
            return false;
        if (firstOuthospitalDeptName != null ? !firstOuthospitalDeptName.equals(that.firstOuthospitalDeptName) : that.firstOuthospitalDeptName != null)
            return false;
        if (latestOuthospitalDeptId != null ? !latestOuthospitalDeptId.equals(that.latestOuthospitalDeptId) : that.latestOuthospitalDeptId != null)
            return false;
        if (latestOuthospitalDeptName != null ? !latestOuthospitalDeptName.equals(that.latestOuthospitalDeptName) : that.latestOuthospitalDeptName != null)
            return false;
        if (latestClinicDate != null ? !latestClinicDate.equals(that.latestClinicDate) : that.latestClinicDate != null)
            return false;
        if (latestInhospitalDate != null ? !latestInhospitalDate.equals(that.latestInhospitalDate) : that.latestInhospitalDate != null)
            return false;
        if (latestOuthospitalDate != null ? !latestOuthospitalDate.equals(that.latestOuthospitalDate) : that.latestOuthospitalDate != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (sourceDiagnosisId != null ? sourceDiagnosisId.hashCode() : 0);
        result = 31 * result + (sourceDiagnosisId2 != null ? sourceDiagnosisId2.hashCode() : 0);
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (inhospitalId2 != null ? inhospitalId2.hashCode() : 0);
        result = 31 * result + (familyName1 != null ? familyName1.hashCode() : 0);
        result = 31 * result + (patientRelationId1 != null ? patientRelationId1.hashCode() : 0);
        result = 31 * result + (patientRelation1 != null ? patientRelation1.hashCode() : 0);
        result = 31 * result + (familyPhone1 != null ? familyPhone1.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (isValid1 != null ? isValid1.hashCode() : 0);
        result = 31 * result + (familyName2 != null ? familyName2.hashCode() : 0);
        result = 31 * result + (patientRelationId2 != null ? patientRelationId2.hashCode() : 0);
        result = 31 * result + (patientRelation2 != null ? patientRelation2.hashCode() : 0);
        result = 31 * result + (familyPhone2 != null ? familyPhone2.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (isValid2 != null ? isValid2.hashCode() : 0);
        result = 31 * result + (familyName3 != null ? familyName3.hashCode() : 0);
        result = 31 * result + (patientRelationId3 != null ? patientRelationId3.hashCode() : 0);
        result = 31 * result + (patientRelation3 != null ? patientRelation3.hashCode() : 0);
        result = 31 * result + (familyPhone3 != null ? familyPhone3.hashCode() : 0);
        result = 31 * result + (address3 != null ? address3.hashCode() : 0);
        result = 31 * result + (isValid3 != null ? isValid3.hashCode() : 0);
        result = 31 * result + (familyCreateTime3 != null ? familyCreateTime3.hashCode() : 0);
        result = 31 * result + (sourceInhospitalWay != null ? sourceInhospitalWay.hashCode() : 0);
        result = 31 * result + (sourceInhospitalWayName != null ? sourceInhospitalWayName.hashCode() : 0);
        result = 31 * result + (sourceInhospitalDate != null ? sourceInhospitalDate.hashCode() : 0);
        result = 31 * result + (sourceOuthospitalDate != null ? sourceOuthospitalDate.hashCode() : 0);
        result = 31 * result + (sourceInhospitalDeptId != null ? sourceInhospitalDeptId.hashCode() : 0);
        result = 31 * result + (sourceInhospitalDeptName != null ? sourceInhospitalDeptName.hashCode() : 0);
        result = 31 * result + (sourceOuthospitalDeptId != null ? sourceOuthospitalDeptId.hashCode() : 0);
        result = 31 * result + (sourceOuthospitalDeptName != null ? sourceOuthospitalDeptName.hashCode() : 0);
        result = 31 * result + (sourceTurnDeptId != null ? sourceTurnDeptId.hashCode() : 0);
        result = 31 * result + (sourceTurnDeptName != null ? sourceTurnDeptName.hashCode() : 0);
        result = 31 * result + (sourceDeptDoctor != null ? sourceDeptDoctor.hashCode() : 0);
        result = 31 * result + (sourceDeptDoctorName != null ? sourceDeptDoctorName.hashCode() : 0);
        result = 31 * result + (sourceDirectorDoctor != null ? sourceDirectorDoctor.hashCode() : 0);
        result = 31 * result + (sourceDirectorDoctorName != null ? sourceDirectorDoctorName.hashCode() : 0);
        result = 31 * result + (sourceInchargeDoctor != null ? sourceInchargeDoctor.hashCode() : 0);
        result = 31 * result + (sourceInchargeDoctorName != null ? sourceInchargeDoctorName.hashCode() : 0);
        result = 31 * result + (sourceInhospitalDoctor != null ? sourceInhospitalDoctor.hashCode() : 0);
        result = 31 * result + (sourceInhospitalDoctorName != null ? sourceInhospitalDoctorName.hashCode() : 0);
        result = 31 * result + (sourceAttendingDoctor != null ? sourceAttendingDoctor.hashCode() : 0);
        result = 31 * result + (sourceAttendingDoctorName != null ? sourceAttendingDoctorName.hashCode() : 0);
        result = 31 * result + (sourceCancerNum != null ? sourceCancerNum.hashCode() : 0);
        result = 31 * result + (confirmedDate != null ? confirmedDate.hashCode() : 0);
        result = 31 * result + (confirmedAge != null ? confirmedAge.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeId != null ? sourceDiseaseTypeId.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeName != null ? sourceDiseaseTypeName.hashCode() : 0);
        result = 31 * result + (sourceDiagnosis != null ? sourceDiagnosis.hashCode() : 0);
        result = 31 * result + (sourceDiseaseCode != null ? sourceDiseaseCode.hashCode() : 0);
        result = 31 * result + (secondaryDiagnosis != null ? secondaryDiagnosis.hashCode() : 0);
        result = 31 * result + (secondaryDiseaseCode != null ? secondaryDiseaseCode.hashCode() : 0);
        result = 31 * result + (secondaryPathologyDiagnosis != null ? secondaryPathologyDiagnosis.hashCode() : 0);
        result = 31 * result + (secondaryPathologyDiseaseCode != null ? secondaryPathologyDiseaseCode.hashCode() : 0);
        result = 31 * result + (sourceDiagnosis2 != null ? sourceDiagnosis2.hashCode() : 0);
        result = 31 * result + (sourceDiseaseCode2 != null ? sourceDiseaseCode2.hashCode() : 0);
        result = 31 * result + (sourcePathologyDiagnosis2 != null ? sourcePathologyDiagnosis2.hashCode() : 0);
        result = 31 * result + (sourcePathologyDiseaseCode2 != null ? sourcePathologyDiseaseCode2.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationClinic != null ? tumourPeriodizationClinic.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationTnm != null ? tumourPeriodizationTnm.hashCode() : 0);
        result = 31 * result + (diagnosis1 != null ? diagnosis1.hashCode() : 0);
        result = 31 * result + (diagnosis2 != null ? diagnosis2.hashCode() : 0);
        result = 31 * result + (diagnosis3 != null ? diagnosis3.hashCode() : 0);
        result = 31 * result + (diagnosis4 != null ? diagnosis4.hashCode() : 0);
        result = 31 * result + (diagnosis5 != null ? diagnosis5.hashCode() : 0);
        result = 31 * result + (diseaseCode1 != null ? diseaseCode1.hashCode() : 0);
        result = 31 * result + (diseaseCode2 != null ? diseaseCode2.hashCode() : 0);
        result = 31 * result + (diseaseCode3 != null ? diseaseCode3.hashCode() : 0);
        result = 31 * result + (diseaseCode4 != null ? diseaseCode4.hashCode() : 0);
        result = 31 * result + (diseaseCode5 != null ? diseaseCode5.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis1 != null ? pathologyDiagnosis1.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis2 != null ? pathologyDiagnosis2.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis3 != null ? pathologyDiagnosis3.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis4 != null ? pathologyDiagnosis4.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis5 != null ? pathologyDiagnosis5.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode1 != null ? pathologyDiagnosisCode1.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode2 != null ? pathologyDiagnosisCode2.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode3 != null ? pathologyDiagnosisCode3.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode4 != null ? pathologyDiagnosisCode4.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode5 != null ? pathologyDiagnosisCode5.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationId1 != null ? disagnosisPeriodizationId1.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationId2 != null ? disagnosisPeriodizationId2.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationId3 != null ? disagnosisPeriodizationId3.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationId4 != null ? disagnosisPeriodizationId4.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationId5 != null ? disagnosisPeriodizationId5.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationName1 != null ? disagnosisPeriodizationName1.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationName2 != null ? disagnosisPeriodizationName2.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationName3 != null ? disagnosisPeriodizationName3.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationName4 != null ? disagnosisPeriodizationName4.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationName5 != null ? disagnosisPeriodizationName5.hashCode() : 0);
        result = 31 * result + (surgeryDate1 != null ? surgeryDate1.hashCode() : 0);
        result = 31 * result + (surgeryDate2 != null ? surgeryDate2.hashCode() : 0);
        result = 31 * result + (surgeryDate3 != null ? surgeryDate3.hashCode() : 0);
        result = 31 * result + (surgeryDate4 != null ? surgeryDate4.hashCode() : 0);
        result = 31 * result + (surgeryDate5 != null ? surgeryDate5.hashCode() : 0);
        result = 31 * result + (surgeryDate6 != null ? surgeryDate6.hashCode() : 0);
        result = 31 * result + (surgeryDate7 != null ? surgeryDate7.hashCode() : 0);
        result = 31 * result + (surgeryDate8 != null ? surgeryDate8.hashCode() : 0);
        result = 31 * result + (surgeryName1 != null ? surgeryName1.hashCode() : 0);
        result = 31 * result + (surgeryName2 != null ? surgeryName2.hashCode() : 0);
        result = 31 * result + (surgeryName3 != null ? surgeryName3.hashCode() : 0);
        result = 31 * result + (surgeryName4 != null ? surgeryName4.hashCode() : 0);
        result = 31 * result + (surgeryName5 != null ? surgeryName5.hashCode() : 0);
        result = 31 * result + (surgeryName6 != null ? surgeryName6.hashCode() : 0);
        result = 31 * result + (surgeryName7 != null ? surgeryName7.hashCode() : 0);
        result = 31 * result + (surgeryName8 != null ? surgeryName8.hashCode() : 0);
        result = 31 * result + (opCode1 != null ? opCode1.hashCode() : 0);
        result = 31 * result + (opCode2 != null ? opCode2.hashCode() : 0);
        result = 31 * result + (opCode3 != null ? opCode3.hashCode() : 0);
        result = 31 * result + (opCode4 != null ? opCode4.hashCode() : 0);
        result = 31 * result + (opCode5 != null ? opCode5.hashCode() : 0);
        result = 31 * result + (opCode6 != null ? opCode6.hashCode() : 0);
        result = 31 * result + (opCode7 != null ? opCode7.hashCode() : 0);
        result = 31 * result + (opCode8 != null ? opCode8.hashCode() : 0);
        result = 31 * result + (surgeryDoctor1 != null ? surgeryDoctor1.hashCode() : 0);
        result = 31 * result + (surgeryDoctor2 != null ? surgeryDoctor2.hashCode() : 0);
        result = 31 * result + (surgeryDoctor3 != null ? surgeryDoctor3.hashCode() : 0);
        result = 31 * result + (surgeryDoctor4 != null ? surgeryDoctor4.hashCode() : 0);
        result = 31 * result + (surgeryDoctor5 != null ? surgeryDoctor5.hashCode() : 0);
        result = 31 * result + (surgeryDoctor6 != null ? surgeryDoctor6.hashCode() : 0);
        result = 31 * result + (surgeryDoctor7 != null ? surgeryDoctor7.hashCode() : 0);
        result = 31 * result + (surgeryDoctor8 != null ? surgeryDoctor8.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName1 != null ? surgeryDoctorName1.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName2 != null ? surgeryDoctorName2.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName3 != null ? surgeryDoctorName3.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName4 != null ? surgeryDoctorName4.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName5 != null ? surgeryDoctorName5.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName6 != null ? surgeryDoctorName6.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName7 != null ? surgeryDoctorName7.hashCode() : 0);
        result = 31 * result + (surgeryDoctorName8 != null ? surgeryDoctorName8.hashCode() : 0);
        result = 31 * result + (familyCreateTime1 != null ? familyCreateTime1.hashCode() : 0);
        result = 31 * result + (familyCreateTime2 != null ? familyCreateTime2.hashCode() : 0);
        result = 31 * result + (diagnosisCreateTime1 != null ? diagnosisCreateTime1.hashCode() : 0);
        result = 31 * result + (diagnosisCreateTime2 != null ? diagnosisCreateTime2.hashCode() : 0);
        result = 31 * result + (diagnosisCreateTime3 != null ? diagnosisCreateTime3.hashCode() : 0);
        result = 31 * result + (diagnosisCreateTime4 != null ? diagnosisCreateTime4.hashCode() : 0);
        result = 31 * result + (diagnosisCreateTime5 != null ? diagnosisCreateTime5.hashCode() : 0);
        result = 31 * result + (diagnosisType1 != null ? diagnosisType1.hashCode() : 0);
        result = 31 * result + (diagnosisType2 != null ? diagnosisType2.hashCode() : 0);
        result = 31 * result + (diagnosisType3 != null ? diagnosisType3.hashCode() : 0);
        result = 31 * result + (diagnosisType4 != null ? diagnosisType4.hashCode() : 0);
        result = 31 * result + (diagnosisType5 != null ? diagnosisType5.hashCode() : 0);
        result = 31 * result + (diagnosisId1 != null ? diagnosisId1.hashCode() : 0);
        result = 31 * result + (diagnosisId2 != null ? diagnosisId2.hashCode() : 0);
        result = 31 * result + (diagnosisId3 != null ? diagnosisId3.hashCode() : 0);
        result = 31 * result + (diagnosisId4 != null ? diagnosisId4.hashCode() : 0);
        result = 31 * result + (diagnosisId5 != null ? diagnosisId5.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime1 != null ? surgeryCreateTime1.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime2 != null ? surgeryCreateTime2.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime3 != null ? surgeryCreateTime3.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime4 != null ? surgeryCreateTime4.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime5 != null ? surgeryCreateTime5.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime6 != null ? surgeryCreateTime6.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime7 != null ? surgeryCreateTime7.hashCode() : 0);
        result = 31 * result + (surgeryCreateTime8 != null ? surgeryCreateTime8.hashCode() : 0);
        result = 31 * result + (treatmentNames != null ? treatmentNames.hashCode() : 0);
        result = 31 * result + (treatmentHistory != null ? treatmentHistory.hashCode() : 0);
        result = 31 * result + (firstOuthospitalDeptId != null ? firstOuthospitalDeptId.hashCode() : 0);
        result = 31 * result + (firstOuthospitalDeptName != null ? firstOuthospitalDeptName.hashCode() : 0);
        result = 31 * result + (latestOuthospitalDeptId != null ? latestOuthospitalDeptId.hashCode() : 0);
        result = 31 * result + (latestOuthospitalDeptName != null ? latestOuthospitalDeptName.hashCode() : 0);
        result = 31 * result + (latestClinicDate != null ? latestClinicDate.hashCode() : 0);
        result = 31 * result + (latestInhospitalDate != null ? latestInhospitalDate.hashCode() : 0);
        result = 31 * result + (latestOuthospitalDate != null ? latestOuthospitalDate.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
