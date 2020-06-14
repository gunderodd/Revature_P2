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

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "Product")
public class Product {
	
	@OneToMany(mappedBy = "product")
	private List<OrderProduct> orderProductList;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
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
	
	public Product(int id, String name, String description, double price, int stock, String url) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.url = url;
	}

	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}
	
	public void addOrderProduct(OrderProduct op) {
		this.addOrderProduct(op, true);
	}
	
	public void addOrderProduct(OrderProduct op, boolean reciprocate) {
		if (op != null) {
			if (this.orderProductList.contains(op)) {
				this.orderProductList.set(orderProductList.indexOf(op), op);
			} else {
				this.orderProductList.add(op);
			}
			if (reciprocate)
				op.setProduct(this, false);
		}
	}
	
	public void removeOrderProduct(OrderProduct op) {
		this.orderProductList.remove(op);
		op.setProduct(null);
	}

	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

	@Override
	public String toString() {
		return "Product [orderProductList=" + orderProductList + ", id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", stock=" + stock + ", url=" + url + "]";
	}
	
	public boolean equals(Product other) {
		if (other.getId() == this.id)
			return true;
		return false;
	}
}
