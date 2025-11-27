package com.productApi.productApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productApi.productApi.entities.Product;
import com.productApi.productApi.services.ProductService;

@RestController
//@RequestMapping("/products")
public class ProductController {
	/*
	 * @GetMapping public String getProducts(@RequestParam int page, @RequestParam
	 * int limit) { return "HTTP request type GET sended for page --->" + page
	 * +" and limit is --> "+ limit ; }
	 * 
	 * @GetMapping(path ="/{productId}") public String getProduct(@PathVariable
	 * String productId) { return
	 * "HTTP rquest type GET was sended to retreive one product for the productId --->"
	 * + productId; }
	 * 
	 * @org.springframework.web.bind.annotation.PostMapping public String
	 * createProduct() { return "HTTP  request type POST  sended"; }
	 * 
	 * @PutMapping public String updateProduct() { return
	 * "HTTP request  type PUT sended"; }
	 * 
	 * @DeleteMapping public String deleteProduct() { return
	 * "HTTP request of type DELETE was sedned"; }
	 */
	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		return allProducts;

	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@GetMapping("/products/productName")
	public Product getProductByName(@RequestParam String name) {
		return productService.getProductByName(name);
	}

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public AddResponse deleteProduct(@PathVariable int  id) {
		return productService.deleteProduct(id);
	}
	

}
