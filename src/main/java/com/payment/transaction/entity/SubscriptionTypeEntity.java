package com.payment.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "subscription_type")
@Data
@AllArgsConstructor
public class SubscriptionTypeEntity {
	@Id
	@Column(name = "subscription_id")
	private Integer subscriptionId;
	@Column(name = "subcription_type")
	private String subscriptionType;
	@Column(name = "value_per_month")
	private Double valuePerMonth;
	
	public SubscriptionTypeEntity() {
		super();
	}
}