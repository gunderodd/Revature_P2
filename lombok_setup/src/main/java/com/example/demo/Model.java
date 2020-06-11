package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Order\"")
public class Model {

//		@OneToMany(mappedBy = "order")
//		private List<Order_Product> order_productList;
		
		@Id
		@Column(name = "order_id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		// user_id
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id")
		private User user;
		
		@Column(name = "status")
		private String status;
		
		// Make this datetime object
		@Column(name = "created_at")
		private String created_at;

	}

