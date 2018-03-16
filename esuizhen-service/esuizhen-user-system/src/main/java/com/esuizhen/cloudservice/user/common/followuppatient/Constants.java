/**
 * 系统项目名称
 * com.suifang.commons
 * Constants.java
 * 
 * 2016年5月11日-下午7:27:54
 * Administrator
 */
package com.esuizhen.cloudservice.user.common.followuppatient;

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
	public static final int EXPORT_TYPE_1 = 1;//按患者
	public static final int EXPORT_TYPE_2 = 2;//按病案
	
	/** 
     * 每个文件的最大行数 超过请求按默认算 
     */  
    public static final int MAX_ROWS = 30000;
    
    /**
     * 导出的文件名称
     */
    public static final String FILE_NAME = "fastStatisticsPatient";
    
    /**
     * 随访患者导出文件名（包括所有患者、待随访患者、已经随访患者都用这一个文件名）
     */
    public static final String FOLLOW_PATIENT_FILE_NAME = "followPatientList";
    /**
     * add by fanpanwei 随访表
     */
    public static final String FOLLOW_TABLE_FILE_NAME = "followTableList";
    /**
     * 临时文件名称
     */
    public static final String TEMP_FILE_NAME = "excelTemp";
    
    /**
     * 导出文件目录
     */
    public static final String EXCEL_EXPORT = "excelExport";
    
    /**
     * excel模板路径
     */
    public final static String EXCEL_TEMPLATE_PATH = "config/config";
    
    /**
     * 1-所有患者总数标示
     */
    public static final int TOTAL_NUM_FLAG = 1;
    /**
     * 2-失访患者标示
     */
    public static final int LOST_FOLLOWUP_NUM_FLAG = 2;
    /**
     * 3-疑似重复患者标示
     */
    public static final int SIMILAR_NUM_FLAG = 3;
    /**
     * 4-核心数据缺失/疑似错误患者总数标示
     */
    public static final int FAULT_NUM_FLAG = 4;
    
    /** 
     * 首次查询最大行数
     */  
    public static final int SEARCH_MAX_ROWS = 50000;
    
    /** 
     * 病案编目管理员角色
     */  
    public static final int CATALOG_ADMIN_ROLE = 55;
}
