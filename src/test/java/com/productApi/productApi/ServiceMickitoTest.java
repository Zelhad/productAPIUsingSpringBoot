package com.productApi.productApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.productApi.productApi.entities.Product;
import com.productApi.productApi.repositories.ProductRepository;
import com.productApi.productApi.services.ProductService;

@SpringBootTest
@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class ServiceMickitoTest {

	@org.mockito.Mock
	ProductRepository productRepository;

	@org.mockito.InjectMocks
	ProductService productService;

	@Test
	@Order(1)

	void Test_getAllProducts() {

		java.util.List<Product> allProducts = java.util.List.of(
				Product.builder().id(1).href("hrefBuiledr").description("DescriptionBuilder").isBundle(true)
						.isCustomerVisible(true).name("name Builder").orderDate(OffsetDateTime.now())
						.productSerialNumber("SerialNumberBuilder").startDate(OffsetDateTime.now().plusDays(7))
						.terminationDate(OffsetDateTime.now().plusDays(365)).build(),

				Product.builder().id(2).href("hrefBuiledr2").description("DescriptionBuilder2").isBundle(true)
						.isCustomerVisible(true).name("name Builder2").orderDate(OffsetDateTime.now())
						.productSerialNumber("SerialNumberBuilder2").startDate(OffsetDateTime.now().plusDays(7))
						.terminationDate(OffsetDateTime.now().plusDays(365)).build());

		when(productRepository.findAll()).thenReturn(allProducts);

		java.util.List<Product> result = productService.getAllProducts();

		assertEquals(2, result.size());
	}

	@Test
	@Order(2)
	void test_getProductById() {

		Product product = Product.builder().id(1).href("hrefFindByid").description("descriptionFindByid").isBundle(true)
				.isCustomerVisible(true).name("Product find by id").orderDate(OffsetDateTime.now())
				.productSerialNumber("product serial number").startDate(OffsetDateTime.now().plusDays(6))
				.terminationDate(OffsetDateTime.now().plusMonths(5)).build();
		int id = product.getId();
		when(productRepository.findById(id)).thenReturn(java.util.Optional.of(product));
		assertEquals(product, productService.getProductById(id));

	}

	@Test
	@Order(3)
	void test_getProductByName() {
		List<Product> allProducts = List.of(
				Product.builder().id(1).href("hrefBuiledr").description("DescriptionBuilder").isBundle(true)
						.isCustomerVisible(true).name("name Builder").orderDate(OffsetDateTime.now())
						.productSerialNumber("SerialNumberBuilder").startDate(OffsetDateTime.now().plusDays(7))
						.terminationDate(OffsetDateTime.now().plusDays(365)).build(),

				Product.builder().id(2).href("hrefBuiledr2").description("DescriptionBuilder2").isBundle(true)
						.isCustomerVisible(true).name("name Builder2").orderDate(OffsetDateTime.now())
						.productSerialNumber("SerialNumberBuilder2").startDate(OffsetDateTime.now().plusDays(7))
						.terminationDate(OffsetDateTime.now().plusDays(365)).build());

		when(productRepository.findAll()).thenReturn(allProducts);
		Product product = allProducts.get(1);
		String name = product.getName();
		assertEquals(product, productService.getProductByName(name));
		;
	}

}
