package com.brush.up.java.servicemix.rest.cxf.spring.webservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.brush.up.java.servicemix.rest.cxf.spring.webservice.exception.CustomerNotFoundException;
import com.brush.up.java.webservices.data.model.Customer;
import com.brush.up.java.webservices.data.model.Order;

@Path("/customerservice/")
public class CustomerService {

	Map<Long, Customer> customers = new HashMap<Long, Customer>();

	public CustomerService() {
		readCustomerList();
	}

	@GET
	@Path("/customers/{id}/")
	@Produces("application/xml")
	public Customer getCustomer(@PathParam("id") String number) {
		System.out
				.println("-->-->--> Retrieving customer through getCustomer method, Customer number is: "
						+ number);
		long customerNumber = Long.parseLong(number);
		Customer c = customers.get(customerNumber);
		if (null == c) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		return c;
	}

	@GET
	@Path("/customers/{cid}/order/{oId}/")
	@Produces("application/xml")
	public Order getOrder(@PathParam("cid") String customerNumber,
			@PathParam("oId") String orderNumber) {
		System.out.println("-->-->--> Retrieving order " + orderNumber
				+ " for customer " + customerNumber
				+ " through getOrder method");
		long customerNo = Long.parseLong(customerNumber);
		int orderNo = Integer.parseInt(orderNumber);

		Customer c = customers.get(customerNo);

		if (null == c) {
			throw new CustomerNotFoundException("Customer doesn't exist");
		}

		Order responseOrder = null;

		List<Order> orders = c.getOrders();
		for (Order order : orders) {
			if (order.getNumber() == orderNo) {
				responseOrder = order;
				break;
			}
		}

		if (responseOrder == null) {
			throw new NotFoundException("Order " + orderNo + " not found for customer " +customerNo);
		} else {
			return responseOrder;
		}

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
