package com.lab34.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab34.entities.OrderDetail;
import com.lab34.entities.OrderItem;

public interface IOrderItem extends JpaRepository<OrderItem, Integer> {
   List<OrderItem> findByOrderDetail(OrderDetail details);
}
