package com.lab34.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab34.entities.OrderDetail;

public interface IOrderDetail extends JpaRepository<OrderDetail, Integer>{
	List<OrderDetail> findByStatusEquals(int status);
}
