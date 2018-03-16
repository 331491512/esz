package com.esuizhen.cloudservice.ehr.util;

import java.io.IOException;  
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;




import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelExportUtils {
	private static final Logger log = LoggerFactory.getLogger(ExcelExportUtils.class);
	
	/**
	 * 
	 * Description:导出excel
	 * 
	 * @param fundListDTO
	 * @param resp
	 * @param templateFile
	 *            模板文件
	 * @param destFile
	 *            导出文件
	 */
	public static void exportExcel(List<List<?>> objects, List<String> listSheetNames,HttpServletResponse resp,
	        String templateFile, String destFile,Map<String, Object> beanMap) {
		String templateFileName = TemplateUtil.getExcelExportInfo(templateFile);
		log.debug("获取excel模板文件路径:templateFileName=" + templateFileName);
		String destFileName = TemplateUtil.getExcelExportInfo(destFile);
		log.debug("导出excel文件名:templateFileName=" + destFileName);
		InputStream in = ExcelExportUtils.class.getResourceAsStream(templateFileName);
		
		XLSTransformer transformer = new XLSTransformer();
		OutputStream out = null;
		// 设置响应
		resp.setHeader("Content-Disposition", "attachment;filename="
		        + destFileName + System.currentTimeMillis() + ".xls");
		resp.setContentType("application/x-download");
		try {
			Workbook workBook = transformer.transformMultipleSheetsList(in,objects, listSheetNames, "list",beanMap, 0);
			out = resp.getOutputStream();
			// 将内容写入输出流并把缓存的内容全部发出去
			workBook.write(out);
			out.flush();
			out.close();
			in.close();
		} catch (ParsePropertyException e) {
			log.error("输入流为空，获取输入流失败" + in, e);
		} catch (InvalidFormatException e) {
			log.error("InvalidFormatException:", e);
		} catch (IOException e) {
			log.error("IOException异常:", e);
		} catch (Exception e) {
			log.error("导出患者失败:", e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					log.error("关闭输出流失败", e);
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error("关闭输入流失败", e);
				}
			}
		}
	}
}
