package poly.store.service.Lmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.DAO.ProductDao;
import poly.store.entity.Product;
import poly.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

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
	public List<Product> findByCategoryId(String cid) {
	
		return pdao.findByCategoryId(cid);
	}
	
}
