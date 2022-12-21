package poly.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.store.entity.Account;
import poly.store.entity.Authority;

//@Repository
public interface AuthorityDAO  extends JpaRepository<Authority, Integer>{
  @Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

}
