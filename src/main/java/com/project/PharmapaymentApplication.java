package com.project;

import java.io.IOException;
import java.util.HashMap;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com")
public class PharmapaymentApplication {

    @Autowired
    private JavaMailSender javaMailSender;
	public static void main(String[] args) throws MessagingException {
		SpringApplication.run(PharmapaymentApplication.class, args);
	
		
	}
	
	
	public void run(String[] args) {

        System.out.println("Sending Email...");

        try {
		
            sendEmail();
            //sendEmailWithAttachment();

        } catch (Exception e) {
            e.printStackTrace();
        } 

        System.out.println("Done");

    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("deepashdeepika7@gmail.com", "monikamohan98@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }

	
	
	
	
	@Bean
	public HashMap<Integer,Integer> map()
	{
		return new HashMap<Integer,Integer>();
	}
	
	@Bean
	public LocalValidatorFactoryBean validate(MessageSource messageSource) {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();

		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		return localValidatorFactoryBean;
	}

}
