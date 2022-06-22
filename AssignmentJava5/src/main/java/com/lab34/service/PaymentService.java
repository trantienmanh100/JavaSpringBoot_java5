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

import com.lab34.entities.PaymentDetail;
import com.lab34.repository.IPaymentRepository;

@Service
public class PaymentService {
 @Autowired
 private IPaymentRepository paymentRep;

public <S extends PaymentDetail> S save(S entity) {
	return paymentRep.save(entity);
}

public <S extends PaymentDetail> Optional<S> findOne(Example<S> example) {
	return paymentRep.findOne(example);
}

public List<PaymentDetail> findAll() {
	return paymentRep.findAll();
}

public Page<PaymentDetail> findAll(Pageable pageable) {
	return paymentRep.findAll(pageable);
}

public List<PaymentDetail> findAll(Sort sort) {
	return paymentRep.findAll(sort);
}

public List<PaymentDetail> findAllById(Iterable<Integer> ids) {
	return paymentRep.findAllById(ids);
}

public Optional<PaymentDetail> findById(Integer id) {
	return paymentRep.findById(id);
}

public <S extends PaymentDetail> List<S> saveAll(Iterable<S> entities) {
	return paymentRep.saveAll(entities);
}

public void flush() {
	paymentRep.flush();
}

public boolean existsById(Integer id) {
	return paymentRep.existsById(id);
}

public <S extends PaymentDetail> S saveAndFlush(S entity) {
	return paymentRep.saveAndFlush(entity);
}

public <S extends PaymentDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
	return paymentRep.saveAllAndFlush(entities);
}

public <S extends PaymentDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
	return paymentRep.findAll(example, pageable);
}

public void deleteInBatch(Iterable<PaymentDetail> entities) {
	paymentRep.deleteInBatch(entities);
}

public <S extends PaymentDetail> long count(Example<S> example) {
	return paymentRep.count(example);
}

public void deleteAllInBatch(Iterable<PaymentDetail> entities) {
	paymentRep.deleteAllInBatch(entities);
}

public long count() {
	return paymentRep.count();
}

public <S extends PaymentDetail> boolean exists(Example<S> example) {
	return paymentRep.exists(example);
}

public void deleteById(Integer id) {
	paymentRep.deleteById(id);
}

public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	paymentRep.deleteAllByIdInBatch(ids);
}

public void delete(PaymentDetail entity) {
	paymentRep.delete(entity);
}

public <S extends PaymentDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return paymentRep.findBy(example, queryFunction);
}

public void deleteAllById(Iterable<? extends Integer> ids) {
	paymentRep.deleteAllById(ids);
}

public void deleteAllInBatch() {
	paymentRep.deleteAllInBatch();
}

public PaymentDetail getOne(Integer id) {
	return paymentRep.getOne(id);
}

public void deleteAll(Iterable<? extends PaymentDetail> entities) {
	paymentRep.deleteAll(entities);
}

public void deleteAll() {
	paymentRep.deleteAll();
}

public PaymentDetail getById(Integer id) {
	return paymentRep.getById(id);
}

public PaymentDetail getReferenceById(Integer id) {
	return paymentRep.getReferenceById(id);
}

public <S extends PaymentDetail> List<S> findAll(Example<S> example) {
	return paymentRep.findAll(example);
}

public <S extends PaymentDetail> List<S> findAll(Example<S> example, Sort sort) {
	return paymentRep.findAll(example, sort);
}
 
}
