package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;


import poly.store.entity.Account;
import poly.store.entity.Status;

public interface StatusService {

	
	List<Status> findAll();
	
	

}
