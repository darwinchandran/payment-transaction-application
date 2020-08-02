package com.payment.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.transaction.service.SubscriptionManagementService;
import com.payment.transaction.transferobject.UserSubscriptionTO;

@RestController
@RequestMapping(path = "subscription-management")
public class SubscriptionManagementController {
	@Autowired
	SubscriptionManagementService subscriptionManagementService;
	
	@GetMapping(path = "/users")
	public ResponseEntity<List<UserSubscriptionTO>> getAllUserSubscriptions() {
		List<UserSubscriptionTO> userSubscriptions = subscriptionManagementService.getAllUserSubscriptions();
		return new ResponseEntity<List<UserSubscriptionTO>>(userSubscriptions, HttpStatus.OK);
	}
	
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<UserSubscriptionTO> getUserSubscriptionByUserId(@PathVariable(name = "id") String userId) {
		UserSubscriptionTO userSubscription = subscriptionManagementService.getUserSubscriptionsByUserId(userId);
		return new ResponseEntity<UserSubscriptionTO>(userSubscription, HttpStatus.OK);
	}
}