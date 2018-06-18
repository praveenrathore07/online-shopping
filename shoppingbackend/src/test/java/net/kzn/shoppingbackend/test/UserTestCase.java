package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Cart cart=null;
	private Address address = null;
	

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Vipin");
		user.setLastName("Rathore");
		user.setEmail("vipin@gmail.com");
		user.setContactNumber("9806220828");
		user.setPassword("12345");
		user.setRole("USER");
		
		//add user
		assertEquals("Failed to add user!",true,userDAO.addUser(user));
		
		
		address = new Address();
		address.setAddresssLineOne("Flat no 104");
		address.setAddresssLineTwo("jhari mari appt Airoli");
		address.setCity("Mumbai");
		address.setCountry("India");
		address.setPostalCode("400708");
		address.setBilling(true);
		
		//link the user with address
		address.setUserId(user.getId());
		
		//add address
		assertEquals("Failed to add address!",true,userDAO.addAddress(address));
		
		
		if (user.getRole().equals("USER")) {
			
			//create an cart for the user
			cart = new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("Failed to add cart!",true,userDAO.addCart(cart));
			
			//add shipping address for this user
			address = new Address();
			address.setAddresssLineOne("201 jaddo sociaty, krishn kanhiya nagar");
			address.setAddresssLineTwo("Near kudrat store");
			address.setCity("Indore");
			address.setCountry("India");
			address.setPostalCode("400001");
			//set shippint to true
			address.setShipping(true);
			
			address.setUserId(user.getId());
			
			//add the cart
			assertEquals("Failed to shipping address!",true,userDAO.addAddress(address));
			
		}
	}


}
