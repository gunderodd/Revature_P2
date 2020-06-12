package com.store.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.model.Product;
import com.store.app.service.ProductService;

@CrossOrigin
@RestController
public class ProductGenerator {
	
	// Access Service Bean
	@Autowired
	private ProductService ps;
	
	// Just run a post on this endpoint to refill the db with some items
	@PostMapping("/generate")
	public void generateProducts() {
		// Products
		ps.createProduct(new Product(0, "Acme Monitor", "Lorem ipsum dolor sit amet, cu has nisl tempor invenire, nobis.", 200.00, 3, "https://tinyurl.com/y929e58h"));
		ps.createProduct(new Product(0, "TopMark Monitor", "Paulo simul imperdiet duo eu. Nemore docendi in vim, nam meliore electram te, eu expetenda intellegat mel. Ad viris tation aperiri usu, te insolens argumentum mel. Harum qualisque eam at.", 250.00, 10, "https://tinyurl.com/y6vym4ze"));
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
	}
	
}
