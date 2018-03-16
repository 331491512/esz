/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util.match;<br/>  
 * <b>文件名：</b>MatchMergeUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年4月7日下午5:40:56<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.common.util.match;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sync.MatchUserMergeReq;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: MatchMergeUtil
* @Description: 
* @author lichenghao
* @date 2017年4月7日 下午5:40:56  
*/
@Component
public class MatchMergeUtil {
	@Value("${server.api.url.root}")
	private String apiRoot;
	@Value("${sync.server.user.match.merge}")
	private String mergeUrl;
	//匹配合并请求
    public void matchUserMergeRequest(MatchUserMergeReq req){
    	String url = apiRoot+mergeUrl;
    	LogUtil.log.debug(url);
    	String result = HttpUtil.postWithJSON(url, JsonUtil.toJson(req));
    	TMsgResponse<Object> msg = JsonUtil.toObject(result, TMsgResponse.class);
    	if(msg.getRespCode()==ErrorMessage.SUCCESS.code){
    	}else{
    		LogUtil.logError.error(msg.getRespMsg());
    		throw new EmptyObjectExcption(msg.getRespMsg());
    	}
    }
}
