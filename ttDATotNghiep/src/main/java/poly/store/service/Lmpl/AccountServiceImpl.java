package poly.store.service.Lmpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import poly.store.DAO.AccountDAO;
import poly.store.entity.Account;
import poly.store.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
 
	@Autowired
	 AccountDAO dao;
	
	
	@Override
public Account findById(String username) {
		return dao.findById(username).get();
	}


	@Override
	public List<Account> getAdminisstrators() {	
		return dao.getAdminisstrators();
	}


	@Override
	public List<Account> findAll() {	
		return dao.findAll();
	}
	
} 
