package com.lab34.service.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;


import com.lab34.entities.CartItem;
import com.lab34.entities.Hair;
import com.lab34.entities.ShoppingSession;
import com.lab34.service.ICartService;


@Service
public class CartService {
	
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ICartService cartService;


	

	public List<CartItem> findByShoppingSession(ShoppingSession shoppingSession) {
		return cartService.findByShoppingSession(shoppingSession);
	}

	public CartItem findByHair(Hair hair) {
		return cartService.findByHair(hair);
	}
	
	public <S extends CartItem> S save(S entity) {
		return cartService.save(entity);
	}
	public <S extends CartItem> Optional<S> findOne(Example<S> example) {
		return cartService.findOne(example);
	}
	public List<CartItem> findAll() {
		return cartService.findAll();
	}
	public Page<CartItem> findAll(Pageable pageable) {
		return cartService.findAll(pageable);
	}
	public List<CartItem> findAll(Sort sort) {
		return cartService.findAll(sort);
	}
	public List<CartItem> findAllById(Iterable<Integer> ids) {
		return cartService.findAllById(ids);
	}
	public Optional<CartItem> findById(Integer id) {
		return cartService.findById(id);
	}
	public <S extends CartItem> List<S> saveAll(Iterable<S> entities) {
		return cartService.saveAll(entities);
	}
	public void flush() {
		cartService.flush();
	}
	public boolean existsById(Integer id) {
		return cartService.existsById(id);
	}
	public <S extends CartItem> S saveAndFlush(S entity) {
		return cartService.saveAndFlush(entity);
	}
	public <S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities) {
		return cartService.saveAllAndFlush(entities);
	}
	public <S extends CartItem> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cartService.findAll(example, pageable);
	}
	public void deleteInBatch(Iterable<CartItem> entities) {
		cartService.deleteInBatch(entities);
	}
	public <S extends CartItem> long count(Example<S> example) {
		return cartService.count(example);
	}
	public void deleteAllInBatch(Iterable<CartItem> entities) {
		cartService.deleteAllInBatch(entities);
	}
	public long count() {
		return cartService.count();
	}
	public <S extends CartItem> boolean exists(Example<S> example) {
		return cartService.exists(example);
	}
	public void deleteById(Integer id) {
		cartService.deleteById(id);
	}
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		cartService.deleteAllByIdInBatch(ids);
	}
	public void delete(CartItem entity) {
		cartService.delete(entity);
	}
	public <S extends CartItem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return cartService.findBy(example, queryFunction);
	}
	public void deleteAllById(Iterable<? extends Integer> ids) {
		cartService.deleteAllById(ids);
	}
	public void deleteAllInBatch() {
		cartService.deleteAllInBatch();
	}
	public CartItem getOne(Integer id) {
		return cartService.getOne(id);
	}
	public void deleteAll(Iterable<? extends CartItem> entities) {
		cartService.deleteAll(entities);
	}
	public void deleteAll() {
		cartService.deleteAll();
	}
	public CartItem getById(Integer id) {
		return cartService.getById(id);
	}
	public CartItem getReferenceById(Integer id) {
		return cartService.getReferenceById(id);
	}
	public <S extends CartItem> List<S> findAll(Example<S> example) {
		return cartService.findAll(example);
	}
	public <S extends CartItem> List<S> findAll(Example<S> example, Sort sort) {
		return cartService.findAll(example, sort);
	}
	 
	
	
	
//	@Override
//	public Cart getCart() {
//		Cart cart = (Cart) request.getSession()
//				.getAttribute(ATT_CART_NAME);
//		if (cart == null) {
//			cart = new Cart();
//			cart.setCartDetails(new HashMap<Integer, Integer>());
//			request.getSession()
//				.setAttribute(ATT_CART_NAME, cart);
//		}
//		return cart;	
//	}
//
//	@Override
//	public void addToCart(int hairId, int quantity) {
//		Cart cart = getCart();
//		
//		int currentQuantity =0;
//		if (cart.getCartDetails().containsKey(hairId)) {
//			// lay so luong hien co ra
//			currentQuantity = cart.getCartDetails().get(hairId);
//		}
//		// cong don
//		int updatedQuantity = currentQuantity + quantity;
//		cart.getCartDetails().put(hairId, updatedQuantity);
//		
//	}
//
//	@Override
//	public void changeHairQuantity(int hairId, int quantity) {
//		Cart cart = getCart();
//		cart.getCartDetails().put(hairId, quantity);
//	}
//
//	@Override
//	public void removeHair(int hairId) {
//		Cart cart = getCart();
//		cart.getCartDetails().remove(hairId);
//		
//	}
//
//	@Override
//	public void removeAllHair() {
//		request.getSession().removeAttribute(ATT_CART_NAME);
//		
//	}
	
	
	
	
	
}
