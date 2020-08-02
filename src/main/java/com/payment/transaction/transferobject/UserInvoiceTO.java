package com.payment.transaction.transferobject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInvoiceTO {
	private String userId;
	private Double basePrice;
	private Double tax;
	private Double totalTobePaid;
	
	public UserInvoiceTO(String userId, Double basePrice) {
		super();
		this.userId = userId;
		this.basePrice = basePrice;
		this.tax = basePrice * (9.00/100.00);
		this.totalTobePaid = basePrice + this.tax;
	}
}