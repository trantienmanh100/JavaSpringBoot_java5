package com.lab34.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the payment_details database table.
 * 
 */
@Entity
@Table(name="payment_details")
@NamedQuery(name="PaymentDetail.findAll", query="SELECT p FROM PaymentDetail p")
public class PaymentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int amount;

	@Temporal(TemporalType.DATE)
	@Column(name="create_at")
	private Date createAt;

	private int status;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="paymentDetail")
	private List<OrderDetail> orderDetails;

	public PaymentDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setPaymentDetail(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setPaymentDetail(null);

		return orderDetail;
	}

}