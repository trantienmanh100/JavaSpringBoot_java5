package com.lab34.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab34.entities.Cart;
import com.lab34.entities.CartItem;
import com.lab34.entities.Hair;
import com.lab34.entities.ShoppingSession;

public interface ICartService extends JpaRepository<CartItem, Integer> {
	
	CartItem findByHair(Hair hair );
	List<CartItem> findByShoppingSession(ShoppingSession shoppingSession );
}
