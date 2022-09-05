package com.deloitte.spring.boot.invesco1.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Product")
public class Product {
	@Id
	@Column(name = "product_id")
	private int product_id;
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", price=" + price + ", product_name=" + product_name + "]";
	}
	public Product(int product_id, int price, String product_name) {
		super();
		this.product_id = product_id;
		this.price = price;
		this.product_name = product_name;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Column(name="price")
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
	@Column(name = "product_name")
	private String product_name;
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
	
	
	
	

}
