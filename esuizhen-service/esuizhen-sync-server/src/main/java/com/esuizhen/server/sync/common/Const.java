package com.esuizhen.server.sync.common;

/**
 * 
 * @author YYCHEN
 *
 */
public final class Const {
	/**
	 * 新增
	 */
	public static final Integer OPFLAG_ADD = 0;
	/**
	 * 修改
	 */
	public static final Integer OPFLAG_EDIT = 1;
	
	/**
	 * 合并医生时使用的唯一码前缀
	 */
	public static final String SYNCDOCTOR = "SYNC-DOCTOR";
	/**
	 * 合并患者时使用的唯一码前缀
	 */
	public static final String SYNCPATIENT = "SYNC-PATIENT";
	
	/**
	 * 是否通知了用户
	 * 未通知
	 * 0
	 */
	public static final Integer PUSHFLAG_NO = 0;
	/**
	 * 是否通知了用户
	 * 已通知
	 * 1
	 */
	public static final Integer PUSHFLAG_YES = 1;
	
	/**
	 * 治疗
	 * 治疗类型
	 * 1
	 */
	public static final Integer ECITREATMENTNOTE_TREATMENTTYPEId = 1;
	/**
	 * 治疗
	 * 治疗类型名称
	 * 手术
	 */
	public static final String ECITREATMENTNOTE_TREATMENTTYPENAME = "手术";
	
	/**
	 * 治疗状态
	 * 是否完成治疗
	 * 2：已完成
	 */
	public static final Integer TREATMENTPROCESSFLAG_FINISHED = 2;
	
	/**
	 * 住院次数
	 * 1:默认第一次住院
	 */
	public static final Integer INHOSPITALTIMES_FIRST = 1;
}
