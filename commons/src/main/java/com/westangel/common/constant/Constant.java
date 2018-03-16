package com.westangel.common.constant;

/**
 * 常量实体
 * 管理系统中用到的常量数据
 * @author YYCHEN
 *
 */
public final class Constant {
	/**
	 * 性别(未知)
	 */
	public final static Integer SEX_UNKNOWN = 0;
	/**
	 * 性别(男性)
	 */
	public final static Integer SEX_MAN = 1;
	/**
	 * 性别(女性)
	 */
	public final static Integer SEX_WOMAN = 2;
	
	/**
	 * 证件类型（身份证）
	 */
	public final static Integer IDTYPE_ID = 1;
	/**
	 * 证件类型（护照）
	 */
	public final static Integer IDTYPE_PASSPORT = 2;
	/**
	 * 证件类型（军官证）
	 */
	public final static Integer IDTYPE_OFFICER = 3;
	
	/**
	 * 未同步（默认）
	 */
	public static final Integer SYNC_NO = 0;
	/**
	 * 已同步（当同步成功之后设置）
	 */
	public static final Integer SYNC_OK = 1;
	
	/**
	 * 婚姻(未婚)
	 */
	public static final Integer MARRIAGESTATUS_UNMARRIED = 1;
	/**
	 * 婚姻(已婚)
	 */
	public static final Integer MARRIAGESTATUS_MARRIED = 2;
	/**
	 * 婚姻(丧偶)
	 */
	public static final Integer MARRIAGESTATUS_WIDOWED = 3;
	/**
	 * 婚姻(离婚)
	 */
	public static final Integer MARRIAGESTATUS_DIVORCE = 4;
	/**
	 * 婚姻(其他)
	 */
	public static final Integer MARRIAGESTATUS_OTHER = 9;
	
	/**
	 * 设备类型（安卓设备）
	 */
	public static final Integer DEVICETYPE_ANDROID = 3;
	/**
	 * 设备类型（苹果设备）
	 */
	public static final Integer DEVICETYPE_IOS = 4;
	
	/**
	 * 文化程度（文盲）
	 */
	public static final Integer EDUCATION_ILLITERACY = 0;
	/**
	 * 文化程度（小学）
	 */
	public static final Integer EDUCATION_PRIMARY = 1;
	/**
	 * 文化程度（初中）
	 */
	public static final Integer EDUCATION_MIDDLE = 2;
	/**
	 * 文化程度（高中）
	 */
	public static final Integer EDUCATION_HIGH = 3;
	/**
	 * 文化程度（大专）
	 */
	public static final Integer EDUCATION_JUNIOR = 4;
	/**
	 * 文化程度（硕士研究生）
	 */
	public static final Integer EDUCATION_MASTER = 5;
	/**
	 * 文化程度（博士研究生）
	 */
	public static final Integer EDUCATION_DOCTOR = 6;
	
	/**
	 * 血型（A型血）
	 */
	public static final String BLOODTYPE_A = "A";
	/**
	 * 血型（B型血）
	 */
	public static final String BLOODTYPE_B = "B";
	/**
	 * 血型（AB型血）
	 */
	public static final String BLOODTYPE_AB = "AB";
	/**
	 * 血型（O型血）
	 */
	public static final String BLOODTYPE_O = "O";
	/**
	 * 一般肿瘤 标签ID
	 */
	public static final Integer TAGID=99999;
	
	/**
	 * 用户相关的常量
	 * @author YYCHEN
	 *
	 */
	public final static class User{
		/**
		 * 游客ID
		 * 1
		 */
		public static final Long TOURIST_ID = 1L;
		
		/**
		 * APP注册用户标识
		 * 0:否（默认）
		 */
		public static final Integer APPFLAG_NO = 0;
		/**
		 * APP注册用户标识
		 * 1:是
		 */
		public static final Integer APPFLAG_YES = 1;
		
		/**
		 * 微信用户标识
		 * 0：否(默认)
		 */
		public static final Integer WEIXINFLAG_NO = 0;
		/**
		 * 微信用户标识
		 * 1：是
		 */
		public static final Integer WEIXINFLAG_YES = 1;
		
