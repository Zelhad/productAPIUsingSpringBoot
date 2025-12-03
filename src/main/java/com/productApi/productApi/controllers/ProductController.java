package com.productApi.productApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productApi.productApi.entities.Product;
import com.productApi.productApi.services.ProductService;

@RestController
@RequestMapping("/api/productInventoryManagement/v1/product")
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

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> allProducts = productService.getAllProducts();
			return new ResponseEntity<List<Product>>(allProducts, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		try {
			Product product = productService.getProductById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/search")
	public ResponseEntity<Product> getProductByName(@RequestParam String name) {
		try {
			Product productByName = productService.getProductByName(name);
			return new ResponseEntity<Product>(productByName, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product createdProduct = productService.addProduct(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {

		try {
			Product foundProduct = productService.getProductById(id);
			foundProduct.setHref(product.getHref());
			foundProduct.setDescription(product.getDescription());
			foundProduct.setIsBundle(product.getIsBundle());
			foundProduct.setIsCustomerVisible(product.getIsCustomerVisible());
			foundProduct.setName(product.getName());
			foundProduct.setOrderDate(product.getOrderDate());
			foundProduct.setProductSerialNumber(product.getProductSerialNumber());
			foundProduct.setStartDate(product.getStartDate());
			foundProduct.setTerminationDate(product.getTerminationDate());

			Product updatedProduct = productService.updateProduct(foundProduct);

			return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
		}
	}

}
