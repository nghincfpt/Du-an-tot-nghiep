package poly.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.store.entity.Account;

@Repository
public interface AccountDAO  extends JpaRepository<Account, String>{
   @Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdminisstrators();


}