		/**
		 * PC注册用户标识
		 * 0：否(默认)
		 */
		public static final Integer PCFLAG_NO = 0;
		/**
		 * PC注册用户标识
		 * 1：是
		 */
		public static final Integer PCFLAG_YES = 1;
		
		/**
		 * 用户状态
		 * 正常 1
		 */
		public static final Integer USERSTATE_NORMAL = 1;
		/**
		 * 用户状态
		 * 系统锁定或注销
		 * <锁定后的用户不可登录，需要申请解锁才能登录>
		 * -2
		 */
		public static final Integer USERSTATE_LOCKED = -2;
		
		/**
		 * 云端和ToB数据同步标志
		 * 未同步
		 */
		public static final Integer SYNCFLAG_NO = 0;
		/**
		 * 云端和ToB数据同步标志
		 * 已同步
		 * 1
		 */
		public static final Integer SYNCFLAG_YES = 1;
		/**
		 * 云端和ToB数据同步标志
		 * 更新操作
		 * 2
		 */
		public static final Integer SYNCFLAG_UPDATE = 2;
		
		/**
		 * 云端和ToB数据同步标志
		 * 更新
		 * 3
		 */
		public static final Integer SYNCFLAG_MERGER = 3;

		/**
		 * 同步失败（不再重试）
		 * -1
		 */
		public static final Integer SYNCFLAG_FIRSTFAIL=-1;

		/**
		 * 同步失败（下次需要重试）
		 * -2
		 */
		public static final Integer SYNCFLAG_SECONDFAIL=-2;
		
		/**
		 * 证件类型
		 * 身份证（缺省）
		 * 1
		 */
		public static final Integer IDTYPE_ID = 1;
		/**
		 * 证件类型
		 * 军官证
		 * 2
		 */
		public static final Integer IDTYPE_OFFICERS = 2;
		/**
		 * 证件类型
		 * 护照
		 * 3
		 */
		public static final Integer IDTYPE_PASSPORT = 3;
		
		/**
		 * 用户登陆方式（验证码）
		 * 1
		 */
		public static final Integer LOGINTYPE_AUTHCODE = 1;
		/**
		 * 用户登陆方式（密码）
		 * 2
		 */
		public static final Integer LOGINTYPE_PASSWORD = 2;
		
		/**
		 * 用户角色(患者身份)
		 * 1
		 */
		public static final Integer ROLE_PATIENT = 1;
		/**
		 * 用户角色(医生身份)
		 * 2
		 */
		public static final Integer ROLE_DOCTOR = 2;
		/**
		 * 用户角色(医生+患者身份)
		 * 3
		 */
		public static final Integer ROLE_DOCTORANDPATIENT = 3;
		/**
		 * 用户角色(医患/科室身份)
		 * 4
		 */
		public static final Integer ROLE_HOSPITALORDEPT = 4;
		/**
		 * 用户角色(系统)
		 * 0
		 */
		public static final Integer ROLE_SYSTEM = 0;

		/**
		 * 用户账号类型
		 * 用户拒绝确认的身份
		 * -2
		 */
		public static final Integer ACCOUNTTYPE_REFUSE = -2;
		/**
		 * 用户账号类型
		 * (未激活的临时用户（无手机号）)
		 * -1
		 */
		public static final Integer ACCOUNTTYPE_TEMPORARY = -1;
		/**
		 * 用户账号类型
		 * (未激活的被动用户（有手机号。对于此类用户患者，医生可以给其发短信通知激活）)
		 * 0
		 */
		public static final Integer ACCOUNTTYPE_NONACTIVATED = 0;
		/**
		 * 用户账号类型
		 * (微信注册用户)
		 * 1
		 */
		public static final Integer ACCOUNTTYPE_WEIXIN = 1;
		/**
		 * 用户账号类型
		 * (微信注册且绑定了手机的用户)
		 * 2
		 */
		public static final Integer ACCOUNTTYPE_WEIXINBINDPHONE = 2;
		/**
		 * 用户账号类型
		 * (App手机注册用户)
		 * 3
		 */
		public static final Integer ACCOUNTTYPE_APP = 3;
		/**
		 * 用户账号类型
		 * 首次PC注册用户(邮箱或手机)
		 * 4
		 */
		public static final Integer ACCOUNTTYPE_APPANDPHONE = 4;
		
