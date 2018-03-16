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

import java.io.Serializable;
import java.util.Date;
/**
 * <p>Title:StatsExportValueInfo</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年8月20日 下午6:09:09
 */
public class StatsExportValueInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	//主键
	private Long id;
	//模板ID
	private String exportTemplateId;
	//查询ID
	private Long searchId;
	//取值列表。
	private String values;
	//记录生成时间
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExportTemplateId() {
		return exportTemplateId;
	}
	public void setExportTemplateId(String exportTemplateId) {
		this.exportTemplateId = exportTemplateId;
	}
	public Long getSearchId() {
		return searchId;
	}
	public void setSearchId(Long searchId) {
		this.searchId = searchId;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
