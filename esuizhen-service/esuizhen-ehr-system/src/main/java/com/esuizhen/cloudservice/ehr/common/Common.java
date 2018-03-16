package com.esuizhen.cloudservice.ehr.common;


/**
 * Title:Common
 * Description:静态变量列表
 * @Create_by:yuanwenming
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:1.0
 * 
 */
public class Common {
	//全局静态配置
    public final static String EXCEL_TEMPLATE_PATH = "config/excelExport";
    
    public final static String DIAGNOSIS_CARD_ID_PRE = "DICA";
    
    public final static String DIAGNOSIS_ID_PRE = "DIAG";
    
    public final static String ISSUED_ID_PRE = "ISSUE";
    
    /** 
     * 每个文件的最大行数 超过请求按默认算 
     */  
    public static final int MAX_ROWS = 50000;
    
    /**
     * 导出的文件名称
     */
    public static final String FILE_NAME = "advancedSearch";
    
    /**
     * 临时文件名称
     */
    public static final String TEMP_FILE_NAME = "excelTemp";
    
    /**
     * 导出文件目录
     */
    public static final String EXCEL_EXPORT = "excelExport";
    
    /**
     * 导出文件目录
     */
    public static final String INHOSPITAL_IMPORT_TEMPLATE_FILE = "inhospital.import.template.file";
    
    /**
     * 导出文件目录
     */
    public static final String INHOSPITAL_IMPORT_LOG_FILE = "inhospital.import.log.file";
    
    /**
     * 导出文件目录
     */
    public static final String IMPORT_LOG = "/var/logs/importLog/";
}
