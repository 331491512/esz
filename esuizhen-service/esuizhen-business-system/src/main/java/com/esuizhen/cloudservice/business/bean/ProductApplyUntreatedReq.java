/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ProductApplyUntreatedReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月25日下午5:53:26<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ProductApplyUntreatedReq
* @Description: 
* @author lichenghao
* @date 2016年5月25日 下午5:53:26  
*/
public class ProductApplyUntreatedReq {
	//提供商
	private Integer vendor;
	//服务状态分类
	private Integer reqFlag;
	//分页索引
	private int page;
	//每页数量
	private int num;
	public Integer getVendor() {
		return vendor;
	}
	public void setVendor(Integer vendor) {
		this.vendor = vendor;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
