/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Order;
import model.Table;
import server.Connect2Server;

/**
 * OrderBroker 
 * 	communicating data with server
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
	MenuBroker mBroker = new MenuBroker();
	TableBroker tBroker = new TableBroker();
	
	/**
	 * insert
	 * 	insert data into database
	 * @param order Order object 
	 * @return boolean true if insert is success, otherwise the return is false
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public boolean insert(Order order) throws SQLException {
		executedResult = false;
		//check item and table first!!!!!!
		if(order.getTimeStamp() ==null) {
			System.out.println("[OB_insert]TimeStamp cannot be null");
			return executedResult;
		}
		if(tBroker.isExisting(order.getTable()) && mBroker.isExisting("item", order.getOrderItem().getItemID())) {
			if(!(isExisting(order))) {
				try {
					connect();	
					if(order.getTimeStamp() != null && order.getOrderID() > 0) {
						stmtString = "insert capstone2020.`order` (orderID, timeStamp,orderItemQty, orderAmount, "
								+ "orderStatus, item_itemID, table_tableID, table_startTime)"
								+ " values(?,?,?,?,?,?,?,?)";
						preparedStmt = con.prepareStatement(stmtString);
						preparedStmt.setInt(1, order.getOrderID());
						preparedStmt.setTimestamp(2, order.getTimeStamp());
						preparedStmt.setInt(3, order.getOrderItemQty());
						preparedStmt.setDouble(4, order.getOrderAmount());
						preparedStmt.setInt(5, order.getOrderStatus());				
						preparedStmt.setInt(6, order.getOrderItem().getItemID());
						preparedStmt.setInt(7, order.getTable().getTableID());
						preparedStmt.setTimestamp(8, order.getTable().getStartTime());
					}else {
						//orderID and timeStamp is default
						stmtString = "insert capstone2020.`order` (timeStamp,orderItemQty, orderAmount, "
								+ "orderStatus, item_itemID, table_tableID, table_startTime)"
								+ " values(?,?,?,?,?,?,?)";
						preparedStmt = con.prepareStatement(stmtString);
						preparedStmt.setTimestamp(1, order.getTimeStamp());
						preparedStmt.setInt(2, order.getOrderItemQty());
						preparedStmt.setDouble(3, order.getOrderAmount());
						preparedStmt.setInt(4, order.getOrderStatus());				
						preparedStmt.setInt(5, order.getOrderItem().getItemID());
						preparedStmt.setInt(6, order.getTable().getTableID());
						preparedStmt.setTimestamp(7, order.getTable().getStartTime());
					}
					
					System.out.println("[OB_insert]stmt: "+preparedStmt);
					if(preparedStmt.executeUpdate() == 1) {
						executedResult = true;
					}
					close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("the data of order is incorrect or the order is exisitng in DB.");
			}
		}else {
			
			System.out.println("[OrderBroker] table or item is incorrect.");
		}
		
		return executedResult;
	}
	
	/**
	 * isExisitng
	 * 	check id is existing or not.
	 * @param order Order object, the orderID cannot be null or small then 0
	 * @return boolean indicating the ID is existing in DB, or not
	 * @throws SQLException Exception if SQL has any problem.
	 */
	
	public boolean isExisting(Order order) throws SQLException {
		executedResult = false;
		System.out.println("[order]"+order.getOrderID());
		if(order.getOrderID() >= 0) {
			try {
				connect();
				stmtString = "select count(*) from capstone2020.`order` "
						+ "where orderID = " + order.getOrderID()+" AND timeStamp = '"+ order.getTimeStamp()+"'";
				preparedStmt = con.prepareStatement(stmtString);
				System.out.println("[OrderBroker]isExisting: "+stmtString);
				rs = preparedStmt.executeQuery(stmtString);
				rs.next();
				int temp = rs.getInt("count(*)");
				System.out.println("[OB]isExisting: temp= "+ temp);
				if(rs.getInt("count(*)")==1) {
					executedResult =true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("orderID is small than or equal  0.");
		}
			return executedResult;
	}

	/**
	 * update
	 * 	update order which is existing in order database
	 * @param order Order object orderID cannot be null and large than 0
	 * @return boolean true, the data updates success. False, deleting fail. 
	 * @throws SQLException Exception if SQL has any problem.
	 */
	
	public boolean update(Order order) throws SQLException {
		executedResult = false;
		if(!(tBroker.isExisting(order.getTable()))) {
			System.out.println("[OrderBroker] update : table isn't existing.");
			return executedResult;
		}
		if (!(mBroker.isExisting("item", order.getOrderItem().getItemID()))) {
			System.out.println("[OrderBroker] update : item isn't existing.");
			return executedResult;
		}
		if(!isExisting(order)) {
			System.out.println("Order isn't existing, please check table data.");
			//here can implement the exception handling to throw the noExisitng Exception ....
		}else {
			try {
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				connect();
				/* 2020.04.2 [Modify]	
				stmtString = "update capstone2020.`order` SET "
						+ " orderItemQty = " + order.getOrderItemQty()
						+ ", orderAmount = " + order.getOrderAmount()
						+ ", orderStatus = " + order.getOrderStatus()
						+ " Where orderID = " + order.getOrderID() + " AND timeStamp = '"+ order.getTimeStamp()+"'";
				*/
				stmtString = "update capstone2020.`order` SET orderItemQty = ?, orderAmount = ?, orderStatus = ?"
						+ " Where orderID = ? AND timeStamp = ?";				
				preparedStmt = con.prepareStatement(stmtString);				
				preparedStmt.setInt(1, order.getOrderItemQty());
				preparedStmt.setDouble(2, order.getOrderAmount());
				preparedStmt.setInt(3, order.getOrderStatus());
				preparedStmt.setInt(4, order.getOrderID());
				preparedStmt.setTimestamp(5, order.getTimeStamp());
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
	
	/**
	 * updateStatus
	 * 	only update Status of order
	 * @param order Order object orderID cannot be null or small then 0
	 * @return boolean true if updated success; otherwise false.
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public boolean updateStatus(Order order) throws SQLException {
		executedResult = false;
		if(isExisting(order)) {		
			try {
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				connect();
				stmtString = "update capstone2020.`order` SET orderStatus = " + order.getOrderStatus()
						   + " Where orderID = " + order.getOrderID() + " AND timeStamp = '"+ order.getTimeStamp()+"'";
				
				preparedStmt = con.prepareStatement(stmtString);
				System.out.println("[OrderBroker]updateStatus: stmtString =" + stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("[OrderBroker] order is not existing.");
		}
		
		return executedResult;
	}

 	/*
 * delete
 * 	delete data by Order object.
 * @param order Order object, the orderID cannot be null(mandatory).
 * @return boolean true, the data has been deleted. False, deleting fail.
 * @throws SQLException Exception if SQL has any problem.
*/
	public boolean delete(Order order) {
		executedResult = false;
		if(order.getOrderID() > 0 && order.getTimeStamp() != null) {
			try {
				connect();			
				stmtString = "delete from capstone2020.`order` "
						   + " Where orderID = " + order.getOrderID() + " AND timeStamp = '"+ order.getTimeStamp()+"'";
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					System.out.println("[Order]deleted.");
					executedResult = true;
				}
				//close();
				if(!preparedStmt.isClosed()) preparedStmt.close();
				if(!con.isClosed()) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Table ID cannot equal or small than 0, "+order.getOrderID()+ ". Or timeStamp cannot be null");		
		}
		return executedResult;	
	}
	
	 /**
	 * deleteAll
	 * 	delete all data in the order database
	 * @return boolean true if all data has been deleted; otherwise false  
	 * @throws SQLException Exception if SQL has any problem.
	 */
	private boolean deleteAll() {
		executedResult = false;
		try {
			connect();			
			stmtString = "delete from capstone2020.`order`";
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
	
	/**
	 * dataQty 
	 * 	total number of database
	 * @return int the qty of data
	 */
	public int qtyData() {
		int qty = 0;
		try {
			connect();
			stmtString = "select count(*) from capstone2020.`order`";
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
	
	/**
	 * getOrderByID
	 * 	get order data by orderID and timestamp 
	 * @param orderID int it should be integer and large than 0
	 * @param timeStamp Timestamp cannot be null
	 * @return order Order object if it is existing in order database; otherwise false
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public Order getOrderByID(int orderID, Timestamp timeStamp) throws SQLException {
		Order order = new Order(orderID, timeStamp);
		Item item = new Item();
		Table table = new Table();
		if(isExisting(order)) {
			try {
				connect();
				stmtString = "select orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime"
						+ " from capstone2020.`order` where orderID = "+ orderID + " AND timeStamp = '"+ timeStamp+"'";
				preparedStmt = con.prepareStatement(stmtString);
				rs = preparedStmt.executeQuery();
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				rs.next();
				order.setOrderItemQty(rs.getInt("orderItemQty"));
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				item.setItemID(rs.getInt("item_itemID"));
				order.setOrderItem(item);
				table.setTableID(rs.getInt("table_tableID"));
				table.setStartTime(rs.getTimestamp("table_startTime"));				
				order.setTable(table);
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				order = null;
				e.printStackTrace();
			}
		}else {
			order =null;
			System.out.println("No table matches the TableID and startTime");
		}		
		return order;
	}
	
	
	/**
	 * getOrderByID
	 * 		get order data by order object 
	 * @param order Order object orderID and timeStamp cannot be null
	 * @return order Order object if it is existing in order database; otherwise false
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public Order getOrderByID(Order order) throws SQLException {
		Item item = new Item();
		Table table = new Table();
		if(isExisting(order)) {
			try {
				connect();
				stmtString = "select *  from capstone2020.`order` "
						+ " where orderID = "+ order.getOrderID() + " AND timeStamp = '"+ order.getTimeStamp()+ "'";
				preparedStmt = con.prepareStatement(stmtString);
				rs = preparedStmt.executeQuery();
				// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
				rs.next();
				order.setOrderItemQty(rs.getInt("orderItemQty"));
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				item.setItemID(rs.getInt("item_itemID"));
				order.setOrderItem(item);
				table.setTableID(rs.getInt("table_tableID"));
				table.setStartTime(rs.getTimestamp("table_startTime"));
				order.setTable(table);
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				order = null;
				e.printStackTrace();
			}
		}else {
			order =null;
			System.out.println("No table matches the TableID and startTime");
		}
		
		return order;
	}
	
	/**
	 * getOrders
	 * 	get all data from the order database 
	 * @return List containing the object
	 */
	 
	public List<Order> getOrders(){
		orders = new ArrayList<Order>();
		try {
			connect();
			stmtString = "select * from capstone2020.`order`";
			//System.out.println("[oB]getOrders: "+ stmtString);
			
			
			MenuBroker menubroker = new MenuBroker();
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			// orderID, timeStamp, orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime
			
			
			while(rs.next()) {
				Order order = new Order();
				Item item = new Item();
				Table table = new Table();
				order.setOrderID(rs.getInt("orderID"));
				order.setOrderItemQty(rs.getInt("orderItemQty"));
				order.setTimeStamp(rs.getTimestamp("timestamp"));
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				item = menubroker.findbyID((rs.getInt("item_itemID")));
				order.setOrderItem(item);
				table.setTableID(rs.getInt("table_tableID"));
				table.setStartTime(rs.getTimestamp("table_startTime"));
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
	
	/**
	 * close
	 * 	close all connection between database.
	 * @throws SQLException if any exception during running query
	 */
	private void close() throws SQLException {
		if(!rs.isClosed()) rs.close();
		if(!preparedStmt.isClosed()) preparedStmt.close();
		if(!con.isClosed()) con.close();
		}
	
	 /**
		 * connect
		 * 	Establishing the connection to server.
		 * @return con Connection
		 * @throws SQLException if any exception during running query
		 */
	private Connection connect() throws SQLException {
		if(con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}
	
}
