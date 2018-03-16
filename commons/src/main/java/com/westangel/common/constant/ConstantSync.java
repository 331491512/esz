package com.westangel.common.constant;

/**
 * 常量实体 管理系统中用到的常量数据
 * 
 * @author YYCHEN
 *
 */
public final class ConstantSync {
	public static final class TableId{
		public static final int USER=100;
		public static final int DOCTOR=101;
		public static final int PATIENT=102;
		public static final int CONTACT=103;
		public static final int UUID_PATIENTNO=104;
		public static final int R_DOCTOR_PATIENT=105;
		public static final int R_HOSPITAL_DOCTOR=106;
		public static final int R_HOSPITAL_PATIENT=107;
		public static final int R_DEPT_PATIENT=108;
		public static final int INHOSPITAL=200;
		public static final int OUTHOSPITAL=201;
		public static final int DIAGNOSIS=202;
		public static final int CLINIC_MEDICAL=203;
		public static final int SURGERY=204;
		public static final int TREATMENT=205;
		public static final int DETETION_REPORT=300;
		public static final int DETETION_DETAIL=301;
		public static final int EXAM_REPROT=302;
		public static final int FOLLOWUP_RESULT=400;
		public static final int FOLLOWUP_RESULT_BUFF=401;
	}
	public static enum Sync_Table {
		// user
		USER(100, "USER"),
		DOCTOR(101, "DOCTOR"),
		PATIENT(102, "PATIENT"),
		CONTACT(103, "CONTACT"),
		UUID_PATIENTNO(104, "UUIDPATIENTNO"),
		R_DOCTOR_PATIENT(105, "RDOCTORPATIENT"),
		R_HOSPITAL_DOCTOR(106, "RHOSPITALDOCTOR"),
		R_HOSPITAL_PATIENT(107, "RHOSPITALPATIENT"),
		R_DEPT_PATIENT(108, "RDEPTPATIENT"),
		// ehr
		INHOSPITAL(200, "INHOSPITAL"),
		OUTHOSPITAL(201, "OUTHOSPITAL"),
		DIAGNOSIS(202, "DIAGNOSIS"),
		CLINIC_MEDICAL(203, "CLINICMEDICAL"),
		SURGERY(204, "SURGERY"),
		TREATMENT(205, "TREATMENT"),
		// lis/pacs
		DETETION_REPORT(300, "DETETIONREPORT"),
		DETETION_DETAIL(301, "DETETIONDETAIL"),
		EXAM_REPROT(302, "EXAMREPORT"),
		// followup
		FOLLOWUP_RESULT(400, "FOLLOWUPRESULT"),
		FOLLOWUP_RESULT_BUFF(401, "FOLLOWUPRESULTBUFF"),;		
		/**
		 * 编号
		 */
		public Integer id;

		/**
		 * 提示信息
		 */
		public String code;
		
		Sync_Table(Integer id, String code) 
		{
			this.code = code;
			this.id = id;

		}
		
		static public Sync_Table getInfoViaId(Integer id)
		{
			for (Sync_Table msg:values()){
				if (msg.id.equals(id)) {
					return msg;
				}
			}
			return null;
		}
		
		static public Sync_Table getInfoViaCode(String code)
		{
			for (Sync_Table msg:values()){
				if (msg.code.equals(code)) {
					return msg;
				}
			}
			return null;
		}
	}

	public final static class SYNCFLAG {
		/**
		 * 已经合并 -3
		 */
		public static final int MERGER_OK = -3;
		/**
		 * 患者服务端不存在 -2
		 */
		public static final int NOT_IN_SERVER = -2;
		/**
		 * 同步时服务端错误 -1
		 */
		public static final int SERVER_ERROR = -1;
		/**
		 * 未同步 0
		 */
		public static final int SYNC_NO = 0;
		/**
		 * 同步成功 1
		 */
		public static final int SYNC_OK = 1;
		/**
		 * 待更新 2
		 */
		public static final int SYNC_UPDATE = 2;
		/**
		 * 待合并 3
		 */
		public static final int SYNC_MERGER_WAIT = 3;
		/**
		 * 待同步 9
		 */
		public static final int SYNC_WAIT = 9;
	}

	public final static class BatchState {
		/**
		 * -3：同步处理错误 
		 */
		public static final int SYNC_ERROR = -3;
		/**
		 *  0：初始化（默认）
		 */
		public static final int SYNC_INIT = 0;
		/**
		 *  1：推送开始 
		 */
		public static final int PUSH_START = 1;
		/**
		 * 2：推送结束 
		 */
		public static final int PUSH_END = 2;
		/**
		 * 3：处理中 
		 */
		public static final int DATA_HADLE = 3;
		/**
		 * 4：同步结果待返回 
		 */
		public static final int SYNC_RESULT = 4;
		/**
		 * 5：同步完成
		 */
		public static final int SYNC_OK = 5;
	}
	
	/**
	 * 身份证
	 */
	public static final int MATCH_TYPE_IDENTIFICATION = 1;
	/**
	 * 手机号
	 */
	public static final int MATCH_TYPE_MOBILE = 2;
	
	public static boolean checkTableIdCode(Integer tableId,String tableCode){
		return tableId.equals(ConstantSync.Sync_Table.getInfoViaCode(tableCode).id);
	}

}
