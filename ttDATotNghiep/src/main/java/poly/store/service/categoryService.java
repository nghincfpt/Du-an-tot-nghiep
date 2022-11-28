package poly.store.service;

import java.util.List;

import poly.store.entity.Category;
import poly.store.entity.Product;

public interface categoryService {

	List<Category> findAll();
	
	

	
	
	Category save(Category Category);

	Category update(Category Category);



	Category findById(String id);



	void delete(String id);



	void deleteById(String id);

}