		/**
		 * 用户信息填写状态（未完善个人信息）
		 */
		public static final Integer INFOSTATE_NOTPERFECT = 0;
		/**
		 * 用户信息填写状态
		 * （已完善基本信息（如：患者完善了疾病信息；医生完善了医院和科室信息（初级审核)））
		 */
		public static final Integer INFOSTATE_PRIMARY = 1;
		/**
		 * 用户信息填写状态（完成实名认证或审核（如患者完成了实名认证；医生完成了高级审核)）
		 */
		public static final Integer INFOSTATE_REALNAME = 2;
		
		/**
		 * 用户来源标志
		 * 未知
		 * 0
		 */
		public static final Integer USERSOURCEFLAG_UNKNOWN = 0;
		/**
		 * 用户来源标志
		 * 扫码
		 * 1
		 */
		public static final Integer USERSOURCEFLAG_SCANCODE = 1;
		/**
		 * 用户来源标志
		 * 微信
		 * 2
		 */
		public static final Integer USERSOURCEFLAG_WEIXIN = 2;
		/**
		 * 用户来源标志
		 * 医院同步
		 * 3
		 */
		public static final Integer USERSOURCEFLAG_HOSPITAIL = 3;
		/**
		 * 用户来源标志
		 * 医生创建
		 * 4
		 */
		public static final Integer USERSOURCEFLAG_DOCTOR = 4;
		/**
		 * 用户来源标志
		 * 扫描医院二维码
		 * 5
		 */
		public static final Integer USERSOURCEFLAG_HOSPITAL_QRCODE = 5;
		
		/**
		 * 第三方账号类型
		 * qq
		 */
		public static final Integer THIRDPARTYTYPE_QQ = 1;
		/**
		 * 第三方账号类型
		 * 微信
		 */
		public static final Integer THIRDPARTYTYPE_WEIXIN = 2;
		/**
		 * 第三方账号类型
		 * 新浪微博账号
		 */
		public static final Integer THIRDPARTYTYPE_sina = 3;
		
		/**
		 * 注册标志
		 * 已注册
		 */
		public static final Integer REGISTERFLAG_ALEARDYREGISTER = 1;
		/**
		 * 注册标志
		 * 首次注册
		 */
		public static final Integer REGISTERFLAG_FIRSTREGISTER = 0;
		
		/**
		 * 与患者关系
		 * 本人
		 */
		public static final Integer PATIENTRELATION_ONESELF = 0;
		/**
		 * 与患者关系
		 * 亲属
		 */
		public static final Integer PATIENTRELATION_RELATIVE = 1;
		/**
		 * 与患者关系
		 * 子
		 */
		public static final Integer PATIENTRELATION_SON = 2;
		/**
		 * 与患者关系
		 * 女儿
		 */
		public static final Integer PATIENTRELATION_DAUGHTER = 3;
		/**
		 * 与患者关系
		 * 孙子
		 */
		public static final Integer PATIENTRELATION_GRANDSON = 4;
		/**
		 * 与患者关系
		 * 父母
		 */
		public static final Integer PATIENTRELATION_PARENT = 5;
		/**
		 * 与患者关系
		 * 祖父母
		 */
		public static final Integer PATIENTRELATION_GRANDPARENTS = 6;
		/**
		 * 与患者关系
		 * 兄弟姐妹
		 */
		public static final Integer PATIENTRELATION_SIBLINGS = 7;
		/**
		 * 与患者关系
		 * 家属统称
		 */
		public static final Integer PATIENTRELATION_FAMILIES = 8;
		/**
		 * 与患者关系
		 * 其他
		 */
		public static final Integer PATIENTRELATION_OTHER = 9;
		
