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

import poly.store.DAO.RoleDAO;
import poly.store.DAO.StatusDao;
import poly.store.entity.Role;
import poly.store.entity.Status;
import poly.store.service.RoleService;
import poly.store.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	StatusDao dao;

	@Override
	public List<Status> findAll() {

		return dao.findAll();
	}

}
