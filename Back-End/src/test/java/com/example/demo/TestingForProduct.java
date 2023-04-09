package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest

public class TestingForProduct {
	@Autowired
	ProductRepository productRepository;

	@Test
	
	public void testProductSave() {
		Product product = new Product();
		product.setId(1L);
		product.setTitle("AMANI RUFFLE DETAILED SHIRT DRESS");
		product.setDescription("Long sleeve shirt dress with front button fastening and ruffle detail");
		product.setCategory("Top");
		product.setPrice((long) 4890);
		product.setImage("https://d1hj68zhrbkzii.cloudfront.net/wp-content/uploads/2023/04/0310901205WHT-1Ladies-dress_fashion-bug_sri-lanka_compressed.jpg");
		productRepository.save(product);
		assertNotNull(productRepository.findById(1L).get());
	}

	@Test
	public void testReadAllProduct() {
		List<Product> list1 = productRepository.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}

	@Test
	public void testUpdateProduct() {
		Product product = productRepository.findById(1L).get();
		product.setCategory("Dress");
		productRepository.save(product);
		assertNotEquals("Top", productRepository.findById(1L).get().getCategory());
	}

	@Test
	public void testDelete() {
		productRepository.deleteById(1L);
		assertThat(productRepository.existsById(1L)).isFalse();
	}
}
