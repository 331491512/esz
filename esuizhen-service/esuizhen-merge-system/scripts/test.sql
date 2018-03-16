SELECT *
FROM u_patient a
WHERE a.patientId IN ('392606', '425728', '427454');

SELECT *
FROM uuid_patient_merge a
WHERE a.goalpatientid = '392606';

SELECT *
FROM u_user a
WHERE a.patientNo IN ('0000228564', '0000349236', '0000351037');


SELECT
  createTime,
  updateTime,
  rawCreateTime
FROM u_patient
ORDER BY updateTime DESC;

-- 查看疑似重复组
SELECT
  a.goalpatientid,
  count(a.patientid) cn,
  GROUP_CONCAT(a.patientid)
FROM uuid_patient_merge a
WHERE a.repeatflag = 1
GROUP BY a.goalpatientid
HAVING cn > 2
ORDER BY a.goalpatientid;

# init 261merge database
CREATE DATABASE `user_db_261_merge`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
CREATE DATABASE `ehr_db_261_merge`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
CREATE DATABASE `followup_db_261_merge`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;


SELECT *
FROM user_db.u_patient a
WHERE a.patientId IN (416179, 467612, 394765);


SELECT *
FROM user_db.u_patient_merge_bak a
WHERE a.patientid = 394765;

-- 查询联系人
SELECT
  upatientfa0_.id                AS id1_160_,
  upatientfa0_.address           AS address2_160_,
  upatientfa0_.createTime        AS createTi3_160_,
  upatientfa0_.familyName        AS familyNa4_160_,
  upatientfa0_.familyPhone       AS familyPh5_160_,
  upatientfa0_.flag              AS flag6_160_,
  upatientfa0_.isDefault         AS isDefaul7_160_,
  upatientfa0_.isValid           AS isValid8_160_,
  upatientfa0_.mergeFlag         AS mergeFla9_160_,
  upatientfa0_.mergeFrom         AS mergeFr10_160_,
  upatientfa0_.mergeTarget       AS mergeTa11_160_,
  upatientfa0_.mergeTime         AS mergeTi12_160_,
  upatientfa0_.oldContactAddress AS oldCont13_160_,
  upatientfa0_.patientId         AS patient14_160_,
  upatientfa0_.patientRelation   AS patient15_160_,
  upatientfa0_.patientType       AS patient16_160_,
  upatientfa0_.rawCreateTime     AS rawCrea17_160_,
  upatientfa0_.remark            AS remark18_160_,
  upatientfa0_.updateTime        AS updateT19_160_,
  upatientfa0_.zipcode           AS zipcode20_160_
FROM u_patient_family upatientfa0_
WHERE upatientfa0_.patientId IN ( 385146, 385712,419040);

INSERT INTO u_patient_family (address, createTime, familyName, familyPhone, flag, isDefault, isValid, mergeFlag, mergeFrom, mergeTarget, mergeTime, oldContactAddress, patientId, patientRelation, patientType, rawCreateTime, remark, updateTime, zipcode)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

select * from u_patient_