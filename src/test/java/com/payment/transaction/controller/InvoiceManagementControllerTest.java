package com.payment.transaction.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvoiceManagementControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private InvoiceManagementController invoiceManagementController;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(invoiceManagementController).build();
	}

	@Test
	public void getAllUserInvoices() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/invoice-management/users");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		
		assertTrue(result.getResponse().getContentAsString() != null);
	}
	
	@Test
	public void getUserInvoiceByUserId() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/invoice-management/users/101");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		
		assertTrue(result.getResponse().getContentAsString() != null);
	}
}