package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;

/**
* @ClassName: TCrfObservationSubjectElementSet 
* @Description: crf观察项标题设置实体
* @author wang_hw
* @date 2016年4月5日 下午5:12:37
 */
public class TCrfObservationSubjectElementSet
{

	/**
	 * 观察点ID
	 */
	private String crfCourseItemId;
	
	/**
	 * 采集项父ID
	 */
	private String parentId;
	/**
	 * 观察项标题列表
	 */
	private List<TCrfObservationSubjectElement> subjectElemenList;

	
	public String getCrfCourseItemId()
	{
		return crfCourseItemId;
	}

	public void setCrfCourseItemId(String crfCourseItemId)
	{
		this.crfCourseItemId = crfCourseItemId;
	}

	
	public String getParentId()
	{
		return parentId;
	}

	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	public List<TCrfObservationSubjectElement> getSubjectElemenList()
	{
		return subjectElemenList;
	}

	public void setSubjectElemenList(List<TCrfObservationSubjectElement> subjectElemenList)
	{
		this.subjectElemenList = subjectElemenList;
	}
	
	
}
