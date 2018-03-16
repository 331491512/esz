package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.esuizhen.cloudservice.user.common.followuppatient.ExcelTemplate;
import com.esuizhen.cloudservice.user.service.followuppatient.AbstractExportBigData;
import com.westangel.common.util.DateUtil;

@Service
public class BigDataToExcelImpl extends AbstractExportBigData {

	@Override
	protected void writeHeaderToOutputStream(FileOutputStream fos)
			throws IOException {
		writeToOutputStream(ExcelTemplate.HEADER.toString(), fos);
	}

	@Override
	protected void writeFooterToOutputStream(FileOutputStream fos)
			throws IOException {
		writeToOutputStream(ExcelTemplate.FOOTER.toString(), fos);
	}

	@Override
	protected void writeOneRowToOutputStream(Object obj, FileOutputStream fos,
			final Collection<String> titles) throws IOException {
		// 获取metaData;
		writeToOutputStream("<tr>", fos);
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();// 获取属性
		
		for (String excelField : titles) {
			boolean flag = false;
			for (Field field : fields) {
				String fieldName = field.getName();
				if (fieldName.equals(excelField)) {
					Object o = getFieldValue(obj, fieldName);
					if(o instanceof Date) {
						Date dt = (Date)o;
						o = DateUtil.convertToStr(dt, DateUtil.DATE_TIME_LINE);
					}
					writeToOutputStream("<td class=\"txt\">" + HtmlUtils.htmlEscape(o == null ? "" : o.toString()) + "</td>", fos);
					flag = true;
				}
				if (flag) {
					break;
				}
			}
		}
		writeToOutputStream("</tr>", fos);
	}
	
	
	
	@Override
	protected void writeOneRowToOutputStream(Object t, FileOutputStream fos, String[] titles) throws IOException {
		// 获取metaData;
		writeToOutputStream("<tr>", fos);
		LinkedHashMap<String, String> map = (LinkedHashMap<String, String>)t;
		for (String key : titles) {
			Object obj = map.get(key);
			writeToOutputStream("<td class=\"txt\">" + HtmlUtils.htmlEscape(obj == null ? "" : obj.toString()) + "</td>", fos);
		}
		writeToOutputStream("</tr>", fos);
	}
	
	@Override
	protected void writeOneRowToOutputStream(Object obj,FileOutputStream fos,final String titles) throws IOException {
		writeToOutputStream("<tr>", fos);
		JSONArray arr = JSON.parseArray(titles);
		int len = arr.size();
		for(int i=0;i<len;i++) {
			JSONObject map = JSON.parseObject(arr.get(i).toString());
			Object id = map.get("id");
			if(id != null) {
				boolean flag = false;
				JSONObject jsonObj = JSON.parseObject(obj.toString());
				Iterator<Entry<String,Object>> itr = jsonObj.entrySet().iterator();
				while(itr.hasNext()) {
					Entry<String,Object> entry = itr.next();
					if(entry.getKey().equals(id)) {
						Object o = entry.getValue();
						if(o instanceof Date) {
							Date dt = (Date)o;
							o = DateUtil.convertToStr(dt, DateUtil.DATE_TIME_LINE);
						}
						writeToOutputStream("<td class=\"txt\">" + HtmlUtils.htmlEscape(o == null ? "" : o.toString()) + "</td>", fos);
						flag = true;
					}
					if(flag) {
						break;
					}
				}
			}else {
				if(map.get("subTitles") != null) {
					JSONArray subArray = JSON.parseArray(map.get("subTitles").toString());
					int length = subArray.size();
					for(int j=0;j < length;j++) {
						String subTitle = subArray.get(j).toString();
						JSONObject subMap = JSON.parseObject(subTitle);
						id = subMap.get("id");
						boolean flag = false;
						JSONObject jsonObj = JSON.parseObject(obj.toString());
						Iterator<Entry<String,Object>> itr = jsonObj.entrySet().iterator();
						while(itr.hasNext()) {
							Entry<String,Object> entry = itr.next();
							if(entry.getKey().equals(id)) {
								Object o = entry.getValue();
								if(o instanceof Date) {
									Date dt = (Date)o;
									o = DateUtil.convertToStr(dt, DateUtil.DATE_TIME_LINE);
								}
								writeToOutputStream("<td class=\"txt\">" + HtmlUtils.htmlEscape(o == null ? "" : o.toString()) + "</td>", fos);
								flag = true;
							}
							if(flag) {
								break;
							}
						}
					}
				}
			}
		}
		writeToOutputStream("</tr>", fos);
	}
	
	protected void fileOutputStreamStatus(List<FileOutputStream> foList)
			throws IOException {
		System.out.println("共有文件输出流：" + foList.size());
		for (FileOutputStream fo : foList) {
			System.out.println("文件输出流：" + (fo == null ? "已清空" : fo.toString() + " : " + (fo.getFD().valid())));
		}
	}

	@Override
	protected void writeTitleToOutputStream(Collection<String> titles,
			FileOutputStream fos) throws IOException {
		if (titles != null && titles.size() > 0) {
			writeToOutputStream("<tr>", fos);
			for (String title : titles) {
				writeToOutputStream("<td class=\"txt\">" + HtmlUtils.htmlEscape(title == null ? "": title) + "</td>", fos);
			}
			writeToOutputStream("</tr>", fos);
		}
	}

	@Override
	protected void writeTitleToOutputStream(String titles, FileOutputStream fos)
			throws IOException {
		JSONArray arr = JSON.parseArray(titles);
		int len = arr.size();
		writeToOutputStream("<tr>", fos);
		for(int i=0;i<len;i++) {
			JSONObject map = JSON.parseObject(arr.get(i).toString());
			Object title = map.get("name");
			Integer rows = (Integer)map.get("rows");
			Integer cols = (Integer)map.get("cols");
			writeToOutputStream("<td class=\"txt\" colspan='"+cols+"' rowspan='"+rows+"'>" + HtmlUtils.htmlEscape(title == null ? "": title.toString()) + "</td>", fos);
		}
		writeToOutputStream("</tr>", fos);
		writeToOutputStream("<tr>", fos);
		for(int i=0;i<len;i++) {
			JSONObject map = JSON.parseObject(arr.get(i).toString());
			if(map.get("subTitles") != null) {
				JSONArray subArray = JSON.parseArray(map.get("subTitles").toString());
				int length = subArray.size();
				for(int j=0;j < length;j++) {
					String subTitle = subArray.get(j).toString();
					JSONObject subMap = JSON.parseObject(subTitle);
					Object title = subMap.get("name");
					Integer rows = (Integer)subMap.get("rows");
					Integer cols = (Integer)subMap.get("cols");
					writeToOutputStream("<td class=\"txt\" colspan='"+cols+"' rowspan='"+rows+"'>" + HtmlUtils.htmlEscape(title == null ? "": title.toString()) + "</td>", fos);
				}
			}
		}
		writeToOutputStream("</tr>", fos);
	}

	private Object getFieldValue(Object obj, String fieldName) {
		Object o = null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName,obj.getClass());
			if (pd != null) {
				Method getMethod = pd.getReadMethod();// 获取get方法
				o = getMethod.invoke(obj);// 执行get方法返回一个Object
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return o;
	}

}
