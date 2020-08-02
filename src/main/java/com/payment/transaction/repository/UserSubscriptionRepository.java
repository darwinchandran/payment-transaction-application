package com.payment.transaction.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.payment.transaction.entity.UserSubscriptionEntity;

public interface UserSubscriptionRepository extends CrudRepository<UserSubscriptionEntity, Integer>{
	@Query(value = "SELECT userSubscription from UserSubscriptionEntity userSubscription where userSubscription.userId =?1 ")
	public UserSubscriptionEntity findByUserId(String userId);
}