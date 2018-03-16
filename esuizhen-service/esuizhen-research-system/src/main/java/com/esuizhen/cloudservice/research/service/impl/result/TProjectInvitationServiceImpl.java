package com.esuizhen.cloudservice.research.service.impl.result;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;
import com.esuizhen.cloudservice.research.dao.result.DoctorDao;
import com.esuizhen.cloudservice.research.dao.result.HospitalDoctorDao;
import com.esuizhen.cloudservice.research.dao.result.ProjectInvitationDao;
import com.esuizhen.cloudservice.research.model.result.TProjectInvitation;
import com.esuizhen.cloudservice.research.service.result.TProjectInvitationService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.HospitalDoctor;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.service.HospitalService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.LogUtil;

@Service
public class TProjectInvitationServiceImpl implements TProjectInvitationService {
	private Locale locale = Locale.getDefault();
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectInvitationDao projectInvitationDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private HospitalDoctorDao hospitalDoctorDao;

	@Autowired
	private MessageSource messageSource;
	@Autowired
	private HospitalService hopitalService;
	@Autowired
	private SmsInnerService smsInnerService;

	@Value("${esuizhen.url}")
	private String esuichenUrl;
	@Value("${mail.host}")
	private String mailHost;
	@Value("${mail.username}")
	private String mailUserName;
	@Value("${mail.password}")
	private String mailPassword;
	@Value("${mail.smtp.auth}")
	private String mailAuth;
	@Value("${mail.smtp.timeout}")
	private String mailTimeout;
	@Value("${mail.pc.ip}")
	private String mailPCIP;

