/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.util;<br/>  
 * <b>文件名：</b>ExcelFileWrite.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月18日下午3:53:44<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.westangel.common.util.LogUtil;

/** 
* @ClassName: ExcelFileWrite
* @Description: 
* @author lichenghao
* @date 2016年8月18日 下午3:53:44  
*/
public class ExcelFileWriteUtil {
	
	public static int testi = 0;
	// 模版文件导出
	@SuppressWarnings("unused")
	public static File initFollowReportTemplateFile(File outFile,String templateFilePath,int startRow,int startColumn,List<Object> data)throws Exception{
		if(data==null){
			LogUtil.logError.error("---------data is null-------");
			return null;
		}
		LogUtil.log.info("---------init file start-------");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		writeExcelFileTemplate(templateFilePath,baos,startRow,startColumn,data);
		FileOutputStream fileOut = new FileOutputStream(outFile);
		baos.writeTo(fileOut);
		baos.close();
		fileOut.close();
		LogUtil.log.info("---------init file success-------");
		return outFile;
	}
	
	
	@SuppressWarnings("unchecked")
	public static void writeExcelFileTemplate(String file,ByteArrayOutputStream baos,int startRow,int startColumn,List data)throws Exception{
		FileInputStream is = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		XSSFSheet sheet = wb.getSheetAt(0);
		writeSheet(sheet,startRow,startColumn,(List<List>)data.get(0));
		wb.write(baos);
	}
	
	// 新建excel 导出
	public static File initFollowReportFile(File outFile,List<Object> data)throws Exception{
		if(data==null){
			LogUtil.logError.error("---------data is null-------");
			return null;
		}
		LogUtil.log.info("---------init file start-------");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		writeExcelFile(baos,data);
		FileOutputStream fileOut = new FileOutputStream(outFile);
		baos.writeTo(fileOut);
		baos.close();
		fileOut.close();
		LogUtil.log.info("---------init file success-------");
		return outFile;
	}
	
	public static void writeExcelFile(ByteArrayOutputStream baos,List data)throws Exception{
		//XSSFWorkbook wb = new XSSFWorkbook();
		SXSSFWorkbook wb = new SXSSFWorkbook(1000);
		for(Object obj:data){
			final Map<String,Object> sheetBook = (Map<String,Object>)obj;
			final Sheet sheet = wb.createSheet((String)sheetBook.get("sheetName"));
			writeSheet(sheet,0,0,(List<List>)sheetBook.get("sheetData"));
		}
		wb.write(baos);
	}
	//写入sheet
	@SuppressWarnings("unchecked")
	public static void writeSheet(Sheet sheet,int startRow,int startColumn,List rows){
		Row row = null;
		Cell cell = null;
		int rowindex=startRow;
		for(String[] clos : (List<String[]>)rows){
			row = sheet.createRow(rowindex++);
			int clo=startColumn;
			for(String str:clos){
				cell = row.createCell(clo++);
				if(str==null)
					cell.setCellValue("");
				else
					cell.setCellValue(str);
			}
			if(rowindex%1000==0)
				try {
					((SXSSFSheet)sheet).flushRows();
				} catch (IOException e) {
					LogUtil.logError.error(" output excel file error:"+e.getMessage());
				}
		}
		rows.clear();
	}
	
	public static void main(String[] args) {
		String[] row = new String[10];
		row[0] = "123";
	}
	
	
	
}
