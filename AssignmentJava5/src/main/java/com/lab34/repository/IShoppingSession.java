package com.lab34.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab34.entities.ShoppingSession;
import com.lab34.entities.User;

public interface IShoppingSession extends JpaRepository<ShoppingSession, Integer> {
	ShoppingSession findByUser(User user);
		
	

}
