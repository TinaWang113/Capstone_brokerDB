/**
 * 
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

import model.Table;

/**
 * @author 730693
 *
 */
public class Order {
	//Attributes
	// if orderID is 0, the DB will auto increment;
	//otherwise, following the value that is assigned to tabelID 
	private int orderID;
	//auto create now() in DB, if timeStamp' value is null
	private Timestamp timeStamp = null;	
	private int orderItemQty =0 ;
	private double orderAmount = 0.0;
	//orderStatus default is 0
	private int orderStatus = 0;
	private Table table =null;
	private Item orderItem =null;
	
	
	/**
	 * @param orderID
	 * @param timeStamp
	 * @param orderItemQty
	 * @param orderAmount
	 * @param orderStatus
	 * @param table
	 * @param orderItem
	 */
	public Order(int orderID, Timestamp timeStamp, int orderItemQty, int orderStatus, Table table,
			Item orderItem) {
		super();
		setOrderID(orderID);
		setTimeStamp(timeStamp);
		setOrderItemQty(orderItemQty);		
		setOrderStatus(orderStatus);
		setTable(table);
		setOrderItem(orderItem);
		setOrderAmount(calOrderAmount());
	}
	
	/**
	 * @param orderID
	 * @param timeStamp
	 * @param orderItemQty
	 * @param orderAmount
	 * @param orderStatus
	 * @param table
	 * @param orderItem
	 */
	public Order(int orderItemQty, Table table, Item orderItem) {
		super();
		setOrderID(0);
		setTimeStamp(null);
		setOrderItemQty(orderItemQty);		
		setOrderStatus(0);
		setTable(table);
		setOrderItem(orderItem);
		setOrderAmount(calOrderAmount());
		
	}
	
	public Order(int orderID, Timestamp timeStamp) {
		
		setOrderID(orderID);
		setTimeStamp(timeStamp);
		setOrderItemQty(0);		
		setOrderStatus(0);
		setTable(null);
		setOrderItem(null);
		setOrderAmount(calOrderAmount());
	}
	
	
	public Order() {
		
	}
	
	
	/**calOrderAmount
	 * 
	 * @return double
	 */
	public double calOrderAmount() {
		if(getOrderItemQty() > 0 && orderItem !=null) {
			return getOrderAmount() * orderItem.getItemPrice();
		}
		System.out.println("No any ordered item");
		return 0.00;
		
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
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the orderItemQty
	 */
	public int getOrderItemQty() {
		return orderItemQty;
	}
	/**
	 * @param orderItemQty the orderItemQty to set
	 */
	public void setOrderItemQty(int orderItemQty) {
		this.orderItemQty = orderItemQty;
	}
	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	/**
	 * @return the orderStatus
	 */
	public int getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
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
	 * @return the orderItem
	 */
	public Item getOrderItem() {
		return orderItem;
	}
	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(Item orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", timeStamp=" + timeStamp + ", orderItemQty=" + orderItemQty
				+ ", orderAmount=" + orderAmount + ", orderStatus=" + orderStatus + ", table=" + table.toString() + ", orderItem="
				+ orderItem.toString() + "]";
	}

	
	

	
}
