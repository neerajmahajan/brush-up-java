package com.brush.up.java.servicemix.soap.cxf.spring.webservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.brush.up.java.webservices.data.model.Customer;
import com.brush.up.java.webservices.data.model.Order;

@WebService
public class CustomerService {

	Map<Long, Customer> customers = new HashMap<Long, Customer>();

	public CustomerService() {
		readCustomerList();
	}

	@WebMethod
	// optional but helpful annotation
	public Customer getCustomer(long customerId) {
		return customers.get(customerId);
	}

	@WebMethod
	// optional but helpful annotation
	public List<Order> getOrders(final long customerId) {
		return customers.get(customerId).getOrders();
	}

	@WebMethod
	// optional but helpful annotation
	public Order getOrder(final long customerId, final long orderId) {
		List<Order> orders = customers.get(customerId).getOrders();
		Order order = null;
		for (Order actualOrder : orders) {
			if (actualOrder.getNumber() == orderId) {
				order = actualOrder;
				break;
			}
		}
		return order;
	}

	private void readCustomerList() {

		Customer c1 = new Customer();
		c1.setName("Elizabeth");
		c1.setNumber(100);
		c1.setLocation("UK");

		Order order1 = new Order();
		order1.setItemCount(3);
		order1.setNumber(1);
		c1.getOrders().add(order1);

		Customer c2 = new Customer();
		c2.setName("Simon");
		c2.setNumber(200);
		c2.setLocation("England");

		Order order2 = new Order();
		order2.setItemCount(10);
		order2.setNumber(50);
		c2.getOrders().add(order2);

		customers.put(c1.getNumber(), c1);
		customers.put(c2.getNumber(), c2);

	}
}
