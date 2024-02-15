package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.User;
import com.app.enums.Gender;
import com.app.enums.Role;
import com.app.enums.Status;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	private byte[] profile;
	@Test
	void testSaveUsers() {
		User admin = new User("${ADMIN_FIRSTNAME}", "${ADMIN_LASTNAME}", LocalDate.now(), Gender.MALE, 20.3, 50.0,profile,"${ADMIN_MAIL}", "${ADMIN_PASSW0RD}", Role.ADMIN, Status.APPROVED);
		User a= userDao.save(admin);
		assertEquals(1, a!=null ? 1 : 0);
	}

}
