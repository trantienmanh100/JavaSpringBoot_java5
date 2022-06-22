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

import com.lab34.entities.User;
import com.lab34.repository.IUserrepository;

@Service
public class UserService {
	@Autowired
	IUserrepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	public <S extends User> Optional<S> findOne(Example<S> example) {
		return userRepository.findOne(example);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public List<User> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	public List<User> findAllById(Iterable<Integer> ids) {
		return userRepository.findAllById(ids);
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}

	public void flush() {
		userRepository.flush();
	}

	public boolean existsById(Integer id) {
		return userRepository.existsById(id);
	}

	public <S extends User> S saveAndFlush(S entity) {
		return userRepository.saveAndFlush(entity);
	}

	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
		return userRepository.saveAllAndFlush(entities);
	}

	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}

	public void deleteInBatch(Iterable<User> entities) {
		userRepository.deleteInBatch(entities);
	}

	public <S extends User> long count(Example<S> example) {
		return userRepository.count(example);
	}

	public void deleteAllInBatch(Iterable<User> entities) {
		userRepository.deleteAllInBatch(entities);
	}

	public long count() {
		return userRepository.count();
	}

	public <S extends User> boolean exists(Example<S> example) {
		return userRepository.exists(example);
	}

	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		userRepository.deleteAllByIdInBatch(ids);
	}

	public void delete(User entity) {
		userRepository.delete(entity);
	}

	public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return userRepository.findBy(example, queryFunction);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		userRepository.deleteAllById(ids);
	}

	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	public User getOne(Integer id) {
		return userRepository.getOne(id);
	}

	public void deleteAll(Iterable<? extends User> entities) {
		userRepository.deleteAll(entities);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

	public User getById(Integer id) {
		return userRepository.getById(id);
	}

	public User getReferenceById(Integer id) {
		return userRepository.getReferenceById(id);
	}

	public <S extends User> List<S> findAll(Example<S> example) {
		return userRepository.findAll(example);
	}

	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}
	
	
}
