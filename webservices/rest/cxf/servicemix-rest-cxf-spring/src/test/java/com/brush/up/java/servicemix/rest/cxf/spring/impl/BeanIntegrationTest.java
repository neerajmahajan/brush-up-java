package com.brush.up.java.servicemix.rest.cxf.spring.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brush.up.java.servicemix.rest.cxf.spring.Bean;
import com.brush.up.java.servicemix.rest.cxf.spring.webservice.CustomerService;
import com.brush.up.java.webservices.data.model.Customer;

/**
 * Local integration test (outside of OSGi).
 * @see BeanOsgiIntegrationTest for integration test inside OSGi.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/bundle-context.xml")
public class BeanIntegrationTest  {

	private Bean myBean;
	
	@Autowired
	private CustomerService customerRequestHandler;
	
	@Test
    public void testCustomerService() {
		Customer customer = customerRequestHandler.getCustomer("100");
		Assert.assertNotNull(customer);
    }
	

}

