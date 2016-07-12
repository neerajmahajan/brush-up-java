package com.brush.up.java.webservices.data.model;

import org.junit.Test;


public class TestCustomer {

	@Test
	public void test() {
		Customer c1 = new Customer();
		c1.setName("Elizabeth");
		c1.setNumber(100);
		c1.setLocation("UK");

		Order order1 = new Order();
		order1.setItemCount(3);
		order1.setNumber(1);
		c1.getOrders().add(order1);
	}

}
