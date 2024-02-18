package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.app.entities.User;
import com.app.enums.Gender;
import com.app.enums.Role;
import com.app.enums.Status;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	private byte[] profile;
	
	@Value("${ADMIN_FIRSTNAME}") // Injecting values from application.properties
    private String adminFirstName;
    
    @Value("${ADMIN_LASTNAME}")
    private String adminLastName;
    
    @Value("${ADMIN_MAIL}")
    private String adminMail;
    
    @Value("${ADMIN_PASSW0RD}")
    private String adminPassword;
	
    @Autowired
	private PasswordEncoder encoder;
    
	@Test
	void testSaveUsers() {
		
		User admin = new User(adminFirstName, adminLastName, LocalDate.now(), Gender.MALE, 20.3, 50.0,profile,adminMail,encoder.encode(adminPassword), Role.ADMIN, Status.APPROVED);
		User a= userDao.save(admin);
		assertEquals(1, a!=null ? 1 : 0);
	}

}
