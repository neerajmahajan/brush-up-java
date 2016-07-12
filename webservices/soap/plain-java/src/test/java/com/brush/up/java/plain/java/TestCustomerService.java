package com.brush.up.java.plain.java;

import junit.framework.Assert;

import org.junit.Test;

public class TestCustomerService {

	@Test
	public void testCustomerService() {
		CustomerService customerService = new CustomerService();
		
		Assert.assertNotNull(customerService);
	}

}
