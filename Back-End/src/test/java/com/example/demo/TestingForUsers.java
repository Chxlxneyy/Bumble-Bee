package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@SpringBootTest
public class TestingForUsers {
	@Autowired
	UsersRepository usersRepository;
	
	@Test
	public void testSaveUsers() {
		Users users = new Users();
		users.setId(1L);
		users.setName("Kanchana");
		users.setAddress("Piliyandala");
		users.setDob("2000-08-15");
		users.setMobile("0779874321");
		users.setPassword("1234");
		usersRepository.save(users);
		assertNotNull(usersRepository.findById(1L).get());
	}

	@Test
	public void testReadAll() {
		List<Users> list = usersRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void testSingleUser() {
		Users users = usersRepository.findById(1L).get();
		assertEquals("Piliyandala", users.getAddress());
	}

	@Test
	public void testUpdateUser() {
		Users users = usersRepository.findById(1L).get();
		users.setName("Kanchana Perera");
		usersRepository.save(users);
		assertNotEquals("Kanchana", usersRepository.findById(1L).get().getName());
	}

	@Test
	public void testDelete() {
		usersRepository.deleteById(1L);
		assertThat(usersRepository.existsById(1L)).isFalse();
	}
}
