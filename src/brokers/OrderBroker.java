/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Order;
import model.Table;
import server.Connect2Server;

/**
 * @author 730693
 *
 */
public class OrderBroker {
	//attributes
	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	String stmtString="";
	boolean executedResult = false;
	List <Order>orders;
	MenuBroker mBroker;
	TableBroker tBroker;
	
	
	public boolean insert(Order order) {
		executedResult = false;
		if((order.getOrderID() < 0) || (order.getOrderID() > 0 && isExisting(order))) {
			System.out.println("the data of order is incorrect or the order is exisitng in DB.");
		}else {		
			try {
				connect();			
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				stmtString = "insert order (orderID, timeStamp, orderItemQty, orderAmount, "
						+ "orderStatus, item_itemID, table_tableID, table_startTime)"
						+ "values(?,?,?,?,?,?,?,?)";
				preparedStmt = con.prepareStatement(stmtString);			
				if(order.getOrderID() != 0) {	
					preparedStmt.setInt(1, order.getOrderID());
				}else {
					preparedStmt.setString(1, null);
				}
				preparedStmt.setDate(2, order.getTimeStamp());
				preparedStmt.setInt(3, order.getOrderItemQty());
				preparedStmt.setDouble(4, order.getOrderAmount());
				preparedStmt.setInt(5, order.getOrderStatus());
				Item item = order.getOrderItem();
				if(!(mBroker.isExisting("item", item.getItemID()))) {
					close();
					System.out.println("the itemID is invalidated. Please check the value.");
					return executedResult;
				}
				preparedStmt.setInt(6, item.getItemID());
				Table table = order.getTable();
				if(!(tBroker.isExisting(table))) {
					close();
					System.out.println("the data of Table is invalidated. Please check the value.");
					return executedResult;
				}
				preparedStmt.setInt(7, table.getTableID());
				preparedStmt.setString(8, table.getStartTime().toString());
				if(preparedStmt.executeUpdate() ==1) {
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return executedResult;
	}
	
	
	
	public boolean isExisting(Order order) {
		executedResult = false;
		if(!(order.getOrderID() > 0)) {
			return false;
		}else {
			try {
				connect();
				stmtString = "select count(*) from table "
						+ "where orderID = " + order.getOrderID()+" AND timeStamp = "+ order.getTimeStamp();
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.execute()) {
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return executedResult;
		}
	}

	
	public boolean update(Order order) {
		executedResult = false;
		if(!isExisting(order)) {
			System.out.println("Order isn't existing, please check table data.");
			//here can implement the exception handling to throw the noExisitng Exception ....
		}else {
			try {
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				connect();
				stmtString = "update order SET "
						+ " orderItemQty = " + order.getOrderItemQty()
						+ ", orderAmount = " + order.getOrderAmount()
						+ ", orderStatus = " + order.getOrderStatus()
						+ ", item_itemID = " + order.getOrderItem().getItemID()
						+ ", table_tableID = " +order.getTable().getTableID()
						+ ", table_startTime = " +order.getTable().getStartTime()
						+ " Where orderID = " + order.getOrderID() + " AND timeStamp = "+ order.getTimeStamp();
				
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return executedResult;
	}
	
	public boolean updateStatus(Order order) {
		executedResult = false;
		if(!(order.getOrderID() > 0) || isExisting(order) || !(order.getOrderStatus()+"").matches("[0-3]")) {
			System.out.println("[Order] data invalidated.");
		}else {
			try {
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				connect();
				stmtString = "update order SET orderStatus = " + order.getOrderStatus()
						   + " Where orderID = " + order.getOrderID() + " AND timeStamp = "+ order.getTimeStamp();
				
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return executedResult;
	}

	public boolean delete(Order order) {
		executedResult = false;
		if(order.getOrderID() > 0 && order.getTimeStamp() != null) {
			try {
				connect();			
				stmtString = "delete from order "
						   + " Where orderID = " + order.getOrderID() + " AND timeStamp = "+ order.getTimeStamp();
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					System.out.println("[Order]deleted.");
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Table ID cannot equal or small than 0, "+order.getOrderID()+ ". Or timeStamp cannot be null");		
		}
		return executedResult;	
	}
	
	
	private boolean deleteAll() {
		executedResult = false;
		try {
			connect();			
			stmtString = "delete from order";
			preparedStmt = con.prepareStatement(stmtString);
			if(preparedStmt.executeUpdate() == 1) {
				System.out.println("[Order] All data is deleted.");
				executedResult = true;
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return executedResult;
		
	}
	
	public int qtyData() {
		int qty = 0;
		try {
			stmtString = "select count(*) from order";
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			rs.next();
			qty =  rs.getInt(1);
			System.out.println("[qtyDate] Order#"+qty);
			close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return qty;
	}
	
	public Order getOrderByID(int orderID, Date timeStamp) {
		Order order = new Order(orderID, timeStamp);
		if(isExisting(order)) {
			try {
				connect();
				stmtString = "select orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime"
						+ " from order where orderID = "+ orderID + " AND timeStamp = "+ timeStamp;
				preparedStmt = con.prepareStatement(stmtString);
				rs = preparedStmt.executeQuery();
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				rs.next();
				order.setOrderItemQty(rs.getInt("orderItemQty"));
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				Item item = mBroker.findbyID(rs.getInt("item_itemID"));
				if(item == null) {
					System.out.println("[Order]get Item date fail");
				}
				order.setOrderItem(item);
				Table table = tBroker.findByID(rs.getInt("table_tableID"), rs.getTimestamp("table_startTime"));
				if(table == null) {
					System.out.println("[Order] Get table data fail.");
				}
				order.setTable(table);
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("No table matches the TableID and startTime");
		}
		
		return order;
	}
	
	
	public List<Order> getOrders(){
		orders = new ArrayList<Order>();
		try {
			connect();
			stmtString = "select * from order";
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
			while(rs.next()) {
				Order order = new Order();
				order.setOrderItemQty(rs.getInt("orderItemQty"));
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				Item item = mBroker.findbyID(rs.getInt("item_itemID"));
				if(item == null) {
					System.out.println("[Order]get Item date fail");
				}
				order.setOrderItem(item);
				Table table = tBroker.findByID(rs.getInt("table_tableID"), rs.getTimestamp("table_startTime"));
				if(table == null) {
					System.out.println("[Order] Get table data fail.");
				}
					order.setTable(table);
					orders.add(order);
				}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;

	}
	
	
	private void close() throws SQLException {
		if(rs.isClosed()) rs.close();
		if(!preparedStmt.isClosed()) preparedStmt.close();
		if(!con.isClosed()) con.close();
	}
	
	private Connection connect() throws SQLException {
		if(con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}
	
}
