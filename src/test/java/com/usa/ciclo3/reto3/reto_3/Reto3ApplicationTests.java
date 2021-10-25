package com.usa.ciclo3.reto3.reto_3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.usa.ciclo3.reto3.model.*;
import com.usa.ciclo3.reto3.repository.crud.*;
import com.usa.ciclo3.reto3.service.AdminService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Reto3ApplicationTests {

	@Autowired
	AdminService adminService;


	@Autowired
	AdminCrudRepository adminCrudRepo;

	@Test
	void TestAdmin() {
		Admin adm = new Admin("Isaac","ivvidp12@gmail.com","1234567890");
		adminService.guardarAdmin(adm);

		assertEquals(adminCrudRepo.count(), 1);
		assertEquals(adm.getEmail(), "ivvidp12@gmail.com");
		assertEquals(adminCrudRepo.existsById(1), true);
	}

}
