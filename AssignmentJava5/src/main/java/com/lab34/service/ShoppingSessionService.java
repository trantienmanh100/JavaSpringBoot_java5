package com.lab34.service;

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

import com.lab34.entities.ShoppingSession;
import com.lab34.entities.User;
import com.lab34.repository.IShoppingSession;

@Service
public class ShoppingSessionService {
  @Autowired
  private IShoppingSession shoppingRepository;



public ShoppingSession findByUser(User user) {
	return shoppingRepository.findByUser(user);
}

public <S extends ShoppingSession> S save(S entity) {
	return shoppingRepository.save(entity);
}

public <S extends ShoppingSession> Optional<S> findOne(Example<S> example) {
	return shoppingRepository.findOne(example);
}

public List<ShoppingSession> findAll() {
	return shoppingRepository.findAll();
}

public Page<ShoppingSession> findAll(Pageable pageable) {
	return shoppingRepository.findAll(pageable);
}

public List<ShoppingSession> findAll(Sort sort) {
	return shoppingRepository.findAll(sort);
}

public List<ShoppingSession> findAllById(Iterable<Integer> ids) {
	return shoppingRepository.findAllById(ids);
}

public Optional<ShoppingSession> findById(Integer id) {
	return shoppingRepository.findById(id);
}

public <S extends ShoppingSession> List<S> saveAll(Iterable<S> entities) {
	return shoppingRepository.saveAll(entities);
}

public void flush() {
	shoppingRepository.flush();
}

public boolean existsById(Integer id) {
	return shoppingRepository.existsById(id);
}

public <S extends ShoppingSession> S saveAndFlush(S entity) {
	return shoppingRepository.saveAndFlush(entity);
}

public <S extends ShoppingSession> List<S> saveAllAndFlush(Iterable<S> entities) {
	return shoppingRepository.saveAllAndFlush(entities);
}

public <S extends ShoppingSession> Page<S> findAll(Example<S> example, Pageable pageable) {
	return shoppingRepository.findAll(example, pageable);
}

public void deleteInBatch(Iterable<ShoppingSession> entities) {
	shoppingRepository.deleteInBatch(entities);
}

public <S extends ShoppingSession> long count(Example<S> example) {
	return shoppingRepository.count(example);
}

public void deleteAllInBatch(Iterable<ShoppingSession> entities) {
	shoppingRepository.deleteAllInBatch(entities);
}

public long count() {
	return shoppingRepository.count();
}

public <S extends ShoppingSession> boolean exists(Example<S> example) {
	return shoppingRepository.exists(example);
}

public void deleteById(Integer id) {
	shoppingRepository.deleteById(id);
}

public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	shoppingRepository.deleteAllByIdInBatch(ids);
}

public void delete(ShoppingSession entity) {
	shoppingRepository.delete(entity);
}

public <S extends ShoppingSession, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return shoppingRepository.findBy(example, queryFunction);
}

public void deleteAllById(Iterable<? extends Integer> ids) {
	shoppingRepository.deleteAllById(ids);
}

public void deleteAllInBatch() {
	shoppingRepository.deleteAllInBatch();
}

public ShoppingSession getOne(Integer id) {
	return shoppingRepository.getOne(id);
}

public void deleteAll(Iterable<? extends ShoppingSession> entities) {
	shoppingRepository.deleteAll(entities);
}

public void deleteAll() {
	shoppingRepository.deleteAll();
}

public ShoppingSession getById(Integer id) {
	return shoppingRepository.getById(id);
}

public ShoppingSession getReferenceById(Integer id) {
	return shoppingRepository.getReferenceById(id);
}

public <S extends ShoppingSession> List<S> findAll(Example<S> example) {
	return shoppingRepository.findAll(example);
}

public <S extends ShoppingSession> List<S> findAll(Example<S> example, Sort sort) {
	return shoppingRepository.findAll(example, sort);
}
  
}
