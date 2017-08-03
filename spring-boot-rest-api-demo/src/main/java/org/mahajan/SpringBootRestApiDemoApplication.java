package org.mahajan;

import org.mahajan.entities.Customer;
import org.mahajan.reposirotry.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRestApiDemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootRestApiDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiDemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Neeraj", "Mahajan","14/05/1985"));
			repository.save(new Customer("Amit", "Sharma","06/08/1982"));
			log.info("");
		};
	}
}