		/**
		 * 生存状态
		 * 健在
		 * 1(默认)
		 */
		public static final Integer LIVESTATUS_ALIVE = 1;
		/**
		 * 生存状态
		 * 死亡
		 */
		public static final Integer LIVESTATUS_DEATH = 0;
		
		/**
		 * 此患者有病历生成，且医生和患者自己可见
		 * 没有
		 */
		public static final Integer HASVISIBLEMEDICALRECORD_NO = 0;
		/**
		 * 此患者有病历生成，且医生和患者自己可见
		 * 有
		 */
		public static final Integer HASVISIBLEMEDICALRECORD_YES = 1;
		
		/**
		 * 是否专家出诊（否）
		 */
		public static final Integer ISEXPERT_NO = 0;
		/**
		 * 是否专家出诊（是）
		 */
		public static final Integer ISEXPERT_YES = 1;
		
		/**
		 * 医生审核状态
		 * 未审核(默认）
		 */
		public static final Integer AUDITSTATE_NOT = 0;

		/**
		 * 医生审核状态
		 * 用户拒绝的账号
		 * -2
		 */
		public static final Integer AUDITSTATE_DISAGREE = -2;
		/**
		 * 医生审核状态
		 * 临时账号
		 * -1
		 */
		public static final Integer AUDITSTATE_TEMP = -1;
		/**
		 * 医生审核状态
		 * 未激活的被动用户
		 * 0
		 */
		public static final Integer AUDITSTATE_UNKNOWN = 0;
		/**
		 * 医生审核状态
		 * 初级待审核
		 * 1
		 */
		public static final Integer AUDITSTATE_PRIMARYPENDING = 1;
		/**
		 * 医生审核状态
		 * 初级审核通过
		 * 2
		 */
		public static final Integer AUDITSTATE_PRIMARYPASS = 2;
		/**
		 * 医生审核状态
		 * 高级待审核
		 * 3
		 */
		public static final Integer AUDITSTATE_SENIOR = 3;
		/**
		 * 医生审核状态
		 * 高级审核通过
		 * 4
		 */
		public static final Integer AUDITSTATE_ADVANCEDPASS = 4;
		
		/**
		 * 0
		 * 可见标识
		 * 任何人不可见
		 */
		public static final Integer VISIBLEFLAG_NOBODY = 0;
		/**
		 * 1
		 * 可见标识
		 * 部分可见（患者、上传医生和所关注医生可见）（默认）
		 */
		public static final Integer VISIBLEFLAG_PART = 1;
		/**
		 * 2
		 * 可见标识
		 * 患者可见（患者和上传医生可见）
		 */
		public static final Integer VISIBLEFLAG_PATIENT = 2;
		/**
		 * 3
		 * 可见标识
		 * 私密(仅上传医生可见)
		 */
		public static final Integer VISIBLEFLAG_DOCTOR = 3;
		/**
		 * 4
		 * 可见标识
		 * 患者和仅本医院的关注医生可见(要根据本记录hospitalId判断)
		 */
		public static final Integer VISIBLEFLAG_HOSPITAL = 4;
		
		/**
		 * 系统内部用户userId-随诊助手(代表患者）
		 * 
		 */
		public static final Long SuizhenAssist = 2L;
		
		
		/**
		 * 系统内部用户userId-易随诊平台(代表医生和平台）
		 * 
		 */
		public static final Long SuizhenSys = 9L;
		
		/**
		 * 读取标识
		 * 0：未读（默认）
		 */
		public static final Integer READFLAG_NO = 0;
		/**
		 * 读取标识
		 * 1：已读
		 */
		public static final Integer READFLAG_YES = 1;
	}
	
