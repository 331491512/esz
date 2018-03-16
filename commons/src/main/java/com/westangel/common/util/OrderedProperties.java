/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util;<br/>  
 * <b>文件名：</b>OrderedProperties.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月23日上午9:45:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

/** 
* @ClassName: OrderedProperties
* @Description: 
* @author lichenghao
* @date 2016年6月23日 上午9:45:02  
*/
public class OrderedProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();  
	   
    public Enumeration<Object> keys() {  
        return Collections.<Object> enumeration(keys);  
    }  
   
    public Object put(Object key, Object value) {  
        keys.add(key);  
        return super.put(key, value);  
    }  
   
    public Set<Object> keySet() {  
        return keys;  
    }  
   
    public Set<String> stringPropertyNames() {  
        Set<String> set = new LinkedHashSet<String>();  
   
        for (Object key : this.keys) {  
            set.add((String) key);  
        }  
   
        return set;  
    }  

}
