package com.metacube.training.mailSender;

import org.slf4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("smtpmailsender")
//@Primary
public class SmtpMailSender implements MailSender {
	
	@Override
	public void sendMail()
	{
		System.out.println("MAIL SENT!!! SMTP sender");
		final Logger log = org.slf4j.LoggerFactory.getLogger(SmtpMailSender.class);
		log.info("Mail send from SMTP mail sender");
	}
}
