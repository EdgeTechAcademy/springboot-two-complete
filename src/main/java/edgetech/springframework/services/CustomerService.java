package edgetech.springframework.services;

import edgetech.springframework.domain.Customer;

/**
 * Created by Edge Tech Academy on 12/12/2016.
 */
public interface CustomerService {
	Iterable<Customer> listAllCustomers();

	Customer getCustomerById(Integer id);

	Customer saveCustomer(Customer Customer);

	void deleteCustomer	(Integer id);

	Iterable<Customer> listOddCustomers();
}

