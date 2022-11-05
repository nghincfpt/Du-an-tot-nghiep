package poly.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.dao.ProductDao;
import poly.store.entity.Product;
import poly.store.service.ProductService;


@Service
public class ProductServiceIMpl implements ProductService {
	@Autowired
	ProductDao pdao;

	@Override
	public List<Product> findAll() {
		
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		
		return pdao.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 pdao.deleteById(id);
		
	}

	@Override
	public void deleteById(Integer id) {
		pdao.deleteById(id);
		
	}

	


}
