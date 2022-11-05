package poly.store.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import poly.store.entity.Product;





@Repository
public interface ProductDao  extends JpaRepository<Product,Integer>{


}
