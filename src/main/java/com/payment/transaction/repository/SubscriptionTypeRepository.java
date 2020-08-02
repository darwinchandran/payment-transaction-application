package com.payment.transaction.repository;

import org.springframework.data.repository.CrudRepository;

import com.payment.transaction.entity.SubscriptionTypeEntity;

public interface SubscriptionTypeRepository extends CrudRepository<SubscriptionTypeEntity, Integer> {

}
