package com.payment.transaction.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "user_subscription")
@Data
public class UserSubscriptionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_subscription_id")
	private int userSubscriptionId;
	@Column(name = "user_id")
	private String userId;
	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private SubscriptionTypeEntity subscription;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	
	public UserSubscriptionEntity(String userId, SubscriptionTypeEntity subscription, Date startDate,
			Date endDate) {
		super();
		this.userId = userId;
		this.subscription = subscription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public UserSubscriptionEntity() {
		super();
	}
}