package poly.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.entity.Product;
import poly.store.service.OrderService;
import poly.store.service.ProductService;







@Controller

public class OrderController {


	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	@RequestMapping("/order/list")
	public String list(Model model,HttpServletRequest request) {
		String username =request.getRemoteUser();
	//	model.addAttribute("orders",orderService.findByIdUsername(username));
		model.addAttribute("orders",orderService.findByIdUsername(username));
		return "order/list";
	}

	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id")Long id,Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}
}
