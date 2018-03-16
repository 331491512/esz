package com.westangel.common.dao.search;

import com.westangel.common.bean.search.SearchInfo;

/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.dao;<br/>  
 * <b>文件名：</b>SearchDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月12日下午3:19:07<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */


/** 
* @ClassName: SearchDao
* @Description: 
* @author lichenghao
* @date 2016年8月12日 下午3:19:07  
*/
public interface SearchDao {
	/**
	 * 
	 * @author lichenghao
	 * @title :queryVarFollowupPatientTableName
	 * @Description:获取插入动态表
	 * @return String
	 * @date 2016年8月24日 上午8:27:17
	 */
	public String queryVarFollowupPatientTableName();
	
	/**
	 * 
	 * @author lichenghao
	 * @title :insert
	 * @Description:插入查询表
	 * @return int
	 * @date 2016年8月24日 上午8:27:37
	 */
	public int insert(SearchInfo obj);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :update
	 * @Description:修改查询表  主要用于修改查询表相关数量
	 * @return int
	 * @date 2016年8月24日 上午8:28:14
	 */
	public int update(SearchInfo obj);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryTableNameBySearchId
	 * @Description:查询中间表名称获取
	 * @return String
	 * @date 2016年8月24日 上午8:29:31
	 */
	public String queryTableNameBySearchId(Integer searchId);
	
	/**
	 * 通过id获取搜索条件信息
	 * @param searchId
	 * @return
	 */
	public SearchInfo querySearchById(Integer searchId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :querySearchInfo
	 * @Description:获取search表名和列
	 * @return SearchInfo
	 * @date 2016年9月2日 下午4:14:38
	 */
	public Integer createSearchInfo(SearchInfo searchInfo);
	
	/**
	 * 
	 * @author raox
	 * @title :querySearchInfo
	 * @Description:获取search表名和列
	 * @return SearchInfo
	 * @date 2016年9月2日 下午4:14:38
	 */
	public Integer initNullSearchWidePatientColumn(SearchInfo searchInfo);
}
