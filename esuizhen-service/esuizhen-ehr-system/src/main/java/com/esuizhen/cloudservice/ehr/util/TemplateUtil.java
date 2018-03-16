package com.esuizhen.cloudservice.ehr.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.esuizhen.cloudservice.ehr.common.Common;

/**
 * 
 * Title:TemplateUtil Description:获取指定模版内容工具类
 * 
 * @Create_by:yuanwenming
 * @Create_date:2013-9-23
 * @Last_Edit_By:
 * @Edit_Description
 * @version:1.0
 * 
 */
public class TemplateUtil {
	private static final Log log = LogFactory.getLog(TemplateUtil.class);

	/**
	 * 获取模板KEY对应的内容
	 * 
	 * @param resourcePath
	 * @param msgId
	 * @return String
	 */
	private static String getSendTemplate(String resourcePath, String key) {
		try {
			return new PropReader(resourcePath).getString(key);
		} catch (Exception e) {
			log.error("读取资源文件" + resourcePath + "出错！");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 替换模板占位符的值
	 * 
	 * @param templateContent
	 *            模板内容
	 * @param map
	 *            占位符的值
	 * @return String
	 */
	private static String compose(String templateContent,
	        Map<String, String> map) {
		if (map == null) {
			return templateContent;
		} else {
			for (String key : map.keySet()) {
				templateContent = templateContent.replaceAll("\\$\\{" + key
				        + "\\}", map.get(key));
			}
			return templateContent;
		}
	}

	private static String getMsg(String templateContent, Map<String, String> map) {
		if (templateContent != null) {
			return compose(templateContent, map);
		}
		return null;
	}

	public static String getTemplateMsg(String template, String templateType,
	        Map<String, String> templateMap) {
		String templateContent = null;
		templateContent = getSendTemplate(template, templateType);
		if (templateContent != null) {
			return getMsg(templateContent, templateMap);
		} else {
			return null;
		}
	}
	
	public static String getTemplateMsg(String template, String templateType) {
		String templateContent = null;
		templateContent = getSendTemplate(template, templateType);
		if (templateContent != null) {
			return getMsg(templateContent, new HashMap<String, String>());
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * Description:获取excel配置信息
	 * @param templateType
	 * @return
	 */
	public static String getExcelExportInfo(String templateType) {
		return getSendTemplate(Common.EXCEL_TEMPLATE_PATH,templateType);
	}
}
