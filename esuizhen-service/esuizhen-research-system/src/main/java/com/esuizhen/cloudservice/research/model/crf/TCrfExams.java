package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;

/**
* @ClassName: TCrfExam 
* @Description:CRF检查信息
* @author wang_hw
* @date 2016年4月6日 下午3:49:02
 */
public class TCrfExams{
	
	private String crfObserveId;
	
	private List<TCrfExamsDetail> dataList;

	public String getCrfObserveId()
	{
		return crfObserveId;
	}

	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}

	public List<TCrfExamsDetail> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<TCrfExamsDetail> dataList)
	{
		this.dataList = dataList;
	}
}

