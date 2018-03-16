package com.esuizhen.bigdata.utils;

import com.esuizhen.bigdata.cmd.cmd_.Producer;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by fqc on 16/11/25.
 */
public class RawPropertyUtils {
    public static void main(String[] args) throws Exception {
        System.out.println(load1());//通过ClassLoader方式加载配置文件
        System.out.println(load2());//
    }

    /**
     * 通过ClassLoader方式加载配置文件
     * 这种加载方式：
     * 1.可在myeclipse里运行时得到配置文件路径；
     * 2.亦可在把项目打成jar包运行时，得到配置文件路径；
     */
    public static String load1() throws Exception {
        Properties p = new Properties();
        InputStream in = Producer.class.getClassLoader().getResourceAsStream("config/application.properties");
        p.load(in);
        return p.getProperty("merge.impl.pkg").toString().trim();
    }

    /**
     * 自动加载配置文件机制，可在修改配置文件后，不用重启服务也能得到配置文件的新内容
     */
    public static String load2() throws Exception {
        String file_name = Producer.class.getClassLoader().getResource("config/config.properties").getFile();
        Properties p = new Properties();
        PropertiesConfiguration propconfig = null;//创建自动加载的机制
        propconfig = new PropertiesConfiguration();
        propconfig.setEncoding("UTF-8");//设置编码
        propconfig.setReloadingStrategy(new FileChangedReloadingStrategy());//设置自动冲加载机制
        p.load(new FileInputStream(file_name));
        return p.getProperty("user_name").toString().trim();//每次调用这个方法都会从配置文件里取到最新的参数
    }

}
