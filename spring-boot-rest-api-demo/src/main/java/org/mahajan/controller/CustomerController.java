package org.mahajan.controller;

import java.util.List;

import org.mahajan.businesservice.CustomerBusinessService;
import org.mahajan.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerBusinessService service; 
	
	@RequestMapping(method=RequestMethod.GET, value="/customers")
	public List<Customer> getAllCustomers(){
		return service.getCustomers();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customers/{lastName}")
	public List<Customer> getCustomersByLastName(@PathVariable String lastName){
		return service.findByLastName(lastName);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public void  addCustomer(@RequestBody Customer customer){
		service.add(customer);
	}
	
	

}
