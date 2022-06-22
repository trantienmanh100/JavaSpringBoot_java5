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
import com.lab34.repository.IOrderDetail;
import com.lab34.repository.IOrderItem;

@Service
public class OrderDetailService {
 @Autowired
 private IOrderDetail orderDetail;

public <S extends OrderDetail> S save(S entity) {
	return orderDetail.save(entity);
}

public List<OrderDetail> findByStatusEquals(int status) {
	return orderDetail.findByStatusEquals(status);
}

public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
	return orderDetail.findOne(example);
}

public List<OrderDetail> findAll() {
	return orderDetail.findAll();
}

public Page<OrderDetail> findAll(Pageable pageable) {
	return orderDetail.findAll(pageable);
}

public List<OrderDetail> findAll(Sort sort) {
	return orderDetail.findAll(sort);
}

public List<OrderDetail> findAllById(Iterable<Integer> ids) {
	return orderDetail.findAllById(ids);
}

public Optional<OrderDetail> findById(Integer id) {
	return orderDetail.findById(id);
}

public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
	return orderDetail.saveAll(entities);
}

public void flush() {
	orderDetail.flush();
}

public boolean existsById(Integer id) {
	return orderDetail.existsById(id);
}

public <S extends OrderDetail> S saveAndFlush(S entity) {
	return orderDetail.saveAndFlush(entity);
}

public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
	return orderDetail.saveAllAndFlush(entities);
}

public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
	return orderDetail.findAll(example, pageable);
}

public void deleteInBatch(Iterable<OrderDetail> entities) {
	orderDetail.deleteInBatch(entities);
}

public <S extends OrderDetail> long count(Example<S> example) {
	return orderDetail.count(example);
}

public void deleteAllInBatch(Iterable<OrderDetail> entities) {
	orderDetail.deleteAllInBatch(entities);
}

public long count() {
	return orderDetail.count();
}

public <S extends OrderDetail> boolean exists(Example<S> example) {
	return orderDetail.exists(example);
}

public void deleteById(Integer id) {
	orderDetail.deleteById(id);
}

public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	orderDetail.deleteAllByIdInBatch(ids);
}

public void delete(OrderDetail entity) {
	orderDetail.delete(entity);
}

public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return orderDetail.findBy(example, queryFunction);
}

public void deleteAllById(Iterable<? extends Integer> ids) {
	orderDetail.deleteAllById(ids);
}

public void deleteAllInBatch() {
	orderDetail.deleteAllInBatch();
}

public OrderDetail getOne(Integer id) {
	return orderDetail.getOne(id);
}

public void deleteAll(Iterable<? extends OrderDetail> entities) {
	orderDetail.deleteAll(entities);
}

public void deleteAll() {
	orderDetail.deleteAll();
}

public OrderDetail getById(Integer id) {
	return orderDetail.getById(id);
}

public OrderDetail getReferenceById(Integer id) {
	return orderDetail.getReferenceById(id);
}

public <S extends OrderDetail> List<S> findAll(Example<S> example) {
	return orderDetail.findAll(example);
}

public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
	return orderDetail.findAll(example, sort);
}
 
}
