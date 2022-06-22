package com.lab34.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.lab34.entities.Hair;
import com.lab34.entities.HairType;
import com.lab34.repository.IHairRepository;

@Service
public class HairService {
	@Autowired
	private IHairRepository hairRep;
	
	
	public Page<Hair> listAll(int pageNumber, int size){
		Pageable pageable =PageRequest.of(pageNumber,size);
		return hairRep.findAll(pageable);
	}


	public Page<Hair> findByNameLike(String name,int pageNumber ) {
		Pageable pageable =PageRequest.of(pageNumber,8);
		return hairRep.findByNameLike(name,pageable);
	}

	public Page<Hair> findByType(HairType type ,int pageNumber,int size) {
		Pageable pageable =PageRequest.of(pageNumber,size);
		return hairRep.findByType(type,pageable);
	}

	public <S extends Hair> S save(S entity) {
		return hairRep.save(entity);
	}


	public <S extends Hair> Optional<S> findOne(Example<S> example) {
		return hairRep.findOne(example);
	}


	public List<Hair> findAll() {
		return hairRep.findAll();
	}


	public Page<Hair> findAll(Pageable pageable) {
		return hairRep.findAll(pageable);
	}


	public List<Hair> findAll(Sort sort) {
		return hairRep.findAll(sort);
	}


	public List<Hair> findAllById(Iterable<Integer> ids) {
		return hairRep.findAllById(ids);
	}


	public Optional<Hair> findById(Integer id) {
		return hairRep.findById(id);
	}


	public <S extends Hair> List<S> saveAll(Iterable<S> entities) {
		return hairRep.saveAll(entities);
	}


	public void flush() {
		hairRep.flush();
	}


	public boolean existsById(Integer id) {
		return hairRep.existsById(id);
	}


	public <S extends Hair> S saveAndFlush(S entity) {
		return hairRep.saveAndFlush(entity);
	}


	public <S extends Hair> List<S> saveAllAndFlush(Iterable<S> entities) {
		return hairRep.saveAllAndFlush(entities);
	}


	public <S extends Hair> Page<S> findAll(Example<S> example, Pageable pageable) {
		return hairRep.findAll(example, pageable);
	}


	public void deleteInBatch(Iterable<Hair> entities) {
		hairRep.deleteInBatch(entities);
	}
	
	


	public <S extends Hair> long count(Example<S> example) {
		return hairRep.count(example);
	}


	public void deleteAllIdInBatch(List<Integer> ids) {
		hairRep.deleteAllByIdInBatch(ids);
	}


	public long count() {
		return hairRep.count();
	}


	public <S extends Hair> boolean exists(Example<S> example) {
		return hairRep.exists(example);
	}


	public void deleteById(Integer id) {
		hairRep.deleteById(id);
	}


	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		hairRep.deleteAllByIdInBatch(ids);
	}


	public void delete(Hair entity) {
		hairRep.delete(entity);
	}


	public <S extends Hair, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return hairRep.findBy(example, queryFunction);
	}


	public void deleteAllById(Iterable<? extends Integer> ids) {
		hairRep.deleteAllById(ids);
	}


	public void deleteAllInBatch() {
		hairRep.deleteAllInBatch();
	}


	public Hair getOne(Integer id) {
		return hairRep.getOne(id);
	}


	public void deleteAll(Iterable<? extends Hair> entities) {
		hairRep.deleteAll(entities);
	}


	public void deleteAll() {
		hairRep.deleteAll();
	}


	public Hair getById(Integer id) {
		return hairRep.getById(id);
	}


	public Hair getReferenceById(Integer id) {
		return hairRep.getReferenceById(id);
	}


	public <S extends Hair> List<S> findAll(Example<S> example) {
		return hairRep.findAll(example);
	}


	public <S extends Hair> List<S> findAll(Example<S> example, Sort sort) {
		return hairRep.findAll(example, sort);
	}

	

	
	
}
