/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brokers.MenuBroker;
import model.Category;
import model.Item;

/**
 * @author 730693
 *
 */
class MenuBrokerTest {
	MenuBroker mb;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mb = new MenuBroker(); 
		
	}
	

	/**
	 * Test method for {@link brokers.MenuBroker#findAll()}.
	 * @throws SQLException 
	 */
	@Test
	void findItemAll() throws SQLException {
		List <Item> items = mb.findItemAll();
		assertEquals(items.size(), mb.qtyData("item"));	
	}

	
	

	/**
	 * Test method for {@link brokers.MenuBroker#findbyID(int)}.
	 * @throws SQLException 
	 */
	@Test
	void testFindbyCategoryID() throws SQLException {
		Category category = mb.findByID(2);
		assertEquals(category.getCategoryID(), 2);
		System.out.println(category.toString());
		category = mb.findByID(9999);
		assertEquals(category, null);	
	}

	/**
	 * Test method for {@link brokers.MenuBroker#findByID(int)}.
	 */
	@Test
	void testFindByItemID() {
		try {
		Item item = mb.findbyID(7);
		assertEquals(item.getItemID(), 7);
		System.out.println(item.toString());
		item = mb.findbyID(9999);
		assertEquals(item, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * Test method for {@link brokers.MenuBroker#isExisting(java.lang.String, int)}.
	 * @throws SQLException 
	 */
	@Test
	void testIsExisting() throws SQLException {
		assertTrue(mb.isExisting("category", 3));
		assertTrue(mb.isExisting("table", 7));
	}

	/**
	 * Test method for {@link brokers.MenuBroker#qtyData(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testQtyData() throws SQLException {
		List <Item> items = mb.findItemAll();
		List<Category> categories = mb.findCategoryAll();
		assertEquals(items.size(), mb.qtyData("item"));	
		assertEquals(categories.size(), mb.qtyData("category"));
		Category category = new Category("Test2sdffdsf33",1);
		mb.insertCategory(category);
		assertEquals(categories.size()+1, mb.qtyData("category"));
		
		Item item = new Item( "Test2", categories.get(3), 21.22, "Testing purpose","test", "dfdsftest");
		mb.insertItem(item);
		assertEquals(items.size()+1, mb.qtyData("item"));		
	}

	/**
	 * Test method for {@link brokers.MenuBroker#insert(model.Item)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsertItem() throws SQLException {
		List<Category> categories = mb.findCategoryAll();
		Item item = new Item( "Teadfadfa", categories.get(3), 331.22, "Testing purpose","test", "dfdsftest");
		mb.insertItem(item);
		List <Item> items = mb.findItemAll();
		assertTrue(mb.isExisting("item", items.get(items.size()-1).getItemID()));
	}

	/**
	 * Test method for {@link brokers.MenuBroker#insert(model.Category)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsertCategory() throws SQLException {
		List<Category> categories = mb.findCategoryAll();
		assertEquals(categories.size(), mb.qtyData("category"));
		Category category = new Category("Teadfasf33",2);
	}

	/**
	 * Test method for {@link brokers.MenuBroker#update(model.Item)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateItem() throws SQLException {
		List<Item> items = mb.findItemAll();
		Item item = items.get(items.size()-1);
		item.setItemDesc("testeseteststst");;
		assertTrue(mb.update(item));
		List<Item> items2 = mb.findItemAll();
		//assertEquals(items2.size(), items.size()+1);
		assertEquals(mb.findbyID(items.size()-1).getItemDesc(), item.getItemDesc());
	}

	/**
	 * Test method for {@link brokers.MenuBroker#update(model.Category)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateCategory() throws SQLException {
		List<Category> categories = mb.findCategoryAll();
		System.out.println("[updateCategory]"+categories.size());
		Category category = categories.get(categories.size()-1);
		category.setCategoryName("Test21314");
		mb.update(category);
		assertEquals(mb.findByID(categories.size()-1).getCategoryName(), category.getCategoryName());
	}

	/**
	 * Test method for {@link brokers.MenuBroker#deleteByID(java.lang.String, int)}.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteByID() throws SQLException {
		List<Category> categories = mb.findCategoryAll();
		assertEquals(categories.size(), mb.qtyData("category"));
		Category category = new Category("Test23sfdsf33",1);
		assertTrue(mb.deleteByID("category", 22));
		assertTrue(mb.isExisting("category", 22));
	}

}
