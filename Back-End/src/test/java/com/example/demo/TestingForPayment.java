package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

@SpringBootTest
public class TestingForPayment {
	@Autowired
	PaymentRepository paymentRepository;

	@Test
	public void testSavePayment() {
		Payment payment = new Payment();
		payment.setId(6L);
		payment.setName("Dinithi");
		payment.setAddress("maharagama");
		payment.setMobile("0756121789");
		payment.setNote("Deliver to  My Home");
		payment.setTotal("9000");
		payment.setDividedAmount("3000");
		paymentRepository.save(payment);
		assertNotNull(paymentRepository.findById(6L).get());
	}

	@Test
	public void testAllData() {
		List<Payment> list1 = paymentRepository.findAll();
		assertThat(list1).size().isGreaterThan(0);
	}
	
}
