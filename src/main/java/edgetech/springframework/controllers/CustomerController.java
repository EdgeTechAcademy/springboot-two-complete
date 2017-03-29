package edgetech.springframework.controllers;

import edgetech.springframework.domain.Customer;
import edgetech.springframework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Edge Tech Academy on 12/12/2016.
 */
@Controller
public class CustomerController {

	//	Use a service for when things get complicated.
	//	more so than just doing a findAll or delete

	private CustomerService CustomerService;

	@Autowired
	public void setCustomerService(CustomerService CustomerService) {
		this.CustomerService = CustomerService;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("customers", CustomerService.listAllCustomers());
		System.out.println("Returning Customers:");
		return "customers";
	}

	@RequestMapping("customer/{id}")
	public String showCustomer(@PathVariable Integer id, Model model){
		if ( CustomerService.getCustomerById(id) != null ) {
			model.addAttribute("customer", CustomerService.getCustomerById(id));
			return "customershow";
		}
		else return "404";
	}

	//	These items have been added for the new functionality
	//		to make our app a richer MVC example
	@RequestMapping("customer/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		model.addAttribute("customer", CustomerService.getCustomerById(id));
		return "customerform";
	}

	@RequestMapping("customer/new")
	public String newCustomer(Model model){
		model.addAttribute("customer", new Customer());
		return "customerform";
	}

	@RequestMapping(value = "customer", method = RequestMethod.POST)
	public String saveCustomer(Customer Customer){
		CustomerService.saveCustomer(Customer);
		return "redirect:/customer/" + Customer.getId();
	}

	@RequestMapping("customer/delete/{id}")
	public String delete(@PathVariable Integer id){
		CustomerService.deleteCustomer(id);
		return "redirect:/customers";
	}

	@RequestMapping(value = "/oddCustomers", method = RequestMethod.GET)
	public String listOdd(Model model){
		model.addAttribute("customers", CustomerService.listOddCustomers());
		System.out.println("Returning Customers:");
		return "customers";
	}
}
