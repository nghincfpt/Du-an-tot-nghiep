package poly.store.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Category;
import poly.store.entity.Product;
import poly.store.service.Lmpl.CategoryServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	
	@Autowired
	CategoryServiceImpl categoryService;
	 
	@GetMapping
	public List<Category> getAll(){
		return categoryService.findAll();
	}
	@GetMapping("/{id}")
	public Category getOne(@PathVariable("id") String id) {
		System.out.println(id);
		System.out.println("-----------------");
		return categoryService.findById(id);
	}
	
	
	@PostMapping()
	public Category create(@RequestBody Category Category) {
		return categoryService.save(Category);
	}
	
	@PutMapping("{id}")
	public Category update(@PathVariable("id") String id,@RequestBody Category Category) {
		return categoryService.update(Category);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		categoryService.delete(id);
	}
}
