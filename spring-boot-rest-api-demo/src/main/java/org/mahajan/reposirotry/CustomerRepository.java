package org.mahajan.reposirotry;

import java.util.List;

import org.mahajan.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByLastNameIgnoreCase(String lastName);
	
	//find convention find---by --- propertyName 
	//In case of Object find---by --- ObjectPropertyName -- propertyName of referenced Object

}
