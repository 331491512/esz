/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.pay.weixin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.model.pay.WeiXinPayInfo;

//import controllers.Application;


/**
 * @author Daloong
 * 微信退款证书 配置
 */
@Component
public class WeiXinCertificate {
	
	private static final String JKS_CA_FILENAME = "tenpay_cacert.jks";
	
	private static final String JKS_CA_ALIAS = "tenpay";
	
	/**证书秘钥*/
	private static final String JKS_CA_PASSWORD = "Ashine82607188Ashine82607188Ashi";
	
	public static final String SunX509 = "SunX509";
	public static final String JKS = "JKS";
	public static final String PKCS12 = "PKCS12";
	public static final String TLS = "TLS";
	
	/** 证书密码（默认为商户号） */
	private String certPasswd = WeiXinUtil.MCH_ID;//"1228040402";
	
	public static WeiXinCertificate _weixinCertificate = null;
	
	private static String certPath;
	
	@Value("${cert.path}")
	public void setCertPath(String certPath){
		this.certPath = certPath;
	}
	public static WeiXinCertificate instance(){
		if(_weixinCertificate==null){
			_weixinCertificate = new WeiXinCertificate();
		}
		return _weixinCertificate;
	}
	
	public SSLConnectionSocketFactory callHttps(WeiXinPayInfo weixinPayInfo) throws Exception{
//		Resource resource = new ClassPathResource(weixinPayInfo.getCertificatePath()+"/rootca.pem");
//		Resource resourcep12 = new ClassPathResource(weixinPayInfo.getCertificatePath()+"/apiclient_cert.p12");
//			
//		File caFile = resource.getFile();
//		File certFile = resourcep12.getFile();
		File caFile = new File(weixinPayInfo.getCertificatePath()+"/rootca.pem");
		File certFile = new File(weixinPayInfo.getCertificatePath()+"/apiclient_cert.p12");
		
		//获取目录
		String caPath = caFile.getParent();
		
		File jksCAFile = new File(caPath+"/"+this.JKS_CA_FILENAME);
		if(!jksCAFile.isFile()){//判断是否有此目录， 没有则创建
			X509Certificate x509Certificate = (X509Certificate) getCertificate(caFile);
			FileOutputStream out = new FileOutputStream(jksCAFile);
			storeCACert(x509Certificate, JKS_CA_ALIAS,JKS_CA_PASSWORD,out);
			out.close();
		}
		
		FileInputStream trustStream = new FileInputStream(jksCAFile);
		FileInputStream keyStream = new FileInputStream(certFile);
		
		SSLContext sslContext = getSSLContext(trustStream,JKS_CA_PASSWORD, keyStream, weixinPayInfo.getMchId());
		
		//关闭流
		keyStream.close();
		trustStream.close();
		
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
		if(socketFactory!=null)
			LogUtil.log.info(Constant.LOGTAG.OK+" new SSLConnectionSocketFactory succeed.");
		else
			LogUtil.logError.error(Constant.LOGTAG.ERR+" new SSLConnectionSocketFactory failed!");
		
		return socketFactory;
	}
	
	
	/**
	 * 获取CA证书信息
	 * @param cafile CA证书文件
	 * @return Certificate
	 */
	private Certificate getCertificate(File caFile) throws Exception{
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream(caFile);
		Certificate cert = certificateFactory.generateCertificate(in);
		if(in != null){
			in.close();
		}
		return cert;
	}
	
	/**
	 * 存储ca证书成JKS格式
	 * @param cert
	 * @param alias
	 * @param password
	 * @param out
	 */
	private void storeCACert(Certificate cert, String alias, String password, OutputStream out) throws Exception{
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(null, null);

		ks.setCertificateEntry(alias, cert);
		ks.store(out, str2CharArray(password));
	}
	
	/**
	 * 字符串转换成char数组
	 * @param str
	 * @return char[]
	 */
	private char[] str2CharArray(String str) {
		if(null == str){
			return null;
		}		
		return str.toCharArray();
	}
	
	/**
	 * 获取SSLContext
	 * @param trustFile 
	 * @param trustPasswd
	 * @param keyFile
	 * @param keyPasswd
	 * @return
	 */
	public SSLContext getSSLContext(
			FileInputStream trustFileInputStream, String trustPasswd,
			FileInputStream keyFileInputStream, String keyPasswd)
			throws Exception {

		// ca
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(SunX509);
		KeyStore trustKeyStore = KeyStore.getInstance(JKS);
		trustKeyStore.load(trustFileInputStream, str2CharArray(trustPasswd));
		tmf.init(trustKeyStore);

		final char[] kp = str2CharArray(keyPasswd);
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(SunX509);
		KeyStore ks = KeyStore.getInstance(PKCS12);
		ks.load(keyFileInputStream, kp);
		kmf.init(ks, kp);

		SecureRandom rand = new SecureRandom();
		SSLContext ctx = SSLContext.getInstance(TLS);
		ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), rand);

		return ctx;
	}
}

