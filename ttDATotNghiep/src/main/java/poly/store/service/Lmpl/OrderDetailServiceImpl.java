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

import poly.store.DAO.OrderDetailDAO;
import poly.store.entity.OrderDetail;
import poly.store.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	 @Autowired
	 private OrderDetailDAO dao;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return dao.save(entity);
	}

	@Override
	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
		return dao.findOne(example);
	}

	@Override
	public List<OrderDetail> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public List<OrderDetail> findAllById(Iterable<Long> ids) {
		return dao.findAllById(ids);
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
		return dao.saveAll(entities);
	}

	@Override
	public void flush() {
		dao.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return dao.existsById(id);
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return dao.saveAndFlush(entity);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return dao.saveAllAndFlush(entities);
	}

	@Override
	public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return dao.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<OrderDetail> entities) {
		dao.deleteInBatch(entities);
	}

	@Override
	public <S extends OrderDetail> long count(Example<S> example) {
		return dao.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<OrderDetail> entities) {
		dao.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public <S extends OrderDetail> boolean exists(Example<S> example) {
		return dao.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		dao.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(OrderDetail entity) {
		dao.delete(entity);
	}

	@Override
	public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return dao.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		dao.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		dao.deleteAllInBatch();
	}

	@Override
	public OrderDetail getOne(Long id) {
		return dao.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetail> entities) {
		dao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public OrderDetail getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public OrderDetail getReferenceById(Long id) {
		return dao.getReferenceById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example) {
		return dao.findAll(example);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
		return dao.findAll(example, sort);
	}
	 
}
