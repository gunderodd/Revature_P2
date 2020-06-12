package com.store.app.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// accepts order products that look like this:
	/*
	 * {
	 * 	"order" : { "orderId" : 1 }
	 *  "product" : { "productId" : 1 }
	 *  "quantity" : 1
	 */
	// we only create OrderProducts for carts, so we don't have to update the Product quantity yet.
	@PostMapping("/orderproduct")
	public OrderProduct createOrderProduct(HttpSession session, @RequestBody OrderProduct op) {
		Product product = ps.getProductById(op.getProduct().getProductId());
		if (op.getQuantity() > product.getStock()) {
			// TODO LOG
			throw new BusinessException("You cannot buy more than what's currently in stock.");
		}
		User user = (User) session.getAttribute("user");
		Order cart = os.getCartByUser(user);
		boolean newCart = false;
		if (cart == null) {
			cart = new Order();
			cart.setUser(user);
			cart.setStatus("cart");
			cart.setCreatedAt(Date.from(Instant.now()));
			newCart = true; 
		}
		op.setProduct(product);
		op.setOrder(cart);
		List<OrderProduct> cartProducts = cart.getOrderProductList();
		for (OrderProduct current : cartProducts) {
			if (current.getProduct().getProductId() == op.getProduct().getProductId()) {
				current.setQuantity(current.getQuantity() + op.getQuantity());
				ops.updateOrderProduct(current);
				return current;
			}
		}
		if (newCart) {
			os.createOrder(cart);
		}
		ops.createOrderProduct(op);
		return op;
	}
}
