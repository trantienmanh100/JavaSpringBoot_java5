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

import com.lab34.entities.OrderDetail;
import com.lab34.entities.OrderItem;
import com.lab34.repository.IOrderItem;

@Service
public class OrderItemService {
	@Autowired
	private IOrderItem orderItemRep;

	public List<OrderItem> findByOrderDetail(OrderDetail details) {
		return orderItemRep.findByOrderDetail(details);
	}

	public <S extends OrderItem> S save(S entity) {
		return orderItemRep.save(entity);
	}

	public <S extends OrderItem> Optional<S> findOne(Example<S> example) {
		return orderItemRep.findOne(example);
	}

	public List<OrderItem> findAll() {
		return orderItemRep.findAll();
	}

	public Page<OrderItem> findAll(Pageable pageable) {
		return orderItemRep.findAll(pageable);
	}

	public List<OrderItem> findAll(Sort sort) {
		return orderItemRep.findAll(sort);
	}

	public List<OrderItem> findAllById(Iterable<Integer> ids) {
		return orderItemRep.findAllById(ids);
	}

	public Optional<OrderItem> findById(Integer id) {
		return orderItemRep.findById(id);
	}

	public <S extends OrderItem> List<S> saveAll(Iterable<S> entities) {
		return orderItemRep.saveAll(entities);
	}

	public void flush() {
		orderItemRep.flush();
	}

	public boolean existsById(Integer id) {
		return orderItemRep.existsById(id);
	}

	public <S extends OrderItem> S saveAndFlush(S entity) {
		return orderItemRep.saveAndFlush(entity);
	}

	public <S extends OrderItem> List<S> saveAllAndFlush(Iterable<S> entities) {
		return orderItemRep.saveAllAndFlush(entities);
	}

	public <S extends OrderItem> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderItemRep.findAll(example, pageable);
	}

	public void deleteInBatch(Iterable<OrderItem> entities) {
		orderItemRep.deleteInBatch(entities);
	}

	public <S extends OrderItem> long count(Example<S> example) {
		return orderItemRep.count(example);
	}

	public void deleteAllInBatch(Iterable<OrderItem> entities) {
		orderItemRep.deleteAllInBatch(entities);
	}

	public long count() {
		return orderItemRep.count();
	}

	public <S extends OrderItem> boolean exists(Example<S> example) {
		return orderItemRep.exists(example);
	}

	public void deleteById(Integer id) {
		orderItemRep.deleteById(id);
	}

	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		orderItemRep.deleteAllByIdInBatch(ids);
	}

	public void delete(OrderItem entity) {
		orderItemRep.delete(entity);
	}

	public <S extends OrderItem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderItemRep.findBy(example, queryFunction);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		orderItemRep.deleteAllById(ids);
	}

	public void deleteAllInBatch() {
		orderItemRep.deleteAllInBatch();
	}

	public OrderItem getOne(Integer id) {
		return orderItemRep.getOne(id);
	}

	public void deleteAll(Iterable<? extends OrderItem> entities) {
		orderItemRep.deleteAll(entities);
	}

	public void deleteAll() {
		orderItemRep.deleteAll();
	}

	public OrderItem getById(Integer id) {
		return orderItemRep.getById(id);
	}

	public OrderItem getReferenceById(Integer id) {
		return orderItemRep.getReferenceById(id);
	}

	public <S extends OrderItem> List<S> findAll(Example<S> example) {
		return orderItemRep.findAll(example);
	}

	public <S extends OrderItem> List<S> findAll(Example<S> example, Sort sort) {
		return orderItemRep.findAll(example, sort);
	}
	
}
