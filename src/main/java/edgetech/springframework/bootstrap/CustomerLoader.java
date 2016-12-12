package edgetech.springframework.bootstrap;

import edgetech.springframework.domain.Customer;
import edgetech.springframework.repositories.CustomerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Edge Tech Academy on 12/2/2016.
 */
@Component
public class CustomerLoader implements ApplicationListener<ContextRefreshedEvent> {

	private CustomerRepository repository;

	private Logger log = Logger.getLogger( CustomerLoader.class );

	@Autowired
	public void setRepository( CustomerRepository repository ) {
		this.repository = repository;
	}

	@Override
	public void onApplicationEvent( ContextRefreshedEvent event ) {

		createCustomer( "Microsoft",		"Seattle" );
		createCustomer( "Oracle", 			"Austin" );
		createCustomer( "IBM",		 		"Roanoak" );
		createCustomer( "Amazon", 			"Palo Alta" );
		createCustomer( "Best Buy", 		"Mansfield" );
		createCustomer( "Neiman Marcus", 	"Dallas" );
		createCustomer( "Fry's", 			"Coppell" );
		createCustomer( "Torchy's Tacos", 	"Arlington" );
	}

	public void createCustomer( String customerId, String location ) {
		Customer cust;

		cust = new Customer( customerId, location );
		repository.save( cust );
		log.info( "id: " + cust.getId() + "  " + cust.getCustomerId() );
	}
}
