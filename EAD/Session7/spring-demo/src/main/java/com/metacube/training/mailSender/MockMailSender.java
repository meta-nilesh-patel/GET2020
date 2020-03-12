package com.metacube.training.mailSender;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

//@Component("mockmailsender")
public class MockMailSender implements MailSender
{
	
	@Override
	public void sendMail()
	{
		System.out.println("MESSAGE WRITTEN Mock mail sender");
		final Logger log = org.slf4j.LoggerFactory.getLogger(SmtpMailSender.class);
		log.info("Mail send from Mock mail sender");
	}
}
