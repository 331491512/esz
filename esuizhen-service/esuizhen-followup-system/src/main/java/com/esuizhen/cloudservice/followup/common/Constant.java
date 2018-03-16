/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.common;<br/>  
 * <b>文件名：</b>Constant.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年2月4日下午3:05:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.common;

/**
 * @ClassName: Constant
 * @Description:
 * @author lichenghao
 * @date 2016年2月4日 下午3:05:01
 */
public final class Constant {
	public final static class DAILY {

		// 新增患者激活统计
		public final static String DATATYPE_NAP = "NAP";

		// 新增患者病种统计
		public final static String DATATYPE_NAD = "NAD";

		// 访结果统计（按随访方式）
		public final static String DATATYPE_FRW = "FRW";

		// 访结果统计（按随访方式）
		public final static String DATATYPE_FRT = "FRT";

		// 访结果统计（按随访时间）
		public final static String DATATYPE_FRD = "FRD";

	}

	public final static class FOLLOWUPWAY {
		// 随访方式：微信
		public final static int FOLLOWUPWAY_WX = 4;

		// 随访方式：医生App
		public final static int FOLLOWUPWAY_APP = 3;

		// 随访方式：短信
		public final static int FOLLOWUPWAY_SMS = 1;

		// 随访方式：电话
		public final static int FOLLOWUPWAY_PHONE = 2;
	}

	/**
     * 导出文件目录
     */
    public static final String EXCEL_EXPORT = "excelExport";
    /**
     * csv文件名称
     */
    public static final String FOLLOW_PATIENT_FILE_NAME = "followuptaskdetail";
    /**
     * 临时文件名称
     */
    public static final String TEMP_FILE_NAME = "excelTemp";
    
    /**
     * 批量病案号条数
     */
    public static final Integer BATCH_PATIENTNO = 2000;
}
