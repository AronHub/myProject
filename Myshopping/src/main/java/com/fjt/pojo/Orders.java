package com.fjt.pojo;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 订单
 * @author pc
 *
 */
@Entity
@Table
@SequenceGenerator(name="seq_orders",sequenceName="seq_orders")
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long userId;
	private Double totalPrice;
	private Date orderDate;
	@Id
	@GeneratedValue(generator="seq_orders",strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="user_Id")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(name="tatal_Price")
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Column(name="order_Date")
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	

}
