/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TProductApplyStatisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月25日下午4:53:27<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: TProductApplyStatisInfo
* @Description: 
* @author lichenghao
* @date 2016年5月25日 下午4:53:27  
*/
public class TProductApplyStatisInfo {
	//等待服务
	private Integer wait;
	//取消的服务
	private Integer cancel;
	//损失金额
	private Float loss;
	public Integer getWait() {
		return wait;
	}
	public void setWait(Integer wait) {
		this.wait = wait;
	}
	public Integer getCancel() {
		return cancel;
	}
	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}
	public Float getLoss() {
		return loss;
	}
	public void setLoss(Float loss) {
		this.loss = loss;
	}
}
