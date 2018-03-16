/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import com.westangel.common.bean.sys.TagInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenghao
 * @date  2017年2月17日 下午3:43:11
 */
public interface ProductTagDao {
	//获取商品标签
	public List<TagInfo> getProductTags(@Param("productId")String productId);
	//获取患者标签
	public List<TagInfo> getPatientTags(@Param("userId")Long userId);
	//获取规则标签
	public List<TagInfo> getRuleTags(@Param("ruleId")String ruleId);
	//删除患者标签
	public int deleteProductTag(@Param("productId")String productId);
	//创建商品标签
	public int createtProductTagList(@Param("productId")String productId,@Param("list")List<TagInfo> list);

	List<TagInfo> findContentTagsByRule(String ruleId);
}
