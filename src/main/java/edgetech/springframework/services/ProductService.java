package edgetech.springframework.services;

import edgetech.springframework.domain.Product;

/**
 * Created by Edge Tech Academy on 12/12/2016.
 */
public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

	//	These items have been added for the new functionality
	//		to make our app a richer MVC example
    Product saveProduct(Product product);

    void deleteProduct(Integer id);

    Iterable<Product> listOddProducts();
}
