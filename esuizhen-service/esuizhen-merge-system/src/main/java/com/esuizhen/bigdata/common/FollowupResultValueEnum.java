package com.esuizhen.bigdata.common;

/**
 * Created by fqc on 17/1/6.
 * 随访结果优先级枚举定义((`followupTaskId`,`patientId`) unique 特指的患者任务)
 * <p>
 * <p>
 * /**
 * prd描述
 * 一、患者随访完成状态
 * 1、已完成（有效结果，死亡11>转移12>复发13>稳定14>住院生存15>门诊生存16>好转17）
 * 2、已完成（无效结果）指随访中结果为主动拒接21、无人接听22、无法接通 23、关机24、停机25、拒绝随访26、错号27、空号28
 * 3、暂存
 * 4、未完成
 * 二、随访时间最近；
 * 注：
 * 有效结果：指随访中结果为稳定、复发、转移、死亡、门诊生存、住院生存、好转 ；
 * <p>
 * 无效结果：指随访中结果为主动拒接21、无人接听22、无法接通 23、关机24、停机25、拒绝随访26、错号27、空号28； （无效结果：指随访中结果为无人接听、主动拒接、无法接通、关机、停机、错号、空号、拒绝随访；）
 * <p>
 * 随访结果为“其他情况”时，根据全局开关中“随访结果统计全局设置”开关判断是否为有效结果；
 * “其它情况” 19 或 29
 * <p>
 * 随访任务状态 随访结果
 * 随访时间
 * <p>
 * 保留的是{taskId,patientId} ，之后该追加或更新到目标患者
 * 随访结果也是使用改投票就好了
 */

public enum FollowupResultValueEnum {
    DEATH("死亡", 11),
    METASTASIZE("转移", 12),
    RECURRENCE("复发", 13),
    STABILIZATION("稳定", 14),
    IN_HOSPITAL_LIVE("住院生存", 15),
    DEPARTMENT_LIVE("门诊生存", 16),
    TURN_BETTER("好转", 17),

    REJECT_A_CALL("主动拒接", 21),
    NO_ANSWER("无人接听", 22),
    NOT_AVAILABLE("无法接通", 23),
    POWER_OFF("关机", 24),
    OUT_OF_SERVICE("停机", 25),
    REJECT_FOLLOWUP("拒绝随访", 26),
    WRONG_NUMBER("错号", 27),
    NO_LONGER_IN_SERVICE("空号", 28),

    //这里在计算的时候动态判断最好了
    OTHER_SITUATION_WITH_ENABLE("其它情况", 19),
    OTHER_SITUATION_WITH_UNABLE("其它情况", 29);

    private String name;
    private Integer level;

    private FollowupResultValueEnum(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public static String getName(Integer level) {
        for (FollowupResultValueEnum c : FollowupResultValueEnum.values()) {
            if (c.getLevel() == level) {
                return c.name;
            }
        }
        return null;
    }

    public static Integer getLevel(String name) {
        for (FollowupResultValueEnum c : FollowupResultValueEnum.values()) {
            if (c.getName() == name) {
                return c.level;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public static void main(String[] args) {
        System.out.println(FollowupResultValueEnum.getLevel(FollowupResultValueEnum.DEATH.getName()));
        System.out.println(FollowupResultValueEnum.DEATH);
        System.out.println(FollowupResultValueEnum.DEATH.getName());
        System.out.println(FollowupResultValueEnum.OTHER_SITUATION_WITH_ENABLE.getLevel());
        System.out.println(FollowupResultValueEnum.OTHER_SITUATION_WITH_UNABLE.getLevel());
    }
}
