package edgetech.springframework.domain;

import javax.persistence.*;

/**
 * Created by Edge Tech Academy on 12/2/2016.
 */
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String customerId;
	private String location;

	public Customer( String customerId, String location ) {
		this.customerId = customerId;
		this.location = location;
	}

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId( String customerId ) {
		this.customerId = customerId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation( String location ) {
		this.location = location;
	}
}