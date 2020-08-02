package com.payment.transaction;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentTransactionApplication.class, args);
	}
	
	@Bean
	public DozerBeanMapper dozerMapper() {
		return new DozerBeanMapper();
	}

}
