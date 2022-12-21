package poly.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.store.entity.Account;
import poly.store.entity.Order;
import poly.store.model.OrderModel;

//@Repository
public interface OrderDAO  extends JpaRepository<Order, Long>{

	//@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByIdUsername(String username);
	
	@Query("SELECT o FROM Order o WHERE o.account.username=username")
	List<Order> findAllUsername(String username);
	
	@Query(value = "SELECT * FROM Products WHERE Name LIKE ?1", 
			nativeQuery = true)
		List<Order> listAll(String name);
	
	@Query("SELECT o FROM Order o WHERE o.id = ?1")
	List<Order> getOrderByName(Long id);
	


}
