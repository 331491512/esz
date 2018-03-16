/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.spring;<br/>  
 * <b>文件名：</b>MapperScannerConfigurer.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月15日下午12:52:48<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/** 
* @ClassName: MapperScannerConfigurer
* @Description: 
* @author lichenghao
* @date 2017年7月15日 下午12:52:48  
*/
public class MapperScannerConfigurer extends org.mybatis.spring.mapper.MapperScannerConfigurer {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		try {
			//如果sqlSessionFactory 不存在 ，将不再扫描mapper
			registry.getBeanDefinition("sqlSessionFactory");
		} catch (Exception e) {
			return;
		}
		super.postProcessBeanDefinitionRegistry(registry);
	}
}
