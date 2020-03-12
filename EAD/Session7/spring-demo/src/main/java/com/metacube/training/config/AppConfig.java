package com.metacube.training.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.training.mailSender.MockMailSender;
import com.metacube.training.mailSender.SmtpMailSender;

/**
 * This method is creating bean objects of SmtpMailSender and MockMailSender class.
 */
@Configuration
public class AppConfig 
{
	@Bean("mock")	
	public MockMailSender mockMailSender() 
	{
		return new MockMailSender();
	}
	
	@Bean("smtp")
	public SmtpMailSender smtpMailSender() 
	{
		return new SmtpMailSender();
	}
}
