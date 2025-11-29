package com.productApi.productApi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;

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
	@org.junit.jupiter.api.Order(1)
	void Test_getAllProducts() {

	    java.util.List<Product> allProducts = java.util.List.of(
	        Product.builder()
	            .id(1)
	            .href("hrefBuiledr")
	            .description("DescriptionBuilder")
	            .isBundle(true)
	            .isCustomerVisible(true)
	            .name("name Builder")
	            .orderDate(OffsetDateTime.now())
	            .productSerialNumber("SerialNumberBuilder")
	            .startDate(OffsetDateTime.now().plusDays(7))
	            .terminationDate(OffsetDateTime.now().plusDays(365))
	            .build(),
	            
	            Product.builder()
	            .id(2)
	            .href("hrefBuiledr2")
	            .description("DescriptionBuilder2")
	            .isBundle(true)
	            .isCustomerVisible(true)
	            .name("name Builder2")
	            .orderDate(OffsetDateTime.now())
	            .productSerialNumber("SerialNumberBuilder2")
	            .startDate(OffsetDateTime.now().plusDays(7))
	            .terminationDate(OffsetDateTime.now().plusDays(365))
	            .build()
	    );

	    when(productRepository.findAll()).thenReturn(allProducts);

	    java.util.List<Product> result = productService.getAllProducts();

	    assertEquals(2, result.size());
	}
	

	
	
	

}
