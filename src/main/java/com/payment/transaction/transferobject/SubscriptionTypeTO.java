package com.payment.transaction.transferobject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionTypeTO {
	private Integer subscriptionId;
	private String subscriptionType;
	private String valuePerMonth;
	public SubscriptionTypeTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}