	/**
	 * 病例系统常量值
	 * @author YYCHEN
	 *
	 */
	public static final class Ehr{
		/**
		 * 病例类型
		 * 门（急）诊诊疗记录病历
		 * 1
		 */
		public static final Integer EMRTYPE_EMERGENCY = 1;
		/**
		 * 病例类型
		 * 住院病历
		 * 2
		 */
		public static final Integer EMRTYPE_HOSPITALIZATION = 2;
		/**
		 * 病例类型
		 * 健康体检记录病历
		 * 3
		 */
		public static final Integer EMRTYPE_PHYSICALEXAMINATION = 3;
		/**
		 * 病例类型
		 * 转诊（院）记录病历
		 * 4
		 */
		public static final Integer EMRTYPE_REFERRAL = 4;
		/**
		 * 病例类型
		 * 法定医学证明和报告病历
		 * 5
		 */
		public static final Integer EMRTYPE_LEGALMEDICAL = 5;
		/**
		 * 病例类型
		 * 其他病历
		 * 9
		 */
		public static final Integer EMRTYPE_OTHER = 9;
		
		/**
		 * 病历子类型
		 * 未知
		 * 0
		 */
		public static final Integer EMRSUBTYPE_UNKNOWN = 0;
		/**
		 * 病历子类型
		 * 检查单
		 * 1
		 */
		public static final Integer EMRSUBTYPE_CHECK = 1;
		/**
		 * 病历子类型
		 * 化验单
		 * 2
		 */
		public static final Integer EMRSUBTYPE_LABORATORY = 2;
		/**
		 * 病历子类型
		 * 治疗处置记录
		 * 4
		 */
		public static final Integer EMRSUBTYPE_TREATMENT = 4;
		/**
		 * 病历子类型
		 * 手术单
		 * 5
		 */
		public static final Integer EMRSUBTYPE_OPERATION = 5;
		/**
		 * 病历子类型
		 * 诊断报告
		 * 9
		 */
		public static final Integer EMRSUBTYPE_DIAGNOSIS = 9;
		/**
		 * 病历子类型
		 * 门（急）诊病历
		 * 11
		 */
		public static final Integer EMRSUBTYPE_EMERGENCY = 11;
		/**
		 * 病历子类型
		 * 住院病案首页（住院基本信息）
		 * 21
		 */
		public static final Integer EMRSUBTYPE_HOSPITALIZATION = 21;
		/**
		 * 病历子类型
		 * 出院记录
		 * 21
		 */
		public static final Integer EMRSUBTYPE_OUTHOSPITAL = 23;
		/**
		 * 病历子类型
		 * 死亡医学证明
		 * 52
		 */
		public static final Integer EMRSUBTYPE_DEATHREPORT = 52;
		
		/**
		 * 结构化标志
		 * 否
		 * 0
		 */
		public final static Integer STRUCTFLAG_NO = 0;
		/**
		 * 结构化标志
		 * 是，如果ocr识别成功或医院同步过来的结构化的数据
		 * 1
		 */
		public final static Integer STRUCTFLAG_YES = 1;
		
		/**
		 * 随访方式
		 * 1：短信随访
		 */
		public final static Integer FOLLOWUPWAY_SMS = 1;
		/**
		 * 随访方式
		 * 2：电话随访  （默认）
		 */
		public final static Integer FOLLOWUPWAY_TELEPHONE = 2;
		/**
		 * 随访方式
		 * 4：问卷
		 */
		public final static Integer FOLLOWUPWAY_QUESTIONNAIRE = 4;
		
		/**
		 * 可见标识
		 * 0: 任何人不可见。包括患者本人
		 */
		public final static Integer VISIBLEFLAG_NO_ONE = 0;
		
		/**
		 * 处理标识。
			0：待处理（增量用户）；（默认）
			数据采集时的临时表，以及采集后的目标表，均使用此标识表示记录是否需要处理（0表示需要处理）。
		 */
		public final static Integer HANDLEFLAG_PENDING = 0;
		/**
		 * 处理标识。
			1：已处理
			数据采集时的临时表，以及采集后的目标表，均使用此标识表示记录是否需要处理（0表示需要处理）。
		 */
		public final static Integer HANDLEFLAG_PROCESSED = 1;
	}
	
	/**
	 * 支付相关常量
	 * @author bigdragon
	 *
	 */
	public final static class Pay{
		
		public static final int PAY_WAY_ALI    = 1; //支付宝支付
		
