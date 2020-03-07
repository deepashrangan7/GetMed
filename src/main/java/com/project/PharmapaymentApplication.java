package com.project;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com")
public class PharmapaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmapaymentApplication.class, args);

	}
	@Bean
	public HashMap<Integer,Double> map()
	{
		return new HashMap<Integer,Double>();
	}
	
	@Bean
	public LocalValidatorFactoryBean validate(MessageSource messageSource) {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();

		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		return localValidatorFactoryBean;
	}

}
