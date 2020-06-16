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
	
	@PostMapping("/orderproduct")
	public OrderProduct createOrderProduct(@RequestBody String[] args) {
		Product product = ps.getProductById(Integer.parseInt(args[0]));
		int quantity = Integer.parseInt(args[1]);
		User real = us.getUserByUsername(args[2]);
		if (quantity == 0) {
			throw new BusinessException("You're trying to add a quantity of 0 or less to your shopping cart, which is not allowed. User: " + real.getUsername());
		}
		if (quantity > product.getStock()) {
			throw new BusinessException("You are putting too much in your cart. Not enough stock of item: " + product.getName() + ", user: " + real.getUsername());
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
	
	@PutMapping("/orderproduct")
	public OrderProduct updateOrderProduct(@RequestBody String[] args) {
		Product product = ps.getProductById(Integer.parseInt(args[0]));
		int quantity = Integer.parseInt(args[1]);
		User real = us.getUserByUsername(args[2]);
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
						throw new BusinessException("You are putting too much in your cart. Not enough stock of item: " + product.getName() + ", user: " + real.getUsername());
					}
					current.setQuantity(quantity);
					product.setStock(stockTotal - quantity);
					ops.updateOrderProduct(current);
					ps.updateProduct(product);
					return current;
				}
			}
		}
		throw new BusinessException("OrderProduct sent does not already exist. Can't update it if it doesn't already exist! user: " + real.getUsername());
	}
	
	@GetMapping("/orderproducts/order/{id}")
	public List<OrderProduct> orderProductsByOrder(@PathVariable("id") int id) {
		Order order = os.getOrderById(id);
		return order.getOrderProductList();
	}
}
