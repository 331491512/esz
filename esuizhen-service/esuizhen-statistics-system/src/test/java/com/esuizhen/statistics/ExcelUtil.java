package com.esuizhen.statistics;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil
{

	
	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	private static List<List<String>> readXlsx(String path) throws Exception
	{
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		List<List<String>> list = new ArrayList<List<String>>();
		for (int numSheet = 0; numSheet < 1; numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					List<String> data = new ArrayList<String>();
					for (int i = 0; i < xssfRow.getPhysicalNumberOfCells(); i++) {
						data.add(xssfRow.getCell(i).toString());
					}
					list.add(data);
				}
			}
		}
		return list;
	}

	/**
	 * 写Excel
	 * 
	 * @param xls_write_Address
	 * @param data
	 * @param sheetname
	 * @throws IOException
	 */
	public static void writeExcel(String file, ByteArrayOutputStream baos, List<LinkedHashMap<String, Object>> data) throws IOException
	{

		FileInputStream is = new FileInputStream(file); // 读取的文件路径
		XSSFWorkbook wb = new XSSFWorkbook(is);

		XSSFSheet sheet = wb.getSheetAt(0);

		for (int i = 0; i < data.size(); i++) {
			XSSFRow row = sheet.createRow(i + 1);
			Map<String, Object> map = data.get(i);
			int j = 0;
			for (String key : map.keySet()) {
				XSSFCell cell = row.createCell(j++);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				if (map.get(key) == null) {
					cell.setCellValue("");
				} else {
					cell.setCellValue(map.get(key).toString());
				}

			}

		}

		wb.write(baos);
	}

	/**
	 * 写Excel
	 * 
	 * @param xls_write_Address
	 * @param data
	 * @param sheetname
	 * @throws IOException
	 */
	public static void writeExcelForPatient(String file, ByteArrayOutputStream baos, List<Map<String, Object>> data) throws IOException
	{

		FileInputStream is = new FileInputStream(file); // 读取的文件路径
		XSSFWorkbook wb = new XSSFWorkbook(is);

		XSSFSheet sheet = wb.getSheetAt(0);

		for (int i = 0; i < data.size(); i++) {
			XSSFRow row = sheet.createRow(i + 1);
			Map<String, Object> map = data.get(i);

			String[] keyArray = new String[] { "patientNo", "name", "sex", "age", "doctorName", "sureDiagnoseTime", "patientCondition", "suifangDate", "result", "deathDate", "recurrenceDate",
					"transferDate", "transferSite", "mobile", "sendStatus", "sendTime", "sendContent", "replyTime", "replyContent", "registerSource" };

			for (int j = 0; j < keyArray.length; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(map.get(keyArray[j]) == null ? "" : map.get(keyArray[j]).toString());
			}
		}

		wb.write(baos);
	}

	/**
	 * 写Excel
	 * @param xls_write_Address
	 * @param data
	 * @param sheetname
	 * @throws IOException
	 */
	public static void writeSeminaPatient(String file, ByteArrayOutputStream baos, List<Map<String, Object>> data) throws IOException
	{

		FileInputStream is = new FileInputStream(file); // 读取的文件路径
		XSSFWorkbook wb = new XSSFWorkbook(is);

		XSSFSheet sheet = wb.getSheetAt(0);

		for (int i = 0; i < data.size(); i++) {
			XSSFRow row = sheet.createRow(i + 1);
			Map<String, Object> map = data.get(i);

			String[] keyArray = new String[] { "patientNo", "name", "sex", "age", "doctor_name", "sureDiagnoseTime", "patientCondition", "suifangDate", "result", "deathDate", "recurrenceDate",
					"transferDate", "transferSite", "mobile"};

			for (int j = 0; j < keyArray.length; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(map.get(keyArray[j]) == null ? "" : map.get(keyArray[j]).toString());
			}
		}

		wb.write(baos);
	}
}
