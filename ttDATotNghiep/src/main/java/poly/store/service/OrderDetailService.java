package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.store.entity.OrderDetail;

public interface OrderDetailService {

	<S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort);

	<S extends OrderDetail> List<S> findAll(Example<S> example);

	OrderDetail getReferenceById(Long id);

	OrderDetail getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends OrderDetail> entities);

	OrderDetail getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(OrderDetail entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends OrderDetail> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<OrderDetail> entities);

	<S extends OrderDetail> long count(Example<S> example);

	void deleteInBatch(Iterable<OrderDetail> entities);

	<S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends OrderDetail> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends OrderDetail> List<S> saveAll(Iterable<S> entities);

	Optional<OrderDetail> findById(Long id);

	List<OrderDetail> findAllById(Iterable<Long> ids);

	List<OrderDetail> findAll(Sort sort);

	Page<OrderDetail> findAll(Pageable pageable);

	List<OrderDetail> findAll();

	<S extends OrderDetail> Optional<S> findOne(Example<S> example);

	<S extends OrderDetail> S save(S entity);

}
