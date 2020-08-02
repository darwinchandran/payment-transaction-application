package com.payment.transaction.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.transaction.transferobject.UserInvoiceTO;
import com.payment.transaction.transferobject.UserSubscriptionTO;

@Service
public class InvoiceManagementService {
	@Autowired
	SubscriptionManagementService subscriptionManagementService;
	
	public List<UserInvoiceTO> getAllUserInvoices() {
		List<UserSubscriptionTO> allUserSubscriptions = subscriptionManagementService.getAllUserSubscriptions();
		
		List<UserInvoiceTO> allUserInvoices = allUserSubscriptions.stream().map(subscription 
				-> new UserInvoiceTO(subscription.getUserId(), Double.valueOf(subscription.getSubscription().getValuePerMonth())))
				.collect(Collectors.toList());
		
		return allUserInvoices;
	}
	
	public UserInvoiceTO getUserInvoiceById(String userId) {
		UserSubscriptionTO userSubscription = subscriptionManagementService.getUserSubscriptionsByUserId(userId);
		
		UserInvoiceTO userInvoice = new UserInvoiceTO(userSubscription.getUserId(), Double.valueOf(userSubscription.getSubscription().getValuePerMonth()));
		
		return userInvoice;
	}
}