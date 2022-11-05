package poly.store.service;

import java.util.List;

import poly.store.entity.Product;



public interface ProductService {

	
	
	List<Product> findAll();

	Product findById(Integer id);

	Product save(Product product);

	Product update(Product product);

	void deleteById(Integer id);

	void delete(Integer id);

	

}
