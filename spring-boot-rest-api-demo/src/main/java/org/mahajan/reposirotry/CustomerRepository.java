package org.mahajan.reposirotry;

import java.util.List;

import org.mahajan.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findByLastNameIgnoreCase(String lastName);

}
