/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.service;<br/>  
 * <b>文件名：</b>SysService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日上午10:04:16<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.service;

import com.westangel.common.bean.Page;
import com.westangel.commonservice.sys.bean.ArticleReq;
import com.westangel.commonservice.sys.bean.KnowledgeTitleListReq;
/**
 * 
* @ClassName: ArticleService 
* @Description: 疾病知识相关
* @author lichenghao
* @date 2016年7月19日 下午5:00:27
 */
public interface ArticleService {

	/**
	 * 获得疾病知识文章标题列表
	 * @author jiayanzhao
	 * @title :reloadRTFToText
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月20日 上午11:05:09
	 */
	Page getArticleTitle(KnowledgeTitleListReq req);
	
	/**
	 * 获得疾病知识文章内容
	 * @author jiayanzhao
	 * @title :reloadRTFToText
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月20日 上午11:05:09
	 */
	Object getArticleContent(int articleId);
	
	/**
	 * 获取文章对应的疾病病种
	 * @author lichenghao
	 * @title :getArticleMetaEdiseaseBodyPartTypeList
	 * @Description:TODO
	 * @return Object
	 * @date 2016年7月19日 下午5:29:00
	 */
	Object getArticleMetaEdiseaseBodyPartTypeList();

	/**
	 * 根据规则获取文章列表
	 * @param req
	 * @return
	 */
	Page getArticlesByRule(ArticleReq req);

}
