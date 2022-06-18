package com.shared.infrastructure;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.shared.domain.Constants;
import com.shared.domain.NotificationDomainService;

@Service

public class NotificationDomainServiceImplementation implements NotificationDomainService{

	
	private JavaMailSender javaMailSender;
	
	public NotificationDomainServiceImplementation(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	@Override
	public void sendNotification(String toEmail,
								String subject,
								String body) {
	SimpleMailMessage email	= new SimpleMailMessage();
	email.setFrom(Constants.DEPARTMENT_MANAGER_EMAIL);
	email.setTo(toEmail);
	email.setText(body);
	email.setSubject(subject);
	javaMailSender.send(email);
		
	}
   
	
	


	
	
}
