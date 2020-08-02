package com.payment.transaction;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.payment.transaction.entity.SubscriptionTypeEntity;
import com.payment.transaction.entity.UserSubscriptionEntity;
import com.payment.transaction.repository.SubscriptionTypeRepository;
import com.payment.transaction.repository.UserSubscriptionRepository;

@Component
public class PaymentTransactionCommandLineRunner implements CommandLineRunner{
	@Autowired
	SubscriptionTypeRepository subscriptionTypeRepository;
	@Autowired
	UserSubscriptionRepository userSubscriptionRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SubscriptionTypeEntity subscriptionTypeEntity1 = new SubscriptionTypeEntity(1, "Bronze Plan", 1000.00);
		SubscriptionTypeEntity subscriptionTypeEntity2 = new SubscriptionTypeEntity(2, "Silver Plan", 2000.00);
		SubscriptionTypeEntity subscriptionTypeEntity3 = new SubscriptionTypeEntity(3, "Gold Plan", 3000.00);
		
		subscriptionTypeEntity1 = subscriptionTypeRepository.save(subscriptionTypeEntity1);
		subscriptionTypeEntity2 = subscriptionTypeRepository.save(subscriptionTypeEntity2);
		subscriptionTypeEntity3 = subscriptionTypeRepository.save(subscriptionTypeEntity3);
		
		UserSubscriptionEntity userSubscriptionEntity1 
			= new UserSubscriptionEntity("101", subscriptionTypeEntity1, 
					Date.valueOf("2020-08-01"), Date.valueOf("2020-08-31"));
		UserSubscriptionEntity userSubscriptionEntity2
			= new UserSubscriptionEntity("102", subscriptionTypeEntity2, 
					Date.valueOf("2020-08-01"), Date.valueOf("2020-08-31"));
		UserSubscriptionEntity userSubscriptionEntity3
			= new UserSubscriptionEntity("103", subscriptionTypeEntity3, 
					Date.valueOf("2020-08-01"), Date.valueOf("2020-08-31"));
		
		userSubscriptionRepository.save(userSubscriptionEntity1);
		userSubscriptionRepository.save(userSubscriptionEntity2);
		userSubscriptionRepository.save(userSubscriptionEntity3);
	}
}