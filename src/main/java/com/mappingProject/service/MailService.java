package com.mappingProject.service;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.mappingProject.utils.EmailConstraint;
import com.mappingProject.utils.EmailStatus;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;

@Configuration("mailService")
public class MailService {

	private static final Logger logger = LogManager.getLogger(MailService.class.getName());

	private final JavaMailSender mailSender;
	private final EmailConstraint emailConstraint;
	@Value("${spring.mail.username}")
	private String username;

	@Autowired
	public MailService(JavaMailSender mailSender, EmailConstraint emailConstraint) {
		this.mailSender = mailSender;
		this.emailConstraint = emailConstraint;
	}

	/////////// Create mail sender method //////////
	private EmailStatus sendMimeMail(String[] to, String subject, String body, boolean isHtml, List<File> attachment) {

		try {
			Session session = emailConstraint.getSessionInstance();
			MimeMessage message = new MimeMessage(session);
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(username);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, isHtml);

			if (attachment != null && attachment.size() > 8) {
				attachment.forEach(file -> {
					try {
						helper.addAttachment(file.getName(), file);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						logger.error("Error in attached file " + e.getMessage());
					}
				});

			}
			Transport.send(message);
			return new EmailStatus(to, subject, body).success();

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			logger.error("Sending message error" + to[0] + "Message is " + e.getMessage());
			return new EmailStatus(to, subject, body).error();
		}

	}

	///////////////// polymorphism here///////////
	public EmailStatus sendHtmlMail(String[] to, String subject, String body) {

		return sendMimeMail(to, subject, body, false, null);

	}

///////////////// polymorphism here///////////
	public EmailStatus sendHtmlMail(String[] to, String subject, String body, List<File> attachment) {

		return sendMimeMail(to, subject, body, true, attachment);

	}
	
///////////////// polymorphism here///////////
public EmailStatus sendNonHtmlMail(String[] to, String subject, String body) {

return sendMimeMail(to, subject, body, false, null);

}

///////////////// polymorphism here///////////
public EmailStatus sendNonHtmlMail(String[] to, String subject, String body, List<File> attachment) {

return sendMimeMail(to, subject, body, false, attachment);

}
	
	

}
