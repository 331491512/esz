############################### user_db ##################################################

-- 患者表 2.4.2
alter table user_db.u_patient
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）' after `patientType`,
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget,
  add column `lastAttendingDate` datetime null comment '最近就诊时间' after rawcreatetime;

alter table user_db.u_patient modify column `patientType` int(2) COMMENT '患者类型。1：普通（默认）；2：特病; -1: 被合并掉的疑似重复患者(类软删除)' DEFAULT 1;

-- 用户表 2.4.1
alter table user_db.u_user
add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 创建u_patient_merge_bak 2.5.23
create table if not exists user_db.u_patient_merge_bak
  select p.*
  from user_db.u_patient p
  where 1 = 0;
-- 创建u_user_merge_bak 2.5.24
create table if not exists user_db.u_user_merge_bak
  select p.*
  from user_db.u_user p
  where 1 = 0;
-- 添加主键约束
alter table user_db.u_patient_merge_bak
  modify patientid bigint primary key;
alter table user_db.u_user_merge_bak
  modify userid bigint primary key;

-- 日志表 2.5.22
create table if not exists user_db.u_merge_log (
  id    int primary key auto_increment ,
  goalpatientid bigint comment '目标患者',
  otherPatientIds varchar(255) comment '被合并患者Id集合',
  mergereason   varchar(255) comment '合并原因',
  mergeTime     datetime comment '合并时间',
  mergeresult   varchar(255) comment '合并结果',
  operator      bigint comment '操作人'
);

-- 患者联系人 2.4.3
alter table user_db.u_patient_family
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- alter table user_db.u_patient_family  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;
-- 医患关系 2.4.7
alter table user_db.r_doctor_patient
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

############################### ehr_db ##################################################
-- 病案首页 3.4.7
alter table ehr_db.ei_inhospital_note
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget,
  add column `oldinhospitalid` varchar(128) null after `mergeTime`;

-- 诊断信息 3.4.1
alter table ehr_db.e_diagnosis_info
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 治疗 3.4.6
alter table ehr_db.eci_treatment_note
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 手术 3.4.4
alter table ehr_db.eci_surgery_note
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 出院小结    3.5.10
alter table ehr_db.ei_outhospital_note
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 门诊患者  3.5.8
alter table ehr_db.ec_clinic_medical_note
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 检验报告单详情表 3.5.6
alter table ehr_db.eci_detection_detail
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 检验报告单 3.5.5
alter table ehr_db.eci_detection_report
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 检验报告单 3.5.7
alter table ehr_db.eci_exam_report
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;


############################### followup_db ##################################################
-- 电话发送记录 2.3.16
alter table followup_db.followup_call_req
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 短信发送记录 2.3.14
alter table followup_db.followup_sms_req
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 微信发送记录 2.3.13
alter table followup_db.followup_wx_req
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 调查问卷 2.3.22
alter table followup_db.questionnaire_result
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 随访result 2.3.10
alter table followup_db.followup_result
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget,
  add column `seq` int(3) null comment '优先级排序字段';

-- 随访buff 2.3.11
alter table followup_db.followup_result_buff
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 随访r_followup_task_patient 2.3.9
alter table followup_db.r_followup_task_patient
  add column `mergeFlag` int(2) default 0 COMMENT '合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）',
  add column `mergeFrom` bigint null COMMENT '被合并患者patientId' after `mergeFlag`,
  add column `mergeTarget` bigint null COMMENT '目标患者goalPatientId' after `mergeFrom`,
  add column `mergeTime` datetime null comment '合并时间' after mergeTarget;

-- 创建 followup_result_merge_bak 2.3.28
create table if not exists followup_db.followup_result_merge_bak
  select *
  from followup_db.followup_result
  where 1 = 0;

-- 创建 followup_result_buff_merge_bak 2.3.29
create table if not exists followup_db.followup_result_buff_merge_bak
  select *
  from followup_db.followup_result_buff
  where 1 = 0;

-- 创建 r_followup_task_patient_merge_bak 2.3.30
create table if not exists followup_db.r_followup_task_patient_merge_bak
  select *
  from followup_db.r_followup_task_patient
  where 1 = 0;

-- 创建 var_patient_followup_merge_bak 2.3.31
create table if not exists followup_db.var_patient_followup_merge_bak
  select *
  from followup_db.var_patient_followup
  where 1 = 0;
