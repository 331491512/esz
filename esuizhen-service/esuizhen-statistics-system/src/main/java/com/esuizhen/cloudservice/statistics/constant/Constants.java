/**
 * 系统项目名称
 * com.suifang.commons
 * Constants.java
 * 
 * 2016年5月11日-下午7:27:54
 * Administrator
 */
package com.esuizhen.cloudservice.statistics.constant;

/**
 *
 * Constants
 * 
 * 2016年5月11日 下午7:27:54
 * 
 * @version 1.0.0
 *
 */
public class Constants {
	
	/** 
     * 每个文件的最大行数 超过请求按默认算 
     */  
    public static final int MAX_ROWS = 30000;
    
    /**
     * 临时文件名称
     */
    public static final String TEMP_FILE_NAME = "excelTemp";
    
    /**
     * 导出文件目录
     */
    public static final String EXCEL_EXPORT = "excelExport";
    
	public final static class PatientStatistics {
		public static final String TOTAL = "total"; // 患者总数
		public static final String TUMOR = "tumor"; // 肿瘤患者总数
		public static final String TASK = "task"; // 任务患者总数
		public static final String LOST_FOLLOWUP = "lostFollowup"; // 失访患者总数
		public static final String SIMILAR = "similar"; // 疑似重复患者总数
		public static final String FAULT = "fault"; // 错误患者总数
		
		/** 263 新增 add by yuanwenming */
		/**
		 * 肿瘤性质分布
		 */
		public static final String TUMOR_STATUS = "tumorStatus";
		/**
		 * 肿瘤部位统计
		 */
		public static final String TUMOR_PART = "tumourPart";
		/**
		 * 肿瘤病种统计
		 */
		public static final String DISEASE_TYPE = "diseaseType";
		/**
		 * 科室统计
		 */
		public static final String DEPARTMENT = "department";
		/**
		 * 地区统计
		 */
		public static final String AREA = "area";
		/**
		 * 年龄统计
		 */
		public static final String AGE = "age";
		/**
		 * 性别统计
		 */
		public static final String SEX = "sex";

	}
	
	/**
	 * 编目员角色
	 */
	public static final int CATALOG_ADMIN_ROLE = 55;
}
