package com.brush.up.java.servicemix.rest.cxf.spring.webservice;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.brush.up.java.servicemix.rest.cxf.spring.webservice.model.Customer;

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
        System.out.println("-->-->--> Retrieving customer through getCustomer method, Customer number is: " + number);
        long customerNumber = Long.parseLong(number);
        Customer c = customers.get(customerNumber);
        return c;
    }
	
	
	
	private void readCustomerList(){
	
		Customer c1 = new Customer();
        c1.setName("Elizabeth");
        c1.setNumber(100);
        c1.setLocation("UK");
        
        Customer c2 = new Customer();
        c2.setName("Simon");
        c2.setNumber(200);
        c2.setLocation("England");
        
        
        customers.put(c1.getNumber(), c1);
        customers.put(c2.getNumber(), c2);
		
	}

}
