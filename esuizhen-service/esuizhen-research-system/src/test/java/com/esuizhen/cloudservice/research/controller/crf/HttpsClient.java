package com.esuizhen.cloudservice.research.controller.crf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")  
@ContextConfiguration( { "classpath:spring/application.xml" })
public class HttpsClient
{
	private String httpUrl = "https://localhost:8443/project/crf/subject/element/child/query?crfCourseItemId=CITEM24502281969860968&parentId=S1";
	// 客户端密钥库
	private String sslKeyStorePath;
	private String sslKeyStorePassword;
	private String sslKeyStoreType;
	// 客户端信任的证书
	private String sslTrustStore;
	private String sslTrustStorePassword;

	@Before
	public void setUp()
	{
		sslKeyStorePath = "E:\\keys\\tomcat.keystore";
		sslKeyStorePassword = "123456";
		sslKeyStoreType = "JKS"; // 密钥库类型，有JKS PKCS12等
		sslTrustStore = "E:\\keys\\tomcat.keystore";
		sslTrustStorePassword = "123456";
		System.setProperty("javax.net.ssl.keyStore", sslKeyStorePath);
		System.setProperty("javax.net.ssl.keyStorePassword", sslKeyStorePassword);
		System.setProperty("javax.net.ssl.keyStoreType", sslKeyStoreType);
		// 设置系统参数
		System.setProperty("javax.net.ssl.trustStore", sslTrustStore);
		System.setProperty("javax.net.ssl.trustStorePassword", sslTrustStorePassword);
	}

	@Test
	public void testHttpsClient()
	{
		SSLContext sslContext = null;
		try {
			KeyStore kstore = KeyStore.getInstance("jks");
			kstore.load(new FileInputStream(sslKeyStorePath), sslKeyStorePassword.toCharArray());
			KeyManagerFactory keyFactory = KeyManagerFactory.getInstance("sunx509");
			keyFactory.init(kstore, sslKeyStorePassword.toCharArray());
			KeyStore tstore = KeyStore.getInstance("jks");
			tstore.load(new FileInputStream(sslTrustStore), sslTrustStorePassword.toCharArray());
			TrustManager[] tm;
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("sunx509");
			tmf.init(tstore);
			tm = tmf.getTrustManagers();
			sslContext = SSLContext.getInstance("SSL");
			sslContext.init(keyFactory.getKeyManagers(), tm, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			//创建TrustManager
	        X509TrustManager xtm = new X509TrustManager() {
	            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
	            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
	            public X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	        };
	        //这个好像是HOST验证
	        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
	            public boolean verify(String arg0, SSLSession arg1) {
	                return true;
	            }
	            public void verify(String arg0, SSLSocket arg1) throws IOException {}
	            public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
	            public void verify(String arg0, X509Certificate arg1) throws SSLException {}
	        };
	        
			HttpClient httpClient = new DefaultHttpClient();
			SSLSocketFactory socketFactory = new SSLSocketFactory(sslContext);
			socketFactory.setHostnameVerifier(hostnameVerifier);
			Scheme sch = new Scheme("https", 8443, socketFactory);
			httpClient.getConnectionManager().getSchemeRegistry().register(sch);
			HttpGet httpPost = new HttpGet(httpUrl);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			String spt = System.getProperty("line.separator");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer stb = new StringBuffer();
			String line = null;
			while ((line = buffer.readLine()) != null) {
				stb.append(line);
			}
			buffer.close();
			String result = stb.toString();
			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
