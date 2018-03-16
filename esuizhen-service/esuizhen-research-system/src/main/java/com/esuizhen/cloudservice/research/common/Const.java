package com.esuizhen.cloudservice.research.common;

/**
 * <p>Title:Const</p>
 * <p>Description:常量类</p>
 * @author YYCHEN
 * @date 2016年6月7日 上午11:27:23
 */
public final class Const {
	/**
	 * 专题状态
	 * 0：未开始
	 */
	public static final Integer PROJECT_STATE_NOTSTART = 0;
	/**
	 * 专题状态
	 * 1：未筛选患者
	 */
	public static final Integer PROJECT_STATE_NOTSCREENEDPATIENTS = 1;
	/**
	 * 专题状态
	 * 2：进行中（患者已入组）
	 */
	public static final Integer PROJECT_STATE_CARRIEDOUT = 2;
	/**
	 * 专题状态
	 * -1：已结束
	 */
	public static final Integer PROJECT_STATE_ENDED = -1;
	/**
	 * 专题状态
	 * -2：已终止（强行终止/取消）
	 */
	public static final Integer PROJECT_STATE_REVOKE = -2;
	
	/**
	 * CRF标题元素元数据
	 * T11(人口学信息)
	 */
	public static final String META_CRF_SUBJECT_ELEMENT_RKXXX = "T11";
	/**
	 * CRF标题元素元数据
	 * S2(诊断信息)
	 */
	public static final String META_CRF_SUBJECT_ELEMENT_ZDXX = "S2";
	
	/**
	 * 专题采集项是否已经采集过
	 * -1:禁止采集
	 */
	public static final Integer COLLECTFLAG_PROHIBIT = -1;
	/**
	 * 专题采集项是否已经采集过
	 * 0: 未采集
	 */
	public static final Integer COLLECTFLAG_NOT = 0;
	/**
	 * 专题采集项是否已经采集过
	 * 1：已采集
	 */
	public static final Integer COLLECTFLAG_ALREADY = 1;
}
