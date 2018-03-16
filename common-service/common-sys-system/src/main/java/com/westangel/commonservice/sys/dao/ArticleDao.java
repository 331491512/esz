/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.dao;<br/>  
 * <b>文件名：</b>SysDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日上午9:50:29<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.dao;

import com.westangel.commonservice.sys.bean.ArticleReq;
import com.westangel.commonservice.sys.bean.KnowledgeTitleListReq;
import com.westangel.commonservice.sys.bean.TArticleTitle;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/** 
* @ClassName: SysDao
* @Description: 底层服务dao
* @author lichenghao
* @date 2015年12月17日 上午9:50:29  
*/
public interface ArticleDao {
	// 查询疾病知识
	public List<TArticleTitle> queryArticleTitleList(Object param);

	// 获取疾病知识
	public LinkedHashMap<String,Object> queryArticleContent(int articleId);
	
	// 获取病种和疾病部位元数据
	public List<LinkedHashMap<String,Object>> queryArticleMetaEdiseaseBodyPartTypeList();

	public Integer findIcdDiseaseTypeIdByPatientId(Long patientId);

	public List<TArticleTitle> findArticleTitleByTag(KnowledgeTitleListReq req);

    List<TArticleTitle> findArticleListByRule(@Param("req") ArticleReq req, @Param("articleTypes") List<Integer> articleTypes);
}
