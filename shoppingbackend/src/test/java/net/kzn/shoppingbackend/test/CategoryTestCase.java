package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory () { category = new Category();
	 * 
	 * category.setName("Laptop"); category.setDescription(
	 * "Discription for Laptop"); category.setImageURL("cat_3.png");
	 * 
	 * assertEquals("Succesfully added the category inside the table!"
	 * ,true,categoryDAO.add(category));
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory () { category = categoryDAO.get(1);
	 * assertEquals("Succesfully fetched single category from the table!"
	 * ,"Television",category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void tesUpdateCategory () { category = categoryDAO.get(1);
	 * 
	 * category.setName("tv"); assertEquals(
	 * "Succesfully updated single category in the table!"
	 * ,true,categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory () { category = categoryDAO.get(1);
	 * 
	 * assertEquals("Succesfully deleted single category from the table!"
	 * ,true,categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory () {
	 * 
	 * assertEquals("Succesfully fetched list of categories from the table!"
	 * ,2,categoryDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testCRUDCategory() {

		category = new Category();

		category.setName("Laptop");
		category.setDescription("Discription for Laptop");
		category.setImageURL("cat_1.png");
		assertEquals("Succesfully added the category inside the table!",true,categoryDAO.add(category));
		
		category = new Category();

		category.setName("Television");
		category.setDescription("Discription for Television");
		category.setImageURL("cat_2.png");
		assertEquals("Succesfully added the category inside the table!",true,categoryDAO.add(category));
		
		//fetching and updating the category 
		
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Succesfully updated the category inside the table!",true,categoryDAO.update(category));
		
		//deleting the category
		
		assertEquals("Succesfully updated the category inside the table!",true,categoryDAO.delete(category));
		
		//fetching the list of categories
		
		assertEquals("Succesfully fetched list of categories from the table!",1,categoryDAO.list().size());




	}
}
