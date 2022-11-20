package poly.store.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Product;
import poly.store.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
 
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<Product> getAll() {
		return productService.findAll();
	}
//	@GetMapping("page")
//	public String search(ModelMap model,
//			 @RequestParam(name = "name", required= false) String name,
//			 @RequestParam("page") Optional<Integer> page,
//			 @RequestParam("size") Optional<Integer> size) {
//		
//		int currentpage = page.orElse(1);
//		int pageSize = size.orElse(5);
//		
//		Pageable pageable = PageRequest.of(currentpage-1, pageSize,Sort.by("name"));
//		//Pageable pageable = PageRequest.of(currentpage, pageSize,Sort.by("name"));
//		
//		Page<Product> resultPage = null;
//		
//		 
//		if(StringUtils.hasText(name)) {
//			 resultPage = productService.findByNameContaining(name,pageable);
//			 model.addAttribute("name",name);
//			 System.out.println("ljsdlfjsdf    "+resultPage.getContent().size() + " ----- " + name);
//		 }else {
//			 resultPage = productService.findAllpage(pageable);
//		 }
//		
//		 int  totaPages = resultPage.getTotalPages();
//		 System.out.println("Total page: " + totaPages);
//		 if(totaPages > 0) {
//			 int start = Math.max(1, currentpage-2);
//			 int end = Math.min(currentpage + 2, totaPages);
//		
//		 if(totaPages >5) {
//			 if(end == totaPages) start = end-5;
//			 else if (start == 1 ) end = start +5;
//		 }
//		 List<Integer> pagenumbers = IntStream.rangeClosed(start, end)
//				 .boxed()
//				 .collect(Collectors.toList());
//		model.addAttribute("pagenumbers",pagenumbers);
//		 }
//		 
//		model.addAttribute("productPage", resultPage);
//		
//		return "product/list";
//	}
	
	@GetMapping("/{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		
		return productService.findById(id);
	}
//	
//	@PostMapping()
//	public Product create(@RequestBody Product product) {
//		return productService.save(product);
//	}
//	
//	@PutMapping("{id}")
//	public Product update(@PathVariable("id") Integer id,@RequestBody Product product) {
//		return productService.update(product);
//	}
//	
//	@DeleteMapping("{id}")
//	public void delete(@PathVariable("id") Integer id) {
//		 productService.delete(id);
//	}
}
