package poly.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
@RequestMapping({"/","/home/index"})
public String home() {
	return "redirect:/product/home";
}

@RequestMapping({"/admin","/admin/index"})
public String admin() {
	return "redirect:/assets/admin/index.html";
}

@RequestMapping({"/admin","/admin/product/list"})
public String adminProduct() {
	return "redirect:/assets/admin/productlist.html";
}
}
