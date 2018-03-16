package com.westangel.common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

/**
 * @ClassName: WordUtil
 * @Description:Word文档工具类
 * @author wang_hw
 * @date 2016年3月21日 上午11:31:29
 */
@Component
public class WordTxtUtil
{

	private static String picturePath;

	private static String htmlBegin;
	
	private static String htmlEnd;
	/**
	 * @author wang_hw
	 * @title :convertWord2Html
	 * @Description:将word转换为Html（仅支持word2003）
	 * @return void
	 * @date 2016年4月7日 下午3:09:47
	 */
	public static void convertWord2Html(File fileName, File outPutFile)
	{
		try {
			LogUtil.log.info("开始转换文件" + fileName);
			HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));
			WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
			wordToHtmlConverter.setPicturesManager(new PicturesManager()
			{
				public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches, float heightInches)
				{
					return picturePath + suggestedName;
				}
			});
			wordToHtmlConverter.processDocument(wordDocument);

			// 保存word内图片
			List<Picture> pics = wordDocument.getPicturesTable().getAllPictures();
			if (pics != null) {
				for (int i = 0; i < pics.size(); i++) {
					Picture pic = (Picture) pics.get(i);
					try {
						pic.writeImageContent(new FileOutputStream(picturePath + pic.suggestFullFileName()));
					} catch (Exception e) {
						LogUtil.logError.error(e.getMessage());
					}
				}
			}

			Document htmlDocument = wordToHtmlConverter.getDocument();

			// 数据输出流
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DOMSource domSource = new DOMSource(htmlDocument);
			StreamResult streamResult = new StreamResult(out);

			// 转换器
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer serializer = tf.newTransformer();
			serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty(OutputKeys.METHOD, "html");
			serializer.transform(domSource, streamResult);
			out.close();

			// 写入到文件
			FileUtils.writeByteArrayToFile(outPutFile, out.toByteArray());
			LogUtil.log.info("文件转换成功" + outPutFile);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
		}
	}
	
	/**
	 * @author wang_hw
	 * @title :convertTxt2Html
	 * @Description:txt转换为Html
	 * @return void
	 * @date 2016年4月7日 下午4:45:02
	 */
	public static void convertTxt2Html(File sourceFile, File outPutFile)
    {  
    	try 
    	{
    		StringBuffer sb = new StringBuffer();
    		sb.append(htmlBegin);
    		sb.append(stringToHtml(StringEscapeUtils.escapeHtml(FileUtils.readFileToString(sourceFile))));
    		sb.append(htmlEnd);
			FileUtils.writeStringToFile(outPutFile,sb.toString() );
		} catch (IOException e) 
		{
			LogUtil.logError.error(e.getMessage());
		}
    }

	/**
	 * @author wang_hw
	 * @title :stringToHtml
	 * @Description:字符串替换为Html
	 * @return String
	 * @date 2016年4月7日 下午4:44:00
	 */
	private static String stringToHtml(String s) 
	{
    	StringBuilder builder = new StringBuilder();
    	for (char c : s.toCharArray()) 
    	{
	    	switch (c)
	    	{
	    		case '\n':
	    			builder.append("<br>");
	    			break;
	    		case '\r':
	    			builder.append("<br>");
	    			break;
	    		case ' ':
	    			builder.append("&nbsp;");
	    			break;
	    		case '\t':
	    			builder.append("&nbsp;&nbsp;&nbsp;&nbsp;");
	    			break;
	    		default:
	    			builder.append(c);
	    	}
    	}
    	String converted = builder.toString();
    	return converted;
	}

	@Value("${picture.path}")
	public void setPicPath(String picturePath)
	{
		WordTxtUtil.picturePath = picturePath;
	}

	@Value("${preview.html.begin}")
	public void setPreviewHtmlBegin(String htmlBegin)
	{
		WordTxtUtil.htmlBegin = htmlBegin;
	}
	
	@Value("${preview.html.end}")
	public void setPreviewHtmlEnd(String htmlEnd)
	{
		WordTxtUtil.htmlEnd = htmlEnd;
	}
	
}
