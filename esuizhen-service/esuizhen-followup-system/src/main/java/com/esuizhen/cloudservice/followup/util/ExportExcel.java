package com.esuizhen.cloudservice.followup.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @ClassName: ExportExcel
 * @Description: excel导出工具
 * @author raox
 * @date 2016年8月26日 上午9:22:08
 */
public class ExportExcel<T> {

	public void exportExcel(String[] headers, String[] headerFields, Collection<T> dataset, OutputStream out) {
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet();

		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCell cell = null;
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(style);
		}

		Iterator<T> it = dataset.iterator();
		String textValue = "";
		int index = 0;
		String getMethodName = null;
		Class<? extends Object> entityClass = null;
		Method getMethod = null;
		try {
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T entity = (T) it.next();
				for (int j = 0; j < headerFields.length; j++) {
					getMethodName = "get" + headerFields[j].substring(0, 1).toUpperCase() + headerFields[j].substring(1);
					entityClass = entity.getClass();
					getMethod = entityClass.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(entity, new Object[] {});
					if (UtilValidate.isEmpty(value)) {
						textValue = "";
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						textValue = sdf.format(date);
					} else {
						// 其它数据类型都当作字符串简单处理
						try {
							textValue = value.toString();
						} catch (Exception e) {
							textValue = "";
						}
					}
					row.createCell(j).setCellValue(textValue);
				}
			}
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportExcel(String[] headers, String[] headerFields, Collection<T> dataset, OutputStream out, String json) {
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet();

		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCell cell = null;
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(style);
		}

		try {
			Iterator<T> it = dataset.iterator();
			String textValue = "";
			int index = 0;
			String getMethodName = null;
			Class<? extends Object> entityClass = null;
			Method getMethod = null;
			// json
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Map<String, String>> valueMaps = objectMapper.readValue(json, Map.class);
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T entity = (T) it.next();
				for (int j = 0; j < headerFields.length; j++) {
					getMethodName = "get" + headerFields[j].substring(0, 1).toUpperCase() + headerFields[j].substring(1);
					entityClass = entity.getClass();
					getMethod = entityClass.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(entity, new Object[] {});
					if (UtilValidate.isEmpty(value)) {
						textValue = "";
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						textValue = sdf.format(date);
					}else if (value instanceof Integer) {
						Map<String, String> valueTextMap = valueMaps.get(headerFields[j]);
						if (UtilValidate.isNotEmpty(valueTextMap)) {
							textValue = valueTextMap.get(value.toString());
						} else {
							textValue = value.toString();
						}
					} else {
						// 其它数据类型都当作字符串简单处理
						try {
							textValue = value.toString();
						} catch (Exception e) {
							textValue = "";
						}
					}
					row.createCell(j).setCellValue(textValue);
				}
			}
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportExcel(String[] headers, String[] headerFields, List<Map<String, Object>> dataset, OutputStream out) {
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet();

		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCell cell = null;
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(style);
		}

		Iterator<Map<String, Object>> it = dataset.iterator();
		String textValue = "";
		int index = 0;
		Map<String, Object> dataMap = null;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			dataMap = (Map<String, Object>) it.next();
			for (int j = 0; j < headerFields.length; j++) {
				Object value = dataMap.get(headerFields[j]);
				if (UtilValidate.isEmpty(value)) {
					textValue = "";
				} else if (value instanceof Date) {
					Date date = (Date) value;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					textValue = sdf.format(date);
				} else {
					// 其它数据类型都当作字符串简单处理
					try {
						textValue = value.toString();
					} catch (Exception e) {
						textValue = "";
					}
				}
				row.createCell(j).setCellValue(textValue);
			}
		}
		try {
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exportExcel(String[] headers, String[] headerFields, List<Map<String, Object>> dataset, OutputStream out, String json) throws JsonParseException,
			JsonMappingException, IOException {
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet();

		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCell cell = null;
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(style);
		}

		// json
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, String>> valueMaps = objectMapper.readValue(json, Map.class);

		Iterator<Map<String, Object>> it = dataset.iterator();
		String textValue = "";
		int index = 0;
		Map<String, Object> dataMap = null;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			dataMap = (Map<String, Object>) it.next();
			for (int j = 0; j < headerFields.length; j++) {
				Object value = dataMap.get(headerFields[j]);
				if (UtilValidate.isEmpty(value)) {
					textValue = "";
				} else if (value instanceof Date) {
					Date date = (Date) value;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					textValue = sdf.format(date);
				} else if (value instanceof Integer) {
					Map<String, String> valueTextMap = valueMaps.get(headerFields[j]);
					if (UtilValidate.isNotEmpty(valueTextMap)) {
						textValue = valueTextMap.get(value.toString());
					} else {
						textValue = value.toString();
					}
				} else {
					// 其它数据类型都当作字符串简单处理
					try {
						textValue = value.toString();
					} catch (Exception e) {
						textValue = "";
					}
				}
				row.createCell(j).setCellValue(textValue);
			}
		}
		try {
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws IOException {
		ExportExcel<Map<String, Object>> exportExcel = new ExportExcel<Map<String, Object>>();

		List<Map<String, Object>> hospitalList = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = null;
		for (int i = 0; i < 10; i++) {
			map = new HashMap<String, Object>();
			map.put("trueName", "张三");
			map.put("patientRelation", 1);
			map.put("productId", 2);
			map.put("createTime", "2016-12-21");
			map.put("tpCreateTime", "2016-12-21");
			map.put("releaseTime", "2016-12-21");
			map.put("userSourceFlag", 1);
			map.put("sex", 1);
			map.put("mobile", "123456789");
			map.put("auditState", 4);
			hospitalList.add(map);
		}

		System.out.println("初始化数据结束。。。。。。。。。。。。。。。。。");
		String[] headers = { "姓名", "身份", "微信公众号", "注册时间", "关注微信时间", "取消关注时间", "用户来源", "性别", "手机号", "审核状态" };
		String[] headerFields = { "trueName", "patientRelation", "productId", "createTime", "tpCreateTime", "releaseTime", "userSourceFlag", "sex", "mobile", "auditState" };

		String json = "{\"productId\":{\"2\":\"易随诊医生\",\"3\":\"随诊中心\"}" + ",\"patientRelation\":{\"0\":\"本人\",\"1\":\"家属\"}" + ",\"sex\":{\"0\":\"未知\",\"1\":\"男\",\"2\":\"女\"}"
				+ ",\"auditState\":{\"-1\":\"审核失败\",\"0\":\"未审核\",\"2\":\"完善资料\",\"3\":\"实名认证待审核\",\"4\":\"实名认证审核通过\"}"
				+ ",\"userSourceFlag\":{\"0\":\"未知\",\"1\":\"医生\",\"2\":\"医生\",\"3\":\"医生\",\"4\":\"医生\",\"5\":\"医院\"}}";
		System.out.println(json);

		OutputStream out = new FileOutputStream(new File("d:\\1.xls"));
		exportExcel.exportExcel(headers, headerFields, hospitalList, out, json);
		out.flush();
		out.close();
		System.out.println("导出数据结束。。。。。。。。。。。。。。。。。");

	}
}
