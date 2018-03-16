package com.esuizhen.cloudservice.ehr.service.common.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.esuizhen.cloudservice.ehr.common.ExcelTemplate;
import com.esuizhen.cloudservice.ehr.service.common.AbstractExportBigData;

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
	protected void writeOneRowToOutputStream(Object obj, FileOutputStream fos,final Collection<String> titles)
			throws IOException {
		// 获取metaData;
        writeToOutputStream("<tr>", fos);
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();//获取属性
        
        for(String excelField : titles) {
        	boolean flag=false;
        	for(Field field : fields) {
            	String fieldName = field.getName();
            	if(fieldName.equals(excelField)) {
            		Object o = getFieldValue(obj,fieldName);
            		writeToOutputStream("<td class=\"txt\">" + HtmlUtils.htmlEscape(o == null ? "" : o.toString()) + "</td>", fos);
            		flag = true;
            	}
            	if(flag) {
            		break;
            	}
            }
        }
        writeToOutputStream("</tr>", fos);
	}
	
	protected void fileOutputStreamStatus(List<FileOutputStream> foList)  
            throws IOException {  
        System.out.println("共有文件输出流：" + foList.size());  
        for (FileOutputStream fo : foList) {  
            System.out.println("文件输出流："  
                    + (fo == null ? "已清空" : fo.toString() + " : "  
                            + (fo.getFD().valid())));  
        }  
    }

	@Override
	protected void writeTitleToOutputStream(Collection<String> titles,
			FileOutputStream fos) throws IOException {
		if (titles != null && titles.size() > 0) {
            writeToOutputStream("<tr>", fos);  
            for (String title : titles) {  
                writeToOutputStream("<td>"  
                        + HtmlUtils.htmlEscape(title == null ? "" : title)  
                        + "</td>", fos);  
            }  
            writeToOutputStream("</tr>", fos);  
        }
	}
	
	private Object getFieldValue(Object obj,String fieldName) {
		Object o = null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName,obj.getClass());
			if(pd != null) {
				Method getMethod = pd.getReadMethod();//获取get方法
				o = getMethod.invoke(obj);//执行get方法返回一个Object
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
