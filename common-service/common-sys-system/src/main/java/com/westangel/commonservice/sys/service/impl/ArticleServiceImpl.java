/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.service.impl;<br/>  
 * <b>文件名：</b>ArticleServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月19日下午5:01:39<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.sys.TagInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.PageUtil;
import com.westangel.commonservice.sys.bean.ArticleReq;
import com.westangel.commonservice.sys.bean.KnowledgeTitleListReq;
import com.westangel.commonservice.sys.bean.TArticleTitle;
import com.westangel.commonservice.sys.dao.ArticleDao;
import com.westangel.commonservice.sys.dao.SysTagDao;
import com.westangel.commonservice.sys.service.ArticleService;
import com.westangel.commonservice.sys.service.SysTagService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: ArticleServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年7月19日 下午5:01:39  
*/
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private SysTagDao sysTagDao;

	@Autowired
	private SysTagService sysTagService;

	@Override
	public Page getArticleTitle(KnowledgeTitleListReq req){
		List<TArticleTitle> articleTitles=null;
		if(req.getRuleId()!=null){
			ArticleReq articleReq=new ArticleReq();
			articleReq.setRuleId(req.getRuleId());
			articleReq.setNum(req.getNum());
			articleReq.setPage(req.getPageSize());
			List<TagInfo> tagInfos=sysTagDao.findContentTagsByRule(articleReq.getRuleId());
			List<Integer> articleTypes=getArticleType(req.getSourceType());
			if(tagInfos!=null&&tagInfos.size()>0){
				articleReq.setTagInfos(tagInfos);
				PageHelper.startPage(articleReq.getPage()+1,articleReq.getNum());
				articleTitles=articleDao.findArticleListByRule(articleReq,articleTypes);
			}else{
				Page<TArticleTitle> page=new Page<TArticleTitle>();
				page.setTotalNum(0);
				page.setCurrPage(0);
				page.setCurrSize(0);
				page.setTotalPage(0);
				return page;
			}
		}else{
			if(req.getPatientId()!=null){
				List<TagInfo> list=sysTagDao.getPatientTags(req.getPatientId());
				if(list!=null&&list.size()>0)
					req.setTags(list);
				else{
					list=new ArrayList<TagInfo>();
					TagInfo tagInfo=new TagInfo();
					tagInfo.setTagId(Constant.TAGID);
					list.add(tagInfo);
					req.setTags(list);
				}
			}
			PageHelper.startPage(req.getPageSize()+1,req.getNum());
			articleTitles=articleDao.queryArticleTitleList(req);
		}

		return PageUtil.returnPage((com.github.pagehelper.Page<TArticleTitle>)articleTitles);
	}

	private List<Integer> getArticleType(String sourceType) {
		List<Integer> articleTypes=null;
		if(!StringUtils.isBlank(sourceType)){
			articleTypes=new ArrayList<Integer>();
			String [] s=sourceType.split(",");
			for (String str : s){
				articleTypes.add(Integer.valueOf(str));
			}
		}
		return articleTypes;
	}

	@Override
	public Object getArticleContent(int articleId){
		return articleDao.queryArticleContent(articleId);
	}

	@Override
	public Object getArticleMetaEdiseaseBodyPartTypeList() {
		// TODO Auto-generated method stub
		return articleDao.queryArticleMetaEdiseaseBodyPartTypeList();
	}

	@Override
	public Page getArticlesByRule(ArticleReq req) {
		//if(req.getRuleId()==null){
		//	throw new EmptyParamExcption("ruleId is null");
		//}
		//List<TagInfo> tagInfos=sysTagDao.findContentTagsByRule(req.getRuleId());
		//if(tagInfos!=null&&tagInfos.size()>0){
		//	req.setTagInfos(tagInfos);
		//}else{
		//	return null;
		//}
		//PageHelper.startPage(req.getPage()+1,req.getNum());
		//List<TArticleTitle> articleTitles=articleDao.findArticleListByRule(req);
		//return PageUtil.returnPage((com.github.pagehelper.Page<TArticleTitle>)articleTitles);
		return null;
	}

}
