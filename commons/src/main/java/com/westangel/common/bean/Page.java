package com.westangel.common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
* @ClassName: Page 
* @Description: 分页实体
* @author wang_hw
* @date 2015年12月10日 上午10:17:17
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 总条数
	 */
	private Integer totalNum;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	/**
	 * 当前页数
	 */
	private Integer currPage;
	
	/**
	 * 当前页数据条数
	 */
	private Integer currSize;
	
	/**
	 * 数据列表
	 */
	private List<T> dataList;

	public Integer getTotalNum()
	{
		return totalNum;
	}

	public void setTotalNum(Integer totalNum)
	{
		this.totalNum = totalNum;
	}

	public Integer getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(Integer totalPage)
	{
		this.totalPage = totalPage;
	}

	public Integer getCurrPage()
	{
		return currPage;
	}

	public void setCurrPage(Integer currPage)
	{
		this.currPage = currPage;
	}
	public Integer getCurrSize()
	{
		return currSize;
	}

	public void setCurrSize(Integer currSize)
	{
		this.currSize = currSize;
	}
	public List<T> getDataList()
	{
		return dataList;
	}

	public void setDataList(List<T> dataList)
	{
		this.dataList = dataList;
	}

	
}
