/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.controller;<br/>  
 * <b>文件名：</b>ArticleController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月19日下午5:04:28<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.controller;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.sys.bean.KnowledgeTitleListReq;
import com.westangel.commonservice.sys.bean.SysTag;
import com.westangel.commonservice.sys.service.ArticleService;
import com.westangel.commonservice.sys.service.SysTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/** 
* @ClassName: ArticleController
* @Description: 
* @author lichenghao
* @date 2016年7月19日 下午5:04:28  
*/
@Controller
public class ArticleController {
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ArticleService articleService;

	@Autowired
	private SysTagService sysTagService;
	/**
	 * 获取文章标题列表
	 * @author jiayanzhao
	 * @title :sysListArticleTitle
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月17日 下午4:49:51
	 */
	@ResponseBody
	@RequestMapping(value="/knowledge/article/title/list",method=RequestMethod.POST)
	public TMsgResponse<Page> getArticleTitleList(@RequestBody KnowledgeTitleListReq req,Locale locale){
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page page = articleService.getArticleTitle(req);
			msg.setResult(page);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}
	
	/**
	 * 获取文章内容
	 * @author jiayanzhao
	 * @title :sysQueryArticleContent
	 * @Description:TODO
	 * @return TMsgResponse<String>
	 * @date 2015年12月17日 下午4:49:51
	 */
	@ResponseBody
	@RequestMapping(value="/knowledge/article/content/query",method=RequestMethod.GET)
	public TMsgResponse<Object> getsysQueryArticleContent(int articleId,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result = articleService.getArticleContent(articleId);
		}catch(EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1409.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		} 
		catch (Exception e) {
			e.printStackTrace();
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getArticleMetaEdiseaseBodyPartTypeList
	 * @Description:TODO
	 * @return 获取文章对应的疾病部位和病种
	 * @date 2016年7月19日 下午5:31:51
	 */
	@ResponseBody
	@RequestMapping(value="/knowledge/article/disease/body/part/list/get",method=RequestMethod.GET)
	public TMsgResponse<Object> getArticleMetaEdiseaseBodyPartTypeList(Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result = articleService.getArticleMetaEdiseaseBodyPartTypeList();
		}
		catch (Exception e) {
			e.printStackTrace();
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value="/knowledge/article/tag/list/get",method=RequestMethod.GET)
	public TMsgResponse<List<SysTag>> getArticleTagList (@RequestParam(value = "tagType", defaultValue = "1") Integer tagType, Locale locale){
		TMsgResponse<List<SysTag>> msg = new TMsgResponse<List<SysTag>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result = sysTagService.findSysTagByTagTypeId(tagType);
		}
		catch (Exception e) {
			e.printStackTrace();
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/*@RequestMapping(value = "/knowledge/article/rule/list")
	@ResponseBody
	public TMsgResponse<Page> getKnowledgeArticleByRule(Locale locale, Integer ruleId,Integer page,Integer num){
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			ArticleReq req=new ArticleReq();
			req.setRuleId(ruleId);
			req.setNum(num);
			req.setPage(page);
			msg.result=articleService.getArticlesByRule(req);
		} catch (EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msg;
	}*/
}
