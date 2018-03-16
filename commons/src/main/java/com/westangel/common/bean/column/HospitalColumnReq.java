/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.column;<br/>  
 * <b>文件名：</b>HospitalColumnReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月13日下午7:08:40<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.column;

import java.io.Serializable;

/** 
* @ClassName: HospitalColumnReq
* @Description: 
* @author lichenghao
* @date 2016年7月13日 下午7:08:40  
*/
public class HospitalColumnReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//医院编号
	private Integer hospitalId;
	//获取列表  0 医院主页 1 图文消息
	private Integer reqFlag;
	//栏目类型
	private Integer columnType;
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	public Integer getColumnType() {
		return columnType;
	}
	public void setColumnType(Integer columnType) {
		this.columnType = columnType;
	}
	
	
	
	
}
