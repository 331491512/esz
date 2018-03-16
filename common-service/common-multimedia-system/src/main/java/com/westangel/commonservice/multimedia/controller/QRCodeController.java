package com.westangel.commonservice.multimedia.controller;

import java.io.File;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.multimedia.TPicUploadResp;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.multimedia.util.image.ImageHandlerUtil;
import com.westangel.commonservice.multimedia.util.qrcode.QRCodeUtil;

@Controller
public class QRCodeController {

	@Autowired
	private MessageSource messageSource;
	@Value("${temp.path}")
	private String tempPath;
	
	@Value("${temp.url}")
	private String tempUrl;

	/**
	 * <p>Title:createCustomQRCode</p>
	 * <p>Description:生成自定义二维码</p>
	 * @author YYCHEN
	 * @date 2016年10月18日 下午3:00:14
	 * @param locale
	 * @param text
	 * @param doctorId
	 * @param patientId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/custom/qr/code/create", method = RequestMethod.GET)
	public TMsgResponse<Object> createCustomQRCode(Locale locale, String text, Long doctorId, Long patientId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> tMsgResponse = new TMsgResponse<Object>();
		tMsgResponse.respCode = ErrorMessage.SUCCESS.code;
		tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		StringBuilder builder = new StringBuilder();
		String fileName = null;
		if (doctorId != null) {
			builder.append(doctorId);
			builder.append("_");
		}
		if (patientId != null) {
			builder.append(patientId);
		}
		if (builder.length() > 0) {
			builder.append(".jpg");
			fileName = builder.toString();
		}
		try {
			fileName = QRCodeUtil.encode(text, this.getClass().getClassLoader().getResource("image/logo_96_96.png").getPath(), fileName, this.tempPath, true);
			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			resp.setPicUrl(this.tempUrl + fileName);
			tMsgResponse.setResult(resp);
		} catch (Exception ex) {
			ex.getStackTrace();
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.respCode = ErrorMessage.E1500.code;
			tMsgResponse.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

}
