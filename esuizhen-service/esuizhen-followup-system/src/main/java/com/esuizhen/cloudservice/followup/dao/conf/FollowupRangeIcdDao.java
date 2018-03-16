package com.esuizhen.cloudservice.followup.dao.conf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.TFollowupRangeIcdCodeText;

public interface FollowupRangeIcdDao {

	public List<TFollowupRangeIcdCodeText>queryAllFollowupRangeIcdCodeText();
	
	public void batchInsertFollowupRangeIcdCodeText(@Param("followupRangeIcdCodeTextList")List<TFollowupRangeIcdCodeText> followupRangeIcdCodeTextList);
	
	public void deleteAllFollowupRangeIcdCodeText();
	
	public Map<String,Object> queryDiseaseTypeIcdByCode(String diseaseCode);
	
	public void batchInsertFollowupRangeIcd(TFollowupRangeIcdCodeText followupRangeIcdCodeText);
	
	public void deleteAllFollowupRangeIcd();
	
	public void batchInsertFollowupRangeIcdCode(TFollowupRangeIcdCodeText followupRangeIcdCodeText);
	
	public void deleteAllFollowupRangeIcdCode();
}
