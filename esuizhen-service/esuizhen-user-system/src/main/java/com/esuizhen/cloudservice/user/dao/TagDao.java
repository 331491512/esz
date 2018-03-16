package com.esuizhen.cloudservice.user.dao;

import java.util.List; 
import java.util.Map;




import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.Tag;


public interface TagDao {

	List<Tag> findmenuTagList(Map<String, Object> searchParams);
	
	public int getTagIdByTagName(String tem);
	
	List<Integer> getTagIdByArticleId(@Param("articleId")long articleId);

	public void saveArticleTag(@Param("articleId")long articleId,@Param("list")List<Integer> articleTagsList);
}
