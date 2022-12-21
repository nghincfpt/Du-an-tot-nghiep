package poly.store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.store.entity.Account;
import poly.store.entity.Role;
import poly.store.entity.Status;

@Repository
public interface StatusDao  extends JpaRepository<Status, Integer>{

}
