package poly.store.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.store.entity.Category;




@Repository
public interface CategoryDAO  extends JpaRepository<Category, String>{

}
