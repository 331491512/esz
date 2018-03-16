ALTER TABLE ehr_db.ei_inhospital_note
ADD COLUMN `patientType`  int(3) NULL AFTER `oldouthospitaldate`,
ADD COLUMN `mergeFlag`  int(1) NULL AFTER `patientType`,
ADD COLUMN `mergeFrom`  int(11) NULL AFTER `mergeFlag`,
ADD COLUMN `mergeTarget`  int(11) NULL AFTER `mergeFrom`,
ADD COLUMN `oldInhospitalId`  varchar(128) NULL AFTER `mergeTarget`;


ALTER TABLE ehr_db.e_diagnosis_info
ADD COLUMN `patientType`  int(3) NULL ,
ADD COLUMN `mergeFlag`  int(1) NULL AFTER `patientType`,
ADD COLUMN `mergeFrom`  int(11) NULL AFTER `mergeFlag`,
ADD COLUMN `mergeTarget`  int(11) NULL AFTER `mergeFrom`;

ALTER TABLE ehr_db.eci_treatment_note
ADD COLUMN `patientType`  int(3) NULL ,
ADD COLUMN `mergeFlag`  int(1) NULL AFTER `patientType`,
ADD COLUMN `mergeFrom`  int(11) NULL AFTER `mergeFlag`,
ADD COLUMN `mergeTarget`  int(11) NULL AFTER `mergeFrom`;

ALTER TABLE ehr_db.eci_surgery_note
ADD COLUMN `patientType`  int(3) NULL ,
ADD COLUMN `mergeFlag`  int(1) NULL AFTER `patientType`,
ADD COLUMN `mergeFrom`  int(11) NULL AFTER `mergeFlag`,
ADD COLUMN `mergeTarget`  int(11) NULL AFTER `mergeFrom`;

-- 添加临时字段最近就诊时间
ALTER TABLE user_db.u_patient
ADD COLUMN `lastMaxDate`  datetime NULL AFTER `rawCreateTime`;


ALTER TABLE user_db.u_patient_family
ADD COLUMN `patientType`  int(3) NULL ,
ADD COLUMN `mergeFlag`  int(1) NULL AFTER `patientType`,
ADD COLUMN `mergeFrom`  int(11) NULL AFTER `mergeFlag`,
ADD COLUMN `mergeTarget`  int(11) NULL AFTER `mergeFrom`;

ALTER TABLE user_db.r_doctor_patient
ADD COLUMN `patientType`  int(3) NULL ,
ADD COLUMN `mergeFlag`  int(1) NULL AFTER `patientType`,
ADD COLUMN `mergeFrom`  int(11) NULL AFTER `mergeFlag`,
ADD COLUMN `mergeTarget`  int(11) NULL AFTER `mergeFrom`;