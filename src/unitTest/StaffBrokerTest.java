/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brokers.StaffBroker;
import model.Staff;

/**
 * @author 730693
 *
 */
class StaffBrokerTest {

	StaffBroker sb ;
	Staff staff_1;
	Staff staff_2;
	Staff staff_3;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		sb = new StaffBroker();
		Random random = new Random();
		//int ranIndex = random.nextInt(3);
		String[] jobIDs = {"manager", "Staff-PT", "Staff-FT"}; 
		/*
		if(sb.dataQty() == 0) {
			sb.deleteAll();
		}
		*/		

		staff_1 = new Staff(random.nextInt(10000), "1234", "Y", "Test1", "HI", "4031231234",jobIDs[0]);
		staff_2 = new Staff(random.nextInt(10000), "1234", "N", "Test2", "HI", "4031231234", jobIDs[1]);
		staff_3 = new Staff(random.nextInt(10000), "1234", "Y", "Test1", "HI", "4031231234", jobIDs[2]);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#insert(model.Staff)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsert() throws SQLException {
		int number = sb.dataQty();
		assertEquals(sb.insert(staff_1), true);
		number ++;
		assertEquals(sb.dataQty(), number);
		assertEquals(sb.insert(staff_2), true);
		number ++;
		assertEquals(sb.dataQty(), number);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#isExisitng(int)}.
	 * @throws SQLException 
	 */
	@Test
	void testIsExisitng() throws SQLException {
		sb.insert(staff_1);
		assertTrue(sb.isExisitng(staff_1.getsID()));
		assertEquals(sb.isExisitng(staff_2.getsID()),false);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#findByIDList(int)}.
	 * @throws SQLException 
	 */
	@Test
	void testFindByIDList() throws SQLException {
		sb.insert(staff_1);
		assertTrue(sb.isExisitng(staff_1.getsID()));
		System.out.println(sb.findByIDList( staff_1.getsID()));
		//assertEquals(sb.findByIDList("job", job_1.getjobID()).get(0), job_1);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#delete(int)}.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteByID() throws SQLException {
		sb.insert(staff_1);
//		assertEquals((sb.findByIDList(staff_1.getsID()).get(0).getsID()), staff_1.getsID());
		sb.delete(staff_1.getsID());
		assertEquals(sb.isExisitng(staff_1.getsID()), false);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#delete(model.Staff)}.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteStaff() throws SQLException {
		assertEquals(sb.insert(staff_2), true);
		sb.delete(staff_2.getsID());
		assertEquals(sb.isExisitng(staff_2.getsID()),false);
		assertEquals(sb.insert(staff_1), true);
		sb.delete(staff_1.getsID());
		assertEquals(sb.isExisitng(staff_1.getsID()),false);
	}

	/**
	 * Test method for {@link brokers.StaffBroker#update(model.Staff)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdate() throws SQLException {
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.insert(staff_2), true);
		staff_1.setfName("update test");
		staff_1.setJobName("Staff-FTTTT");
		System.out.println("[Staff_before update] " +staff_1.toString());
		System.out.println(sb.update(staff_1));
//		assertEquals(sb.findByIDList(staff_1.getsID()).get(0).getfName(), staff_1.getfName());
	}

	/**
	 * Test method for {@link brokers.StaffBroker#listing(java.sql.ResultSet)}.
	 */
	@Test
	void testListing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link brokers.StaffBroker#findAll()}.
	 */
	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link brokers.StaffBroker#dataQty()}.
	 * @throws SQLException 
	 */
	@Test
	void testDataQty() throws SQLException {
		int number = sb.dataQty();
		assertEquals(sb.insert(staff_1), true);
		assertEquals(sb.dataQty(), (number+1));
		assertEquals(sb.insert(staff_2), true);
		assertEquals(sb.dataQty(), (number+1));
	}

	/**
	 * Test method for {@link brokers.StaffBroker#deleteAll()}.
	 */
	@Test
	void testDeleteAll() {
		fail("Not yet implemented");
	}

}
