package com.esuizhen.cloudservice.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.Tag;
import com.esuizhen.cloudservice.user.service.TagService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.util.LogUtil;



@Controller
public class TagController {

	@Autowired
	private TagService tagService;
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/disease/tag/list",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<Tag>> getDiseaseTagList(@RequestBody Tag tag,Locale locale){
		TMsgResponse<List<Tag>> msg=new TMsgResponse<List<Tag>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			Map<String, Object> searchParams = new HashMap<String, Object>();
			if(tag!=null){
				searchParams.put("tagTypeId", tag.getTagTypeId());
				searchParams.put("tagName", tag.getTagName());
			}
			List<Tag> listTags = this.tagService.findmenuTagList(searchParams);
			if(listTags!=null && listTags.size()>0){
				msg.setResult(listTags);
			}
		} catch (Exception e) {
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
}
