package com.esuizhen.cloudservice.statistics.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.esuizhen.cloudservice.statistics.bean.TFollowupWayStatisticInfo;
import com.esuizhen.cloudservice.statistics.bean.TStatisticTitleInfo;

/**
 * 统计系统中使用的动态表头
 * @author YYCHEN
 *
 */
public class JsonUtil {

	/**
	 * 将表头设置信息转换成表头bean
	 * @param jsonStr
	 * @return
	 */
	public static List<TStatisticTitleInfo> jsonStrConvertTableHand(String jsonStr){
		com.alibaba.fastjson.JSONArray parseArray = JSONObject.parseArray(jsonStr);
		return jsonStrConvertTableHand(parseArray);
	}
	
	/**
	 * 处理表头嵌套的情况
	 * 有递归调用的情况（如子表头也有嵌套的情况）
	 * @param parseArray
	 * @return
	 */
	private static List<TStatisticTitleInfo> jsonStrConvertTableHand(JSONArray parseArray) {
		List<TStatisticTitleInfo> result = new ArrayList<TStatisticTitleInfo>();
		Iterator<Object> iterator = parseArray.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			TStatisticTitleInfo statisticTitleInfo = new TStatisticTitleInfo();
			//ID
			Object id = jsonObject.get("id");
			if (id != null) {
				statisticTitleInfo.setId(id.toString());
			}
			Object name = jsonObject.get("name");
			if (name != null) {
				statisticTitleInfo.setName(name.toString());
			}
			Object type = jsonObject.get("type");
			if (type != null) {
				statisticTitleInfo.setType(Integer.parseInt(type.toString()));
			}
			Object rows = jsonObject.get("rows");
			if (rows != null) {
				statisticTitleInfo.setRows(Integer.parseInt(rows.toString()));
			}
			Object cols = jsonObject.get("cols");
			if (cols != null) {
				statisticTitleInfo.setCols(Integer.parseInt(cols.toString()));
			}
			Object subTitles = jsonObject.get("subTitles");
			if (subTitles != null) {//表头还有嵌套的情况，继续递归调用
				com.alibaba.fastjson.JSONArray array = (JSONArray) subTitles;
				statisticTitleInfo.setSubTitles(jsonStrConvertTableHand(array));
			}
			
			result.add(statisticTitleInfo);
		}
        return result;
	}
	
	/**
	 * 将表头设置信息转换成表头bean,按照随访方式
	 * @param jsonStr
	 * @return
	 */
	public static TFollowupWayStatisticInfo convertTableHandByFollowupWay(String jsonStr){
		TFollowupWayStatisticInfo title = new TFollowupWayStatisticInfo();
		JSONObject parseObject = JSONObject.parseObject(jsonStr);
		JSONArray followupWayArray = parseObject.getJSONArray("followupWay");
		List<TStatisticTitleInfo> followupWayList = jsonStrConvertTableHand(followupWayArray);
		JSONArray outPatientFlagArray = parseObject.getJSONArray("outPatientFlag");
		List<TStatisticTitleInfo> outPatientFlagList = jsonStrConvertTableHand(outPatientFlagArray);
		JSONArray followupWayTotalArray = parseObject.getJSONArray("followupWayTotal");
		List<TStatisticTitleInfo> followupWayTotalList = jsonStrConvertTableHand(followupWayTotalArray);
		title.setFollowupWayTitles(followupWayList);
		title.setOutPatientFlagTitles(outPatientFlagList);
		title.setFollowupWayTotalTitles(followupWayTotalList);
		return title;
	}

	public static void main(String[] args) {
		//String json = "{\"json\":[{\"id\":\"followupTaskName\",\"name\":\"任务名称\",\"type\":2,\"rows\":1,\"cols\":1}]}";
		String json = "[{\"id\":\"followupTaskName\",\"name\":\"任务名称\",\"type\":2,\"rows\":1,\"cols\":1}]";
		List<TStatisticTitleInfo> infos = jsonStrConvertTableHand(json);
		for (TStatisticTitleInfo item : infos) {
			System.out.println(item.getId());
		}
	}
}
