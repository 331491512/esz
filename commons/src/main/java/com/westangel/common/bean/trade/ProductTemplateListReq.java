/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>ProductTemplateListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月17日上午10:46:16<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;
/** 
* @ClassName: ProductTemplateListReq
* @Description: 
* @author lichenghao
* @date 2017年2月17日 上午10:46:16  
*/
public class ProductTemplateListReq {
	/**
			 * 模版类型
		不传：返回所有
		0：服务类型
		1：自运营（商品添加中使用）

	 */
	private Integer templateType;
	
	/**
	 * 使用范围标识。
		0：全部
		1：仅医生（默认）【如果医生端请求产品列表，则 只能返回usageFlag=1的产品模板】
		2：仅医院

	 */
	private int useageFlag=0;

	public Integer getTemplateType() {
		return templateType;
	}

	public void setTemplateType(Integer templateType) {
		this.templateType = templateType;
	}

	public int getUseageFlag() {
		return useageFlag;
	}

	public void setUseageFlag(int useageFlag) {
		this.useageFlag = useageFlag;
	}
}
