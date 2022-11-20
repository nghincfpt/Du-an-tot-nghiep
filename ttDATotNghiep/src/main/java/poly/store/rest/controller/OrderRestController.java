package poly.store.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Order;
import poly.store.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

	@Autowired
	OrderService orderService;
	 
	// nhận giới dạng json nên sử dụng requetsBody và nhận vào jsonNode
	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
	return orderService.create(orderData);
	}
}
