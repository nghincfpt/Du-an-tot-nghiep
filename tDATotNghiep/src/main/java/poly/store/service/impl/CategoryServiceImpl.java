package poly.store.service.impl;

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

import poly.store.dao.CategoryDAO;
import poly.store.entity.Category;
import poly.store.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {
	

	
	 @Autowired
	 private CategoryDAO dao;

	@Override
	public <S extends Category> S save(S entity) {
		return dao.save(entity);
	}

	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return dao.findOne(example);
	}

	@Override
	public List<Category> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public List<Category> findAllById(Iterable<String> ids) {
		return dao.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return dao.saveAll(entities);
	}

	@Override
	public void flush() {
		dao.flush();
	}

	@Override
	public boolean existsById(String id) {
		return dao.existsById(id);
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return dao.saveAndFlush(entity);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return dao.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return dao.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Category> entities) {
		dao.deleteInBatch(entities);
	}

	@Override
	public <S extends Category> long count(Example<S> example) {
		return dao.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Category> entities) {
		dao.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return dao.exists(example);
	}

	@Override
	public void deleteById(String id) {
		dao.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		dao.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Category entity) {
		dao.delete(entity);
	}

	@Override
	public <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return dao.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		dao.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		dao.deleteAllInBatch();
	}

	@Override
	public Category getOne(String id) {
		return dao.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		dao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public Category getById(String id) {
		return dao.getById(id);
	}

	@Override
	public Category getReferenceById(String id) {
		return dao.getReferenceById(id);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example) {
		return dao.findAll(example);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return dao.findAll(example, sort);
	}
	 


}
