/**
 * 
 */
package model;

import java.sql.Date;
import java.util.List;

import com.mysql.cj.xdevapi.Table;

/**
 * @author 730693
 *
 */
public class Order {
	//Attributes
	private int orderID;
	private Date orderDate;
	private Table table;
	//private double orderAmount;
	private List<OrderedItem>orderedItems;
	
	public Order(Date orderDate, Table table, List<OrderedItem> orderedItems) {
		this.orderDate = orderDate;
		this.table = table;
		this.orderedItems = orderedItems;
	}
	
	public void Order() {
		
	}

	/**
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * @return the orderedItems
	 */
	public List<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	/**
	 * @param orderedItems the orderedItems to set
	 */
	public void setOrderedItems(List<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ", table=" + table + ", orderedItems="
				+ orderedItems + "]";
	}

	

	
}
