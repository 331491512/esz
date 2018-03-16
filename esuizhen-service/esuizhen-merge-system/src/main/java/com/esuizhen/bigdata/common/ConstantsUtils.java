package com.esuizhen.bigdata.common;

/**
 * Created by fqc on 16/11/22.
 */
public final class ConstantsUtils {
    public static final String pkgController = "com.esuizhen.bigdata.controller.";

    //病案号、姓名、性别、出生日期、出生地、民族、国籍、地区、籍贯、身份证号
    //如上信息按合并的优先级关系取值；
    //即默认患者有信息取默认患者；默认患者信息为空时，取时间最近的补充；
    /**
     * 病案号 patientNo
     */
    // public static final String PATIENTNO = "PatientNo";
    /**
     * 姓名 trueName
     */
    public static final String TRUENAME = "TrueName";
    /**
     * 性别 sex
     */
    public static final String SEX = "Sex";
    /**
     * 出生日期 birthDate
     */
    public static final String BIRTHDATE = "BirthDate";
    /**
     * 出生地 birthPlaceAddress u_user表
     */
    public static final String BIRTHPLACEADDRESS = "BirthPlaceAddress";

    /**
     * 地区 birthPlaceCode u_user
     */
    public static final String BIRTHPLACECODE = "BirthPlaceCode";

    /**
     * 民族 nation user表
     */
    public static final String NATION = "Nation";

    /**
     * 国籍 country user table
     */
    public static final String COUNTRY = "Country";
    /**
     * 地区  city user table
     */
    public static final String CITY = "City";
    /**
     * 籍贯 nativePlace user
     */
    public static final String NATIVEPLACE = "NativePlace";
    /**
     * 身份证号 identification user
     */
    public static final String IDENTIFICATION = "Identification";

    //职业、婚姻状态
    //        取时间最近的患者信息进行补充
    /**
     * 职业 profession user <>由于该属性为String类型，目前再这组中合并不统一，先不予以考虑</>
     */
    public static final String PROFESSION = "Profession";
    /**
     * 职业编码
     */
    public static final String OCCUPATIONID = "OccupationId";
    /**
     * 婚姻状态 marriageStatus user
     */
    public static final String MARRIAGESTATUS = "MarriageStatus";

    //
    //失访状态、时间、原因
    //        取默认患者的失访状态
    /**
     * 随访状态 followupFlag
     */
    public static final String FOLLOWUPFLAG = "FollowupFlag";
    /**
     * 失访时间 lostFollowupTime
     */
    public static final String LOSTFOLLOWUPTIME = "LostFollowupTime";
    /**
     * 失访原因 lostFollowupCause
     */
    public static final String LOSTFOLLOWUPCAUSE = "LostFollowupCause";


    //死亡状态、时间及原因
    //重复患者中有死亡状态的，优先取死亡状态，
    //如有两条以上死亡状态的，取死亡随访结果中随访时间较早的死亡相关记录（死亡状态、随访时间、随访结果、死亡时间、死亡原因等数据）
    /**
     * 生存状态 liveStatus
     */
    public static final String LIVESTATUS = "LiveStatus";
    /**
     * 死亡时间 deathDate
     */
    public static final String DEATHDATE = "DeathDate";
    /**
     * 死亡原因 causeOfDeath
     */
    public static final String CAUSEOFDEATH = "CauseOfDeath";

    //
    //        联系人信息
    //将所有重复患者信息累加后去重
    //patientRelation` int(11) DEFAULT '0' COMMENT '与患者关系。\r\n0: 本人；(默认)\r\n1：家属\r\n',
    //        `familyName` varchar(100) DEFAULT NULL COMMENT '家属姓名',
    //        `familyPhone` varchar(100) DEFAULT NULL COMMENT '家属电话',
    /**
     * 与患者关系 patientRelation
     */
    public static final String PATIENTRELATION = "PatientRelation";
    /**
     * 家属姓名 familyName
     */
    public static final String FAMILYNAME = "FamilyName";
    /**
     * 家属电话 familyPhone
     */
    public static final String FAMILYPHONE = "FamilyPhone";

    //        住院信息
    //将所有住院信息累加，按时间顺序排列
    //
    //其他如主要诊断、第一原发、第二原发等内容，应在数据合并后重新按规则刷一遍。

}
