/**
 * 
 */
package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brokers.*;
import model.*;

/**
 * @author 730693
 *
 */
class OrderBrokerTest {
	//attributes
	OrderBroker oBroker = new OrderBroker();
	Order order_1;
	Order order_2;
	MenuBroker mBroker = new MenuBroker();
	TableBroker tBroker = new TableBroker();
	Timestamp orderTime;
	List<Table>tables;
	List<Item>items;
	List<Order> orders;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		orders = oBroker.getOrders();
		tables = tBroker.findAll();
		items = mBroker.findItemAll();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Timestamp timeStamp = Timestamp.valueOf(f.format(date)); 
		Table table = tables.get(2);
		Item orderItem = items.get(2);
		order_1 = new Order(0,timeStamp, 50, 0, table, orderItem);		
		order_2 = new Order(0,timeStamp, 50, 1, tables.get(2), orderItem);
		
		TimeUnit.SECONDS.sleep(3);
	}

	/**
	 * Test method for {@link brokers.OrderBroker#insert(model.Order)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsert() throws SQLException {
		assertFalse(oBroker.isExisting(order_1));
		int qty = oBroker.qtyData();
		System.out.println("qty:" +qty);
		assertTrue(oBroker.insert(order_1));
		assertEquals(qty+1, oBroker.qtyData());
		System.out.println("[after]qty: "+oBroker.qtyData());
		//assertTrue(oBroker.isExisting(order_1));
		//assertFalse(oBroker.insert(order_1));
	}

	/**
	 * Test method for {@link brokers.OrderBroker#isExisting(model.Order)}.
	 * @throws SQLException 
	 */
	@Test
	void testIsExisting() throws SQLException {		
		/*
		 * for(Order order:orders) { System.out.print("[Order]:");
		 * System.out.println(order.getOrderID() +" " + order.getOrderItemQty() +" "
		 * +order.getOrderItem().getItemID() +" " + order.getTable().getTableID() +" " +
		 * order.getTable().getStartTime() +" " + order.getOrderStatus()); }
		 */
		
		Order order = oBroker.getOrderByID(orders.get(0).getOrderID(), orders.get(0).getTimeStamp());
		assertTrue(oBroker.isExisting(order));
		assertFalse(oBroker.isExisting(order_2));
			
	}

	/**
	 * Test method for {@link brokers.OrderBroker#update(model.Order)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdate() throws SQLException {
		Order editOrder = orders.get(1);
		System.out.println(editOrder.getOrderID() +" " + editOrder.getOrderItemQty() +" "
				 +editOrder.getOrderItem().getItemID() +" " + editOrder.getTable().getTableID() +" " 
				 +editOrder.getTable().getStartTime() +" " + editOrder.getOrderStatus()); 
		//System.out.println(editOrder.toString());
		System.out.println("[uniTest] OrderAmount"+editOrder.getOrderAmount());
		editOrder.setOrderItemQty(8);
		
		System.out.println("[uniTest] OrderAmount"+editOrder.getOrderAmount());
		assertTrue(oBroker.updateStatus(editOrder));
		//should throw Exception
		assertFalse(oBroker.updateStatus(order_2));
	}

	/**
	 * Test method for {@link brokers.OrderBroker#updateStatus(model.Order)}.
	 * @throws SQLException 
	 */
	@Test
	void testUpdateStatus() throws SQLException {
		Order editOrder = orders.get(1);
		System.out.println("[before]"+editOrder.getOrderID()+", "+ editOrder.getOrderItemQty()+", "+ editOrder.getOrderStatus());
		editOrder.setOrderStatus( editOrder.getOrderStatus()+1);
		System.out.println("[after]"+editOrder.getOrderID()+", "+ editOrder.getOrderItemQty()+", "+ editOrder.getOrderStatus());
		assertTrue(oBroker.updateStatus(editOrder));
		Order foundOrder = oBroker.getOrderByID(editOrder);
		//should throw Exception
		assertEquals(editOrder.getOrderStatus(), foundOrder.getOrderStatus());
		System.out.println("Testing an order isn't existing");
		assertFalse(oBroker.updateStatus(order_2));
	}

	/**
	 * Test method for {@link brokers.OrderBroker#delete(model.Order)}.
	 * @throws SQLException 
	 */
	@Test
	void testDelete() throws SQLException {
		assertTrue(oBroker.insert(order_2));
		orders = oBroker.getOrders();
		assertEquals(orders.get(orders.size()-1).getTimeStamp(),order_2.getTimeStamp());
		assertTrue(oBroker.delete(orders.get(orders.size()-1)));
		assertFalse(oBroker.isExisting(orders.get(orders.size()-1)));
	}

	/**
	 * Test method for {@link brokers.OrderBroker#qtyData()}.
	 * @throws SQLException 
	 */
	@Test
	void testQtyData() throws SQLException {
		System.out.println("[uniTest]qtyData");
		int qty = oBroker.qtyData();
		assertTrue(oBroker.insert(order_1));
		assertEquals(qty+1, oBroker.qtyData());
		oBroker.delete(orders.get(1));
		assertEquals(qty, oBroker.qtyData());
	}

	/**
	 * Test method for {@link brokers.OrderBroker#getOrderByID(int, java.sql.Date)}.
	 * @throws SQLException 
	 */
	@Test
	void testGetOrderByID() throws SQLException {
		oBroker.insert(order_1);
		orders = oBroker.getOrders();
		Order getLastOrder = orders.get(orders.size()-1);
		assertEquals(getLastOrder.getTimeStamp(),order_1.getTimeStamp());
	    Order seekingOrder = oBroker.getOrderByID(order_2);
		assertEquals(seekingOrder, null);
		assertTrue(oBroker.delete(getLastOrder));
		assertEquals(oBroker.getOrderByID(getLastOrder), null);

	}

}
