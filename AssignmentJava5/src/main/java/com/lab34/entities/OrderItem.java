package com.lab34.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the order_items database table.
 * 
 */
@Entity
@Table(name="order_items")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_at")
	private Date createAt;
	
	private int quantity;

	//bi-directional many-to-one association to OrderDetail
	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderDetail orderDetail;

	//bi-directional many-to-one association to Hair
	@ManyToOne
	private Hair hair;

	public OrderItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public OrderDetail getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Hair getHair() {
		return this.hair;
	}

	public void setHair(Hair hair) {
		this.hair = hair;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}