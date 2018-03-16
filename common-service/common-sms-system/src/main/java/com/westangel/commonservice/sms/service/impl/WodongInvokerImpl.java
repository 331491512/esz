package com.westangel.commonservice.sms.service.impl;

import com.westangel.common.bean.ProductInfo;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.TimeUtil;
import com.westangel.commonservice.sms.dao.SmsDao;
import com.westangel.commonservice.sms.model.SmsCaptchaRecordInfo;
import com.westangel.commonservice.sms.model.SmsTemplateMessageInfo;
import com.westangel.commonservice.sms.model.wodong.WodongChannelInfo;
import com.westangel.commonservice.sms.model.wodong.WodongChannelMap;
import com.westangel.commonservice.sms.service.SmsInvoker;
import com.westangel.commonservice.sms.util.SmsUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nidan on 2017年07月13 上午 9:49
 */
@Service(value = "wodongService")
public class WodongInvokerImpl implements SmsInvoker {

    @Autowired
    private SmsDao smsDao;

    @Value("${wodong.url}")
    private String wodongUrl;

    @Autowired
    private WodongChannelMap channelMap;

    @PostConstruct
    public void initConfigure()
    {
        //配置通道
        List<WodongChannelInfo> channels = smsDao.getWodongChannelList();
        if (null != channels) {
            for(WodongChannelInfo channel:channels){
                channelMap.put(key4BusinessProduct(channel.getBusinessId(), channel.getProductId()), channel);
            }
        }
    }

    @Override
    public boolean sendCapatcha(ProductInfo product, String mobile, String templateText) {
        boolean ret = false;
        SmsCaptchaRecordInfo record = smsDao.getCaptcha(product.getBusinessId(), product.getProductId(), mobile, null);

        if (null != record) {
            Long timing = 0L;
            try {
                timing = TimeUtil.timingWithNow(record.getOccurTime());
            } catch (Exception e) {
            }
            if (timing > 30*60000) {
                record = null;
            }
        }
        String captcha = (null != record)?record.getCaptcha(): SmsUtil.getCaptchaNum();
        String content = org.springframework.util.StringUtils.replace(templateText, "{0}", captcha);
        if (sendSms(mobile, content, product)){
            smsDao.saveCaptcha(product.getBusinessId(), product.getProductId(), mobile, captcha);
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean sendContent(ProductInfo product, List<String> moblies, String content) {
        String mobiles = new String();
        for(int i = 0; i < moblies.size(); i++){
            mobiles += moblies.get(i);
            if (i != moblies.size()-1) {
                mobiles += ",";
            }
        }
        return sendSms(mobiles, content, product);
    }

    /**
     * 短信发送
     * @param mobiles
     * @param content
     * @param product
     * @return
     */
    private boolean sendSms(String mobiles, String content, ProductInfo product){
        if (StringUtils.isEmpty(mobiles)) {
            throw new RuntimeException("发送的目标手机号不能为空！");
        }
        if (StringUtils.isEmpty(content)) {
            throw new RuntimeException("发送的短信内容不能为空！");
        }
        String key = key4BusinessProduct(product.getBusinessId(), product.getProductId());
        WodongChannelInfo channel = channelMap.get(key);
        if (null == channel) {
            throw new RuntimeException("易信通没有找到发送通道：(" + key + ")!");
        }
        boolean ret = false;
        List<NameValuePair> paras = new ArrayList<NameValuePair>();
        paras.add(new BasicNameValuePair("action","send"));
        paras.add(new BasicNameValuePair("userid", channel.getUserId()));
        paras.add(new BasicNameValuePair("account", channel.getAccount()));
        paras.add(new BasicNameValuePair("password", channel.getPassword()));
        paras.add(new BasicNameValuePair("mobile", mobiles));
        paras.add(new BasicNameValuePair("content", content+"【易随诊】"));

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        String result = HttpUtil.postForm(wodongUrl+"/sms.aspx", paras,"UTF-8", map);
        try{
            LogUtil.log.info("wodong短信响应结果："+new String(result.getBytes(),"utf-8"));
        }catch (Exception e){

        }
        if (null == result) {
            throw new RuntimeException("发送到服务器失败！");
        } else {
            if (-1 == com.mysql.jdbc.StringUtils.indexOfIgnoreCase(result, "<returnstatus>Success</returnstatus>")){
                LogUtil.logError.error("sendSms:\n"+result);
                throw new RuntimeException("发送失败，请稍后再试！");
            } else {
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public boolean sendTemplateMessage(ProductInfo product, String mobile, SmsTemplateMessageInfo templateMessageInfo) {
        String content = new String();
        content += templateMessageInfo.getExpression();
        for(int i = 0; i < templateMessageInfo.getValues().size(); i++){
            String part = "{"+i+"}";
            content = org.springframework.util.StringUtils.replace(content, part, templateMessageInfo.getValues().get(i));
        }
        return sendSms(mobile, content, product);
    }

    public String key4BusinessProduct(Integer businessId, Integer productId)
    {
        return ""+businessId+"-"+productId+"";
    }

    @Override
    public boolean callTwoway(ProductInfo product, String from, String to, String serFrom, String serTo, String userData, String maxCallTime, String callbackUrl) {
        LogUtil.log.info("沃动不提供电话功能");
        return false;
    }

    @Override
    public Object getReceipt(ProductInfo product) {
        LogUtil.log.info("沃动暂时只用于云端");
        return null;
    }

    @Override
    public Object getSmsSendReport(String channelName) {
        LogUtil.log.info("沃动暂时只用于云端");
        return null;
    }
}
