package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.store.entity.Category;





public interface CategoryService {

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	<S extends Category> List<S> findAll(Example<S> example);

	Category getReferenceById(String id);

	Category getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends Category> entities);

	Category getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	<S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Category entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	<S extends Category> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Category> entities);

	<S extends Category> long count(Example<S> example);

	void deleteInBatch(Iterable<Category> entities);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Category> S saveAndFlush(S entity);

	boolean existsById(String id);

	void flush();

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	Optional<Category> findById(String id);

	List<Category> findAllById(Iterable<String> ids);

	List<Category> findAll(Sort sort);

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll();

	<S extends Category> Optional<S> findOne(Example<S> example);

	<S extends Category> S save(S entity);

}
