package com.westangel.commonservice.multimedia.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.multimedia.TPicUploadResp;
import com.westangel.common.bean.weixin.WeixinMediaGetReq;
import com.westangel.common.service.WeixinInnerService;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.WordTxtUtil;
import com.westangel.commonservice.multimedia.util.audio.ChangeAudioFormat;
import com.westangel.commonservice.multimedia.util.image.ImageHandlerUtil;

@Controller
public class MultimediaController {

	@Autowired
	private MessageSource messageSource;

	@Value("${image.format}")
	private String imageFormat;

	/*********** 上传文件保存路径 ************/
	@Value("${image.path}")
	private String imagePath;

	@Value("${audio.path}")
	private String audioPath;

	@Value("${html.path}")
	private String htmlPath;

	@Value("${file.path}")
	private String filePath;

	@Value("${previewfile.path}")
	private String previewfilePath;

	/*********** 上传文件Url ************/
	@Value("${image.url}")
	private String imageUrl;

	@Value("${audio.url}")
	private String audioUrl;

	@Value("${file.url}")
	private String fileUrl;

	@Value("${previewfile.url}")
	private String previewfileUrl;

	@Autowired
	private WeixinInnerService service;

	/**
	 * @author wang_hw
	 * @title :upload
	 * @Description:图片上传
	 * @return TMsgResponse<TPicUploadResp>
	 * @date 2015年12月17日 下午6:58:52
	 */
	@ResponseBody
	@RequestMapping(value = "/pic/upload", method = RequestMethod.POST)
	public TMsgResponse<TPicUploadResp> uploadPic(@RequestParam("file") CommonsMultipartFile uploadFile,
			Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TPicUploadResp> msg = new TMsgResponse<TPicUploadResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 图片上传
			String fileName = System.currentTimeMillis()
					+ ImageHandlerUtil.getFileSuffix(uploadFile.getOriginalFilename());
			File localFile = new File(imagePath + fileName);
			uploadFile.transferTo(localFile);
			ImageHandlerUtil.taskExec(localFile);

			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			fileName = fileName.replace(ImageHandlerUtil.getFileSuffix(fileName),
					"_ico" + ImageHandlerUtil.getFileSuffix(fileName));
			resp.setPicUrl(imageUrl + fileName);
			msg.result = resp;
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/pic/wechat/upload", method = RequestMethod.GET)
	public TMsgResponse<TPicUploadResp> uploadPicWechat(String mediaId,Integer productId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TPicUploadResp> msg = new TMsgResponse<TPicUploadResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 图片上传
			String fileName = System.currentTimeMillis() + imageFormat;
			File localFile = new File(imagePath + fileName);

			// 微信拉取图片
			WeixinMediaGetReq req = new WeixinMediaGetReq();
			req.setMedia_id(mediaId);
			req.setBusinessId(1);
			if(productId==null)
				req.setProductId(2);
			else
				req.setProductId(productId);
			req.setPath(localFile.getAbsolutePath());
			service.downloadMediaFile(req);

			// 压缩图片
			ImageHandlerUtil.taskExec(localFile);

			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			fileName = fileName.replace(ImageHandlerUtil.getFileSuffix(fileName),
					"_ico" + ImageHandlerUtil.getFileSuffix(fileName));
			resp.setPicUrl(imageUrl + fileName);
			msg.result = resp;
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/audio/upload", method = RequestMethod.POST)
	public TMsgResponse<TPicUploadResp> uploadAudio(@RequestParam("file") MultipartFile uploadFile, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TPicUploadResp> msg = new TMsgResponse<TPicUploadResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 音频上传
			String fileName = System.currentTimeMillis()
					+ ImageHandlerUtil.getFileSuffix(uploadFile.getOriginalFilename());
			File localFile = new File(audioPath + fileName);
			uploadFile.transferTo(localFile);
			try{
				if(localFile.getPath().indexOf(".amr")>-1)
					ChangeAudioFormat.changeToMp3(localFile.getPath(), localFile.getPath().replace(".amr", ".mp3"));
			}catch(Exception e){
				e.printStackTrace();
			}
			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			resp.setAudioUrl(audioUrl + fileName);
			msg.result = resp;

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	public TMsgResponse<TPicUploadResp> uploadFile(@RequestParam("file") MultipartFile uploadFile, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TPicUploadResp> msg = new TMsgResponse<TPicUploadResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 文档上传
			String fileName = System.currentTimeMillis()
					+ ImageHandlerUtil.getFileSuffix(uploadFile.getOriginalFilename());
			File localFile = new File(filePath + fileName);
			uploadFile.transferTo(localFile);

			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			resp.setFileUrl(fileUrl + fileName);
			msg.result = resp;

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/preview/file/upload", method = RequestMethod.POST)
	public TMsgResponse<TPicUploadResp> uploadPreviewFile(@RequestParam("file") MultipartFile uploadFile,
			Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TPicUploadResp> msg = new TMsgResponse<TPicUploadResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 文档上传
			String suffix = ImageHandlerUtil.getFileSuffix(uploadFile.getOriginalFilename());

			if (!".txt".equalsIgnoreCase(suffix) &&
					!".doc".equalsIgnoreCase(suffix) &&
					!".pdf".equalsIgnoreCase(suffix)) {
				LogUtil.logError.error("文件上传格式错误");
				throw new RuntimeException();
			}
			File dir = new File(previewfilePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String fileName = System.currentTimeMillis() + suffix;
			File localFile = new File(previewfilePath + fileName);
			File outPutFile = new File(htmlPath + fileName.replace(suffix, ".html"));

			uploadFile.transferTo(localFile);

			// 文件转换
			if (".txt".equals(suffix)) {
				WordTxtUtil.convertTxt2Html(localFile, outPutFile);

			} else if (".doc".equals(suffix)) {
				WordTxtUtil.convertWord2Html(localFile, outPutFile);
			}

			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			resp.setPreviewFileUrl(previewfileUrl + fileName);
			msg.result = resp;

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/compress/file", method = RequestMethod.GET)
	public TMsgResponse<TPicUploadResp> compressFile(Locale locale, String filePath) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TPicUploadResp> msg = new TMsgResponse<TPicUploadResp>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		File file = new File(filePath);
		String fileName = file.getName().substring(0, file.getName().lastIndexOf(".")) + ".zip";
		File baseDir = new File(previewfilePath);
		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}
		File zipFile = new File(previewfilePath + fileName);
		if (zipFile.exists()) {
			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			resp.setFilePath(previewfileUrl + fileName);
			msg.setResult(resp);
			return msg;
		}

		File localFile = new File(previewfilePath + file.getName());
		if (!localFile.exists()) {
			this.downloadFile(filePath, localFile.getAbsolutePath());
		}
		ZipOutputStream zos = null;
		BufferedOutputStream bos = null;
		try {
			// 创建写出流操作
			OutputStream os = new FileOutputStream(zipFile);
			bos = new BufferedOutputStream(os);
			zos = new ZipOutputStream(bos);

			String basePath = null;

			// 获取目录
			if (file.isDirectory()) {
				basePath = file.getPath();
			} else {
				basePath = file.getParent();
			}

			this.zipFile(localFile, basePath, zos);

			// 设置返回结果
			TPicUploadResp resp = new TPicUploadResp();
			resp.setFilePath(previewfileUrl + fileName);
			msg.setResult(resp);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		} finally {
			if (zos != null) {
				try {
					zos.closeEntry();
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return msg;
	}

	/**
	 * <p>
	 * Title:downloadFile
	 * </p>
	 * <p>
	 * Description:将远程文件下载到本地
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年7月25日 下午1:11:26
	 * @param remoteFilePath
	 * @param localFilePath
	 */
	private void downloadFile(String remoteFilePath, String localFilePath) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File(localFilePath);
		try {
			urlfile = new URL(remoteFilePath);
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
		} catch (Exception e) {
			LogUtil.logError.error("下载文件到本地出错：" + e.getMessage());
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * <p>
	 * Title:zipFile
	 * </p>
	 * <p>
	 * Description:压缩文件
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年7月25日 下午1:11:52
	 * @param source
	 * @param basePath
	 * @param zos
	 * @throws IOException
	 */
	private void zipFile(File source, String basePath, ZipOutputStream zos) throws IOException {
		File[] files = null;
		if (source.isDirectory()) {
			files = source.listFiles();
		} else {
			files = new File[1];
			files[0] = source;
		}

		InputStream is = null;
		BufferedInputStream bis = null;
		String pathName;
		byte[] buf = new byte[1024];
		int length = 0;
		try {
			for (File file : files) {
				if (file.isDirectory()) {
					//pathName = file.getPath().substring(basePath.length() + 1) + "/";
					pathName = file.getName() + "/";
					zos.putNextEntry(new ZipEntry(pathName));
					zipFile(file, basePath, zos);
				} else {
					//pathName = file.getPath().substring(basePath.length() + 1);
					pathName = file.getName();
					is = new FileInputStream(file);
					bis = new BufferedInputStream(is);
					zos.putNextEntry(new ZipEntry(pathName));
					while ((length = bis.read(buf)) != -1) {
						zos.write(buf, 0, length);
					}
				}
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (bis != null) {
				bis.close();
			}
		}

	}
}
