package com.payment.transaction.transferobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSubscriptionTO {
	private Integer userSubscriptionId;
	private String userId;
	private SubscriptionTypeTO subscription;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	public UserSubscriptionTO() {
		super();
	}
}