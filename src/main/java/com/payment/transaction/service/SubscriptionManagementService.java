package com.payment.transaction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.transaction.entity.UserSubscriptionEntity;
import com.payment.transaction.repository.UserSubscriptionRepository;
import com.payment.transaction.transferobject.UserSubscriptionTO;

@Service
public class SubscriptionManagementService {
	@Autowired
	UserSubscriptionRepository userSubscriptionRepository;
	@Autowired
	DozerBeanMapper dozerBeanMapper;
	
	public List<UserSubscriptionTO> getAllUserSubscriptions() {
		Iterable<UserSubscriptionEntity> allsubscriptionsIterable = userSubscriptionRepository.findAll();
		List<UserSubscriptionEntity> allSubscriptionsFromDB = new ArrayList<UserSubscriptionEntity>();
		
		allsubscriptionsIterable.forEach(allSubscriptionsFromDB::add);
		
		List<UserSubscriptionTO> allSubscriptions = allSubscriptionsFromDB.stream()
				.map(subscriptionFromDB -> dozerBeanMapper.map(subscriptionFromDB, UserSubscriptionTO.class))
				.collect(Collectors.toList());
		
		return allSubscriptions;
	}
	
	public UserSubscriptionTO getUserSubscriptionsByUserId(String userId) {
		UserSubscriptionEntity subscriptionFromDB = userSubscriptionRepository.findByUserId(userId);
		
		UserSubscriptionTO subscription = 
				dozerBeanMapper.map(subscriptionFromDB, UserSubscriptionTO.class);
		
		return subscription;
	}
}