package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.store.entity.Account;
import poly.store.entity.OrderDetail;

@Repository
public interface OrderDetailDAO  extends JpaRepository<OrderDetail, Long>{

}
