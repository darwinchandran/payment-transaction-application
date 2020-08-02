package com.payment.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.transaction.service.InvoiceManagementService;
import com.payment.transaction.transferobject.UserInvoiceTO;

@RestController
@RequestMapping(path = "invoice-management")
public class InvoiceManagementController {
	@Autowired
	InvoiceManagementService invoiceManagementService;
	
	@GetMapping(path = "/users")
	public ResponseEntity<List<UserInvoiceTO>> getAllUserInvoices() {
		List<UserInvoiceTO> userInvoices = invoiceManagementService.getAllUserInvoices();
		return new ResponseEntity<List<UserInvoiceTO>>(userInvoices, HttpStatus.OK);
	}
	
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<UserInvoiceTO> getUserInvoiceByUserId(@PathVariable(name = "id") String userId) {
		UserInvoiceTO userInvoice = invoiceManagementService.getUserInvoiceById(userId);
		return new ResponseEntity<UserInvoiceTO>(userInvoice, HttpStatus.OK);
	}
}