		public static final int PAY_WAY_WEIXIN = 2; //微信支付
		
		public static final int PAY_STATE_SUCCESS = 1;//支付成功
		
		public static final int PAY_STATE_FAIL    = 3; //支付失败
	}
	
	 /**
     * 抵用券常量
     */
    public final static class Coupon{
    	//抵用券使用方法
    	public static final int COUPON_TYPE_CASH = 1;//现金券 直接减
    	public static final int COUPON_TYPE_SALE = 2;//折扣券 乘法运算
    	
    	//抵用券状态
    	public static final int COUPON_STATE_UNCLAIMED = 0;//未领取的
    	public static final int COUPON_STATE_NOT_USED = 1;//未使用的
    	public static final int COUPON_STATE_USED = 2;//使用的
    	public static final int COUPON_STATE_OVERDUE = 3;//过期的
    	
    	//抵用券模版状态
    	public static final int COUPON_TEMPLATE_STATE_ON = 1 ;//上架
    	public static final int COUPON_TEMPLATE_STATE_OFF = 2;//下架
    	
    	//抵用券模版条件类型
    	public static final int COUPON_TEMPLATE_REQ_REGIST =1;//用户注册
    	
    }
	
	//业务线类型
	public enum BusinessType{
		//未知
		BusinessUNKNOWNType,
		//随诊业务线
		BusinessTypeSuizhen,
	};	

	//业务线类型
	public enum ProductType{
		//未知
		ProductUNKNOWNType,
		//随诊医生app
		ProductTypeSuizhenDoctor,
		//随诊患者微信
		ProductTypeSuizhenPatient,
	};
	
	//消息服务类型
	public enum ImServiceType{
		//未知
		ImServiceUNKNOWNType,
		//图文咨询
		ImServiceTypeConsulting,		
		//随访
		ImServiceTypeFollowup,
	};	
	
	/**
	 * Push EventType常量
	 */
    public final static class Push{
		
		public static final int EVENT_TYPE_NEW_MSG     = 1; //新消息
		public static final int EVENT_TYPE_NEW_PATIENT = 2; //新患者
	    public static final int EVENT_TYPE_NEW_EMR     = 3; //新病历
	    public static final int EVENT_TYPE_NEW_FOLLOWUP = 4; //新随访反馈
	    public static final int EVENT_TYPE_SERVICE_STATE_CHANGE = 5; //业务状态变化
	    public static final int EVENT_TYPE_ALERT = 6; //业务状态变化
	    public static final int EVENT_TYPE_NEW_PROFIT = 7; //新收益
	    public static final int EVENT_TYPE_MDT_APPLY = 8; //mdt申请
	    public static final int EVENT_TYPE_FOLLOWUP_DAILY = 9; //随访日报发送
	    public static final int EVENT_TYPE_MDT_STATE1 = 10; //MDT样本验收
	    public static final int EVENT_TYPE_MDT_STATE2 = 11; //MDT病理填写意见
	    public static final int EVENT_TYPE_MDT_STATE3 = 12; //MDT内科填写意见
	    public static final int EVENT_TYPE_MDT_STATE4 = 13; //MDT放疗填写意见
	    public static final int EVENT_TYPE_MDT_STATE5 = 14; //患者已付款
	    public static final int EVENT_TYPE_MDT_STATE6 = 15; //MDT流程结束
	    public static final int EVENT_TYPE_MDT_STATE7 = 16; //上传病历资料
	    public static final int EVENT_TYPE_APPLY_WAIT_HANDLE = 17; //上传病历资料
	    
	    public static final int WEIXIN_BIND_DEFAULT_PRODUCT_ID = 2;//微信发送默认productId
		
