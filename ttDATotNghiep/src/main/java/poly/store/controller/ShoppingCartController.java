package poly.store.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.entity.Product;






@Controller


public class ShoppingCartController {
	
	@RequestMapping("/cart/view")
	public String list(Model model) {
		return "cart/view";
	}

}
