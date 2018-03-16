package com.esuizhen.statistics;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Mail{
	
	@Autowired
	private JavaMailSender sender;

	@Value("${mail.subject}")
	private String subject;
	
	@Value("${mail.to}")
	private String mailTo;
	
	@Value("${mail.from}")
	private String mailFrom;
	
	
	
	

	public boolean sendMain(String hospitalId ,String hospitalName , String deptId , String deptName , File toFile) 
	{
		 sender = null;
		try {
			MimeMessage mail = sender.createMimeMessage();  
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mail, true);
			helper.setTo(mailTo);
			helper.setFrom(mailFrom);
			helper.setSubject(subject);
			helper.setText(hospitalName+"("+hospitalId+")"+deptName+"("+deptId+")");
			helper.addAttachment(hospitalName+deptName+".xlsx", toFile);
			sender.send(mail);
			toFile.deleteOnExit();
		} catch (Exception e) {
			throw new RuntimeException();
		} 
		return false;
	}
	
	/*******************************************************************************************************************************/
	
}
