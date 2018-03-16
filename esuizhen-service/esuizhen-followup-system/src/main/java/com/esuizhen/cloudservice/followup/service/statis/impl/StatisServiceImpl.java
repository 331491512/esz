package com.esuizhen.cloudservice.followup.service.statis.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.dao.followup.FollowupResultDao;
import com.esuizhen.cloudservice.followup.dao.statis.StatisDao;
import com.esuizhen.cloudservice.followup.model.statis.TStatisData;
import com.esuizhen.cloudservice.followup.model.statis.TStatisResult;
import com.esuizhen.cloudservice.followup.service.statis.StatisService;
import com.esuizhen.cloudservice.followup.util.StatisUtil;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.LogUtil;

@Service
public class StatisServiceImpl implements StatisService
{

	@Autowired
	private FollowupResultDao dao;
	
	@Autowired
	private StatisDao statisDao;
	
	@Override
	public TStatisResult querySURStatisResult(String doctorId ,String confirmedDateBegin ,String confirmedDateEnd , String diseaseTypeIds)
	{
		//日期格式
		DecimalFormat decimalFormat=new DecimalFormat("0.00");
		
		//查询月份
		String[] months = new String[]{"3","6","12","36","60"};
		
		//返回结果组装
		TStatisResult result = new TStatisResult();
		
		//头
		List<List<TStatisData>> dataList = new ArrayList<List<TStatisData>>();
		result.setMetaList(StatisUtil.getSurMetadata());
		result.setDataList(dataList);
		
		//数据
		
		LinkedHashMap<String, Object> resultMap = statisDao.querySURStatisResult(doctorId, confirmedDateBegin, confirmedDateEnd, diseaseTypeIds);
		result.setDataType("SUR");
		result.setTitle("统计标题");
		result.setTotalSamples(Integer.parseInt(resultMap.get("totalSamples")+""));
		
		for(String key : months)
		{
			List<TStatisData> list= new ArrayList<TStatisData>();
			
			String base = resultMap.get("base"+key)== null ? "0" : resultMap.get("base"+key)+"";
			String live = resultMap.get("live"+key)== null ? "0" : resultMap.get("live"+key)+"";
			//项目/月
			TStatisData data1 = new TStatisData();
			data1.setId("mons");
			data1.setValue(key+"月");
			
			//生存率(%)
			TStatisData data2 = new TStatisData();
			data2.setId("sur");
			if("0".equals(base))
			{
				data2.setValue("0");
			}else
			{
				data2.setValue(decimalFormat.format(Double.parseDouble(live)/Double.parseDouble(base)*100));
			}
			
			
			//符合人数
			TStatisData data3 = new TStatisData();
			data3.setId("sum");
			data3.setValue(base);
			
			//存活人数
			TStatisData data4 = new TStatisData();
			data4.setId("num");
			data4.setValue(live);
			
			list.add(data1);
			list.add(data2);
			list.add(data3);
			list.add(data4);
			dataList.add(list);
		}
		return result;
	}

}
