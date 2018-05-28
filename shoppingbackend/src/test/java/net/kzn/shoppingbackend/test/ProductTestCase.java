package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTestCase {

	
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
/*	@Test
	public void testCRUDCategory() {

		product = new Product();

		product.setName("Oppo Selfie S53");
		product.setCode("OPPO126");
		product.setBrand("Oppo");
		product.setDescription("Discription for Oppo S53");
		product.setUnitPrice(2500);
		product.setQuantity(8);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Something went wrong while adding the product inside the table!",true,productDAO.add(product));
				
		//fetching and updating the Product 
		
		product = productDAO.get(2);
		
		product.setName("Samsung Galaxy S7");
		
		assertEquals("Something went wrong while updating the product inside the table!",true,productDAO.update(product));
		
		//deleting the category
		
		assertEquals("Something went wrong while updating the product inside the table!",true,productDAO.delete(product));
		
		//fetching the list of categories
		
		assertEquals("Something went wrong while fetching the list of products inside the table!",6,productDAO.list().size());


	}
*/
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of active products", 6,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of active products by category", 4,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of active products by category", 2,productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("Something went wrong while fetching the latest active products", 3,productDAO.getLatestActiveProducts(3).size());
		
	}

}
