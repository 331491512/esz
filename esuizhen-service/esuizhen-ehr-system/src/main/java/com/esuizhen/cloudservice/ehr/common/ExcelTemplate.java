package com.esuizhen.cloudservice.ehr.common;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esuizhen.cloudservice.ehr.util.TemplateUtil;

public class ExcelTemplate {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelTemplate.class);
	
	public static final StringBuffer HEADER = new StringBuffer(
            "<html xmlns:x=\"urn:schemas-microsoft-com:office:excel\">")
            .append("<head>")
            .append("<meta http-equiv=\"content-type\" content=\"application/ms-excel; charset=UTF-8\"/>")
            .append("<!--[if gte mso 9]><xml>").append("<x:ExcelWorkbook>")
            .append("<x:ExcelWorksheets>").append("<x:ExcelWorksheet>").append(
                    "<x:Name></x:Name>").append("<x:WorksheetOptions>").append(
                    "<x:Print>").append("<x:ValidPrinterInfo />").append(
                    "</x:Print>").append("</x:WorksheetOptions>").append(
                    "</x:ExcelWorksheet>").append("</x:ExcelWorksheets>")
            .append("</x:ExcelWorkbook>").append("</xml><![endif]-->")
            .append("<style type=\"text/css\"><!-- ")
            .append(".txt{padding-top:1px;padding-right:1px;padding-left:1px;mso-ignore:padding;color:black;font-size:11.0pt;font-weight:400;font-style:normal;text-decoration:none;font-family:宋体;mso-generic-font-family:auto;mso-font-charset:134;mso-number-format:\"\\@\";text-align:general;vertical-align:middle;mso-background-source:auto;mso-pattern:auto;white-space:nowrap;} --> </style>")
            .append("</head>").append("<body>").append("<table>");
	
	public static final StringBuffer FOOTER = new StringBuffer("</table></body></html>");
	
	/**
	 * 根据属性key获取标题list
	 * @param key
	 * @return
	 */
	public static Collection<String> getTitle(String key) {
		Collection<String> titles = new ArrayList<String>();
		String tmp = TemplateUtil.getExcelExportInfo(key);
		LOGGER.info("打印标题列表:" + tmp);
		String[] titleSplit = tmp.split(",");
		for(String title : titleSplit) {
			titles.add(title);
		}
		return titles;
	}
}
