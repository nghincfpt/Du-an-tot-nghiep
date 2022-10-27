package poly.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("admin/products")
public class ProductController {

	@GetMapping("add")
	public String add(Model model) {
	
		return "admin/products/list";
	}
}
