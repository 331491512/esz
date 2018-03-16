/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util;<br/>  
 * <b>文件名：</b>MergerBean.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月15日上午10:00:30<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;

import java.lang.reflect.Field;

/** 
* @ClassName: MergerBean
* @Description: 
* @author lichenghao
* @date 2016年11月15日 上午10:00:30  
*/
public class MergerBean {

	public <T> void mergeObject(T origin, T destination) {
        if (origin == null || destination == null)
            return;
        if (!origin.getClass().equals(destination.getClass()))
            return;
 
        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }
    }
}
