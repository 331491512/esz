package com.westangel.common.util;

import java.beans.IntrospectionException;  
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;



/** 
 *@className BeanUtils
 *@Description:
 *@author yuanwenming
 *@date 2017年5月16日
 */
public class BeanUtils {
	/**
	 * 把一个对象的值填充到另外一个对象中
	 * @param srcObj 源对象
	 * @param targetObj 填充对象
	 */
	public static void beanToBean(Object srcObj,Object targetObj) {
		if(targetObj != null) {
			Class<?> clazz = srcObj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Class<?> fillClazz = targetObj.getClass();
			Field[] fillFields = fillClazz.getDeclaredFields();
			for(Field field : fields) {
				String fieldName = field.getName();
				for(Field fillField : fillFields) {
					String fillFieldName = fillField.getName();
					if(fieldName.equals(fillFieldName)) {
						Object o = getFieldValue(srcObj,fieldName);
						if(o != null) {
							setFieldValue(targetObj,fillFieldName,o);
						}
						break;
					}
				}
			}
		}
	}
	
	private static void setFieldValue(Object obj,String fieldName,Object fieldValue) {
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName,obj.getClass());
			pd.getWriteMethod().invoke(obj, fieldValue);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	private static Object getFieldValue(Object obj,String fieldName) {
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
	
	/**
	 * 将Bean对象转换成Map对象，将忽略掉值为null、"" 或size=0的属性
	 * @param obj 对象
	 * @return 若给定对象为null则返回size=0的map对象
	 */
	public static Map<String, Object> toMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj == null) {
			return map;
		}
		BeanMap beanMap = new BeanMap(obj);
		Iterator<String> it = beanMap.keyIterator();
		while (it.hasNext()) {
			String name = it.next();
			Object value = beanMap.get(name);
			// 转换时会将类名也转换成属性，此处去掉
			if (value != null && (!"".equals(value)) && !name.equals("class")) {
				map.put(name, value);
			}
		}
		return map;
	}

	/**
	 * 该方法将给定的所有对象参数列表转换合并生成一个Map，对于同名属性，依次由后面替换前面的对象属性
	 * @param objs 对象列表
	 * @return 对于值为null的对象将忽略掉
	 */
	public static Map<String, Object> toMap(Object... objs) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Object object : objs) {
			if (object != null) {
				map.putAll(toMap(object));
			}
		}
		return map;
	}
	
	/**
	 * 获取接口的泛型类型，如果不存在则返回null
	 * @param clazz
	 * @return
	 */
	public static Class<?> getGenericClass(Class<?> clazz) {
		Type t = clazz.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			//if(((Class<?>) p[1])!=null && BaseController.class.isAssignableFrom(clazz)) return ((Class<?>) p[1]);
			return ((Class<?>) p[0]);
		}
		return null;
	}
}
