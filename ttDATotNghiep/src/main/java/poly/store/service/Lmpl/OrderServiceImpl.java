package poly.store.service.Lmpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import poly.store.DAO.OrderDAO;
import poly.store.DAO.OrderDetailDAO;
import poly.store.entity.Order;
import poly.store.entity.OrderDetail;
import poly.store.entity.Product;
import poly.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO dao;

	@Autowired
	OrderDetailDAO ddao;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);

		// đọ json list orderdtail
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type).stream()
				.peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);

		return order;
	}
	
	@Override
	public List<Order> findAll() {
	
		return dao.findAll();
	}
	@Override
	public Order findById(Long id) {

		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByIdUsername(String username) {

		return dao.findByIdUsername(username);
	}
	
	@Override
	public List<Order> findAllUsername(String username) {

		return dao.findAllUsername(username);
	}
	@Override
	 public List<Order> listAll(){
		   return dao.findAll(Sort.by("Address").ascending());
	   }

	@Override
	public void delete(Long id) {
		 dao.deleteById(id);
		
	}

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return dao.save(order);
	}
		
}
