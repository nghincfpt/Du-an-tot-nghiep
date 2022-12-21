package poly.store.service.Lmpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import poly.store.DAO.AccountDAO;
import poly.store.DAO.AuthorityDAO;
import poly.store.entity.Account;
import poly.store.entity.Authority;
import poly.store.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	 AuthorityDAO dao;
	
	@Autowired
	AccountDAO acdao;
	@Override
	
	
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return dao.save(auth);
	}

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts=acdao.getAdminisstrators();
		return dao.authoritiesOf(accounts);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}
 
	
	
}
