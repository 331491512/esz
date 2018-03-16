package com.esuizhen.bigdata.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;
import java.nio.charset.Charset;

/**
 * Created by fqc on 11/13/16.
 */
@Configuration
public class BeanConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanConfigController.class);

    @Value("${characterEncoding}")
    private String characterEncoding;

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding(characterEncoding);
        filter.setForceEncoding(false);
        return filter;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
                Charset.forName(characterEncoding));
        return stringHttpMessageConverter;
    }

//    @Bean
//    public ObjectMapper jsonMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        return objectMapper;
//    }


    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "datasource.druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Value("${datasource.druid.allow}")
    private String druidAllowUrl;
    @Value("${datasource.druid.deny}")
    private String druidDenyUrl;

    /*@Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        LOGGER.info("druidAllowUrl白名单->{}", druidAllowUrl);
        LOGGER.info("druidDenyUrl黑名单->{}", druidDenyUrl);
        reg.addUrlMappings("/druid*//*");
        reg.addInitParameter("allow", druidAllowUrl);
        reg.addInitParameter("deny", druidDenyUrl);
        return reg;
    }*/


    /*@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("*//*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid*//*");
        return filterRegistrationBean;
    }*/

    @Bean
    public RequestContextListener requestContextListener() {
        RequestContextListener requestContextListener = new RequestContextListener();
        return requestContextListener;
    }
}
