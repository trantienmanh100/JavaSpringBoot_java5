package com.lab34.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ShoppingSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal total;
	private Date createDate ;
	
	
	//bi-directional many-to-one association to CartItem
		@OneToMany(mappedBy="shoppingSession")
		private List<CartItem> cartItems;

		//bi-directional many-to-one association to User
		@ManyToOne
		private User user;
	
	
	
}
