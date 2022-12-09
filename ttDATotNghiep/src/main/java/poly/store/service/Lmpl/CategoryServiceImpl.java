package poly.store.service.Lmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.store.DAO.CategoryDAO;
import poly.store.entity.Category;

import poly.store.service.categoryService;

@Service
public class CategoryServiceImpl implements categoryService {

	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
	
		return cdao.findAll();
	}
	
	@Override
	public Category findById(String id) {
		
		return cdao.findById(id).get();
	}


	@Override
	public Category save(Category Category) {
		// TODO Auto-generated method stub
		return cdao.save(Category);
	}

	@Override
	public Category update(Category Category) {
		// TODO Auto-generated method stub
		return cdao.save(Category);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		 cdao.deleteById(id);
		
	}

	@Override
	public void deleteById(String id) {
		cdao.deleteById(id);
		
	}

	

	
}
