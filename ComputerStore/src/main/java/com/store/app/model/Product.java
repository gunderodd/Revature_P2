package com.store.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="productId")
@Entity
@Table(name = "Product")
public class Product {
	
	@OneToMany(mappedBy = "product")
	private List<OrderProduct> order_productList;

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "url")
	private String url;

	
	// Constructors
	public Product() {
		super();
	}	
	
	public Product(int productId, String name, String description, double price, int stock, String url) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.url = url;
	}

	
	// Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public List<OrderProduct> getOrder_productList() {
		return order_productList;
	}

	public void setOrder_productList(List<OrderProduct> order_productList) {
		this.order_productList = order_productList;
	}

	@Override
	public String toString() {
		return "Product [order_productList=" + order_productList + ", productId=" + productId + ", name=" + name
				+ ", description=" + description + ", price=" + price + ", stock=" + stock + ", url=" + url + "]";
	}
	
}