	    //pushContent serviceType 类型
	    public static final int PUSH_CONTENT_SERVICETYPE_USER = 0; //用户
	    public static final int PUSH_CONTENT_SERVICETYPE_BUSINESS = 1; //医患咨询业务/院级服务
	    public static final int PUSH_CONTENT_SERVICETYPE_FOLLOWUP = 2; //随访
	    public static final int PUSH_CONTENT_SERVICETYPE_MEDICALRECORD = 3; //病历
	    public static final int PUSH_CONTENT_SERVICETYPE_PROJECT = 4; //科研
	    public static final int PUSH_CONTENT_SERVICETYPE_STATISTICS = 5; //统计
	    public static final int PUSH_CONTENT_SERVICETYPE_WEIXIN = 6; //微信消息
	    
	    
	    //微信消息类型
	    public static final String PUSH_WEIXIN_MSGTYPE_NEWS="news"; //文本消息
	    public static final String PUSH_WEIXIN_MSGTYPE_TEXT="text"; //图文消息
    }
    
    /**
     * 产品服务相关常量
     */
    public final static class Business{
    	
    	public static final int PRODUCT_TYPE_RICHTEXT = 1; //图文咨询
      	public static final int PRODUCT_TYPE_TEL      = 2; //电话咨询
    	public static final int PRODUCT_TYPE_CLINIC   = 3; //预约挂号
    	public static final int PRODUCT_TYPE_MDT      = 4; //专家会诊咨询
    	public static final int PRODUCT_TYPE_PRIVATE_DOCTOR = 5; //私人医生
    	public static final int PRODUCT_TYPE_CONVENIENT = 6; //医院便利服务包
    	public static final int PRODUCT_TYPE_MONITOR_ILLNESS = 7; //医院病情监控包
    	public static final int PRODUCT_TYPE_OFFLINE = 8; //线下挂号
    	public static final int PRODUCT_TYPE_MEDICAL_RECORD_MAIL = 9; //病案复印邮寄
    	public static final int PRODUCT_TYPE_INSPECTION_RESULT = 10; //检查结果查询
    	public static final int PRODUCT_TYPE_FOLLOWUP_MESSAGE = 11; //随访消息
    	public static final int PRODUCT_TYPE_REVIEW_APPOINTMENT = 12; //复查预约
    	public static final int PRODUCT_TYPE_REVIEW_GOODS = 13; //普通商品
    	public static final int PRODUCT_TYPE_FOLLOWUP_BUSINESS = 14; //医院随诊服务包
    	public static final int PRODUCT_TYPE_GRATUITY=100; //打赏
        	
    	public static final int SERVICE_TIMEOUT       = 24; //业务超时时间。24小时。主要是微信消息回复需要在24小时内。          	
		
    	/* 套餐标识    */
    	public static final int PRODUCT_PACKAGE_PARENT = 1; //是套餐，如私人医生
    	public static final int PRODUCT_PACKAGE_NO = 0;    //非套餐，如图文咨询。（但可以作为套餐元素）
    	public static final int PRODUCT_PACKAGE_CHILD = -1;    //仅作为套餐子元素，不可单独购买。如预约挂号。
    		
    	public static final String BUTTON_DESC_PREFIX = "- ";

    	/*产品子类型*/
    	public static final int PRODUCT_TYPE_MEDICAL_RECORD_MAIL_EXPRESS=901;
		public static final int PRODUCT_TYPE_MEDICAL_RECORD_RECEIVE=902;

		/*业务流程状态*/

		/*病案复印邮寄服务流程*/
		public static final int MEDICAL_RECORD_EXPRESS_PROCESS_APPLY_STATUS=0;//已申请
		public static final int MEDICAL_RECORD_EXPRESS_PROCESS_LEAVE_HOSPITAL_STATUS=1;//已离院
		public static final int MEDICAL_RECORD_EXPRESS_PROCESS_FILE_STATUS=3;//已归档
		public static final int MEDICAL_RECORD_EXPRESS_PROCESS_DUPLICATE_STATUS=4;//已复印
		public static final int MEDICAL_RECORD_EXPRESS_PROCESS_EXPRESS_STATUS=5;//已邮寄

