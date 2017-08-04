package org.mahajan;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mahajan.entities.Customer;
import org.mahajan.reposirotry.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest // or ContextConfiguration(classes = SpringBootRestApiDemoApplicationTests.class, loader=SpringApplicationContextLoader.class
public class SpringBootRestApiDemoApplicationTests {
	
	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
		
		Assert.assertNotNull("the repository should be  not null",customerRepository);
	}
	
	@Test
	public void testLoadingResultsInDatabase (){
		
		List<Customer> customerList = this.customerRepository.findAll();
		Assert.assertNotNull("the repository should be  not null",customerRepository);
		System.out.println("############################" + customerList.size());
		Assert.assertNotNull("the repository should have at least one result ",customerList.size() > 0);
	}

}
