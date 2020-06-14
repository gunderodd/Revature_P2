package com.store.app.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.model.Order;
import com.store.app.model.OrderProduct;
import com.store.app.model.Product;
import com.store.app.model.User;
import com.store.app.service.OrderProductService;
import com.store.app.service.OrderService;
import com.store.app.service.ProductService;
import com.store.app.service.UserService;

@CrossOrigin
@RestController
public class ProductGenerator {
	
	// Access Service Bean
	@Autowired
	private ProductService ps;
	@Autowired
	private UserService us;
	@Autowired
	private OrderService os;
	@Autowired
	private OrderProductService ops;
	
	// Just run a post on this endpoint to refill the db with some items
	@PostMapping("/generate")
	public void generateProducts() {
		// Products
		Product p1 = new Product(0, "Acme Monitor", "Lorem ipsum dolor sit amet, cu has nisl tempor invenire, nobis.", 200.00, 3, "https://tinyurl.com/y929e58h");
		Product p2 = new Product(0, "TopMark Monitor", "Paulo simul imperdiet duo eu. Nemore docendi in vim, nam meliore electram te, eu expetenda intellegat mel. Ad viris tation aperiri usu, te insolens argumentum mel. Harum qualisque eam at.", 250.00, 10, "https://tinyurl.com/y6vym4ze");
		p1.setOrderProductList(new ArrayList<OrderProduct>());
		p2.setOrderProductList(new ArrayList<OrderProduct>());
		
		ps.createProduct(p1);
		ps.createProduct(p2);
		ps.createProduct(new Product(0, "ViewFresh Monitor", "Quo mutat iracundia ea, pri viris putent eu. Assum movet qui ei, ne vis nibh consul referrentur.", 370.00, 10, "https://tinyurl.com/yase564t"));
		ps.createProduct(new Product(0, "Acme DX Monitor", "Sit amet, cu has nisl tempor invenire, nobis.", 4000.00, 6, "https://tinyurl.com/ydcytxqf"));
		ps.createProduct(new Product(0, "TopMark FullKitX Monitor", "Paulo simul imperdiet duo eu. Nemore docendi in vim, nam meliore electram te, eu expetenda intellegat mel. Ad viris tation aperiri usu, te insolens argumentum mel. Harum qualisque eam at.", 270.00, 10, "https://tinyurl.com/yalwrplo"));
		ps.createProduct(new Product(0, "ViewFresh Monitor Delux", "Pri viris putent eu. Assum movet qui ei, ne vis nibh consul referrentur.", 370.99, 10, "https://tinyurl.com/ybckmuzf"));
		
		ps.createProduct(new Product(0, "Acme Motherboard", "Eros natum ad eos, ubique oblique accommodare in eos. Eam et dicta cotidieque, an eum hinc comprehensam, no quas lorem vel. Nisl maluisset eu usu, torquatos honestatis philosophia quo ut, ei qui quas appellantur.", 200.00, 8, "https://tinyurl.com/ydxkmvy9"));
		ps.createProduct(new Product(0, "TopMark Motherboard", "His eu vivendum periculis adolescens. No eam nemore discere explicari, vidit saperet gloriatur eu nam, id vidisse lobortis persecuti cum. Est forensibus ullamcorper te, at suas eruditi insolens pro.", 300.00, 5, "https://tinyurl.com/y7hhws3o"));
		ps.createProduct(new Product(0, "Certifica Motherboard", "Eros natum ad eos, ubique oblique accommodare in eos. Eam et dicta cotidieque, an eum hinc comprehensam, no quas lorem vel.", 200.00, 15, "https://tinyurl.com/y8pd8ua2"));
	
		ps.createProduct(new Product(0, "Acme DDR3", "Quo mutat iracundia ea, pri viris putent eu. Assum movet qui ei, ne vis nibh consul referrentur.", 46.99, 14, "https://tinyurl.com/ya32yopv"));
		ps.createProduct(new Product(0, "TopMark DDR4", "Per volutpat electram ei. Cu sea appareat posidonium neglegentur. Iusto ubique sit in, agam indoctum per ei.", 149.00, 25, "https://tinyurl.com/y7bc2kwc"));
		ps.createProduct(new Product(0, "Certifica DDR3", "No eam nemore discere explicari, vidit. Eros natum ad eos, ubique oblique.", 120.00, 3, "https://tinyurl.com/yaymde4x"));
		ps.createProduct(new Product(0, "Retro DDR3", "Mnibh consul referrentur.", 48.99, 1, "https://tinyurl.com/y9c4bwsx"));
		ps.createProduct(new Product(0, "BigBuy DDR4", "Per volutpat electram ei. Cu sea appareat posidonium neglegentur Ko eam nemore discere explicari, vidit. Iusto ubique sit in, agam indoctum per ei.", 159.00, 25, "https://tinyurl.com/y9kv8k8w"));
		ps.createProduct(new Product(0, "Certifica DDR4", "Nemore docendi in vim, nam meliore electram te, eros natum ad eos, ubique oblique.", 120.00, 3, "https://tinyurl.com/yaymde4x"));
	
		ps.createProduct(new Product(0, "Fieldstone Splitter Cable", "Cu sea appareat posidonium neglegentur. Eros natum ad eos, ubique oblique iusto ubique.", 25.00, 50, "https://tinyurl.com/yaudy4eo"));
		ps.createProduct(new Product(0, "Todar Cable Extension", "Ubique oblique accommodare in eos. Eam et dicta cotidieque. Nemore docendi in vim, nam meliore electram te.", 59.99, 12, "https://tinyurl.com/yd4row8k"));
		ps.createProduct(new Product(0, "Acme Cable Adaptor", "Per volutpat electram ei. Cu sea appareat posidonium neglegentur.", 24.99, 10, "https://tinyurl.com/y78caqbm"));
	
		ps.createProduct(new Product(0, "ViewFresh Circuit Board", "Ex tantas dolores quaerendum mel, euismod hendrerit dissentiunt te vim.", 29.99, 12, "https://tinyurl.com/ycu37gxs"));
		
		System.out.println("Creating users");
		User admin = new User(0, "admin", "admin", "emp");
		User user = new User(0, "user","user", "cust");
		User user2 = new User();
		user2.setUsername("user2");
		user2.setPassword("user2");
		user2.setAccessLevel("cust");
		user.setOrderList(new ArrayList<Order>());
		user2.setOrderList(new ArrayList<Order>());
		
		us.createUser(user);
		us.createUser(admin);
		System.out.println("before creating user2: " + user2);
		us.createUser(user2);
		System.out.println("after creating user2" + user2);

		Order ob = new Order();
		Order oc = new Order();
		System.out.println("before sysouting the orders oc and ob");
		System.out.println(oc);
		System.out.println(ob);
		
		ob.setOrderProductList(new ArrayList<OrderProduct>());
		ob.setStatus("bought");
		ob.setCreatedAt(Date.from(Instant.now()));

		oc.setOrderProductList(new ArrayList<OrderProduct>());
		oc.setStatus("cart");
		oc.setCreatedAt(Date.from(Instant.now()));


		
		System.out.println("after creating empty OP lists ");
		System.out.println(oc);
		System.out.println(ob);


		System.out.println("before setting users, didnt persist the orders to the DB just yet.");
		System.out.println("before getuserbyuserid");
		System.out.println(us.getUserById(user.getUserId()));
		System.out.println("after getuserbyuserid");
		oc.setUser(us.getUserById(user.getUserId()));
		ob.setUser(us.getUserById(user.getUserId()));
		System.out.println("after setting users and before updating orders");
		// we cant print anymore cause of recursion with toString()
		System.out.println("before creating orders, after setting the users. Didnt persist before setting users.");
		ob = os.createOrder(ob);
		oc = os.createOrder(oc);
		System.out.println("before updating user");
		us.updateUser(user);
		System.out.println("creating order products");
		// breaks here
		OrderProduct op1 = new OrderProduct();
		OrderProduct op2 = new OrderProduct();
		OrderProduct op3 = new OrderProduct();
		
		System.out.println("before printing the newly created order products");
		System.out.println(op1);
		System.out.println(op2);
		System.out.println(op3);
		System.out.println("after printing the newly created order products");
		
		
		System.out.println();
		System.out.println("created order products, setting their orders, products, quantities");
		System.out.println();
		System.out.println("before print product");
		System.out.println(ps.getProductById(p1.getId()));
		System.out.println("after print product");

		// breaks here
		op1.setOrder(os.getOrderById(ob.getId()));
		op1.setProduct(ps.getProductById(p1.getId()));
		op1.setQuantity(1);
		System.out.println();
		
		op2.setOrder(os.getOrderById(ob.getId()));
		op2.setProduct(ps.getProductById(p2.getId()));
		op2.setQuantity(2);
		System.out.println();
		
		op3.setOrder(os.getOrderById(oc.getId()));
		op3.setProduct(ps.getProductById(p1.getId()));
		op3.setQuantity(3);
		System.out.println();
		
		System.out.println("Attempting to put the OPs into the database");
		ops.createOrderProduct(op1);
		ops.createOrderProduct(op2);
		ops.createOrderProduct(op3);
		System.out.println();
		System.out.println("Everything is done, hooray");
	}
}
