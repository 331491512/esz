package com.westangel.commonservice.sms.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.sms.model.yixintong.Response;


/** 
 * @ClassName: ObjectXMLConvertUtil 
 * @Description: Object和XML之间的转换
 * @author yzq 
 * @date Jul 20, 2015 1:30:54 PM
 */
public class ObjectXMLConvertUtil {
   
    private static JAXBContext context;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;
    
    static{
	init();
    }
    
    public static String toXML(Object obj){
	try {
            if(context==null)
        	init();
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    
    public static Object toObject(String xml) {
	 if(context==null)
     	    init();
	try {
	    return unmarshaller.unmarshal(new StringReader(xml));
	} catch (JAXBException e) {
	    throw new RuntimeException(e);
	}
    }
    
    public static String fromObject(Object obj){
	try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    
    @SuppressWarnings("unchecked")
    public static <T> T fromXML(String xml, Class<T> valueType) {
	try {
	    JAXBContext context = JAXBContext.newInstance(valueType);
	    Unmarshaller unmarshaller = context.createUnmarshaller();
	    return (T) unmarshaller.unmarshal(new StringReader(xml));
	} catch (Exception e) {
	    throw new RuntimeException(e.getMessage());
	}
    }

    @SuppressWarnings("restriction")
    public static void init(){
	
	 try {
	    context = JAXBContext.newInstance(Response.class);
	    marshaller = context.createMarshaller();
	    unmarshaller = context.createUnmarshaller();
	    
	    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
	    
	} catch (JAXBException e) {
	    throw new RuntimeException(e.getMessage());
	}
   }
    
    public static void main(String[] args) {
		String result= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<Response><Result>0</Result>"
				+ "<Mo num=\"2\">"
				+ "<Item id=\"1\" content=\"上行\" from_mobile=\"13500000000\" to_port=\"0001\" rec_time=\"2013-07-20 13:23:45\"/>"
				+ "<Item id=\"2\" content=\"上行02\" from_mobile=\"13600000000\" to_port=\"0002\" rec_time=\"2013-07-20 13:23:45\"/>"
				+ "</Mo>"
				+ "</Response>";
		Object obj = ObjectXMLConvertUtil.toObject(result);
//		String json= JsonUtil.toJson(obj);
//		Response res = JsonUtil.toObject(json, Response.class);
//		System.out.println(res.getMo().getItems());
	}
}
