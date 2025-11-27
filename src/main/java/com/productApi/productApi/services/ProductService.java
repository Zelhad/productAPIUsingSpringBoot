package com.productApi.productApi.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.productApi.productApi.controllers.AddResponse;
import com.productApi.productApi.entities.Product;

@Service
public class ProductService {

	static HashMap<Integer, Product> productsIdMap;

	public ProductService() {

		productsIdMap = new HashMap<Integer, Product>();

		Product product1 = new Product(1, "/api/v1/products/TEL-1000001", "Enterprise-grade ", true, false,
				"IPHON 17", java.time.OffsetDateTime.now(), "SNIP171025V1", java.time.OffsetDateTime.now(),
				OffsetDateTime.now().plusDays(365));

		Product product2 = new Product(2, "/api/v1/products/TEL-1000001", "Enterprise-grade ", true, false,
				"IPHON 17", java.time.OffsetDateTime.now(), "SNIP171025V1", java.time.OffsetDateTime.now(),
				OffsetDateTime.now().plusDays(365));

		Product product3 = new Product(3, "/api/v1/products/TEL-1000001", "Enterprise-grade ", true, false,
				"IPHON 17", java.time.OffsetDateTime.now(), "SNIP171025V1", java.time.OffsetDateTime.now(),
				OffsetDateTime.now().plusDays(365));

		Product product4 = new Product(4, "/api/v1/products/TEL-1000001", "Enterprise-grade ", true, false,
				"IPHON 17", java.time.OffsetDateTime.now(), "SNIP171025V1", java.time.OffsetDateTime.now(),
				OffsetDateTime.now().plusDays(365));

		productsIdMap.put(1, product1);
		productsIdMap.put(2, product2);
		productsIdMap.put(3, product3);
		productsIdMap.put(4, product4);

	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>(productsIdMap.values());
		return products;
	}
	public Product getProductById(int id) {
		return productsIdMap.get(id);
	}
	
	public Product getProductByName(String name) {
		Product product = null; 
		for(int i : productsIdMap.keySet()) {
			if(productsIdMap.get(i).getName().equals(name)) {
				product= productsIdMap.get(i);
			}
		}
		return product;
	}
	
	public Product addProduct(Product product) {
		product.setId(getMaxId());
		productsIdMap.put(product.getId(), product);
		return product;
	}
	
	public Product  updateProduct(Product product) {
		if(product.getId()> 0) {
			productsIdMap.put(product.getId() , product);
		}
		return product;
	}
	
	public AddResponse deleteProduct(int id ) {
		productsIdMap.remove(id);
		AddResponse response = new AddResponse();
		response.setMsg("Product deleted");
		response.setId(id);
		return response;
		
	}
	
	public static int getMaxId() {
		int max = 0; 
		for(int id : productsIdMap.keySet()) 
			if(max <= id) 
				max=id;
			
		return max+1 ;
	}

}
