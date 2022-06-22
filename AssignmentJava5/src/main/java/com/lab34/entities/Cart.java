package com.lab34.entities;

import java.util.Map;

public class Cart {
	private Map<Integer, Integer> cartDetails;
	
	public Map<Integer, Integer> getCartDetails(){
		return cartDetails;
	}
	
	public void setCartDetails(Map<Integer, Integer> cartDetails) {
		this.cartDetails =cartDetails;
	}
}
