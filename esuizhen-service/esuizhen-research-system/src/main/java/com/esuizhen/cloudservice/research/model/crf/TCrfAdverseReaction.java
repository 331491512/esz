package com.esuizhen.cloudservice.research.model.crf;

import java.util.List;

/**
* @ClassName: TCrfAdverseReaction 
* @Description: CRF-观察项-不良反映信息
* @author wang_hw
* @date 2016年4月15日 下午6:18:31
 */
public class TCrfAdverseReaction{
	
	/**
	 * 观察项ID
	 */
	private String crfObserveId;
	
	/**
	 * 不良反映明细列表
	 */
	private List<TCrfAdverseReactionInfo> adverseReactionList;

	public String getCrfObserveId()
	{
		return crfObserveId;
	}

	public void setCrfObserveId(String crfObserveId)
	{
		this.crfObserveId = crfObserveId;
	}

	public List<TCrfAdverseReactionInfo> getAdverseReactionList()
	{
		return adverseReactionList;
	}

	public void setAdverseReactionList(List<TCrfAdverseReactionInfo> adverseReactionList)
	{
		this.adverseReactionList = adverseReactionList;
	}
	
	

}

