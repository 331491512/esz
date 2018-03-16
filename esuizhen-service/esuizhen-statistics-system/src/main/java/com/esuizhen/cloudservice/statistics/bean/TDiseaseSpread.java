/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TDiseaseSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午3:59:46<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.text.DecimalFormat;
import java.util.List;

/** 
* @ClassName: TDiseaseSpread
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午3:59:46  
*/
public class TDiseaseSpread {
	//总人数
	private Integer diseaseTotalNum;
	//病种统计项
	private List<TDiseaseSpreadItem> diseaseDistributionItems;
	
	public Integer getDiseaseTotalNum() {
		return diseaseTotalNum;
	}
	public void setDiseaseTotalNum(Integer diseaseTotalNum) {
		this.diseaseTotalNum = diseaseTotalNum;
	}
	public List<TDiseaseSpreadItem> getDiseaseDistributionItems() {
		return diseaseDistributionItems;
	}
	public void setDiseaseDistributionItems(List<TDiseaseSpreadItem> diseaseDistributionItems) {
		this.diseaseDistributionItems = diseaseDistributionItems;
	}
	
	public void initDiseaseDistributionItems(List<TDiseaseSpreadItem> diseaseDistributionItems){
		this.diseaseDistributionItems = diseaseDistributionItems;
		if(diseaseDistributionItems!=null&&diseaseDistributionItems.size()>0){
			int totalNum = 0;
			for(TDiseaseSpreadItem item : diseaseDistributionItems){
				totalNum+=item.getDiseaseNum();
			}
			this.diseaseTotalNum=totalNum;
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			for(TDiseaseSpreadItem item : diseaseDistributionItems){
				item.setDiseaseRate(decimalFormat
						.format(Double.parseDouble(item.getDiseaseNum()+"")
								/ Double.parseDouble(totalNum+"") * 100));
			}
		}
	}
}
