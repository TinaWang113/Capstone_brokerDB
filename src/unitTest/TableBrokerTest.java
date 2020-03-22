/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brokers.TableBroker;
import model.Table;

/**
 * @author 730693
 *
 */
class TableBrokerTest {

	//attributes
	TableBroker tBroker;
	Timestamp startTime;
	Timestamp endTime;
	Table table_1 ;
	Table table_2 ;
	Table table_3 ;
	/**
	 * @throws java.lang.Exception;
	 */
	@BeforeEach
	void setUp() throws Exception {
		//DateTimeFormatter fmateDateTime= DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
		tBroker = new TableBroker();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Timestamp startTime = Timestamp.valueOf(f.format(date)); 
		//System.out.println("[UniTest] setup - startTime: " + startTime);
		table_1 = new Table(8,startTime);
		table_2 = new Table(7,startTime);
		table_3 = new Table(6,startTime);
		TimeUnit.SECONDS.sleep(3);
	}
	

	/**
	 * Test method for {@link brokers.TableBroker#insertTable(model.Table)}.
	 * @throws ParseException 
	 */
	@Test
	void testInsertTable() {
		/*
		date = LocalDateTime.now();
		endTime = java.sql.Timestamp.valueOf(date);
		*/
		int org_qty = tBroker.qtyData();
		System.out.println("[Test] data #"+org_qty);
		System.out.println("[uniTest]insert :" + table_1.toString());
		assertFalse(tBroker.isExisting(table_1));
		assertTrue(tBroker.insertTable(table_1));
		Table findTable = tBroker.findByID(table_1);
		System.out.println("[UniTest]insert, findTable: "+ findTable.toString());
		assertTrue(tBroker.isExisting(table_1));
		assertEquals(org_qty+1, tBroker.qtyData());
		
		
	}

	/**
	 * Test method for {@link brokers.TableBroker#isExisting(model.Table)}.
	 * @throws ParseException 
	 */
	@Test
	void testIsExisting(){
		assertFalse(tBroker.isExisting(table_2));
		tBroker.insertTable(table_2);
		assertTrue(tBroker.isExisting(table_2));
	}

	/**
	 * Test method for {@link brokers.TableBroker#update(model.Table)}.
	 */
	@Test
	void testUpdate() {
		//table_3 = new Table(6,startTime);
				tBroker.insertTable(table_2);
				Table table = tBroker.findByID(table_2);
				assertEquals(table.getTableStatus(), 0);
				table_2.setTableStatus(1);
				assertTrue(tBroker.updateStatus(table_2));
				System.out.println(table_2.toString());
				table = tBroker.findByID(table_2);
				System.out.println("[UniTest]UpdateStatus: "+table.toString());
				assertEquals(table.getTableStatus(), 1);
	}

	/**
	 * Test method for {@link brokers.TableBroker#updateStatus(model.Table)}.
	 */
	@Test
	void testUpdateStatus() {
		//table_3 = new Table(6,startTime);
		tBroker.insertTable(table_2);
		Table table = tBroker.findByID(table_2);
		assertEquals(table.getTableStatus(), 0);
		table_2.setTableStatus(1);
		assertTrue(tBroker.updateStatus(table_2));
		System.out.println(table_2.toString());
		table = tBroker.findByID(table_2);
		System.out.println("[UniTest]UpdateStatus: "+table.toString());
		assertEquals(table.getTableStatus(), 1);
		
	}

	/**
	 * Test method for {@link brokers.TableBroker#delete(model.Table)}.
	 */
	@Test
	void testDelete() {
		System.out.println("[testDelete] insert result: "+tBroker.insertTable(table_3));
		
		assertTrue(tBroker.delete(table_3));
		assertFalse(tBroker.isExisting(table_3));
	}

	/**
	 * Test method for {@link brokers.TableBroker#qtyData()}.
	 */
	@Test
	void testQtyData() {
		int qty = tBroker.qtyData();
		System.out.println("[uniTest]qty:" + qty);
		tBroker.insertTable(table_1);
		assertEquals((qty+1), tBroker.qtyData());
		tBroker.delete(table_1);
		System.out.println("[after delete]"+tBroker.qtyData());
		assertEquals(qty, tBroker.qtyData());
		tBroker.insertTable(table_1);
		tBroker.insertTable(table_2);
		tBroker.insertTable(table_3);
		assertEquals(qty+3, tBroker.qtyData());
	}

	/**
	 * Test method for {@link brokers.TableBroker#findByID(int, java.sql.Date)}.
	 */
	@Test
	void testFindByIDIntDate() {
		Table foundTable = tBroker.findByID(table_1.getTableID(), table_1.getStartTime());
		assertEquals(foundTable, null);
		tBroker.insertTable(table_1);
		foundTable = tBroker.findByID(table_1.getTableID(), table_1.getStartTime());
		assertTrue(foundTable !=null);
		System.out.println(foundTable.toString());
	}

	/**
	 * Test method for {@link brokers.TableBroker#findByID(model.Table)}.
	 */
	@Test
	void testFindByIDTable() {
		//System.out.println("[uniTest]findByTable: "+ foundTable.toString());
		assertEquals(tBroker.findByID(table_2), null);
		assertTrue(tBroker.insertTable(table_2));
		tBroker.findByID(table_2);
		assertEquals(tBroker.findByID(table_2), table_2);
	}

	/**
	 * Test method for {@link brokers.TableBroker#findAll()}.
	 */
	@Test
	void testFindAll() {
		List<Table> tables = new ArrayList<Table>();
		tables = tBroker.findAll();
		assertEquals(tBroker.qtyData(), tables.size());
		/*
		for(Table table: tables) {
			System.out.println("[Tables]"+table.toString());
		}
		*/
	}

}
