package com.esuizhen.cloudservice.followup.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esuizhen.cloudservice.followup.dao.followup.FollowupPlanDao;
import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplate;
import com.esuizhen.cloudservice.followup.model.followup.FollowupPlanTemplateDetialInfo;
import com.westangel.common.service.FollowupService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:spring/application.xml" })
public class FollowupServiceTest 
{
	
	@Autowired
	private FollowupService followupService;
	
	@Autowired
	private FollowupPlanDao dao;
	
	private Integer[] month1 = new Integer[]{3,6,9,12,15,18,21,24,30,36,42,48,54,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index1 = new Integer[]{1,3,5,7 ,9 ,11,13,15,18,21,24,27,30,33,35,37,39,41 ,43 ,45 ,47 ,49 ,51 ,53 ,55 ,57 ,59 ,61 ,63};
	
	private Integer[] month2 = new Integer[]{3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index2 = new Integer[]{2,4,6,8 ,10,12,14,16,17,19,20,22,23,25,26,28,29,31,32,34,36,38,40,42 ,44 ,46 ,48 ,50 ,52 ,54 ,56 ,58 ,60 ,62 ,64 };
	
	
	private Integer[] month3 = new Integer[]{6,12,18,24,30,36,42,48,54,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index3 = new Integer[]{2,5 ,8 ,11,14,16,19,22,25,28,30,32,34,36 ,38 ,40 ,42 ,44 ,46 ,48 ,50 ,52 ,54 ,56 ,58};
	
	private Integer[] month4 = new Integer[]{3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index4 = new Integer[]{1,3,4,6 ,7 ,9 ,10,12,13,14,15,17,18,20,21,23,24,26,27,29,31,33,35,37 ,39 ,41 ,43 ,45 ,47 ,49 ,51 ,53 ,55 ,57 ,59 };
	
	private Integer[] month5 = new Integer[]{3,6,9,12,18,24,36,48,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index5 = new Integer[]{1,3,5,7 ,10,13,18,23,28,30,32,34,36 ,38 ,40 ,42 ,44 ,46 ,48 ,50 ,52 ,54 ,56 ,58};
	
	private Integer[] month6 = new Integer[]{3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index6 = new Integer[]{2,4,6,8 ,9 ,11,12,14,15,16,17,19,20,21,22,24,25,26,27,29,31,33,35,37 ,39 ,41 ,43 ,45 ,47 ,49 ,51 ,53 ,55 ,57 ,59};
	
	private Integer[] month7 = new Integer[]{1,3,6,9,12,18,24,36,48,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index7 = new Integer[]{1,2,4,6,8 ,11,14,19,24,29,31,33,35,37 ,39 ,41 ,43 ,45 ,47 ,49 ,51 ,53 ,55 ,57 ,59};
	
	private Integer[] month8 = new Integer[]{3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,72,84,96,108,120,132,144,156,168,180,192,204,216,228,240};
	private Integer[] index8 = new Integer[]{3,5,7,9 ,10,12,13,15,16,17,18,20,21,22,23,25,26,27,28,30,32,34,36,38 ,40 ,42 ,44 ,46 ,48 ,50 ,52 ,54 ,56 ,58 ,60};
	
	private String questionInfo="亲爱的患友您好！请您把目前的身体状况通过填写问卷的方式告诉我们，以便我们能够关注到您的身体康复情况，点击进入填写";
	
	@Test
	@Ignore
	public void initNormalFollowupPlan() 
	{
		boolean flag = followupService.initNormalFollowupPlan(1823196L , "2015-09-06 09:09:09" , 41L);
		LogUtil.log.info("flag="+flag+","+followupService.toString());
	}
	
	//子宫内膜癌
	@Test
	@Ignore
	public void createFollowupPlanTemplate1()
	{
		String planTemplateId = GeneralUtil.generateUniqueID("TEMP");
		FollowupPlanTemplate followupPlanTemplate = new FollowupPlanTemplate(
				planTemplateId,"子宫内膜癌随访模板",1,"易随诊","根据子宫内膜癌的特性，制定的常规随访计划",61,9,1,new Date(),new Date(),null);
		dao.createFollowupPlanTemplate(followupPlanTemplate);
		dao.addFollowupPlanTemplateDetialInfo(getDetialInfoList(planTemplateId , "肿瘤标志物-(CA-125)，CT/MRI:胸/腹/盆腔部，阴道细胞涂片学检查，盆腔检查（三合诊）"));
	}
	
	//卵巢癌
	@Test
	@Ignore
	public void createFollowupPlanTemplate2()
	{
		String planTemplateId = GeneralUtil.generateUniqueID("TEMP");
		FollowupPlanTemplate followupPlanTemplate = new FollowupPlanTemplate(
				planTemplateId,"卵巢癌随访模板",1,"易随诊","根据卵巢癌的特性，制定的常规随访计划",63,9,1,new Date(),new Date(),null);
		
		dao.createFollowupPlanTemplate(followupPlanTemplate);
		dao.addFollowupPlanTemplateDetialInfo(getDetialInfoList4(planTemplateId , "肿瘤标志物-(CA-125)，腹部B超，CT-胸、腹、盆腔"));
	}
	
	//宫颈癌
	@Test
	@Ignore
	public void createFollowupPlanTemplate3()
	{
		String planTemplateId = GeneralUtil.generateUniqueID("TEMP");
		FollowupPlanTemplate followupPlanTemplate = new FollowupPlanTemplate(
				planTemplateId,"宫颈癌随访模板",1,"易随诊","根据子宫颈癌的特性，制定的常规随访计划",60,9,1,new Date(),new Date(),null);
		
		dao.createFollowupPlanTemplate(followupPlanTemplate);
		dao.addFollowupPlanTemplateDetialInfo(getDetialInfoList(planTemplateId , "肿瘤标志物-鳞状细胞癌抗原（SCC），肿瘤标志物-(CA-125)，腹部、盆腔B超，CT/MRI:胸/腹/盆腔部，残端细胞学检查，妇科检查"));
	}
	
	//"鼻咽癌","口腔癌","喉癌","甲状腺肿瘤","食管癌","乳腺癌","肺癌","胃癌","肝癌","胰腺癌","结肠癌","肾癌","前列腺癌","膀胱癌","直肠癌"
	@Test
	@Ignore
	public void createFollowupPlanTemplate4()
	{

		Integer[] diseaseTypeIds = new Integer[]{1,2,3,4,21,23,20,30,34,36,32,40,51,42,33};
		String [] names=new String[]{"鼻咽癌","口腔癌","喉癌","甲状腺癌","食管癌","乳腺癌","肺癌","胃癌","肝癌","胰腺癌","结肠癌","肾癌","前列腺肿瘤","膀胱癌","直肠癌"};
		String[] checks = new String[]{
				"EB病毒血清学检查，CT/MRI：扫描范围上界应包括海绵窦，下界包至口咽部，行增强扫描",
				"CT/MRI头颈部",
				"喉镜，CT/MRI:头颈胸部",
				"B超，CT/MEI：颈部，甲状腺触诊",
				"食管镜，CT/MRI：颈胸部，B超：腹部，肿瘤标志物：CEA\\SCC",
				"乳腺钼靶X线（健侧），肿瘤标志物CA153，胸腹部及盆腔彩超，CT/MRI胸腹部",
				"肿瘤标志物AFP，CT/MRI：胸腹部，MRI:头颈部、脊柱，骨扫描",
				"胃镜，肿瘤标志物：CEA\\CA199，CT/MRI:胸腹部盆腔，B超：胸腹部盆腔",
				"肿瘤标志物：AFP，肝功能，CT/MRI:胸腹部盆腔，B超：胸腹部盆腔",
				"肿瘤标志物CA-199、CEA，糖耐量试验，CT/MRI:胸腹部盆腔，B超：胸腹部盆腔",
				"肿瘤标志物CEA，大便常规+便潜血，CT/MRI:胸腹部盆腔，B超：胸腹部盆腔",
				"尿常规+尿潜血，X线造影，CT/MRI:胸腹部盆腔，B超：胸腹部盆腔",
				"直肠指诊，血清酸性磷酸酶，CT/MRI:胸腹部盆腔，B超：胸腹部盆腔",
				"尿细胞学检查，膀胱镜，流式细胞术，静脉尿路造影，CT/MRI:胸腹部盆腔，膀胱造影",
				"直肠指检，直肠镜或乙状结肠镜，CT/MRI:胸腹部盆腔"
		};
		
		for(int i=0; i<diseaseTypeIds.length; i++)
		{
			String planTemplateId = GeneralUtil.generateUniqueID("TEMP");
			FollowupPlanTemplate followupPlanTemplate = new FollowupPlanTemplate(
					planTemplateId,names[i]+"随访模板",1,"易随诊","根据"+names[i]+"的特性，制定的常规随访计划",diseaseTypeIds[i],9,1,new Date(),new Date(),null);
			
			dao.createFollowupPlanTemplate(followupPlanTemplate);
			dao.addFollowupPlanTemplateDetialInfo(getDetialInfoList2(planTemplateId , checks[i]));
		}
		
	}

	
	//其他病种
	@Test
	@Ignore
	public void createFollowupPlanTemplate5()
	{

		Integer[] diseaseTypeIds = new Integer[]{19,29,39,69,49,999};
		String [] names=new String[]{"其他头颈肿瘤","其他胸部肿瘤","其他腹部肿瘤","其他妇科肿瘤","其他泌尿肿瘤","其他肿瘤"};
		String[] checks = new String[]{
				"",
				"",
				"",
				"",
				"",
				""
		};
		
		for(int i=0; i<diseaseTypeIds.length; i++)
		{
			String planTemplateId = GeneralUtil.generateUniqueID("TEMP");
			FollowupPlanTemplate followupPlanTemplate = new FollowupPlanTemplate(
					planTemplateId,names[i]+"随访模板",1,"易随诊","按照肿瘤患者常规随访要求，自动生成复查提醒以及随访问卷填写提示",diseaseTypeIds[i],9,1,new Date(),new Date(),null);
			
			dao.createFollowupPlanTemplate(followupPlanTemplate);
			dao.addFollowupPlanTemplateDetialInfo(getDetialInfoList2(planTemplateId , checks[i]));
		}
		
	}
	
	//恶性淋巴瘤	骨肉瘤	恶性神经胶质瘤	脑膜瘤	椎管内肿瘤
	@Test
	public void createFollowupPlanTemplate6()
	{

		Integer[] diseaseTypeIds = new Integer[]{90,81,103,101,102};
		String [] names=new String[]{"淋巴瘤","骨肉瘤","恶性神经瘤","脑脊膜瘤","脊髓瘤"};
		String[] checks = new String[]{
				"淋巴结，PET-CT（医生决定），CT/MRI:全身",
				"胸片，CT/MRI:胸腹部盆腔，MRI:病变部位",
				"CT/MRI:头颅，基因：LP/19q，基因：MGMT甲基化，PET检查",
				"CT/MRI:头颅，脑血管造影",
				"CT/MRI:脊柱、头颈胸腹盆"
		};
		
		for(int i=0; i<diseaseTypeIds.length; i++)
		{
			String planTemplateId = GeneralUtil.generateUniqueID("TEMP");
			FollowupPlanTemplate followupPlanTemplate = new FollowupPlanTemplate(
					planTemplateId,names[i]+"随访模板",1,"易随诊","根据"+names[i]+"的特性，制定的常规随访计划",diseaseTypeIds[i],9,1,new Date(),new Date(),null);
			
			dao.createFollowupPlanTemplate(followupPlanTemplate);
			dao.addFollowupPlanTemplateDetialInfo(getDetialInfoList3(planTemplateId , checks[i]));
		}
		
	}
	/**
	 * @author wang_hw
	 * @title :getDetialInfoList
	 * @Description:获取公共数据
	 * @return List<FollowupPlanTemplateDetialInfo>
	 * @date 2016年2月16日 下午5:33:44
	 */
	public  List<FollowupPlanTemplateDetialInfo> getDetialInfoList(String planTemplateId , String checkInfo)
	{
		List<FollowupPlanTemplateDetialInfo> detialInfoList = new ArrayList<FollowupPlanTemplateDetialInfo>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("为了更好的监控您的病情，请做以下复查：<br/>");
		sb.append(checkInfo);
		sb.append("<br/>复查后请上传结果，点击上传 （或点击页面下方“康复管理-我的病历”上传）。");
		Set<Integer> set = new HashSet<Integer>();
		//提醒消息
		for(int i=0; i<month1.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index1[i],0,month1[i]+"个月",2,month1[i],sb.toString(),new Date(),new Date());
			detialInfoList.add(detialInfo);
			set.add(month1[i]);
		}
		
		//问卷消息
		for(int i=0; i<month2.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index2[i],10,set.contains(month2[i])?null:month2[i]+"个月",3,month2[i],questionInfo,new Date(),new Date());
			detialInfoList.add(detialInfo);
		}
		
		return detialInfoList;
	}
	
	/**
	 * @author wang_hw
	 * @title :getDetialInfoList
	 * @Description:获取公共数据
	 * @return List<FollowupPlanTemplateDetialInfo>
	 * @date 2016年2月16日 下午5:33:44
	 */
	public  List<FollowupPlanTemplateDetialInfo> getDetialInfoList2(String planTemplateId , String checkInfo)
	{
		List<FollowupPlanTemplateDetialInfo> detialInfoList = new ArrayList<FollowupPlanTemplateDetialInfo>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("为了更好的监控您的病情，请定期复查！<br/>");
		if(!StringUtils.isEmpty(checkInfo))
		{
			sb.append(checkInfo+"<br/>");
		}
		
		sb.append("复查后请上传结果，点击上传 （或点击页面下方“康复管理-我的病历”上传）。");
		Set<Integer> set = new HashSet<Integer>();
		//提醒消息
		for(int i=0; i<month3.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index3[i],0,month3[i]+"个月",2,month3[i],sb.toString(),new Date(),new Date());
			detialInfoList.add(detialInfo);
			set.add(month3[i]);
		}
		
		//问卷消息
		for(int i=0; i<month4.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index4[i],10,set.contains(month4[i])?null:month4[i]+"个月",3,month4[i],questionInfo,new Date(),new Date());
			detialInfoList.add(detialInfo);
		}
		
		return detialInfoList;
	}
	
	/**
	 * @author wang_hw
	 * @title :getDetialInfoList
	 * @Description:获取公共数据
	 * @return List<FollowupPlanTemplateDetialInfo>
	 * @date 2016年2月16日 下午5:33:44
	 */
	public  List<FollowupPlanTemplateDetialInfo> getDetialInfoList3(String planTemplateId , String checkInfo)
	{
		List<FollowupPlanTemplateDetialInfo> detialInfoList = new ArrayList<FollowupPlanTemplateDetialInfo>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("为了更好的监控您的病情，请做以下复查：<br/>");
		sb.append(checkInfo);
		sb.append("<br/>复查后请上传结果，点击上传 （或点击页面下方“康复管理-我的病历”上传）。");
		Set<Integer> set = new HashSet<Integer>();
		//提醒消息
		for(int i=0; i<month5.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index5[i],0,month5[i]+"个月",2,month5[i],sb.toString(),new Date(),new Date());
			detialInfoList.add(detialInfo);
			set.add(month5[i]);
		}
		
		//问卷消息
		for(int i=0; i<month6.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index6[i],10,set.contains(month6[i])?null:month6[i]+"个月",3,month6[i],questionInfo,new Date(),new Date());
			detialInfoList.add(detialInfo);
		}
		
		return detialInfoList;
	}
	
	/**
	 * @author wang_hw
	 * @title :getDetialInfoList
	 * @Description:获取公共数据
	 * @return List<FollowupPlanTemplateDetialInfo>
	 * @date 2016年2月16日 下午5:33:44
	 */
	public  List<FollowupPlanTemplateDetialInfo> getDetialInfoList4(String planTemplateId , String checkInfo)
	{
		List<FollowupPlanTemplateDetialInfo> detialInfoList = new ArrayList<FollowupPlanTemplateDetialInfo>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("为了更好的监控您的病情，请做以下复查：<br/>");
		sb.append(checkInfo);
		sb.append("<br/>复查后请上传结果，点击上传 （或点击页面下方“康复管理-我的病历”上传）。");
		
		Set<Integer> set = new HashSet<Integer>();
		//提醒消息
		for(int i=0; i<month7.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index7[i],0,month7[i]+"个月",2,month7[i],sb.toString(),new Date(),new Date());
			detialInfoList.add(detialInfo);
			set.add(month7[i]);
		}
		
		//问卷消息
		for(int i=0; i<month8.length; i++)
		{
			FollowupPlanTemplateDetialInfo detialInfo = new FollowupPlanTemplateDetialInfo(
					GeneralUtil.generateUniqueID("TEMP"),planTemplateId,index8[i],10,set.contains(month8[i])?null:month8[i]+"个月",3,month8[i],questionInfo,new Date(),new Date());
			detialInfoList.add(detialInfo);
		}
		
		return detialInfoList;
	}
}