		/*病案复印现场领取服务流程*/
		public static final int MEDICAL_RECORD_RECEIVE_PROCESS_APPLY_STATUS=0;//已申请
		public static final int MEDICAL_RECORD_RECEIVE_PROCESS_RECEIVE_STATUS=6;//已领取

    }
    
    
    /**
     * 科研专题相关常量
     * @author YYCHEN
     *
     */
    public final static class Research{
    	/**
    	 * 是否设置了科研模板
    	 * 0：未设置（缺省）
    	 */
    	public static final int ISPROJECTTEMPLATESET_NO = 0;
    	/**
    	 * 是否设置了科研模板
    	 * 1：已设置
    	 */
    	public static final int ISPROJECTTEMPLATESET_YES = 1;
    	
    	/**
    	 * 专题状态
    	 * 0：未开始
    	 */
    	public static final int PROJECT_STATE_NOTSTART = 0;
    	/**
    	 * 专题状态
    	 * 1：进行中
    	 */
    	public static final int PROJECT_STATE_RUNNING = 1;
    	/**
    	 * 专题状态
    	 * 2：已结束
    	 */
    	public static final int PROJECT_STATE_FINISHED = 2;
    	/**
    	 * 专题状态
    	 * 3：已终止（强行终止/取消）
    	 */
    	public static final int PROJECT_STATE_TERMINATED = 3;
    	
    	/**
    	 * 科研专题模板是否公开
    	 * 0：不公开
    	 */
    	public static final int PROJECT_TEMPLATE_ISPUBLISH_NO = 0;
    	/**
    	 * 科研专题模板是否公开
    	 * 1：公开
    	 */
    	public static final int PROJECT_TEMPLATE_ISPUBLISH_YES = 1;
    	
    	/**
    	 * 知情同意书(ICF)确认方式
    	 * 0:无需确认
    	 */
    	public static final int ICFCONFIRMWAY_UNWANTED  = 0;
    	/**
    	 * 知情同意书(ICF)确认方式
    	 * 1：线上确认
    	 */
    	public static final int ICFCONFIRMWAY_ONLINE  = 1;
    	/**
    	 * 知情同意书(ICF)确认方式
    	 * 2：面签确认
    	 */
    	public static final int ICFCONFIRMWAY_NEGOTIABLE  = 2;
    	
    	/**
    	 * 专题患者邀请状态
    	 * -3：信息发送中
    	 */
    	public static final int PROJECTINVITATIONPATIENT_STATE_SMS_SENDING = -3;
    	/**
    	 * 专题患者邀请状态
    	 * -2：信息发送失败
    	 */
    	public static final int PROJECTINVITATIONPATIENT_STATE_FAIL = -2;
    	/**
    	 * 专题患者邀请状态
    	 * -1：已拒绝
    	 */
    	public static final int PROJECTINVITATIONPATIENT_STATE_REFUSE = -1;
    	/**
    	 * 专题患者邀请状态
    	 * 0：已邀请，待确认
    	 */
    	public static final int PROJECTINVITATIONPATIENT_STATE_PENDING = 0;
    	/**
    	 * 专题患者邀请状态
    	 * 1：已接受（已线上确认或面签确认）
    	 */
    	public static final int PROJECTINVITATIONPATIENT_STATE_RECEIVED = 1;
    	/**
    	 * 专题患者邀请状态
    	 * 2：同意入组
    	 */
    	public static final int PROJECTINVITATIONPATIENT_STATE_AGREE = 2;
    }
    
    /**
     * 日志里输出的前导符
     * @author DaLoong
     *
     */
    public final static class LOGTAG{
    	public static final String ERR = "################ ERROR: ";
    	public static final String INF = "================ ";
    	public static final String OK  = "~~~~~~~~~~~~~~~~ OK! ";
    	
    	
    }
    
   /**
    * 用户操作相关常量
    */
    public final static class Operation{
    	
    	/*操作名*/
    	public static final String OPERATION_NAME_REVIEWALERT = "reviewalert";
    	
    	/*动作*/
    	public static final int ACTION_TYPE_ADD = 1;
    	public static final int ACTION_TYPE_DEL = 2;
    	public static final int ACTION_TYPE_UPD = 3;
    	public static final int ACTION_TYPE_SEL = 4;
    }
}
