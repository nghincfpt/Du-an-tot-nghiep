package poly.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.store.entity.Product;
import poly.store.service.ProductService;





@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	ProductService productService;
	@RequestMapping("/list")
	public String list(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("items",list);
		return "product/list";
	}
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);
		return "product/detail";
	}
}
