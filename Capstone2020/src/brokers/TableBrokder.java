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
public class TableBrokder {

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
	public List<Order> getOrderAll(int tableID) throws SQLException {
		executedResult = false;
		connect();
		stmtString = "select t.tableID, o.timestamp, o.orderID, o.orderItem, orderQty, orderPrice,orderStatus "
				+ "from capstone2020.table t, capstone2020.order o " + "where t.tableID=o.tableID and o.tableID="
				+ tableID + " order by o.timestamp desc";
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		if (rs != null) {
			orders = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order();
				order.setTableID(rs.getInt(1));
				order.setTimeStamp(rs.getString(2));
				order.setOrderID(rs.getInt(3));
				order.setOrderItem(rs.getString(4));
				order.setOrderQty(rs.getInt(5));
				order.setOrderPrice(rs.getDouble(6));
				order.setOrderStatus(rs.getInt(7));
				orders.add(order);
				System.out.println(order.toString());
			}
		} else {
			System.out.println("SQL stmt is problem.");
		}
		close();
		return orders;
	}

	// select * from capstone2020.table;
	public List<Table> getTableAll() throws SQLException {
		executedResult = false;
		connect();
		stmtString = "select tableID, timestamp, tableStatus from capstone2020.table";
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		if (rs != null) {
			tables = new ArrayList<Table>();
			while (rs.next()) {
				Table table = new Table();
				table.setTableID(rs.getInt(1));
				table.setTimeStamp(rs.getString(2));
				table.setTableStatus(rs.getInt(3));
				tables.add(table);
				System.out.println(tables.toString());
			}
		} else {
			System.out.println("SQL stmt is problem.");
		}
		close();
		return tables;
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Order> updateOrderStatus(Order order, int change) throws SQLException {
		executedResult = false;
		orders = new ArrayList<Order>();

		if (order != null && isExisting("order", order.getOrderID())) {
			connect();
			stmtString = "update capstone2020.order " + "set orderStatus=? where orderID= ?";
			preparedStmt = con.prepareStatement(stmtString);
			preparedStmt.setInt(1, change);
			preparedStmt.setInt(2, order.getOrderID());
			if (preparedStmt.executeUpdate() == 1)
				executedResult = true;
			orders = getOrderAll(order.getTableID());
		} else {
			System.out.println("update object is incorrect, " + order.toString());
		}
		close();
		return orders;
	}

	public boolean closeSession(Table table) throws SQLException {
		executedResult = false;
		if (table != null && isExisting("table", table.getTableID())) {
			connect();
			stmtString = "update capstone2020.table " + "set tableStatus=? where tableID= ?";
			preparedStmt = con.prepareStatement(stmtString);
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, table.getTableID());
			if (preparedStmt.executeUpdate() == 1)
				executedResult = true;
		} else {
			System.out.println("update object is incorrect, " + table.toString());
		}
		// close();
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
		// System.out.println("table: "+table+ ", id= "+ id);
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
