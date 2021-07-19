//package fr.hb.benjamin.picom.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import fr.hb.benjamin.picom.business.User;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class UserServiceImplTest {
//
//	// ----------------------------- Attributes ---------------------------------
//	@Autowired
//	private UserService userService;
//	private static User userIn;
//	private static User userOut;
//	
//	
//	
//	// -------------------------------- Tests -----------------------------------
//	@Test
//	@Order(1)
//	void testSave() {
//		User user = new User();
//		user.setFistName("FirstName");
//		user.setLastName("LastName");
//		user.setEmail("user@mail.com");
//		user.setPassword("123456789");
//		user.setBills(new ArrayList());
//		// TODO method to check role & bills
//		userIn = userService.save(user);
//		
//		// Tests
//		assertNotNull(userIn);
//		assertNotNull(userIn.getIdUser());
//		assertEquals(userIn.getFistName(), user.getFistName());
//		assertEquals(userIn.getLastName(), user.getLastName());
//		assertEquals(userIn.getEmail(), user.getEmail());
//		assertEquals(userIn.getPassword(), user.getPassword());
//		// TODO check role & bills
//	}
//	
//	
//	@Test
//	@Order(2)
//	void testFindByEmailAndPassword() {
//		userOut = userService.findByEmailAndPassword(userIn.getEmail(),	userIn.getPassword());
//		userOut.setBills(userIn.getBills());
//		// Tests
//		System.out.println(userIn);
//		System.out.println(userOut);
//		assertNotNull(userOut);
//		assertEquals(userIn, userOut);
//	}
//
//
//}
