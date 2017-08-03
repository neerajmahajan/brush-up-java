package org.mahajan.businesservice;

import java.util.ArrayList;
import java.util.List;

import org.mahajan.entities.Customer;
import org.mahajan.reposirotry.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBusinessService {
	
	@Autowired
	private CustomerRepository reposiotry;

	public List<Customer> getCustomers() {
		
		List<Customer> customerList = new ArrayList<>();
		
		Iterable<Customer> customers = reposiotry.findAll();
		for (Customer customer : customers) {
			customerList.add(customer);
		}
		
		return customerList;
	}

	public void add(Customer customer) {
		reposiotry.save(customer);
		
	}

	public List<Customer> findByLastName(String lastName) {
		return reposiotry.findByLastNameIgnoreCase(lastName);
	}

}
