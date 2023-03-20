package com.mappingProject.utils;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import lombok.Data;

@Configuration
@Data
public class EmailConstraint {
	
	@Value("${spring.mail.username}")
	private String username;
	@Value("${spring.mail.password}")
	private String password;
	@Value("${spring.mail.port}")
	private String port;
	@Value("${spring.mail.host}")
	private String host;
	@Value("${spring.mail.isAuth}")
	private String isAuth;
	@Value("${spring.mail.tls}")
	private String istls;
	 
	private Properties getPropertiseInstantce() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", isAuth);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.starttls.enable", istls);
		
		return properties;
	}
	
	public Session getSessionInstance() {
		return Session.getInstance(getPropertiseInstantce(), new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

}
