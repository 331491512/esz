package com.esuizhen.cloudservice.followup.util;

import java.util.ArrayList;
import java.util.List;

import com.esuizhen.cloudservice.followup.model.statis.TStatisMetadata;

public class StatisUtil
{

	/**
	 * @author wang_hw
	 * @title :getSurMetadata
	 * @Description:生存率统计元数据
	 * @return List<TStatisMetadata>
	 * @date 2016年1月15日 下午8:57:04
	 */
	public static List<TStatisMetadata> getSurMetadata()
	{
		List<TStatisMetadata> metadataList = new ArrayList<TStatisMetadata>();
		
		TStatisMetadata meta1 = new TStatisMetadata();
		meta1.setType("x");
		meta1.setId("mons");
		meta1.setDisplayName("项目/月");
		meta1.setValueType("string");
		
		TStatisMetadata meta2 = new TStatisMetadata();
		meta2.setType("y");
		meta2.setId("sur");
		meta2.setDisplayName("生存率(%)");
		meta2.setValueType("percent");
		
		TStatisMetadata meta3 = new TStatisMetadata();
		meta3.setType("d");
		meta3.setId("sum");
		meta3.setDisplayName("符合人数");
		meta3.setValueType("int");
		
		TStatisMetadata meta4 = new TStatisMetadata();
		meta4.setType("n");
		meta4.setId("num");
		meta4.setDisplayName("存活人数");
		meta4.setValueType("int");
		
		metadataList.add(meta1);
		metadataList.add(meta2);
		metadataList.add(meta3);
		metadataList.add(meta4);
		return metadataList;
	}
}
