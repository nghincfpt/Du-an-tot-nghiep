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

	
}
