/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Item;
import model.Order;
import model.Table;
import server.Connect2Server;

/***/
public class TableMgmtBrokder {

	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	String stmtString = "";
	boolean executedResult = false;
	List<Item> items;
	List<Order> orders;
	List<Table> tables;

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Order> getOrderAll(String tableID, String startTime) throws SQLException {
		executedResult = false;
		connect();
		stmtString = "select t.tableID, o.timeStamp, o.orderID, i.itemName, o.orderItemQty, i.itemPrice, o.orderStatus \r\n"
				+ "from capstone2020.table t, capstone2020.order o, capstone2020.item i \r\n"
				+ "where t.tableID=o.table_tableID \r\n" + "and t.startTime=o.table_startTime \r\n"
				+ "and o.item_itemID=i.itemID and t.tableID=? and t.startTime=? order by o.timestamp desc";
		preparedStmt = con.prepareStatement(stmtString);
		preparedStmt.setString(1, tableID);
		preparedStmt.setString(2, startTime);
		rs = preparedStmt.executeQuery();
		if (rs != null) {
			orders = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order();
				order.setTableID(rs.getString(1));
				order.setTimeStamp(rs.getString(2));
				order.setOrderID(rs.getInt(3));
				order.setOrderItem(rs.getString(4));
				order.setOrderQty(rs.getInt(5));
				order.setOrderPrice(rs.getDouble(6));
				order.setOrderStatus(rs.getInt(7));
				orders.add(order);
			}
		} else {
			System.out.println("SQL stmt is problem.");
		}
		close();
		return orders;
	}

	public List<Table> getTableAll() throws SQLException {
		executedResult = false;
		connect();
		stmtString = "select tableID, startTime, endTime, tableStatus from capstone2020.table";
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		if (rs != null) {
			tables = new ArrayList<Table>();
			while (rs.next()) {
				Table table = new Table();
				table.setTableID(rs.getInt(1));
				table.setStartTime(rs.getString(2));
				table.setEndTime(rs.getString(3));
				table.setTableStatus(rs.getInt(4));
				tables.add(table);
			}
		} else {
			System.out.println("SQL stmt is problem.");
		}
		close();
		return tables;
	}

	public Table getTable(String tableId, String startTime) throws SQLException {

		executedResult = false;
		connect();
		stmtString = "select tableID, startTime, endTime, tableStatus from capstone2020.table where tableID=? and startTime=?";
		preparedStmt = con.prepareStatement(stmtString);
		preparedStmt.setString(1, tableId);
		preparedStmt.setString(2, startTime);
		rs = preparedStmt.executeQuery();
		Table table = new Table();
		if (rs != null) {
			while (rs.next()) {
				table.setTableID(rs.getInt(1));
				table.setStartTime(rs.getString(2));
				table.setEndTime(rs.getString(3));
				table.setTableStatus(rs.getInt(4));
			}
		} else {
			System.out.println("SQL stmt is problem.");
		}
		close();
		return table;
	}

	public Order getOrder(String orderItemId, String timeStamp) throws SQLException {

		executedResult = false;
		connect();
		stmtString = "select o.orderID, o.item_itemID, o.orderItemQty, o.orderStatus, o.table_tableID, o.timeStamp  from capstone2020.order o where orderID=? and timeStamp=?";
		preparedStmt = con.prepareStatement(stmtString);
		preparedStmt.setString(1, orderItemId);
		preparedStmt.setString(2, timeStamp);
		rs = preparedStmt.executeQuery();
		Order order = new Order();
		if (rs != null) {
			while (rs.next()) {
				order.setOrderID(rs.getInt(1));
				order.setOrderItem(rs.getString(2));
				order.setOrderQty(rs.getInt(3));
				order.setOrderStatus(rs.getInt(4));
				order.setTableID(rs.getString(5));
				order.setTimeStamp(rs.getString(6));
			}
		} else {
			System.out.println("SQL stmt is problem.");
		}
		close();
		return order;
	}

	public boolean changeTableStatus(String tableId, String startTime) throws SQLException {
		executedResult = false;
		connect();
		stmtString = "update capstone2020.table set tableStatus=0 where tableID=? and startTime=?";
		preparedStmt = con.prepareStatement(stmtString);
		preparedStmt.setString(1, tableId);
		preparedStmt.setString(2, startTime);

		if (preparedStmt.executeUpdate() == 1) {
			executedResult = true;
		} else {
			System.out.println("update object is incorrect, ");
			return false;
		}
		con.close();
		return true;
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean changeOrderStatus(String orderItemId, String timeStamp, String startTime) throws SQLException {
		executedResult = false;
		Order order = getOrder(orderItemId, timeStamp);
		connect();

		stmtString = "update capstone2020.order set orderStatus=? where orderID=? and table_tableID=? "
				+ "and table_startTime=? and timeStamp=?";
		preparedStmt = con.prepareStatement(stmtString);

		if (order.getOrderStatus() == 1) {
			preparedStmt.setInt(1, 0);
		} else {
			preparedStmt.setInt(1, 1);
		}
		preparedStmt.setInt(2, order.getOrderID());
		preparedStmt.setString(3, order.getTableID());
		preparedStmt.setString(4, startTime);
		preparedStmt.setString(5, timeStamp);
		if (preparedStmt.executeUpdate() == 1) {
			executedResult = true;
			orders = getOrderAll(order.getTableID(), startTime);
		} else {
			System.out.println("update object is incorrect, ");
			return false;
		}
		con.close();
		return true;
	}

	public boolean closeSession(String tableId) throws SQLException {
		executedResult = false;
		connect();
		stmtString = "update capstone2020.table " + "set tableStatus=? and endTime=now() where tableID= ?";
		preparedStmt = con.prepareStatement(stmtString);
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, tableId);
		if (preparedStmt.executeUpdate() == 1) {
			executedResult = true;
		}
		preparedStmt.close();
		con.close();
		return executedResult;
	}

	public void close() throws SQLException {
		if (rs.isClosed())
			rs.close();
		if (!preparedStmt.isClosed())
			preparedStmt.close();
		if (!con.isClosed())
			con.close();
	}

	public Connection connect() throws SQLException {
		if (con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}

	public boolean isExisting(String table, int id) throws SQLException {
		connect();
		executedResult = false;
		switch (table.toLowerCase()) {
		case "item":
			stmtString = "select count(*) from item where itemID = " + id;
			break;
		case "category":
			stmtString = "select count(*) from category where categoryID = " + id;
			break;
		case "order":
			stmtString = "select count(*) from capstone2020.order where orderID = " + id;
			break;
		default:
			break;
		}
		preparedStmt = con.prepareStatement(stmtString);
		// rs = preparedStmt.executeQuery(stmtString);
		// rs.next();
		// System.out.println(rs.getInt("count(*)") );
		if (preparedStmt.execute()) {
			executedResult = true;
		}
		preparedStmt.close();
		con.close();
		return executedResult;
	}
}
