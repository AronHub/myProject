package com.fjt.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 订单详细
 * @author pc
 *
 */
@Table(name="order_item")
@Entity
@SequenceGenerator(name="seq_orderItem",sequenceName="seq_orderItem")
public class OrderItem implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long ordersId;
	private Long bokId;
	private Integer bookNum;
	
	@Id
	@GeneratedValue(generator="seq_orderItem",strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="order_Id")
	public Long getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}
	@Column(name="book_Id")
	public Long getBokId() {
		return bokId;
	}
	public void setBokId(Long bokId) {
		this.bokId = bokId;
	}
	@Column(name="book_Num")
	public Integer getBookNum() {
		return bookNum;
	}
	public void setBookNum(Integer bookNum) {
		this.bookNum = bookNum;
	}
	
	
	
	

}
