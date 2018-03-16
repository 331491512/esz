package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:TStatisticResultInfo</p>
 * <p>Description:统计列表结构信息</p>
 * @author YYCHEN
 * @date 2016年8月10日 下午6:10:50
 */
public class TStatisticResultInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//生成的查询ID
	private Integer searchId;
	//导出数据使用的模板ID
	private String exportTemplateId;
	//统计列表表头信息
	private List<TStatisticTitleInfo> titiles;
	//
	private List<Map<String, Object>> values;
	
	private String show;
	
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public String getExportTemplateId() {
		return exportTemplateId;
	}
	public void setExportTemplateId(String exportTemplateId) {
		this.exportTemplateId = exportTemplateId;
	}
	public List<TStatisticTitleInfo> getTitiles() {
		return titiles;
	}
	public void setTitiles(List<TStatisticTitleInfo> titiles) {
		this.titiles = titiles;
	}
	public List<Map<String, Object>> getValues() {
		return values;
	}
	public void setValues(List<Map<String, Object>> values) {
		this.values = values;
	}
}
