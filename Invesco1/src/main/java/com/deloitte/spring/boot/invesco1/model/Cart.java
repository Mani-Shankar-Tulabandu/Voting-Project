package com.deloitte.spring.boot.invesco1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	@Column(name="cart_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_no;
	
	@Column(name="quantity")
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name="product_name")
	private String product_name;
	
	@Column(name="price")
	private int price;
	

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name2) {
		this.product_name = product_name2;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ",  product_name=" + product_name + ", price="
				+ price +", quantity =  "+ quantity+ "]";
	}

	public Cart() {
		super();
	}

	public Cart(int cart_no, String product_name, int price, int product_id,int quantity) {
		super();
		this.cart_no = cart_no;		
		this.product_name = product_name;
		this.price = price;
		this.quantity=quantity;
		
	}

	
	
	
}
