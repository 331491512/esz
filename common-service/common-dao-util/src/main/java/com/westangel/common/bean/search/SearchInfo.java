/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.search;<br/>  
 * <b>文件名：</b>SearchInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月8日上午9:28:12<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.search;
/** 
* @ClassName: SearchInfo
* @Description: 
* @author lichenghao
* @date 2016年8月8日 上午9:28:12  
*/
public class SearchInfo {
	//查询编号
	private Integer searchId;
	//查询总数
	private int totalNum;
	//请求接口
	private String interfaceName;
	//中间表
	private String searchTableName;
	//列
	private String searchColumn;
	//请求参数
	private String req;
	//操作者
	private Long operator;
	
	private String sqlContent;
	
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	
	
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	
	public String getSearchTableName() {
		return searchTableName;
	}
	public void setSearchTableName(String searchTableName) {
		this.searchTableName = searchTableName;
	}
	public SearchInfo(){}
	public SearchInfo(String interfaceName,String req,Long operator){
		this.interfaceName = interfaceName;
		this.req = req;
		this.operator = operator;
	}
	public String getSearchColumn() {
		return searchColumn;
	}
	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}
	public String getSqlContent() {
		return sqlContent;
	}
	public void setSqlContent(String sqlContent) {
		this.sqlContent = sqlContent;
	}
	public SearchInfo(String interfaceName,String req,Long operator,String searchTableName){
		this.interfaceName = interfaceName;
		this.req = req;
		this.operator = operator;
		this.searchTableName = searchTableName;
	}
}