	@Override
	public boolean addProjectInvitation(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws UnsupportedEncodingException {
		TProjectInvitation projectInvitation = new TProjectInvitation();
		projectInvitation.setProjectId(projectSubcenterDetailInfo.getProjectId());
		projectInvitation.setSubcenterId(projectSubcenterDetailInfo.getSubcenterId());
		projectInvitation.setInviter(projectSubcenterDetailInfo.getDoctorId());
		projectInvitation.setInvitee(projectSubcenterDetailInfo.getSubcenterDirector());
		projectInvitation.setState(1);
		this.projectInvitationDao.insert(projectInvitation);
		String content = this.getContent(projectSubcenterDetailInfo);
		if (StringUtils.isNotEmpty(content)) {
			// 发送邮件
			if (StringUtils.isNotEmpty(projectSubcenterDetailInfo.getEmail())) {
				this.sendEmail("临床科研专题邀请", content, projectSubcenterDetailInfo.getEmail());
			}
			// 发送短信
			this.sendSMS(projectSubcenterDetailInfo.getMobile(), content);
		}
		return true;
	}

	/**
	 * <p>
	 * Title:getContent
	 * </p>
	 * <p>
	 * Description:获取发送的信息内容
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年10月31日 下午3:23:57
	 * @param projectSubcenterDetailInfo
	 * @return
	 */
	private String getContent(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) {
		TProjectSimpleInfo projectSimpleInfo = this.projectDao.findById(projectSubcenterDetailInfo.getProjectId());
		Doctor doctor = this.doctorDao.findByDoctorId(projectSubcenterDetailInfo.getDoctorId());
		HospitalDoctor hospitalDoctor = this.hospitalDoctorDao.findByDoctorId(projectSubcenterDetailInfo.getDoctorId());
		if (hospitalDoctor == null) {
			return null;
		}
		HospitalProfile hospitalProfile = this.hopitalService.getHospitalDetail(hospitalDoctor.getHospitalId());
		if (hospitalProfile == null) {
			return null;
		}
		String[] params = new String[] {
				projectSubcenterDetailInfo.getTrueName(),
				hospitalProfile.getHospitalName(),
				doctor.getTrueName(),
				projectSimpleInfo.getProjectName(),
				projectSubcenterDetailInfo.getMobile(),
				this.esuichenUrl};
		String content = messageSource.getMessage("project.add.invitation.doctor.sms.message", params, locale);
		return content;
	}

	/**
	 * <p>
	 * Title:sendSMS
	 * </p>
	 * <p>
	 * Description:发送短信
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年10月31日 上午11:44:23
	 * @param mobile
	 * @param projectSubcenterDetailInfo
	 */
	private void sendSMS(String mobile, String content) {
		List<String> mobiles = new ArrayList<String>();
		mobiles.add(mobile);
		this.sendSmsContent(mobiles, content);
	}

	/**
	 * <p>
	 * Title:sendSmsContent
	 * </p>
	 * <p>
	 * Description:给指定的手机号发送短信
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年10月31日 下午3:16:31
	 * @param mobiles
	 * @param content
	 * @return
	 */
	private boolean sendSmsContent(List<String> mobiles, String content) {
		if (mobiles == null || mobiles.isEmpty() || StringUtils.isEmpty(content)) {
			return false;
		}
		SmsContentSendReq smsContentSendReq = new SmsContentSendReq();
		smsContentSendReq.setBusinessId(1);
		smsContentSendReq.setProductId(1);
		smsContentSendReq.setMobiles(mobiles);
		smsContentSendReq.setContent(content);
		try {
			this.smsInnerService.sendContent(smsContentSendReq);
		} catch (Exception e) {
			LogUtil.log.error("发送短信出错！" + e.getMessage());
		}
		return true;
	}

	private boolean sendEmail(String subject, String content, String to) throws UnsupportedEncodingException {
		try {
			Properties props = new Properties();
            props.put("mail.smtp.host", this.mailHost);
            //props.put("mail.smtp.port", Mail._PORT);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.localhost", this.mailPCIP);
            Transport transport = null;
            Session session = Session.getDefaultInstance(props, null);
            transport = session.getTransport("smtp");
            transport.connect(this.mailHost, this.mailUserName, this.mailPassword);
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            InternetAddress fromAddress = new InternetAddress(
                    this.mailUserName, MimeUtility.encodeText(subject, "gb2312", "B"));
            //编码方式有两种："B"代表Base64、"Q"代表QP（quoted-printable）方式。
             
            msg.setFrom(fromAddress);
            InternetAddress toAddress = new InternetAddress(to);
            msg.setRecipient(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject, "UTF-8");
            msg.setText(content, "UTF-8");
            msg.saveChanges();
 
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			LogUtil.logError.error(e.getCause() + "/t" + e.getMessage());
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			LogUtil.logError.error(e.getCause() + "/t" + e.getMessage());
			return false;
		}
		return true;
	}
	
	private boolean sendEmailHTML(String subject, String content, String to)
            throws UnsupportedEncodingException {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", this.mailHost);
            //props.put("mail.smtp.port", Mail._PORT);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.localhost", this.mailPCIP);
 
            Transport transport = null;
            Session session = Session.getDefaultInstance(props, null);
            transport = session.getTransport("smtp");
            transport.connect(this.mailHost, this.mailUserName, this.mailPassword);
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
//          InternetAddress fromAddress = new InternetAddress(
//                  Mail._USER, MimeUtility.encodeText(
//                          new String(Mail._FROM
//                                  .getBytes("ISO-8859-1"), "UTF-8"),
//                          "gb2312", "B"));
            InternetAddress fromAddress = new InternetAddress(
                    this.mailUserName, MimeUtility.encodeText(
                            this.mailUserName, "gb2312", "B"));
            //编码方式有两种："B"代表Base64、"Q"代表QP（quoted-printable）方式。
             
            msg.setFrom(fromAddress);
            InternetAddress toAddress = new InternetAddress(to);
            msg.setRecipient(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject, "UTF-8");
            msg.setContent(content, "text/html;charset=UTF-8");
            msg.saveChanges();
 
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            LogUtil.logError.error(e.getCause() + "/t" + e.getMessage());
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            LogUtil.logError.error(e.getCause() + "/t" + e.getMessage());
            return false;
        }
        return true;
    }
}