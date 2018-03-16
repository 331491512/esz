/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.dao.user;<br/>  
 * <b>文件名：</b>DoctorKnowledgeArticleDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年9月29日下午2:49:15<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.dao.business;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.business.bean.ReviewAppointInfoGetReq;

/** 
* @ClassName: DoctorKnowledgeArticleDao
* @Description: 
* @author lichenghao
* @date 2016年9月29日 下午2:49:15  
*/
public interface BusinessSendDao {
	/**
	 * 
	 * @author lichenghao
	 * @title :createDoctorKnowledgeArticle
	 * @Description:患教知识入库
	 * @return int
	 * @date 2016年9月29日 下午2:50:25
	 */
	public int createDoctorKnowledgeArticle(Object param);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryKnowledgeArticleTitle
	 * @Description:获取患教知识标题
	 * @return void
	 * @date 2016年9月29日 下午4:22:50
	 */
	public String queryKnowledgeArticleTitle(@Param("articleId") String articleId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryQuestionnaireSubject
	 * @Description:获取问卷标题
	 * @return String
	 * @date 2016年9月30日 下午3:58:05
	 */
	public String queryQuestionnaireSubject(@Param("questionnaireId") String questionnaire);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :insertFolloupReviewAppoint
	 * @Description:添加复查内容
	 * @return void
	 * @date 2016年10月9日 下午12:05:06
	 */
	public void insertFolloupReviewAppoint(Object param);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getProductIdByHospitalId
	 * @Description:获取医院某项服务Id
	 * @return String
	 * @date 2016年10月9日 下午3:42:59
	 */
	public List<LinkedHashMap<String, Object>> getProductIdByHospitalId(Object param);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryReviewAppointInfo
	 * @Description:获取复查预约信息
	 * @return Object
	 * @date 2016年10月9日 下午4:16:02
	 */
	public LinkedHashMap<String, Object> queryReviewAppointInfo(ReviewAppointInfoGetReq req);
}
