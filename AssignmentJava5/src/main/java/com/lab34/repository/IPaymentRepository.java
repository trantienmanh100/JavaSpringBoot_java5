package com.lab34.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab34.entities.PaymentDetail;

public interface IPaymentRepository extends JpaRepository<PaymentDetail, Integer> {

}
