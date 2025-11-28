package com.productApi.productApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productApi.productApi.controllers.AddResponse;
import com.productApi.productApi.entities.Product;
import com.productApi.productApi.repositories.ProductRepository;


@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public ProductService() {

	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}

	public Product getProductByName(String name) {
		List<Product> products = productRepository.findAll();

		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product; // Found → return it
			}
		}

		// Not found → return a built Product object
		return Product.builder().name(name).description("No description available").isBundle(false)
				.isCustomerVisible(true).build();
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	public AddResponse deleteProduct(int id) {
		productRepository.deleteById(id);
		AddResponse response = new AddResponse();
		response.setMsg("Product deleted");
		response.setId(id);
		return response;
}
}
