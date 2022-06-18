package com.shared.domain;

import org.springframework.stereotype.Service;

@Service
public interface NotificationDomainService {

	void sendNotification(String toEmail, String subject, String body);
	
}
