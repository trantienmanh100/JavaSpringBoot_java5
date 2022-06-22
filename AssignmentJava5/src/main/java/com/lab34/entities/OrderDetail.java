package com.lab34.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_details")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private BigDecimal total;
	private int status;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;
	

	//bi-directional many-to-one association to PaymentDetail
	@ManyToOne
	@JoinColumn(name="payment_id")
	private PaymentDetail paymentDetail;

	//bi-directional many-to-one association to OrderItem
	@OneToMany(mappedBy="orderDetail")
	private List<OrderItem> orderItems;

	

}