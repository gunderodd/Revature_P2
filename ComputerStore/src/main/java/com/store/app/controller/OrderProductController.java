package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.store.app.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class OrderProductController {
	@Autowired
	OrderService os;
	@Autowired
	ProductService ps;
	@Autowired
	OrderProductService ops;
	@Autowired
	UserService us;
	
	// This is only for creating new orderProducts
	@PostMapping("/orderproduct")
	public OrderProduct createOrderProduct(@RequestBody String[] args) {
		Product product;
		int quantity;
		User real;
		try {
			product = ps.getProductById(Integer.parseInt(args[0]));
			quantity = Integer.parseInt(args[1]);
			real = us.getUserByUsername(args[2]);
			if (real == null || !(real.getPassword().equals(args[3]))) {
				// TODO LOG
				throw new BusinessException("You cannot add to cart without proper authentification");
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			// TODO LOG
			throw new BusinessException("Incorrect information passed");
		}
		if (quantity <= 0) {
			// TODO LOG
			throw new BusinessException("You're trying to add a quantity of 0 or less to your shopping cart, which is not allowed.");
		}
		if (quantity > product.getStock()) {
			// TODO LOG
			throw new BusinessException("You are putting too much in your cart. Not enough stock of item: " + product.getName());
		}
		Order cart = os.getCartByUser(real);
		OrderProduct op = new OrderProduct();
		List<OrderProduct> cartProducts = cart.getOrderProductList();
		for (OrderProduct current : cartProducts) {
			if (current.getProduct().getId() == product.getId()) {
				current.setQuantity(current.getQuantity() + quantity);
				ops.updateOrderProduct(current);
				product.setStock(product.getStock() - quantity);
				ps.updateProduct(product);
				return current;
			}
		}
		op.setOrder(cart);
		op.setProduct(product);
		op.setQuantity(quantity);
		product.setStock(product.getStock() - quantity);
		ps.updateProduct(product);
		return ops.createOrderProduct(op);
	}
	
	// this is only for updating existing orderProducts
	@PutMapping("/orderproduct")
	public OrderProduct updateOrderProduct(@RequestBody String[] args) { // TODO FIX THIS, GET RID OF SESSION
		Product product;
		int quantity;
		User real;
		try {
			product = ps.getProductById(Integer.parseInt(args[0]));
			quantity = Integer.parseInt(args[1]);
			real = us.getUserByUsername(args[2]);
			if (real == null || !(real.getPassword().equals(args[3]))) {
				// TODO LOG
				throw new BusinessException("You cannot add to cart without proper authentification");
			}
			if (quantity < 0) {
				throw new BusinessException("You cannot set a quantity to a negative number.");
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e ) {
			// TODO LOG
			throw new BusinessException("Incorrect information passed");
		}
		Order cart = os.getCartByUser(real);
		List<OrderProduct> cartProducts = cart.getOrderProductList();
		for (OrderProduct current : cartProducts) {
			if (current.getProduct().getId() == product.getId()) {
				int stockTotal = product.getStock() + current.getQuantity();
				if (quantity == 0) {
					cart.removeOrderProduct(current);
					product.setStock(stockTotal);
					ops.deleteOrderProduct(current);
					ps.updateProduct(product);
					return new OrderProduct();
				} else {
					if (quantity > stockTotal) {
						throw new BusinessException("You are putting too much in your cart. Not enough stock of item: " + product.getName());
					}
					current.setQuantity(quantity);
					product.setStock(stockTotal - quantity);
					ops.updateOrderProduct(current);
					ps.updateProduct(product);
					return current;
				}
			}
		}
		throw new BusinessException("OrderProduct sent does not already exist. Can't update it if it doesn't already exist!");
	}
	
	@GetMapping("/orderproducts/order/{id}")
	public List<OrderProduct> orderProductsByOrder(@PathVariable("id") int id) {
		// TODO ASPECT AND SECURITY
		Order order = os.getOrderById(id);
		return order.getOrderProductList();
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
