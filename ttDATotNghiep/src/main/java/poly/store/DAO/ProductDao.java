package poly.store.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import poly.store.entity.Product;

//@Repository
public interface ProductDao  extends JpaRepository<Product,Integer>{

//	List<Product> findByCategoryId(String cid);
    
//	List<Product> findByNameContaining(String name);
//
//	Page<Product> findByNameContaining(String name, Pageable pageable);
//	Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
//	
	 @Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String cid);

}
