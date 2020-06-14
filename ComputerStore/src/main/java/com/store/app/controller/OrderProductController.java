package com.store.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.exception.BusinessException;
import com.store.app.model.Order;
import com.store.app.model.OrderProduct;
import com.store.app.model.Product;
import com.store.app.model.User;
import com.store.app.service.OrderProductService;
import com.store.app.service.OrderService;
import com.store.app.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
public class OrderProductController {
	@Autowired
	OrderService os;
	@Autowired
	ProductService ps;
	@Autowired
	OrderProductService ops;
	
	@PostMapping("/orderproduct")
	public OrderProduct createOrderProduct(HttpSession session, @RequestBody int[] args) {
		Product product;
		int quantity;
		try {
			product = ps.getProductById(args[0]);
			quantity = args[1];
		} catch (IndexOutOfBoundsException e) {
			// TODO LOG
			throw new BusinessException("not enough arguments passed.");
		}
		if (quantity > product.getStock()) {
			// TODO LOG
			throw new BusinessException("You cannot buy more than what's currently in stock.");
		}
		User user = (User) session.getAttribute("user");
		Order cart = os.getCartByUser(user);
		System.out.println("user:" +user+ "   order:" +cart+ "   product:" +product);
		OrderProduct op = new OrderProduct(0, cart, product, quantity);
		List<OrderProduct> cartProducts = cart.getOrderProductList();
		for (OrderProduct current : cartProducts) {
			if (current.getProduct().getId() == op.getProduct().getId()) {
				current.setQuantity(current.getQuantity() + op.getQuantity());
				ops.updateOrderProduct(current);
				return current;
			}
		}
		ops.createOrderProduct(op);
		return op;
	}
	
	// should this get an array of args or just stick with op parameter?
	@PutMapping("/orderproduct")
	public OrderProduct updateOrderProduct(HttpSession session, @RequestBody OrderProduct op) {
		User sessionUser = (User) session.getAttribute("user");
		User opUser = op.getOrder().getUser();
		if (sessionUser.getId() == opUser.getId()) {
			ops.updateOrderProduct(op);
			return op;
		}
		throw new BusinessException("Current user " + sessionUser.getUsername() + " does not match the user associated with the orderProduct.");
	}
	
//	@DeleteMapping("/orderproduct")
//	public void deleteOrderProduct(HttpSession session, OrderProduct op) {
//		// TODO
//		// aspect for logged in
//		// aspect for admin or if the user matches the associated orderProduct
//			// this is a cross-cutting concern. might want to consider making an aspect for this and applying it to the update method.
//		
//	}
}
