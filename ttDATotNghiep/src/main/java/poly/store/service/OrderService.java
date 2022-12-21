package poly.store.service;



import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Order;
import poly.store.entity.Product;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByIdUsername(String username);



	List<Order> findAllUsername(String username);

	List<Order> listAll();

	void delete(Long id);

	Order update(Order order);

	List<Order> findAll();

	


	
  


}
