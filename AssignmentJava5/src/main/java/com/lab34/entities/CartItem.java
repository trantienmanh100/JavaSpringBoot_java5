package com.lab34.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	private  int quantity;
	
	//bi-directional many-to-one association to Hair
	@ManyToOne
	private Hair hair;

	//bi-directional many-to-one association to ShoppingSession
	@ManyToOne
	@JoinColumn(name="session_id")
	private ShoppingSession shoppingSession;
	
}
