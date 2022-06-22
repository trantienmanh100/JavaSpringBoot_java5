package com.lab34.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String fullName;
	private String address;
	private String telephone;
	private Date createAt;
	private int role;
	
	
	
	@OneToMany(mappedBy="user")
	private List<ShoppingSession> shoppingSessions;
	
	@OneToMany(mappedBy="user")
	private List<OrderDetail> orderDetails;

	
	
}
