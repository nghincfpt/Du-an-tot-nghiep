package poly.store.rest.controller;



import poly.store.entity.Manufacturer;

import poly.store.service.Lmpl.ManufactureServiceImpl;


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
@RequestMapping("/rest/manufacture")
public class ManufactureRestController {
	
	@Autowired
	ManufactureServiceImpl ManufactureService;
	 
	@GetMapping
	public List<Manufacturer> getAll(){
		return ManufactureService.findAll();
	}
	@GetMapping("/{id}")
	public Manufacturer getOne(@PathVariable("id") Integer id) {
		
		return ManufactureService.findById(id);
	}
	
	
	@PostMapping()
	public Manufacturer create(@RequestBody Manufacturer Manufactures) {
		return ManufactureService.save(Manufactures);
	}
	
	@PutMapping("{id}")
	public Manufacturer update(@PathVariable("id") String id,@RequestBody Manufacturer Manufactures) {
		return ManufactureService.update(Manufactures);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		ManufactureService.delete(id);
	}
}
