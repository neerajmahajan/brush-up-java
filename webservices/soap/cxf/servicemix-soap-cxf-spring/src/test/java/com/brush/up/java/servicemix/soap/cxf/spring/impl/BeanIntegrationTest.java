package com.brush.up.java.servicemix.soap.cxf.spring.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brush.up.java.servicemix.soap.cxf.spring.Bean;

/**
 * Local integration test (outside of OSGi).
 * @see BeanOsgiIntegrationTest for integration test inside OSGi.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/bundle-context.xml")
public class BeanIntegrationTest  {

	
	@Autowired
	private Bean myBean;
	
	@Test
    public void testBean() {
		Assert.assertNotNull(myBean);
    }
	

}

