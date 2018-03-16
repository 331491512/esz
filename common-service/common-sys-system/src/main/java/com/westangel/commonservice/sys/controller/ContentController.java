package com.westangel.commonservice.sys.controller;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.sys.bean.ContentRule;
import com.westangel.commonservice.sys.service.ContentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * Created by Nidan on 2017年05月17 下午 17:59
 */
@Controller
public class ContentController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ContentSourceService contentSourceService;

    @RequestMapping(value = "/content/source/rule",method = RequestMethod.GET)
    @ResponseBody
    public TMsgResponse<ContentRule> getContentSourceByRule(String ruleId, Locale locale){
        TMsgResponse<ContentRule> msg=new TMsgResponse<ContentRule>();
        msg.setRespCode(ErrorMessage.SUCCESS.code);
        msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
        try{
            msg.result=contentSourceService.getContentSourceList(ruleId);
        } catch (EmptyParamExcption e){
            msg.setRespCode(ErrorMessage.E1400.code);
            msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
            LogUtil.logError.error(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            msg.setRespCode(ErrorMessage.E1500.code);
            msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
            LogUtil.logError.error(e.getMessage());
        }
        return msg;
    }


}
