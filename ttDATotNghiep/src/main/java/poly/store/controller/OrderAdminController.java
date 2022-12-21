package poly.store.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.config.Constants;
import poly.store.entity.Product;
import poly.store.service.OrderService;
import poly.store.service.ProductService;







@Controller

public class OrderAdminController {


	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/adminorder/checkout")
	public String checkout() {
		return "adminorder/checkout";
	}
	@RequestMapping("/adminorder/list")
	public String list(Model model,HttpServletRequest request) {
		String username = request.getRemoteUser();
	
		model.addAttribute("orders",orderService.findAllUsername(username));
		return "adminorder/list";
	}

	
	@RequestMapping("/adminorder/detail/{id}")
	public String detail(@PathVariable("id")Long id,Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "adminorder/detail";
	}
}
