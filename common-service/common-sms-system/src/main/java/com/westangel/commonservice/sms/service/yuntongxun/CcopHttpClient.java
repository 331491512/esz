package com.westangel.commonservice.sms.service.yuntongxun;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.Principal;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
/**
 * 
* @ClassName: CcopHttpClient 
* @Description: 云通讯httpclient 
* @author LIPENG
* @date 2015年12月28日 下午3:58:33 
*
 */
public class CcopHttpClient {
	/**
	 * 
	* @Title: registerSSL 
	* @Description: 注册SSL连接 
	* @param @param hostname 请求的主机（IP或者域名）
	* @param @param protocol 请求协议名称（TLS-安全传输层协议）
	* @param @param port 端口号
	* @param @param scheme 协议名称
	* @param @return HttpClient实例 
	* @param @throws NoSuchAlgorithmException
	* @param @throws KeyManagementException    设定文件 
	* @return DefaultHttpClient    HttpClient实例类型 
	* @throws
	 */
	public DefaultHttpClient registerSSL(String hostname, String protocol, int port, String scheme)
	throws NoSuchAlgorithmException, KeyManagementException
	{
		//创建一个默认的HttpClient
		DefaultHttpClient httpClient = new DefaultHttpClient();
		//创建SSL上下文实例
		SSLContext ctx = SSLContext.getInstance(protocol);
		//服务端证书验证
		X509TrustManager tm = new X509TrustManager(){
			/**
			 * 验证客户端证书
			 */
			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				//这里跳过客户端证书	验证
			}
			
			/**
			 * 验证服务端证书
			 */
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				if (chain == null || chain.length == 0)   {
			           throw new IllegalArgumentException("null or zero-length certificate chain");
			           }   
			       if (authType == null || authType.length() == 0) {  
			           throw new IllegalArgumentException("null or zero-length authentication type");
			           }   
			   
			       boolean br = false;   
			       Principal principal = null;   
			       for (X509Certificate x509Certificate : chain) {   
			           principal = x509Certificate.getSubjectX500Principal();   
			           if (principal != null) {
			               br = true;   
			               return;   
			           }   
			       }   
			       if (!br) {   
			          throw new CertificateException("服务端证书验证失败！");   
			       }
			}
			
			public X509Certificate[] getAcceptedIssuers() {
				   return new X509Certificate[0];
			   }
		};
		ctx.init(null, new TrustManager[]{tm}, new java.security.SecureRandom());
		SSLSocketFactory factory = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		Scheme sch = new Scheme(scheme, port, factory);
		//注册SSL连接
		httpClient.getConnectionManager().getSchemeRegistry().register(sch);
		return httpClient;
	} 
}
