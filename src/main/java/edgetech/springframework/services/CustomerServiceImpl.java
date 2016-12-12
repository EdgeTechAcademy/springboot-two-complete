package edgetech.springframework.services;

import edgetech.springframework.domain.Customer;
import edgetech.springframework.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
/**
 * Created by Edge Tech Academy on 12/12/2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository CustomerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository CustomerRepository) {
		this.CustomerRepository = CustomerRepository;
	}

	@Override
	public Iterable<Customer> listAllCustomers() {
		return CustomerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return CustomerRepository.findOne(id);
	}

	//	These items have been added for the new functionality
	//		to make our app a richer MVC example
	@Override
	public Customer saveCustomer(Customer Customer) {
		return CustomerRepository.save(Customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		Customer    Customer = CustomerRepository.findOne(id);
		CustomerRepository.delete(Customer);
	}

	@Override
	public Iterable<Customer> listOddCustomers() {
		Iterable<Customer> Customers = CustomerRepository.findAll();
		for(Iterator<Customer> prodIterator = Customers.iterator(); prodIterator.hasNext();) {
			Customer prod = prodIterator.next();
			if ((prod.getId() & 1) == 0)		// if the Id is Even
				prodIterator.remove();			// remove from our list
		}
		return Customers;
	}
}
